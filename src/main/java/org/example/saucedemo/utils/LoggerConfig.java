package org.example.saucedemo.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerConfig {
    public static void logInfo(Class<?> className, String message) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.info(message);
    }
}
