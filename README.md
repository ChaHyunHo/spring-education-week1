## Spring education Week1

#### tag0

## 📚 목차

- [1일차](#tag1)
- [2일차](#tag2)
- [3일차](#tag3)
- [4일차](#tag4)

---

#### tag1

#### 1. 왜 스프링일까?

스프링 프레임워크는 자바(Java) 기반의 애플리케이션을 개발하는 데 필요한 거의 모든 것을 지원하는 오픈소스 프레임워크입니다. 단순히 웹 개발뿐만 아니라, 데이터 처리, 보안,
배치(batch) 작업 등 기업 환경의 복잡한 시스템을 구축하는 데 필요한 포괄적인 프로그래밍 및 설정 모델을 제공합니다.

스프링의 핵심 철학은 "좋은 객체 지향 설계"를 돕는 것입니다. 복잡하고 무거웠던 과거의 자바 개발 방식(특히 EJB)을 비판하며, 개발자들이 순수한 자바 객체(POJO)를 사용해
비즈니스 로직에만 집중할 수 있도록 도와줍니다.

#### POJO(Plain Old Java Object)

**POJO**는 말 그대로 "평범한 옛날 자바 객체"를 의미합니다.

과거의 **EJB와 같은 특정 기술 프레임워크에 종속된 객체들은 해당 프레임워크의 특정 클래스를 상속(`extends`)하거나 인터페이스를 구현(`implements`)해야만
했습니다**. 이로 인해 코드가 프레임워크에 심하게 종속되고, 테스트가 어려워지는 문제가 있었습니다.

**POJO**는 이러한 종속성이 없는, 순수 자바 문법으로만 만들어진 객체입니다.

```
// 이것이 바로 POJO입니다.
// 특정 프레임워크의 클래스를 상속하거나 인터페이스를 구현하지 않았습니다.
public class Member {
    private String name;
    private int age;

    // Getters and Setters...
}
```

스프링의 위대함은 바로 이 POJO를 기반으로 동작한다는 점입니다. 스프링은 POJO 객체를 가져다가 IoC 컨테이너에 등록하고, AOP를 적용하는 등 강력한 기능을 부여합니다.
개발자는 프레임워크가 아닌, 순수한 비즈니스 로직을 담은 POJO에만 집중하면 됩니다.

#### 스프링의 역사: 고통에서 탄생한 혁신

- **~2000년대 초반 (EJB의 시대):** 기업용 자바 개발의 표준은 **EJB(Enterprise JavaBeans)**였습니다. EJB는 강력한 기능을 제공했지만, 너무
  복잡하고, 무거웠으며, 비싼 WAS(Web Application Server)를 필요로 했습니다. 또한, **코드가 EJB 프레임워크에 심하게 종속되는 문제**가 있었습니다.
- **2002년 (새로운 시대의 서막):** 개발자 **로드 존슨(Rod Johnson)**이
  `Expert One-on-One J2EE Design and Development`라는 책을 출간합니다. 그는 이 책에서 EJB의 문제점을 신랄하게 비판하고, POJO와
  DI를 기반으로 한 더 가볍고 단순한 프레임워크의 필요성을 역설했습니다. 이 책에 담긴 3만 줄의 코드가 바로 **스프링 프레임워크의 시작**이었습니다.
- **2004년 (스프링 1.0 출시):** EJB의 대안으로 공식 출시되며 폭발적인 인기를 얻기 시작합니다.
- **2010년대 (스프링 부트의 등장):** 스프링 프레임워크 자체도 설정이 복잡하다는 의견이 많아졌습니다. 이를 해결하기 위해 **스프링 부트(Spring Boot)**가
  등장했습니다. **스프링 부트는 "Convention over Configuration(설정보다 관례)"** 철학을 바탕으로, 개발자가 복잡한 설정을 하지 않아도 최소한의
  설정으로 빠르게 애플리케이션을 실행할 수 있도록 도와줍니다. 오늘날 대부분의 스프링 프로젝트는 스프링 부트를 기반으로 시작합니다.

#### 스프링의 3대 핵심 특징

- **IoC (Inversion of Control) / DI (Dependency Injection): 제어의 역전 / 의존성 주입**
    - **과거:** 개발자가 직접 객체를 생성하고 의존성을 연결했습니다. (예: `Controller`가 `new Service()`를 직접 생성)
    - **스프링:** 객체의 생성과 생명주기 관리를 스프링 컨테이너가 대신해 줍니다. 개발자는 필요한 객체를 선언만 하면, 스프링이 알아서 주입(Injection)해 줍니다.
    - "레고 블록"을 조립할 때, 필요한 블록을 직접 찾는 것이 아니라, "레고 마스터(스프링 컨테이너)"에게 "이런 모양의 블록이 필요해!"라고 요청하면 알아서 가져다주는
      것과 같습니다. 이로 인해 부품(객체) 간의 결합도(coupling)가 낮아지고, 유연하고 확장 가능한 구조가 됩니다.
- **AOP (Aspect-Oriented Programming): 관점 지향 프로그래밍**
    - 애플리케이션 전반에 걸쳐 공통적으로 적용되는 기능(예: 로깅, 보안, 트랜잭션)을 비즈니스 로직과 분리하여 모듈화하는 기술입니다.
    - 메인 비즈니스 코드에는 영향을 주지 않으면서, 필요한 부분에 공통 기능을 '끼워 넣는' 방식으로 동작합니다.
- **PSA (Portable Service Abstraction): 일관된 서비스 추상화**
    - 데이터베이스 접근 방식(JPA, JDBC 등), 트랜잭션 처리 등 다양한 기술 구현체들을 스프링이 제공하는 일관된 방식으로 사용할 수 있도록 돕습니다.
    - 덕분에 개발자는 기술이 바뀌더라도 코드를 거의 수정하지 않고 기술을 교체할 수 있습니다.

#### 톰캣, 서블릿, 그리고 스프링 컨테이너의 구조

우리가 스프링 부트로 웹 애플리케이션을 실행하면, 내부에서는 다음과 같은 구조로 요청을 처리합니다.

```
// 요청의 흐름 
Api Request → Tomcat → Servlet(DispatcherServlet) → Spring Container(Controller)
```

1. **톰캣 (Tomcat) - 웹 서버 & 서블릿 컨테이너**
    - 스프링 부트는 **내장 톰캣(Embedded Tomcat)**을 가지고 있습니다.
    - **역할:** 클라이언트(웹 브라우저)로부터 오는 **HTTP 요청을 가장 먼저 받는 관문**입니다. 마치 건물의 "안내 데스크"와 같습니다.
    - 톰캣은 들어온 요청을 분석하여, 이 요청을 처리할 수 있는 애플리케이션(서블릿)에게 전달합니다.

1. **서블릿 (Servlet) - DispatcherServlet**
    - **역할:** 톰캣으로부터 요청을 넘겨받는 **스프링의 중앙 통제실** 또는 "교통 경찰"입니다.
    - 스프링 웹 애플리케이션에서는 모든 요청이 일단 `DispatcherServlet`이라는 단 하나의 서블릿으로 모입니다.
    - `DispatcherServlet`은 요청 URL(예: `/members/1`)을 보고, 이 요청을 처리할 담당자(Controller)가 누구인지 찾아주는 역할을
      합니다. 실제 로직을 처리하지 않고, 적절한 곳에 **요청을 위임(dispatch)**합니다.

1. **스프링 컨테이너 (Spring Container) - ApplicationContext**
    - **역할:** 스프링의 **핵심 엔진**이자 **POJO 객체들의 공장 겸 관리소**입니다.
    - `@Controller`, `@Service`, `@Repository` 등 스프링이 관리하는 모든 객체(**Bean**)들이 이곳에 등록되어 있습니다.
    - `DispatcherServlet`이 "이 URL 요청 누가 처리해?"라고 물으면, 스프링 컨테이너는 등록된 Bean 중에서 적절한 `Controller`와 그 안의
      메서드를 찾아 연결해 줍니다.
    - 이후 `Controller`는 비즈니스 로직 처리를 `Service`에 위임하고, `Service`는 데이터 처리를 `Repository`에 위임하는 식으로 작업이
      연쇄적으로 일어납니다. 이 모든 객체 간의 관계(의존성)는 스프링 컨테이너가 관리하고 연결(주입)해 줍니다.

결론적으로, **톰캣**이 요청을 받고, 스프링의 `DispatcherServlet`이 요청을 분류하며, 실제 작업은 **스프링 컨테이너**가 관리하는 여러 **Bean(POJO
객체)**들이 협력하여 처리하는 구조입니다. 이 구조 덕분에 개발자는 비즈니스 로직에만 집중할 수 있습니다.

**잠깐, 서블릿(Servlet)이란 무엇일까요?**

앞서 `DispatcherServlet`이라는 용어가 등장했는데, 여기서 서블릿(Servlet)이란 무엇인지 짚고 넘어가겠습니다.

- **서블릿(Servlet)은** 서버 측에서 실행되는 작은 자바 프로그램을 의미합니다.
  (Server + Applet의 합성어)

과거에는 클라이언트의 요청에 따라 웹 페이지의 내용이 바뀌어야 할 때마다 새로운 HTML 파일을 일일이 만들어야 했습니다. 이는 매우 비효율적이었습니다.

서블릿은 이러한 **정적인(static) 웹의 한계를 극복**하기 위해 등장했습니다.

**서블릿의 핵심 역할:**

1. **동적(Dynamic) 웹 페이지 생성:**
    - 서블릿은 자바 코드를 통해 동적으로 HTML을 생성할 수 있습니다.
    - 예를 들어, 사용자의 요청에 따라 데이터베이스에서 정보를 가져와 다른 내용의 HTML 페이지를 만들어 응답할 수 있습니다. (예: "홍길동님, 환영합니다!" vs "
      이순신님, 환영합니다!")
2. **클라이언트 요청 처리:**
    - 클라이언트(웹 브라우저)가 보낸 `GET`, `POST`와 같은 HTTP 요청을 읽고, 그에 맞는 비즈니스 로직을 수행합니다.

**즉, 서블릿은 클라이언트의 요청을 받아 자바 코드로 비즈니스 로직을 처리하고, 그 결과를 동적인 HTML로 만들어 클라이언트에게 응답해주는 기술입니다.**

**스프링과 서블릿의 관계:**

스프링 프레임워크가 등장하기 전에는 개발자들이 여러 개의 서블릿을 직접 만들고, 각 URL 요청을 어떤 서블릿이 처리할지 `web.xml`이라는 파일에 일일이 설정해야 했습니다.

하지만 스프링에서는 **`DispatcherServlet`**이라는 **단 하나의 서블릿**이 모든 요청을 **대표**로 받습니다. 그리고 실제 작업은
`DispatcherServlet`이 스프링 컨테이너에 있는 컨트롤러(Controller)에게 위임하는 방식으로 동작합니다.

덕분에 개발자는 서블릿을 직접 구현하는 번거로움 없이, 컨트롤러 로직 개발에만 집중할 수 있게 되었습니다.

#### Spring Boot 프로젝트 생성하기

### **OpenJDK 17 설치**

스프링 부트 3.x 버전을 사용하려면 Java 17 이상이 필요합니다. 아래 링크를 통해 **OpenJDK 17**을 설치해 주세요.

- **Windows**: https://jdk.java.net/archive/
    - 압축 해제 후, 시스템 환경 변수에 `JAVA_HOME`을 설정하고 `Path`에 bin 디렉토리를 추가해야 합니다.
- **macOS (Homebrew 사용)**:

```
brew install openjdk@17
```

#### Spring Initializr로 프로젝트 생성

**Spring Initializr([https://start.spring.io](https://start.spring.io/))**는 스프링 프로젝트의 뼈대를 손쉽게 만들어주는
웹 도구입니다.

아래와 같이 프로젝트 설정을 구성하고, 필요한 의존성(Dependencies)을 추가합니다.

- **Project**: **Gradle - Groovy**
- **Language**: **Java**
- **Spring Boot**: **3.x.x** 버전 중 최신 안정 버전 선택
- **Project Metadata**:
    - `Group`: `com.example` (보통 회사 도메인 역순)
    - `Artifact`: `demo` (프로젝트 이름)
- **Packaging**: **Jar**
- **Java**: **17**

### **Dependencies 추가**

`ADD DEPENDENCIES...` 버튼을 눌러 아래 라이브러리들을 검색하고 추가합니다.

- **Spring Web**: 웹 애플리케이션 및 RESTful API 개발에 필요한 핵심 라이브러리. (내장 톰캣 포함)
- **Spring Data JPA**: SQL 없이 객체(Entity) 중심으로 데이터베이스를 다룰 수 있게 해주는 ORM 기술.
- **MySQL Driver**: MySQL 데이터베이스에 연결하기 위한 드라이버.
- **Lombok**: `@Getter`, `@Setter`, 생성자 등 반복적인 자바 코드를 어노테이션으로 자동 생성해 주는 라이브-러리.
- **Spring Boot DevTools**: 코드 변경 시 애플리케이션이 자동으로 재시작(Live Reload)되도록 하여 개발 편의성을 높여줌.
- **Spring Boot Actuator**: 애플리케이션의 상태 모니터링 및 관리를 위한 기능 제공.

설정이 완료되면 `GENERATE` 버튼을 눌러 프로젝트 압축 파일을 다운로드하고, 사용하는 IDE(IntelliJ, Eclipse 등)에서 프로젝트를 열어주세요.

#### 디렉토리 구조 예시

```
src
└── main
    ├── java
    │   └── com.example.demo
    │       ├── domain               # 📌 도메인별 패키지
    │       │   └── member
    │       │       ├── controller   # Member 관련 HTTP 요청 처리 (API 엔드포인트)
    │       │       ├── service      # Member 관련 비즈니스 로직 구현
    │       │       ├── dto          # Member 관련 데이터 전송 객체 (Request/Response)
    │       │       ├── entity       # Member 데이터베이스 테이블과 매핑되는 객체
    │       │       └── repository   # Member 데이터베이스 접근 로직 (JPA 인터페이스)
    │       │
    │       ├── common               # 📂 여러 도메인에서 공통으로 사용하는 코드
    │       │   └── util             # 유틸리티 클래스 (e.g., 날짜, 암호화 등)
    │       │
    │       └── global               # 🌍 애플리케이션 전역에 적용되는 코드
    │           └── config           # 각종 설정 클래스 (e.g., SecurityConfig)
    │
    └── resources
        ├── db/migration/            # DB 마이그레이션 스크립트 (Flyway, Liquibase)
        ├── application.yml          # 애플리케이션 주요 설정 파일
        └── static/                  # CSS, JS, 이미지 등 정적 리소스
```

**패키지 설명**

- **domain**: 애플리케이션의 핵심 비즈니스 로직이 담기는 곳입니다. **회원(Member), 주문(Order), 상품(Product) 등 주요 기능(도메인) 단위로
  패키지를 분리**하여 코드를 관리합니다. 이렇게 하면 특정 기능과 관련된 코드를 쉽게 찾을 수 있고, 기능 간의 의존성을 명확하게 파악할 수 있습니다.
- **common**: 특정 도메인에 종속되지 않고, **여러 도메인에서 공통으로 사용되는 유틸리티성 코드**를 모아두는 패키지입니다.
- **global**: 애플리케이션의 **전반적인 동작에 영향을 미치는 설정 코드**를 모아두는 패키지입니다. 보안 설정, CORS 설정, 로깅 설정 등이 여기에 해당됩니다.

### YAML과 Properties: 스프링 부트 설정 파일 이해하기

스프링 부트에서는 애플리케이션의 다양한 설정을 외부 파일로 분리하여 관리합니다. 이때 가장 널리 사용되는 두 가지 파일 형식이 바로 `.properties`와 `.yml` 입니다.
두 파일 모두 동일한 설정을 할 수 있지만, 작성 방식과 구조에서 차이가 있습니다.

**`.properties` 파일**

`Properties` 파일은 자바에서 전통적으로 사용해 온 **`key = value`** 형식의 설정 파일입니다.

- **형식**: `key`와 `value`가 등호(`=`)로 연결된 단순한 텍스트입니다.
- **구조**: 계층 구조를 표현하기 위해 `key`에 점(`.`)을 사용합니다.
- **장점**: 형식이 매우 단순하여 이해하기 쉽고, 예전부터 널리 사용되어 익숙합니다.
- **단점**: 계층 구조가 깊어질수록 `spring.datasource.url`처럼 상위 `key`가 반복적으로 등장하여 가독성이 떨어지고 파일이 길어질 수 있습니다.

작성 예시 (application.properties)

```
# 데이터베이스 설정
spring.datasource.url=jdbc:mysql://localhost:3306/spring_db
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA 설정
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# 서버 포트 설정
server.port=8080
```

**`.yml` (또는 `.yaml`) 파일**

**YAML**(YAML Ain't Markup Language)은 '사람이 쉽게 읽을 수 있는' 데이터 직렬화 형식입니다. **들여쓰기(indentation)**를 사용하여
데이터의 계층 구조를 표현하는 것이 가장 큰 특징입니다.

- **형식**: `key: value` 형식이며, 콜론(`:`) 뒤에 반드시 공백이 하나 있어야 합니다.
- **구조**: **들여쓰기(스페이스 2칸 권장)**로 부모-자식 관계의 계층 구조를 표현합니다.
- **장점**:
    - 상위 `key`의 중복 작성이 없어 코드가 간결하고 깔끔합니다.
    - 데이터 구조가 한눈에 파악되어 가독성이 매우 뛰어납니다.
    - 리스트(배열) 표현이 용이합니다.
- **단점**: 들여쓰기에 매우 민감하여, 스페이스 한 칸 차이로도 설정이 제대로 읽히지 않는 에러가 발생할 수 있습니다.

작성 예시 (application.yml)

```
# .properties 예시와 동일한 설정입니다.
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/spring_db
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect

server:
  port: 8080
```

spring이라는 부모 key 아래에 datasource와 jpa가 자식으로 포함된 구조가 명확하게 보입니다.

**비교 및 요약: 어떤 것을 사용해야 할까?**

| **구분**  | **.properties**    | **.yml**                    |
|---------|--------------------|-----------------------------|
| **형식**  | `key=value`        | `key: value` (들여쓰기 기반)      |
| **구조**  | 점(.)으로 구분하는 평면적 구조 | 들여쓰기를 이용한 계층적 구조            |
| **가독성** | 설정이 길어지면 떨어짐       | 구조 파악이 쉬워 가독성이 높음           |
| **장점**  | 단순하고 직관적, 익숙함      | 간결함, 뛰어난 가독성, 구조적 데이터 표현 용이 |
| **단점**  | 키 중복으로 인한 번거로움     | 들여쓰기 실수에 매우 민감함             |

기능적으로 두 파일은 완전히 동일한 역할을 수행합니다. 어떤 것을 선택할지는 개인의 취향이나 팀의 컨벤션에 따릅니다.

하지만 **최근 스프링 부트 개발 트렌드는 `.yml`을 더 선호하는 추세**입니다. 복잡한 설정도 한눈에 파악할 수 있는 가독성과 간결함이라는 장점이 매우 크기 때문입니다.

스프링 부트는 두 형식 모두 완벽하게 지원하므로, 프로젝트의 특성과 팀의 스타일에 맞는 것을 선택하여 사용하면 됩니다.

## **3. MySQL 환경 설정**

로컬 머신에 직접 MySQL을 설치하는 대신, **Docker**를 사용하여 격리되고 일관된 데이터베이스 환경을 구성합니다.

### Docker를 이용한 MySQL 컨테이너 실행

1. **Docker 설치**
    - 아직 Docker가 설치되지 않았다면 아래 공식 사이트에서 자신의 운영체제에 맞게 설치합니다.
    - **설치**: [**https://www.docker.com/products/docker-desktop/
      **](https://www.docker.com/products/docker-desktop/)
2. **MySQL 컨테이너 실행**Bash
    - 터미널(명령 프롬프트)을 열고 아래 명령어를 입력하여 MySQL 8.0 버전의 컨테이너를 실행합니다.

    ```bash
    docker run --name spring-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=spring_db -d mysql:8.0
    ```

   **명령어 옵션 설명:**

    - `-name spring-mysql`: 컨테이너의 이름을 `spring-mysql`로 지정합니다.
    - `p 3306:3306`: 로컬 머신의 3306번 포트와 컨테이너의 3306번 포트를 연결합니다.
    - `e MYSQL_ROOT_PASSWORD=root`: MySQL의 root 계정 비밀번호를 `root`로 설정합니다.
    - `e MYSQL_DATABASE=spring_db`: 컨테이너 생성 시 `spring_db`라는 이름의 데이터베이스를 미리 생성합니다.
    - `d`: 컨테이너를 백그라운드에서 실행합니다.

### application.yml 파일 설정

프로젝트의 `src/main/resources/application.yml` 파일을 열고, 위에서 생성한 MySQL 컨테이너에 접속하도록 아래와 같이 설정합니다.

```yaml
spring:
  # 데이터베이스 연결 설정
  datasource:
    url: jdbc:mysql://localhost:3306/spring_db?useSSL=false&allowPublicKeyRetrieval=true
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver

  # JPA 및 Hibernate 설정
  jpa:
    hibernate:
      # ddl-auto: 애플리케이션 실행 시 스키마(테이블) 처리 전략
      # none: 아무 작업도 하지 않음 (운영 환경 추천)
      # create: 기존 테이블 삭제 후 다시 생성
      # update: 변경된 부분만 반영
      ddl-auto: none
    properties:
      hibernate:
        # MySQL 8 버전에 맞는 Dialect(방언) 설정
        dialect: org.hibernate.dialect.MySQL8Dialect

  # 로깅 레벨 설정
  logging:
    level:
      # Hibernate가 실행하는 SQL 쿼리를 DEBUG 레벨로 로그에 출력
      org.hibernate.SQL: DEBUG

# 내장 웹 서버 설정
server:
  port: 8080
```

이제 스프링 부트 애플리케이션을 실행하면, Docker로 실행 중인 MySQL 데이터베이스에 자동으로 연결됩니다.

## **4. 주요 라이브러리 설정 모음**

### 🚀 Undertow: 경량 웹 서버로 교체하기

**Undertow**는 가볍고 성능이 뛰어난 웹 서버입니다. 기본 내장 웹 서버인 Tomcat보다 적은 리소스를 사용하면서 높은 요청 처리량을 제공하여 고성능이 요구되는 환경에
적합합니다.

**1. `build.gradle` 의존성 수정**

기존 `spring-boot-starter-web`에서 Tomcat을 제외하고, `spring-boot-starter-undertow`를 추가합니다.

```groovy
dependencies {
    // 기존 Tomcat 의존성 제외
    implementation('org.springframework.boot:spring-boot-starter-web') {
        exclude group: 'org.springframework.boot', module: 'spring-boot-starter-tomcat'
    }
    // Undertow 의존성 추가
    implementation 'org.springframework.boot:spring-boot-starter-undertow'
}
```

### Swagger: API 문서 자동화

**Swagger(Springdoc)**는 개발한 REST API의 명세를 자동으로 생성하고, 웹 UI를 통해 API를 직접 테스트해 볼 수 있는 강력한 문서화 도구입니다.

**1. `build.gradle` 의존성 추가**

```groovy
dependencies {
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0'
}
```

**2. Swagger 설정 클래스 작성 (JWT 인증 추가)**

다음은 Swagger UI에서 **JWT(Bearer Token)** 인증을 사용할 수 있도록 설정하는 예시입니다.

```java
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(title = "My API Docs", description = "API 명세서", version = "v1")
)
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    String jwtSchemeName = "jwtAuth";
    SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
    Components components = new Components()
        .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
            .name(jwtSchemeName)
            .type(SecurityScheme.Type.HTTP) // HTTP 방식
            .scheme("bearer") // bearer 토큰 방식
            .bearerFormat("JWT")); // 토큰 형식

    return new OpenAPI()
        .addSecurityItem(securityRequirement)
        .components(components);
  }
}
```

3. application.yml 설정 추가

```yaml
# Swagger UI 설정 (Springdoc)
springdoc:
  swagger-ui:
    enabled: true
```

**4. Swagger UI 접속**

애플리케이션 실행 후 아래 주소로 접속하여 API 문서를 확인합니다.

- **URL**: `http://localhost:8080/swagger-ui/index.html`

### Flyway: 데이터베이스 스키마 버전 관리

**Flyway**는 데이터베이스의 스키마 변경 이력을 코드로 관리하고, 애플리케이션 실행 시 정해진 순서에 따라 자동으로 DB에 반영(마이그레이션)해주는 도구입니다. 이를 통해
팀원들과 DB 형상을 일관되게 유지할 수 있습니다.

**1. `build.gradle` 의존성 추가**

```
dependencies {
    implementation 'org.flywaydb:flyway-core'
    implementation 'org.flywaydb:flyway-mysql'
}
```

**2. 마이그레이션 SQL 파일 작성**

Flyway는 **`V<버전>__<설명>.sql`** 형식의 파일명을 규칙으로 사용합니다. 파일은 `src/main/resources/db/migration` 경로에 위치해야
합니다.

- **파일 경로 및 이름**: `src/main/resources/db/migration/V1__init_table.sql`

```sql
CREATE TABLE example
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);
```

3. application.yml 설정 추가

```yaml
spring:
  flyway:
    enabled: true # Flyway 활성화
    # 마이그레이션 파일 위치 지정 (기본값)
    locations: classpath:db/migration
```

이제 애플리케이션을 실행하면 Flyway가 SQL 파일을 읽어 데이터베이스에 자동으로 테이블을 생성합니다.

### MapStruct: 객체 매핑 자동화

**MapStruct**는 **DTO(Data Transfer Object)와 Entity 간의 변환 코드**를 자동으로 생성해주는 라이브러리입니다. 반복적인 매핑 코드를 직접
작성할 필요 없이, 간단한 인터페이스 정의만으로 빠르고 타입-안전(type-safe)한 변환 로직을 만들어줍니다.

**1. `build.gradle` 의존성 추가**

`mapstruct` 라이브러리와 컴파일 시점에 코드를 생성해 줄 `mapstruct-processor`를 함께 추가합니다.

```groovy
dependencies {
    implementation 'org.mapstruct:mapstruct:1.5.5.Final'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'
}
```

**2. Mapper 인터페이스 작성 예제**

변환 규칙을 정의할 인터페이스를 생성합니다.

```java
// TODO: UserEntity, UserDto 클래스 생성 이후 실습 예정

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // MapStruct가 생성할 구현체를 스프링 Bean으로 등록
public interface UserMapper {

  // 필드명이 다를 경우 @Mapping으로 직접 지정
  @Mapping(source = "email", target = "emailAddress")
  UserDto toDto(UserEntity entity);

  // 필드명이 같다면 별도 매핑 없이 자동으로 변환
  UserEntity toEntity(UserDto dto);
}
```

- `@Mapper(componentModel = "spring")`: 컴파일 시점에 MapStruct가 이 인터페이스의 구현체를 자동으로 생성하며, 이를 스프링 컨테이너에 *
  *Bean으로 등록**해줍니다. 덕분에 다른 서비스 클래스에서 `@Autowired`로 주입하여 사용할 수 있습니다.
- `@Mapping(source = "...", target = "...")`: `UserEntity`의 `email` 필드를 `UserDto`의 `emailAddress`
  필드로 매핑하도록 지정합니다. 필드명이 동일한 경우에는 이 어노테이션을 생략해도 자동으로 매핑됩니다.

### 최종 `build.gradle` 의존성(Dependencies) 예시

아래는 **Undertow, Spring Data JPA, MySQL, Swagger(Springdoc), Flyway, MapStruct, Lombok** 등 지금까지 논의된
모든 라이브러리가 포함된 `dependencies` 블록입니다. 이 내용을 `build.gradle` 파일에 복사하여 사용하거나 참고할 수 있습니다.

```groovy
dependencies {
    implementation('org.springframework.boot:spring-boot-starter-web') {
        exclude group: 'org.springframework.boot', module: 'spring-boot-starter-tomcat'
    }
    implementation 'org.springframework.boot:spring-boot-starter-undertow'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'

    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2'

    implementation 'org.flywaydb:flyway-core'
    implementation 'org.flywaydb:flyway-mysql'

    implementation 'org.mapstruct:mapstruct:1.5.5.Final'

    runtimeOnly 'com.mysql:mysql-connector-j'

    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    compileOnly 'org.projectlombok:lombok'

    annotationProcessor 'org.projectlombok:lombok'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```

## 5. 🎨 코드 스타일과 저장 시 자동 정렬 설정

팀원들과 일관된 코드 스타일을 유지하고, 저장할 때마다 코드를 자동으로 정리하도록 설정하여 개발 효율을 높일 수 있습니다.

**Code Formatter 설정 (Google Style 적용)**

- **경로**: `File > Settings > Editor > Code Style > Java`
- **설정**: 상단의 `Scheme` 드롭다운 메뉴에서 `GoogleStyle`을 선택하고 `Apply` 버튼을 누릅니다.
    - 아래 파일을 import 해주세요.

      [intellij-java-google-style.xml](https://prod-files-secure.s3.us-west-2.amazonaws.com/83c75a39-3aba-4ba4-a792-7aefe4b07895/1175c8ee-d999-41ef-b194-9112eee0a55c/intellij-java-google-style.xml)

**저장 시 자동 실행 (Actions on Save) 설정 (필수)**

- **경로**: `File > Settings > Tools > Actions on Save`
- **주요 설정 항목 체크**:
    - `✅ Reformat code`: 파일 저장 시 설정된 코드 스타일(GoogleStyle)에 맞춰 전체 코드 서식을 정리합니다.
    - `✅ Optimize imports`: 사용하지 않는 `import` 구문을 자동으로 제거하고, 순서를 정리합니다.

이 설정을 완료하면, 파일을 저장(`Ctrl+S`)하는 것만으로도 항상 깔끔하고 정돈된 코드를 유지할 수 있습니다.

## 6. 실습: 프로젝트 템플릿 완성하기

### 프로젝트 환경 구성

- **1. 프로젝트 생성 및 의존성 설정**
    - **Spring Initializr**에서 Gradle/Java 17 기반 프로젝트를 생성합니다.
    - 생성된 `build.gradle` 파일을 열어 아래 라이브러리들이 모두 포함되도록 수정합니다.
        - **WAS**: `Undertow` (Tomcat 제외)
        - **기본**: `Spring Web`, `JPA`, `MySQL Driver`, `Lombok`
        - **추가**: `Swagger(Springdoc)`, `Flyway`, `MapStruct`
- **2. 데이터베이스 실행**
    - 터미널에 아래 명령어를 입력해 **MySQL Docker 컨테이너**를 실행합니다.

```shell
docker run --name spring-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=spring_db -d mysql:8.0
```

- **3. 애플리케이션 설정**
    - `application.yml` 파일에 **DB 연결 정보**와 `Flyway` 설정을 추가합니다.
    - IntelliJ의 **`Save Actions`**와 **`Google Java Format`**을 설정해 코드 스타일을 통일합니다.

### 설정 동작 확인

- **1. 애플리케이션 실행**
    - `@SpringBootApplication` 클래스를 실행하고, **로그에 DB 연결 에러가 없는지** 확인합니다.
- **2. Swagger UI 접속**
    - 브라우저에서 **`http://localhost:8080/swagger-ui/index.html`** 로 접속하여 API 문서 페이지가 정상적으로 표시되는지 확인합니다.

#### tag2

- [목차](#tag0)

## **1. Java 객체지향 프로그래밍 ☕**

Spring 프레임워크를 효과적으로 사용하기 위해 반드시 알아야 할 핵심 Java 객체 지향 프로그래밍(OOP) 개념은 다음과 같습니다. 각 개념이 Spring에서 어떻게
활용되는지에 집중하여 이해하는 것이 중요합니다.

### **클래스(Class)와 객체(Object) 🧱**

- `클래스`는 객체를 만들기 위한 **설계도**이고, `객체`는 그 설계도를 바탕으로 메모리에 생성된 **실체**입니다.
- Spring에서 `@Component`, `@Service`, `@Repository` 등의 어노테이션이 붙은 클래스는 모두 **Spring Bean(객체)을 만들기 위한
  설계도**입니다. Spring IoC 컨테이너는 이 클래스들을 읽어 **객체(Bean)를 생성하고 직접 관리**합니다.

```java
// 클래스 선언 (설계도)
class Car {

  // 메소드
  void move() {
    System.out.println("자동차가 움직입니다.");
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    // 객체 생성 (실체화)
    Car myCar = new Car();
    myCar.move(); // 자동차가 움직입니다.

    Car yourCar = new Car();
    yourCar.move(); // 자동차가 움직입니다.
  }
}
```

### **캡슐화 (Encapsulation) 🛡️**

- 객체의 데이터를 외부에서 직접 접근하지 못하도록 `private`으로 숨기고, 데이터 조작이 필요할 경우 `public` 메소드(Getter/Setter)를 통해서만 접근을
  허용하는 방식입니다. 이를 통해 **데이터를 보호하고 객체의 일관성을 유지**할 수 있습니다.
- Spring Bean의 내부 상태(필드)는 `private`으로 보호하고, 정해진 비즈니스 로직(메소드)을 통해서만 상호작용하도록 설계합니다. 이는 다른 Bean이 현재
  Bean의 상태를 임의로 변경하는 것을 막아 **애플리케이션의 안정성과 예측 가능성을 높입니다.**

```java
class Student {

  private int score; // 외부에서 직접 접근 불가

  // Getter: 데이터를 읽는 통로
  public int getScore() {
    return this.score;
  }

  // Setter: 데이터를 쓰는 통로 (조건 검증 추가)
  public void setScore(int score) {
    if (score >= 0 && score <= 100) {
      this.score = score;
    } else {
      System.out.println("유효하지 않은 점수입니다.");
    }
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    Student student = new Student();
    // student.score = 200; // 컴파일 에러! private 필드는 직접 접근 불가

    student.setScore(95);
    System.out.println("학생의 점수: " + student.getScore()); // 학생의 점수: 95

    student.setScore(150); // 유효하지 않은 점수입니다.
    System.out.println("학생의 점수: " + student.getScore()); // 학생의 점수: 95 (이전 값 유지)
  }
}
```

### **상속 (Inheritance) 👨‍👩‍👧**

- 부모 클래스의 멤버(필드, 메소드)를 자식 클래스가 물려받아 사용할 수 있는 기능입니다. 이를 통해 **코드의 재사용성을 높이고 클래스를 계층적으로 구성**할 수 있습니다.
- Spring 프레임워크가 제공하는 특정 기능의 기반 클래스를 `상속(extends)`하고 필요한 부분을 `재정의(@Override)`하여 손쉽게 기능을 확장하거나 커스터마이징할
  수 있습니다.

```java
// 부모 클래스
class Animal {

  void eat() {
    System.out.println("음식을 먹습니다.");
  }
}

// 자식 클래스 (Animal을 상속)
class Dog extends Animal {

  void bark() {
    System.out.println("멍멍!");
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    Dog myDog = new Dog();
    myDog.eat();  // 부모로부터 상속받은 메소드 호출
    myDog.bark(); // 자식이 가진 고유한 메소드 호출
  }
}
```

### **다형성 (Polymorphism) 🎭**

- "여러 가지 형태를 가질 수 있는 능력"을 의미합니다. 같은 타입(부모 클래스)이지만, 실행 시점에는 다른 객체(자식 클래스)가 되어 **동일한 메시지(메소드 호출)에 대해
  각기 다른 동작**을 하는 것입니다. **메소드 오버라이딩(@Override)**이 다형성을 구현하는 핵심 기술입니다.
- **다형성은 Spring의 핵심 가치인 의존성 주입(Dependency Injection, DI)과 서비스 추상화의 기반**이 됩니다. 개발자는 구체적인 구현 클래스가 아닌 *
  *인터페이스(추상적인 역할)에 의존**하여 코드를 작성합니다. 그러면 Spring 컨테이너가 실행 시점에 해당 인터페이스를 구현한 **실제 구현 객체(Bean)를 주입**
  해줍니다. 이를 통해 부품을 교체하듯 유연하게 기능을 변경하고 확장할 수 있습니다.

```java
// 역할(인터페이스) 정의
interface Speaker {

  void makeSound();
}

// 역할을 구현한 실제 객체 1
class Dog implements Speaker {

  @Override
  public void makeSound() {
    System.out.println("멍멍!");
  }
}

// 역할을 구현한 실제 객체 2
class Cat implements Speaker {

  @Override
  public void makeSound() {
    System.out.println("야옹~");
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    // Speaker라는 역할(타입)에 의존
    // 상황에 따라 Dog 객체를 주입받을 수도 있고,
    Speaker pet = new Dog();
    pet.makeSound(); // 멍멍!

    // Cat 객체를 주입받을 수도 있다.
    pet = new Cat();
    pet.makeSound(); // 야옹~
    // 사용하는 쪽의 코드는 변경되지 않는다!
  }
}
```

## **2. 인터페이스(Interface)와 추상 클래스(Abstract Class) 📜**

다형성을 구현하고, 객체의 역할을 명확히 하며, 코드의 유연성을 높이는 중요한 문법입니다. Spring에서는 특히 **의존성 주입(DI)**과 **느슨한 결합(Loose
Coupling)**을 위해 인터페이스를 적극적으로 활용합니다.

### **인터페이스 (Interface)**

- 클래스가 **무엇을 해야 하는지(what)**에 대한 '**약속**' 또는 '**명세**'입니다. 메소드의 시그니처만 정의하며, 실제 구현은 `implements` 키워드를
  통해 클래스에게 위임합니다. 클래스는 여러 인터페이스를 동시에 구현할 수 있습니다.
- **Spring의 의존성 주입(DI)에서 가장 선호되는 방식**입니다. Controller가 Service를 사용할 때, 구체적인 `UserServiceImpl` 클래스가 아닌
  `UserService` 인터페이스에 의존하게 만듭니다. 이렇게 하면, 나중에 `UserService`의 구현체를 다른 것으로 교체하거나, 테스트 시에 가짜 객체(Mock)로
  대체해도 Service를 사용하는 Controller 코드는 전혀 변경할 필요가 없습니다. 이는 **유연하고 확장성 높은 설계의 핵심**입니다.

```java
// "알림을 보낼 수 있다"는 역할(약속)을 정의하는 인터페이스
interface Notifier {

  void send(String message);
}

// 약속을 실제로 이행하는 구현 클래스 1
class EmailNotifier implements Notifier {

  @Override
  public void send(String message) {
    System.out.println("이메일 발송: " + message);
  }
}

// 약속을 실제로 이행하는 구현 클래스 2
class SmsNotifier implements Notifier {

  @Override
  public void send(String message) {
    System.out.println("SMS 발송: " + message);
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    // Notifier 역할에 의존하여 코딩
    Notifier notifier;

    // 필요에 따라 이메일 구현체를 주입받아 사용
    notifier = new EmailNotifier();
    notifier.send("회원가입을 축하합니다!"); // 이메일 발송: 회원가입을 축하합니다!

    // SMS 구현체로 쉽게 교체 가능
    notifier = new SmsNotifier();
    notifier.send("인증번호는 [1234] 입니다."); // SMS 발송: 인증번호는 [1234] 입니다.
  }
}
```

### **추상 클래스 (Abstract Class)**

- 클래스를 위한 **'미완성 설계도**'입니다. 일부 메소드는 직접 구현해두고(공통 기능), 일부 메소드는 `abstract` 키워드를 통해 선언만 해두어 자식 클래스가 반드시
  완성하도록 강제합니다. `extends` 키워드로 상속하며, 단 하나의 클래스만 상속할 수 있습니다.
- 여러 구현 클래스들이 **공통으로 사용하는 필드나 메소드가 있을 때 코드 중복을 줄이기 위해 사용**됩니다. 예를 들어, 다양한 종류의 리포트를 생성하는 Bean들이 있다고
  가정해 봅시다. 리포트의 헤더나 푸터를 만드는 로직은 모두 동일하다면, 이 공통 로직을 추상 클래스에 구현해두고, 실제 리포트 내용을 채우는 핵심 로직만 자식 클래스에서
  구현하도록 하여 효율성을 높일 수 있습니다.

```java
// 도형이라는 공통 속성과 미완성된 기능을 가진 추상 클래스
abstract class Shape {

  private final String name;

  public Shape(String name) {
    this.name = name;
  }

  // 공통 기능은 직접 구현
  public void printName() {
    System.out.println("도형의 이름: " + name);
  }

  // 개별 기능은 미완성 상태로 자식에게 위임 (추상 메소드)
  public abstract double getArea();
}

// 추상 클래스를 상속받아 미완성 기능을 완성하는 자식 클래스
class Circle extends Shape {

  private final double radius;

  public Circle(String name, double radius) {
    super(name);
    this.radius = radius;
  }

  @Override // 추상 메소드 구현을 강제함
  public double getArea() {
    return Math.PI * radius * radius;
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    // Shape shape = new Shape("도형"); // 에러! 미완성 설계도로는 객체 생성 불가

    Shape myCircle = new Circle("원", 5.0);
    myCircle.printName(); // 도형의 이름: 원 (부모의 공통 기능)
    System.out.println("넓이: " + myCircle.getArea()); // 넓이: 78.53... (자식이 구현한 기능)
  }
}
```

### **✅ 인터페이스 vs. 추상 클래스: 언제 무엇을 쓸까?**

| **구분**             | **인터페이스 (Interface)**                                                                            | **추상 클래스 (Abstract Class)**                  |
|--------------------|--------------------------------------------------------------------------------------------------|----------------------------------------------|
| **핵심 목적**          | 클래스들의 **동작(기능)을 명세**하고 **역할을 정의**                                                                | 관련 클래스들 간의 **코드 공유 및 재사용**                   |
| **키워드**            | `implements` (다중 구현 가능)                                                                          | `extends` (단일 상속만 가능)                        |
| **관계**             | `~을 할 수 있는` (has-a) 관계에 가까움 (e.g., `Flyable`)                                                    | `~이다` (is-a) 관계에 가까움 (e.g., `Animal`)        |
| **Spring에서의 주 용도** | **DI를 통한 느슨한 결합(Loose Coupling)**, 서비스 추상화                                                       | 공통 로직을 가진 Bean들의 **코드 중복 제거**                |
| **선택 기준**          | **서로 관련 없는 클래스들에게 공통된 역할을 부여**하고 싶을 때. &lt;br> **Spring의 DI 기능을 적극 활용**하고 싶을 때 **(일반적으로 우선 고려)** | **밀접하게 연관된 클래스들 간에 공통된 필드나 메소드를 공유**하고 싶을 때. |

---

## **3. 컬렉션 프레임워크 (Collections Framework) 🗃️**

애플리케이션에서 다수의 데이터를 효과적으로 관리하고 사용하기 위해 Java가 기본으로 제공하는 라이브러리입니다. Spring에서는 DB 조회 결과, 요청 데이터 처리, 설정 값
관리 등 거의 모든 영역에서 컬렉션이 사용됩니다.

<aside>

**💡잠깐! 컬렉션과 박싱 & 언박싱 (Boxing & Unboxing)**

컬렉션 프레임워크(`List`, `Set`, `Map` 등)는 **객체(Object)만 저장**할 수 있습니다. `int`, `double` 같은 기본 타입(primitive
type)은 직접 담을 수 없습니다.

- **박싱(Boxing)**: 기본 타입을 해당 타입의 래퍼 클래스(Wrapper Class) 객체로 변환하는 과정입니다. (`int` → `Integer`)
- **언박싱(Unboxing)**: 래퍼 클래스 객체를 다시 기본 타입으로 변환하는 과정입니다. (`Integer` → `int`)

Java 5부터는 이 과정이 자동으로 일어나는데, 이를 **오토박싱(Auto-boxing) & 오토언박싱(Auto-unboxing)**이라고 합니다.

</aside>

```java
List<Integer> numbers = new ArrayList<>();

// 오토박싱: 기본 타입 int(10)가 자동으로 Integer 객체로 변환되어 리스트에 추가됨
numbers.

add(10);

// 언박싱: 리스트에서 꺼낸 Integer 객체가 자동으로 int 타입으로 변환되어 변수에 할당됨
int firstNumber = numbers.get(0);
​
이 개념
덕분에 우리는
컬렉션을 마치
기본 타입을
직접 다루는
것처럼 편리하게
사용할 수
있습니다 .
```

### **List**

- **순서가 있는** 데이터의 집합으로, **데이터 중복을 허용**합니다. 인덱스(index)를 통해 특정 위치의 데이터에 빠르게 접근할 수 있습니다. 가장 대표적인 구현체는
  `ArrayList`입니다.
- **DB에서 여러 건의 데이터를 조회한 결과**를 담을 때 가장 흔하게 사용됩니다. 예를 들어, `findAll()` 같은 메소드는 `List<UserDto>` 형태로 결과를
  반환합니다. 또한, 여러 개의 요청 파라미터를 한 번에 받을 때도 활용됩니다.

```java
import java.util.ArrayList;
import java.util.List;

public class JavaProgramming {

  public static void main(String[] args) {
    List<String> fruits = new ArrayList<>();
    // 순서대로 추가됨
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Apple"); // 중복 허용

    System.out.println("과일 목록: " + fruits);       // 과일 목록: [Apple, Banana, Apple]
    System.out.println("첫 번째 과일: " + fruits.get(0)); // 첫 번째 과일: Apple
  }
}
```

### **Set**

- **순서가 없고**, **중복을 허용하지 않는** 데이터의 집합입니다. 데이터의 존재 여부를 빠르게 확인할 때 유용합니다. 가장 대표적인 구현체는 `HashSet`입니다.
- 데이터의 **고유성을 보장**해야 할 때 사용됩니다. 예를 들어, 사용자의 권한(`Role`) 정보를 담을 때 중복된 권한이 들어가지 않도록 `Set<Role>` 형태로 관리할
  수 있습니다.

```java
import java.util.HashSet;
import java.util.Set;

public class JavaProgramming {

  public static void main(String[] args) {
    Set<String> uniqueNames = new HashSet<>();
    uniqueNames.add("Alice");
    uniqueNames.add("Bob");
    uniqueNames.add("Alice"); // 중복된 값은 추가되지 않음

    System.out.println("고유한 이름들: " + uniqueNames); // 고유한 이름들: [Alice, Bob] (순서 보장 안 됨)
    System.out.println("Bob이 포함되어 있나? " + uniqueNames.contains("Bob")); // Bob이 포함되어 있나? true
  }
}
```

### **Map**

- **Key-Value 쌍**으로 데이터를 저장하는 구조입니다. **Key는 중복될 수 없으며**, 각 Key는 하나의 Value에 매핑됩니다. Key를 통해 Value를 매우
  빠르게 찾아올 수 있습니다. 대표적인 구현체는 `HashMap`입니다.
- Spring 프로젝트 내에서 활용 범위가 매우 넓습니다.
    - **JSON 데이터 처리**: 클라이언트가 보낸 JSON 객체를 `Map<String, Object>` 형태로 받아 처리할 수 있습니다.
    - **요청 파라미터**: `@RequestParam` 어노테이션을 통해 여러 개의 쿼리 스트링을 `Map`으로 한 번에 받을 수 있습니다.
    - **DB 결과 매핑**: 데이터베이스 조회 결과를 DTO 객체가 아닌 `Map`으로 받아 유연하게 처리할 수 있습니다.

```java
import java.util.HashMap;
import java.util.Map;

public class JavaProgramming {

  public static void main(String[] args) {
    Map<String, Integer> userAges = new HashMap<>();
    userAges.put("Alice", 25);
    userAges.put("Bob", 30);
    userAges.put("Alice", 26); // 기존 "Alice" Key의 값을 26으로 덮어씀

    System.out.println("사용자 나이 정보: " + userAges); // 사용자 나이 정보: {Bob=30, Alice=26}
    System.out.println("Bob의 나이: " + userAges.get("Bob"));   // Bob의 나이: 30
  }
}
```

### **컬렉션 프레임워크 성능 비교: 시간 복잡도 🚀**

시간 복잡도는 데이터의 크기(n)가 증가할 때, 특정 연산을 수행하는 데 걸리는 시간이 어떻게 변하는지를 나타내는 척도입니다. 어떤 컬렉션을 선택하느냐에 따라 애플리케이션의 성능이
크게 달라질 수 있습니다.

- `O(1)` (Constant Time): 데이터 크기와 상관없이 항상 일정한 시간이 걸립니다. **가장 빠릅니다.**
- `O(n)` (Linear Time): 데이터 크기에 비례하여 시간이 선형적으로 증가합니다.
- `O(log n)` (Log Time): 데이터 크기가 두 배로 늘어나도 시간은 조금만 증가합니다. `O(1)` 다음으로 빠릅니다.

### **주요 컬렉션 시간 복잡도 비교표**

| 연산 (Operation)             | `ArrayList`   | `HashSet`  | `HashMap`  |
|----------------------------|---------------|------------|------------|
| **추가 (add / put)**         | 분할 상환 `O(1)`¹ | 평균 `O(1)`² | 평균 `O(1)`² |
| **삭제 (remove)**            | `O(n)`        | 평균 `O(1)`² | 평균 `O(1)`² |
| **검색/조회 (contains / get)** | `O(n)`        | 평균 `O(1)`² | 평균 `O(1)`² |
| **인덱스로 조회 (get(index))**   | `O(1)`        | -          | -          |

> **¹ 분할 상환 O(1)**: 대부분의 경우 O(1)이지만, 내부 배열의 크기가 꽉 차서 더 큰 배열로 복사해야 하는 드문 경우에 O(n)이 걸립니다. 이 비용을 전체 연산에
> 분산시키면 평균적으로 O(1)에 가깝다고 봅니다.
>
>
> **² 평균 O(1)**: 해시 충돌(Hash Collision)이 없을 때 `O(1)`입니다. 충돌이 많이 발생하면 최악의 경우 `O(n)`까지 성능이 저하될 수 있지만, 잘
> 구현된 `hashCode`에서는 극히 드뭅니다.
>

**왜 이런 차이가 발생할까요?**

**1. `ArrayList` (순차적 메모리 구조)**

`ArrayList`는 내부적으로 데이터를 배열에 저장합니다. 데이터가 메모리상에 순서대로 위치합니다.

- **인덱스로 조회 `get(index)`가 `O(1)`인 이유**: 배열은 특정 인덱스의 메모리 주소를 `(시작 주소) + (인덱스 * 데이터 크기)` 공식으로 한 번에 계산할
  수 있습니다. 그래서 데이터가 아무리 많아도 특정 위치의 값을 즉시 찾아올 수 있습니다.
- **검색 `contains()` 및 삭제 `remove()`가 `O(n)`인 이유**: 특정 값을 찾으려면 처음부터 끝까지 하나씩 모두 비교해봐야 합니다(`O(n)`). 특정
  값을 삭제한 후에는 뒤따라오던 요소들을 모두 한 칸씩 앞으로 당겨 빈 공간을 메워야 하므로 `O(n)`의 시간이 걸립니다.

**2. `HashSet` / `HashMap` (해시 기반 구조)**

`HashSet`과 `HashMap`은 '해시 테이블'이라는 구조를 사용합니다. `hashCode()` 메소드를 통해 얻은 정수 값(해시 값)을 사용하여 데이터를 저장할 위치를
결정합니다.

- **추가, 삭제, 검색이 평균 `O(1)`인 이유**:
    1. 저장할 객체의 `hashCode()`를 호출하여 해시 값을 얻습니다.
    2. 이 해시 값을 이용해 데이터가 저장될 내부 배열의 위치(버킷)를 즉시 계산합니다.
    3. 해당 위치에 데이터를 저장하거나 검색합니다.
       이 과정은 데이터의 총 개수와 상관없이 거의 일정한 속도를 보장하기 때문에 매우 빠릅니다.
       **✅ Spring 개발자를 위한 실용 가이드: 언제 무엇을 쓸까?**

- **`ArrayList`를 사용하세요...**
    - 데이터의 **순서가 중요**하고, **중복을 허용**해야 할 때.
    - 데이터를 추가한 순서대로 화면에 보여줘야 할 때. (e.g., 게시글 목록, 댓글 목록)
    - **DB 조회 결과를 담아 클라이언트에게 전달**하는 DTO 리스트로 가장 일반적으로 사용됩니다.
    - 데이터를 중간에 삽입/삭제하는 일보다, **전체 목록을 조회하는 일이 훨씬 많을 때** 유리합니다.

- **`HashSet`을 사용하세요...**
    - 데이터의 **중복을 절대 허용하고 싶지 않을** 때.
    - 데이터의 **순서는 전혀 중요하지 않을** 때.
    - 특정 데이터가 **존재하는지 여부만 빠르게 확인**하고 싶을 때. (e.g., 사용자의 권한(Role) 관리, 게시글에 대한 태그(Tag) 관리)

- **`HashMap`을 사용하세요...**
    - **특정 Key를 통해 Value를 빠르게 찾아와야** 할 때.
    - 데이터를 (id, 객체) 형태로 관리하고 싶을 때.
    - **JSON 데이터를 다룰 때** 매우 유용합니다. Key-Value 구조가 JSON과 완벽하게 일치하기 때문입니다.
    - 간단한 **인메모리 캐시(In-memory Cache)**를 구현할 때. (e.g., `userId`를 Key로, `UserDto`를 Value로 저장)

## **4. 예외 처리 (Exception Handling) ⚠️**

- 프로그램 실행 중 발생할 수 있는 오류(예외)에 대비하여, 프로그램이 비정상적으로 종료되는 것을 막고 정상적인 실행 흐름을 유지하도록 만드는 문법입니다. `try` 블록으로
  예외 발생 가능 코드를 감싸고, `catch` 블록에서 특정 예외를 잡아 처리하며, `finally` 블록으로 예외 발생 여부와 상관없이 항상 실행해야 하는 코드를 정의합니다.
- Spring은 강력한 예외 처리 모델을 제공합니다.
    - **`@ControllerAdvice`와 `@ExceptionHandler`**: 이 조합을 사용하면 애플리케이션 전역에서 발생하는 예외를 **한 곳에서 중앙 집중적으로
      관리**할 수 있습니다. 예를 들어, `UserNotFoundException`이 발생하면 특정 에러 페이지를 보여주거나 표준화된 JSON 에러 응답을 보내도록 설정할
      수 있습니다.
    - **`@Transactional`**: 트랜잭션이 적용된 메소드에서 처리되지 않은 예외(Unchecked Exception)가 발생하면, Spring은 자동으로 해당
      트랜잭션을 **롤백(Rollback)**하여 데이터의 일관성을 유지합니다.

```java
public class JavaProgramming {

  public static void main(String[] args) {
    try {
      int data = 100 / 0; // ArithmeticException 발생!
      System.out.println("결과: " + data); // 이 코드는 실행되지 않음

    } catch (ArithmeticException e) {
      // 특정 예외를 잡아서 처리
      System.err.println("수학적 오류가 발생했습니다: 0으로 나눌 수 없습니다.");

    } finally {
      // 예외 발생 여부와 관계없이 항상 실행됨
      System.out.println("자원 해제 등 마무리 작업을 수행합니다.");
    }
    System.out.println("프로그램이 정상적으로 계속 진행됩니다.");
  }
}
```

## **5. 어노테이션 (Annotation)**

- 코드에 대한 **메타데이터(Metadata)**, 즉 '부가 정보'를 제공하는 '태그'입니다. 어노테이션 자체는 아무런 동작을 하지 않지만, 컴파일러나 프레임워크(Spring)
  가 이 태그를 읽고 특정 작업을 수행하도록 지시합니다.
- **현대 Spring 프레임워크의 핵심**입니다. 과거의 복잡한 XML 설정 대신 어노테이션을 통해 대부분의 설정을 처리합니다. Spring은 어노테이션을 보고 **객체(
  Bean)를 생성하고, 의존성을 주입하고, 요청을 처리하는 등 모든 '마법**'을 부립니다.
    - **`@Component`**, **`@Service`**: 이 클래스는 Spring이 관리할 Bean(객체)임을 표시합니다.
    - **`@Autowired`**: 필요한 의존성(객체)을 자동으로 주입해달라고 Spring에 요청합니다.
    - **`@GetMapping`**, **`@PostMapping`**: HTTP 요청 URL과 특정 메소드를 연결합니다.
    - **`@Transactional`**: 메소드에 트랜잭션 기능을 적용합니다.

```java
class Animal {

  void makeSound() {
    System.out.println("동물이 소리를 냅니다.");
  }
}

class Dog extends Animal {

  // @Override: 부모의 메소드를 재정의했음을 컴파일러에 알림
  // 만약 부모에 해당 메소드가 없으면 컴파일 에러를 발생시켜 실수를 방지함
  @Override
  void makeSound() {
    System.out.println("멍멍!");
  }
}
```

## **6. 제네릭 (Generics)**

- 클래스나 메소드를 정의할 때, 사용할 데이터 타입을 미리 정하지 않고 **타입을 파라미터로 받는** 기술입니다. 이를 통해 **컴파일 시점에 타입 안정성을 확보**하고,
  불필요한 형변환을 제거하여 더 유연하고 안정적인 코드를 작성할 수 있습니다.
- 제네릭은 Spring 개발의 **타입 안정성**을 책임지는 필수 요소입니다.
    - **컬렉션**: `List<UserDto>`처럼 컬렉션에 담길 데이터의 타입을 명확히 하여 실수를 방지합니다.
    - **API 응답**: `ResponseEntity<ApiResponse<UserDto>>`와 같이 API 응답의 구조를 명확하게 정의하여 클라이언트와 서버 간의 소통을
      원활하게 합니다.
    - **Spring Data JPA**: `JpaRepository<User, Long>`처럼 Repository가 다룰 **엔티티 타입(User)**과 **ID 타입(
      Long)**을 제네릭으로 지정하여 해당 타입에 맞는 DB 처리 메소드를 자동으로 생성해줍니다.

```java
// 제네릭 클래스: 어떤 타입(T)의 내용물이라도 담을 수 있는 상자
class Box<T> {

  private T content;

  public void set(T content) {
    this.content = content;
  }

  public T get() {
    return content;
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    // String을 담는 Box 생성
    Box<String> stringBox = new Box<>();
    stringBox.set("Hello Spring!");
    String message = stringBox.get();
    System.out.println(message); // Hello Spring!

    // Integer를 담는 Box 생성
    Box<Integer> integerBox = new Box<>();
    integerBox.set(100);
    int number = integerBox.get();
    System.out.println(number); // 100
  }
}
```

## **7. 람다 표현식 & 스트림 API (Java 8+) 🚀**

Java 8에서 도입된 혁신적인 기능으로, 함수형 프로그래밍 스타일을 Java에 도입하여 코드를 훨씬 더 간결하고 표현력 있게 만들어 줍니다.

### **람다 표현식 (Lambda Expressions)**

- **이름이 없는 함수(Anonymous Function)**를 만드는 간결한 방법입니다. 메소드를 마치 값(value)처럼 다룰 수 있게 해줍니다. 주로 **함수형 인터페이스(
  Functional Interface: 단 하나의 추상 메소드만 가진 인터페이스)**를 구현할 때, 불필요한 코드 없이 핵심 로직만 깔끔하게 작성할 수 있습니다.

```java
// 목표: 새로운 스레드를 생성하여 코드를 실행한다.

// [Before] Java 7까지의 익명 클래스 방식
new Thread(new Runnable() {
  @Override
  public void run () {
    System.out.println("스레드 실행 (기존 방식)");
  }
}).

start();

// [After] Java 8 람다 표현식
// () -> { ... } 부분이 run() 메소드의 구현체를 대체합니다.
new

Thread(() ->System.out.

println("스레드 실행 (람다 방식)")).

start();
```

### **스트림 API (Stream API)**

- 컬렉션(List, Set 등)이나 배열의 데이터 요소들을 **하나의 데이터 흐름(stream)**으로 보고, 여러 연산을 **체인(chain) 형태로 연결**하여 처리하는
  선언적인 방식입니다. `for` 루프와 `if`문으로 복잡하게 작성하던 데이터 처리 로직을 훨씬 우아하게 표현할 수 있습니다.
    1. **생성**: `collection.stream()`으로 스트림을 만듭니다.
    2. **중간 연산**: `filter()`, `map()`, `sorted()` 등. 여러 개를 연결할 수 있으며, 결과로 새로운 스트림을 반환합니다. (지연 연산)
    3. **최종 연산**: `collect()`, `forEach()`, `count()` 등. 스트림 처리를 시작하고 최종 결과를 반환합니다. (최종 연산은 단 한 번만
       가능)

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {

  private String name;
  private Integer price;

  public Fruit(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
// 데이터 준비
    List<Fruit> fruits = Arrays.asList(
        new Fruit("Apple", 1500),
        new Fruit("Banana", 2500),
        new Fruit("Orange", 3000)
    );

// [Before] Java 7까지의 for 루프 방식
    List<String> expensiveFruitNamesOld = new ArrayList<>();
    for (Fruit fruit : fruits) {
      if (fruit.getPrice() >= 2000) {
        expensiveFruitNamesOld.add(fruit.getName().toUpperCase());
      }
    }

    System.out.println("For 루프 결과: " + expensiveFruitNamesOld);

// [After] Java 8 스트림 API
    List<String> expensiveFruitNamesNew = fruits.stream() // 1. 스트림 생성
        .filter(f -> f.getPrice() >= 2000)           // 2. 중간 연산: 조건에 맞는 과일만 필터링
        .map(f -> f.getName().toUpperCase())         // 3. 중간 연산: 과일 객체를 이름(대문자)으로 변환
        .toList();               // 4. 최종 연산: 결과를 새로운 리스트로 수집

    System.out.println("스트림 결과: " + expensiveFruitNamesNew);

// (Fruit 클래스는 이름과 가격 필드, getter가 있다고 가정)
  }
}
```

**✅ Spring 개발에서의 활용**

람다와 스트림은 현대 Spring 애플리케이션에서 데이터를 다루는 표준 방식으로 자리 잡았습니다.

- **DTO 변환**: **가장 흔한 사용 사례**입니다. DB에서 조회한 `List<Entity>`를 클라이언트에게 전달할 `List<DTO>`로 변환할 때, 스트림의
  `map()` 연산은 거의 필수적으로 사용됩니다. 이를 통해 반복문 없이 깔끔한 변환 로직을 작성할 수 있습니다.Java

```java
// User 엔티티 리스트를 UserDto 리스트로 변환
List<UserDto> userDtos = users.stream()
        .map(user -> new UserDto(user.getName(), user.getEmail()))
        .collect(Collectors.toList());
```

- **데이터 필터링 및 가공**: 서비스 계층에서 비즈니스 로직에 따라 필요한 데이터를 `filter()`로 거르거나, 특정 조건에 따라 값을 `map()`으로 변경하는 등
  복잡한 데이터 가공을 간결하게 처리할 수 있습니다.
- **비동기/리액티브 프로그래밍**: Spring의 `CompletableFuture`를 사용한 비동기 처리나, `Spring WebFlux` 같은 리액티브 프로그래밍 모델에서는
  람다와 스트림이 문법의 기본이 됩니다.

### **스트림 중간 결과 확인을 위한 `peek()`**

`peek()`은 스트림 파이프라인의 **중간 연산(intermediate operation)** 중 하나로, 스트림의 각 요소가 파이프라인의 특정 지점을 통과할 때마다 지정된
작업을 수행하게 합니다. 이름 그대로 스트림의 내용을 **변경하지 않고 살짝 엿보는(peek)** 용도로, 주로 **디버깅** 시에 사용됩니다.

**주요 특징:**

- `map()`과 달리, `peek()`은 스트림의 요소를 **소비만 하고 반환(변경)하지 않습니다.**
- `forEach()`와 달리, `peek()`은 **중간 연산**이므로 `peek()` 다음에 다른 스트림 연산을 계속 이어갈 수 있습니다.
- **주의!**: `peek()`은 중간 연산이므로, `collect()`, `count()` 같은 **최종 연산(terminal operation)이 호출되어야만 동작합니다.
  ** 최종 연산이 없으면 스트림 파이프라인 전체가 실행되지 않으므로 `peek()`도 아무런 동작을 하지 않습니다.

스트림 연산 과정에서 데이터가 어떻게 변하는지 단계별로 확인해 보겠습니다.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaProgramming {

  public static void main(String[] args) {
    List<String> languages = Arrays.asList("Java", "Python", "Go", "JavaScript");

    List<String> result = languages.stream()
        .filter(lang -> lang.length() > 3) // 1. 길이가 3보다 큰 언어 필터링
        .peek(lang -> System.out.println("필터링 후: " + lang)) // 2. 필터링된 결과 엿보기
        .map(String::toUpperCase) // 3. 대문자로 변환
        .peek(lang -> System.out.println("대문자 변환 후: " + lang)) // 4. 변환된 결과 엿보기
        .collect(Collectors.toList()); // 5. 최종 연산 (이 코드가 없으면 peek은 동작 안 함)

    System.out.println("\n최종 결과 리스트: " + result);
  }
}
```

실행 결과:

```
필터링 후: Java
대문자 변환 후: JAVA
필터링 후: Python
대문자 변환 후: PYTHON
필터링 후: JavaScript
대문자 변환 후: JAVASCRIPT

최종 결과 리스트: [JAVA, PYTHON, JAVASCRIPT]
```

결과에서 볼 수 있듯이, `peek()`을 사용하면 각 중간 연산이 끝난 직후의 데이터 상태를 명확히 확인할 수 있어 복잡한 스트림을 디버깅할 때 매우 유용합니다.

**올바른 사용법:**

- **`peek()`으로는 데이터의 상태를 변경하는 로직(e.g., `peek(user -> user.setActive(true))`)을 넣지 마세요.** 오직 로그를 남기거나
  디버깅하는 용도로만 사용하는 것이 좋습니다. 상태 변경은 `map()`을 사용해야 합니다.
- `peek()`은 **디버깅 도구**이지, 비즈니스 로직을 위한 도구가 아님을 기억하세요.

물론입니다. Java의 기본 반복문인 `for`와 `for-each`, 그리고 스트림의 `forEach`에 대한 설명과 세 가지를 비교하는 표를 만들어 드리겠습니다.

## **8. 반복문: `for` 와 `for-each`**

데이터의 집합(컬렉션, 배열)에 담긴 각 요소를 순서대로 접근하여 동일한 작업을 반복 수행할 때 사용합니다.

### **`for` 루프 (index 기반)**

- 가장 전통적인 반복문으로, **초기화, 조건식, 증감식** 세 부분으로 구성됩니다. **인덱스(index)**를 직접 제어할 수 있어 유연성이 높습니다.
- **언제 사용할까?**:
    - 반복 중 **현재 요소의 인덱스**가 필요할 때.
    - 배열이나 리스트를 **역순으로 순회**해야 할 때.
    - 특정 조건에 따라 반복 횟수를 건너뛰거나 조절해야 할 때.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// i라는 인덱스를 직접 사용
for(
int i = 0; i <names.

size();

i++){
    System.out.

println((i +1) +"번째 이름: "+names.

get(i));
    }
```

### **향상된 `for` 루프 (`for-each`)**

- 덱스를 사용하지 않고, 컬렉션이나 배열의 **각 요소를 처음부터 끝까지 순서대로** 바로 가져오는 더 간결하고 읽기 좋은 방식의 반복문입니다.
    - **언제 사용할까?**:
        - 단순히 컬렉션의 **모든 요소를 순회**하기만 하면 될 때.
        - **인덱스가 필요 없을 때**. (가장 일반적인 경우)
        - 코드를 간결하게 유지하고 싶을 때. (가독성이 좋고 실수가 적음)
        ```
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
  
            // 인덱스 없이 각 요소를 직접 가져옴
            for (String name : names) {
              System.out.println("이름: " + name);
            }
        ```

### **✅ `for` vs `for-each` vs `Stream.forEach()` 비교**

세 가지 방식은 비슷해 보이지만, 목적과 특징에서 명확한 차이가 있습니다.

| **특징**     | **for 루프 (index 기반)**       | **향상된 for-each 루프**           | **Stream.forEach()**       |
|------------|-----------------------------|-------------------------------|----------------------------|
| **문법**     | `for (int i=0; i<len; i++)` | `for (Type var : collection)` | `stream.forEach(e -> ...)` |
| **인덱스 사용** | **가능 (O)**                  | 불가능 (X)                       | 불가능 (X)                    |
| **가독성**    | 보통                          | **높음**                        | 높음                         |
| **요소 삭제**  | `Iterator` 사용 시 가능          | **불가능**¹                      | 불가능 (Side-Effect 금지)       |
| **병렬 처리**  | 불가능 (X)                     | 불가능 (X)                       | 가능 (O)²                    |
| **핵심 용도**  | 인덱스를 이용한 복잡한 제어             | 컬렉션의 **단순 순회**                | **스트림 파이프라인**의 최종 소비       |

> ¹ for-each 루프 도중 컬렉션의 요소를 삭제하면 ConcurrentModificationException이 발생합니다.
>
>
> ² `parallelStream().forEach()`를 통해 병렬 처리가 가능하지만, 순서가 보장되지 않습니다.
>

**그래서, 언제 무엇을 써야 할까? 🤔**

- **`for` 루프**: **인덱스가 꼭 필요할 때**만 사용하세요. 그 외의 경우에는 `for-each`나 스트림이 더 나은 선택입니다.
- **`for-each` 루프**: **가장 일반적인 선택지**입니다. 단순히 컬렉션의 모든 요소를 한 번씩 살펴보고 싶을 때 우선적으로 고려하세요.
- **`Stream.forEach()`**: `filter`, `map` 등 **다른 스트림 연산과 함께 사용될 때**만 사용하세요. `forEach`를 쓰기 위해 굳이 스트림을
  생성하는 것은 비효율적입니다. 스트림 파이프라인의 마지막 단계에서 결과를 소비하는 용도입니다.

---

## 9. 실습: 계층 구조 만들기 **🔢**

데이터베이스에서 카테고리 데이터를 조회했습니다. 하지만 조회된 결과는 각 카테고리가 자신의 `id`와 `parent_id`만 아는 **평면적인 리스트(Flat List)**
형태입니다.(ex. `List<CategoryFlatDto>`) 이 데이터를 화면의 내비게이션 메뉴처럼 부모-자식 관계가 명확한 **계층적인 트리(Tree) 구조**로 만들어야
하는 상황입니다.

이 실습의 핵심은 외부 라이브러리나 프레임워크의 도움 없이, 순수 Java 언어의 기본기를 활용하여 이 변환 과정을 직접 구현하는 것입니다.

### 달성 목표

1. 단순한 1차원 `List` 데이터를, 객체 간의 참조를 통해 복합적인 **트리(Tree) 구조로 재조립**하는 능력을 기릅니다.
2. 효율적인 자료구조(**`Map`**)를 활용하여, 불필요한 반복 없이 데이터를 효율적으로 처리하는 문제 해결 능력을 향상시킵니다.
3. 순수 Java 문법만으로 **객체지향적인 데이터 처리 로직**을 깔끔하고 가독성 높게 구현하는 습관을 들입니다.
4. 재조립 된 데이터 전체를 콘솔에 출력하여 확인합니다.

### 데이터 준비: DTO 클래스 정의

먼저, 변환할 원본 데이터와 변환 후의 결과 데이터를 표현할 DTO 클래스를 정의합니다.

- **`CategoryFlatDto` 클래스**
    - DB에서 조회된 원본 데이터를 표현하는 클래스입니다.
    - **필드**: `id(Long)`, `name(String)`, `parentId(Long)`
- **`CategoryTreeDto` 클래스**
    - 최종 결과물인 계층 구조를 표현하는 클래스입니다.
    - **필드**: `id(Long)`, `name(String)`, `children(List<CategoryTreeDto>)`

### 스스로 점검해볼 질문

- 이 문제를 **재귀(Recursion)** 함수로 해결한다면 어떤 장단점이 있을까요? (Map을 사용하는 방식과 비교해보세요.)
    - 재귀로 해결할 경우 코드가 간결해지는거 말고는 장점이 없음. Map 방식의 경우는 명시성이 더 좋고 확장성, 속도면에서 훨씬 우월하다. 재귀호출과 수백배의 성능차이가
      난다.
- 만약 데이터에 잘못된 `parentId`(존재하지 않는 부모 ID)가 포함되어 있다면 어떤 문제가 발생할 수 있을까요?
    - 데이터는 존재하지만 계층간 출력이 나오지 않거나 예외케이스에 걸려 오류가 발생될 수 있다.??
- 완성된 트리 구조를 화면에 출력한다면, 모든 계층을 들여쓰기하여 보기 좋게 출력하는 방법은 무엇일까요?
    - 재귀함수를 호출하여 출력한다.

```java
public static void main(String[] args) {

  // 1. Flat한 리스트 준비
  List<CategoryFlatDto> flatList = List.of(
      new CategoryFlatDto(1L, "전자제품", null),
      new CategoryFlatDto(2L, "노트북", 1L),
      new CategoryFlatDto(3L, "스마트폰", 1L),
      new CategoryFlatDto(4L, "게이밍 노트북", 2L),
      new CategoryFlatDto(5L, "주방가전", 1L),
      new CategoryFlatDto(6L, "믹서기", 5L),
      new CategoryFlatDto(7L, "핸드폰 케이스", 3L)
  );

  // 재귀 호출방식
  long recStart = System.nanoTime();
  List<CategoryTreeDto> recData = treeRecursive(flatList, null);
  System.out.println(JsonUtils.toJson(recData));
  long recEnd = System.nanoTime();
  System.out.println("재귀 방식: " + ((recEnd - recStart) / 1_000_000.0) + " ms");

  // Map 방식
  long mapStart = System.nanoTime();
  List<CategoryTreeDto> topNode = new ArrayList<>();
  Map<Long, CategoryTreeDto> treeMap = new HashMap<>();

  for (CategoryFlatDto flat : flatList) {
    CategoryTreeDto categoryTreeDto = new CategoryTreeDto();
    categoryTreeDto.setId(flat.getId());
    categoryTreeDto.setName(flat.getName());
    treeMap.put(flat.getId(), categoryTreeDto);
  }

  for (CategoryFlatDto flat : flatList) {
    CategoryTreeDto node = treeMap.get(flat.getId());

    if (flat.getParentId() == null) {
      topNode.add(node);
    } else {
      CategoryTreeDto parent = treeMap.get(flat.getParentId());
      parent.getChildren().add(node);
    }
  }

  printTree(topNode, 0);
  long mapEnd = System.nanoTime();
  System.out.println("Map 방식: " + ((mapEnd - mapStart) / 1_000_000.0) + " ms");

  // SpringApplication.run(SpringEducationWeek1Application.class, args);
}

public static void printTree(List<CategoryTreeDto> treeList, int depth) {
  for (CategoryTreeDto node : treeList) {
    System.out.println("  ".repeat(depth) + "- " + node.getName());
    printTree(node.getChildren(), depth + 1);
  }
}

public static List<CategoryTreeDto> treeRecursive(List<CategoryFlatDto> flatList, Long parentId) {
  List<CategoryTreeDto> result = new ArrayList<>();

  for (CategoryFlatDto flat : flatList) {
    if (Objects.equals(flat.getParentId(), parentId)) {
      CategoryTreeDto node = new CategoryTreeDto();
      node.setId(flat.getId());
      node.setName(flat.getName());
      node.setChildren(treeRecursive(flatList, flat.getId())); // 자식 재귀 탐색
      result.add(node);
    }
  }

  return result;
}
```

#### 결과

```
- 전자제품
  - 노트북
    - 게이밍 노트북
  - 스마트폰
    - 핸드폰 케이스
  - 주방가전
    - 믹서기
Map 방식: 0.144542 ms
재귀 방식: 85.677083 ms
```

#### tag3

- [목차](#tag0)

## 1. ORM과 Spring Data JPA, Hibernate 이해 🧐

Spring Data JPA는 Java Persistence API(JPA)를 기반으로 데이터를 다루는 데 필요한 코드를 최소화하여 생산성을 높이는 프레임워크입니다.
Hibernate는 JPA의 구현체로, 자바 객체와 데이터베이스 간의 매핑(ORM)을 수행합니다.

### ORM의 등장 배경: 개발자의 고충

- **과거의 개발 방식 (JDBC)**Java
    - 개발자는 자바 코드 내에 SQL 쿼리를 직접 작성하고, `ResultSet`의 결과를 다시 자바 객체로 한 줄 한 줄 변환하는 반복적인 작업을 수행해야 했습니다.

```java
// 옛날 방식 (JDBC)
String sql = "SELECT * FROM users WHERE id = ?";
PreparedStatement pstmt = connection.prepareStatement(sql);
pstmt.

setLong(1,1L);

ResultSet rs = pstmt.executeQuery();
User user = new User();
if(rs.

next()){
    user.

setId(rs.getLong("id"));
    user.

setUsername(rs.getString("username"));
    }
```

- **객체-관계 불일치 (Object-Relational Impedance Mismatch)**
    - 자바는 **객체 지향** 언어지만, 데이터베이스는 **관계형(테이블)** 구조를 가집니다. 이 둘의 패러다임이 달라 발생하는 근본적인 문제로 인해, 개발자는 핵심
      비즈니스 로직보다 데이터 변환 및 SQL 작성에 많은 시간을 소모했습니다.

### ORM과 Hibernate: 문제 해결사

- **ORM(Object-Relational Mapping)이란?**
    - 위에서 언급된 '객체-관계 불일치' 문제를 해결하기 위해 등장한 기술입니다. 객체와 DB 테이블을 자동으로 매핑하여, 개발자가 SQL 없이 객체 중심으로 데이터를 다룰
      수 있게 해줍니다.
- **Hibernate의 등장과 역할**
    - **Hibernate**는 이 ORM 개념을 구현한 가장 대표적인 프레임워크입니다.
    - 개발자가 `userRepository.save(user);`와 같이 객체 중심 코드를 작성하면, Hibernate가 적절한 SQL을 생성하고 실행하여 복잡한 데이터 변환
      과정을 마법처럼 처리해줍니다.
- **ORM의 장점**
    - **생산성 향상**: SQL보다 객체 중심의 코드로 비즈니스 로직에 집중할 수 있습니다.
    - **유지보수 용이**: 객체 모델만 수정하면 되므로 관리가 편합니다.
    - **DB 독립성**: 특정 데이터베이스에 종속되지 않는 코드를 작성할 수 있습니다.
    - **고급 기능**: Hibernate는 지연 로딩(Lazy Loading), 캐싱 등 성능 최적화를 위한 고급 기능을 제공합니다.

### JPA와 Spring Data JPA: 표준과 편의성

- **표준의 필요성 (JPA의 탄생)**
    - Hibernate는 매우 성공적이었지만, 모든 코드가 Hibernate에 종속되는 **'벤더 종속성(Vendor Lock-in)'** 문제가 있었습니다. 다른 ORM
      기술로 전환하려면 코드를 전부 수정해야 했기 때문입니다.
    - 이 문제를 해결하기 위해 자바 진영에서는 ORM 기술에 대한 '**표준 명세(Standard Specification)**'인 **JPA(Java Persistence
      API)**를 만들었습니다.
- **JPA(Java Persistence API)란?**
    - 데이터베이스 영속성을 다루는 자바 기술에 대한 **API 명세(Specification)이자 규칙**입니다.
    - `@Entity`, `@Id` 같은 어노테이션과 `persist()`, `find()` 같은 메서드를 표준으로 정의합니다.
    - **주의**: JPA 자체는 실제 동작하는 코드가 아니라, ORM 프레임워크들이 따라야 할 '**설계도**'입니다.
- **관계 요약**
    - **JPA (설계도)**: 데이터베이스 연동 기술에 대한 표준 명세(인터페이스)
    - **Hibernate (실제 일꾼)**: JPA라는 설계도를 보고 실제로 구현한 가장 유명한 구현체
    - **Spring Data JPA (편의 도구)**: Hibernate 같은 JPA 구현체를 더 쉽고 편하게 사용하도록 한 번 더 감싸서, `Repository`
      인터페이스만으로도 개발이 가능하게 만든 스프링 프레임워크의 모듈

## 2. Flyway를 활용한 DB 형상 관리 🗄️

애플리케이션 코드는 Git으로 버전을 관리하는데, 데이터베이스의 스키마(테이블 구조, 제약조건 등)는 어떻게 관리할까요? Flyway는 **데이터베이스의 변경 이력을 코드로 관리
**하여 이 문제를 해결하는 DB 마이그레이션 자동화 도구입니다.

### DB 형상 관리, 왜 중요한가?

팀 단위 개발 시, 각자 로컬 DB에서 작업하다 보면 스키마가 달라지는 경우가 많습니다. 누군가는 `ALTER TABLE`로 컬럼을 추가하고, 누군가는 `CREATE TABLE`로
새 테이블을 만듭니다. 이 변경 내역이 공유되지 않으면, 다른 팀원의 환경에서는 애플리케이션이 오류를 뿜는 '**DB 동기화 지옥**'이 펼쳐집니다. Flyway는 모든 DB 변경
사항을 파일로 기록하여, 팀 전체가 동일한 스키마 버전을 유지하도록 돕습니다.

### Flyway의 동작 원리

Flyway의 핵심은 **`flyway_schema_history`**라는 메타데이터 테이블입니다.

1. 애플리케이션이 시작되면, Flyway는 DB에 `flyway_schema_history` 테이블이 있는지 확인하고 없으면 자동으로 생성합니다.
2. 설정한 마이그레이션 파일 위치(`locations`)를 스캔하여 SQL 파일 목록을 읽어옵니다.
3. `flyway_schema_history` 테이블의 기록과 SQL 파일 목록을 비교하여, 아직 실행되지 않은 새로운 버전의 SQL 파일을 찾습니다.
4. 새로운 SQL 파일들을 **버전 순서대로** DB에 실행(migrate)합니다.
5. 실행이 성공하면, 해당 파일의 버전, 이름, 실행 시간 등의 정보를 `flyway_schema_history` 테이블에 기록합니다.

이 과정을 통해, Flyway는 어떤 변경사항이 언제 적용되었는지 추적하며, 항상 최신 버전의 DB 스키마를 유지합니다.

### Flyway 설정 및 사용법

- **`build.gradle` 의존성 추가**Groovy

```groovy
dependencies {
    implementation 'org.flywaydb:flyway-core'
    implementation 'org.flywaydb:flyway-mysql'
}
```

- `application.yml` 설정YAML

```
spring:
  flyway:
    enabled: true
    locations: classpath:db/migration # 마이그레이션 SQL 파일이 위치할 경로
    baseline-on-migrate: true # 기존에 테이블이 있는 DB에 Flyway를 처음 적용할 때 사용
```

- **마이그레이션 파일 작성**
  SQL 파일로 데이터베이스 변경 이력을 관리하며, 파일명 규칙을 반드시 따라야 합니다.
    - **명명 규칙**: `V<버전>__<설명>.sql` (V, 언더스코어 2개 `__`는 필수)
    - **예시**: `V1__create_users_table.sql`SQL

```sql
CREATE TABLE user
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(50)  NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP
);
```

### Flyway의 장점

- **신뢰성 있는 DB 배포**: 모든 변경 사항이 코드로 관리되므로, 개발/스테이징/운영 환경 모두에서 동일한 스키마를 보장하여 배포 안정성을 높입니다.
- **명확한 변경 이력 관리**: `flyway_schema_history` 테이블과 버전 관리된 SQL 파일들을 통해 누가, 언제, 어떤 이유로 DB를 변경했는지 명확하게
  추적할 수 있습니다.
- **팀원 간의 손쉬운 동기화**: Git을 통해 마이그레이션 파일을 공유하기만 하면, 모든 팀원이 `git pull` 후 애플리케이션을 실행하는 것만으로 최신 DB 스키마를
  맞출 수 있습니다.

## 3. HikariCP를 이용한 DB 커넥션 풀 관리 🏊

데이터베이스 스키마가 준비되면, 애플리케이션이 데이터베이스와 효율적으로 통신할 방법을 설정해야 합니다. 이때 **DB 커넥션 풀(Connection Pool)**이 핵심적인 역할을
합니다.

- **커넥션 풀이란?**
    - 데이터베이스 접속(Connection) 객체를 미리 여러 개 만들어 '**풀(Pool)**'에 저장해두고, 필요할 때마다 빌려 쓰고 반납하는 기술입니다.
    - 매번 요청이 올 때마다 새로운 연결을 만드는 비싼 과정(TCP/IP 핸드셰이크, DB 인증 등)을 생략하여 **애플리케이션의 전반적인 응답 속도와 성능을 크게 향상**
      시킵니다.
- **HikariCP의 역할**
    - **HikariCP**는 Spring Boot 2.0부터 기본으로 채택된 매우 빠르고 안정적인 커넥션 풀 라이브러리입니다.
    - 개발자가 별도 설정을 하지 않아도 Spring Boot가 자동으로 HikariCP를 설정하여 최적의 성능을 제공합니다.

### 왜 Spring Boot는 HikariCP를 선택했는가?

과거에는 **Apache Commons DBCP**나 **Tomcat-JDBC Pool** 같은 커넥션 풀이 널리 사용되었습니다. 이들도 훌륭한 라이브러리지만, **개발자들은 더
높은 성능과 안정성을 갈망했습니다.**

**HikariCP**는 바로 이 지점에서 등장했습니다. 'Hikari(히카리)'는 일본어로 '빛'을 의미하며, 이름처럼 빛의 속도를 지향합니다. 바이트 코드 레벨까지 최적화하는
등 극단적인 성능 개선을 통해 기존 커넥션 풀들의 성능을 압도했습니다. 벤치마크에서 월등한 성능과 안정성을 입증하자, **Spring Boot 2.0부터는 HikariCP를 기본
커넥션 풀로 채택**하여 모든 개발자가 별도 설정 없이도 최고의 성능을 누릴 수 있도록 했습니다.

### HikariCP의 장점과 단점

**✅ 장점 (Advantages)**

- **압도적인 성능**: 바이트 코드 조작, Lock 최소화 등 저수준 최적화를 통해 다른 어떤 커넥션 풀보다 빠릅니다. 이는 대규모 트래픽 상황에서 큰 차이를 만듭니다.
- **높은 안정성과 신뢰성**: 커넥션 누수(Leak)를 방지하고, 유휴 커넥션을 효과적으로 관리하는 등 안정성에 초점을 맞춰 설계되었습니다.
- **간결한 구성**: 복잡하고 불필요한 설정 옵션을 과감히 제거했습니다. 개발자가 꼭 필요한 몇 가지 옵션만으로 쉽게 설정하고 안정적으로 운영할 수 있습니다.
- **활발한 유지보수**: Spring Boot의 기본 값으로 채택되면서 거대한 사용자층을 확보했고, 지금도 매우 활발하게 유지보수되고 있습니다.

**❌ 단점 (Disadvantages)**

- **제한적인 고급 기능**: 간결함을 추구하는 철학 때문에 아주 특수한 상황에서 필요한 일부 고급 모니터링이나 유연한 확장 기능이 부족하다고 느껴질 수 있습니다.
- **복잡한 내부 구조**: 사용법은 간단하지만, 최고의 성능을 위해 내부 구현은 매우 복잡합니다. 따라서 커넥션 풀 자체의 동작 방식을 깊게 디버깅해야 할 때 진입 장벽이 높을
  수 있습니다.

### **주요 설정 (`application.yml`)**

기본값으로도 훌륭하지만, 서비스의 특성에 맞게 아래와 같이 상세 설정이 가능합니다.

```yaml
spring:
  datasource:
    hikari:
      maximum-pool-size: 10  # 최대 커넥션 개수
      connection-timeout: 30000 # 커넥션을 얻기 위해 대기하는 최대 시간 (ms)
      max-lifetime: 1800000 # 커넥션의 최대 수명 (ms)
```

## 4. JPA Entity 설계 📝

JPA 엔티티(Entity)는 데이터베이스 테이블에 대응하는 자바 클래스입니다. 단순히 데이터를 담는 객체를 넘어, JPA가 관리하며 데이터베이스와 직접 상호작용하는 핵심적인
역할을 합니다. `@Entity` 어노테이션이 붙은 클래스는 JPA가 관리하는 '객체'가 됩니다.

### 핵심 어노테이션: `@Entity`와 `@Table`

- **`@Entity`**
    - 이 클래스가 JPA가 관리해야 하는 엔티티임을 표시합니다. **필수 어노테이션**입니다.
    - 주의: 기본 생성자(no-args constructor)가 반드시 필요하며, final 클래스에는 사용할 수 없습니다.
- **`@Table(name = "...")`**
    - 엔티티 클래스가 매핑될 데이터베이스 테이블의 이름을 지정합니다.
    - 만약 생략하면, 엔티티 클래스 이름을 테이블 이름으로 사용합니다. (예: `User` -> `user`)

### 네이밍 컨벤션: 이름 설정 시 고려사항

테이블 및 컬럼 이름을 정할 때는 일관된 규칙을 따르는 것이 매우 중요합니다.

- **테이블/컬럼명 설정 시 주의점**
    - **네이밍 전략(Naming Strategy)**
        - Java에서는 `camelCase`(예: `userName`)를, DB에서는 `snake_case`(예: `user_name`)를 사용하는 것이 일반적입니다.
          Spring Boot는 이 변환을 자동으로 처리해주는 전략(SpringPhysicalNamingStrategy)을 기본으로 사용하므로,
          `@Column(name = "user_name")`처럼 명시하지 않아도 필드 `userName`은 자동으로 컬럼 `user_name`에 매핑됩니다.
    - **DB 예약어 주의**
        - `USER`, `ORDER`, `GROUP` 등은 데이터베이스의 예약어일 수 있습니다. **테이블명이나 컬럼명으로 사용하면 예기치 않은 SQL 오류가 발생할 수
          있으므로 무조건 피하는 것이 좋습니다.**
          부득이하게 사용해야 할 경우, @Table(name = "`order`")처럼 백틱()으로 감싸서 이스케이프 처리를 할 수 있습니다.

- **테이블명, 단수형 vs 복수형?**
    - **전통적인 방식 (복수형 - `users`)**
        - 데이터베이스 관점에서는 테이블을 데이터의 '집합(Collection)'으로 봅니다. 따라서 '사용자들의 모음'이라는 의미로 `users`, `orders`처럼
          복수형을 사용하는 것이 일반적이었습니다.
    - **ORM/JPA 관점 (단수형 - `user`)**
        - 최근 ORM이 널리 쓰이면서 생긴 경향입니다. ORM은 `User`라는 엔티티 클래스(객체) 하나가 `user`라는 테이블 하나와 1:1로 매핑된다고 봅니다.
          즉, 객체의 관점을 따라 단수형으로 이름을 일치시키는 것이 더 직관적이라는 것입니다.

    - 어느 한쪽이 절대적으로 옳다고 할 수는 없습니다. 하지만 최신 개발 트렌드에서는 ORM의 관점을 따라 **단수형 명명 규칙을 사용하는 경우가 많습니다.** 가장 중요한
      것은, **프로젝트 내에서 하나의 컨벤션을 정하고 일관되게 지키는 것입니다.**

- **상태(Boolean) 타입 필드 네이밍**
    - **Java/API 네이밍 (`is-` / `has-` / `can-`)**
        - Boolean 타입의 필드명은 그 자체로 '참/거짓'으로 답할 수 있는 질문이 되도록 짓는 것이 가장 좋습니다. `is~`로 시작하는 네이밍은 **자바빈(
          JavaBean) 표준 명세**에 따른 규칙으로, 여러 프레임워크(Lombok, Jackson 등)가 이를 자동으로 인지하여 가독성과 개발 편의성을 높여줍니다.
        - **가독성**: `if (user.isActive())` 처럼 코드가 자연스러운 영어 문장처럼 읽힙니다.
    - **대표 접두사**
        - **`is~`**: 상태를 나타낼 때 (e.g., `isActive`, `isDeleted`, `isVisible`)
        - **`has~`**: 소유나 포함 여부를 나타낼 때 (e.g., `hasProfileImage`, `hasCoupon`)
        - **`can~`**: 가능/권한 여부를 나타낼 때 (e.g., `canPurchase`, `canComment`)

### 기본 키(Primary Key) 매핑: `@Id`와 `@GeneratedValue`

- **`@Id`**
    - 테이블의 기본 키(PK)에 해당하는 필드를 나타냅니다. 모든 엔티티는 `@Id`가 붙은 필드를 반드시 가져야 합니다.
- **`@GeneratedValue(strategy = ...)`**
    - 기본 키의 값을 데이터베이스가 자동으로 생성하도록 위임하는 방법을 지정합니다.
    - **`GenerationType.IDENTITY`**: **MySQL**의 `AUTO_INCREMENT`처럼 데이터베이스가 직접 ID를 생성하고 관리하게 합니다.
      데이터가 저장(INSERT)된 후에야 ID 값을 알 수 있습니다.
    - **`GenerationType.SEQUENCE`**: **Oracle** 등에서 사용하는 시퀀스 객체를 통해 ID를 할당받습니다.
    - **`GenerationType.AUTO`**: (기본값) 사용하는 데이터베이스 방언(Dialect)에 맞춰 위 전략 중 하나를 JPA가 자동으로 선택합니다.

### 필드-컬럼 매핑: `@Column`과 기타 어노테이션

- **`@Column`**
    - 엔티티의 필드와 테이블의 컬럼을 매핑합니다. 다양한 속성을 통해 컬럼의 제약조건 등을 설정할 수 있습니다.
    - **`name`**: 매핑할 테이블 컬럼의 이름을 지정합니다. (예: `createdAt` -> `created_at`)
    - **`nullable = false`**: `NOT NULL` 제약조건을 설정합니다.
    - **`unique = true`**: `UNIQUE` 제약조건을 설정합니다.
    - **`length`**: `VARCHAR` 타입 컬럼의 길이를 지정합니다.
- **`@CreationTimestamp` / `@UpdateTimestamp`** (Hibernate 기능)
    - 데이터가 처음 생성될 때(`@CreationTimestamp`) 또는 수정될 때(`@UpdateTimestamp`)의 시간을 자동으로 기록해주는 편리한 기능입니다.
- **`@DynamicInsert` / `@DynamicUpdate`**
    - **`@DynamicInsert`**: `INSERT` SQL 생성 시, 값이 `null`이 아닌 필드만으로 쿼리를 만듭니다. 데이터베이스에 설정된 `DEFAULT`
      값을 적용하고 싶을 때 유용합니다.
    - **`@DynamicUpdate`**: `UPDATE` SQL 생성 시, 변경된 필드만으로 쿼리를 만듭니다. 불필요한 필드 업데이트를 막아 성능에 이점을 줄 수
      있습니다.

### User 엔티티 설계 예제 (주석 포함)

```java

@Entity // 이 클래스는 JPA가 관리하는 엔티티입니다.
@Getter // Lombok: Getter 메서드를 자동 생성합니다.
@DynamicInsert // 값이 null이 아닌 필드만으로 INSERT 쿼리를 생성합니다.
@DynamicUpdate // 변경된 필드만으로 UPDATE 쿼리를 생성합니다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 기본 생성자를 필요로 합니다.
@Table(name = "user") // 'user'라는 이름의 테이블과 매핑됩니다.
public class User {

  @Id // 이 필드가 테이블의 Primary Key(기본 키)입니다.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성을 DB의 AUTO_INCREMENT에 위임합니다.
  private Long id;

  @Column(name = "username", nullable = false, length = 50) // 'username' 컬럼, NOT NULL, 길이 50
  private final String username;

  @Column(nullable = false, unique = true) // 'email' 컬럼, NOT NULL, UNIQUE
  private final String email;

  @Column(name = "password_hash", nullable = false)
  private final String passwordHash;

  @CreationTimestamp // 엔티티가 생성될 때의 시간이 자동으로 기록됩니다.
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp // 엔티티가 수정될 때의 시간이 자동으로 기록됩니다.
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Builder // 빌더 패턴으로 객체를 생성할 수 있게 합니다.
  public User(
      String username,
      String email,
      String passwordHash
  ) {
    this.username = username;
    this.email = email;
    this.passwordHash = passwordHash;
  }
}
```

## 5. Spring Data JPA Repository 작성법 🛠️

엔티티(Entity)를 통해 실제 데이터베이스 작업을 수행할 **리포지토리(Repository)** 인터페이스를 작성합니다. 리포지토리는 데이터 접근 계층(DAO)을 더 쉽고
세련되게 다룰 수 있도록 해주는 핵심적인 추상화 계층입니다.

### 기본 개념 및 CRUD: `JpaRepository` 인터페이스

Spring Data JPA의 마법은 `JpaRepository` 인터페이스를 상속받는 것에서 시작됩니다. 개발자가 이 인터페이스를 상속받은 자신만의 인터페이스를 정의하면,
Spring이 실행 시점에 동적으로 구현체를 생성해줍니다.

```java
// JpaRepository<T, ID>
// T: 리포지토리에서 다룰 엔티티 클래스 (예: User)
// ID: 해당 엔티티의 Primary Key 필드 타입 (예: Long)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  // 이 안에 코드가 없어도 아래의 주요 메서드들을 바로 주입받아 사용할 수 있습니다.
}
```

- **주요 기본 제공 메서드**
    - `save(S entity)`: 새로운 엔티티는 저장(**INSERT**)하고, 이미 존재하는 엔티티는 병합(**UPDATE**)합니다.
    - `findById(ID id)`: PK를 기준으로 엔티티 하나를 조회합니다. 결과는 `Optional<T>`로 반환되어 Null-safe한 처리를 돕습니다.
    - `findAll()`: 모든 엔티티를 조회합니다. (`List<T>`)
    - `count()`: 엔티티의 총 개수를 반환합니다. (`long`)
    - `delete(T entity)`: 특정 엔티티를 삭제합니다.
    - `deleteById(ID id)`: PK를 기준으로 엔티티를 삭제합니다.

### 메서드 이름 기반 쿼리 (Query from Method Names)

가장 직관적이고 생산성이 높은 기능입니다. 정해진 규칙에 따라 메서드 이름을 지으면, Spring Data JPA가 메서드 이름을 분석하여 자동으로 JPQL 쿼리를 생성하고
실행합니다.

- **쿼리 생성 규칙**: `(find/read/query/count/delete)By...[And/Or]...[OrderBy]`
    - **기본 조회**: `findByUsername(String username)`
        - `SELECT u FROM User u WHERE u.username = ?1`

    - **조건 조합 (`And`, `Or`)**: `findByUsernameAndRole(String username, String role)`
        - `SELECT u FROM User u WHERE u.username = ?1 AND u.role = ?2`

    - **다양한 조건 키워드**:
        - `Containing`: `LIKE '%...%'` 검색. `findByUsernameContaining("test")`
        - `StartingWith`: `LIKE '...%'` 검색.
        - `GreaterThan` / `LessThan`: 특정 값보다 크거나 작음. `findByAgeGreaterThan(20)`
        - `After` / `Before`: 날짜 비교. `findByCreatedAtAfter(LocalDateTime.now().minusDays(1))`
        - `OrderBy`: 정렬. `findAllByOrderByCreatedAtDesc()`

```java
public interface UserRepository extends JpaRepository<User, Long> {

  // 이메일로 유저 조회 (결과가 없을 수 있으므로 Optional 사용)
  Optional<User> findByEmail(String email);

  // 특정 날짜 이후에 가입한 유저들을 이름 순으로 정렬하여 조회
  List<User> findByCreatedAtAfterOrderByUsernameAsc(LocalDateTime dateTime);

  // 'role'이 'admin'인 유저의 수를 카운트
  long countByRole(String role);
}
```

- **장점**: 간단한 쿼리를 매우 빠르고 직관적으로 작성할 수 있으며, 컴파일 시점에 오타 등을 체크할 수 있습니다.
- **단점**: 조건이 복잡해지면 메서드 이름이 지나치게 길어져 가독성이 떨어집니다.

### `@Query`를 이용한 커스텀 쿼리

메서드 이름만으로 표현하기 힘든 복잡한 쿼리(JOIN, 서브쿼리 등)나, DTO로 직접 결과를 매핑하고 싶을 때 사용합니다. **JPQL(Java Persistence Query
Language)**을 사용하여 직접 쿼리를 작성합니다.

- **JPQL (Java Persistence Query Language)**
    - 데이터베이스 테이블이 아닌 **엔티티 객체**를 대상으로 하는 객체지향 쿼리 언어입니다. `FROM User u`처럼 테이블명이 아닌 엔티티 클래스명을 사용합니다.

- **`@Query` 기본 사용법**
    - **Named Parameters**:
        - `:(파라미터명)`으로 쿼리에 변수를 바인딩합니다. 메서드 파라미터에 `@Param` 어노테이션을 사용하여 어떤 값이 어떤 이름의 파라미터에 매핑될지 명확히
          지정할 수 있습니다. 가독성이 높아 권장되는 방식입니다.
    - **예시: 이메일로 사용자 조회**

```
// 이메일 주소는 고유(unique)하므로, 조회 결과는 단일 객체입니다.
// 결과가 없을 수도 있는 상황을 고려하여 Optional<User>로 반환하는 것이 안전합니다.
@Query("SELECT u FROM User u WHERE u.email = :email")
Optional<User> findUserByEmail(@Param("email") String email);
```

- **`@Query(...)`**: `FROM User u`는 `user` 테이블이 아닌 `User` 엔티티 객체를 의미합니다. JPQL은 이처럼 객체지향적으로 쿼리를
  작성합니다.
- **`:email`**: 쿼리 내에서 사용될 명명된 파라미터(Named Parameter)입니다.
- **`@Param("email")`**: 메서드의 파라미터

- **네이티브 쿼리 (Native Query)**
    - JPQL로 해결할 수 없는 데이터베이스 고유의 함수나 문법을 사용해야 할 때, `nativeQuery = true` 속성을 사용해 순수 SQL을 직접 작성할 수
      있습니다.

```
// 예시: MySQL의 특정 함수를 사용해야 할 경우
@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
User findByUsernameNative(String username);
```

## 6. 실습: DB 테이블 설계부터 Repository 작성까지 🚀

위에서 배운 모든 개념을 종합하여 실습을 진행합니다.

1. **DB 테이블 설계 및 Flyway 마이그레이션**
    - 회원(User) 등 필요한 테이블을 설계합니다.
    - `V2__create_user_table.sql` 등 마이그레이션 파일을 작성합니다.
    - 테이블 생성 후, 수정 사항이 발생하였을 경우를 가정하여 `status`컬럼을 추가합니다.
2. **JPA Entity 작성**
    - `User`엔티티를 자바 클래스로 작성합니다.
3. **Repository 작성 및 테스트**
    - `UserRepository`를 작성합니다.

### **이번에 배울 것**

#### tag4

- [목차](#tag0)

<aside>
❗ 이번 학습에서는 데이터베이스 설계의 기초부터 실전까지 모든 것을 아우르는 시간을 갖습니다. 
단일 테이블의 기본 구조부터 시작하여, 가장 중요한 1:N 및 N:N 연관관계, 그리고 계층형 데이터 구조를 설계하는 방법을 익히고, 데이터 무결성을 위한 정규화(Normalization)와 성능 최적화를 위한 반정규화 사이에서 균형을 잡는 현대적인 접근 방식을 학습합니다. 

마지막으로 이 모든 이론을 종합하여 실제 쇼핑몰 데이터베이스 스키마를 직접 설계하고, 이를 JPA의 `@ManyToOne`, `@OneToMany` 어노테이션으로 엔티티에 녹여내어
관계를 매핑하는 전체 과정을 실습을 통해 완성하게 됩니다.

</aside>

## 1. 단일 테이블 구조 설계 💡

단일 테이블 설계는 모든 데이터베이스 설계의 출발점입니다. 단순히 컬럼을 나열하는 것을 넘어, 데이터의 정체성과 규칙을 정의하는 과정입니다.

### 테이블 기본 구조와 PK 정의

- **핵심 개념: 대리 키(Surrogate Key) vs 자연 키(Natural Key)**
    - **대리 키 (권장)**: `id BIGINT AUTO_INCREMENT`처럼 비즈니스와 직접적인 관련이 없는, 오직 데이터 식별만을 위해 인위적으로 부여된 키입니다.
      **변경될 일이 없고 항상 고유함을 보장**하므로 현대 애플리케이션에서 PK로 사용하는 것을 강력히 권장합니다.
    - **자연 키**: 이메일이나 주민등록번호처럼 비즈니스 로직에 실제 존재하는 값으로 PK를 잡는 것입니다. 하지만 이런 값은 변경될 수 있거나 개인정보보호 이슈가 있어
      PK로 사용하기에 적합하지 않은 경우가 많습니다.
- 테이블 설계 예제 (`user` 테이블)**SQL

```sql
CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(50)  NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

- **설계 포인트**
    - `id`는 대리 키(PK)로, 각 사용자를 고유하게 식별합니다.
    - `email` 컬럼에 `UNIQUE` 제약조건을 걸어 데이터 중복을 방지합니다.
    - `NOT NULL` 제약조건을 적절히 활용하여 데이터 무결성을 보장합니다.
    - 컬럼 이름은 명확하고 직관적으로 정의해야 유지보수성을 높일 수 있습니다.
    - 데이터 타입과 제약 조건(`NOT NULL`, `UNIQUE`)을 적절히 설정하여 데이터 무결성을 보장합니다.

## 2. 테이블 간 연관관계 설계 🔗

데이터의 중복을 최소화하고 일관성을 유지하기 위해 **정규화(Normalization)** 과정을 거쳐 테이블을 분리하고 관계를 맺습니다. 이 관계를 어떻게 맺느냐에 따라 시스템의
성능과 확장성이 결정됩니다.

### 1:N 관계 (One-to-Many)

하나의 엔티티가 여러 다른 엔티티와 관계를 맺는, 가장 흔하고 기본적인 관계입니다.

- 데이터 중복을 피하기 위해 1쪽에 해당하는 정보를 분리하고, N쪽에서 1쪽의 데이터를 참조하는 방식입니다. 예를 들어, 한 명의 사용자 정보를 여러 주문에 반복해서 저장하는
  대신, `user` 테이블을 만들고 `order` 테이블에서는 해당 사용자의 ID만 참조합니다.
- **예제**: 한 명의 사용자(1)는 여러 개의 주문(N)을 가질 수 있습니다.SQL

```sql
-- purchase 테이블
CREATE TABLE purchase
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT         NOT NULL, -- FK: 어떤 user의 주문인지 식별
    total_price DECIMAL(10, 2) NOT NULL,
    status      VARCHAR(20)    NOT NULL,
    created_at  DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)
);
```

- **JPA 엔티티 매핑 예시**
    - **`User` (1쪽 엔티티)**: 자신이 가진 주문 목록을 관리합니다.

```java

@Entity
public class User {

  // ...
  // '나'는 Order 엔티티의 'user' 필드에 의해 매핑되었다.
  @OneToMany(mappedBy = "user")
  private final List<Order> orders = new ArrayList<>();
}
```

- **Order (N쪽 엔티티, 연관관계의 주인): 자신이 속한 사용자를 명시합니다.**

```java

@Entity
public class Order {

  // ...
  @ManyToOne(fetch = FetchType.LAZY) // Order(N) : User(1) 관계
  @JoinColumn(name = "user_id") // DB의 user_id 컬럼과 매핑
  private User user;
}
```

- **설계 포인트 및 고려사항**
  연관관계의 주인(Owner): 외래 키(user_id)를 관리하는 N쪽(Order)이 연관관계의 주인이 됩니다.

### N:N 관계 (Many-to-Many)

양쪽 엔티티가 서로에게 1:N 관계를 가지는 경우로, 데이터베이스에서는 직접 표현할 수 없어 중간에 **연결 테이블(Junction Table)**을 두어 1:N 관계 두 개로
풀어냅니다.

- '주문-상품' 관계처럼, 하나의 주문에 여러 상품이 포함되고 하나의 상품도 여러 주문에 포함될 수 있는 복잡한 관계를 표현합니다.
- **예제**: 하나의 주문(N) ↔ 여러 상품(N)SQL

```sql
-- 연결 테이블: `purchase_item`
CREATE TABLE purchase_item
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    purchase_id BIGINT         NOT NULL, -- FK: 어떤 주문에 속하는지
    product_id  BIGINT         NOT NULL, -- FK: 어떤 상품인지
    quantity    INT            NOT NULL, -- 주문 수량
    price       DECIMAL(10, 2) NOT NULL  -- 주문 시점의 상품 가격
);
```

- **JPA 엔티티 매핑 예시 (권장 방식)**
  @ManyToMany는 실무에서 비추천: 연결 테이블에 quantity, price 같은 추가 정보를 담을 수 없고, 복잡한 쿼리 작성이 어려워 거의 사용하지 않습니다.
  연결 테이블을 별도의 엔티티로 승격하여 1:N, N:1 관계로 풀어내는 것이 정석입니다.

```java

@Entity
public class PurchaseItem {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "purchase_id")
  private Purchase purchase;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  private int quantity;
  private BigDecimal price;
}
```

- **설계 포인트 및 고려사항**
    - 연결 테이블은 단순히 관계만 맺는 것이 아니라, **관계 자체에 대한 의미 있는 데이터**(주문 수량, 주문 시점 가격 등)를 저장하는 중요한 역할을 합니다.

### 계층형 관계 (트리 구조)

카테고리, 댓글 등 계층 구조를 표현할 때 사용하며, 엔티티가 자기 자신을 참조하는 **자기 참조(Self-Referencing)** 관계를 통해 부모-자식 구조를 만듭니다.

- 조직도나 파일 시스템처럼 상위-하위 관계가 반복되는 데이터를 표현하는 데 사용됩니다. 가장 일반적인 구현 방식은 **인접 리스트(Adjacency List)** 모델입니다.
- **예제**: 카테고리 테이블 (인접 리스트 모델)SQL

```sql
CREATE TABLE category
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    parent_id BIGINT DEFAULT NULL -- FK: 부모 카테고리의 id를 참조
);
```

- **JPA 엔티티 매핑 예시**

```java

@Entity
public class Category {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private Category parent; // 부모 카테고리

  @OneToMany(mappedBy = "parent")
  private final List<Category> children = new ArrayList<>(); // 자식 카테고리 목록
}
```

- **설계 포인트 및 고려사항**
    - **장점**: 구조가 매우 직관적이고 데이터를 추가하거나 수정하기 쉽습니다.
    - **단점**: 특정 노드의 모든 하위 노드를 조회하려면 여러 번의 재귀적인 쿼리가 필요하여, 트리의 깊이가 깊어질수록 조회 성능이 급격히 저하될 수 있습니다.
    - **대안 모델**: 대용량 계층형 데이터를 다룰 때는 조회 성능이 더 좋은 **Nested Set**이나 **Materialized Path** 같은 다른 모델을
      고려하기도 합니다. (이는 더 심화된 주제입니다.)

### FOREIGN KEY 제약조건: 써야 할까, 말아야 할까? 🤔

제공해주신 내용은 `FOREIGN KEY`를 사용하지 않는 이유에 초점이 맞춰져 있습니다. 이는 대규모 트래픽 서비스나 MSA 환경에서 주로 논의되는 내용으로, 장단점을 균형 있게
이해하는 것이 중요합니다.

**✅ `FOREIGN KEY`를 사용하는 이유 (장점) - 데이터 무결성 최우선**

- **데이터 무결성 보장 (가장 큰 장점)**: 데이터베이스 레벨에서 참조 관계의 유효성을 **강제로 보장**합니다. 예를 들어, 존재하지 않는 `user_id`로 주문을
  생성하는 것을 원천적으로 차단하여 '고아 데이터' 발생을 막습니다.
- **애플리케이션 개발 단순화**: 데이터 정합성을 DB에 위임하므로, 애플리케이션 코드에서 모든 예외 케이스를 처리해야 하는 부담이 줄어듭니다.
- **명시적인 관계 정의**: 테이블 구조만 봐도 데이터 간의 관계를 명확하게 파악할 수 있어 문서의 역할을 합니다.

**⚠️ `FOREIGN KEY`를 사용하지 않는 이유 (단점) - 유연성과 성능 최우선**

- **성능 오버헤드**: `INSERT`, `UPDATE`, `DELETE` 시마다 참조 무결성을 확인하는 비용이 발생합니다. 초당 수천, 수만 건의 쓰기 작업이 발생하는
  시스템에서는 이 오버헤드가 병목이 될 수 있습니다.
- **개발 및 마이그레이션 복잡성**: 테이블 변경이나 데이터 이전 작업 시, 참조 순서를 고려해야 하므로 작업이 복잡해지고 제약이 많아집니다.
- **분산 시스템(MSA)에서의 한계**: 서비스별로 데이터베이스가 분리된 마이크로서비스 아키텍처에서는 DB 레벨의 `FOREIGN KEY`를 물리적으로 사용할 수 없습니다.

**상황에 맞는 선택이 중요**

- **일반적인 웹 애플리케이션 / 모노리스 아키텍처**: **`FOREIGN KEY` 사용을 적극 권장**합니다. 성능 저하보다 데이터 무결성을 보장하는 이점이 훨씬 큽니다.
- **대규모 트래픽 서비스 / MSA**: `FOREIGN KEY`를 사용하지 않고, **애플리케이션 레벨에서 코드(ORM, 로직)로 데이터의 정합성을 관리**하는 전략을
  선택하는 경우가 많습니다. 이는 시스템의 확장성과 유연성을 극대화하기 위한 선택입니다.

## 3. 데이터 정규화(Normalization)의 현대적 접근 💡

정규화는 데이터베이스 설계 시 **데이터의 중복을 최소화하고 무결성을 보장**하기 위해 테이블을 구조화하는 체계적인 과정입니다. 정규화를 통해 '데이터 이상 현상(Anomaly)'
을 방지하고, 더 효율적이고 논리적인 데이터 모델을 만들 수 있습니다.

### 정규화의 핵심 목표: 데이터 이상 현상(Anomaly) 방지

만약 정규화 없이 하나의 테이블에 모든 정보를 저장하면 다음과 같은 문제가 발생합니다.

| **주문번호** | **고객ID** | **고객이름** | **고객등급** | **상품명** | **상품가격** |
|----------|----------|----------|----------|---------|----------|
| 1001     | user01   | 김철수      | GOLD     | 노트북     | 1500000  |
| 1002     | user02   | 이영희      | SILVER   | 키보드     | 50000    |
| 1003     | user01   | 김철수      | GOLD     | 마우스     | 30000    |

- **갱신 이상 (Update Anomaly)**: '김철수'의 등급이 'VIP'로 변경되면, 1001번과 1003번 주문의 '고객등급'을 모두 바꿔야 합니다. 하나라도 누락되면
  데이터가 불일치하게 됩니다.
- **삽입 이상 (Insertion Anomaly)**: 아직 주문을 하지 않은 신규 고객 '박민준'을 등록하려면, 불필요한 주문번호나 상품명까지 `NULL`로 넣어야 하는
  문제가 발생합니다.
- **삭제 이상 (Deletion Anomaly)**: '이영희' 고객이 1002번 주문을 취소하여 해당 데이터가 삭제되면, '이영희'라는 고객 정보 자체가 DB에서 사라져
  버립니다.

**정규화는 이러한 문제를 해결하기 위해 테이블을 논리적인 단위로 분해하는 과정입니다.**

### 핵심 정규형 (1NF, 2NF, 3NF) 쉽게 이해하기

이론적으로는 5NF, BCNF 등 여러 단계가 있지만, 실무에서는 **제3정규형(3NF)까지 만족시키는 것을 목표**로 하는 경우가 대부분입니다.

- **제1정규형 (1NF): 모든 컬럼은 원자적(Atomic) 값을 가져야 한다.**
    - **의미**: 한 칸에 여러 개의 값이 들어갈 수 없습니다.
    - **예시**: `취미` 컬럼에 '농구, 축구'처럼 쉼표로 구분된 값을 넣으면 1NF 위반입니다.
    - **해결**: 별도의 `취미` 테이블을 만들거나, 각 취미를 별개의 행으로 분리해야 합니다.

- **제2정규형 (2NF): 부분 함수 종속을 제거한다. (PK가 여러 컬럼일 때 적용)**
    - **의미**: 테이블의 모든 컬럼은 **반드시 기본 키(PK) 전체에 종속**되어야 합니다. PK의 일부에만 종속되어서는 안 됩니다.
    - **예시**: `(주문번호, 상품번호)`가 PK인 테이블에서 `상품명`은 `상품번호`에만 종속됩니다. `주문번호`와는 관계가 없습니다. 이것이 '부분 함수 종속'입니다.
    - **해결**: `상품명`을 별도의 `상품` 테이블로 분리합니다. (`order_item`과 `product`의 관계)

- **제3정규형 (3NF): 이행 함수 종속을 제거한다.**
    - **의미**: 기본 키(PK)가 아닌 컬럼들끼리 서로 의존해서는 안 됩니다.
    - **예시**: `주문` 테이블에 `고객ID`, `고객이름`, `고객등급`이 모두 있다면, `고객이름`과 `고객등급`은 PK인 `주문ID`가 아닌 `고객ID`에 의해
      결정됩니다. 이것이 '이행 함수 종속'입니다.
    - **해결**: `고객이름`, `고객등급`을 별도의 `고객` 테이블로 분리합니다. (`order`와 `user`의 관계)

위의 1, 2, 3차 정규화를 거치면 맨 처음의 비정규화 테이블은 `users`, `products`, `orders`, `order_items` 와 같이 논리적으로 잘 분리된
테이블 구조를 갖추게 됩니다.

### 현대적 관점: 정규화와 반정규화(Denormalization)의 줄다리기

"정규화 수준이 높을수록 무조건 좋은 설계인가?" **현대적인 관점에서는 꼭 그렇지만은 않습니다.**

- **반정규화(Denormalization)란?**
    - 데이터 조회 성능을 향상시키기 위해 **의도적으로 정규화 원칙을 위배**하여, 테이블에 중복 데이터를 추가하거나 테이블을 병합하는 과정입니다.

| **구분** | **정규화 (Normalization)**          | **반정규화 (Denormalization)**            |
|--------|----------------------------------|---------------------------------------|
| **장점** | 데이터 무결성 극대화, 중복 최소화, 데이터 모델 유연   | **조회 성능 향상 (JOIN 감소)**, 쿼리 단순화        |
| **단점** | 여러 테이블을 `JOIN`해야 하므로 조회 성능 저하 가능 | 데이터 중복 발생, 데이터 불일치 위험 증가, 입력/수정/삭제 복잡 |

- **언제 반정규화를 고려하는가?**
    - **읽기 작업이 압도적으로 많을 때**: 통계, 대시보드처럼 조회가 빈번한데, 매번 여러 테이블을 `JOIN`하는 비용이 너무 클 경우.
    - **미리 계산된 값이 필요할 때**: 게시물의 `좋아요 수`나 `댓글 수`처럼 자주 필요한 값을 매번 `COUNT(*)`로 계산하는 대신, 게시물 테이블에
      `like_count`, `comment_count` 컬럼을 두어 관리합니다.

### 실용적인 데이터베이스 설계 전략

현대적인 데이터베이스 설계는 정규화를 맹목적으로 따르기보다, **상황에 맞게 정규화와 반정규화를 조율하는 실용적인 접근**을 취합니다.

1. **기본은 정규화**: 우선 **제3정규형(3NF)을 목표로** 데이터 모델을 설계하여 데이터 무결성과 유연성을 확보합니다.
2. **성능 측정**: 애플리케이션을 개발하고 실제 사용 시나리오에 맞춰 성능을 측정합니다.
3. **병목 지점 식별**: 특정 조회 쿼리에서 `JOIN`으로 인한 성능 저하가 명확하게 **증명되면**,
4. **전략적 반정규화**: 해당 부분에만 **제한적으로 반정규화**를 적용하여 성능을 최적화합니다.

<aside>

**"일단 정규화하고, 성능 문제가 발생하면 측정하여 필요한 곳만 반정규화하라 <br> (Normalize first, denormalize where proven
necessary)"** 가 현대적인 데이터 설계의 핵심 원칙입니다.
</aside>

## 4. 쇼핑몰 DB 테이블 설계: 기본 구조와 관계 🛍️

온라인 쇼핑몰의 핵심 기능인 사용자, 상품, 주문을 처리하기 위한 데이터베이스 스키마 예제입니다. 이 설계는 데이터 중복을 최소화하고 일관성을 유지하는 정규화 원칙을 따릅니다.

### 핵심 엔티티: `user`와 `product`

모든 상거래의 기본이 되는 '누가(user)' '무엇을(product)' 사고파는지 정의하는 테이블입니다.

- **`user` 테이블**
    - **역할**: 회원가입한 고객의 정보를 저장합니다.
    - **주요 설계 포인트**:
        - `email`에 **UNIQUE** 제약조건을 설정하여 중복 가입을 방지합니다.
        - `password_hash`처럼 비밀번호는 절대 원본 그대로 저장하지 않고, 반드시 해시(hash)하여 저장해야 합니다.
- **`product` 테이블**SQL
    - **역할**: 판매하는 상품의 상세 정보를 저장합니다.
    - **주요 설계 포인트**:
        - `stock` 컬럼을 통해 상품의 재고를 관리하며, 주문 시 이 값을 감소시키는 로직이 필요합니다.
        - `price`는 현재 시점의 상품 판매 가격을 의미합니다.

```sql
-- user Table
CREATE TABLE user
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(50)  NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- product Table
CREATE TABLE product
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    stock       INT            NOT NULL DEFAULT 0,
    category_id BIGINT COMMENT '상품이 속한 카테고리 ID',
    created_at  DATETIME                DEFAULT CURRENT_TIMESTAMP,
    updated_at  DATETIME                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### 계층 구조 데이터: `category`

상품을 효율적으로 분류하고 탐색할 수 있도록 계층 구조를 가진 카테고리 정보를 저장합니다.

- **`category` 테이블**SQL
    - **역할**: '상의 > 티셔츠 > 반팔티' 와 같은 계층형 카테고리 구조를 표현합니다.
    - **주요 설계 포인트**:
        - `parent_id`라는 **자기 참조(Self-Referencing)** 외래 키를 사용합니다.
        - `parent_id`가 `NULL`이면 최상위 카테고리를 의미합니다.

```sql
-- category Table
CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    parent_id  BIGINT   DEFAULT NULL COMMENT '부모 카테고리 ID (자기 참조)',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### 주문 및 관계 설계: `purchase` 와 `purchase_items`

주문 행위는 '어떤 주문'인지에 대한 정보와 '주문에 어떤 상품들이 담겼는지'에 대한 정보로 나뉩니다. 이는 **1:N**과 **N:N** 관계를 모두 포함하는 핵심적인
설계입니다.

- **`purchase` 테이블 (1:N 관계)**
    - **역할**: 한 건의 주문 자체에 대한 종합 정보(주문자, 배송지, 총액, 상태)를 저장합니다.
    - **주요 설계 포인트**:
        - `user_id`를 통해 `user` 테이블과 **1:N 관계**를 맺습니다. (한 명의 유저는 여러 번 주문할 수 있습니다.)
        - `status` 컬럼을 통해 '주문 처리중', '배송 완료' 등 주문의 생명주기(Lifecycle)를 관리합니다.
- **`purchase_items` 테이블 (N:N 관계 해결)**SQL
    - **역할**: `purchase`와 `product` 사이의 **N:N 관계를 해결**하기 위한 **연결 테이블(Junction Table)**입니다. 한 주문에 어떤
      상품들이 몇 개씩, 얼마에 팔렸는지를 기록합니다.
    - **주요 설계 포인트**:
        - `purchase_id`와 `product_id`를 외래 키로 가져 관계를 맺습니다.
        - **가장 중요한 점**: `price` 컬럼이 `product` 테이블에도 있지만 여기에도 존재합니다. 이는 상품 가격이 미래에 변동되더라도, **주문이 일어난
          시점의 가격을 역사 기록으로 저장**하기 위함입니다.

```sql
-- purchase Table
CREATE TABLE purchase
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT         NOT NULL COMMENT '구매한 사용자 ID',
    total_price      DECIMAL(10, 2) NOT NULL,
    status           VARCHAR(20) DEFAULT 'PENDING' COMMENT 'PENDING, COMPLETED, CANCELED',
    shipping_address TEXT           NOT NULL,
    created_at       DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
    updated_at       DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
);

-- purchase_items Table
CREATE TABLE purchase_item
( -- 단수형으로 이름 변경
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    purchase_id BIGINT         NOT NULL COMMENT '어떤 주문에 속하는지',
    product_id  BIGINT         NOT NULL COMMENT '어떤 상품인지',
    quantity    INT            NOT NULL,
    price       DECIMAL(10, 2) NOT NULL COMMENT '주문 시점의 상품 가격',
    created_at  DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
    updated_at  DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
);
```

### 전체 구조 및 관계 요약

```sql
[ user ]--<1:N>--[ purchase ]--<1:N>--[ purchase_item ]--<N:1>--[ product ]
                                                                   |
                                                                   |
                                                                  <N:1>
                                                                   |
                                                                [ category ]
                                                                   |
                                                                  <N:1> (자기참조)
                                                                   |
                                                                (parent_id)
```

- **User : Purchase** = 1 : N
- **Purchase : Purchase Item** = 1 : N
- **Product : Purchase Item** = 1 : N
- **Category : Product** = 1 : N
- **Category : Category** = 1 : N (자기 참조)

## 5. @ManyToOne과 @OneToMany: 핵심 개념 이해하기 💡

두 어노테이션은 JPA에서 가장 중요하고 또 가장 헷갈리는 부분입니다. 자동차의 '엔진'과 '바퀴'처럼, 이 둘의 관계를 정확히 이해해야 제대로 된 애플리케이션을 만들 수
있습니다.

### 1단계: 가장 간단한 관계부터 시작하기 (`@ManyToOne` 단방향)

먼저, 데이터베이스와 가장 가까운 **`@ManyToOne`**부터 생각해보겠습니다.

- **상황**: 여러 명의 '학생(Student)'이 하나의 '교실(Classroom)'에 속해있는 상황을 떠올려보세요.
- **데이터베이스**: `student` 테이블에는 `classroom_id` 라는 외래 키(FK)가 있어서, 어떤 학생이 몇 반 소속인지 알 수 있습니다.
- **JPA 엔티티**: 이 관계를 코드로 표현하면 다음과 같습니다.Java

    ```java
    // Student.java (N쪽)
    @Entity
    public class Student {
        @Id
        private Long id;
        private String name;
    
        @ManyToOne // 학생(N) : 교실(1) 관계
        @JoinColumn(name = "classroom_id") // DB의 classroom_id 컬럼과 연결
        private Classroom classroom;
    }
    
    // Classroom.java (1쪽)
    @Entity
    public class Classroom {
        @Id
        private Long id;
        private String name;
    
        // 아직 학생에 대한 정보가 없다.
    }
    ```

- `Student` 엔티티는 `classroom` 필드를 통해 자신이 어느 교실 소속인지 알 수 있습니다. 하지만 반대로 `Classroom` 엔티티는 어떤 학생들이 있는지 아직
  모릅니다. 이처럼 **한쪽만 관계를 아는 것을 '단방향 관계**'라고 합니다.

### 2단계: 서로를 알게 하기 (`@OneToMany` 추가와 '연관관계의 주인')

이제 '교실' 쪽에서도 어떤 '학생'들이 있는지 알고 싶게 되었습니다. 이때 **`@OneToMany`**가 등장합니다.

```java
// Classroom.java (1쪽) - 수정
@Entity
public class Classroom {

  @Id
  private Long id;
  private String name;

  @OneToMany(mappedBy = "classroom") // 1 : 학생(N) 관계
  private final List<Student> students = new ArrayList<>();
}
```

이제 `Classroom` 객체도 `students` 리스트를 통해 소속 학생들을 알 수 있게 되었습니다. 하지만 여기서 JPA의 가장 중요한 질문이 나옵니다.

> "JPA 입장에서, 대체 누가 진짜 외래 키(FK)를 관리해야 할까요?"
>

`Student`의 `classroom` 필드를 바꿔야 할까요, 아니면 `Classroom`의 `students` 리스트에 학생을 추가하거나 빼야 할까요? 두 군데서 모두 관계를
설정할 수 있으니 혼란스럽습니다.

### ⭐️ 가장 중요한 개념: 연관관계의 주인(Owner)과 `mappedBy`

JPA는 이 혼란을 해결하기 위해 '**연관관계의 주인**'이라는 개념을 도입했습니다.

- **연관관계의 주인이란?**
    - 실제로 데이터베이스의 **외래 키(FK)를 관리(등록, 수정)할 권한을 가진 쪽**입니다.
    - 주인은 단 한쪽만 될 수 있습니다.
    - **누가 주인이 되는가?** 외래 키가 있는 곳, 즉 **N쪽(`@ManyToOne`이 있는 곳)**이 항상 주인이 됩니다.
    - 우리 예제에서는 `student` 테이블에 `classroom_id`가 있으므로, **`Student` 엔티티가 주인**입니다.

- **`mappedBy`의 진짜 의미**
    - 주인이 아닌 쪽(`Classroom`)은 `@OneToMany`에 `mappedBy` 속성을 반드시 적어야 합니다.
    - `@OneToMany(mappedBy = "classroom")` 을 한국어로 풀어쓰면 다음과 같습니다.

      > "나는 연관관계의 주인이 아니야. 나는 Student 엔티티 안에 있는 classroom 필드에 의해 관리되고 있어. 그러니 내 리스트에 학생을 추가하거나 빼도
      DB에 반영하지 말고, 오직 저쪽(Student)에서 관계가 변경될 때 거울처럼 내 상태를 갱신만 해줘."

    - 즉, **`mappedBy`는 주인이 아님을 나타내는 '꼬리표'** 이자, 관계를 관리하는 실제 필드가 무엇인지 알려주는 '연결고리'입니다.

### 3단계: 처음 배울 때 꼭 지켜야 할 규칙 (실수 방지)

1. **양방향 관계에서는 '연관관계 편의 메서드'를 만드세요.**
    - `Student`가 주인이므로, `student.setClassroom(classroom)`을 호출해야 DB에 반영됩니다.
    - 하지만 객체지향적으로는 `classroom.getStudents().add(student)`도 말이 됩니다. 두 코드 중 하나만 실행하면 객체 상태와 DB 상태가
      달라지는 문제가 생깁니다.
    - **해결책**: 양쪽의 관계를 한 번에 설정해주는 메서드를 만듭니다.

    ```java
    // Classroom.java 에 추가
    public void addStudent(Student student) {
        this.students.add(student); // 1. 교실의 학생 리스트에 추가
        student.setClassroom(this); // 2. 학생의 소속 교실을 여기로 설정 (주인에게 변경 알림)
    }
    ```

2. **무한 루프를 조심하세요 (`toString()`, JSON 변환)**
    - `Classroom`의 `toString()`을 호출하면 `students` 리스트를 출력하고, 리스트 안의 각 `Student`는 다시 `toString()`을
      호출하여 `classroom`을 출력하고... 이렇게 무한 반복됩니다.
    - **해결책**: Lombok의 `@ToString` 사용 시, `@ToString.Exclude`를 양방향 관계 필드 중 하나에 붙여서 순환을 끊어야 합니다. JSON
      변환 시에는 `@JsonManagedReference` / `@JsonBackReference`를 사용합니다.

## 6. 엔티티 연관관계 매핑 🧬

데이터베이스 테이블 간의 관계를 JPA 엔티티의 객체 연관관계로 매핑하는 방법을 완전한 예제 코드와 함께 심층적으로 알아봅니다.

### 1:N 양방향 관계: `User` ↔ `Purchase`

한 명의 사용자(`User`)가 여러 개의 주문(`Purchase`)을 가질 수 있는, 가장 일반적인 관계입니다.

- **관계**: `User`와 `Purchase`는 1:N 관계입니다. 데이터베이스에서는 N쪽인 `purchase` 테이블이 `user_id`라는 외래 키(FK)를 가집니다.
- **연관관계의 주인 (Owner)**: JPA에서는 이 외래 키를 직접 관리하는 엔티티를 '주인'으로 정합니다. 이 경우, `Purchase` 엔티티의 `user` 필드가
  `@JoinColumn(name = "user_id")`를 통해 `user_id` 컬럼과 직접 매핑되므로, **`Purchase`가 연관관계의 주인**이 됩니다.
- **주인이 아닌 쪽 (Non-owner)**: `User` 엔티티의 `purchases` 필드는 `mappedBy` 속성을 통해 "나는 `Purchase` 엔티티의 `user`
  필드에 의해 매핑된, 읽기 전용 관계다"라고 명시합니다. 이 필드를 통해 `User` 객체에서 관련 `Purchase` 목록을 쉽게 조회할 수 있지만, 이 필드를 수정한다고
  해서 `purchase` 테이블의 `user_id`가 변경되지는 않습니다.

**주요 어노테이션 설명**

- **`@ManyToOne`**: N:1 관계를 나타냅니다.
- **`@OneToMany`**: 1:N 관계를 나타냅니다.
- **`@JoinColumn(name = "...")`**: 외래 키 컬럼을 직접 지정합니다. 연관관계의 주인이 사용합니다.
- **`@JsonManagedReference` / `@JsonBackReference`**: 양방향 관계의 엔티티를 JSON으로 변환할 때, `User`는 `Purchase`를
  부르고, `Purchase`는 다시 `User`를 부르는 **무한 순환 참조**가 발생합니다. 이를 방지하기 위해 1쪽(`User`)에
  `@JsonManagedReference`를, N쪽(`Purchase`)에 `@JsonBackReference`를 붙여 N쪽의 정보는 JSON 직렬화에서 제외합니다.

```java
// User.java

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String passwordHash;

  @Builder.Default // 빌더 사용 시에도 기본값 유지를 위해 추가
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private final List<Purchase> purchases = new ArrayList<>();

  @Column(updatable = false)
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  public void onPrePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = this.createdAt;
  }

  @PreUpdate
  public void onPreUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}

// Purchase.java
import lombok .*;
    import jakarta.persistence .*;
    import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "purchase")
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  @JsonBackReference
  private User user;

  @Column(nullable = false)
  private BigDecimal totalPrice;

  @Enumerated(EnumType.STRING) // Enum 타입을 문자열로 저장
  @Column(nullable = false, length = 20)
  private PurchaseStatus status;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String shippingAddress;

  @Column(updatable = false)
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  public void onPrePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = this.createdAt;
  }

  @PreUpdate
  public void onPreUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}

// PurchaseStatus.java (Enum)
public enum PurchaseStatus {
  PENDING, COMPLETED, CANCELED
}
```

### N:1 단방향 및 자기 참조 관계: `Product` ↔ `Category`

여러 상품(`Product`)이 하나의 카테고리(`Category`)에 속하고, 카테고리는 자기 자신을 부모로 참조하여 계층 구조를 이루는 관계입니다.

- **N:1 (Product → Category)**: 가장 단순하고 직관적인 단방향 관계입니다. `Product` 엔티티가 `Category`의 참조를 가지고 있으며,
  데이터베이스에서는 `product` 테이블이 `category_id` 외래 키를 가집니다.
- **자기 참조 (Category → Category)**: `Category` 엔티티 내부에 또 다른 `Category` 타입의 `parent` 필드와 `children`
  리스트를 두어 부모-자식 관계를 표현합니다. 이는 1:N 양방향 관계의 특수한 형태입니다.

```java
// Product.java

import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(nullable = false)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(nullable = false)
  private Integer stock;

  @Column(updatable = false)
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  public void onPrePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = this.createdAt;
  }

  @PreUpdate
  public void onPreUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}

// Category.java
import lombok .*;
    import jakarta.persistence .*;
    import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  @JsonBackReference
  private Category parent;

  @Builder.Default
  @OneToMany(mappedBy = "parent")
  @JsonManagedReference
  private final List<Category> children = new ArrayList<>();

  @Column(updatable = false)
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  public void onPrePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = this.createdAt;
  }

  @PreUpdate
  public void onPreUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}

```

### N:N 관계: `Purchase` ↔ `Product`

하나의 주문(`Purchase`)에는 여러 상품(`Product`)이, 하나의 상품은 여러 주문에 포함될 수 있습니다. 이 관계는 중간 **연결 엔티티(
`PurchaseItem`)**를 통해 두 개의 1:N 관계로 풀어냅니다.

- **`@ManyToMany`의 한계**: JPA는 `@ManyToMany` 어노테이션으로 N:N 관계를 직접 매핑할 수 있지만, 이는 연결 테이블을 JPA가 내부적으로만
  사용하여 개발자가 제어할 수 없습니다.
- **연결 엔티티(Link Entity) 패턴**: `PurchaseItem`이라는 별도의 엔티티를 만들어 N:N 관계를 명시적으로 풀어냅니다. `PurchaseItem`은
  `Purchase`와 `Product`에 대해 각각 N:1 관계를 가집니다. 이 패턴을 통해 연결 테이블을 완벽하게 제어할 수 있습니다.
- **데이터의 역사성 보존**: `PurchaseItem`에 `price` 필드를 두는 것은 매우 중요합니다. 상품의 가격은 언제든 변할 수 있지만, 주문 내역에는 **결제가
  이루어진 시점의 가격**이 정확히 기록되어야 하기 때문입니다.

```java
// PurchaseItem.java

import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "purchase_item")
public class PurchaseItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "purchase_id", nullable = false)
  private Purchase purchase;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @Column(nullable = false)
  private int quantity;

  @Column(nullable = false)
  private BigDecimal price; // 주문 시점의 가격

  @Column(updatable = false)
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  public void onPrePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = this.createdAt;
  }

  @PreUpdate
  public void onPreUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}
```

## 7. 실습: 쇼핑몰 DB 설계 및 JPA 연관관계 매핑 🛒

DB 스키마 설계부터 Flyway 적용, JPA 엔티티 연관관계 매핑, 그리고 테스트 코드 검증까지의 전 과정을 실습합니다.

### DB 스키마 생성 (Flyway)

Flyway를 사용하여 `user`, `category`, `product`, `purchase`, `purchase_item` 5개 테이블의 스키마를 정의하고, 애플리케이션을
실행하여 데이터베이스에 적용하세요.

- **핵심**: 의존성이 없는 테이블(`user`, `category`)부터 순서대로 마이그레이션 파일을 작성합니다.

### JPA 엔티티 및 연관관계 매핑

생성된 각 테이블에 맞춰 JPA 엔티티를 작성합니다. 아래의 핵심 연관관계를 어노테이션을 사용하여 정확히 매핑하는 데 집중하세요.

- `User` ↔ `Purchase` : **1:N 양방향 관계**
- `Product` → `Category` : **N:1 단방향 관계**
- `Category` ↔ `Category` : **자기 참조 양방향 관계**
- `Purchase` ↔ `Product` : **N:N 관계** (`PurchaseItem` 연결 엔티티로 해결)

<br><br><br>
출처: 팀스파르타 <br>
Copyright ⓒ TeamSparta All rights reserved.