-- 문제 1번
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT;

-- 문제 2번
SELECT DEPARTMENT_NAME, CAPACITY
FROM TB_DEPARTMENT;

-- 문제 3번
SELECT STUDENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
AND SUBSTR(STUDENT_SSN, 8, 1) = 2
AND ABSENCE_YN = 'Y';

-- 문제 4번
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091',
					 'A513110', 'A513119')
ORDER BY 1 DESC;

-- 문제 5번
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY >= 20 AND CAPACITY <= 30;

-- 문제 6번
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 문제 7번
SELECT STUDENT_NAME, STUDENT_NO
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 문제 8번
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 문제 9번
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

-- 문제 10번
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) = 2002
AND ABSENCE_YN = 'N'
AND STUDENT_ADDRESS LIKE '%전주%'; 
