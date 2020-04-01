import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

	
	public static void main(String[] args) throws Exception {
		
		Path path = Paths.get("problem1.txt");

		String dataFile = path.toUri().getPath();
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		duplicateRemover.remove(dataFile);
		String outputFile = "";
		outputFile = Paths.get(outputFile, dataFile).getParent().toString();
		System.out.println(outputFile);
		duplicateRemover.write(outputFile);

		
		
		// The main method shall create an instance of a DuplicateRemover 
		// called duplicateRemover
		
		// The main method shall use the write method of duplicateRemover 
		// to output the unique words of "problem1.txt" to a file called "unique_words.txt"
		
		
			
		
	}
	
}
