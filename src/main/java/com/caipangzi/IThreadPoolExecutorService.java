package com.caipangzi;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/4
 * Time: 09:14
 * 线程池创建接口
 */
public interface IThreadPoolExecutorService {

    public ThreadPoolExecutor createThreadPool();

    public int getCorePoolSize();

    public void setCorePoolSize(int corePoolSize);

    public int getMaxPoolSize();

    public void setMaxPoolSize(int maxPoolSize);

    public long getKeepAliveTime();

    public void setKeepAliveTime(long keepAliveTime);

    public int getQueueCapacity();

    public void setQueueCapacity(int queueCapacity);

    public RejectTaskHandler getRejectTaskHandler();

    public void setRejectTaskHandler(RejectTaskHandler rejectTaskHandler);

}
