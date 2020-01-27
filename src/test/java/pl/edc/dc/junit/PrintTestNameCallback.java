package pl.edc.dc.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@Slf4j
public class PrintTestNameCallback implements BeforeTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        extensionContext.getTestMethod().ifPresent(method -> log.info("Executing test method: {}", method.getName()));
    }
}
