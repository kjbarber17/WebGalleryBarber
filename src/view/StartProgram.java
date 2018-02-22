package view;

import java.util.List;
import java.util.Scanner;

import controller.ArtworkHelper;
import model.Artwork;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ArtworkHelper ah = new ArtworkHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a title: ");
		String title = in.nextLine();
		System.out.print("Enter an artist name: ");
		String artistName = in.nextLine();
		System.out.print("Enter artwork media: ");
		String media = in.nextLine();
		System.out.print("Enter year of artwork: ");
		String year = in.nextLine();
		System.out.print("Enter artwork value: ");
		double value = in.nextDouble();

		Artwork toAdd = new Artwork(0, title, artistName, media, year, value);
		ah.insertArtwork(toAdd);
		
	}

	private static void deleteArtwork() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title to delete: ");
		String title = in.nextLine();
		System.out.print("Enter the artist name to delete: ");
		String artistName = in.nextLine();

		Artwork toDelete = new Artwork(title, artistName);
		ah.deleteItem(toDelete);

	}

	/*private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Title");
		System.out.println("2 : Search by Artist Name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Artwork> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the title of the artwork: ");
			String title = in.nextLine();
			foundItems = ah.searchForItemByTitle(title);
		} else {
			System.out.print("Enter the Artist Name: ");
			String artistName = in.nextLine();
			foundItems = ah.searchForItemByTitle(artistName);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Artwork a : foundItems) {
				System.out.println(a.getId() + " : " + a.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Artwork toEdit = ah.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getMedia() + " from " + toEdit.getValue());
			System.out.println("1 : Update Media");
			System.out.println("2 : Update Value");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Media: ");
				String newMedia = in.nextLine();
				toEdit.setMedia(newMedia);
			} else if (update == 2) {
				System.out.print("New Value: ");
				double newValue = in.nextDouble();
				toEdit.setValue(newValue);
			}

			ah.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our art gallery! ---");
		while (goAgain) {
			System.out.println("*  Select artwork from gallery:");
			System.out.println("*  1 -- Add pieces of artwork");
			//System.out.println("*  2 -- Edit an item");
			System.out.println("*  2 -- Delete pieces of artwork");
			System.out.println("*  3 -- View the list of artwork");
			System.out.println("*  4 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
				//} else if (selection == 2) {
				//editAnItem();
			} else if (selection == 2) {
				viewGallery();
				deleteArtwork();
			} else if (selection == 3) {
				viewGallery();
			} else {
				//ah.cleanUp();
				System.out.println("   Thank you for visiting our art gallery!   ");
				goAgain = false;
			}

		}

	}

	private static void viewGallery() {
		// TODO Auto-generated method stub
		List<Artwork> allItems = ah.showAllItems();
		for(Artwork a: allItems) {
			System.out.println(a.returnArtworkDetails());
		}

	}

}


