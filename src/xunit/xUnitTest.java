package xunit;

public class xUnitTest {
    public static void main(String[] args) {
        TestSuite suite = TestCaseTest.suite();
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.getSummary());
    }
}
