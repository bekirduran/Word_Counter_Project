
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bekirduran
 */
public class WordsCount {
    
     public static void main(String[] args) throws IOException, InterruptedException  {
        
    //Reading book from file to count words
    fileReader filereader = new fileReader();
    String fileText = filereader.readToText("/Users/bekirduran/Desktop/book_example.txt");
        
    
    //Reading Commonwords from file (Comparing and Dropping this Words)
    ArrayList<String> commonFiletext = new ArrayList<>();
    commonFiletext = filereader.readToArray("/Users/bekirduran/Desktop/commonwords.txt");


      
         
        HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
        Pattern pattern = Pattern.compile("[^a-zA-Z’]");
        String[] splittedWord = pattern.split(fileText.toLowerCase());
        int wordCount = 0;
        
        //Checking and Counting Each Word according to Commonwords.txt
        for(String word : splittedWord) { // Short cut typing for loops
               if( !commonFiletext.contains(word)){  
                   
                   wordCount = 0;
                   
                        for (int i = 0; i <splittedWord.length; i++) {
                            if(splittedWord[i].equals(word)) wordCount++;
                        }
                   // shows wordCount bigger and equal than 3
                    if(wordCount >=3 && !hashMap.containsKey(word) && word.length()>1 ){
                         hashMap.put(word, wordCount);
                        } 
                  }
        }

      
Set set = hashMap.entrySet();
Iterator iterator = set.iterator();

while(iterator.hasNext()) {
    Map.Entry mapEntry = (Map.Entry)iterator.next();
    System.out.print(mapEntry.getKey() + ": "+mapEntry.getValue()+" \n");
    }
}   
    
    
}
