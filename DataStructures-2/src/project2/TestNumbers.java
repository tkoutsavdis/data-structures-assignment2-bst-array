package project2;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class TestNumbers {
	private long start = 0,end =0,start1 = 0,end1 =0,start2 = 0,end2 =0,start3 = 0,end3 =0,start4 = 0,end4 =0;
	Random random = new Random();
	DynamicBST dynamic;
	BinarySearchTree array;
	private String fileName;
	private int number=0,N=0;
	private  ArrayList<Integer> list = new ArrayList<Integer>(); 
	private  ArrayList<Integer> myList = new ArrayList<Integer>(); 
	private int [] array2 = new int[100];
	private   int[] array1;
	private int HUN = 100;
	private int MIL= 1000000;
	private int THOUS = 1000;
	private int number0=0,number1=0,number2=0;
	private int counter1=0,counter2=0,counter3=0,counter4=0,counter5=0,counter6=0,counter7=0,counter8=0,counter9=0;
	
	public TestNumbers() {
		
	}
	
	public void readFile() throws IOException {
		
	System.out.println("Give me (full path) file name:");
	Scanner t = new Scanner(System.in);
	fileName = t.next();
	
	 File file = new File(fileName);
	   
	 FileInputStream fstream =  new FileInputStream(fileName);
	 DataInputStream inputFile = new DataInputStream(fstream);
	 
	  try{
		  while(true){
			  number = inputFile.readInt();
	          list.add(number);
	          
	          N++;
	 	   }
	  }
	  catch (EOFException e)
	 {
	 						}
	  inputFile.close();
	  System.out.println("\n  ***Done with reading from a binary file."); 
	}
	
	
	
	public void averageInsertDynamic() {
		CounterSingleton counter = CounterSingleton.getInstance(); 
		counter.resetCounter();
		int j=0;
		dynamic = new DynamicBST(N);
		
		start = System.currentTimeMillis();
		while(j<N) {
			dynamic.insert(list.get(j));
			j++;
		}
		end = System.currentTimeMillis();
		
		counter1 = counter.getCount();
		array1 = new int[N];
		dynamic.dynamicToArray(dynamic.getRoot());
		array1 = dynamic.getMyArray();
		
	}

	
	public void averageInsertArray() {
		CounterSingleton counter = CounterSingleton.getInstance(); 
		counter.resetCounter();
		int j=0;
		
		
		array = new BinarySearchTree(N);
		
		counter.resetCounter();
		
		start1 = System.currentTimeMillis();
		while(j<N) {
			array.insertKey(0,list.get(j));
			j++;
		}		 
		end1 = System.currentTimeMillis();
		
		counter2 = counter.getCount();
	}
	
	
	public void randomKey() {
		int j=0;
				
		while(j<HUN) {
			number0 = list.get(random.nextInt(list.size()));
			
			myList.add(number0);
			
			j++;	
			}
	}
	
	public void randomRangeKey(int area) {
		int j=0;
		int MAX = array1[N-1];
		
		if(area == HUN) {
			while(j<HUN) {
				array2[j] = HUN + random.nextInt(MAX - HUN + 1 );	
				j++;	
			}
			
		}
		
		else if(area == THOUS) {
			while(j<HUN) {
				array2[j]  =  THOUS + random.nextInt(MAX - THOUS);
				j++;	
			}
		}
	}

	public void averageSearchArray(){
		CounterSingleton counter = CounterSingleton.getInstance(); 
		counter.resetCounter();
		int i=0;
		
		randomKey();
		
		counter.resetCounter();
		
		start2 = System.nanoTime();
		while(i<HUN) {
			number1 = myList.get(i);
			
			array.searchArray(0, number1);
			
			i++;	
		}
		end2 = System.nanoTime();
		counter3 = counter.getCount();
	}
		
	public void averageSearchDynamic(){	
		CounterSingleton counter = CounterSingleton.getInstance(); 
		counter.resetCounter();
		int k=0;
		
		start3 = System.nanoTime();
		while(k<HUN) {
			number2 = myList.get(k);
			
			dynamic.search(dynamic.getRoot(), number2);
			k++;
		}
		end3 = System.nanoTime();	
		counter4 = counter.getCount();
	}

	
	
	
	public void averageRangeDynHUN() {
		int i=0;
		CounterSingleton counter = CounterSingleton.getInstance(); 
		counter.resetCounter();
		
		randomRangeKey(HUN);
		// K = 100 , DYNAMIC
		
		while (i<HUN) {
			
			dynamic.testRange(dynamic.getRoot(), HUN, array2[i]);
			i++;
		}
		counter5 = counter.getCount();
	}
	
	
	
	public void averageRangeArrayHUN() {
		int k= 0 ;
		CounterSingleton counter = CounterSingleton.getInstance(); 
		counter.resetCounter();
		
		//K=100 , ARRAY
		
		while (k<HUN) {
			int value1 = array2[k];
			array.testRange(0, HUN, value1);
			k++;
		}	
		counter6 =counter.getCount();
	}
		
		
		public void averageRangeDynTHOUS() {
			
			int j=0;
			CounterSingleton counter = CounterSingleton.getInstance();
			counter.resetCounter();
			// K=1000 , Dynamic
			randomRangeKey(THOUS);
			
			while (j<100) {
				int value1 = array2[j];
				dynamic.testRange(dynamic.getRoot(), THOUS, value1);
				j++;
			}
			counter7 = counter.getCount();
		}
			
			
			//K=1000 , ARRAY
		public void averageRangeArrayTHOUS() {
			CounterSingleton counter = CounterSingleton.getInstance();
			counter.resetCounter();
			int l=0;
			
			while (l<100) {
				int value1 = array2[l];
				array.testRange(0, THOUS, value1);
				l++;
			}
			counter8 = counter.getCount();
		}
		
		public void binarySearch() {
			int k=0;
			CounterSingleton counter = CounterSingleton.getInstance();
			counter.resetCounter();
			
			start4 = System.nanoTime();
			while(k<HUN) {
				number2 = myList.get(k);
				binarySearch1(array1,0,N-1,number2);
				k++;
			}
			end4 = System.nanoTime();
			counter9 = counter.getCount();
		}
		
		 int binarySearch1(int arr[], int l, int r, int x) {
		    CounterSingleton counter = CounterSingleton.getInstance();
			
			 
		        if (counter.increaseCounter() && r >= l) { 
		            int mid = l + (r - l) / 2; 
		  
		            // If the element is present at the 
		            // middle itself 
		            if (arr[mid] == x) 
		                return mid; 
		  
		            // If element is smaller than mid, then 
		            // it can only be present in left subarray 
		            if (counter.increaseCounter() && arr[mid] > x) 
		                return binarySearch1(arr, l, mid - 1, x); 
		  
		            // Else the element can only be present 
		            // in right subarray 
		            return binarySearch1(arr, mid + 1, r, x); 
		        } 
		        // We reach here when element is not present 
		        // in array 
		        return -1; 
		    } 
		
		public void printValues() {
			
			System.out.println("  AVRG/INSERT TIME INSERT AVRG/SEARCH TIME SEARCH \t K=100          K=1000 ");
			System.out.println("Dynamic: " +counter1/N+ "\t" + (end - start) + " ms \t" +(counter4/100) + "\t" +(end3 - start3)+ " ns\t" + counter5/100 +" \t" + counter7/100 );
			System.out.println("Array: \t" + counter2/N + "\t " +(end1 - start1)+" ms \t" +(counter3/100) + "\t" +  (end2 - start2)+ " ns\t" +counter6/100 +"\t\t" + counter8/100);	
			System.out.println(" \t \t \t \t" +counter9/100 + "\t" + (end4-start4) + " ns");
		}
		
}