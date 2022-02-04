package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    List<TestCase> tests = new ArrayList<>();

    public void add(TestCase test) {
        tests.add(test);
    }

    // 패턴 : connecting parameter?
    public void run(TestResult result) {
        tests.forEach( t -> {
            t.run(result);
        });
    }
}
