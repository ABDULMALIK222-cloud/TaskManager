package service;

import model.Task;
import java.util.*;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String title, String description, String dueDate) {
        Task task = new Task(nextId++, title, description, dueDate);
        tasks.add(task);
        System.out.println("✅ Task added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void markTaskCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markCompleted();
                System.out.println("✅ Task marked as completed.");
                return;
            }
        }
        System.out.println("❌ Task not found.");
    }

    public void deleteTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("🗑️ Task deleted.");
                return;
            }
        }
        System.out.println("❌ Task not found.");
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasksList) {
        this.tasks = tasksList;
        this.nextId = tasksList.stream().mapToInt(Task::getId).max().orElse(0) + 1;
    }
}
