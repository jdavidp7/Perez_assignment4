import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	Scanner scanner;
	ArrayList<String> words;
	Map <String, Integer> wordCounter;
	public void count(String dataFile) {
		words = new ArrayList<String>();
		try {
			File file = new File (dataFile);
			
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				words.add(scanner.nextLine());
			}
			wordCounter = new HashMap<String, Integer>();
			
			for (String uniqueWord: words) {
				Integer Count = wordCounter.get(uniqueWord);
				wordCounter.put(uniqueWord, (Count == null) ? 1 : Count + 1);
			}
			
			for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			
		} catch (IOException FileNotFoundException) {
			System.out.println("File not found");
			return;
		}
	}
	public void write(String outputFile) {
		File outFile = new File(outputFile + "/unique_word_counts.txt");
		
		try {
			boolean fileCreated = outFile.createNewFile();
			
			System.out.println(fileCreated);
		} catch (IOException ioe) {
			
		}
		try {
			PrintWriter print = new PrintWriter(outFile);
			print.print(wordCounter);
			print.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanner.close();
	}


}
