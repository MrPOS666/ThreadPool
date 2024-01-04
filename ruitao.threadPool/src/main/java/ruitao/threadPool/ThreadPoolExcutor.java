package ruitao.threadPool;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExcutor {
    private final int poolSize;
    private final WorkerThread[] workers;
    private final LinkedBlockingQueue<Runnable> queue;

    public ThreadPoolExcutor(int poolSize, int maxCapacity) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<Runnable>(maxCapacity);
        workers = new WorkerThread[poolSize];
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread(queue);
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        queue.offer(task);
    }

    public void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < poolSize; i++) {
            workers[i] = null;
        }
    }
}

