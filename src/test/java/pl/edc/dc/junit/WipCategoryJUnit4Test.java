package pl.edc.dc.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pl.edc.dc.WipTest;

@Category(WipTest.class)
public class WipCategoryJUnit4Test {

    @Rule
    public PrintTestNameRule printTestNameRule = new PrintTestNameRule();

    @Test
    public void wipCategoryTest() {
    }
}
