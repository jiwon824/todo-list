document.addEventListener("DOMContentLoaded", function () {

    function addTodo() {
        const form = document.querySelector("#todo-form");  // 기존 폼 가져오기
        const inputField = form.querySelector("input[name='name']");
        const todoText = inputField.value.trim();

        if (!todoText) {
            alert("할 일을 입력하세요.");
            return;
        }

        form.submit();  // 기존 폼을 제출
    }

    function updateTodo(button) {
        const todoItem = button.closest(".todo-item");
        const todoId = todoItem.getAttribute("data-id");
        const label = todoItem.querySelector(".todo-text");
        const text = label.innerText;

        label.style.display = "none";

        const input = document.createElement("input");
        input.setAttribute("type", "text");
        input.setAttribute("class", "form-control todo-edit-input");
        input.setAttribute("value", text);

        const colDiv = todoItem.querySelector(".col");
        colDiv.appendChild(input);

        const dropdownContainer = todoItem.querySelector(".dropdown");
        dropdownContainer.style.display = "none";

        const saveButton = document.createElement("button");
        saveButton.setAttribute("type", "button");
        saveButton.setAttribute("class", "btn btn-outline-primary");
        saveButton.innerText = "저장";
        saveButton.addEventListener("click", function () {
            saveUpdatedTodo(todoItem, todoId);
        });

        todoItem.appendChild(saveButton);
    }

    function saveUpdatedTodo(todoItem, todoId) {
        const input = todoItem.querySelector(".todo-edit-input");
        const updatedText = input.value.trim();

        if (!updatedText) {
            alert("할 일을 입력하세요.");
            return;
        }

        const form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", `/todos/${todoId}/update`);

        const inputField = document.createElement("input");
        inputField.setAttribute("type", "hidden");
        inputField.setAttribute("name", "name");
        inputField.setAttribute("value", updatedText);
        form.appendChild(inputField);

        document.body.appendChild(form);
        form.submit();
    }

    function deleteTodo(button) {
        const todoItem = button.closest(".todo-item");
        const todoId = todoItem.getAttribute("data-id");

        const form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "/todos/" + todoId + "/delete");

        document.body.appendChild(form);
        form.submit();
    }

    // 전역 함수로 등록하여 HTML에서 사용 가능하게 함
    window.addTodo = addTodo;
    window.updateTodo = updateTodo;
    window.deleteTodo = deleteTodo;
});
