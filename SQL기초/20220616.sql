--HR 유저에 관리되는 테이블 확인해보자
SELECT   table_name
FROM     user_tables;

--TABLE_NAME
--------------------------------------------------------------------------------
REGIONS       : 대륙정보
LOCATIONS     : 국가정보
DEPARTMENTS   :위치정보
JOBS          :부서정보
EMPLOYEES     :업무정보
JOB_HISTORY   :사원정보
COUNTRIES     :업무이력정보

2.1 데이터 조회
DESC   employees;

이름             널?       유형           필드명
-------------- -------- ------------ 
EMPLOYEE_ID    NOT NULL NUMBER(6)        사번
FIRST_NAME              VARCHAR2(20)     이름
LAST_NAME      NOT NULL VARCHAR2(25)     성
EMAIL          NOT NULL VARCHAR2(25)     email
PHONE_NUMBER            VARCHAR2(20)     전화번호
HIRE_DATE      NOT NULL DATE             입사일
JOB_ID         NOT NULL VARCHAR2(10)     업무 코드
SALARY                  NUMBER(8,2)      급여
COMMISSION_PCT          NUMBER(2,2)      상여율
MANAGER_ID              NUMBER(6)        관리자 코드, 매니저 아이디
DEPARTMENT_ID           NUMBER(4)        부서 코드




SELECT   *
FROM   employees;


SELECT   employee_id, first_name, last_name, salary
FROM   employees;

--------------------------------------------------------

SELECT    필드명
FROM      테이블명
WHERE     조건
GROUP BY  그룹으로 묶을 필드
HAVING    그룹조건
ORDER BY  정렬시킬필드




2.2 조건절
SELECT  : 반드시 FROM 키워드가 따라와야 한다
FROM    : 조회할 테이블명
WHERE   :원하는 레코드만 검색하고자 할때 사용

80번 부서 사원 정보 -> 부서가 80번
SELECT   *  --34
FROM   employees
WHERE  department_id =          80;   -- "="는 다른 프로그램에서는 대입연산자이지만, 오라클에서는 비교연산자임 
       컬럼       연산자     연산의 대상


2.3 연산자
[예제 2-4] 80번 부서 사원의 사번, 성, 급여, 한 해 동안 받은 급여를 조회
SELECT  employee_id, last_name, salary * 12 "annual salary"  --공백이 들어가면 "" ALIAS!
FROM    employees 
WHERE   department_id = 80;

SELECT  절에서 다음과 같을때 ALIAS(별칭, 애칭, 별명)을 습관적으로 지정하기
1. 컬럼의 표현(salary * 12)이 연산자이거나 함수가 사용된 경우
2. 컬럼의 표현이 지나치게 긴경우에는 ALIAS사용!

ALIAS 사용방법
1. AS 키워드 사용한다. ▶ 컬럼의 표현 AS ALIAS명 
2. 공백을 두고 사용 ▶ 컬럼의 표현 AS ALIAS명
3. ALIAS 명에 공백이 있으면 쌍따옴표를 사용하고, 공백이 없으면 쌍따옴표 생략가능!
4. ALIAS 명에 숫자와 문자가 섞여 숫자가 먼저 사용될 경우 쌍따옴표 사용



[예제 2-5] 한 해 동안 받은 급여가 120000인 사원의
사번, 이름, 성, 업무코드, 급여, 연봉 조회한다.
SELECT  employee_id, first_name, last_name, job_id, salary, salary * 12 연봉  --4명이 나와.
FROM    employees
WHERE   salary * 12 = 120000;
--WHERE 연봉 = 120000; -- WHERE 절에서는 ALIAS(연봉) 사용 불가 SELECT절에 써!

--------------------------------------------------------------------------------
▶문자열 연결 연산자 || -> SELECT 목록과 조건절에 사용, SELECT 절에 많이 사용

[예제 2-6] 사번이 101번인 사원의 사번, 성명을 조회한다.
SELECT  employee_id 사번, first_name ||' '|| last_name 성명  -- 이름과 성을 띄고 싶어- 그럼 공백으로 연결해주면 돼
FROM    employees
WHERE   employee_id =101;


[예제 2-8] 사번이 101번인 사원의 사번, 성, 한 해 동안 받은 급여를 조회한다.
SELECT  employee_id, first_name 성, salary*12 연봉
FROM    employees
WHERE   employee_id = 101;

--------------------------------------------------------------------------------
▶비교연산자: =, !=, >=, <=, <. >

[예제 2-9] 급여가 3000 이하인 사원의
 사번, 성, 급여, 부서코드, 업무코드 정보를 조회한다.
SELECT  employee_id, last_name, salary, department_id, job_id
FROM    employees
WHERE   salary <= 3000;

[예제 2-10] 부서코드가 80번 초과인 사원의
사번, 성, 급여, 부서코드, 업무코드 정보를 조회한다.
SELECT  employee_id, last_name, salary, department_id, job_id
FROM    employees
WHERE   department_id > 80;

--------------------------------------------------------------------------------
▶ 문자데이터와 날짜데이터는 작은 따옴표로 묶어서 표현해야 한다.
  문자데이터는 대소문자를 구분한다.
  
[예제 2-11] 성이 King 인 사원의 사번, 성, 부서정보를 조회한다.
SELECT  employee_id, last_name, department_id
FROM    employees
WHERE   last_name = 'King';

[예제 2-12] 입사일이 2004년 1월 1일 이전(2003년까지)인 사원의 사번, 성, 입사일 정보를 조회한다.
날짜, 문자는 홑따옴표 안에 작성해야 함
날짜는 '?'로 구분 -/로 구분해
SELECT  employee_id, last_name, hire_date
FROM    employees
--WHERE   hire_date < '2004-01-01';--2004년 1월 1일(2003년까지)
--WHERE   hire_date <= '2003-12-31';--2004년 1월 1일(2003년까지)
--WHERE   hire_date <= '2003/12/31';--2004년 1월 1일(2003년까지)
--WHERE   hire_date < '2004/01/01';--2004년 1월 1일(2003년까지)
--WHERE   hire_date < '04-01-01';--2004년 1월 1일(2003년까지) 년도 두자리도 인식해
--WHERE   hire_date <= '03-12-31';--2004년 1월 1일(2003년까지)
--WHERE   hire_date <= '03/12/31';--2004년 1월 1일(2003년까지)
--WHERE   hire_date < '04/01/01';--2004년 1월 1일(2003년까지)
--WHERE   TO_CHAR(hire_date,'YYYY') < '2004';--2004년 1월 1일(2003년까지)
WHERE   TO_CHAR(hire_date,'YYYY') <= '2003';--2004년 1월 1일(2003년까지)

--■직접 입력된 날짜는 TO_CHAR 로 변환이 안됨■
SELECT  TO_CHAR(SYSDATE, 'YYYY') this_year --2022 이건 되는데
FROM   dual;

SELECT  TO_CHAR('2022-06-17', 'YYYY') this_year --변환안됨!
FROM   dual;


--------------------------------------------------------------------------------
▶ AND, OR, NOT 논리조건 연산자

[예제 2-13] 30번 부서 사원 중 급여가 10000이하인 사원의 
사번, 성명, 급여, 부서정보를 조회한다.
단, 성명은 성과 이름을 합해서 사용한다.
SELECT  employee_id, first_name,  ||' '|| last_name name,  salary, department_id --ALIAS를 사용...?
FROM    employees
WHERE   department_id=30
AND     salary <=10000;

[예제 2-14] 30번 부서에서 급여가 10000 이하'이면서' 2005년 이전(2004년까지야)에 입사한 사원의 
사번, 성명, 급여, 부서코드, 입사일 정보를 조회한다.
SELECT employee_id, first_name || ' ' || last_name name, salary, 
        department_id, hire_date
FROM   employees
WHERE department_id= 30
AND  salary <=10000 
AND  hire_date <='2004/12/31';


--■ AND연산자는 조건이 모두 true일때 true값을 반환한다
[예제 2-15] 30번 부서나 60번 부서에 속한 사원의 사번, 성명, 급여, 부서정보를 조회한다
단 성명은 성과 이름을 합해서 사용하고, 부서는 dept_id로 변명한다.
SELECT  employee_id, first_name || ' ' || last_name name, salary, department_id dept_id
FROM   employees
WHERE   department_id= 30
OR      department_id= 60;

[예제 2-16] 30번 부서의 급여가 10000미만인 사원과 60번 부서의 급여가 5000이상인 사원의 
성명, 급여, 부서 정보를 조회한다.
단 성명은 성과 이름을 합해서 사용하고, 부서는 dept_id로 별명한다.
SELECT  first_name || ' ' || last_name name, salary, department_id dept_id
FROM    employees
WHERE   (department_id = 30 AND     salary < 10000)  --괄호로 묶어줌
OR      (department_id = 60 AND     salary >=5000);   --괄호로 묶어줌
--■AND와 OR 조건이 혼합되어 사용되는 경우 가독성을 위해 괄호를 붙여주는 것이 좋다.

--------------------------------------------------------------------------------
▶ 범위 조건 연산자 BETWEEN
BETWEEN 초기값 AND 마지막값 은 초기값 이상 마지막값 이하 와 같다.

[예제 2-18] 사번 110번 부터 120번 까지의 사원의 
사번, 성명, 급여, 부서 정보를 조회한다.
SELECT employee_id, first_name || ' ' || last_name name, salary, department_id dept_id
FROM   employees
--WHERE  employee_id >=110
--AND    employee_id <=120;
WHERE  employee_id BETWEEN 110 AND 120;

[예제 2-20] 사번이 110에서 120인 사원 중 급여가 5000에서 10000사이의 사원의 
사번, 성명, 급여, 부서 정보를 조회한다.
단 성명은 성과 이름을 합해서 name, 부서는 dept_id, 사번은 emp_id로 별명한다.
SELECT  employee_id emp_id, first_name || ' ' || last_name name,
        salary, department_id dept_id
FROM    employees
WHERE   employee_id BETWEEN 110 AND 120 
AND     salary BETWEEN 5000 AND 10000;



[예제 2-21] 사번이 110번 미만 120번 초과인 사원의 사번, 성명, 급여, 부서 정보를 조회한다.
단 성명은 성과 이름을 합해서 name, 부서는 dept_id,사번은 emp_id로 별명한다.

SELECT   employee_id emp_id, first_name || ' ' || last_name name,
        salary, department_id dept_id
FROM   employees
WHERE   employee_id <110
OR      employee_id >120;

[예제 2-22] NOT BETWEEN A TO B
SELECT   employee_id emp_id, first_name || ' ' || last_name name, salary, department_id dept_id
FROM   employees
--WHERE   employee_id NOT BETWEEN 110 AND 120;
WHERE   NOT employee_id BETWEEN 110 AND 120;   --둘다 같은거야
--BETWEEN 이나 관계연산자로 비교할 수 있는 값은 숫자데이터, 문자데이터, 날짜데이터 이다

--------------------------------------------------------------------------------
[예제 2-23] 2005년 1월 1일 이후부터 2007년 12월 31일 사이에 입사한 사원의 
사번, 성명, 급여, 입사일자 정보를 조회한다.
SELECT  employee_id emp_id, first_name || ' ' || last_name name, salary, hire_date
FROM    employees
--WHERE   hire_date >='2005/01/01'
--AND     hire_date >='2007/12/31';
--①WHERE    hire_date BETWEEN '2005/01/01' AND '2007/12/31';  ◀ 날짜를 홑따옴표 묶어서 사용, 결과는 홑따옴표 묶어서 사용,
                                                                  --결과는 홈따옴표에 묶여 있으므로 문자취급

-- ■DATE 타입의 HIRE_DATE의 값을 '01-01-05', '31-12-07' 와 같은 문자값으로
-- 비교했음에도 오류없이 결과가 나오는 이유는 오라클 SQL엔진이 자동으로 묵시적 형변환을 했기 때문이다.
-- 하지만 가급적 명시적으로 형변환하는 것이 바람직하다.
-- 명시적 형변환 함수는 TO_DATE() 이다
  --WHERE    hire_date BETWEEN TO_DATE('2005/01/01') AND TO_DATE('2007/12/31');
                              --TO_DATE()함수 : 날짜로 형변환
                              
--②WHERE   TO_CHAR(hire_date,'YYYY') BETWEEN 2005 AND 2007  -- TO_CHAR사용해서 검색해보기 : To_char은 무조건 문자로 바꿔 
--WHERE  TO_CHAR(hire_date,'YYYY') BETWEEN '2005' AND '2007' ;  -- 이러면 안된다?
--▶③직접 입력된 날짜는 TO_CHAR 로 변환이 안됨
--▶④데이터가 입력되어진 필드에 대해서는 TO_CHAR로 변환됨

--날짜와 문자는 홑따옴표로 묶음
--공백이 있는 ALIAS는 쌍따옴표로 묶음


[예제 2-25] 30번 부서원 또는 60번 부서원 또는 90번 부서원의 사원의
사번, 성명, 급여, 부서정보를 조회한다.
SELECT  employee_id emp_id, first_name || ' ' || last_name name, salary, hire_date--14
FROM   employees
WHERE  department_id = 30
OR    department_id = 60
OR    department_id = 90;

--▶ IN 조건 연산자--------------------------------------------------------------
여러 개의 값 중에 일치하는 값이 있는지 비교할 때는 IN(값1, 값2, 값3...)의 형태로 비교하는 값의 목록을 나열한다.
SELECT  employee_id emp_id, first_name || ' ' || last_name name, salary, hire_date
FROM   employees
WHERE  department_id IN(30, 60, 90);
WHERE  department_id NOT IN(30, 60, 90);
WHERE  NOT department_id IN(30, 60, 90);

--▶LIKE 조건 연산자-------------------------------------------------------------
컬럼값들 중에 특정 패턴에 속하는 값을 조회하고자 할 때 LIKE 연산자를 사용한다.
%는 여러 개의 문자열을 나타낸다.
_는 하나의 문자를 나타낸다.