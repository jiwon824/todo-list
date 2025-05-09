package jiwon.todo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id @GeneratedValue
    @Column(name = "todo_id")
    private Long id; // PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // FK
    private Member member;

    private String name; // 할 일 이름
    private Boolean isDone; // 완료 여부
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Todo(String name) {
        this.name = name;
        this.isDone = false;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public void update(String name, Boolean isDone){
        this.name = name;
        this.isDone = isDone;
        updatedAt = LocalDateTime.now();
    }
}
