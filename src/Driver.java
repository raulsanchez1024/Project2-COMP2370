import java.io.File;
import java.io.FileNotFoundException;
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
	
	public static void insertionSort(String f, int n) throws IOException, URISyntaxException {
//		get file, read file, and store the text into an array
		URL url = ClassLoader.getSystemResource(f);

		
		File file = new File(url.toURI()); 
	    Scanner sc = new Scanner(file); 
	    			  
//	    insert all words into an ArrayList (arrList)
	    ArrayList<String> arrList = new ArrayList<String>();
	    while (sc.hasNext()) {
	    	arrList.add(sc.next());
	    }
	    
	    ArrayList<String> arr2 = new ArrayList<>(arrList.subList(0, n));
	    
//	   convert arrList to a regular array
	    String[] arr = arr2.toArray(new String[0]);

//	    close scanner
	    sc.close();
	    
	    CpuTimer timer = new CpuTimer();
	    
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
	    System.out.print("Avg. times for n = " + n + ": Insertion Sort "  + timer.getElapsedCpuTime() + " sec., ");
	}
	
	public static String[] mergeSortSetup(String f, int n) throws URISyntaxException, FileNotFoundException {
//		get file, read file, and store the text into an array
		URL url = ClassLoader.getSystemResource(f);

		
		File file = new File(url.toURI()); 
	    Scanner sc = new Scanner(file); 
	    			  
//	    insert all words into an ArrayList (arrList)
	    ArrayList<String> arrList = new ArrayList<String>();
	    while (sc.hasNext()) {
	    	arrList.add(sc.next());
	    }
	    
	    ArrayList<String> arr2 = new ArrayList<>(arrList.subList(0, n));
	    
//	   convert arrList to a regular array
	    String[] arr = arr2.toArray(new String[0]);

//	    close scanner
	    sc.close();
	    
	    return arr;
	}
	
	public static void merge(String[] A, int p, int q, int r) throws URISyntaxException, FileNotFoundException {
	    
		int n1 = q - p + 1;
		int n2 = r - q;
		
		String[] left = new String[n1];
	    String[] right = new String[n2];
	    
	    for(int i = 0; i < n1; i++) {
	    	left[i] = A[p + i];
	    }
	    for(int j = 0; j < n2; j++) {
	    	right[j] = A[q + 1 + j];
	    }
	    
	    int i = 0, j = 0;
	    
	    int k = p;
	    while (i < n1 && j < n2) {
	    	if (left[i].compareTo(right[j]) <= 0) {
	    		A[k] = left[i];
	    		i++;
	    	} else {
	    		A[k] = right[j];
	    		j++;
	    	}
	    	k++;
	    }
	    
	    while (i < n1) {
	    	A[k] = left[i];
	    	i++;
	    	k++;
	    }
	    while (j < n2) {
	    	A[k] = right[j]; 
            j++; 
            k++; 
	    }
	}
	
	public static void mergeSort(String[] A, int p, int r) throws FileNotFoundException, URISyntaxException {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	


	public static void main(String[] args) throws IOException, URISyntaxException {
		
		
		
		for(int i = 3; i <= 13; i++) {
			int n = (int) Math.pow(2, i);
			insertionSort(args[0], n);
			
			String[] arr = mergeSortSetup(args[0], n);
		    CpuTimer timer = new CpuTimer();
			mergeSort(arr, 0, arr.length - 1);
		    System.out.println("Merge Sort "  + timer.getElapsedCpuTime() + " sec.");

		    
		}
	}
}
