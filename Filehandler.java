package utils;

import model.Task;
import java.io.*;
import java.util.*;

public class FileHandler {
    public static void saveTasksToFile(List<Task> tasks, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.getId() + "," + task.getTitle() + "," + task.getDescription() + "," + task.getDueDate() + "," + task.isCompleted());
                writer.newLine();
            }
            System.out.println("💾 Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static List<Task> loadTasksFromFile(String filename) {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 5);
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String description = parts[2];
                    String dueDate = parts[3];
                    boolean isCompleted = Boolean.parseBoolean(parts[4]);
                    Task task = new Task(id, title, description, dueDate);
                    if (isCompleted) task.markCompleted();
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ No previous data found.");
        }
        return tasks;
    }
}
