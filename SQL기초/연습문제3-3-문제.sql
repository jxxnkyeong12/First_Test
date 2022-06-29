-----------------------------------------------------------------------------------------------
--[연습문제 3-3]
--01. 사원테이블에서 30번 부서의 사번, 성명, 급여, 근무개월수, 근무년수(근무개월수/12)를 조회
--단, 근무개월수는 오늘 날짜를 기준으로 날짜함수를 사용
SELECT  employee_id, first_name || last_name name, salary,
        TRUNC(MONTHS_BETWEEN(SYSDATE,hire_date)) hd1,  --date1이 더 커야해 
        TRUNC(MONTHS_BETWEEN(SYSDATE,hire_date)/12) hd
FROM  employees
WHERE department_id = 30;


--02. 급여가 12000 이상인 사원들의 
--사번, 성명, 급여를 조회하여 급여순으로 정렬한다.
--급여는 공백없이(TRIM, FM) 천단위 기호(,)를 사용하여 표현한다.
--       ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
SELECT employee_id, first_name || last_name name,
       TO_CHAR(salary, 'FM$999,999,999')"급여1", 
       TRIM(TO_CHAR(salary, '$999,999,999')) "급여2"
FROM employees
WHERE salary >=12000
ORDER BY salary ASC;




--03. 2005년 전(2004년까지)에 입사한 사원들의 
--사번, 성명, 입사일자, 입사일의 요일(DAY, DY) 을 조회하여 
--최근에 입사(DESC)한 사원순으로 정렬한다.
SELECT employee_id, first_name || last_name name, hire_date hd, 
       TO_CHAR(hire_date, 'DY') 요일1,
       TO_CHAR(hire_date, 'DAY') 요일2       
FROM employees
WHERE hire_date >='2004/12/31' 
--WHERE TO_CHAR(hire_date, 'YYYY') <='2004'
ORDER BY hire_date DESC;



-----------------------------------------------------------------------------------------------


