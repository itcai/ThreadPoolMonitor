package com.caipangzi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/4
 * Time: 09:22
 * 实现线程池创建接口
 */
public class ThreadPoolExecutorService implements IThreadPoolExecutorService {

    private int corePoolSize;
    private int maxPoolSize;
    private long keepAliveTime;
    private int queueCapacity;

    RejectTaskHandler rejectTaskHandler;

    /**
     * 创建线程池
     * @return
     */
    public ThreadPoolExecutor createThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                getCorePoolSize(),
                getMaxPoolSize(),
                getKeepAliveTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(getQueueCapacity()),
                getRejectTaskHandler()
        );
        return executor;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public RejectTaskHandler getRejectTaskHandler() {
        return rejectTaskHandler;
    }

    public void setRejectTaskHandler(RejectTaskHandler rejectTaskHandler) {
        this.rejectTaskHandler = rejectTaskHandler;
    }
}
