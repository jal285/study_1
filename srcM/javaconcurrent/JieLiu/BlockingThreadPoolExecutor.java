package javaconcurrent.JieLiu;

import java.util.concurrent.*;


//
//在此解决方案中，我们将创建一个Semaphore数字，该数字必须等于在任何给定时间点阻塞队列中的最大任务数。因此，该方法如下所示：
//
//        1）在执行任务之前，要求锁定信号量；
//        2）如果获得了锁定，则执行正常。否则，重试将一直进行到获得锁为止
//        。3）任务完成后；锁被释放到信号量
public class BlockingThreadPoolExecutor extends ThreadPoolExecutor
{
    private final Semaphore semaphore;

    public BlockingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        semaphore = new Semaphore(corePoolSize + 50);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r)
    {
        super.beforeExecute(t, r);
    }

    @Override
    public void execute(final Runnable task)
    {
        boolean acquired = false;
        do
        {
            try
            {
                semaphore.acquire();
                acquired = true;
            } catch (final InterruptedException e)
            {
                //LOGGER.warn("InterruptedException whilst aquiring semaphore", e);
            }
        } while (!acquired);
        try
        {
            super.execute(task);
        } catch (final RejectedExecutionException e)
        {
            System.out.println("Task Rejected");
            semaphore.release();
            throw e;
        }
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t)
    {
        super.afterExecute(r, t);
        if (t != null)
        {
            t.printStackTrace();
        }
        semaphore.release();
    }
}
