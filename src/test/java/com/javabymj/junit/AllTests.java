package com.javabymj.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArraysTest.class,
        BeforeAfterTest.class,
        StringHelperParameterizedTest.class
})
public class AllTests {
}
