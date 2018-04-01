package xayb.handler;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    private ScheduledExecutorService scheduledExecutorService;

    public ThreadPool(int maxThreads) {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(maxThreads);
    }

    public void addThread(Runnable run) {
        if(!this.scheduledExecutorService.isShutdown())
            this.addThread(0, run);
    }

    public void addThread(long time, Runnable run) {
        if(!this.scheduledExecutorService.isShutdown())
            this.scheduledExecutorService.schedule(run, time, TimeUnit.MILLISECONDS);
    }

    public void dispose() {
        this.scheduledExecutorService.shutdownNow();
        while(!this.scheduledExecutorService.isTerminated());
    }
}