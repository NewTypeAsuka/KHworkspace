-- TCL(TRANSACTION CONTROL LANGUAGE) : 트랜잭션 제어 언어
-- COMMIT(트랜잭션 종료 후 저장), ROLLBACK(트랜잭션 취소), SAVEPOINT(임시저장)

-- DML : 데이터 조작 언어로 데이터의 삽입, 수정, 삭제
--> 트랜잭션은 DML과 관련되어 있음.


/* TRANSACTION이란?
 - 데이터베이스의 논리적 연산 단위
 
 - 데이터 변경 사항을 묶어 하나의 트랜잭션에 담아 처리함.

 - 트랜잭션의 대상이 되는 데이터 변경 사항 : INSERT, UPDATE, DELETE (DML)
 
 EX) INSERT 수행 --------------------------------> DB 반영(X)
   
     INSERT 수행 --> 트랜잭션에 추가 --> COMMIT --> DB 반영(O)
     
     INSERT 10번 수행 --> 1개 트랜잭션에 10개 추가 --> ROLLBACK --> DB 반영 안됨


    1) COMMIT : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 DB에 반영
    
    2) ROLLBACK : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 삭제하고
                 마지막 COMMIT 상태로 돌아감.
                
    3) SAVEPOINT : 메모리 버퍼(트랜잭션)에 저장 지점을 정의하여
                   ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아닌
                   저장 지점까지만 일부 ROLLBACK 
    
    [SAVEPOINT 사용법]
    
    SAVEPOINT 포인트명1;
    ...
    SAVEPOINT 포인트명2;
    ...
    ROLLBACK TO 포인트명1; -- 포인트1 지점 까지 데이터 변경사항 삭제

*/

SELECT * FROM DEPARTMENT2;

-- DEPARTMENT3에 D0, 경리부, L2 삽입
INSERT INTO DEPARTMENT2
VALUES ('D0', '경리부', 'L2');

-- 경리부 삽입 확인
-- 하지만 아직 DB에 실제로 삽입되지는 않음
SELECT * FROM DEPARTMENT2;

ROLLBACK; -- 롤백: 마지막 커밋 상태로 되돌아감

SELECT * FROM DEPARTMENT2; -- 롤백 확인

INSERT INTO DEPARTMENT2 -- 다시 경리부 INSERT
VALUES ('D0', '경리부', 'L2');

COMMIT; -- 커밋: 트랜잭션에 저장된 DML을 DB에 반영

ROLLBACK;

SELECT * FROM DEPARTMENT2; -- 롤백했지만 앞서 커밋해서 경리부 남아 있음

-- SAVEPOINT 사용하기
DELETE FROM DEPARTMENT2
WHERE DEPT_ID = 'D1'; -- D1행 삭제
-- DELETE 내역이 트랜잭션에 저장

SELECT * FROM DEPARTMENT2; -- 삭제 확인

-- D1 삭제 구문 수행 후 시점을 저장
SAVEPOINT S1;

DELETE FROM DEPARTMENT2
WHERE DEPT_ID = 'D2'; -- D2행 삭제

SELECT * FROM DEPARTMENT2; -- 삭제 확인

-- D2 삭제 구문 수행 후 시점을 저장
SAVEPOINT S2;

DELETE FROM DEPARTMENT2
WHERE DEPT_ID = 'D3'; -- D3행 삭제

SELECT * FROM DEPARTMENT2; -- 삭제 확인

-- S2까지 ROLLBACK
ROLLBACK TO S2;

SELECT * FROM DEPARTMENT2; -- 롤백 확인

-- S2까지 ROLLBACK
ROLLBACK TO S1;

SELECT * FROM DEPARTMENT2; -- 롤백 확인

-- 트랜잭션의 모든 내용 삭제
ROLLBACK;

SELECT * FROM DEPARTMENT2; -- 롤백 확인