## Spring education Week1

#### 1. 왜 스프링일까?
스프링 프레임워크는 자바(Java) 기반의 애플리케이션을 개발하는 데 필요한 거의 모든 것을 지원하는 오픈소스 프레임워크입니다. 단순히 웹 개발뿐만 아니라, 데이터 처리, 보안, 배치(batch) 작업 등 기업 환경의 복잡한 시스템을 구축하는 데 필요한 포괄적인 프로그래밍 및 설정 모델을 제공합니다.

스프링의 핵심 철학은 "좋은 객체 지향 설계"를 돕는 것입니다. 복잡하고 무거웠던 과거의 자바 개발 방식(특히 EJB)을 비판하며, 개발자들이 순수한 자바 객체(POJO)를 사용해 비즈니스 로직에만 집중할 수 있도록 도와줍니다.


#### POJO(Plain Old Java Object)
**POJO**는 말 그대로 "평범한 옛날 자바 객체"를 의미합니다.

과거의 **EJB와 같은 특정 기술 프레임워크에 종속된 객체들은 해당 프레임워크의 특정 클래스를 상속(`extends`)하거나 인터페이스를 구현(`implements`)해야만 했습니다**. 이로 인해 코드가 프레임워크에 심하게 종속되고, 테스트가 어려워지는 문제가 있었습니다.

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
스프링의 위대함은 바로 이 POJO를 기반으로 동작한다는 점입니다. 스프링은 POJO 객체를 가져다가 IoC 컨테이너에 등록하고, AOP를 적용하는 등 강력한 기능을 부여합니다. 개발자는 프레임워크가 아닌, 순수한 비즈니스 로직을 담은 POJO에만 집중하면 됩니다.


#### 스프링의 역사: 고통에서 탄생한 혁신
- **~2000년대 초반 (EJB의 시대):** 기업용 자바 개발의 표준은 **EJB(Enterprise JavaBeans)**였습니다. EJB는 강력한 기능을 제공했지만, 너무 복잡하고, 무거웠으며, 비싼 WAS(Web Application Server)를 필요로 했습니다. 또한, **코드가 EJB 프레임워크에 심하게 종속되는 문제**가 있었습니다.
- **2002년 (새로운 시대의 서막):** 개발자 **로드 존슨(Rod Johnson)**이 `Expert One-on-One J2EE Design and Development`라는 책을 출간합니다. 그는 이 책에서 EJB의 문제점을 신랄하게 비판하고, POJO와 DI를 기반으로 한 더 가볍고 단순한 프레임워크의 필요성을 역설했습니다. 이 책에 담긴 3만 줄의 코드가 바로 **스프링 프레임워크의 시작**이었습니다.
- **2004년 (스프링 1.0 출시):** EJB의 대안으로 공식 출시되며 폭발적인 인기를 얻기 시작합니다.
- **2010년대 (스프링 부트의 등장):** 스프링 프레임워크 자체도 설정이 복잡하다는 의견이 많아졌습니다. 이를 해결하기 위해 **스프링 부트(Spring Boot)**가 등장했습니다. **스프링 부트는 "Convention over Configuration(설정보다 관례)"** 철학을 바탕으로, 개발자가 복잡한 설정을 하지 않아도 최소한의 설정으로 빠르게 애플리케이션을 실행할 수 있도록 도와줍니다. 오늘날 대부분의 스프링 프로젝트는 스프링 부트를 기반으로 시작합니다.


#### 스프링의 3대 핵심 특징

- **IoC (Inversion of Control) / DI (Dependency Injection): 제어의 역전 / 의존성 주입**
    - **과거:** 개발자가 직접 객체를 생성하고 의존성을 연결했습니다. (예: `Controller`가 `new Service()`를 직접 생성)
    - **스프링:** 객체의 생성과 생명주기 관리를 스프링 컨테이너가 대신해 줍니다. 개발자는 필요한 객체를 선언만 하면, 스프링이 알아서 주입(Injection)해 줍니다.
    - "레고 블록"을 조립할 때, 필요한 블록을 직접 찾는 것이 아니라, "레고 마스터(스프링 컨테이너)"에게 "이런 모양의 블록이 필요해!"라고 요청하면 알아서 가져다주는 것과 같습니다. 이로 인해 부품(객체) 간의 결합도(coupling)가 낮아지고, 유연하고 확장 가능한 구조가 됩니다.
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
    - `DispatcherServlet`은 요청 URL(예: `/members/1`)을 보고, 이 요청을 처리할 담당자(Controller)가 누구인지 찾아주는 역할을 합니다. 실제 로직을 처리하지 않고, 적절한 곳에 **요청을 위임(dispatch)**합니다.

1. **스프링 컨테이너 (Spring Container) - ApplicationContext**
    - **역할:** 스프링의 **핵심 엔진**이자 **POJO 객체들의 공장 겸 관리소**입니다.
    - `@Controller`, `@Service`, `@Repository` 등 스프링이 관리하는 모든 객체(**Bean**)들이 이곳에 등록되어 있습니다.
    - `DispatcherServlet`이 "이 URL 요청 누가 처리해?"라고 물으면, 스프링 컨테이너는 등록된 Bean 중에서 적절한 `Controller`와 그 안의 메서드를 찾아 연결해 줍니다.
    - 이후 `Controller`는 비즈니스 로직 처리를 `Service`에 위임하고, `Service`는 데이터 처리를 `Repository`에 위임하는 식으로 작업이 연쇄적으로 일어납니다. 이 모든 객체 간의 관계(의존성)는 스프링 컨테이너가 관리하고 연결(주입)해 줍니다.

결론적으로, **톰캣**이 요청을 받고, 스프링의 `DispatcherServlet`이 요청을 분류하며, 실제 작업은 **스프링 컨테이너**가 관리하는 여러 **Bean(POJO 객체)**들이 협력하여 처리하는 구조입니다. 이 구조 덕분에 개발자는 비즈니스 로직에만 집중할 수 있습니다.


**잠깐, 서블릿(Servlet)이란 무엇일까요?**

앞서 `DispatcherServlet`이라는 용어가 등장했는데, 여기서 서블릿(Servlet)이란 무엇인지 짚고 넘어가겠습니다.

- **서블릿(Servlet)은** 서버 측에서 실행되는 작은 자바 프로그램을 의미합니다.
  (Server + Applet의 합성어)

과거에는 클라이언트의 요청에 따라 웹 페이지의 내용이 바뀌어야 할 때마다 새로운 HTML 파일을 일일이 만들어야 했습니다. 이는 매우 비효율적이었습니다.

서블릿은 이러한 **정적인(static) 웹의 한계를 극복**하기 위해 등장했습니다.

**서블릿의 핵심 역할:**

1. **동적(Dynamic) 웹 페이지 생성:**
    - 서블릿은 자바 코드를 통해 동적으로 HTML을 생성할 수 있습니다.
    - 예를 들어, 사용자의 요청에 따라 데이터베이스에서 정보를 가져와 다른 내용의 HTML 페이지를 만들어 응답할 수 있습니다. (예: "홍길동님, 환영합니다!" vs "이순신님, 환영합니다!")
2. **클라이언트 요청 처리:**
    - 클라이언트(웹 브라우저)가 보낸 `GET`, `POST`와 같은 HTTP 요청을 읽고, 그에 맞는 비즈니스 로직을 수행합니다.

**즉, 서블릿은 클라이언트의 요청을 받아 자바 코드로 비즈니스 로직을 처리하고, 그 결과를 동적인 HTML로 만들어 클라이언트에게 응답해주는 기술입니다.**

**스프링과 서블릿의 관계:**

스프링 프레임워크가 등장하기 전에는 개발자들이 여러 개의 서블릿을 직접 만들고, 각 URL 요청을 어떤 서블릿이 처리할지 `web.xml`이라는 파일에 일일이 설정해야 했습니다.

하지만 스프링에서는 **`DispatcherServlet`**이라는 **단 하나의 서블릿**이 모든 요청을 **대표**로 받습니다. 그리고 실제 작업은 `DispatcherServlet`이 스프링 컨테이너에 있는 컨트롤러(Controller)에게 위임하는 방식으로 동작합니다.

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
**Spring Initializr([https://start.spring.io](https://start.spring.io/))**는 스프링 프로젝트의 뼈대를 손쉽게 만들어주는 웹 도구입니다.

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

- **domain**: 애플리케이션의 핵심 비즈니스 로직이 담기는 곳입니다. **회원(Member), 주문(Order), 상품(Product) 등 주요 기능(도메인) 단위로 패키지를 분리**하여 코드를 관리합니다. 이렇게 하면 특정 기능과 관련된 코드를 쉽게 찾을 수 있고, 기능 간의 의존성을 명확하게 파악할 수 있습니다.
- **common**: 특정 도메인에 종속되지 않고, **여러 도메인에서 공통으로 사용되는 유틸리티성 코드**를 모아두는 패키지입니다.
- **global**: 애플리케이션의 **전반적인 동작에 영향을 미치는 설정 코드**를 모아두는 패키지입니다. 보안 설정, CORS 설정, 로깅 설정 등이 여기에 해당됩니다.

### YAML과 Properties: 스프링 부트 설정 파일 이해하기

스프링 부트에서는 애플리케이션의 다양한 설정을 외부 파일로 분리하여 관리합니다. 이때 가장 널리 사용되는 두 가지 파일 형식이 바로 `.properties`와 `.yml` 입니다. 두 파일 모두 동일한 설정을 할 수 있지만, 작성 방식과 구조에서 차이가 있습니다.

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

**YAML**(YAML Ain't Markup Language)은 '사람이 쉽게 읽을 수 있는' 데이터 직렬화 형식입니다. **들여쓰기(indentation)**를 사용하여 데이터의 계층 구조를 표현하는 것이 가장 큰 특징입니다.

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

| **구분** | **.properties** | **.yml** |
| --- | --- | --- |
| **형식** | `key=value` | `key: value` (들여쓰기 기반) |
| **구조** | 점(.)으로 구분하는 평면적 구조 | 들여쓰기를 이용한 계층적 구조 |
| **가독성** | 설정이 길어지면 떨어짐 | 구조 파악이 쉬워 가독성이 높음 |
| **장점** | 단순하고 직관적, 익숙함 | 간결함, 뛰어난 가독성, 구조적 데이터 표현 용이 |
| **단점** | 키 중복으로 인한 번거로움 | 들여쓰기 실수에 매우 민감함 |

기능적으로 두 파일은 완전히 동일한 역할을 수행합니다. 어떤 것을 선택할지는 개인의 취향이나 팀의 컨벤션에 따릅니다.

하지만 **최근 스프링 부트 개발 트렌드는 `.yml`을 더 선호하는 추세**입니다. 복잡한 설정도 한눈에 파악할 수 있는 가독성과 간결함이라는 장점이 매우 크기 때문입니다.

스프링 부트는 두 형식 모두 완벽하게 지원하므로, 프로젝트의 특성과 팀의 스타일에 맞는 것을 선택하여 사용하면 됩니다.

## **3. MySQL 환경 설정**

로컬 머신에 직접 MySQL을 설치하는 대신, **Docker**를 사용하여 격리되고 일관된 데이터베이스 환경을 구성합니다.

### Docker를 이용한 MySQL 컨테이너 실행

1. **Docker 설치**
    - 아직 Docker가 설치되지 않았다면 아래 공식 사이트에서 자신의 운영체제에 맞게 설치합니다.
    - **설치**: [**https://www.docker.com/products/docker-desktop/**](https://www.docker.com/products/docker-desktop/)
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

```
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

**Undertow**는 가볍고 성능이 뛰어난 웹 서버입니다. 기본 내장 웹 서버인 Tomcat보다 적은 리소스를 사용하면서 높은 요청 처리량을 제공하여 고성능이 요구되는 환경에 적합합니다.

**1. `build.gradle` 의존성 수정**

기존 `spring-boot-starter-web`에서 Tomcat을 제외하고, `spring-boot-starter-undertow`를 추가합니다.

```
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
```
dependencies {
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0'
}
```

**2. Swagger 설정 클래스 작성 (JWT 인증 추가)**

다음은 Swagger UI에서 **JWT(Bearer Token)** 인증을 사용할 수 있도록 설정하는 예시입니다.
```
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


​
3. application.yml 설정 추가
```
# Swagger UI 설정 (Springdoc)
springdoc:
  swagger-ui:
    enabled: true
```
**4. Swagger UI 접속**

애플리케이션 실행 후 아래 주소로 접속하여 API 문서를 확인합니다.

- **URL**: `http://localhost:8080/swagger-ui/index.html`


### Flyway: 데이터베이스 스키마 버전 관리

**Flyway**는 데이터베이스의 스키마 변경 이력을 코드로 관리하고, 애플리케이션 실행 시 정해진 순서에 따라 자동으로 DB에 반영(마이그레이션)해주는 도구입니다. 이를 통해 팀원들과 DB 형상을 일관되게 유지할 수 있습니다.

**1. `build.gradle` 의존성 추가**
```
dependencies {
    implementation 'org.flywaydb:flyway-core'
    implementation 'org.flywaydb:flyway-mysql'
}
```

**2. 마이그레이션 SQL 파일 작성**

Flyway는 **`V<버전>__<설명>.sql`** 형식의 파일명을 규칙으로 사용합니다. 파일은 `src/main/resources/db/migration` 경로에 위치해야 합니다.

- **파일 경로 및 이름**: `src/main/resources/db/migration/V1__init_table.sql`
```
CREATE TABLE example (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);
```
3. application.yml 설정 추가
```
spring:
  flyway:
    enabled: true # Flyway 활성화
    # 마이그레이션 파일 위치 지정 (기본값)
    locations: classpath:db/migration
```
이제 애플리케이션을 실행하면 Flyway가 SQL 파일을 읽어 데이터베이스에 자동으로 테이블을 생성합니다.

### MapStruct: 객체 매핑 자동화

**MapStruct**는 **DTO(Data Transfer Object)와 Entity 간의 변환 코드**를 자동으로 생성해주는 라이브러리입니다. 반복적인 매핑 코드를 직접 작성할 필요 없이, 간단한 인터페이스 정의만으로 빠르고 타입-안전(type-safe)한 변환 로직을 만들어줍니다.

**1. `build.gradle` 의존성 추가**

`mapstruct` 라이브러리와 컴파일 시점에 코드를 생성해 줄 `mapstruct-processor`를 함께 추가합니다.
```
dependencies {
    implementation 'org.mapstruct:mapstruct:1.5.5.Final'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'
}
```
**2. Mapper 인터페이스 작성 예제**

변환 규칙을 정의할 인터페이스를 생성합니다.
```
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
- `@Mapper(componentModel = "spring")`: 컴파일 시점에 MapStruct가 이 인터페이스의 구현체를 자동으로 생성하며, 이를 스프링 컨테이너에 **Bean으로 등록**해줍니다. 덕분에 다른 서비스 클래스에서 `@Autowired`로 주입하여 사용할 수 있습니다.
- `@Mapping(source = "...", target = "...")`: `UserEntity`의 `email` 필드를 `UserDto`의 `emailAddress` 필드로 매핑하도록 지정합니다. 필드명이 동일한 경우에는 이 어노테이션을 생략해도 자동으로 매핑됩니다.


### 최종 `build.gradle` 의존성(Dependencies) 예시

아래는 **Undertow, Spring Data JPA, MySQL, Swagger(Springdoc), Flyway, MapStruct, Lombok** 등 지금까지 논의된 모든 라이브러리가 포함된 `dependencies` 블록입니다. 이 내용을 `build.gradle` 파일에 복사하여 사용하거나 참고할 수 있습니다.

```
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
```
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

<br><br><br>
출처: 팀스파르타 <br>
Copyright ⓒ TeamSparta All rights reserved.