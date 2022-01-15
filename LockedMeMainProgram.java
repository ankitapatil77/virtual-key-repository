package com.lockedMe.prooject;

public class LockedMeMainProgram {

	public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
		FileOperations.createMainFolderIfNotExist("main");
		
		FileMenuOption.printWelcomeScreen("LockedMe.com", "Ankita Patil");
		
		FileHandleOption.handleWelcomeScreenInput();
	}

	
}



