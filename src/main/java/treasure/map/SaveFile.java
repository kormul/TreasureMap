package treasure.map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveFile {
	
	public static void saveFile(String dataToSave) throws IOException {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		String fileName = "Resultat - " + date.format(LocalDateTime.now()) + ".txt";
		File file = new File(fileName);
		file.createNewFile();
		FileWriter myWriter = new FileWriter(fileName);
		myWriter.write(dataToSave);
		myWriter.close();
		
	     
	}

}
