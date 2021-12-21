package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class EcoManager {

	URL location = EcoManager.class.getProtectionDomain().getCodeSource().getLocation();
	
	public String extrude(String content) {
		String result = "재활용";
		String currentPath = location.toString() + "util";
		currentPath = currentPath.replace("file:/", "");
		String pythonPath = "python " + currentPath + "/extrude.py " + '\"' + currentPath + '\"';
		
		System.out.println(currentPath);
		System.out.println(pythonPath);
		
		Document doc = Jsoup.parse(content);
		content = doc.text();
		File file = new File(currentPath + "/temp.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		    writer.write(content);
		    writer.close();
		    
		    Process p = Runtime.getRuntime().exec(pythonPath);            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            while ((result = stdInput.readLine()) != null) {
                System.out.println(result);
            }
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public double calcEcoScore(String word){
        String result = null;
        double score = 0;
        String currentPath = location.toString() + "util";
		currentPath = currentPath.replace("file:/", "");
        String pythonPath = "python " + currentPath + "/knock.py " + '\"' + word + '\"';
        
        try {    
        	Process p = Runtime.getRuntime().exec(pythonPath);            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            while ((result = stdInput.readLine()) != null) {
                System.out.println(result);
                score = Double.parseDouble(result);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }
}
