# sortingProject

EECS 2500 - Word Frequency Lists  
Evan Schakel  
Due: Sunday, November 15, 2026 @ 11:59 PM  

## Requirements

- Main class: `MainClass` (in `src/MainClass.java`)
- Default package only (no `package` statements)
- No `module-info.java`
- Input file passed via command line (`args[0]`)
- Submission format: `2500-Schakel, Evan.7z`

## Files

- `src/MainClass.java`: Entry point and 7-pass driver
- `src/ListInterface.java`: Required list interface
- `src/BaseList.java`: Abstract base class with common fields
- `src/LLNode.java`: Singly linked list node
- `src/List1.java`: Unsorted (front insertion)
- `src/List2.java`: Sorted alphabetically
- `src/List2A.java`: Sorted with previous search pointer (POLI)
- `src/List3.java`: Self-adjusting (move to front)
- `src/List4.java`: Self-adjusting (move by one)

## Compile & Run

```bash
javac -d bin src/*.java
java -cp bin MainClass Hamlet.txt
```

## Packaging

Run `./package_submission.sh` to generate `2500-Schakel, Evan.7z`.
