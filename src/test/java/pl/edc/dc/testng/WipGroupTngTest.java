package pl.edc.dc.testng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(PrintTestNameListener.class)
@Test(groups = {"pl.edc.dc.WipTest"})
public class WipGroupTngTest {

    public void wipGroupTest() {
    }
}
