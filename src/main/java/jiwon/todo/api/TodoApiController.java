package jiwon.todo.api;

import jakarta.validation.constraints.NotEmpty;
import jiwon.todo.domain.Todo;
import jiwon.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoApiController {
    public final TodoService todoService;

    @GetMapping("/api/todos")
    public Result<List<TodoDto>> todos(){
        List<Todo> todos = todoService.findTodos();
        List<TodoDto> list = todos.stream()
                .map(TodoDto::new)
                .toList();
        return Result.of(list);
    }

    @PostMapping("/api/todos")
    public CreateTodoResponse saveTodo(@RequestBody @Valid CreateTodoRequest request) {

        Todo todo = new Todo(request.getName());
        Long id = todoService.saveTodo(todo);
        return new CreateTodoResponse(id);
    }

    @Data
    @AllArgsConstructor
    public static class Result<T>{
        private T data;

        public static <T> Result<T> of(T data) {
            return new Result<>(data);
        }
    }

    @Data
    public static class TodoDto{
        private Long todoId;
        private String name; // 할 일 이름
        private Boolean isDone; // 완료 여부
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public TodoDto(Todo todo){
            todoId = todo.getId();
            name = todo.getName();
            isDone = todo.getIsDone();
            createdAt = todo.getCreatedAt();
            updatedAt = todo.getUpdatedAt();
        }

    }

    @Data
    public static class CreateTodoRequest{
        private String name;
    }
    @Data
    @AllArgsConstructor
    public static class CreateTodoResponse{
        private Long id;
    }

    @Data
    public static class UpdateTodoRequest{
        private String name;
    }
    @Data
    @AllArgsConstructor
    public static class UpdateTodoResponse {
        private Long id;
        private String name;
    }
}
