package com.caipangzi;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/4
 * Time: 09:30
 * 线程池监控接口
 */
public interface IThreadPoolMonitorService extends Runnable {

    /**
     * 要实现的监控方法
     */
    public void monitorThreadPool();

    public ThreadPoolExecutor getExecutor();

    public void setExecutor(ThreadPoolExecutor executor);
}
