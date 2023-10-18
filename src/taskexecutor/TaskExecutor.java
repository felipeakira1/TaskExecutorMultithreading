package taskexecutor;

import java.util.List;
import java.util.ArrayList;

public class TaskExecutor {
    private final List<Thread> threads;
    private final List<Runnable> tasks;

    public TaskExecutor() {
        this.threads = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public void addTask(Runnable task) {
        tasks.add(task);
    }

    public void startExecution() {
        for(Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }
    }

    public void waitForCompletion() {
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
