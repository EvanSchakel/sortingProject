# Word Frequency Analyzer

This project reads a text file, tracks how often each word appears, and compares several linked-list approaches for storing and finding words.

Each approach records useful performance data, including:

- Number of unique words
- Total word count
- Word comparisons
- Reference changes
- Processing time

The results show how different data structures and search strategies affect performance when working with text data.

## Project Structure

- `src/MainClass.java`: Reads the input file, runs the analysis, and displays results
- `src/ListInterface.java`: Defines the shared list operations and performance metrics
- `src/BaseList.java`: Provides common list fields and reporting methods
- `src/LLNode.java`: Represents a word, its count, and its next link
- `src/List1.java`: Unsorted list with new words added to the front
- `src/List2.java`: Alphabetically sorted list
- `src/List2A.java`: Sorted list with an optimized search starting point
- `src/List3.java`: Self-adjusting list that moves repeated words to the front
- `src/List4.java`: Self-adjusting list that moves repeated words forward one position

## Running the Project

Compile the source files:

```bash
javac -d bin src/*.java
```

Run the analyzer with a text file:

```bash
java -cp bin MainClass Hamlet.txt
```

The input file can be replaced with any other text file.
