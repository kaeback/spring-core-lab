# spring-core-lab — 순수 자바로 이해하는 IoC·DI·AOP

교안 「실습: 순수 자바로 이해하는 IoC·DI·AOP」의 예제 프로젝트다.
주제는 **도서 대출과 연체료**이고, 스프링 없이 자바 표준 라이브러리만 쓴다.

- JDK 21, Gradle(래퍼 포함). 의존성은 테스트용 JUnit 5뿐이다.
- 각 단계의 `main`은 IntelliJ에서 `LoanApp`을 열고 ▶ 버튼으로 실행하거나, 터미널에서 아래 태스크로 실행한다.

```bash
./gradlew -q step1          # Windows: gradlew.bat -q step1
./gradlew tasks --group lab # 실행 태스크 목록
./gradlew test              # 연체료 계산·프록시 확인 테스트
```

## 단계와 패키지

모든 패키지는 `com.example.lab` 아래에 있다.

| 교안 | 패키지 | 실행 태스크 | 내용 |
|---|---|---|---|
| 0 도메인 | `domain` | — | `Grade`, `Member`, `Book`, `ReturnReceipt` (모든 단계가 함께 쓴다) |
| 1단계 | `step1` | `step1` | `new`로 짠 첫 버전 — 하루 100원(학생 50원) 정액 |
| 미션 1 해답 | `step1.solution` | `step1Solution` | 학생 회원 추가 |
| 2단계 (앞부분) | `step2a` | `step2a` | 정률·상한 정책으로 바꾸려고 `LoanService`를 직접 수정 |
| 2단계 (뒷부분) | `step2b` + `policy` | `step2b` | `LateFeePolicy` 인터페이스 도입 — 그래도 `new`가 남는다 |
| 3단계 | `step3` | `step3` | DI — 생성자로 정책을 주입받는다 |
| 미션 3 해답 | `step3.solution` | `step3Solution` | `NoLateFeePolicy`를 만들어 바꿔 끼우기 |
| 4단계 | `step4` | `step4` | IoC — `AppConfig`가 객체를 만들고 연결한다 |
| 미션 4 해답 | `step4.solution` | `step4Solution` | 람다로 만든 가짜 정책 주입 |
| 5단계 (앞부분) | `step5a` | `step5a` | 시간 측정 코드를 메서드 안에 직접 넣은 버전 |
| 5단계 (뒷부분) | `step5b` | `step5b` | JDK 동적 프록시(`TimeTraceHandler`)로 시간 측정 분리 |
| 미션 5 해답 | `step5b.solution` | `step5bSolution` | `LogTraceHandler`로 바꿔 끼우기 |

- `policy` 패키지(`LateFeePolicy`, `DailyLateFeePolicy`, `RateLateFeePolicy`)는 2단계 뒷부분부터 끝까지 함께 쓴다.
- 미션은 코드 안의 `TODO [미션 N]` 주석으로 표시했고, 해답은 각 단계의 `solution` 패키지에 있다.
- `spring-example/` 폴더는 4단계 "스프링이라면"에서 보는 참고 코드다. 스프링 의존성이 없으므로 컴파일 대상(`src`)에 넣지 않았다.

## 연체료 정책

| 정책 | 일반 회원 | 학생 회원 |
|---|---|---|
| `DailyLateFeePolicy` (처음) | 하루 100원 | 하루 50원 |
| `RateLateFeePolicy` (변경) | 하루에 정가의 1%, 상한은 정가의 절반 | 일반 회원 금액의 절반 |
