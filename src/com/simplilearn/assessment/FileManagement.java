package com.simplilearn.assessment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileManagement {

	private int end = 0;
	
	public void listFiles() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, enter the directory to be listed: ");
		String dir = scan.next();
		
		File file = new File(dir);
		
		File[] arrayFiles = file.listFiles();
				
		// if statement to display by ascending order
		
		if (end < arrayFiles.length) {
			Arrays.sort(arrayFiles, new Comparator<File>() {
	            
	            public int compare(File o1, File o2) {
	                int n1 = extractNumber(o1.getName());
	                int n2 = extractNumber(o2.getName());
	                return n1 - n2;
	            }

	            private int extractNumber(String name) {
	                int i = 0;
	                try {
	                    int s = name.indexOf('_')+1;
	                    int e = name.lastIndexOf('.');
	                    String number = name.substring(s, e);
	                    i = Integer.parseInt(number);
	                } catch(Exception e) {
	                    i = 0; 
	                }
	                return i;
	            }
	        });

	        for(File f : arrayFiles) {
	            System.out.println(f.getName());
	        } 
		} else {
			System.out.println("Sorry, this directory is empty!");
		}
	}
	
	// Add file method
	public void addFile(String fileName) {
		Scanner s = new Scanner(System.in);
		System.out.println("Insert the directory that you want to add the new file:");
		String dir = s.next();
		File file = new File(dir+"\\"+fileName);
		try {
			file.createNewFile();
			System.out.println("File add with success!");
		} catch (Exception e) {
			System.out.println("The proccess failed.\nMaybe something is wrong with the directory path, file name or file type. Please, try again.");
			e.printStackTrace();
		}
	}
	
	// Delete file method
	public boolean deleteFile(String fileName) {
		Scanner s = new Scanner(System.in);
		System.out.println("Insert the directory that you want to delete the file:");
		String dir = s.next();
		File file = new File(dir+"\\"+fileName);
		if (file.delete()) {
			System.out.println("File deleted with success!");
			return true;
		} else {
			System.out.println("The proccess failed.\nMaybe something is wrong with the directory path, file name or file type. Please, try again.");
			return false;
		}
	}
	
	// Search for a file method
	public boolean searchFile(String fileName) {
		boolean existingFile = false;
		Scanner s = new Scanner(System.in);
		System.out.println("Insert the directory where you want to search for the file:");
		String dir = s.next();
		File file = new File(dir);
		
		File[] listFiles = file.listFiles();
		if (listFiles != null) {
			for (File f : listFiles) {
				if (fileName.equalsIgnoreCase(f.getName())) {
					System.out.println("The file found was: " + fileName);
					existingFile = true;
				}
			}
			if (existingFile == false) {
				System.out.println("The file wasn't found. Maybe you typed the wrong name. Please, try again.");
			}
		}
		return existingFile;
	}
	
}
