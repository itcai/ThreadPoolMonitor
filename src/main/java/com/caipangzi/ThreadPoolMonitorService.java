package com.caipangzi;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/4
 * Time: 09:39
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPoolMonitorService implements IThreadPoolMonitorService {

    private static Logger log = Logger.getLogger(ThreadPoolMonitorService.class);

    ThreadPoolExecutor executor;

    private long monitorPeriod;

    public void monitorThreadPool() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("CurrentPoolSize : ").append(executor.getPoolSize());
        strBuff.append(" - CorePoolSize : ").append(executor.getCorePoolSize());
        strBuff.append(" - MaximumPoolSize : ").append(executor.getMaximumPoolSize());
        strBuff.append(" - ActiveTaskCount : ").append(executor.getActiveCount());
        strBuff.append(" - CompletedTaskCount : ").append(executor.getCompletedTaskCount());
        strBuff.append(" - TotalTaskCount : ").append(executor.getTaskCount());
        strBuff.append(" - isTerminated : ").append(executor.isTerminated());

        log.debug(strBuff.toString());
    }

    public void run() {
        try {
            while (true) {
                monitorThreadPool();
                Thread.sleep(monitorPeriod*1000);
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public long getMonitorPeriod() {
        return monitorPeriod;
    }

    public void setMonitorPeriod(long monitorPeriod) {
        this.monitorPeriod = monitorPeriod;
    }
}
