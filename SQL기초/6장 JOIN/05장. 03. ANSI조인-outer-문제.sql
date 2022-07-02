-----------------------------------------------------------------------------------------------
--실습
--01. 모든 사원의 사번, 성, 부서명 조회 --107
--오라클 조인
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;


--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명
FROM employees e LEFT OUTER JOIN departments d
USING (department_id);
-----------------------------------------------------------------------------------------------
--02. 모든 사원의 사번, 성, 부서명, 업무코드 조회 --107
--오라클 조인
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, e.job_id 업무코드
FROM employees e, departments d
WHERE  e.department_id = d.department_id(+);

--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, e.job_id 업무코드
FROM employees e LEFT OUTER JOIN departments d
ON  e.department_id = d.department_id;

--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, e.job_id 업무코드
FROM employees e LEFT OUTER JOIN departments d
USING (department_id);
-----------------------------------------------------------------------------------------------
--03. 모든 사원의 사번, 성, 부서명, 도시명 조회 --107
--오라클 조인
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, l.city 도시명
FROM employees e, departments d, locations l
WHERE  e.department_id = d.department_id(+)
AND d.location_id = l.location_id(+);


--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, l.city 도시명
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
LEFT OUTER JOIN locations l
ON d.location_id = l.location_id;


--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, l.city 도시명
FROM employees e LEFT OUTER JOIN departments d
USING (department_id)
LEFT OUTER JOIN locations l
USING (location_id);

-----------------------------------------------------------------------------------------------
--04. 관리자사번이 149번인 
--모든 사원의 사번, 성, 부서명 조회 --6
--오라클 조인
SELECT e.employee_id 사번, e.last_name 성, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+) -- null도 잡아옴 
AND e.manager_id = 149;


--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 성, d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id -- null도 잡아옴  inner join 은 null빼고야!
WHERE e.manager_id = 149;



--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명
FROM employees e LEFT OUTER JOIN departments d
USING (department_id)
WHERE e.manager_id = 149;


-----------------------------------------------------------------------------------------------
--05. 커미션을 받는 모든 사원들의 
--사번, 성, 부서명, 도시명 조회 --35
--오라클 조인
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, l.city 도시명
FROM employees e , departments d, locations l
WHERE e.department_id = d.department_id(+)
AND d.location_id = l.location_id(+)
AND e.commission_pct IS NOT NULL;


--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, l.city 도시명
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
LEFT OUTER JOIN locations l
ON d.location_id = l.location_id
WHERE e.commission_pct IS NOT NULL;

--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명, l.city 도시명
FROM employees e LEFT OUTER JOIN departments d
USING (department_id)
LEFT OUTER JOIN locations l
USING (location_id)
WHERE e.commission_pct IS NOT NULL;
-----------------------------------------------------------------------------------------------
--06. 모든 부서에 대해 
--부서코드, 부서명, 도시명, 국가명, 대륙명 조회 --27
--오라클 조인
SELECT d.department_id 부서코드, d.department_name 부서명, l.city 도시명, c.country_name 국가명, r.region_name 대륙명
FROM departments d, locations l, countries c, regions r
WHERE d.location_id = l.location_id
AND l.country_id = c.country_id
AND c.region_id = r.region_id;

--ANSI JOIN ON 
SELECT d.department_id 부서코드, d.department_name 부서명, l.city 도시명, c.country_name 국가명, r.region_name 대륙명
FROM departments d LEFT OUTER JOIN locations l
ON d.location_id = l.location_id
LEFT OUTER JOIN countries c
ON l.country_id = c.country_id
LEFT OUTER JOIN regions r
ON c.region_id = r.region_id;

--ANSI JOIN USING
SELECT d.department_id 부서코드, d.department_name 부서명, l.city 도시명, c.country_name 국가명, r.REGION_NAME 대륙명
FROM departments d LEFT OUTER JOIN locations l
USING (location_id)
LEFT OUTER JOIN countries c
USING (country_id)
LEFT OUTER JOIN regions r
USING (region_id);


-----------------------------------------------------------------------------------------------
--07. 사원들이 근무하는 부서와 그 부서에 사원이 몇 명이나 있나 파악하고자 한다.
--    부서코드, 부서명, 사원수 조회 --12
--오라클 조인
SELECT COUNT(e.employee_id) 사원수, d.department_id 부서코드, d.department_name 부서명 
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
GROUP BY d.department_id, d.department_name  --그룹함수가 들어가면! 그룹함수에 안들어가는 컬럼은 여기에 명시해줘얗! 다!!!
ORDER BY 1;
------------------------------------------------------------뭐야??


--ANSI JOIN ON 
SELECT COUNT(e.employee_id) 사원수, d.department_id 부서코드, d.department_name 부서명 
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
GROUP BY d.department_id, d.department_name  --그룹함수가 들어가면! 그룹함수에 안들어가는 컬럼은 여기에 명시해줘얗! 다!!!
ORDER BY 1;
--ANSI JOIN USING

SELECT COUNT(e.employee_id) 사원수, department_id 부서코드, d.department_name 부서명 
FROM employees e LEFT OUTER JOIN departments d  
USING (department_id)
GROUP BY department_id, d.department_name  --그룹함수가 들어가면! 그룹함수에 안들어가는 컬럼은 여기에 명시해줘얗! 다!!!
ORDER BY 1;
-----------------------------------------------------------------------------------------------
--08. 성에 대소문자 무관하게 a 가 있는 성을 가진 사원들의 
--사번, 성, 부서명 조회 --56
--오라클 조인
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
AND LOWER(e.last_name) LIKE '%a%';


--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
WHERE LOWER(e.last_name) LIKE '%a%';


--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, d.department_name 부서명
FROM employees e LEFT OUTER JOIN departments d
USING (department_id)
WHERE LOWER(e.last_name) LIKE '%a%';
-----------------------------------------------------------------------------------------------
--[연습문제 5-2]
--01. 사번이 110, 130, 150 인 사원들의
--    사번, 이름, 부서명 조회 --3
--오라클 조인
SELECT e.employee_id 사번, e.last_name 이름, d.department_name 부서명
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.employee_id IN (110, 130, 150);

--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 이름, d.department_name 부서명
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
WHERE e.employee_id IN (110, 130, 150);

--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 이름, d.department_name 부서명
FROM employees e LEFT OUTER JOIN departments d
USING (department_id)
WHERE e.employee_id IN (110, 130, 150);
-----------------------------------------------------------------------------------------------
--02. 모든사원의 사번, 성, 부서코드, 업무코드, 업무제목 조회 --107
--사번순으로 정렬    
--오라클 조인
SELECT e.employee_id 사번, e.last_name 성, e.department_id 부서코드, j.job_id 업무코드, j.job_title 업무제목
FROM employees e, jobs j
WHERE e.job_id = j.job_id
ORDER BY 1;

--ANSI JOIN ON 
SELECT e.employee_id 사번, e.last_name 성, e.department_id 부서코드, j.job_id 업무코드, j.job_title 업무제목
FROM employees e LEFT OUTER JOIN jobs j
ON e.job_id = j.job_id
ORDER BY 1;

--ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, e.department_id 부서코드, job_id 업무코드, j.job_title 업무제목
FROM employees e LEFT OUTER JOIN jobs j
USING (job_id)
ORDER BY 1;
-----------------------------------------------------------------------------------------------








