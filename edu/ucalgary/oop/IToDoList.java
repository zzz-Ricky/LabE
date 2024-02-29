package edu.ucalgary.oop;

import java.util.List;

import edu.ucalgary.oop.Task;

// Define an interface with methods for adding, completing, deleting, editing, undoing, and listing tasks.
interface IToDoList {
    public void addTask(Task task);

    public void completeTask(String taskId);

    public void deleteTask(String taskId);

    public void editTask(String taskId, String editedTitle);

    public void undo();

    public List<Task> listTasks();
}
