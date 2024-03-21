package org.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 3; // Maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        // Check if the test method needs to be retried
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true; // Retry the test method
        }
        return false; // Do not retry the test method
    }
}
