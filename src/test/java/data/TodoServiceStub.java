package data;

import com.javabymj.junit.service.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn swimming",
                "Learn Spring Boot");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
