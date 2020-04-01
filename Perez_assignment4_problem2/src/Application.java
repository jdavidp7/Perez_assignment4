import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("problem2.txt");

		String dataFile = path.toUri().getPath();
		DuplicateCounter counter = new DuplicateCounter();
		counter.count(dataFile);
		String outputFile = "";
		outputFile = Paths.get(outputFile, dataFile).getParent().toString();
		System.out.println(outputFile);
		counter.write(outputFile);
		System.out.println(dataFile);
					


	}
}
