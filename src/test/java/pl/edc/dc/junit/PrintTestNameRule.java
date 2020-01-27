package pl.edc.dc.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.rules.TestName;
import org.junit.runner.Description;

@Slf4j
public class PrintTestNameRule extends TestName {

    @Override
    protected void starting(Description d) {
        super.starting(d);
        log.info("Executing test method: {}", getMethodName());
    }
}
