--▶LIKE 조건 연산자(가장 많이 사용한다)-------------------------------------------------------------
컬럼값들 중에 특정 패턴에 속하는 값을 조회하고자 할 때 LIKE 연산자를 사용한다.
%는 여러 개의 문자열을 나타낸다.
_는 하나의 문자를 나타낸다. 

컬럼표현 LIKE 검색문자 + %
성명이 LIKE '홍%' ▶ 홍으로 시작하는 모든 것  
성명이 LIKE '%홍' ▶ 홍으로 끝나는 모든 것 
성명이 LIKE '%홍%' ▶ 홍을 포함하는 모든 것 --대부분 이걸 많이 써

[예제 2-28] 이름이 K로 시작되는 사원들의 사번, 성명, 급여, 전화번호 정보를 조회한다.
SELECT  employee_id, first_name || ' ' || last_name name, salary, phone_number phone
FROM   employees
WHERE first_name LIKE 'K%';

[ㅇㅖ제 2-29] 소문자 s로 끝나는
SELECT  employee_id,  first_name || ' ' || last_name name, salary, phone_number phone
FROM  employees
WHERE last_name LIKE '%s';

[예제 2-30] 이름에 b가 들어가 있는 사원 조회
SELECT   employee_id,  first_name || ' ' || last_name name, salary, phone_number phone
FROM   employees
WHERE  first_name LiKE '%b%';

[2-31]이메일의 세 번째 문자가 B인 사원의 사번, 성명, 급여
--세 번째 문자가 B ▶ [__B%] ▶세번째 문자가 B인 , B앞에 2글자가 있는!

SELECT   employee_id,  first_name || ' ' || last_name name, salary, email
FROM  employees
WHERE email LIKE '__B%'; --시작하는 (LIKE) 


[2-32] 전화번호가 6으로 시작하지 않는 사원의 
SELECT    employee_id,  first_name || ' ' || last_name name, salary, email
FROM  employees
WHERE  phone_number NOT LIKE '6%';
--WHERE  NOT phone_number LIKE '6%';

[2-34] job_id에 _A가 들어간 사원정보를 조회한다
SELECT employee_id, first_name || ' ' || last_name name, job_id
FROM  employees
WHERE job_id LIKE '%_A%';  -- 두번째 글자가 A인, A앞에 1글자가 있는, '_' 언더바는 한 글자! 그래서 _A가 없는것도 다 인식이 되버려서 >한 글자로 인식을 안시켜야해
--조회된 데이터행의 결과는 _A가 포함된 것이 아니라 A앞에 한 글자가 들어간 결과이다
--이스케이프로 '\_' 앞에 \식별자로 _자체를 문자로 인식하게 만들어 준다.

--위에 해결방법!
--■LIKE 연산자와 함께 사용된 %, _,를 문자 자체로 인식시키려면 ■
--■ %,_, 앞에 기호문자(\)를 붙이고 옵션을 지정한다. = (ESCAPE) 문자를 달아놔라!


SELECT    employee_id,  first_name || ' ' || last_name name, salary, email
FROM  employees
WHERE  job_id LIKE '%\_A%' ESCAPE '\';



--------------------------------------------------------------------------------
▶ NULL 조건 처리
○ NULL  ▶ 데이터값이 없는 형태의 표현, 비교도 불가하고 연산도 불가하다
--                                     ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
** 컬럼표현 IS NULL, ** 컬럼표현 IS NOT NULL,  -- 옳은 표현
** 컬럼표현 = NULL, ** 컬럼표현 != NULL,        -- 틀린 표현..!


SELECT  *
FROM locations;  --23개

SELECT  *
FROM locations
WHERE state_province IS NOT NULL;   --% : 모든 것 , NULL제외


SELECT  location_id, street_address, city, state_province
FROM locations; 

01.부서배치 받지 않은 (department_id IS NULL) 사원들의 사번, 성, 부서모드, 업무코드, 급여조회
SELECT  employee_id, last_name, department_id, job_id, salary
FROM  employees
WHERE department_id IS NULL; --부서배치 받지 않은!

02.커미션을 받은 사원들의 사번, 성, 부서코드, 커미션요율 조회
SELECT  employee_id, last_name, department_id, job_id, salary
FROM   employees
WHERE  commission_pct IS NOT NULL;


--------------------------------------------------------------------------------

2.4데이터 정렬

데이터의 결과를 일정한 순서로 정렬하고자 할 때 ORDER BY 절을 사용한다.
오름차순 정렬은 ASC를 사용하고 내림차순 정렬은 DESC를 사용하며 ASC가 기본값이다.
ORDER BY 절은 SELECT 문의 가장 마지막에 위치한다.

[2-40] 80번 부서 사원의 사번, 이름, 성, 급여, 부서코드 정보에 대해 이름을 오름차순으로 정렬해봐
SELECT employee_id 사번, last_name 성, first_name 이름,  salary 급여, department_id 부서
FROM   employees
WHERE department_id = 80 
--GROUP   
--HAVING
--ORDER BY first_name ASC; --ORDER BY + 컬러표현(컬럼명) --ORDER BY 는 항상 마지막에 쓴다 
--ORDER BY 3 ASC;          --ORDER BY + 컬러위치(순서번호)
ORDER BY 이름 ASC;         --ORDER BY + ALIAS명


--------------------------------------------------------------------------------
 절      항목                                  ALIAS
--------------------------------------------------------------------------------
SELECT  필드명                                   O
FROM    테이블명                                 O
WHERE   조건절 (일반조건만)                      X
GROUP BY  그룹지을필명                           X
HAVING  조건절 (일반조건, 그룹함수조건도 되고)   X
ORDER BY  정렬필드명                             O
--------------------------------------------------------------------------------


[2-41] 내림차순으로 정리
SELECT employee_id 사번, last_name 성, first_name 이름,  salary 급여, department_id 부서
FROM   employees
WHERE department_id = 80 
--GROUP   
--HAVING
--ORDER BY first_name ASC; --ORDER BY + 컬러표현(컬럼명) --ORDER BY 는 항상 마지막에 쓴다 
--ORDER BY 3 ASC;          --ORDER BY + 컬러위치(순서번호)
ORDER BY 이름 DESC;  

[2-42] 60번 부서 사원의 사번, 성, 급여, 연봉을 연봉으로 오름차순으로 정렬한다.
SELECT  employee_id, last_name, salary, salary * 12 연봉
FROM   employees
WHERE department_id = 60
ORDER BY  연봉
--ORDER BY  4
--ORDER BY  salary * 12;

[2-43] 사원테이블에 사번
SELECT  employee_id, last_name, department_id, salary, salary * 12 연봉
FROM   employees
ORDER BY  department_id ASC, salary DESC; --부서명은 오름차순이 되고, 연봉은 그 해당 부서 만큼만! 내림차순으로 정렬된다!