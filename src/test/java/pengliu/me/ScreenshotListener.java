package pengliu.me;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        // 获取 WebDriver 实例
        Object testInstance = result.getInstance();
        WebDriver driver = ((BaseTestNG) testInstance).getDriver();

        // 如果 WebDriver 实例为空，不截图
        if (driver == null) {
            System.out.println("WebDriver is not initialized, skipping screenshot.");
            return;
        }

        // 获取测试方法名，生成截图文件名
        String methodName = result.getMethod().getMethodName();
        String fileName = "screenshot_" + methodName + "_" + System.currentTimeMillis() + ".png";

        // 截图并保存
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileName);
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 以下为其他未实现的监听器方法（可按需使用）
    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
