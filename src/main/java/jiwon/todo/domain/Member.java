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

    private List<Todo> todos = new ArrayList<>();
}
