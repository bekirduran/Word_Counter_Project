


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bekirduran
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileReader {
    
     //Reading book from file to count words
    public static String readToText(String filepath) throws FileNotFoundException{
           
    File myObj = new File(filepath);
      Scanner myReader = new Scanner(myObj);
      String fileText = "";
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        fileText +=" "+data;
      }
    myReader.close();
    return fileText;
    }
    
  //Reading Commonwords from file
    public static ArrayList<String> readToArray (String filepath) throws FileNotFoundException, IOException{
            
    BufferedReader bufReader = new BufferedReader(new FileReader(filepath)); 
     ArrayList<String> commonFiletext = new ArrayList<>(); 
     String line = bufReader.readLine(); 
    
      while (line != null) { commonFiletext.add(line); 
      line = bufReader.readLine(); } 
         bufReader.close();
         return commonFiletext;
    }
    

}


