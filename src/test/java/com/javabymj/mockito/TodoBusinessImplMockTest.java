package com.javabymj.mockito;

import com.javabymj.junit.service.TodoBusinessImpl;
import com.javabymj.junit.service.TodoService;
import data.TodoServiceStub;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {
    @InjectMocks
    TodoBusinessImpl business;



    @Test
    public  void testRetrieveTodosRelatedToSpring_UsingStub(){
        TodoService todoService=mock(TodoService.class);
        List<String> todos=Arrays.asList("Learn Spring Boot","Learn Spring MVC","Lear Swimming");
        when(todoService.retrieveTodos("dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoService);
        List<String> filteredTodos=todoBusiness.retrieveTodosRelatedToSpring("dummy");
        Assert.assertEquals(2,filteredTodos.size());
    }

    @Test
    public  void testDeleteTodoOtherThanSpring(){
        TodoService todoService=mock(TodoService.class);
        List<String> todos=Arrays.asList("Learn Spring Boot","Learn Spring MVC","Learn Swimming");
        when(todoService.retrieveTodos("dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoService);
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

        ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
        TodoService todoService=mock(TodoService.class);
        List<String> todos=Arrays.asList("Learn Spring Boot","Learn Spring MVC","Learn Swimming","learn Trading");
        when(todoService.retrieveTodos("dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoService);
        todoBusiness.deleteTodo("dummy");

       then(todoService).should(times(2)).deleteTodo(argumentCaptor.capture());
       Assert.assertEquals(argumentCaptor.getAllValues().size(),2);
         }
}
