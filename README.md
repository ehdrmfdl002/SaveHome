# SaveHome (쉽고 간편하게 집을 고를 수 있도록 도와주는 서비스)

![image](https://user-images.githubusercontent.com/62333600/223699885-1589162c-07b5-48e7-891d-8964f06b45d0.png)

### 프로젝트 기간
#### 2022.11.02 ~ 2022.11.24

## 1. SaveHome 소개 
### 지역별로 주택정보(거래 금액, 층 수)를 제공하고, 사용자가 선택한 주택 인근의 편의 시설(마트, 약국) 정보 제공을 통해 사용자가 편리하고 합리적으로 집을 고를 수 있도록 하는 서비스입니다.

## 2. 주요 기능

### 1). 메인페이지
![image](https://user-images.githubusercontent.com/62333600/223703772-237424a9-71cf-4c69-b1ba-a5d7042b9f39.png)

### 2). 회원가입/ 로그인/ 로그아웃
![image](https://user-images.githubusercontent.com/62333600/223703831-0ddde04a-3d88-4861-9f54-dc85f5d8f815.png)

### 3). 비밀번호 수정
![image](https://user-images.githubusercontent.com/62333600/223704127-99bec0d4-c370-4236-b0fb-2b866c86c863.png)

### 4). 회원정보, 회원정보 수정 및 탈퇴
![image](https://user-images.githubusercontent.com/62333600/223704284-d4dda788-4d1d-49ef-9e34-a79ba7b8a15b.png)

### 5). 공지사항
![image](https://user-images.githubusercontent.com/62333600/223704456-efb3c49c-d953-4779-8891-624121fc180a.png)

### 6). 자유게시판
![image](https://user-images.githubusercontent.com/62333600/223704549-384c28db-8044-467f-8330-c06bedbc7777.png)

### 7). 부동산 조회
![image](https://user-images.githubusercontent.com/62333600/223704685-4705ef81-6461-4f50-a405-1907ed902afc.png)

### 8). 뉴스기사 조회
![image](https://user-images.githubusercontent.com/62333600/223704796-c88c1325-39a5-4217-a2bb-f8c3b1f26e8b.png)

## 3. 개발 환경

### 3-1. 환경 설정

💎프론트엔드
- vue: 2.7.14
- vuex: 3.6.2
- bootstrap-vue: 2.23.1

🍀백엔드
- Java : 1.8,
- SpringBoot : 2.7.8,
- Jwt : 0.9.1

🎁DB
- MySQL :  8.0.3

### 3-2. 서비스 아키텍처

![image](https://user-images.githubusercontent.com/62333600/223711130-5279fe34-9fb2-4e8e-859d-27e12387b230.png)


## 4. 설계문서

### 4-1. UseCase
![image](https://user-images.githubusercontent.com/62333600/223711371-08d2075a-cf25-4097-9679-7d037999a83c.png)

### 4-2. 다이어그램
![다이어그램](https://user-images.githubusercontent.com/62333600/223711427-07182440-79dc-4e2e-ab58-830bb3c97c3b.gif)


## 5. 협업 툴 및 코드 컨벤션

### 5-1. 협업 툴
- Git
- Mattermost
- Webex

### 5-2. 코드 컨벤션

- 클래스 이름: UpperCamelCase 로 작성한다. UpperCamelCase 란 문장의 공백을 삭제한 후 첫글자를 대문자로 작성하고 다음 단어의 첫글자들을 대문자로 바꾸어주는 것을 의미한다.
- 메소드 이름: lowerCamelCase 🐫 로 작성한다.
- 상수 이름: 상수이름은 CONSTANT_CASE 스타일로 작성한다.

## 6. 팀원 소개

|팀원|역할|
|------|---|
|최동호|-REST API 설계 <br>-ERD 설계 |
|김영주|-UI/UX 담당 <br>-REST API 설계 |

