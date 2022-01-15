# virtual-key-repository
#  virtual-key-repository

# Background of the problem statement:

               Company Lockers Pvt. Ltd. hired you as a Full Stack Developer. They aim to digitize their products and chose LockedMe.com as their first project to start with. You’re asked to develop a prototype of the application. The prototype of the application will be then presented to the relevant stakeholders for budget approval. Your manager has set up a meeting where you’re asked to present the following in the next 15 working days (3 weeks): 

Specification document - Product’s capabilities, appearance, and user interactions

Number and duration of sprints required 

Setting up Git and GitHub account to store and track your enhancements of the prototype 

Java concepts being used in the project 

Data Structures where sorting and searching techniques are used. 

Generic features and operations available: 

  1)  Retrieving the file names in an ascending order

  2)  Business-level operations:

          -- Option to add a user-specified file to the application

          -- Option to delete a user-specified file from the application

          -- Option to search a user-specified file from the application

          -- Navigation option to close the current execution context and return to the main context

  3)  Option to close the application



Project objective: 
       Java Console based program allows users to input menu options for:
             1) Displaying File/Folder structure.
             2) Search for File/Folder recursively.
             3) Add/Delete File/Folder recursively.

# Component Hierarchy:

     File	                                                                      Description
LockedMeMainProgram.java	                          This program contains the Main method. It's the entry point of the program.
FileMenuOption.java	                                This program contains methods for displaying menu options.
FileHandleOption.java	                              This program contains methods for handling different options from user input and calls respective methods from 
FileOperation.java	                                This program defines all the operations required for displaying, searching, deleting, and adding files/folder.




To track below deliverables -
Specification document - Product's capabilities, appearance, and user interactions

Java concepts being used in the project 

Data Structures where sorting and searching techniques are used. 



# Code to display the welcome screen. It should display:

Application name and the developer details 

The details of the user interface such as options displaying the user interaction information 

Features to accept the user input to select one of the options listed 

The first option should return the current file names in ascending order. The root directory can be either empty or contain few files or folders in it

 The second option should return the details of the user interface such as options displaying the following:

Add a file to the existing directory list

You can ignore the case sensitivity of the file names 

Delete a user-specified file from the existing directory list

You can add the case sensitivity on the file name in order to ensure that the right file is deleted from the directory list

Return a message if FNF (File not found)

Search a user-specified file from the main directory

You can add the case sensitivity on the file name to retrieve the correct file

Display the result upon the successful operation

Display the result upon unsuccessful operation

Option to navigate back to the main context

There should be a third option to close the application

Implemented the concepts such as exceptions, collections, and sorting techniques for source code optimization and increased performance
