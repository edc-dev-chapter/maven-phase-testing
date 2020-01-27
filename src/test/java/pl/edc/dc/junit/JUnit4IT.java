package pl.edc.dc.junit;

import org.junit.Rule;
import org.junit.Test;

public class JUnit4IT {

    @Rule
    public PrintTestNameRule printTestNameRule = new PrintTestNameRule();

    @Test
    public void iT() {
    }
}
