import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasksList = new ArrayList<>();
        tasksList = loadTasksFromFile("tasks.txt");
        while(true){
            //Main program asks user for instruction
            System.out.println("What would you like to do? \n1.Create a new task? \n2.View all tasks? \n3.Clear tasks? \n4.Save and exit");
            String choice = scanner.nextLine();
            //Adds tasks
            if (choice.equals("1")){
                boolean addAnotherTask = true;
                while(addAnotherTask){
                    System.out.println("What is the name of the task?");
                    String taskName = scanner.nextLine();
                    while (taskName.trim().isEmpty()) {
                        System.out.println("Task Name cannot be empty. Please enter a valid name.");
                        taskName = scanner.nextLine();
                            }
                    System.out.println("Enter a description for your task\n(Can leave blank)");
                    String taskDesription = scanner.nextLine();
                    Task task = new Task(taskName, taskDesription);
                    tasksList.add(task);
                    while(true){
                        System.out.println("Task sucessfully made :D, would you like to make another task?(y/n)");
                        String taskMaker = scanner.nextLine();
                        if (taskMaker.equals("y")) {
                            break;
                        } else if (taskMaker.equals("n")){
                            addAnotherTask = false;
                            break;
                        } else{
                            System.out.println("Not a valid output!");
                        }
                        }
                    } 
            }
            if(choice.equals("2")){
                if(tasksList.isEmpty()){
                    System.out.println("You have no tasks!");
                } else {
                    for(int i = 0; i <  tasksList.size(); i++){
                        System.out.println(i + 1 + "." + tasksList.get(i));
                    }
                }

            }
            if(choice.equals("3")){
                if(tasksList.isEmpty()){
                    System.out.println("You have no tasks to remove!");
                } else{
                    for(int i = 0; i < tasksList.size(); i++){
                        System.out.println(i + 1 + "." + tasksList.get(i));
                    }
                    System.out.println("Which task would you like to remove?");
                    int removeTask = scanner.nextInt();
                    tasksList.remove(removeTask - 1);
                }

            }
            if(choice.equals("4")){
                saveTasksToFile(tasksList, "tasks.txt");
                System.out.println("Tasks saved to file. Exiting program.");
                break;
            }
        }

        
    }
    public static void saveTasksToFile(ArrayList<Task> tasks, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    // Method to load tasks from file
    public static ArrayList<Task> loadTasksFromFile(String filename) {
        ArrayList<Task> tasks = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            tasks = (ArrayList<Task>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If file doesn't exist or error reading, just return empty list
            System.out.println("Cant find a task file");
        }
        return tasks;
    }
}
