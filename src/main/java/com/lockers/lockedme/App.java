package com.lockers.lockedme;

import java.io.File;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		// Create project directory called LockedMe in user's root directory if does not
		// already exists
		File projectDir = new File(System.getProperty("user.home") + "\\LockedMe");

		if (!projectDir.exists()) {
			projectDir.mkdir();
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n"
				.concat("Welcome to LockedMe.com app \n")
				.concat("Developed by Cleopas T. Wangayi \n")
				.concat("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"));

		boolean exit = false;

		Scanner input = new Scanner(System.in);

		while (!exit) {
			try {
				String menuOptions = "Please choose an option below \n"
						.concat("1. Retrieve all the current files in your directory \n")
						.concat("2. Business level operations \n")
						.concat("3. Close the application \n");

				System.out.println(menuOptions);

				switch (Integer.parseInt(input.nextLine())) {
					case 1:
						System.out.println(FileManagementService.allProjectFiles());
						break;
					case 2:
						perfomBusinessOperations();
						break;
					case 3:
						exit = true;
						break;
					default:
						System.out.println("Oops, looks like you entered an invalid option");
						break;
				}
			} catch (Exception e) {
				System.out.println("Sorry something went wrong");
			}
		}
		input.close();
	}

	public static void perfomBusinessOperations() {
		boolean exit = false;
		Scanner input = new Scanner(System.in);

		while (!exit) {
			try {
				String menuOptions = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n"
						.concat("Please choose an option below \n")
						.concat("1. Add a file to the existing directory list \n")
						.concat("2. Delete a file from the existing directory list \n")
						.concat("3. Search for a file from the main directory \n")
						.concat("4. Return to main menu");

				System.out.println(menuOptions);
				switch (Integer.parseInt(input.nextLine())) {
					case 1:
						System.out.println("Please enter the name of file you want to create");
						FileManagementService.addFile(input.nextLine());
						break;
					case 2:
						System.out.println("Please enter the name of file you want to delete");
						FileManagementService.deleteFile(input.nextLine());
						break;
					case 3:
						System.out.println("Please enter the name of file you want to search for");
						FileManagementService.searchFile(input.nextLine());
						break;
					case 4:
						exit = true;
						break;
					default:
						System.out.println("Oops, looks like you entered an invalid option");
						break;
				}

			} catch (Exception e) {
				System.out.println("Something went wrong");
			}
		}
	}
}
