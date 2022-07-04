6.3 ■ 다중 컬럼 서브쿼리
서브쿼리도 메인쿼리처럼 여러 개의 컬럼을 사용할 수 있다.
다중컬럼을 pair(쌍) 의 형태로 비교한다.

01. 부서별로 가장 많은 급여를 받는 사원의 
부서코드, 최대급여 조회
SELECT  department_id, MAX(salary) max_sal
FROM    employees
GROUP BY department_id
ORDER BY department_id;


부서  최대급여  이름
10	   4400
20	  13000
30	  11000
40	   6500
50	   8200
60	   9000
70	  10000
80	  14000
90	  24000
100	  12008
110	  12008
null	 7000



02. 부서별로 가장 많은 급여를 받는 사원의 
부서코드, 최대급여, '이름' 조회
SELECT  department_id, MAX(salary) max_sal, first_name --XXX
FROM    employees
GROUP BY department_id, first_name
ORDER BY department_id;

--내가 한거..
SELECT department_id, MAX(salary) max_sal, first_name 이름 --결국 틀린거야 이건
FROM employees
GROUP BY department_id, first_name -- 그룹함수 아닌절을 그룹에 넣어라 근데 이러면 101개 쫙 나와버림
ORDER BY department_id;

--선생님꺼
SELECT  e.department_id, e.salary, e.first_name --11
FROM    employees e
WHERE   (e.department_id, e.salary) IN ( SELECT department_id, MAX(salary) max_sal
                                         FROM   employees
                                         GROUP BY department_id )
ORDER BY e.department_id;


SELECT  e.department_id, e.salary, e.first_name --11개 그대로 나와
FROM    employees e
WHERE   (NVL(e.department_id,0), e.salary) IN ( SELECT NVL(department_id,0), MAX(salary) max_sal  --12개
                                                FROM   employees
                                                GROUP BY department_id )
ORDER BY e.department_id;

--NULL까지 포함

03. 부서별로 가장 많은 급여를 받은 사원의 
사번, 성명, 부서코드, 최대급여, 업무코드 조회
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name, e.department_id,
        e.salary, e.job_id
FROM    employees e
WHERE   (e.department_id, e.salary) IN ( SELECT department_id, MAX(salary) max_sal
                                         FROM   employees 
                                         GROUP BY department_id )
ORDER BY e.department_id;
                
                
                             