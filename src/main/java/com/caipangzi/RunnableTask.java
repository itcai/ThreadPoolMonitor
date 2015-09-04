package com.caipangzi;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/3
 * Time: 20:28
 * 要执行的任务
 */
public class RunnableTask implements Runnable {

    private static Logger log = Logger.getLogger(RunnableTask.class);

    String taskName;

    public RunnableTask() {
    }

    public RunnableTask(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        try {
            log.debug(this.taskName + " : just begin!");
            Thread.sleep(10000);
            log.debug(this.taskName + " : just completed!");
        } catch (InterruptedException e) {
            log.debug(this.taskName + " : is interrupted!");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getTaskName();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}
