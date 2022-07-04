6.6 인라인 뷰 (Inline View)
인라인 뷰는 FROM절에 사용되는 서브쿼리 형식이다.
쿼리가 실행될 때 생성되었다가 사라지는 임시성 뷰라 할 수 있다.
메인쿼리에 독립적이고 WHERE 절에서 메인쿼리의 테이블과 JOIN 을 통해 관계를 맺는다.
FROM절에 사용하는 인라인뷰 서브쿼리에서 그룹함수는 반드시 ALIAS 지정해야 함
메인쿼리에서 ALIAS 명을 컬럼명으로 사용하기 위해




01. 우리회사 사원들의 급여 정보를 관리하는 테이블이 있다.
우리회사 최대급여, 최소급여, 평균급여를 조회
SELECT  MAX(salary) max_sal, MIN(salary) min_sal, ROUND(AVG(salary), 2) avg_sal
FROM    employees e;



--------------------------------------------------------------------------------
02. 우리회사 사원들의 급여 정보를 관리하는 테이블이 있다.
사번, 성, 급여, 우리회사 최대급여, 최소급여, 평균급여를 조회
SELECT  e.employee_id, e.last_name, e.salary, 
        MAX(salary) max_sal, MIN(salary) min_sal, ROUND(AVG(salary), 2) avg_sal
FROM    employees e
GROUP BY e.employee_id, e.last_name, e.salary;

--다중컬럼 서브쿼리로는 안되구 스칼라서브쿼리로 구해보기
SELECT  e.employee_id, e.last_name, e.salary, 
        ( SELECT MAX(salary) FROM employees) max_sal, 
        ( SELECT MIN(salary) FROM employees) min_sal, 
        ( SELECT ROUND(AVG(salary),2) FROM employees) avg_sal
FROM    employees e;


--우리회사 최대급여, 최소급여, 평균급여
SELECT  MAX(salary) max_sal, MIN(salary) min_sal, ROUND(AVG(salary), 2) avg_sal
FROM    employees e; --결과가 하나 나왔지만 그래도 테이블


SELECT e.employee_id, e.last_name, e.salary, m.min_sal, m.avg_sal
--인라인 뷰 서브쿼리 - 테이블 만들어서 하는거!       
FROM    employees e, ( SELECT MAX(salary) max_sal, MIN(salary) min_sal, ROUND(AVG(salary)) avg_sal
                       FROM   employees ) m;
                   
                   
--------------------------------------------------------------------------------
03. 각부서별로 가장 많은 급여를 받는 사원들의
사번, 성, 부서코드, 급여 조회
--①다중컬럼서브쿼리 방법
SELECT  e.employee_id, e.last_name, e.department_id, e.salary
FROM    employees e
WHERE   (NVL(e.department_id,0), e.salary) IN 
        ( SELECT  NVL(department_id,0), MAX(salary) max_sal
          FROM    employees
          GROUP BY department_id )
ORDER BY e.department_id;

--②인라인 뷰 서브쿼리
SELECT  e.employee_id, e.last_name, e.department_id, e.salary
--FROM    employees e, ( 부서별 최대급여)
FROM    employees e, ( SELECT department_id, MAX(salary) max_sal
                       FROM   employees
                       GROUP BY department_id ) m
WHERE   e.salary = m.max_sal
AND     e.department_id = m.department_id
ORDER BY  e.department_id;

[6-24] 급여가 회사 평균급여 이상이고 최대급여 이하인 사원의
사번, 이름, 급여, 회사평균급여, 회사최대급여를 조회한다.

SELECT ROUND(avg(e.salary),2) avg_sal, max(e.salary) max_sal   ----6461.83  / 24000
FROM employees e;

--①스칼라서브쿼리

SELECT  e.employee_id, e.first_name, e.salary
        ( SELECT  ROUND(AVG(salary)) FROM  employees ) avg_sal,
        ( SELECT  MAX(salary) FROM  employees ) max_sal
FROM    employees e
WHERE   salary BETWEEN ( SELECT  ROUND(AVG(salary)) FROM  employees )
        AND ( SELECT  MAX(salary) FROM  employees );


--②인라인뷰 서브쿼리 (복붙해오기...)

SELECT  e.employee_id, e.first_name, e.salary, m.avg_sal, m.max_sal, m.min_sal
FROM    employees e, ( SELECT MAX(salary) max_sal, MIN(salary) min_sal, 
                              ROUND(AVG(salary)) avg_sal 
                       FROM   employees ) m
WHERE   e.salary  BETWEEN m.avg_sal AND max_sal;

04.각 부서별로 가장 많은 급여를 받는 사원들의 
사번, 성, 부서코드, 급여조회

--다중컬럼 서브쿼리  12개
SELECT e.department_id, e.first_name, e.department_id, e.salary 
FROM employees e
WHERE (NVL(e.department_id,0), e.salary) IN (SELECT NVL(department_id,0), MAX(salary) max_sal 
                                             FROM employees 
                                             GROUP BY department_id )
ORDER BY e.department_id;

--인라인 뷰 서브쿼리로 해보기  12개
SELECT e.department_id, e.first_name, e.department_id, e.salary  
FROM employees e, (SELECT department_id, MAX(salary) max_sal 
                   FROM employees 
                   GROUP BY department_id ) m
WHERE NVL( e.department_id,0) = NVL( m.department_id,0)
AND e.salary = m.max_sal(+);


--------------------------------------------------------------------------------

7.몇개의 데이터행만 조회해보자
: ROWNUM - 테이블 존재하는 컬럼이지만 가짜 컬럼으로 사용 (PSEUDO COLUMN) 
  쿼리문의 결과(조회 후, 즉, SELECT 절의 결과)로 나온 각 행에 대한 순서값(중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!)
-- ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣

서브쿼리에서 먼저 정렬(ORDER BY) 후 메인쿼리에서 순번 매기기(ROWNUM)
--ROWNUM 과 인라인뷰의 특성을 사용하여 페이징 처리 하는 기법을 수행

우리회사 사원들의 
사번, 성, 급여 조회
SELECT employee_id, last_name, salary --107개
FROM employees;

ROWNUM 추가
SELECT ROWNUM employee_id, last_name, salary --107개
FROM employees;


급여를 많이 받는 순으로 정렬

우리회사 사원들의 
사번, 성, 급여 조회

SELECT ROWNUM employee_id, last_name, salary --107개
FROM employees
ORDER BY salary DESC;


우리회사 사원들의 사번순으로 정렬하여 10번까지 
사번, 성, 급여 조회
SELECT ROWNUM, employee_id, last_name, salary
FROM employees
WHERE ROWNUM <= 10;
ORDER BY salary DESC;

SELECT  ROWNUM, e.*
--FROM    (급여 내림차운으로 정렬된 테이블)
FROM    (SELECT employee_id, last_name, salary 
         FROM employees 
         ORDER BY salary DESC ) e
WHERE ROWNUM <=10;


▶입사일자가 빠른 사원 10명에 대해 
사번, 성, 입사일자 조회
SELECT ROWNUM, e.*
--FROM (입사일순서로 정렬된 테이블)
FROM  (SELECT employee_id, last_name, hire_date
       FROM employees
       ORDER BY hire_date ASC) e  
WHERE ROWNUM <= 10;


--■등수 구하기
RANK()  OVER(ORDER BY 순위결정기준컬럼)       ▶ 1, 2, 2, 4
DENSE_RANK()  OVER(ORDER BY 순위결정기준컬럼) ▶ 1, 2, 2, 3


▶입사일자가 빠른 사원 10명에 대해 
사번, 성, 입사일자 조회
--SELECT 등수 
SELECT RANK() OVER(ORDER BY hire_date ASC) rank, --rank로 별명붙여줘 
       employee_id, last_name, hire_date
FROM employees
WHERE ROWNUM <=10
ORDER BY hire_date ASC;

SELECT e.*
FROM (SELECT RANK() OVER(ORDER BY hire_date ASC) rank, --rank로 별명붙여줘 원래 조건절은 안되지만, 지금은 하나의 테이블이 된거니까 사용가넝한...
       employee_id, last_name, hire_date
      FROM employees
      ORDER BY hire_date ASC ) e
WHERE ROWNUM <=10

