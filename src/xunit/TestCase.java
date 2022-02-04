package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    public String name;

    public TestCase(String name) {
        this.name = name;
    }

    public TestResult run() {
        setUp();

        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        tearDown();
        return new TestResult();
    }

    public void tearDown() {
    }

    public void setUp() {
    }
}
