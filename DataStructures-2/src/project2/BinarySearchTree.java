package project2;

public class BinarySearchTree {
	private int root;
	private int AVAIL;
	private int key;
	private int maxNodes;
	private int[][] treeArray;
	
	public BinarySearchTree(int maxNodes) {
		root = 0; 
		treeArray = new int[3][maxNodes];
		AVAIL = 0; 
		this.maxNodes = maxNodes -1;
		initStuck(maxNodes);
	}
	
	public void initStuck(int maxNodes1){
		for(int i=0; i <= (maxNodes1 - 2) ; i++) {
			treeArray[0][i] = -1;
			treeArray[1][i] = -1;
			treeArray[2][i] = (i+1);
		}
		treeArray[0][maxNodes1-1] = -1;
		treeArray[1][maxNodes1-1] = -1;
		treeArray[2][maxNodes1-1] = -1;
	}
	
public void insertKey(int root,int key) {
		
		
		if(treeArray[0][maxNodes] == -1) {
			
			
			if(treeArray[0][root] == -1) {
				treeArray[0][root] = key;
				treeArray[1][root] = -1;
				treeArray[2][root] = -1;
				AVAIL = AVAIL + 1;
			}else {
				findLocationToInsert(root , key);
			}
		}else {
			System.out.println("No more space to save numbers!");
		}
	}
	
	
	public void  findLocationToInsert(int place , int key) {	
		CounterSingleton counter = CounterSingleton.getInstance();
		
		if(counter.increaseCounter() && treeArray[0][place] != -1 ) { // if the current place is not empty 
			
			
			if(counter.increaseCounter() && key >  treeArray[0][place] && treeArray[2][place] == -1) { // if key > current place 
					treeArray[2][place] = AVAIL;
					findLocationToInsert(AVAIL,key);
			}else if(counter.increaseCounter() && key> treeArray[0][place] && treeArray[2][place] != -1){
				findLocationToInsert(treeArray [2][place],key);
			}
					
			else if (counter.increaseCounter() && key < treeArray[0][place] && treeArray[1][place] == -1) { //if key < current place 
				
					treeArray[1][place] = AVAIL;
					findLocationToInsert(AVAIL,key);
				}else if(counter.increaseCounter() && key< treeArray[0][place] && treeArray[1][place] != -1){
					findLocationToInsert(treeArray [1][place],key);
				}
			}

		else {
			 treeArray[0][place] = key;
			 treeArray[1][place] = -1;
			 treeArray[2][place] = -1;
			 AVAIL = AVAIL + 1;
		 
		}	
		
	}

	public void printArray() {
		
		for(int i=0; i<=2 ; i++) {
			System.out.print("line " + i + ": " );
			for(int j=0; j<=(maxNodes) ; j++) {
				System.out.print("\t " +treeArray[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public int searchArray(int place , int key) {
		CounterSingleton counter = CounterSingleton.getInstance();
		
		if(counter.increaseCounter() && (place == -1 || key == treeArray[0][place])) {
			return place;
		}
		
		 if(counter.increaseCounter() && key> treeArray[0][place] ) 
			return searchArray(treeArray[2][place] ,key);
		 
			return searchArray(treeArray[1][place],key);	
	}
	
	public void inorder(int place) {
		
		if(treeArray[0][place] == -1) {
			return;
		}
		else if(treeArray[0][place] != -1) {
		 	if(treeArray[1][place] != -1) {
		 		inorder(treeArray[1][place]);	
		 	}
		 	
		 	System.out.println(treeArray[0][place] + " ");
		 	
			if(treeArray[2][place] != -1) {
				inorder(treeArray[2][place]);
			}
		}
	}
	
	public void testRange(int place, int k1, int k2) {
		 CounterSingleton counter = CounterSingleton.getInstance();
		 
		if(counter.increaseCounter() && treeArray[0][place] == -1) {
			return;
		}
		else  {
			
		 	if(counter.increaseCounter() &&  treeArray[1][place] != -1 && treeArray[0][place]> k1) {
		 		testRange(treeArray[1][place],k1,k2);
		 		
		 	}	
		 	if(treeArray[0][place] > k1 && treeArray[0][place] < k2) {
		 		counter.increaseCounter();
		 	}
		 	
			if(counter.increaseCounter() && counter.increaseCounter() &&  treeArray[2][place] != -1 && treeArray[0][place] < k2) {
				testRange(treeArray[2][place],k1,k2);
			}
		}
	}
	
	
	public void range(int place, int k1, int k2) {
		
		
		if(treeArray[0][place] == -1) {
			return;
		}
		else if( treeArray[0][place] != -1) {
			
		 	if( treeArray[1][place] != -1 && treeArray[0][place]> k1) {
		 		range(treeArray[1][place],k1,k2);
		 		
		 	}	
		 	if( treeArray[0][place] > k1 && treeArray[0][place] < k2) {
		 		System.out.print(treeArray[0][place] + " ");
		 		}
			if( treeArray[2][place] != -1 && treeArray[0][place] < k2) {
				range(treeArray[2][place],k1,k2);
			}
		}
	}
}
