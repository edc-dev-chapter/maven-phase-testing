package pl.edc.dc;

import org.junit.experimental.categories.Category;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Category(WipTest.class)
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WipTest {
}
