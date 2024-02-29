package edu.ucalgary.oop;

import java.util.Objects;

public class Task implements Cloneable {

    private boolean isCompleted = false;
    private String id;
    private String title;

    public Task(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Task copy = (Task) super.clone();
        return copy;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                isCompleted == task.isCompleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }
}
