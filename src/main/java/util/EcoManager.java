package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EcoManager {
	public static void main(String args[]) {
        String s = null;
        String word = "\"고양이\"";
        String path = "python ./knock.py " + word;
        System.out.println(path);
        
        try {    
        	Process p = Runtime.getRuntime().exec(path);            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            System.out.println("loading");
            
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            System.exit(0);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
