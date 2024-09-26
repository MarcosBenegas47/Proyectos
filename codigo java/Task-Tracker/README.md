# Task Tracker

_This is a simple command-line interface(CLI) application for managing tasks._

## Fearures 🚀

- Add, Update, and Delete tasks
- Mark a task as in progress or done
- List all tasks
- List all tasks that are done
- List all tasks that are not done
- List all tasks that are in progress



## How to run 🔧
### Prerequisites

- Java Development Kit (JDK) installed on your machine (version 8 or higher).
- Ensure that javac and java are available in your system's PATH.
### Compilation

1. Open a terminal or command prompt.

2. Navigate to the directory where taskCli.java is located.

_Compile the Java file using the following command:_

bash
Copiar código

```
javac taskCli.java
```
This will generate a taskCli.class file in the same directory.


### Running the Program ⚙️


_After compiling, you can run the program using various commands, depending on the desired action. Below are examples of how to use it:_


1. Adding a new task:
```
java taskCli add "Task 1"
```

2. Updating an existing task:

```
java taskCli update <id> "Buy groceries"
```

3. Deleting a task:

```
java taskCli delete <id>
```
4. Marking a task as "In Progress":
```
java taskCli mark-in-progress <id>
```
5. Marking a task as "Done":
```
java taskCli mark-done <id>
```
6. Listing all tasks:
```
java taskCli list
```
7. Listing tasks by status:

- To list tasks marked as "Done":
```
java taskCli list done
```

- To list tasks marked as "To Do":
```
java taskCli list todo
```

- To list tasks marked as "In Progress":
```
java taskCli list in-progress
```
