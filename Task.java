package model;

public class Task {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private boolean isCompleted;

    public Task(int id, String title, String description, String dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nTitle: %s\nDescription: %s\nDue Date: %s\nCompleted: %s\n",
                id, title, description, dueDate, isCompleted ? "Yes" : "No");
    }
}
