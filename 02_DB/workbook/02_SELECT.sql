-- 문제 1번
SELECT STUDENT_SSN 학번, STUDENT_NAME 이름, ENTRANCE_DATE 입학년도
FROM TB_STUDENT
WHERE DEPARTMENT_NO = 002
ORDER BY 3;

-- 문제 2번
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSOR_NAME NOT LIKE '___';

-- 문제 3번
SELECT PROFESSOR_NAME 교수이름,
	FLOOR(MONTHS_BETWEEN(SYSDATE,
	ADD_MONTHS(TO_DATE(SUBSTR(PROFESSOR_SSN, 1, 6), 'YYMMDD'), -1200))
	/12) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) IN ('1', '3')
ORDER BY 나이 ASC;

-- 문제 4번
SELECT SUBSTR(PROFESSOR_NAME, 2, 2) 이름
FROM TB_PROFESSOR;

-- 문제 5번
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE)
	- EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN, 1, 6))) >= 20;
	
-- 문제 6번
SELECT TO_CHAR(TO_DATE('2020-12-25'), 'DAY')
FROM DUAL;

-- 문제 7번
SELECT
TO_DATE('99/10/11', 'YY/MM/DD'),
TO_DATE('49/10/11', 'YY/MM/DD'),
TO_DATE('99/10/11', 'RR/MM/DD'),
TO_DATE('49/10/11', 'RR/MM/DD')
FROM DUAL;

-- 문제 8번
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO NOT LIKE 'A%';

-- 문제 9번
SELECT ROUND(AVG(POINT), 1) 평점
FROM TB_STUDENT
NATURAL JOIN TB_GRADE
WHERE STUDENT_NO LIKE 'A517178';

-- 문제 10번
SELECT DEPARTMENT_NO "학과번호", COUNT(*) "학생수(명)"
FROM TB_DEPARTMENT
NATURAL JOIN TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 1;

-- 문제 11번
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 문제 12번
SELECT 년도, ROUND(AVG(POINT), 1) AS "년도 별 평점"
FROM (SELECT
	  CASE 
	   	  WHEN SUBSTR(TERM_NO, 1, 4) = '2001' THEN '2001'
		  WHEN SUBSTR(TERM_NO, 1, 4) = '2002' THEN '2002'
		  WHEN SUBSTR(TERM_NO, 1, 4) = '2003' THEN '2003'
		  WHEN SUBSTR(TERM_NO, 1, 4) = '2004' THEN '2004'
	  END 년도, POINT
	  FROM TB_STUDENT
	  NATURAL JOIN TB_GRADE
	  WHERE STUDENT_NO = 'A112113')
GROUP BY 년도
ORDER BY 년도;

-- 문제 13번(미완)
SELECT *
FROM TB_DEPARTMENT
LEFT JOIN TB_STUDENT USING (DEPARTMENT_NO)
ORDER BY 1;

-- 문제 14번(미완)
SELECT *
FROM TB_STUDENT;

-- 문제 15번(미완)
SELECT SUBSTR(TERM_NO, 1, 4) 년도,
	SUBSTR(TERM_NO, 5, 2) 학기,
	POINT 평점
FROM TB_STUDENT
NATURAL JOIN TB_GRADE
WHERE STUDENT_NO = 'A112113';