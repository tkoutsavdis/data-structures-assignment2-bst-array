package project2;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Scanner;

public class Console {
	private static int numberOfElements=0;
	private static int key1=0,key2=0;
	private static int searchKey = 0,searchKey1 = 0 ;
	private static int rangeKey1 = 0;
	private static int rangeKey2 = 0;
	private static BinarySearchTree tree; 
	private static boolean test0 = true,test1 = true,test2 = true;
	private static DynamicBST dynamicTree;
	private static TestNumbers test;
	private static String fileName = null;
	private static int number=0,N=0;
			
	
	public static void main(String[] args) throws IOException {
		
    
		while(test0 == true) {
			
			System.out.println();
			System.out.println("Press:\n 'a' to make manually an array binary search tree.\n 'b' to make manually a dynamic binary search tree.\n 't' to open file and test.\n 'z'  exit:");
			Scanner c0 = new Scanner(System.in);
			int choise0 = c0.next().charAt(0);
			test2 = true;
			test1 = true;
		
			if(choise0 == 'a') {
				
				System.out.println("How many elements do you want to save in the array ?");
				Scanner s = new Scanner(System.in);
				numberOfElements = s.nextInt();
				
				tree = new BinarySearchTree(numberOfElements);
				printMenu1();
				

				while(test2 == true) {
					System.out.println("what do you want to do?");
					Scanner c = new Scanner(System.in);
					char choise2 = c.next().charAt(0);
					
					switch(choise2) {
					case 'i':
						System.out.println("Give me the key to insert:");
						Scanner in = new Scanner(System.in);
						key1 = in.nextInt();
						
						tree.insertKey( 0,key1);
						break;
						
					case 'p':
						tree.printArray();
						break;
						
					case 's':
						System.out.println("Give me the key to search:");
						Scanner si = new Scanner(System.in);
						searchKey = si.nextInt();
						
						int f = tree.searchArray(0, searchKey);
						
						if(f != -1 ) {
							System.out.println("The number found !! ");
						}else {
							System.out.println("The number NOT found !! ");
						}
						break;
						
					case 'c':
						tree.inorder(0);
						System.out.print("\n");
						break;
						
					case 'r':
						System.out.println("Give me the first range key:");
						Scanner k1 = new Scanner(System.in);
						rangeKey1 = k1.nextInt();
						
						System.out.println("Give me the second range key:");
						Scanner k2 = new Scanner(System.in);
						rangeKey2 = k2.nextInt();
						
						tree.range(0, rangeKey1, rangeKey2);
						System.out.print("\n");
						break;
						
					case 'e':
						test2 = false;
						test0 = true;
						break;
					
					default:
						test2 = false;
					}
		}
				
			}
				
			if(choise0 == 'b') {
				
				printMenu2();
				dynamicTree = new DynamicBST();
				
				while(test1 == true) {
					System.out.println("what do you want to do?");
					Scanner c = new Scanner(System.in);
					char choise1 = c.next().charAt(0);
					
					switch(choise1) {
					
					case 'i':
						System.out.println("Give me the key to insert:");
						Scanner ins = new Scanner(System.in);
						key2 = ins.nextInt();
						dynamicTree.insert(key2);
						
						break;
						
					case 's':
						System.out.println("Give me the key to search:");
						Scanner sd = new Scanner(System.in);
						searchKey1 = sd.nextInt();

						
						Node cs;
						cs = dynamicTree.search(dynamicTree.getRoot(),searchKey1);
						
						if (cs != null )
							System.out.println("The number  found!");
						else 
							System.out.println("The number NOT found!");
						break;
						
					case 'c':
						dynamicTree.dynamicInorder(dynamicTree.getRoot());
						System.out.print("\n");
						break;
						
					case 'r':
						System.out.println("Give me the first range key:");
						Scanner k1 = new Scanner(System.in);
						rangeKey1 = k1.nextInt();
						
						System.out.println("Give me the second range key:");
						Scanner k2 = new Scanner(System.in);
						rangeKey2 = k2.nextInt();
						
						dynamicTree.dynamicRange(dynamicTree.getRoot(), rangeKey1, rangeKey2);
						System.out.print("\n");
						break;
						
					case 'e':
						test1 = false;
						test0 = true;
						break;
					
					default:
						test1 = false;
					}
				}
			}
			
			if(choise0 == 't') {
				
				test = new TestNumbers();
				
				test.readFile();
				test.averageInsertDynamic();
				test.averageInsertArray();
				test.averageSearchArray();
				test.averageSearchDynamic();
				test.averageRangeDynHUN();
				test.averageRangeArrayHUN();
				test.averageRangeDynTHOUS();
				test.averageRangeArrayTHOUS();
				test.binarySearch();
				test.printValues();
				
				
				test0 = true;
			}
			
			if(choise0 == 'z') {
				test0 = false;
				System.out.println("Goodbye !! ");
			}				
			}
		}		
	
	private static void printMenu1() {
		System.out.println("\tArray BST");
		System.out.println("Press 'i' to insert new key.");
		System.out.println("Press 's' to search key.");
		System.out.println("Press 'c' for inorder.");
		System.out.println("Press 'r' to range.");	
		System.out.println("Press 'p' to print the array.");
		System.out.println("Press 'e' to finish and go back to the main menu.");
	}
	
	private static void printMenu2() {
		System.out.println("\tDynamic BST");
		System.out.println("Press 'i' to insert new key.");
		System.out.println("Press 's' to search key.");
		System.out.println("Press 'c' for inorder.");
		System.out.println("Press 'r' to range.");	
		System.out.println("Press 'e' to finish and go back to the main menu.");
	}

}