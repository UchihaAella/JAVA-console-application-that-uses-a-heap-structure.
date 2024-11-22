import java.util.PriorityQueue;
import java.util.Scanner;

// Class representing a Task with a description and deadline
class Task implements Comparable<Task> {
    private String description; // Description of the task
    private int deadline;       // Deadline in hours (smaller value = higher priority)

    // Constructor to initialize task details
    public Task(String description, int deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    // Getter for task description
    public String getDescription() {
        return description;
    }

    // Getter for task deadline
    public int getDeadline() {
        return deadline;
    }

    // Method to compare tasks based on their deadlines
    // Ensures tasks with earlier deadlines have higher priority
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.deadline, other.deadline);
    }

    // String representation of the task for easy printing
    @Override
    public String toString() {
        return "Task[description='" + description + "', deadline=" + deadline + " hours]";
    }
}

// Main class to manage task scheduling
public class TaskScheduler {
    private PriorityQueue<Task> taskQueue; // Priority queue to store and prioritize tasks

    // Constructor to initialize the priority queue
    public TaskScheduler() {
        this.taskQueue = new PriorityQueue<>();
    }

    // Method to add a new task to the queue
    public void addTask(String description, int deadline) {
        Task newTask = new Task(description, deadline); // Create a new task
        taskQueue.offer(newTask);                      // Add the task to the queue
        System.out.println("Task added: " + newTask);  // Confirm task addition
    }

    // Method to view all tasks in the queue
    public void viewTasks() {
        if (taskQueue.isEmpty()) { // Check if the queue is empty
            System.out.println("No tasks in the queue.");
            return;
        }
        System.out.println("Tasks in the queue:");
        for (Task task : taskQueue) { // Iterate through tasks (note: PriorityQueue doesn't guarantee order here)
            System.out.println(task);
        }
    }

    // Method to process the next task (task with the highest priority)
    public void processTask() {
        if (taskQueue.isEmpty()) { // Check if there are any tasks to process
            System.out.println("No tasks to process.");
            return;
        }
        Task task = taskQueue.poll();  // Remove and retrieve the highest-priority task
        System.out.println("Processing task: " + task); // Confirm task processing
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler(); // Create an instance of TaskScheduler
        Scanner scanner = new Scanner(System.in);      // Scanner for user input
        int choice; // User menu choice

        // Menu-driven program
        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Process Next Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();        // Read user choice
            scanner.nextLine(); // Consume newline

            // Perform actions based on user choice
            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine(); // Read task description
                    System.out.print("Enter task deadline (in hours): ");
                    int deadline = scanner.nextInt();        // Read task deadline
                    scheduler.addTask(description, deadline); // Add task to the scheduler
                    break;

                case 2:
                    scheduler.viewTasks(); // View all tasks in the queue
                    break;

                case 3:
                    scheduler.processTask(); // Process the next task in the queue
                    break;

                case 4:
                    System.out.println("Exiting Task Scheduler. Goodbye!"); // Exit message
                    break;

                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
            }
        } while (choice != 4); // Repeat menu until user chooses to exit


    }
}
