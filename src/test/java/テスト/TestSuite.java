package テスト;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SubTest.class,
        SubTest2.class
})
public class TestSuite {
}
