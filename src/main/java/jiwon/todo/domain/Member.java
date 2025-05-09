package jiwon.todo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id", unique = true)
    private Long id;

    private String password;

    private String name;

    @OneToMany(mappedBy = "userId")
    private List<Todo> todos = new ArrayList<>();

    // == 연관관계 편의 메서드 ==
    public void addTodo(Todo todo) {
        todos.add(todo);
        todo.setMember(this); // 연관관계 주인도 설정해줌
    }
}
