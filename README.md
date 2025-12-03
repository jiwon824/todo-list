# 📌 Todo List CRUD Project

Spring Boot를 처음 학습하며 진행한 **기본 CRUD 연습 프로젝트**입니다.
할 일(Todo) 데이터를 등록·조회·수정·삭제하는 기능을 구현하며
웹 백엔드의 기본 흐름과 구조를 익히는 데 목적이 있습니다.

복잡한 비즈니스 로직보다는
**Controller → Service → Repository → DB**
로 이어지는 기본 웹 서버 구조를 이해하는 데 집중했습니다.

---

## 🛠 기술 스택

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* MySQL
* Gradle
* Lombok
* Postman(API 테스트)

---

## 📚 주요 기능 (CRUD)

1. Todo 등록(Create)

입력받은 제목·내용으로 새로운 Todo 생성

2. Todo 조회(Read)

전체 Todo 목록 조회

ID 기반 개별 Todo 조회

4. Todo 수정(Update)

등록된 Todo의 내용 수정

4. Todo 삭제(Delete)

ID 기반 삭제 기능 제공

---

## 🗂 프로젝트 구조

```plaintext
src
 └─ main
    ├─ java/jiwon/todo
    │     ├─ api
    │     │     ├─ MemberApiController.java       # 회원 관련 REST API
    │     │     └─ TodoApiController.java         # Todo 관련 REST API
    │     │
    │     ├─ controller
    │     │     ├─ HomeController.java            # 홈 화면 컨트롤러
    │     │     ├─ MemberController.java          # 회원 웹 컨트롤러
    │     │     ├─ MemberForm.java                # 회원 폼 객체
    │     │     └─ TodoForm.java                  # Todo 폼 객체
    │     │
    │     ├─ domain
    │     │     ├─ Member.java                    # 회원 엔티티
    │     │     └─ Todo.java                      # Todo 엔티티
    │     │
    │     ├─ repository
    │     │     ├─ MemberRepository.java          # 회원 JPA Repository
    │     │     └─ TodoRepository.java            # Todo JPA Repository
    │     │
    │     ├─ service
    │     │     ├─ MemberService.java             # 회원 서비스 로직
    │     │     └─ TodoService.java               # Todo 서비스 로직
    │     │
    │     └─ TodoApplication.java                 # Spring Boot 메인 클래스
    │
    └─ resources
          ├─ application.yml                      # DB 및 환경 설정
          └─ templates (선택적으로 존재할 수 있음) # Thymeleaf 템플릿

```

---

## 💡 학습 포인트

1. Spring Boot 기본 흐름 이해

  Controller → Service → Repository → DB로 이어지는 웹 애플리케이션 전반의 구조를 직접 구현하며 이해도를 높였습니다.

3. JPA 기반 CRUD 개발

  간단한 엔티티 설계 후 Spring Data JPA의 기본 CRUD 기능을 적용했습니다.

3.  API 테스트 경험

  Postman으로 각 API를 호출하며 HTTP 요청/응답 구조를 확인하고 테스트했습니다.

4.  Git/GitHub 사용

  개발 과정을 GitHub에 기록하고 브랜치 기반 연습을 진행했습니다.

---

## 📝 개발 과정 블로그 정리

* [CRUD 프로젝트] Todo(1)
  [https://im-your-supporter.tistory.com/entry/CRUD-%EC%97%B0%EC%8A%B5-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo](https://im-your-supporter.tistory.com/entry/CRUD-%EC%97%B0%EC%8A%B5-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo)

* [CRUD 프로젝트] Todo(2) – DB 교체
  [https://im-your-supporter.tistory.com/entry/CRUD-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo2-DB%EA%B5%90%EC%B2%B4](https://im-your-supporter.tistory.com/entry/CRUD-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo2-DB%EA%B5%90%EC%B2%B4)

* [CRUD 프로젝트] Todo(3) – Git 연동
  [https://im-your-supporter.tistory.com/entry/CRUD-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo3-Git-%EC%97%B0%EB%8F%99](https://im-your-supporter.tistory.com/entry/CRUD-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo3-Git-%EC%97%B0%EB%8F%99)

* [CRUD 프로젝트] Todo(4)-1 – 화면 구조 개선(git branch 활용)
  [https://im-your-supporter.tistory.com/entry/CRUD-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo4-%ED%99%94%EB%A9%B4%EA%B5%AC%EC%A1%B0-%EA%B0%9C%EC%84%A0git-branch-%EC%9D%B4%EC%9A%A9-memo-time-tracker-%EC%B6%94%EA%B0%80](https://im-your-supporter.tistory.com/entry/CRUD-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-Todo4-%ED%99%94%EB%A9%B4%EA%B5%AC%EC%A1%B0-%EA%B0%9C%EC%84%A0git-branch-%EC%9D%B4%EC%9A%A9-memo-time-tracker-%EC%B6%94%EA%B0%80)

---

## ✨ 향후 개선하고 싶은 부분

* 간단한 예외 처리 공통화
* DTO 분리 및 구조 개선
* 테스트 코드 추가
* 프론트엔드와의 연동
