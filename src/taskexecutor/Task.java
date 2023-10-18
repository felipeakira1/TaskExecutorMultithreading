package taskexecutor;

public class Task implements Runnable{
    private final String taskName;
    private final int num;

    public Task(String taskName, int num) {
        this.taskName = taskName;
        this.num = num;
    }

    private long calculateFactorial(int num) {
        long factorial = 1;
        for(int i = 1; i <= num; i++) {
            double percent = ((double) i/num) * 100;
            System.out.println("Task Progress (" + taskName + "): " + percent + "%");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            factorial *= i;
        }

        return factorial;
    }

    @Override
    public void run() {
        System.out.println("Running task: " + taskName);
        long factorialResult = calculateFactorial(num);
        System.out.println("Task executed successfully! Factorial of " + num + " is: " + factorialResult);
    }
}
