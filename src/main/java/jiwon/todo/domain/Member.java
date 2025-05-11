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
    private Long id; // PK

    @Column(unique = true)
    private String loginId; // 사용자가 설정하는 ID(중복x)

    private String password;
    private String name; // 이름 혹은 닉네임

    @Column(unique = true)
    private String email; // 이메일(중복x)

    @OneToMany(mappedBy = "member")
    private List<Todo> todos = new ArrayList<>();


    // == 생성자 ==
    public Member(Long id, String loginId, String password, String name, String email) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    // == 연관관계 편의 메서드 ==
    public void addTodo(Todo todo) {
        todos.add(todo);
        todo.setMember(this); // 연관관계 주인도 설정해줌
    }
}
