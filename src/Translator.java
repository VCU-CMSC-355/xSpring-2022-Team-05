import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;




public class Main {
    public static void main (String []args) throws IOException, InterruptedException {

        String language = args[0];
        String word = args[1];
        

        String inputFileName = args[0] + ".txt";
        
        
        Process proc = Runtime.getRuntime().exec("java -jar tb.jar"+ " " + language + " " + inputFileName);
        proc.waitFor();
        
        
     
        
        File inputFile = new File(inputFileName);
        
        
        String[] words = null;
        
      
    
 

        FileReader wordSearcher = new FileReader(inputFileName);  
        //Creation of File Reader object
        BufferedReader br = new BufferedReader(wordSearcher); 
        //Creation of BufferedReader object
        String translationOfWord = "";

        String input = word; 
        
        String s;
        // Input word to be searched
        int count = 0;   
        
        //Intialize the word to zero
        while ((s = br.readLine()) != null)   //Reading Content from the file
        {
            words = s.split(",");  //Split the word using space
            for (String found : words) {
                if (found.equals(input))   //Search for the given word
                {   
                    translationOfWord = words[1];
                    count++;    //If Present increase the count by one
                }
            }
            
        }
        
        //if word is not found 
        if (count == 0){
            word = word + ",805";
            
        Process proc2 = Runtime.getRuntime().exec("java -jar msg.jar "+ word);
        proc2.waitFor();
            
        }
        
        
       //still working on this part 
         Process proc2 = Runtime.getRuntime().exec("java -jar msg.jar " + word);
        proc2.waitFor();
        
        
        
        System.out.println(translationOfWord);
        
        
        //run it on online gdb online. it should work args [0] is the language and args[1] should be the word  so example "german dog"
        
        
    }
}