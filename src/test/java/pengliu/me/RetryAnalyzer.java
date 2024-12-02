package pengliu.me;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;       // 当前重试次数
    private static final int maxRetryCount = 3; // 最大重试次数

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() + " for the " + retryCount + " time.");
            return true; // 返回 true 表示重试
        }
        return false; // 超过最大重试次数，停止重试
    }
}
