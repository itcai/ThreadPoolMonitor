package com.caipangzi;

import org.apache.log4j.Logger;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/4
 * Time: 09:07
 * 处理没空闲线程时被拒绝的任务
 */
public class RejectTaskHandler implements RejectedExecutionHandler {

    private static Logger log = Logger.getLogger(RejectTaskHandler.class);

    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.debug(r.toString() + " : is rejected!");
    }
}
