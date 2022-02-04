package xunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(TestCaseTest.class);
//        suite.add(new TestCaseTest("testTemplateMethod")); // 초기 junit은 test 메서드명은 앞에 'test'가 붙어있었다. 이를 위해 리플랙션을 활용해 구현해보자.
//        suite.add(new TestCaseTest("testResult"));
//        suite.add(new TestCaseTest("testFailedResultFormatting"));
//        suite.add(new TestCaseTest("testFailedResult"));
//        suite.add(new TestCaseTest("testSuite"));
        return suite; // 2000년대 초반 junit 코드 실제로 이렇게 다 작성 되어 있었음
    }

    public void testTemplateMethod() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    public void testResult() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    public void testFailedResultFormatting() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    public void testFailedResult() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenTest"));

        TestResult result = new TestResult();
        suite.run(result);
        Assert.assertEquals("2 run, 1 failed", result.getSummary());
    }
}
