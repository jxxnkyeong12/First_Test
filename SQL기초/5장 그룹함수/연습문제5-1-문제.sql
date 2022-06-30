--[ 연습문제 5-1 ]                                                                             
--01. 이름에 소문자 v가 포함된 모든 사원의 사번, 이름, 부서명을 조회하는 쿼리문을 작성한다. --8
SELECT  e.employee_id, e.first_name, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
AND     e.first_name LIKE '%v%';

--02. 커미션을 받는 사원의 사번, 이름, 급여, 커미션 금액, 부서명을 조회하는 쿼리문을 작성한다.
--단, 커미션 금액은 월급여에 대한 커미션 금액을 나타낸다. --35
SELECT  e.employee_id, e.first_name, NVL(e.commission_pct,0) * e.salary comm, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
AND     e.commission_pct IS NOT NULL;


--03. 각 부서의 부서코드, 부서명, 위치코드, 도시명, 국가코드, 국가명을 조회하는 쿼리문을 작성한다. --27
SELECT  d.department_id, d.department_name, d.location_id, l.country_id, c.country_name
FROM    departments d, locations l, countries c
WHERE   d.location_id = l.location_id(+)
AND     l.country_id = c.country_id(+);

--04. 사원의 사번, 이름, 업무코드, 매니저의 사번, 매니저의 이름, 매니저의 업무코드를 조회하여 
--사원의 사번 순서로 정렬하는 쿼리문을 작성한다. --107
SELECT  e.employee_id, e.first_name, e.job_id, e.manager_id, m.first_name 매니저이름, m.job_id 매니저업무코드
FROM    employees e, employees m
WHERE   e.manager_id = m.employee_id(+);

--05. 모든 사원의 사번, 이름, 부서명, 도시, 주소 정보를 조회하여 사번 순으로 정렬하는 쿼리문을 작성한다. --107
SELECT  e.employee_id, e.first_name, d.department_name, l.city, l.street_address
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id(+)
AND     d.location_id = l.location_id(+)
ORDER BY 1;

-----------------------------------------------------------------------------------------------
--실습
--01. 모든 사원의 사번, 성명, 업무코드, 매니저사번, 매니저성명, 매니저의 업무코드 조회하여
--사번 순으로 정렬 --107, SELF JOIN
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name, e.job_id, NVL(TO_CHAR(e.manager_id),'매니저없음'), 
        m.first_name || ' ' || m.last_name 매니저성명, m.job_id 매니저업무코드
FROM    employees e, employees m
WHERE   e.manager_id = m.employee_id(+)
ORDER BY 1;


--02. 성이 King인 사원들의 사번, 성명, 부서코드, 부서명 조회 --2
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name, e.department_id, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
AND     LOWER(e.last_name) LIKE '%king%';

--03. 위치코드가 1400 인 도시에는 어느 부서가 있나 파악하고자 한다.
--위치코드가 1400 인 도시명, 부서명 조회 --1
SELECT  l.city, d.department_name
FROM    departments d, locations l
WHERE   d.location_id = l.location_id(+)
AND     d.location_id = 1400;

--04. 위치코드 1800 인 곳에 근무하는 사원들의 
--사번, 성명, 업무코드, 급여, 부서명, 위치코드 조회 --2
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name, e.job_id, d.department_name, d.location_id
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
AND     d.location_id = 1800;

--05. 자신의 매니저보다 먼저 입사한 사원들의  --내입사일자 < 매니저입사일자
--사번, 성명, 입사일자, 매니저성명, 매니저 입사일자 조회 --37, SELF JOIN
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name, e.hire_date,
        m.first_name || ' ' || m.last_name 매니저성명, m.hire_date 매니저입사일자
FROM    employees e, employees m
WHERE   e.manager_id = m.employee_id(+)
AND     e.hire_date < m.hire_date;

--06. toronto 에 근무하는 사원들의 
--사번, 성, 업무코드, 부서코드, 부서명, 도시 조회 --2
SELECT  e.employee_id, e.last_name, e.job_id, e.department_id, d.department_name, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id(+)
AND     d.location_id = l.location_id(+)
AND     LOWER(l.city) LIKE '%toronto%';

--07. 커미션을 받는 모든 사원들의 성, 부서명, 위치코드, 도시 조회 --35
SELECT  e.last_name, d.department_name, d.location_id, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id(+)
AND     d.location_id = l.location_id (+)
AND     e.commission_pct IS NOT NULL;

--08. 모든 사원의 사번, 이름, 매니저사번, 매니저이름 정보를 조회
--※ 매니저사번, 매니저이름이 NULL 로 조회됐을때 NULL 처리하기
-----------------------------------------------------------------------------------------------
--사번, 성,           매니저사번1, 매니저사번2, 매니저사번3,    매니저사번4,     매니저이름1, 매니저이름2,        매니저이름3   
--매니저사번이 없으면 (null)       0(NVL)       매니저없음(NVL) 매니저없음(NVL2)
--매니저이름이 없으면                                                            (null)       매니저이름없음(NVL) 매니저이름없음(NVL2)
-----------------------------------------------------------------------------------------------

1. NVL(대상표현, NULL 일때)
--     ￣￣￣￣￣￣￣￣￣￣ 데이터 형태가 일치

2. NVL(대상표현2, NULL이 아닐때, NULL 일때)
--                ￣￣￣￣￣￣￣￣￣￣￣￣ 데이터 형태가 일치

-----------------------------------------------------------------------------------------------
1. NVL
SELECT  e.employee_id, e.first_name, 
        e.manager_id                                "null처리1(NVL)",       
        NVL(e.manager_id,0)                         "0(NVL)",         
        NVL(TO_CHAR(e.manager_id),'매니저없음')     "매니저없음(NVL)",         
        NVL(TO_CHAR(e.manager_id),'매니저이름없음') "매니저이름없음(NVL)",         
        
        m.first_name                                "null처리2(NVL)",       
        NVL(m.first_name, '매니저없음')             "매니저없음(NVL)",
        NVL(m.first_name, '매니저이름없음')         "매니저이름없음(NVL)"
FROM    employees e, employees m
WHERE   e.manager_id = m.employee_id(+)
ORDER BY 1;


2. NVL2
SELECT  e.employee_id, e.first_name, 
        e.manager_id                                                    "null처리1(NVL2)",       
        NVL2(e.manager_id,e.manager_id, 0)                              "0(NVL2)",         
        NVL2(e.manager_id, TO_CHAR(e.manager_id),'매니저없음')          "매니저없음(NVL2)",         
        NVL2(e.manager_id, TO_CHAR(e.manager_id),'매니저이름없음')      "매니저이름없음(NVL2)",         
        
        m.first_name                                                    "null처리2(NVL2)",       
        NVL2(m.first_name, m.first_name, '매니저없음')                  "매니저없음(NVL2)",
        NVL2(m.first_name, m.first_name, '매니저이름없음')              "매니저이름없음(NVL2)"
FROM    employees e, employees m
WHERE   e.manager_id = m.employee_id(+)
ORDER BY 1;





