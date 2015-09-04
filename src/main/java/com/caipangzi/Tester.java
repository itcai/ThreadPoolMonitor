package com.caipangzi;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/4
 * Time: 10:16
 * 具体测试类,里面有一个线程池和一个监控线程
 */
public class Tester {

    private Logger log = Logger.getLogger(Tester.class);

    IThreadPoolExecutorService threadPoolExecutorService;
    IThreadPoolMonitorService threadPoolMonitorService;

    public void go() {

        //创建线程池
        ThreadPoolExecutor executor = threadPoolExecutorService.createThreadPool();
        executor.allowCoreThreadTimeOut(true);

        threadPoolMonitorService.setExecutor(executor);

        //创建监控线程
        Thread monitorThread = new Thread(threadPoolMonitorService);
        monitorThread.start();

        for (int i=0; i<10; i++) {
            executor.execute(new RunnableTask("try to execute task " + i));
        }

        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        for (int i=10; i<20; i++) {
            executor.execute(new RunnableTask("try to execute task " + i));
        }

        executor.shutdown();
    }

    public IThreadPoolExecutorService getThreadPoolExecutorService() {
        return threadPoolExecutorService;
    }

    public void setThreadPoolExecutorService(IThreadPoolExecutorService threadPoolExecutorService) {
        this.threadPoolExecutorService = threadPoolExecutorService;
    }

    public IThreadPoolMonitorService getThreadPoolMonitorService() {
        return threadPoolMonitorService;
    }

    public void setThreadPoolMonitorService(IThreadPoolMonitorService threadPoolMonitorService) {
        this.threadPoolMonitorService = threadPoolMonitorService;
    }
}
