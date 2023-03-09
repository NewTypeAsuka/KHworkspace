SELECT DEPT_CODE -- 23행 조회
FROM EMPLOYEE;

SELECT SUM(SALARY) -- 1행 조회
FROM EMPLOYEE;

-- 부서별 급여 합 조회
SELECT DEPT_CODE, SUM(SALARY) -- 에러(단일 그룹의 그룹 함수가 아님)
FROM EMPLOYEE;

/*3*/SELECT DEPT_CODE, SUM(SALARY)
/*1*/FROM EMPLOYEE
/*2*/GROUP BY DEPT_CODE;
-- 1) EMPLOYEE 테이블에서
-- 2) DEPT_CODE가 같은 행끼리 그룹을 지어
-- 3) 그룹별 SALARY 합계를 조회

--------------------------------------------------------------------

/* SELECT문 해석 순서
 * 
 * 5: SELECT 컬럼명, 함수, 계산식, 리터럴 [별칭]
 * 1: FROM 테이블명
 * 2: WHERE 조건식
 * 3: GROUP BY 그룹으로 묶을 컬럼명|함수
 * 4: HAVING 그룹함수를 이용한 조건식(GROUP BY가 있어야 작성 가능)
 * 6: ORDER BY 컬럼명|별칭|순서 정렬방식 [NULLS FIRST|LAST]
 */

-- GROUP BY 절: 같은 값들이 여러 개 기록된 컬럼을 하나의 그룹으로 묶음
-- 부서별 급여 평균
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 부서별 급여 합, 급여 평균, 인원 수, 최고참 입사입, 막내 입사일 조회
SELECT DEPT_CODE, SUM(SALARY),
	ROUND(AVG(SALARY)), COUNT(*),
	MIN(HIRE_DATE), MAX(HIRE_DATE)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 각 직급코드 별로 보너스를 받는 사원의 수 조회
SELECT JOB_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- EMPLOYEE 테이블에서 성별과 성별 별 급여 평균(내림), 급여 합, 인원 수 조회, 인원 수 오름차순 정렬
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') "성별",
	FLOOR(AVG(SALARY)) "급여 평균",
	SUM(SALARY) "급여 합",
	COUNT(*) "인원 수"
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') -- SELECT절이 아직 되지 않아 별칭 사용 불가
ORDER BY "인원 수" ASC;

-- WHERE + GROUP BY
--> WHERE절이 GROUP BY보다 선순위

-- EMPLOYEE 테이블에서 부서코드가 'D5', 'D6'인 부서의 평균 급여 조회
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6') -- 부서코드가 D5, D6인 행만 추린 후 
GROUP BY DEPT_CODE; -- 추려진 결과 내에서 부서코드 별로 그룹 나누기

-- EMPLOYEE 테이블에서 직급별 2000년도 이상 입사자들의 급여 합 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2000
-- WHERE HIRE_DATE >= TO_DATE('2000-01-01')
GROUP BY JOB_CODE;

-- 그룹 내 그룹 만들기
-- EMPLOYEE 테이블에서 부서별로 같은 직급인 사원의 급여 합 조회, 부서코드 오름차순 정렬
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE -- 큰 그룹, 작은 그룹
ORDER BY DEPT_CODE, JOB_CODE;

-- EMPLOYEE 테이블에서 부서 별로 급여 등급(SAL_LEVEL)이 같은 직원 수 조회, 부서코드 오름차순, 급여 등급 내림차순 정렬
SELECT DEPT_CODE, SAL_LEVEL, COUNT(*) "직원 수"
FROM EMPLOYEE
GROUP BY DEPT_CODE, SAL_LEVEL
ORDER BY DEPT_CODE ASC, SAL_LEVEL DESC;

--------------------------------------------------------------------

-- HAVING 절: 그룹 함수로 조회할 그룹에 대한 조건을 설정할 때 사용

-- 부서별 평균 급여가 300만 원 이상인 부서를 조회
/*4*/SELECT DEPT_CODE, AVG(SALARY)
/*1*/FROM EMPLOYEE
/*2*/GROUP BY DEPT_CODE
/*3*/HAVING AVG(SALARY) >= 3000000 -- GROUP BY에서 묶은 그룹에 조건을 대입
/*5*/ORDER BY 1;

-- 부서별 급여가 300만 원 이상인 사원들의 평균을 조회
/*4*/SELECT DEPT_CODE, AVG(SALARY)
/*1*/FROM EMPLOYEE
/*2*/WHERE SALARY >= 3000000 -- EMPLOYEE 테이블이 모든 행에 조건을 대입
/*3*/GROUP BY DEPT_CODE
/*5*/ORDER BY 1;

-- 부서별 급여 합이 900만 원을 초과하는 부서의 부서코드, 급여 합, 인원 수 조회
SELECT DEPT_CODE, SUM(SALARY), COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) > 9000000;

-- EMPLOYEE 테이블에서 부서별 70년대생의 급여 평균이 300만 원 이상인 부서를 찾아
-- 부서코드, 평균 급여(소수점 내림)를 조회, 부서코드 내림차순 정렬 
SELECT DEPT_CODE "부서코드", FLOOR(AVG(SALARY)) "평균 급여"
FROM EMPLOYEE
WHERE TO_NUMBER(SUBSTR(EMP_NO, 1, 2)) >= 70
	AND TO_NUMBER(SUBSTR(EMP_NO, 1, 2)) < 80
-- WHERE SUBSTR(EMP_NO, 1, 2) BETWEEN 70 AND 79
-- WHERE SUBSTR(EMP_NO, 1, 2) LIKE '7%'
-- WHERE SUBSTR(EMP_NO, 1, 1) = '7'
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000
ORDER BY DEPT_CODE DESC;

--------------------------------------------------------------------

-- 집계 함수
-- GROUP BY 절에 작성하여 그룹별로 산출한 결과를 집계하는 함수
-- ROLLUP, CUBE

-- ROLLUP: 그룹 별로 중간 집계와 전체 합계를 처리하는 함수
-- EMPLOYEE 테이블에서 각 부서에 소속된 직급별 급여 합, 부서별 급여 합, 전체 직원의 급여 합을 조회
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY 1;

-- CUBE: 그룹으로 지정된 모든 그룹에 대한 중간 집계와 총 합계를 처리하는 함수
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY 1; -- CUBE는 위 ROLLUP 구문에 이 구문이 추가되어 실행되는 것

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1;

--------------------------------------------------------------------

-- SET OPERATION(집합 연산)

-- 2개 이상의 SELECT 결과(RESULT SET)을 이용해 하나의 결과를 조회하는 연산자
-- 조건에 따른 SELECT 결과가 다른 경우 많은 SELECT를 한번에 조회할 때 유용

-- 주의사항: 집합 연산에 사용되는 SELECT문은 SELECT절의 타입, 순서, 개수가 동일해야 한다.

-- UNION: 합집합
-- INTERSECT: 교집합
-- UNION ALL: 합집합 + 교집합
-- MINUS: 차집합

-- UNION 확인
-- 집합 A: 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
-- 집합 B: 급여가 300만 원 초과인 사원의 사번, 이름 부서코드, 급여 조회
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- INTERSECT 확인
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- UNION ALL 확인
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- MINUS 확인
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 집합 연산은 2개 이상의 SELECT문에 사용 가능
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION 
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'
UNION 
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'
-- SELECT절의 타입, 개수, 순서 동일하면 집합 연산 가능
UNION
SELECT '이름', '부서코드'
FROM DUAL;