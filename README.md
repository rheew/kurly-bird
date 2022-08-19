### 기능 구현 목록

- [ ] 네이버 뉴스 API 연동
    - [ ] 스케쥴러 구현
        - [ ] 주기 ?
        - [x] 이슈 카테고리 키워드로 뉴스 정보를 검색한다. 
        - [x] 검색된 뉴스 정보들 중 이슈 키워드가 들어간 정보를 DB에 저장한다.
          -> 정확도 높이기 작업 필요                
    - [x] 이슈 정보 분석 로직 구현
        - [x] 제목 or 내용으로 이슈 여부를 파악 할 수 있다.

- [ ] 가격 정보 API 연동
    - [ ] 스케줄러 구현
        - [ ] 주기 - 하루에 한번 저장
        - [x] 가격 정보 API에 검색된 정보를 일별로 DB에 저장 할 수 있다.

- [x] 컬리버드 API 제공
    - [x] 조회
        - [x] 상품 목록 정보
        - [x] 뉴스 목록 정보
        - [x] 해당 이슈 번호

- [ ] 가격 API 제공
    - [ ] 조회
    
- [x] 상품 상세 API 제공
    - [x] 조회
- [x] swagger API 연동

### 해야 할 일
- 쿼리 큐닝하기
- 상품 이미지 설정 작업