package jiwon.todo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Long id; // PK

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
