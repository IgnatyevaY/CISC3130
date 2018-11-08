/******************************************************************************
 *  Compilation:  javac Assignment1.java
 *  Execution:    java Assignment1 < input.txt
 *
 *  Reads in a text file and for each line verifies whether the word has
 *  unique characters.
 *
 *  % cat input.txt
 *  Hello
 *  World
 *
 *  % java Assignment1 < input.txt
 *  False
 *  True
 *
 ******************************************************************************/
import java.io.File;
import java.util.*;

public class Assignment1 {
	
	   private static boolean isUniqueChar(String s){
	        s.toLowerCase(); //converts all characters into lower case
	    	char[] c = s.toCharArray(); //lists every letter as a Char in an array
	        for(int i = 0; i < c.length; i++) { //compares index i to the whole list
	        	int count = 0;
	        	for(int j = 0; j < c.length; j++) {
	        		if (c[i]==c[j]) {
	        			count++;
	        		}
	        		
	        		if (count>1) { //if the char repeats, prints false
	        	        System.out.println(false);
	        	        return false;
	        		}
	        	}
	        }
	        System.out.println(true);
	        return true;
	   }

	    

	    private static String sortWord(String s){
	        String b = s.toLowerCase(); //converts all the characters into lower case
	    	char[] c = b.toCharArray(); //lists every letter as a character into a array
	        insertionSort(c);
	        b = new String(c); //takes all the characters and combines it into a string
	        System.out.println(b);
	        return b;
	    }

	    public static void insertionSort(char[] word) {
	        if (word == null || word.length == 0)
	            return;
	        for (int i=0; i<word.length; i++) {
	            char temp = word[i];
	            int j = i;
	            while (j>0 && word[j-1]>temp) {
	                word[j] = word[j-1];
	                j--;
	            }
	            word[j] = temp;
	        }
	        return;
	    }

	    public static void main(String[] args) throws Exception{
	        Scanner scanner = new Scanner(new File("input.txt")); 
	        while (scanner.hasNextLine()) {    // read in words and determine whether it is composed of unique characters
	            String s = scanner.nextLine();
	            isUniqueChar(s);
	            sortWord(s);
	        }

	      scanner.close();
	    }
	}