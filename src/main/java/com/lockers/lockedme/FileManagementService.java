package com.lockers.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManagementService {
    private FileManagementService() {
    }

    private static final String HOMEDIR = System.getProperty("user.home") + "\\LockedMe";

    public static List<String> allProjectFiles() {

        ArrayList<String> projectFilesByName = new ArrayList<>();
        for (File file : new File(HOMEDIR).listFiles()) {
            if (file.isFile()) {
                projectFilesByName.add(file.getName());
            }
        }
        return projectFilesByName;
    }

    /**
     * Method to add a new file to the directory
     * 
     * @param fileName
     */
    public static void addFile(String fileName) {
        File file = new File(HOMEDIR, fileName);

        try {
            if (file.isDirectory()) {
                System.out.println("Sorry we currently only support creating files not directories");
                return;
            }
            if (file.createNewFile()) {
                System.out.println("Successfully created " + file.getName());
            } else {
                System.out.println("File already exists");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchFile(String searchInput) {
        File[] fileList = new File(HOMEDIR).listFiles();
        for (File file : fileList) {
            if (file.isFile() && searchInput.equalsIgnoreCase(file.getName())) {
                System.out.println(file.getName());
            } else {
                System.out.println("File not found");
            }
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(HOMEDIR, fileName);

        try {
            if (!file.exists()) {
                System.out.println("File does not exist");
            }

            if (file.delete()) {
                System.out.println("Successfully deleted " + fileName);
            }
        } catch (Exception e) {
            System.err.println("Something went terribly wrong");
        }
    }

}
