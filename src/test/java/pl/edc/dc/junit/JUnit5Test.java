package pl.edc.dc.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(PrintTestNameCallback.class)
class JUnit5Test {

    @Test
    void test() {
    }
}
