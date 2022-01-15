package com.lockedMe.prooject;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileOperations {

	public static void createMainFolderIfNotExist(String folderName) {
		File theFile = new File("/Users/Ankita/eclipse-workspace/Virtual key repository project");

		
	}

	public static void displayAllFiles(String path) {
		FileOperations.createMainFolderIfNotExist("main");
		// All required files and folders inside "main" folder relative to current
		
		System.out.println("Displaying all files with directory in ascending order\n");

		// listFilesInDirectory displays files along with folder structure
		List<String> ListFilesNames = FileOperations.FilesListInDirectory(path, 0, new ArrayList<String>());

		System.out.println("Displaying all files in ascending order\n");
		Collections.sort(ListFilesNames);

		ListFilesNames.stream().forEach(System.out::println);
	}

	public static List<String> FilesListInDirectory(String path, int inisalisationCount, List<String> fileNames) {
		File dir = new File(path);
		File[] theFiles = dir.listFiles();
		List<File> filesList = Arrays.asList(theFiles);

		Collections.sort(filesList);

		if (theFiles != null && theFiles.length > 0) {
			for (File thefiles : filesList) {

				System.out.print(" ".repeat(inisalisationCount * 2));

				if (thefiles.isDirectory()) {
					System.out.println("`-- " + thefiles.getName());

					// Recursively indent and display the files
					fileNames.add(thefiles.getName());
					FilesListInDirectory(thefiles.getAbsolutePath(), inisalisationCount + 1, fileNames);
				} else {
					System.out.println("|-- " + thefiles.getName());
					fileNames.add(thefiles.getName());
				}
			}
		} else {
			System.out.print(" ".repeat(inisalisationCount * 2));
			System.out.println("|-- Empty Directory");
		}
		System.out.println();
		return fileNames;
	}

	public static void createFiles(String Addfile, Scanner scan) {
		FileOperations.createMainFolderIfNotExist("main");
		Path FilePath = Paths.get("./main/" + Addfile);
		try {
			Files.createDirectories(FilePath.getParent());
			Files.createFile(FilePath);
			System.out.println(Addfile + " File created successfully.....");

			System.out.println("Would you like to add some content/message to the file? (yes/no)");
			String choice = scan.next();

			
			
			if (choice.equals("yes")) {
				System.out.println("\n\n Insert content and press enter:  \n");
				String content=scan.next();
				Files.write(FilePath, content.getBytes());
				System.out.println("\n Content written to file " + content);
				
				System.out.println("Content can be read using Notepad or Notepad++ or wordpad or MS Word...");
			}
			
		} catch (IOException e) {
			System.out.println("Failed to create file " + Addfile);
			System.out.println(e.getClass().getName());
		}
	}

	public static List<String> displayFileLocations(String fileName, String path) {
		List<String> fileListNames = new ArrayList<>();
		FileOperations.searchFileRepetitive(path, fileName, fileListNames);

		if (fileListNames.isEmpty()) {
			System.out.println("\n Couldn't find any file with given file name \"" + fileName + "\n");
		} else {
			System.out.println("\n Found file at below location(s):");

			List<String> files = IntStream.range(0, fileListNames.size())
					.mapToObj(index -> (index + 1) + ": " + fileListNames.get(index)).collect(Collectors.toList());

			files.forEach(System.out::println);
		}

		return fileListNames;
	}

	public static void searchFileRepetitive(String path, String fileName, List<String> fileListNames) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().startsWith(fileName)) {
					fileListNames.add(file.getAbsolutePath());
				}

				// Need to search in directories separately to ensure all files of required
				// fileName are searched
				if (file.isDirectory()) {
					searchFileRepetitive(path, fileName, fileListNames);
				}
			}
		}
	}

	public static void deleteFileRepitatively(String path) {

		File currentFile = new File(path);
		File[] thefiles = currentFile.listFiles();

		if (thefiles != null && thefiles.length > 0) {
			for (File file : thefiles) {

				String fileName = file.getName() + " at " + file.getParent();
				if (file.isDirectory()) {
					deleteFileRepitatively(path);
				}

				if (file.delete()) {
					System.out.println(fileName + " file deleted successfully");
				} else {
					System.out.println("Failed to delete file" + fileName);
				}
			}
		}

		String currentFileName = currentFile.getName() + " at " + currentFile.getParent();
		if (currentFile.delete()) {
			System.out.println(currentFileName + " file deleted successfully");
		} else {
			System.out.println("Failed to delete file " + currentFileName);
		}
	}
}

