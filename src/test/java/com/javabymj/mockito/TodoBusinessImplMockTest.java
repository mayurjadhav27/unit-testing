package com.javabymj.mockito;

import com.javabymj.junit.service.TodoBusinessImpl;
import com.javabymj.junit.service.TodoService;
import data.TodoServiceStub;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
}
