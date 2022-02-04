package xunit;

public class xUnitTest {
    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
        new TestCaseTest("testResult").run();
        new TestCaseTest("testFailedResultFormatting").run();
    }
}
