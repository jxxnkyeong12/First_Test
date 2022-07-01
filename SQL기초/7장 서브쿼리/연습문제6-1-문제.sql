------------------------------------------------------------------------
[연습문제 6-1]
01. 우리회사에서 가장 적은 급여를 받는 사원의 
사번, 성, 업무코드, 부서코드, 부서명, 급여 조회 --1
서브쿼리
SELECT e.employee_id 사번, e.last_name 성, d.department_id 업무코드, d.department_name 부서명, e.salary 급여
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.salary = (SELECT MIN(salary) FROM employees ); 



02. 부서명이 Marketing 인 부서에 속한 사원들의 
사번, 성명, 부서코드, 업무코드 조회 --2
일반쿼리
SELECT e.employee_id, e.last_name, e.department_id, e.job_id
FROM employees e, departments d 
WHERE e.department_id = d.department_id
AND d.department_name = 'Marketing' ;


--서브쿼리
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name,
        e.department_id, e.job_id
FROM    employees e
--AND     e.department_id = (부서명이 Marketing인 부서)
WHERE     e.department_id = ( SELECT department_id 
                              FROM    departments 
                              WHERE   LOWER(department_name) LIKE '%marketing%');


03. 우리회사 사장님보다 먼저 입사한 사원들의 
사번, 성명, 입사일자 조회 --10 SELF JOIN
사장은 그를 관리하는 매니저가 없는 사원을 말한다
일반쿼리
SELECT hire_date
FROM employees
WHERE manager_id IS NULL;

SELECT e.employee_id 사번, e.first_name || ' ' || last_name 성명, e.hire_date, m.hire_date
FROM employees e, employees m
WHERE m.hire_date < (SELECT hire_date FROM employees WHERE MIN(hire_date)); 


SELECT employee_id 사번, first_name || ' ' || last_name 성명, hire_date 입사일자, 
FROM employees 
WHERE (MIN) hire_date > (SELECT hire_date FROM employees WHERE  AND manager_id IS NULL); 


--선생님 풀이
사장님 입사일자
SELECT hire_date --03/06/17
FROM   employees
WHERE  manager_id IS NULL;


일반쿼리
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name
FROM    employees e, employees m
--WHERE   e.manager_id = m.employee_id(+) --☜ 단순히 날짜만 필요하므로 조인조건식 필요없음
--WHERE   내입사일자 < 사장님입사일자
--AND     사장님 = 매니저가없는사원
WHERE   e.hire_date < m.hire_date
AND     m.manager_id IS NULL;

서브쿼리
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name
FROM    employees e
WHERE   e.hire_date < ( SELECT hire_date
                        FROM   employees
                        WHERE  manager)id IS NULL );

------------------------------------------------------------------------