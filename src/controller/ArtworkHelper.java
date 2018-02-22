package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Artwork;

public class ArtworkHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GalleryBarber");
	public void insertArtwork(Artwork toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Artwork> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Artwork> allResults = em.createQuery("select a from Artwork a", Artwork.class);
		List<Artwork> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	public void deleteArtwork(Artwork toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artwork> typedQuery = em.createQuery("select ah from Artwork ah where ah.title = :selectedTitle and ah.artistName = :selectedArtistName ",Artwork.class);
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedArtistName", toDelete.getArtistName());
		typedQuery.setMaxResults(1);
		Artwork result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/*public List<Artwork> searchForItemByTitle(String title) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artwork> typedQuery = em.createQuery("select ah from Artwork ah where ah.title = :selectedTitle",Artwork.class);
		typedQuery.setParameter("selectedTitle", title);
		List<Artwork> result = typedQuery.getResultList();
		em.close();
		return result;
	}*/

	public Artwork searchForArtworkById(int idToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Artwork foundArtwork = em.find(Artwork.class, idToDelete);
		em.close();
		return foundArtwork;
	}

	public void updateArtwork(Artwork toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
				
	}
/*
	public List<ListItem> searchForItemByStore(String storeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore",ListItem.class);
		typedQuery.setParameter("selectedStore", storeName);
		List<ListItem> result = typedQuery.getResultList();
		em.close();
		return result;
	}

	public List<ListItem> searchForItemByItemName(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedItem",ListItem.class);
		typedQuery.setParameter("selectedItem", itemName);
		List<ListItem> result = typedQuery.getResultList();
		em.close();
		return result;
	}
*/
}


