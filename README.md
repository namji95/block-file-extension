# block-file-extension

### 파일 확장자 차단 과제

##### 목차
- [프로젝트 개요](#project-overview)
- [개발 환경](#tech)
- [요구 사항](#requirement)
- [화면 구성](#screen-composition)
- [추가 구현 및 개선 사항](#improvement)

<h3 id="project-overview">📚프로젝트 개요</h3>

- 프로젝트 명 : 파일 확장자 차단
- 소개
  - 어떤 파일들은 첨부시 보안에 문제가 될 수 있습니다.. 특히 exe, sh 등의 실행파일이 존재할 경우 서버에
    올려서 실행이 될 수 있는 위험이 있어 파일 확장자 차단을 하게 되었습니다.

<h3 id="tech"> 🛠️ 개발 환경 ️</h3>

- Java 17
- SpringBoot 3.3.2
- JPA
- Thymeleaf
- MySQL
- Lombok

<h3 id="requirement"> 📃 요구 사항 </h3>

1. 첫 번째
   1. 고정 확장자는 차단을 자주하는 확장자를 리스트이며, default는 unCheck되어져 있습니다.
   2. 고정 확장자를 check or uncheck를 할 경우 db에 저장됩니다. - 새로고침시 유지되어야합니다.
   <br>(아래쪽 커스텀 확장자에는 표현되지 않으니 유의해주세요.)
2. 두 번째
   1. 확장자 최대 입력 길이는 20자리
   2. 추가버튼 클릭시 db 저장되며, 아래쪽 영역에 표현됩니다.
3. 세 번째
   1. 커스텀 확장자는 최대 200개까지 추가가 가능
   2. 확장자 옆 X를 클릭시 db에서 삭제

<h3 id="screen-composition"> 🖥️ 화면 구성 </h3>

<img src="src/main/resources/image/screen-composition.png" width="500">

<h3 id="improvement"> 🔎 추가 구현 및 개선 사항 </h3>

<h5>추가 구현</h5>

- 커스텀 확장자 화면 조회 시 div 태그 영역 벗어나면 스크롤 생기도록 기능 구현
- 확장자 추가 및 삭제 시 alert을 이용한 알림창 기능 구현
- 차단된 확장자가 제대로 차단할 수 있는지 테스트 하기 위해 파일 업로드 기능 구현

<h5>개선 사항</h5>

- 고정 확장자 리스트를 클라이언트가 추가 및 삭제할 수 있으면 어떨까 고민
- alert을 이용한 알림 기능은 javascript가 멈추기 때문에 다른 방법이 필요
