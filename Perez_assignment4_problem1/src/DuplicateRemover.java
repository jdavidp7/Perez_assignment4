import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.io.PrintWriter;


public class DuplicateRemover {
	
	ArrayList<String> uniqueWords;
	ArrayList<String> noDuplicate;
	Scanner scanner;
	public static <E extends Comparable<E>> ArrayList<E> duplicate(ArrayList<E> list) {
		
		Boolean found = false;
		if (list.size()== 0)
			return list;
		
		ArrayList<E> newList = new ArrayList<>();
		newList.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			for(int j = 0; j < newList.size(); j++) {
				if (list.get(i).compareTo(newList.get(j)) == 0){
					found = true;
					break;
				}
			}
			if (found != true)
				newList.add(list.get(i));
			found = false;
		}
		return newList;
		
		
		
		// shall determine the unique words contained in dataFIle and 
		// store those unique words in the associated DuplicateRemover object
		
		// The remove method shall terminate the program and alert 
		// the user with a user-friendly message when an exceptional IO event occurs
		
		// The remove method shall clean up any and all resources allocated 
		// during method execution
		
	}
	public void remove (String dataFile) {
		uniqueWords = new ArrayList<>();
		
		try {
		File file = new File (dataFile);
		scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			uniqueWords.add(scanner.nextLine());
			
		}
		noDuplicate = duplicate(uniqueWords);
		System.out.println(noDuplicate);
		} catch (IOException FileNotFoundException) {
			System.out.println("File not found");
			return;
			
		}
		
	}
	
	public void write(String outputFile) {
		
		// Given the path to a text file, the write method shall print 
		// the current collection of unique words to outputFile
		
		File outFile = new File(outputFile + "/unique_words.txt");
		
		try {
			boolean fileCreated = outFile.createNewFile();
			
			System.out.println(fileCreated);
		} catch (IOException ioe) {
			
		}
		try {
			PrintWriter print = new PrintWriter(outFile);
			print.print(noDuplicate);
			print.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanner.close();

		// The write method shall terminate the program and alert the 
		// user with a user-friendly message when an exceptional IO event occurs
		
		// The write method shall clean up any and all resources 
		// allocated during method execution
		
	}
	
}
