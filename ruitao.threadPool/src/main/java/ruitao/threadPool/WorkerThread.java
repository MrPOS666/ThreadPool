package ruitao.threadPool;

import java.util.concurrent.LinkedBlockingQueue;

class WorkerThread extends Thread {
    private final LinkedBlockingQueue<Runnable> queue;

    public WorkerThread(LinkedBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                Runnable task = queue.take();
                task.run();
                System.out.println(currentThread().getName());
            } catch (RuntimeException | InterruptedException err) {
                System.out.println("Thread pool is interrupted due to an issue: " + err.getMessage());
            }
        }
    }
}
