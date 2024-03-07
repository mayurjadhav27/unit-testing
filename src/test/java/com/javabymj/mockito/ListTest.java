package com.javabymj.mockito;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public  void testListSize(){
        List list=mock(List.class);
        when(list.size()).thenReturn(2);
        Assert.assertEquals(2,list.size());
    }
    @Test
    public  void testListSizeReturnMultipleValues(){
        List list=mock(List.class);
        when(list.size()).thenReturn(2).thenReturn(3);
        Assert.assertEquals(2,list.size());
        Assert.assertEquals(3,list.size());
    }
    @Test
    public  void testGetList(){
        List list=mock(List.class);
        when(list.get(0)).thenReturn(2);
        Assert.assertEquals(2,list.get(0));
        Assert.assertEquals(null,list.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void testRunTimeException(){
        List list=mock(List.class);
        when(list.get(0)).thenThrow(new RuntimeException());
        list.get(0);
    }
}
