6장.  서브쿼리(Sub Query)

SQL 문장 안에 존재하는 또 다른 SQL 문장을 서브쿼리라 한다.
서브쿼리는 괄호로 묶어 사용하고 서브쿼리가 포함된 쿼리문을 메인쿼리라 한다.
  
  서브쿼리는 단일 행 또는 복수행 비교 연산자와 함께 사용 가능
  서브쿼리에서는 ORDER BY 구문을 사용하지 못함
  ORDER BY는 메인쿼리의 문장의 마지막에 하나만 위치할 수 있다.
  서브쿼리의 결과는 메인쿼리의 조건으로 사용
  서브쿼리는 메인쿼리가 서브쿼리를 포함하는 종속적인 관계
  서브쿼리는 연산자 오른쪽에 사용
  여러번의 쿼리를 수행애야만 얻을 수 있는 결과를 하나의 중첩된 sql 문장으로 간편하게 구함
  
서브쿼리 사용이유
1. 알려지지 않은 기준을 이용한 검색을 위해
테이블내에서 조건을 설정하기 어려워 다른 테이블에서 조건들 가져와야 할 경우
단일 SELECT  문으로 조건실을 만들기에는 조건이 복잡할깨
  또는 완전히 다른 테이블에서 데이터 값을 조회하여 메인 쿼리의 조건으로 사용할 경우

2. DB 접근하는 속도를 향상 시킴  

서브쿼리가 사용가능 한 곳
SELECT 절
FROM  절
WHERE   제일많이 사용
HAVING  절
ORDER BY
INSERT 절의 VALUE 절
UPDATE 절의 SET 절

※ 서브쿼리의 위치에 따른 명칭
1. SELECT 절에서 사용하는 서브쿼리
   ○ 스칼라 서브쿼리 : SQL 에서는 단일값을 스칼라값이라 함
   Scalar : (크기)하나, Vector : 크기와 방향
   SELECT 문에서 서브쿼리를 사용하여 하나의 컬럼처럼 사용하기 위한 목적(컬럼 표현 용도)
   조인의 대체 표현식으로 자주 사용
   
   ○ 상호연관 서브쿼리 : 서브쿼리 내에서 메인 쿼리의 컬럼을 사용하는 것
   
2. FROM 절에서 사용하는 서브쿼리
   ○ 인라인 뷰 서브쿼리
   SELECT 절의 결과를 FROM 절에서 하나의 테이블처럼 사용(테이블 대체 용도)
   인라인 뷰 서브쿼리에는 ORDER BY 절은 올 수 없음.
   (출력용도가 아닌 테이블처럼 사용하므로 굳이 정렬할 필요가 없음)
   중요 : 인라인 뷰 서브쿼리에서 그룹함수는 반드시 ALIAS 지정해야 함
   왜냐면 ALIAS 를 지정함으로서 하나의 컬럼으로 사용하므로
      
3. WHERE 절에서 사용하는 서브쿼리
  ○ 일반 서브쿼리 - 메인 쿼리문 안에 있는 또 다른 쿼리문(WHERE/HAVING 조건절 안에서 사용)
  * 서브쿼리의 SELECT 절의 결과를 하나의 변수(상수)처럼 사용
  (조건절은 서브쿼리의 결과에 따라 달라짐) ☜ 단일(결과)행인지, 다중(결과)행인지, 
                                             다중컬럼인지에 따라 달라짐
  --중요!!! 보통 함수로 구한값과 비교할때, 다른곳에서 구한값과 비교할때
  1) 단일(결과)행 서브쿼리 : 조건절에 사용하는 서브쿼리의 결과행이 단일행인경우
                             (조건의 결과값을 기준으로 결과가 하나) 
  2) 다중(결과)행 서브쿼리 : 조건절에 사용하는 서브쿼리의 결과행이 여러행인경우
                             (조건의 결과값을 기준으로 결과가 여러개) 
  3) 다중컬럼     서브쿼리 : 조건절에 사용하는 서브쿼리의 결과컬럼이 여러컬럼인경우
                             (조건의 결과값을 기준으로 컬럼이 여러개)  

1. 조건절(WHERE, HAVING)에 사용하는 단일결과행 서브쿼리, 
                   조건의 결과값을 기준으로 결과가 하나
01. 급여가 우리회사 평균 급여보다 더 적은 급여를 받는 사원의
사번, 이름, 성, 급여 정보를 조회
단일결과행 서브쿼리 연산자 : =, !=, <>, <, >, <=, >=
SELECT  employee_id, first_name, last_name, salary
FROM    employees
WHERE   salary <= AVG(salary); --WHERE 절에 그룹함수 사용 불가

SELECT  AVG(salary) --6461.831775700934579439252336448598130841
FROM    employees;

SELECT  employee_id, first_name, last_name, salary --56
FROM    employees
WHERE   salary <= 6461.831775700934579439252336448598130841; --WHERE 절에 그룹함수 사용 불가

SELECT  employee_id, first_name, last_name, salary --56
FROM    employees
WHERE   salary <= ( SELECT AVG(salary)
                    FROM employees );
[예제 6-2] 월급여가 가장 많은 사원의 
사번, 이름, 성 정보를 조회한다.
SELECT  employee_id, last_name, first_name
FROM    employees
WHERE   salary = (SELECT MAX(salary) FROM employees);


[예제 6-3] 사번 108번 사원의 급여보다 더 많은 급여를 받는 사원의 
사번, 이름, 급여를 조회한다.
SELECT  employee_id, first_name, salary --6
FROM    employees
WHERE   salary > ( SELECT salary FROM employees WHERE employee_id = 108 );

[예제 6-4] 월급여가 가장 많은 사원의 
사번, 이름, 성, 업무제목 정보를 조회한다.
SELECT  employee_id, first_name, last_name, job_title --1
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id(+)
AND     salary = ( SELECT MAX(salary)
                   FROM   employees );

2. 다중(결과행)서브쿼리
: 조건절에 사용하는 서브쿼리의 결과행이 여러행인 경우,
  조건의 결과값을 기준으로 결과값이 여러개
- 연산자 : IN, NOT IN(즉 '='을 IN으로 대체한다고 생각)
비교의 대상이 2개이상은 대소비교 불가, 그래서, IN 사용
WHERE 절에서는 그룹함수 사용 불가
하지만 WHERE 절 안에 있는 서브쿼리에는 그룹함수 사용 가능

01. 부서의 위치코드가 1700인 부서에 속한 사원들의
부서의 위치코드가 1700인 부서
SELECT  department_id --21
FROM    departments
WHERE   location_id = 1700

사번, 성, 부서코드, 업무코드 조회
일반쿼리
SELECT  e.employee_id, e.last_name, e.department_id, e.job_id --18
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
AND     d.location_id = 1700;

서브쿼리
SELECT  e.employee_id, e.last_name, e.department_id, e.job_id --18
FROM    employees e
WHERE   e.department_id IN ( SELECT department_id 
                             FROM   departments 
                             WHERE  location_id = 1700);

02. 근무지의 국가코드가 UK(즉, country_id = UK)인 위치에 있는 
부서코드, 위치코드, 부서명 조회
일반조인

다중결과행서브쿼리


03. 60번부서원들과 같은 급여를 받는 사원들의
사번, 성, 급여, 부서코드 조회
일반쿼리
SELECT  DISTINCT e.employee_id, e.last_name, e.salary, e.department_id
FROM    employees e, employees m
WHERE   e.salary = m.salary(+)
AND     m.department_id = 60;

SELECT  A.employee_id, A.last_name, A.salary, A.department_id
FROM    employees A
INNER JOIN employees B
ON A.salary LIKE B.salary
WHERE B.department_id = 60; 

서브쿼리
SELECT  employee_id, last_name, salary, department_id
FROM    employees
--WHERE   salary = (60번부서의급여)
WHERE   salary IN ( SELECT salary
                    FROM   employees
                    WHERE  department_id = 60 );


04. 우리회사 사원들 중 부서명이 Marketing 이거나 IT에 속한 사원들의
사번, 성, 부서코드 조회

조건 부서명이 Marketing 이거나 IT에 속한 사원들에 속한 부서의
SELECT  department_id
FROM    departments 
WHERE   LOWER(department_name) IN ('marketing','it');

SELECT  e.employee_id, e.last_name, e.department_id
FROM    employees e
WHERE   e.department_id IN (  SELECT  department_id
                              FROM    departments 
                              WHERE   LOWER(department_name) 
                                      IN ('marketing','it') );

































































































[예제 6-1] 평균급여보다 더 적은 급여를 받는 사원의 사번, 이름, 성 정보를 조회한다.





















