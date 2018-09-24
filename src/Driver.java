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
	
	public static int checkHash(ArrayList<String> arrList, int count) {
		int hash = 0;
		
		for(int i = 0; i < count; i++) {
			hash = hash ^ arrList.get(i).hashCode();
		}
		
		return hash;
	}
	
	public static void insertionSort(String f) throws IOException, URISyntaxException {
//		get file, read file, and store the text into an array
		URL url = ClassLoader.getSystemResource(f);

		
		File file = new File(url.toURI()); 
	    Scanner sc = new Scanner(file); 
	    			  
//	    insert all words into an ArrayList (arrList)
	    ArrayList<String> arrList = new ArrayList<String>();
	    while (sc.hasNext()) {
	    	arrList.add(sc.next());
	    }
	    
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
//	    reverse arr and covert back to ArrayList
	    Collections.reverse(Arrays.asList(arr));
	    ArrayList<String> finalArrList = new ArrayList<String>(Arrays.asList(arr));

	}
	
	public static void mergeSort() {
		
	}


	public static void main(String[] args) throws IOException, URISyntaxException {
		
	    insertionSort(args[0]);
	    

	}
}
