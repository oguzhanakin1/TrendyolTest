package com.testTrendyol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main
{
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args)
    {
        logger.info("Running tests...");
        Result result = JUnitCore.runClasses(TestByOrder.class);
        for(Failure failure : result.getFailures())
        {
            logger.error("Test failed:");
            logger.error(failure.toString());
        }
        if(result.wasSuccessful())
        {
            logger.info("All tests were successful");
        }
    }
}
