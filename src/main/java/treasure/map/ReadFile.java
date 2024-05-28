package treasure.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	
	public static List<String> instruction(String path) throws IOException{
		
		List<String> instruction = new ArrayList<>();
		
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine()) != null) {
				line.trim();
				line.replace(" ", "");
				if(line.startsWith("#")) {
					continue;
				}
				instruction.add(line);
				
			}
		
		return instruction;
		
	}

}
