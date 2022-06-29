-----------------------------------------------------------------------------------------------
--[연습문제 3-4]
--사번, 성, 부서코드, 업무코드, 입사일자, 매니저코드, 매니저존재여부(NVL, NVL2 각각 사용) 조회
--매니저존재여부는 각 사원에 대해 
--
--NVL은 
--    관리자가 있으면 manager_id와 관리자가 없으면 '없음'으로 표시,
--NVL2는
--사원의 관리자(매니저)가 있으면 '있음' 으로 --manager_id, 'O','Manager'   
--       관리자(매니저)가 없으면 '없음' 으로 --'없음',     'X','No Manager' 등으로 조회되게 한다.
--       

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
사번 성      부서코드 업무코드  입사일자 manager_id 없으면0(NVL) 없으면없음(NVL) 매니저있음없음(NVL2) manager_id 없음(NVL2) 있으면O없으면X(NVL2) Manager No Manager(NVL2)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
100  King          90 AD_PRES    03/06/17      NULL           0  없음            없음                 없음                  X                    No Manager
101  Kochhar       90 AD_VP      05/09/21      100          100  100             있음                 100                   O                    Manager   
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT  *
FROM employees;

1.NVL
SELECT  employee_id 사번, last_name, department_id, job_id, hire_date,
 --       COALESCE (manager_id, ), 
        NVL(TO_CHAR(manager_id),'0') "없으면0NVL" ,
        NVL(TO_CHAR(manager_id), '없음') "없으면없음(NVL)"
FROM    employees;

2.NVL2
SELECT  employee_id, last_name, department_id, job_id, hire_date, manager_id,
        NVL2(TO_CHAR(manager_id),'있음','없음') "매니저있음없음(NVL2)",
        NVL2(TO_CHAR(manager_id),TO_CHAR(manager_id),'없음') "manager_id 없음(NVL2)",
        NVL2(TO_CHAR(manager_id),'O','X') "있으면O없으면X(NVL2)",
        NVL2(TO_CHAR(manager_id),'Manager','No Manager') "Manager No Manager(NVL2)"
FROM    employees;
-----------------------------------------------------------------------------------------------
--DESC employees;  manager_id ☜ number(6,0)
-----------------------------------------------------------------------------------------------

SELECT  employee_id, last_name, department_id, job_id, hire_date, manager_id,
        NVL2(TO_CHAR(manager_id),'있음','없음') "매니저있음없음(NVL2)",
        NVL2(TO_CHAR(manager_id),TO_CHAR(manager_id),'없음') "manager_id 없음(NVL2)",
        NVL2(TO_CHAR(manager_id),'O','X') "있으면O없으면X(NVL2)",
        NVL2(TO_CHAR(manager_id),'Manager','No Manager') "Manager No Manager(NVL2)"
FROM    employees
ORDER BY employee_id DESC;
