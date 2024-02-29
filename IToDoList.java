package edu.ucalgary.oop;

import java.util.List;

import edu.ucalgary.oop.Task;

// Define an interface with methods for adding, completing, deleting, editing, undoing, and listing tasks.
interface IToDoList {
    public void addTask(Task task);

    public void completeTask(int taskId);

    public void deleteTask(int taskId);

    public void editTask(int taskId, String editedTitle);

    public void undo();

    public List<Object> listTasks();
}
