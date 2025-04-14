package jiwon.todo.repository;

import jakarta.persistence.EntityManager;
import jiwon.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final EntityManager em;

    public void save(Todo todo){
        em.persist(todo);
    }

    public void remove(Todo todo){
        em.remove(todo);
    }

    public Todo findById(Long id){
        return em.find(Todo.class, id);
    }

    public List<Todo> findAll(){
        return em.createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }
}
