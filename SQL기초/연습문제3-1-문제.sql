-----------------------------------------------------------------------------------------------
--[연습문제 3-1]
--01. 사원 테이블에서 부서코드가 100, 110 인 부서에 속한 사원들의
--사번, 성명, 급여, 부서코드, 15%인상된 급여 조회 - 인상된 급여는 정수로 표현
--ROUND, TRUNC, CEIL, FLOOR 함수 모두 사용
--컬럼명은 Increased Salary 로 표시한다.
SELECT employee_id, first_name || ' ' || last_name name,  department_id,
      --급여 + 급여의 15프로! = 급여 + 급여 * 0.15 = 급여 1.15
      ROUND(salary*1.15,0)  "Increased Salary1",
      ROUND(salary*1.15)    "Increased Salary2",
      TRUNC(salary*1.15,0)  "Increased Salary3", 
      TRUNC(salary*1.15)    "Increased Salary4",
      CEIL(salary*1.15)     "Increased Salary5",
      FLOOR(salary*1.15)    "Increased Salary6"
FROM  employees
WHERE department_id  IN(100,110);







----------------------------------------------------------------------------------------------


