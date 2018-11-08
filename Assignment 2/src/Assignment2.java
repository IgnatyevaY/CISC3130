//Yekaterina Ignatyeva
//Assignment 2: Exploring the functions of a LinkedList
//Each test's objective is displayed within the output
import java.util.*;

public class Assignment2 {
	//An easy method to display all (and any) elements in the LinkedList (Wasn't able to get displayList to work, so I just made one of my own)
	public static void displayList(LinkedList test) {
		for(int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i) + " ");
		}
	}
	
	//Checks to see if list is sorted
	public static boolean isSorted(LinkedList<Integer> test) {
		for(int i = 0; i < test.size()-1; i++) {
			if (test.get(i) > test.get(i+1))
				return false;
		}
		return true;
	}
	
	//Removes any duplicates in the LinkedList
	public static LinkedList<Integer> duplicate(LinkedList<Integer> test) {
		for (int current = 0; current < test.size(); current++ ) {
			for (int runner = current+1; runner < test.size(); runner++ ) {  
				if (test.get(current) == test.get(runner))
					test.remove(runner);
			}
		}
		return test;
	}
	//assuming the lists are sorted, it combines two lists into one
	public static LinkedList<Integer> sortMerge(LinkedList<Integer> first, LinkedList<Integer> second) {
		LinkedList<Integer> merge = new LinkedList<Integer>();
			while(!(first.isEmpty()) || !(second.isEmpty())) {
				 if(first.isEmpty() && !(second.isEmpty())){
				 	merge.addAll(second);
				 	break;
				 	}else if(!(first.isEmpty()) && second.isEmpty()){
				 	merge.addAll(first);
				 	break;
			}else if(first.getFirst() < second.getFirst()) {
					merge.add(first.getFirst());
					first.removeFirst();//after adding on the digit to the new list, it permanently removes it from its original
				}else {
					merge.add(second.getFirst());
					second.removeFirst();//after adding on the digit to the new list, it permanently removes it from its original
				}	
			}
		
		return merge;
	}
	
	//Searches for each instance where a digit from one LinkedList matches the other's at the same index
	public static void intersect(LinkedList<Integer> first, LinkedList<Integer> second) {
		String inter = ""; 
		if(first.size() < second.size()) { //To avoid OutofBounds errors, it uses the size of the smallest list
			for(int i = 0; i < first.size(); i++) {
				if(first.get(i) == second.get(i)) 
					inter+="digit:" + first.get(i) + " index: " + i + "\n";
			}
		}else if(second.size() < first.size()) {
			for(int i = 0; i < second.size(); i++) {
				if(first.get(i) == second.get(i))
					inter+="digit:" + first.get(i) + " index: " + i + "\n";
			}
		}else { //situations like if they're equal to each other
			for(int i = 0; i < first.size(); i++) {
				if(first.get(i) == second.get(i))
					inter+="digit:" + first.get(i) + " index: " + i + "\n";
			}
		}
		
		if(inter.equals(""))
			System.out.println("There were no interesecting indexes");
		else
			System.out.println("The intersecting numbers were:\n" + inter);
	}
	
	//Starting at the first and last index, the method checks each element up to the center for whether they match. If they do all the way to the end, then the method returns true. Otherwise it returns false.
	public static boolean palindrome (LinkedList test) {
		int rest=test.size()-1;
		for(int i = 0; i < test.size()/2; i++) {
			if (!(test.get(i).equals(test.get(rest))))
				return false;
			rest--;
		}
		return true;
	}
	
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Test1: Removing Duplicates"); //Separation to make it easier on the eye
		LinkedList<Integer> trial = new LinkedList<Integer>();
		trial.add(7);
		trial.add(7);
		trial.add(5);
		trial.add(3);
		trial.add(2);
		trial.add(5);
		System.out.println("Original");
		displayList(trial);
		duplicate(trial);
		System.out.println("\nResult");
		displayList(trial);
		LinkedList<Integer> trial2 = new LinkedList<Integer>();
		trial2.add(4);
		trial2.add(23);
		trial2.add(2);
		trial2.add(5);
		trial2.add(1);
		trial2.add(4);
		System.out.println("\nOriginal");
		displayList(trial2);
		duplicate(trial2);
		System.out.println("\nResult");
		displayList(trial2);
		System.out.println("\n_________________________________________");
		
		System.out.println("\nTest2: Merging Two Sorted LinkedLists"); //Separation to make it easier on the eye
		trial2.sort(null);//Testing the sort method
		System.out.println("List 1");
		displayList(trial);
		System.out.println("\nList 2");
		displayList(trial2);
		LinkedList<Integer> trial3 = null;
		//checks to see if both lists are sorted, otherwise it prompts whether you'd like to have them sorted for the proper result 
		if (isSorted(trial) && isSorted(trial2)) { 
			trial3 = sortMerge(trial, trial2);
		}else{
			System.out.println("\nOne of the lists aren't sorted. Would you like to sort? (Y/N)");
			String confirm = scan.nextLine();
			if (confirm.equals("Y") || confirm.equals("y")) {
				trial.sort(null); 
				trial2.sort(null);
				trial3=sortMerge(trial, trial2);
			}
		}
		System.out.println("Final Results");
		if(trial3!=null)
			displayList(trial3);
		else
			System.out.println("Null");
		System.out.println("\n_________________________________________");
		
		System.out.println("\nTest3: Finding Intersections"); //Separation to make it easier on the eye
		LinkedList<Integer> trial4 = new LinkedList<Integer>();
		trial4.add(1);
		trial4.add(1);
		trial4.add(5);
		trial4.add(8);
		trial4.add(20);
		trial4.add(10);
		
		LinkedList<Integer> trial5 = new LinkedList<Integer>();
		trial5.add(7);
		trial5.add(1);
		trial5.add(5);
		trial5.add(9);
		trial5.add(20);
		trial5.add(3);
		
		intersect(trial4, trial5);
		System.out.println("_________________________________________");
		
		System.out.println("\nTest4: Palindromes?");
		LinkedList<Integer> trial6 = new LinkedList<Integer>();
		trial6.add(7);
		trial6.add(1);
		trial6.add(22);
		trial6.add(4);
		trial6.add(20);
		trial6.add(11);
		System.out.println("\nExample");
		displayList(trial6);
		System.out.println("\nResult");
		System.out.println(palindrome(trial6));
		
		LinkedList<Integer> trial7 = new LinkedList<Integer>();
		trial7.add(2);
		trial7.add(1);
		trial7.add(0);
		trial7.add(1);
		trial7.add(2);
		System.out.println("\nExample");
		displayList(trial7);
		System.out.println("\nResult");
		System.out.println(palindrome(trial7));
		
		LinkedList<Character> trial8 = new LinkedList<Character>();
		trial8.add('r');
		trial8.add('o');
		trial8.add('t');
		trial8.add('o');
		trial8.add('r');
		System.out.println("\nExample");
		displayList(trial8);
		System.out.println("\nResult");
		System.out.println(palindrome(trial8));
		
		scan.close();
	}
}
