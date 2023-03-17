/* DCL(Data Control Language)
 * - 사용자에 DB 또는 DB 객체에 대한 접근 권한을 부여(GRANT)하고 회수(REVOKE)하는 언어
 *
 * - 사용자(계정) 구분
 * 1) 관리자 계정
 * - 데이터베이스의 생성과 관리를 담당하는 사용자(계정)
 *   모든 권한과 책임을 가지는 계정
 *   ex) SYS(최고 관리자), SYSTEM(SYS에서 권한 몇개가 제외된 관리자)
 * 
 * 2) 사용자 계정
 * - 데이터베이스에 대하여 질의, 갱신, 보고서 작성 등의 작업을 수행할 수 있는 계정
 *   업무에 필요한 최소한의 권한만을 가지는 것을 원칙으로 함
 *   ex) kh 계정, workbook 계정
 * 
 * 
- 권한의 종류
1) 시스템 권한 : DB접속, 객체 생성 권한
관리자 계정 또는 관리자 권한이 있는 계정
CREATE SESSION   : 데이터베이스 접속 권한
CREATE TABLE     : 테이블 생성 권한
CREATE VIEW      : 뷰 생성 권한
CREATE SEQUENCE  : 시퀀스 생성 권한
CREATE PROCEDURE : 함수(프로시져) 생성 권한
CREATE USER      : 사용자(계정) 생성 권한
DROP USER        : 사용자(계정) 삭제 권한
DROP ANY TABLE   : 임의 테이블 삭제 권한


2) 객체 권한 : 특정 객체를 조작할 수 있는 권한
  권한 종류                 설정 객체
    SELECT              TABLE, VIEW, SEQUENCE
    INSERT              TABLE, VIEW
    UPDATE              TABLE, VIEW
    DELETE              TABLE, VIEW
    ALTER               TABLE, SEQUENCE
    REFERENCES          TABLE
    INDEX               TABLE
    EXECUTE             PROCEDURE
 */

---------------관리자 계정으로 접속---------------
-- 사용자 계정 sample 생성

-- 0. SQL 구문 작성 형식은 일반 형식(예전 11C 버전 이전 형식)으로 변경
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 1. 사용자 계정 생성
-- CREATE USER 사용자명 IDENTIFIED BY 비밀번호;
CREATE USER lsj_sample IDENTIFIED BY "sample1234";

-- 2. 생성된 sample 계정 접속 방법 추가
--> CREATE SESSION 권한이 없음(접속 권한 X)
--> sample 계정에 접속 권한 부여(GRANT)

-- 3. 접속 권한 부여
-- GRANT 권한[, 권한, 권한] TO 계정명;
GRANT CREATE SESSION TO lsj_sample;

-- 4. 권한 부여 후 접속 방법 추가

---------------sample 계정으로 접속---------------

-- 5. 테이블 생성
CREATE TABLE TB_MEMBER(
	MEMBER_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL);
--> 권한 불충분
--> 다시 관리자 계정으로 전환해서 테이블 생성 관련 권한 부여

---------------관리자 계정으로 접속---------------

-- 6. 테이블 생성 권한 부여
--    + 객체 생성 공간 할당
GRANT CREATE TABLE TO lsj_sample;

ALTER USER lsj_sample DEFAULT TABLESPACE SYSTEM
QUOTA UNLIMITED ON SYSTEM;

---------------sample 계정으로 접속---------------

-- 7. 테이블 생성 재시도
CREATE TABLE TB_MEMBER(
	MEMBER_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL);
	
-----------------------------------------------

-- 객체 권한 부여/회수
---------------sample 계정으로 접속---------------

-- 1. kh계정의 EMPLOYEE 테이블 조회
SELECT * FROM kh_lsj.EMPLOYEE; --> 권한이 없어서 다른 계정의 테이블이 보이지 않음

---------------kh 계정으로 접속---------------

-- 2. sample 계정에 EMPLOYEE 테이블 SELECT 권한 부여
-- 시스템 권한 부여: GRANT 권한[, 권한, 권한] TO 계정명;
-- 객체 권한 부여: GRANT 권한[, 권한, 권한] ON 객체명 TO 계정명;
GRANT SELECT ON EMPLOYEE TO lsj_sample;

---------------sample 계정으로 접속---------------

-- 3. kh계정의 EMPLOYEE 테이블 다시 조회
SELECT * FROM kh_lsj.EMPLOYEE; --> 조회 가능

-- 4. 선동일 삭제 시도
DELETE FROM kh_lsj.EMPLOYEE
WHERE EMP_NAME = '선동일'; --> 권한 불충분

---------------kh 계정으로 접속---------------

-- 5. sample 테이블의 EMPLOYEE 테이블 조회 권한 회수

-- 시스템 권한 회수: REVOKE 권한[, 권한, 권한] FROM 계정명;
-- 객체 권한 회수: REVOKE 권한[, 권한, 권한] ON 객체명 FROM 계정명;
REVOKE SELECT ON EMPLOYEE FROM lsj_sample;

---------------sample 계정으로 접속---------------

-- 6. 조회 권한 회수 되었나 확인
SELECT * FROM kh_lsj.EMPLOYEE; --> 조회 불가능

---------------관리자 계정으로 접속---------------

/* ROLE(역할 == 권한의 묶음)
 * - 여러 권한을 하나로 묶어둠
 * - 어려운 권한명(SESSION)을 쉽게 변경
 * 
 * 
 */

-- 1) RESOURCE: DB 사용을 위한 기본 객체 생성 권한의 묶음
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'RESOURCE';
--> sample 계정에 시퀀스, 프로시져, 클러스, 인덱스타입, 연산자, 타입, 트리거, 테이블 생성 권한 부여
GRANT CREATE CREATE SEQUENCE
	  CREATE PROCEDURE
	  CREATE CLUSTER
      CREATE INDEXTYPE
	  CREATE OPERATOR
	  CREATE TYPE
	  CREATE TRIGGER
	  CREATE TABLE TO lsj_sample;
--> ROLE을 이용해서 간단히
GRANT RESOURCE TO lsj_sample;
REVOKE RESOURCE FROM lsj_sample;

-- 사용자에게 부여된 롤 조회
SELECT * FROM DBA_ROLE_PRIVS
WHERE GRANTEE = 'LSJ_SAMPLE';

-- 2) CONNECT: CREATE SESSION(DB 접속 권한) 하나만을 가지고 있는 ROLE
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'CONNECT';

-- 앞으로 사용자 계정 권한을 생성할 경우 권한 부여 구문
GRANT CONNECT, RESOURCE, CREATE VIEW TO 계정명;
