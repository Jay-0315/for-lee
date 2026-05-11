# 家計簿 (가계부 앱)

Spring Boot + React 기반 가계부 웹 애플리케이션

## 기술 스택

- **Backend**: Java 21, Spring Boot 3.5, Spring Security, JPA, MySQL, JWT
- **Frontend**: React 19, TypeScript, Vite, Zustand, Axios

## 진행 현황

| Phase | 내용 | 상태 |
|-------|------|------|
| 1 | 환경 구축 | ✅ 완료 |
| 2 | 로그인 / 회원가입 | ✅ 완료 |
| 3 | 카테고리 관리 | ⬜ 예정 |
| 4 | 수입/지출 내역 CRUD | ⬜ 예정 |
| 5 | 영수증 이미지 첨부 | ⬜ 예정 |
| 6 | 월별 합계 / 통계 | ⬜ 예정 |

## 실행 방법

**Backend**
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
# application.properties에 DB 정보 입력 후
./gradlew bootRun
```

**Frontend**
```bash
cd frontend
npm install
npm run dev
```

## API

| Method | URL | 설명 |
|--------|-----|------|
| POST | /api/auth/register | 회원가입 |
| POST | /api/auth/login | 로그인 (JWT 반환) |
