package taskexecutor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final TaskExecutor executor;

    public Menu() {
        scanner = new Scanner(System.in);
        executor = new TaskExecutor();
    }

    private void displayHeader() {
        System.out.println("===================================");
        System.out.println("Simultaneous Task Executor");
        System.out.println("for Calculating Factorial of a Number");
        System.out.println("===================================\n");
    }

    private int getNumberOfTasks() {
        int numTasks;
        while(true) {
            System.out.print("Enter the number of tasks to be executed simultaneously: ");
            try {
                numTasks = scanner.nextInt();
                break;
            } catch(InputMismatchException e) {
                System.err.println("Invalid input. Please enter an integer number.");
                scanner.next();
            }
        }
        return numTasks;
    }

    private int getNumberForFactorial(int i) {
        while(true) {
            System.out.print("Provide the number for which you want to calculate the factorial in task " + i + ": ");
            try {
                int num = scanner.nextInt();
                if(num >= 0) {
                    return num;
                } else {
                    throw new InputMismatchException("Invalid input. Please enter a non-negative integer number.");
                }

            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter an integer number.");
                scanner.next();
            }
        }
    }
    public void showMenu() {
        displayHeader();
        int numTasks = getNumberOfTasks();
        for(int i = 1; i <= numTasks; i++) {
            int num = getNumberForFactorial(i);
            Task factorialTask = new Task("Factorial Task " + i, num);
            executor.addTask(factorialTask);
        }
        executor.startExecution();
        executor.waitForCompletion();
    }
}
