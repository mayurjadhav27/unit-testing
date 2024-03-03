package com.javabymj.junit;

import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeforeAfterTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Invoked before class setup");
    }
    @Before
    public void setUp(){
        System.out.println("Test Before");
    }
    @After
    public void tearDown(){
        System.out.println("Clean up resources or perform teardown tasks after test");
    }
    @Test
    public void test1(){
        System.out.println("Test.....1 executed");
    }
    @Test
    public void test2(){
        System.out.println("Test.....2 executed");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Invoked after class for teardown");
    }
}
