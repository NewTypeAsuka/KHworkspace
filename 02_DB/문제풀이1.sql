-- 1번 문제
SELECT EMP_NAME "사원명",
	FLOOR(ABS(HIRE_DATE-SYSDATE)) "근무일수1",
	FLOOR(ABS(SYSDATE-HIRE_DATE)) "근무일수2"
FROM EMPLOYEE;

-- 2번 문제
SELECT EMP_ID, EMP_NAME, EMAIL, PHONE
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;
-- WHERE SUBSTR(EMP_ID, -1, 1) IN (1, 3, 5, 7, 9);

-- 3번 문제
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20;
-- WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12 >= 20; 

-- 4번 문제
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') AS 주민등록번호
-- SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, 9), '******') AS 주민등록번호
FROM EMPLOYEE;

-- 5번 문제
SELECT EMP_NAME, JOB_CODE,
	TO_CHAR(
	NVL((SALARY+(SALARY*BONUS))*12, SALARY*12),
	'L999,999,999') AS "연봉(원)"
FROM EMPLOYEE;

-- 6번 문제
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D5'
	OR DEPT_CODE = 'D9')
	AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;
	
-- 7번 문제
SELECT EMP_NAME, HIRE_DATE,
	(LAST_DAY(HIRE_DATE)-HIRE_DATE+1) AS "입사한 달의 근무 일수"
FROM EMPLOYEE;

-- 8번 문제
SELECT EMP_NAME, DEPT_CODE, 
	SUBSTR(EMP_NO, 1, 2)||'년 '||
	SUBSTR(EMP_NO, 3, 2)||'월 '||
	SUBSTR(EMP_NO, 5, 2)||'일' AS 생년월일,
	FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6)))/12) 	
	AS "만 나이"
FROM EMPLOYEE;