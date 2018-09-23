import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Driver {
	
	public static boolean alphaSorted(ArrayList<String> arr) {
//		loop through array
		for(int i = 0; i < arr.size() - 1; i++) {
//			compare an element to the next element
			if(arr.get(i).compareTo(arr.get(i+1)) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int checkHash(String[] arr, int count) {
		int hash = 0;
		
		for(int i = 0; i < count; i++) {
			hash = hash ^ arr[i].hashCode();
		}
		
		return hash;
	}
	
	static void insertionSort(String f) throws IOException, URISyntaxException {
//		get file, read file, and store the text into an array
		
		URL url = ClassLoader.getSystemResource(f);

		
		File file = new File(url.toURI()); 
	    Scanner sc = new Scanner(file); 
	    			  
//	    insert all words into an ArrayList (arrList)
	    ArrayList<String> arrList = new ArrayList<String>();
	    while (sc.hasNext()) {
	    	arrList.add(sc.next());
	    }
	    
//	    check if arrList is alphaSorted
	    System.out.println("arrList is sorted: " + alphaSorted(arrList));
	    
//	   convert arrList to a regular array
	    String[] arr = arrList.toArray(new String[0]);
	    	    
//	    close scanner
	    sc.close();
	    
//	    insertionSort
	    for(int j = 1; j < arr.length; j++) {
    	String key = arr[j];
    	int i = j - 1;
    	while (i >= 0 && key.compareTo(arr[i]) > 0) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = key;
    }
//	    reverse arr
	    Collections.reverse(Arrays.asList(arr));
//	    print out
	    for(int i = 0; i < arr.length; i++) {
	    	System.out.println(arr[i]);
	    }
	    
	    ArrayList<String> finalArrList = new ArrayList<String>(Arrays.asList(arr));
//	    check if finalArrList is alphaSorted
	    System.out.println("arrList is sorted: " + alphaSorted(finalArrList));


	}
	
	public static void mergeSort() {
		
	}


	public static void main(String[] args) throws IOException, URISyntaxException {
		
		File file = new File("/Users/raulsanchez/Desktop/COMP 2370/Program2/src/istest3.txt");
		Scanner sc = new Scanner(file);
		
		ArrayList<String> arr = new ArrayList<String>();
	    while (sc.hasNext()) {
	    	arr.add(sc.next());
	    }
	    
	    sc.close();
	    
	    insertionSort(args[0]);
	    


	    

	    sc.close();

	}
}
