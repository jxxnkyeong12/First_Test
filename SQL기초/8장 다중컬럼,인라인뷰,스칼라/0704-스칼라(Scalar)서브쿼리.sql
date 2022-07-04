--6.5 스칼라(Scalar) 서브쿼리
스칼라 서브쿼리는 SELECT 절에 사용되는 서브쿼리 형식이다.
코드성 테이블에서 코드명(컬럼명)을 조회하거나
그룹함수의 결과 값을 조회할 때 많이 사용된다.

1) 단순한 그룹함수의 결과값을 SELECT 절에서 조회하고자 할 경우
01. 각사원의 급여수준을 조회하자 한다.
모든 사원의 사번, 성, 급여, 회사평균급여, 회사 최대급여조회
SELECT  ROUND(AVG(e.salary),2) avg_sal, MAX(e.salary) max_sal --6461.83	24000
FROM    employees e;


SELECT  e.employee_id, e.last_name, e.salary, 
        ROUND(AVG(salary),2) avg_sal, MAX(salary) max_sal --XXX
FROM    employees e
GROUP BY e.employee_id, e.last_name, e.salary;

SELECT  e.employee_id, e.last_name, e.salary, 
        ( SELECT  ROUND(AVG(salary),2)
          FROM    employees ) avg_sal, 
        ( SELECT  MAX(salary) 
          FROM    employees ) max_sal --OOO
FROM    employees e;



02. 모든 사원의 사번, 성, 부서코드, 업무코드, 업무제목 조회(스칼라 서브쿼리로 업무제목 조회)
--스칼라 서브쿼리로 업무제목 구하기)
--① 오라클 쿼리
SELECT  e.employee_id, e.last_name, e.department_id, e.job_id, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id(+);

--② 스칼라서브쿼리
SELECT  e.employee_id, e.last_name, e.department_id, e.job_id, 
        ( SELECT  j.job_title
          FROM    jobs j
          WHERE   e.job_id = j.job_id(+)) job_title
FROM    employees e;



03.각 부서에 대해 부서코드, 부서명, 도시를 조회
(도시를 스칼라서브쿼리로 구하기)
--① 일반쿼리
SELECT  d.department_id, d.department_name, l.city
FROM    departments d, locations l
WHERE   d.location_id = l.location_id;

--② 스칼라서브쿼리
SELECT  d.department_id, d.department_name, 
        ( SELECT  l.city
          FROM    locations l
          WHERE   d.location_id = l.location_id ) city
FROM    departments d;


--------------------------------------------------------------------------------
04. 모든 부서별 부서코드, 부서평균 급여조회
--① 일반쿼리
SELECT  e.department_id, ROUND(AVG(e.salary), 2) avg_sal
FROM    employees e
GROUP BY e.department_id;

--② 스칼라 서브쿼리
SELECT  e.department_id, 
        ( SELECT ROUND(AVG(salary), 2)
          FROM   employees
          WHERE  department_id = e.department_id ) avg_sal
FROM    employees e
GROUP BY e.department_id;

