package com.cdhotel.common;


import org.slf4j.Logger;

public class LoggerUtils {
    public static synchronized void debug(Logger logger, String msg){
        logger.debug(msg);
    }
    public static synchronized void info(Logger logger, String msg){
        logger.info(msg);
    }
    public static synchronized void error(Logger logger, String msg){
        logger.error(msg);
    }
    public static synchronized void error(Logger logger, Throwable e){
        logger.error(String.valueOf(e.fillInStackTrace()));
        StackTraceElement[] trace = e.getStackTrace();
        for (int i = 0; i < trace.length; i++) {
            logger.error("\tat :" + trace[i]);
        }
    }
}
