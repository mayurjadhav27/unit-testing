package com.javabymj.junit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class StringHelperTest {

    StringHelper stringHelper=new StringHelper();
    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        Assert.assertEquals("CC", stringHelper.truncateAInFirst2Positions("AACC"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions1() {
        Assert.assertEquals("CD",stringHelper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_StringWithoutA() {
        Assert.assertEquals("CDEF",stringHelper.truncateAInFirst2Positions("CDEF"));
    }

    //ABCD->false, ABAB->true, AB->true, A->false

    @Test
    public void testAreFirstAndLastTwoCharactersTheSameBasicNegativeScenario(){
        Assert.assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
        Assert.assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_AB(){
        Assert.assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_oneCharString(){
        Assert.assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("a"));
    }

}
