package pl.edc.dc.testng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(PrintTestNameListener.class)
@Test
public class TngTest {

    public void test() {
    }
}
