package jiwon.todo.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoForm {

    @NotEmpty(message = "할 일을 입력해주세요")
    private String name;

}
