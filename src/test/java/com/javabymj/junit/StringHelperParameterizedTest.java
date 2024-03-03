package com.javabymj.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper stringHelper=new StringHelper();

    private String input;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    private String expectedOutput;

    @Parameterized.Parameters
    public static Collection<String[]> testConditions(){
        String[][] expectedOutputs={
                {"AACD","CD"},
                {"ACD","CD"}
        };
        return Arrays.asList(expectedOutputs);
    }
    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        Assert.assertEquals(expectedOutput, stringHelper.truncateAInFirst2Positions(input));
    }

//    @Test
//    public void testTruncateAInFirst2Positions_AInFirst2Positions1() {
//        Assert.assertEquals("CD",stringHelper.truncateAInFirst2Positions("ACD"));
//    }
//
//    @Test
//    public void testTruncateAInFirst2Positions_StringWithoutA() {
//        Assert.assertEquals("CDEF",stringHelper.truncateAInFirst2Positions("CDEF"));
//    }
//
//    //ABCD->false, ABAB->true, AB->true, A->false
//
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSameBasicNegativeScenario(){
//        Assert.assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
//    }
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
//        Assert.assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
//    }
//
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSame_AB(){
//        Assert.assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
//    }
//
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSame_oneCharString(){
//        Assert.assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("a"));
//    }

}
