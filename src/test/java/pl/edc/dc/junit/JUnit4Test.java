package pl.edc.dc.junit;

import org.junit.Rule;
import org.junit.Test;

public class JUnit4Test {

    @Rule
    public PrintTestNameRule printTestNameRule = new PrintTestNameRule();

    @Test
    public void test() {
    }
}
