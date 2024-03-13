package com.javabymj.hamcresmatchers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class HamcresMatchersTest {

    @Test
    public void test(){
        List<Integer> list= Arrays.asList(1,2,3,4);
        Assert.assertThat(list, hasSize(4));
        Assert.assertThat("",isEmptyString());
        Integer[] scores={1,2,3};
        Assert.assertThat(scores,arrayContaining(1,2,3));
    }
}
