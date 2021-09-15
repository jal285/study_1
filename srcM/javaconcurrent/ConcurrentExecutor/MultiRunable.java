package javaconcurrent.ConcurrentExecutor;

import java.util.List;

//多可运行包装器
public class MultiRunable implements Runnable{
    private final List<Runnable> runnables;

    public MultiRunable(List<Runnable> runnables) {
        this.runnables = runnables;
    }

    @Override
    public void run() {
        for (Runnable runnable: runnables){
            new Thread(runnable).start();
        }

    }
}
