package jiwon.todo.service;

import jiwon.todo.domain.Todo;
import jiwon.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Long saveTodo(Todo todo){
        todoRepository.save(todo);
        return todo.getId();
    }

    @Transactional
    public void updateTodo(Long id, String name, Boolean isDone){
        Todo findTodo = todoRepository.findById(id);
        findTodo.update(name, isDone);
    }

    @Transactional
    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findById(id);
        todoRepository.remove(findTodo);
    }

    public Todo findById(Long id){
        return todoRepository.findById(id);
    }

    public List<Todo> findTodos(){
        return todoRepository.findAll();
    }
}
