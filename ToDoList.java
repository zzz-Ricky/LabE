package edu.ucalgary.oop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import edu.ucalgary.oop.Task;

class ToDoList implements IToDoList {

    private List<Object> taskList = new List<Object>();
    private Deque<List<Object>> changes = new ArrayDeque<>();

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public void completeTask(int taskId) {
        changes.push(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId() == taskId) {
                task.setIsCompleted(true);
            }
        }
    }

    @Override
    public void deleteTask(int taskId) {
        changes.push(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId() == taskId) {
                taskList.remove(task);
            }
        }
    }

    @Override
    public void editTask(int taskId, String editedTitle) {
        changes.push(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId() == taskId) {
                task.setId(taskId);
                task.setTitle(editedTitle);
            }
        }
    }

    @Override
    public void undo() {
        taskList = changes.pop();
    }

    @Override
    public List<Object> listTasks() {
        return taskList;
    }
}
