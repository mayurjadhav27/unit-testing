package com.javabymj.mockito;

import com.javabymj.junit.service.TodoBusinessImpl;
import com.javabymj.junit.service.TodoService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplInjectMockTest {

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();
    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusiness;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public  void testRetrieveTodosRelatedToSpring_UsingStub(){
        List<String> todos=Arrays.asList("Learn Spring Boot","Learn Spring MVC","Lear Swimming");
        when(todoService.retrieveTodos("dummy")).thenReturn(todos);
        List<String> filteredTodos=todoBusiness.retrieveTodosRelatedToSpring("dummy");
        Assert.assertEquals(2,filteredTodos.size());
    }

    @Test
    public  void testDeleteTodoOtherThanSpring(){
        List<String> todos=Arrays.asList("Learn Spring Boot","Learn Spring MVC","Learn Swimming");
        when(todoService.retrieveTodos("dummy")).thenReturn(todos);
        todoBusiness.deleteTodo("dummy");

        verify(todoService).deleteTodo("Learn Swimming");//alternate way to this line is next line
        then(todoService).should().deleteTodo("Learn Swimming");

        //verify that method is not called
        verify(todoService, never()).deleteTodo("Learn Spring Boot"); //alternate way to this line is next line
        then(todoService).should(never()).deleteTodo("Learn Spring Boot");

        //verify how many times method is called
        verify(todoService,times(1)).deleteTodo("Learn Swimming");
        //check if method is called atLeastOnce
        verify(todoService,atLeastOnce()).deleteTodo("Learn Swimming");
        //check if method is called atLeast Given number of times
        verify(todoService,atLeast(1)).deleteTodo("Learn Swimming");
    }

    @Test
    public  void testDeleteTodoOtherThanSpring_ArgumentCapture(){
        //Declare Argument Captor
        //Define Argument captor on Specific method call
        //capture Argument

        //replace argumetCaptor by @Captor
        //ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
        List<String> todos=Arrays.asList("Learn Spring Boot","Learn Spring MVC","Learn Swimming","learn Trading");
        when(todoService.retrieveTodos("dummy")).thenReturn(todos);
        todoBusiness.deleteTodo("dummy");

       then(todoService).should(times(2)).deleteTodo(argumentCaptor.capture());
       Assert.assertEquals(argumentCaptor.getAllValues().size(),2);
    }

    //spy
    @Test
    public void testSpy(){
        List<String> spyList= spy(ArrayList.class);
        //below add will return true which actual returned value from below operation
        spyList.add("one");
        when(spyList.size()).thenReturn(10);
        //check mocked method on spy
        Assert.assertEquals(10,spyList.size());
        //verify add is called or not
        verify(spyList).add("one");

        List<String> mockList= mock(ArrayList.class);
        when(mockList.size()).thenReturn(10);
        //check mocked method on spy
        Assert.assertEquals(10,mockList.size());
        //this will give default return type as false in below case
        Assert.assertEquals(false,mockList.add("one"));
    }

}
