package com.javabymj.junit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ArraysTest {

    @Test
    public void testArrays(){
        int[] expected={12,15,23,25};
        int[] actual={23,12,25,15};
        Arrays.sort(actual);
//        Assert.assertEquals(expected,actual); Expected :[I@7ca48474  Actual   :[I@337d0578
        Assert.assertArrayEquals(expected,actual);
    }
    //test null pointer exception
    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        int[] arr=null;
        Arrays.sort(arr);
    }

    //test time performance
    @Test(timeout = 100)
    public void testPerformanceForMillionRecords(){
        int[] arr={12,32,4};
        for(int i=0;i<=1000000;i++){
            arr[0]=i;
            Arrays.sort(arr);
        }
    }
}
