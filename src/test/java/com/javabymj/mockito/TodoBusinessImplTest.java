package com.javabymj.mockito;

import com.javabymj.junit.service.TodoBusinessImpl;
import com.javabymj.junit.service.TodoService;
import data.TodoServiceStub;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TodoBusinessImplTest {
    @Test
    public  void testRetrieveTodosRelatedToSpring_UsingStub(){
        TodoService todoService=new TodoServiceStub();
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoService);
        List<String> filteredTodos=todoBusiness.retrieveTodosRelatedToSpring("mj");
        Assert.assertEquals(2,filteredTodos.size());
    }
}
