package pl.edc.dc.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

@Slf4j
public class PrintTestNameListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        log.info("Executing test method: {}", iInvokedMethod.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }
}
