# Data Structures Assignment 2: Binary Search Tree (Array-Based with AVAIL Free-List)

A static array-based Binary Search Tree implementation using an N×3 matrix representation with AVAIL free-list for memory management. This laboratory assignment demonstrates classical data structure techniques in fixed-memory environments without dynamic allocation, comparing node-pointer patterns to array indexing strategies.

## Overview

This project implements a **contiguous memory Binary Search Tree** using a pre-allocated 3×N integer array. Rather than using Java object references, the tree stores logical pointers as array indices. The AVAIL free-list system manages available positions, enabling efficient reuse of deallocated nodes. This approach exemplifies how to implement pointer-based data structures in languages or environments with memory constraints or cache-locality requirements.

## What It Does

- **Array-Based BST**: Static binary search tree using a 3-element array representation (keys, left-pointers, right-pointers) with fixed pre-allocated capacity
- **Dynamic BST**: Pointer-based binary search tree using Node objects with dynamic memory allocation
- **Core Operations**:
  - Insert elements into trees
  - Search for specific values
  - Range queries (find all elements between two bounds)
  - In-order tree traversal
- **Performance Metrics**:
  - Execution time measurement (milliseconds for insertions, nanoseconds for searches)
  - Operation counter via Singleton pattern to track recursive calls and comparisons
  - Comparative analysis between implementation strategies
- **Data Handling**:
  - Binary file reading support (Big Endian format for Java compatibility)
  - Load datasets from 50 up to 1,000,000 unique integers
  - Random key selection and range boundary generation
- **Interactive Console**: Menu-driven interface for manual tree operations and automated testing

## Quick Start
### Compilation & Execution

**Using Eclipse:**
1. Import the project into Eclipse
2. Right-click the project → Build Project
3. Run `Console.java` as Java Application

**Using Command Line:**
```bash
cd DataStructures-2/src
javac project2/*.java
java project2.Console
```

### Usage

Launch the console and select from menu options:
- **'a'**: Create array-based BST manually
- **'b'**: Create dynamic BST manually  
- **'t'**: Load test data from binary file and run performance analysis
- **'z'**: Exit program

For testing with large datasets, ensure binary test files are in the `testnumbers/` directory. Provide full file path when prompted.

## Requirements

- **Java Version**: 8+
- **Memory**: 256MB minimum (for 1M element dataset)
- **Storage**: ~150MB for all test binary files
- **Device**: Any system with Java runtime

## Project Structure

```
DataStructures-2/
├── src/project2/
│   ├── BinarySearchTree.java       # Array-based BST (static, fixed-size)
│   ├── DynamicBST.java             # Pointer-based BST (dynamic allocation)
│   ├── Node.java                   # Tree node structure for dynamic BST
│   ├── TestNumbers.java            # Performance testing and benchmarking
│   ├── CounterSingleton.java       # Operation counter utility
│   ├── Console.java                # Main menu and user interface
│   └── README.md                   # This file
├── testnumbers/
│   ├── testnumbers_50_BE.bin       # 50 elements (Big Endian)
│   ├── testnumbers_100_BE.bin      # 100 elements
│   ├── testnumbers_1000_BE.bin     # 1,000 elements
│   ├── testnumbers_10000_BE.bin    # 10,000 elements
│   ├── testnumbers_100000_BE.bin   # 100,000 elements
│   ├── testnumbers_1000000_BE.bin  # 1,000,000 elements
│   ├── README.txt                  # Binary file format documentation
│   └── *_LE.bin                    # Little Endian variants (for C/C++)
├── Report.pdf                      # Lab analysis and findings
├── Lab.pdf                         # Lab assignment documentation
└── TEST.pdf                        # Test specifications

```

## Key Classes

### `BinarySearchTree.java`
Fixed-capacity array-based BST using 3×N array: row 0 (keys), row 1 (left child indices), row 2 (right child indices).

**Key Methods:**
- `insertKey(int root, int key)` - Insert element with overflow detection
- `searchArray(int place, int key)` - Recursive search returning node index
- `range(int place, int k1, int k2)` - Range query printing elements in bounds
- `testRange(int place, int k1, int k2)` - Count operations during range query

### `DynamicBST.java`
Pointer-based BST with dynamic node allocation using standard binary tree structure.

**Key Methods:**
- `insert(int key)` - Insert element with automatic memory allocation
- `search(Node current, int key)` - Recursive search returning Node reference
- `dynamicRange(Node node, int k1, int k2)` - Range query with dynamic allocation
- `dynamicToArray(Node root)` - Convert in-order traversal to array

### `TestNumbers.java`
Comprehensive performance benchmarking suite.

**Key Methods:**
- `readFile()` - Load binary test dataset
- `averageInsertDynamic()` / `averageInsertArray()` - Measure insertion performance
- `averageSearchDynamic()` / `averageSearchArray()` - Measure search performance  
- `averageRangeDynHUN()` / `averageRangeArrayHUN()` - Range query benchmarks (k=100)
- `averageRangeDynTHOUS()` / `averageRangeArrayTHOUS()` - Range query benchmarks (k=1000)
- `printValues()` - Display comparative performance report

### `CounterSingleton.java`
Thread-safe singleton managing operation count for complexity analysis.

**Methods:**
- `getInstance()` - Get singleton instance
- `increaseCounter()` - Increment and return true (allows inline counting)
- `getCount()` - Return current operation count
- `resetCounter()` - Reset for new test

### `Console.java`
Interactive user interface providing:
- Manual tree construction and manipulation
- File-based dataset loading
- Test execution triggering
- Results display

## Notes & Assumptions

### Implementation Details
- **Array-Based BST**: Uses -1 as null pointer indicator; AVAIL tracks next available array index
- **Dynamic BST**: Uses Java object references; automatically manages memory
- **Counter Integration**: Both implementations increment operation counter at critical decision points to measure actual comparison/assignment operations performed
- **Singleton Pattern**: CounterSingleton ensures consistent operation tracking across all components

### Design Decisions
- Fixed array BST includes overflow detection to prevent index violations
- In-order traversal used for range queries to maintain sorted order
- Random key generation for search tests ensures no cache-friendly access patterns
- Nano-second timing for search operations; millisecond timing for bulk insertions

### Test Dataset Format
- Binary files contain signed 32-bit integers (4 bytes each)
- Big Endian format (network byte order) for Java interoperability
- All integers are unique and randomly distributed
- Test files located in `testnumbers/` folder

### Performance Characteristics
- **Array BST**: Predictable memory footprint, faster worst-case bounds checking, cache-friendly sequential memory
- **Dynamic BST**: Lower memory overhead for sparse trees, better for unknown dataset sizes, pointer indirection overhead

### Limitations & Known Issues
- Array-based implementation limited by pre-allocated capacity
- Range query operations use manual traversal (optimization opportunity: implement balanced variants)
- Single-threaded design (CounterSingleton not thread-safe for concurrent testing)
- Large dataset testing (1M elements) requires sufficient heap memory

---
