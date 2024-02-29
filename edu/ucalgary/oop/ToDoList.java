package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.ucalgary.oop.Task;

class ToDoList implements IToDoList {

    private List<Task> taskList = new ArrayList<Task>();
    private Stack<List<Task>> changes = new Stack<List<Task>>();

    @Override
    public void addTask(Task task) {
        changes.push(taskList);
        taskList.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        changes.push(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId() == taskId) {
                task.setIsCompleted(true);
            }
        }
    }

    @Override
    public void deleteTask(String taskId) {
        changes.push(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId() == taskId) {
                taskList.remove(task);
            }
        }
    }

    @Override
    public void editTask(String taskId, String editedTitle, boolean newTaskStatus) {
        changes.push(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId() == taskId) {
                task.setId(taskId);
                task.setTitle(editedTitle);
                task.setIsCompleted(newTaskStatus);
            }
        }
    }

    @Override
    public void undo() {
        if (!changes.isEmpty()) {
            taskList = changes.pop();
        }
    }

    @Override
    public List<Task> listTasks() {
        return taskList;
    }
}
