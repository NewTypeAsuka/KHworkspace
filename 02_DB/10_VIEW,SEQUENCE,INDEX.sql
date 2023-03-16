/* VIEW
 * 
 * - 논리적 가상 테이블
 * -> 테이블 모양을 하고는 있지만, 실제로 값을 저장하고 있지는 않음
 * 
 * - SELECT문의 실행 결과(RESULT SET)를 저장하는 객체
 * 
 * - VIEW의 사용 목적
 * 1) 복잡한 SELECT문을 쉽게 재사용하기 위해
 * 2) 테이블의 진짜 모습을 감출 수 있어 보안상 유리
 * 
 * - VIEW 사용시 주의사항
 * 1) 가상의 테이블(실체 X)이기 때문에 ALTER 구문 사용 불가
 * 2) VIEW를 이용한 DML(INSERT, UPDATE, DELETE)이 가능한 경우도 있지만
 *    제약이 많이 따르기 때문에 조회(SELECT) 용도로 대부분 사용
 * 
 * - VIEW 작성법
 * CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름 [컬럼 별칭]
 * AS 서브쿼리(SELECT문)
 * [WITH CHECK OPTION]
 * [WITH READ ONLY]
 * 
 * 1) OR REPLACE 옵션: 기존에 동일한 이름의 VIEW가 존재하면 이를 변경, 없으면 새로 생성
 * 2) FORCE 옵션: 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성(강제 생성)
 *    NOFORCE 옵션(기본값): 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성
 * 3) 컬럼 별칭 옵션: 조회되는 VIEW의 컬럼명을 지정
 * 4) WITH CHECK OPTION 옵션: 옵션을 지정한 컬럼의 값을 수정 불가능하게 함
 * 5) WITH READ ONLY 옵션: 뷰에 대해 SELECT만 가능하도록 지정(읽기 전용)
 * 
 */

-- EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 부서명, 직급명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);
--> VIEW 생성

CREATE VIEW V_EMP
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
	JOIN JOB USING (JOB_CODE));
-- ORA-01031: 권한이 불충분합니다.

--> SYS 계정으로 접속
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--> 각자 계정에 CREATE VIEW 권한 부여
GRANT CREATE VIEW TO kh_lsj;

--> 다시 kh 계정으로 접속해서 view 생성 구문 수행

-- 생성된 VIEW를 이용해서 조회
SELECT * FROM V_EMP;

-- V_EMP 뷰 수정하기(OR REPLACE)
CREATE OR REPLACE VIEW V_EMP
AS (SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서명, JOB_NAME 직급명
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
	JOIN JOB USING (JOB_CODE));

-- V_EMP에서 직급이 대리인 사원의 정보를 조회
SELECT *
FROM V_EMP
WHERE 직급명 = '대리';

--------------------------------------------------------------

-- VIEW를 이용한 DML

-- 테이블 복사
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY2;

-- DEPT_COPY2에서 DEPT_ID, LOCATION_ID 컬럼만 조회하는 VIEW 생성
CREATE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID
FROM DEPT_COPY2;

SELECT * FROM V_DCOPY2;

-- VIEW를 이용한 INSERT
INSERT INTO V_DCOPY2
VALUES('D0', 'L3');

-- INSERT 확인
SELECT * FROM V_DCOPY2;
--> VIEW는 값을 저장하지 않는다고 했는데 저장된 것처럼 보임
--  실제 VIEW에 저장된 것이 아니라 VIEW를 생성할 때 사용한 서브쿼리의 테이블(DEPT_CODE2)에 값이 삽입

-- 원본 테이블(DEPT_COPY2) 확인
SELECT * FROM DEPT_COPY2;
-- D0  NULL  L3
--> 원본 테이블에 삽입된 것을 확인했지만 INSERT 구문에 포함되지 않은 DEPT_TITLE 컬럼은 NULL 삽입(중요)

DELETE FROM DEPT_COPY2 WHERE DEPT_ID = 'D0';
SELECT * FROM V_DCOPY2;

-- 복사한 테이블(DEPT_COPY2)의 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가
ALTER TABLE DEPT_COPY2
MODIFY DEPT_TITLE CONSTRAINT TITLE_NN NOT NULL;

-- 다시 VIEW를 이용해서 INSERT
INSERT INTO V_DCOPY2
VALUES('D0', 'L3');
-- 삽입 불가
--> 원본 테이블 DEPT_ID, LOCATION_ID 컬럼에 'D0', 'L3' 삽입
--  DEPT_TITLE 칼럼에는 NULL 삽입
--  그런데 DEPT_TITLE 칼럼에는 NOT NULL 제약조건 설정되어 NULL 값 삽입 불가

-- 데이터 무결성: 중복 X, NULL X -> 신뢰도 높은 데이터
--> 대부분의 컬럼에 NOT NULL 제약조건 추가되어있음
--  NOT NULL이 설정된 테이블을 이용해서 VIEW를 만들면 INSERT가 거의 불가능

--> 결론: VIEW 가지고 DML을 수행하는 행동은 지양해라

--------------------------------------------------------------

-- WITH READ ONLY 옵션 추가
-- 읽기전용 X로 VIEW 변경
CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPT_COPY2;
					-- DEPT_TITLE 포함

INSERT INTO V_DCOPY2
VALUES('D0', '기획팀', 'L3'); --> 오류 없이 삽입됨

ROLLBACK;

-- 읽기전용으로 VIEW 변경
CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPT_COPY2
WITH READ ONLY;

-- 다시 INSERT 시도
INSERT INTO V_DCOPY2
VALUES('D0', '기획팀', 'L3'); --> 읽기 전용 뷰에서는 DML 작업 수행 불가

--------------------------------------------------------------

/* SEQUENCE(순서, 연속)
 * - 순차적으로 일정한 간격의 숫자(번호)를 발생시키는 객체(번호 생성기)
 * 
 * - SEQUENCE의 사용 목적
 * PK가 지정된 컬럼에 삽입될 값을 생성할 때 SEQUENCE를 이용하면 좋다
 * 
 * [작성법]
 * CREATE SEQUENCE 시퀀스이름
 * [START WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
 * [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
 * [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
 * [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
 * [CYCLE | NOCYCLE] -- 값 순환 여부 지정
 * [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
 *
 * 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둠
 * --> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로 
 *     매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상됨.
 * 
 * - 사용법
 * 1) 시퀀스명.NEXTVAL: 다음 시퀀스 번호를 얻어옴(INCREMENT BY 만큼 증가된 수)
 * 					  단 생성 후 처음 호출된 시퀀스인 경우 START WITH에 작성된 값이 반환
 * 2) 시퀀스명.CURRVAL: 현재 시퀀스 번호를 얻어옴
 * 					  단 시퀀스가 생성되자마자 호출할 경우 오류 발생(마지막으로 호출한 NEXTVAL 값 반환)
 * 
 */

-- 테이블 생성
CREATE TABLE TB_TEST(
	TEST_NO NUMBER PRIMARY KEY,
	TEST_NAME VARCHAR2(30) NOT NULL);

-- 시퀀스 생성
CREATE SEQUENCE SEQ_TEST_NO
START WITH 100 -- 100번부터 시작
INCREMENT BY 5 -- 5씩 증가
MAXVALUE 150   -- 최대값 150
NOMINVALUE	   -- 최소값 없음
NOCYCLE		   -- 반복 X
NOCACHE;       -- 미리 만들어두는 숫자 없음(캐시메모리 사용 X)

-- 시퀀스 생성 확인
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 100
SELECT SEQ_TEST_NO.CURRVAL FROM DUAL; -- 100

-- 다시 NEXTVAL 호출
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 105
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 110
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 115
SELECT SEQ_TEST_NO.CURRVAL FROM DUAL; -- 115

-- TB_TEST에 값 삽입
INSERT INTO TB_TEST
VALUES(SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL);

SELECT * FROM TB_TEST; -- 삽입 확인

-- INSERT 4번 추가 수행
INSERT INTO TB_TEST
VALUES(SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL);

SELECT * FROM TB_TEST; -- 삽입 확인

-- UPDATE에 시퀀스 사용
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO)
				 FROM TB_TEST); --> 계속 실행하면 MAXVALUE 초과

SELECT * FROM TB_TEST;

-- SEQUENCE 변경(ALTER)
/* [작성법]
 * ALTER SEQUENCE 시퀀스이름
 * [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
 * [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
 * [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
 * [CYCLE | NOCYCLE] -- 값 순환 여부 지정
 * [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
 */

-- SEQ_TEST_NO의 증가값을 1, 최대값 155로 수정
ALTER SEQUENCE SEQ_TEST_NO
INCREMENT BY 1
MAXVALUE 155;

-- UPDATE 구문 다시 수행
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO)
				 FROM TB_TEST);

SELECT * FROM TB_TEST;

--------------------------------------------------------------

-- VIEW, SEQUENCE 삭제
DROP VIEW V_DCOPY2;
DROP SEQUENCE SEQ_TEST_NO;

--------------------------------------------------------------

/* INDEX(인덱스)
 * - SQL 구문 중 SELECT 처리 속도 향상시키기 위해 컬럼에 대해 생성하는 객체
 * 
 * - 인덱스 내부 구조는 B* 트리 형식
 * 
 * - INDEX의 장점
 * - 이진 트리 형식으로 구성되어 자동 정렬 및 검색 속도 증가
 * - 조회시 테이블의 전체 내용을 확인하며 조회하는 것이 아닌 인덱스가 지정된 컬럼만을 이용해서
 *    조회하기 때문에 시스템의 부하가 낮아짐
 * 
 * - INDEX의 단점
 * - 데이터 변경(INSERT, UPDATE, DELETE) 작업 시 이진 트리 구조에 변형이 일어남
 *   -> DML 작업이 빈번한 경우 시스템 부하가 늘어 성능 저하
 * - 인덱스도 하나의 객체다 보니 별도의 저장 공간 필요
 * 
 * [작성법]
 * CREATE [UNIQUE] INDEX 인덱스명
 * ON 테이블명(컬럼명[, 컬럼명 | 함수명]);
 * 
 * DROP INDEX 인덱스명
 * 
 * -- 인덱스가 자동 생성되는 경우
 * -> PK 또는 UNIQUE 제약조건이 설정된 컬럼에 대해 인덱스가 자동생성
 */

-- 인덱스 사용 X 검색
SELECT * FROM EMPLOYEE
WHERE EMP_NAME != '0';

-- 인덱스 사용 검색: WHERE절에 INDEX가 설정된 컬럼 언급
SELECT * FROM EMPLOYEE
WHERE EMP_ID != '0';
--> 데이터가 너무 적어서 차이 식별 불가

-- 인덱스 확인용 테이블 생성
CREATE TABLE TB_INDEX_TEST(
	TEST_NO NUMBER PRIMARY KEY, -- UNIQUE INDEX 자동 생성
	TEST_ID VARCHAR2(20) NOT NULL);

-- TB_INDEX_TEST 테이블에 샘플 데이터 100만 개 삽입(PL/SQL 사용)
BEGIN
	FOR I IN 1..1000000
	LOOP 
		INSERT INTO TB_INDEX_TEST VALUES(I, 'TEST' || I);
	END LOOP;
	COMMIT;
END;

-- 인덱스 사용 X 검색
SELECT * FROM TB_INDEX_TEST
WHERE TEST_ID = 'TEST500000'; -- 101ms 소요

-- 인덱스 사용 검색
SELECT * FROM TB_INDEX_TEST
WHERE TEST_NO = 500000; -- 2ms 소요

DROP TABLE TB_INDEX_TEST; -- 테스트용 테이블 삭제

