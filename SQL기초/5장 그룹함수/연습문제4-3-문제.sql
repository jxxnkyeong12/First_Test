-----------------------------------------------------------------------------------------------                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               

--실습
--01. 우리회사 사원들의 업무형태(업무코드)별 사원 수를 파악하고자 한다.
--업무형태(업무코드), 사원수 조회
SELECT  job_id 업무형태, COUNT(*) 사원수
FROM employees
GROUP BY job_id ;




--02. 부서별 급여 정보를 파악하고자 한다.
--부서코드, 급여평균 조회- 급여평균이 높은 부서부터 정렬하고
--급여평균는 반올림하여 소수 둘째자리까지 표현.

SELECT department_id, ROUND(AVG(salary),2) avg_sal
FROM employees
GROUP BY department_id   --salary그냥 하면 group by가 안먹혀.
--HAVING department_id IS NOT NULL
ORDER BY ROUND(AVG(salary),2) DESC; --근데 ORDER BY 2; 라고 하면 좋아 시험 제출할때는 숫자쓰지 말구 이렇게 싹 써~ ㅎ
--ORDER BY salary하면 틀려!


--03. 부서별, 업무별 급여합계를 파악하고자 한다.
--부서코드, 업무코드, 급여합계 조회
SELECT department_id, job_id, SUM(salary)
FROM employees
GROUP BY department_id, job_id;


--04. 부서코드 60번 부서에 속한 사원들의 사원 수를 파악하고자 한다.
--60 번 부서에 속한 사원들의 사원 수를 조회(HAVING 절 사용)
 
SELECT department_id, COUNT(*) 사원수
FROM employees
GROUP BY department_id
HAVING department_id = 60
ORDER BY 1;

--05. 부서의 급여평균이 10000 이상인 부서를 파악하고자 한다.
--부서의 급여평균이 10000이상인 부서코드, 급여평균를 조회
--급여평균는 반올림하여 소수 둘째자리까지 표현.

SELECT department_id, ROUND(AVG(salary),2)
FROM employees 
GROUP BY department_id
HAVING ROUND(AVG(salary)) >=10000
order by 1;


--06. 각 부서별 부서코드, 부서원수, 부서급여평균 조회
SELECT department_id, COUNT(*) cnt, ROUND(AVG(salary),2) avg_sal
FROM employees
GROUP BY department_id 
HAVING department_id IS NOT NULL
order by 1;

--07. 100번 부서에 대한 정보를 파악하고자 한다.
--100번 부서의 부서코드, 부서원수, 부서급여평균 조회

SELECT department_id, count(*),  ROUND(AVG(salary),2)
FROM employees
GROUP BY department_id
HAVING department_id = 100;


--08. 각 부서별 정보를 파악하고자 한다.
--각 부서별 부서원수가 15명 이상인 부서에 대해 부서코드, 부서원수, 부서급여평균 조회

SELECT department_id, count(*), ROUND(AVG(salary),2) avg_sal
FROM employees
GROUP BY department_id
HAVING count(*) >=15 ;

--09. 각 부서의 부서급여평균이 8000 이상인 부서에 대해
--부서코드, 부서원수, 부서급여평균 조회

SELECT department_id, count(*), ROUND(AVG(salary),2) avg_sl
FROM  employees
GROUP BY department_id 
HAVING  ROUND(AVG(salary),2) >=8000
order by 1;

--10. 각 부서별 최대급여를 파악하고자 한다. 
-- 각 부서의 최대급여가 10000 이상인 부서코드, 최대급여를 조회. 

SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) >=10000
ORDER BY 1;

--11. 두 명 이상 있는 성이 어떤 것들이 있나 파악하고자 한다. 
--두 명 이상 있는 성과, 수를 조회

SELECT last_name, count(*) 사원수
FROM employees
GROUP BY last_name
HAVING count(*) >=2
order by 1;

--12. 년도별(오름차순)로 입사한 사원 수를 파악하고자 한다. 
--입사년도, 사원 수 조회 - 년도는 2020의 형태로 표현

--입사년도     사원수
--2001	        1
--2002	      	7
--2003	      	6
--2004	      	10
--2005	      	29
--2006	      	24
--2007	      	19
--2008	      	11
SELECT TO_CHAR(hire_date, 'YYYY') 입사년도, count(*) 사원수
FROM employees
GROUP BY TO_CHAR(hire_date, 'YYYY')  --그냥 hire 하면 안돼.. 그럼 2002 2002 막 두번 나오고 중복이 안합쳐져
-- count(*);
ORDER BY 1;

--13. 각 부서별로 정보를 파악하고자 한다.
--각 부서별 부서코드, 부서원수, 부서급여평균, 부서최고급여, 부서최저급여 조회

SELECT department_id, COUNT(*) 부서원수,  ROUND(AVG(salary),2) 부서급여평균, 
       MAX(salary) 부서최고급여, MIN(salary) 부서최저급여
FROM employees
GROUP BY department_id
--HAVING department_id IS NOT NULL
order by 1;

--14. 각 업무별로 정보를 파악하고자 한다.
--각 업무별 업무코드, 업무하는사원수, 업무급여평균, 업무최고급여, 업무최저급여 조회
SELECT job_id, COUNT(*),  ROUND(AVG(salary),2) avg_sl, MAX(salary), MIN(salary)
FROM employees
GROUP BY job_id
order by 1;


--15. 각 부서별 부서내 업무별로 부서코드, 업무코드, 사원수, 급여평균 조회

SELECT department_id, job_id, COUNT(*) 사원수,  ROUND(AVG(salary),2) avg_sl --왜 job_id가 안들어가지....? 그룹바이에 같이 넣어주니까 해결됐다
FROM employees
GROUP BY department_id, job_id
HAVING department_id IS NOT NULL
order by 1;

-----------------------------------------------------------------------------------------------
--[연습문제 4-3]
--01. 사원테이블에서 똑같은 이름(first_name)이 둘 이상 있는 이름과 그 이름이 모두 몇 명인지를 
--조회하는 쿼리문을 작성한다. 
--이름별로 몇명인지를 구함
SELECT first_name, count(*) cnt
FROM employees
GROUP BY first_name
HAVING count(*) >=2
order by 1;

--02. 부서번호, 각 부서별 급여총액과 급여평균를 조회하는 쿼리문을 작성한다. 
--단, 부서 급여평균이 8000 이상인 부서만 조회되도록 한다.
SELECT department_id, SUM(salary) sum_sal, ROUND(avg(salary),2) avg_sal
FROM employees
GROUP BY department_id
Having  ROUND(avg(salary),2)>=8000
order by 1;
--03. 년도별로 입사한 사원수를 조회하는 쿼리문을 작성한다.
--단, 년도는 2014 의 형태로 표기되도록 한다.

SELECT TO_CHAR(hire_date, 'YYYY') 년도, count(*) 사원수
FROM employees
GROUP BY TO_CHAR(hire_date, 'YYYY')  --그냥 hire 하면 안돼.. 그럼 2002 2002 막 두번 나오고 중복이 안합쳐져
-- count(*);
ORDER BY 1;

-----------------------------------------------------------------------------------------------







