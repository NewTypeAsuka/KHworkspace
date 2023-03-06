-- 한줄 주석
/*
 * 범위 주석
 */

-- CTRL + ENTER: 선택한 SQL 수행
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 사용자 계정 생성
CREATE USER kh_lsj IDENTIFIED BY "oracle";

-- 사용자 계정에 권한 부여
GRANT RESOURCE, CONNECT TO kh_lsj;

-- 객체가 생성될 수 있는 공간 할당량 지정
ALTER USER kh_lsj DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

