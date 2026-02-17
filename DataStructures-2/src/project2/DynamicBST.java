package project2;

import java.util.ArrayList;

public class DynamicBST {
		
	int length;
	 int i = 0;
	 int[] myArray = {};
	    // Root of BST 
	    Node root;
	  
	    

		public int[] getMyArray() {
			return myArray;
		}
		
		 public DynamicBST() {  
		        root = null; 
		    } 
		 
		// Constructor 
	  public DynamicBST(int length) {  
	        root = null; 
	        this.length = length;
	        myArray = new int[length];
	    } 
	   
	   public Node getRoot() {
		return root;
	}
	   
	 public  void insert(int key) { 
	       root = insertRec(root, key); 
	    } 
	

	public  Node insertRec(Node root, int key) { 
		CounterSingleton counter = CounterSingleton.getInstance();
		
		 /* If the tree is empty, return a new node */
        if (counter.increaseCounter() && root == null) { 
        	
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (counter.increaseCounter() && key < root.key) {
            root.left = insertRec(root.left, key); 
        }
        else if (counter.increaseCounter() && key > root.key) { 
        	
            root.right = insertRec(root.right, key); 
        }
        
        /* return the (unchanged) node pointer */
        return root; 
	    } 
	    
	   
	   public Node search(Node current, int key) 
	   { 
		    CounterSingleton counter = CounterSingleton.getInstance();
		    
	       // Base Cases: root is null or key is present at root 
	       if (counter.increaseCounter() && (current == null || current.key == key))  
	           return current; 
	       
	       counter.increaseCounter();
	       // val is greater than root's key 
	       if (current.key > key) 
	           return search(current.left, key); 
	     
	       // val is less than root's key 
	       return search(current.right, key); 
	      
	   } 
	   
	   public void dynamicInorder(Node node) {
		   if (node == null) 
	            return; 
		   
		   dynamicInorder(node.left);
		   
		   System.out.println(node.key + " ");
		   
		   dynamicInorder(node.right);
	   }
	   
	   public void dynamicToArray(Node root){
		   if (root != null) { 
			   dynamicToArray(root.left); 
		   
			   myArray[i++] = root.key;
	             dynamicToArray(root.right); 
	         } 
	   }
	   
	   public void testRange(Node node,int k1,int k2) {
		     CounterSingleton counter = CounterSingleton.getInstance();
			  
			  if (counter.increaseCounter() && node == null) { 
		            return; 
		        } 
			  
			  if (counter.increaseCounter() && k1 < node.key) { 
				  testRange(node.left, k1, k2); 
		        } 
			  
			  if (k1 < node.key && k2 > node.key) { 
				  counter.increaseCounter();
		        } 
			  	
			  if (counter.increaseCounter() && k2 > node.key) { 
				  testRange(node.right, k1, k2); 
		        } 
	   }
	   
	   
	  public void dynamicRange(Node node,int k1,int k2) {
		  CounterSingleton counter = CounterSingleton.getInstance();
		  
		  if (node == null) { 
	            return; 
	        } 
		  
		  if ( k1 < node.key) { 
			  dynamicRange(node.left, k1, k2); 
	        } 
		  
		  if (k1 < node.key && k2 > node.key) { 
	            System.out.print(node.key + " "); 
	        } 
		  
		  if (k2 > node.key) { 
			  dynamicRange(node.right, k1, k2); 
	        } 
	  }
	  
   
}
