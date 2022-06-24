3.5 NULL 관련 함수

일반함수 : NULL 이 계산되었을경우 결과 값이 NULL로 변경되어 버림

1.NVL (대상, NULL일때 반환 표현)
--￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣

2. NVL2 (대상, NUll이 아닐때 반환표현 NULL일때 반환표현)
--             ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣

[3-31]
커미션 금액이 1000미마인 사원의 
사번, 이름, 급여, 커미션율, 커미션금액을 조회한다. NVL2 써보기
커미션 금액 = 급여 * 커미션 요율
SELECT employee_id, first_name, salary, commission_pct, 
       salary * commission_pct 커미션금액  --6
FROM   employees
--WHERE salary * commission_pct  < 1000;  --xxx
WHERE salary * NVL(commission_pct,0)  < 1000;  --xxx null이면 0을 뱉어내라

조회된 NULL  값을 치환하는 함수 : NVL, NVL2 (NULL Value)
NVL(컬럼,0) ▶ 값이 NULL이 아니면 (값이 있으면) 컬럼값으로 처리, NULL 이면 0으로 처리
--  ￣￣￣
NVL2(컬럼, 대상이NULL이 아닐때 반환표현, 대상이 NULL일때 반환표현)
--          ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
NVL2(컬럼, 컬럼, 대상이 NULL일때 반환표현)

[3-31]
커미션 금액이 1000미마인 사원의 
사번, 이름, 급여, 커미션율, 커미션금액을 조회한다. NVL2 써보기
커미션 금액 = 급여 * 커미션 요율
SELECT employee_id, first_name, salary, 
       NVL2(commission_pct, commission_pct,0),
       salary * commission_pct 커미션금액  --6개밖에 안나와 틀린거야
FROM   employees
WHERE  salary * NVL2(commission_pct, commission_pct,0) < 1000;  --78개

[문제]
사번, 성, 급여, 커미션요율, 커미션금액, 총급여 조회
총급여 = 급여 + 상여금 (커미션금액이란 소리야)
샹여금 = 급여 * 상여율

1. NVL
SELECT  employee_id 사번, last_name 성, salary 급여, 
        NVL(commission_pct,0) 커미션요율, 
        salary * NVL(commission_pct,0) 커미션금액, 
        salary + salary * NVL(commission_pct,0) 총급여
FROM    employees;

1. NVL2
SELECT  employee_id 사번, last_name 성, salary 급여, 
        NVL2(commission_pct, commission_pct,0) 커미션요율, 
        salary * NVL2(commission_pct, commission_pct,0) 커미션금액, 
        salary + salary * NVL2(commission_pct, commission_pct, 0) 총급여
FROM    employees;



----------------------------------------------------------------------------------------------



3. COALESCE(exp1, exp2, exp3, ...) 합칠란다. 
COALESCE 함수는 파라미터 목록에서 첫 번째로 NULL 이 아닌 파라미터를 반환
  COALESCE : 합치다, 유착하다, 합체하다.
--------------------------------------------------------------------------------
name      cellular      home            office
--------------------------------------------------------------------------------
홍길동   010-1111-1111                  062-555-5555 
심청                    062-222-2222    062-333-3333
전우치                  062-444-4444 
홍길순   
--------------------------------------------------------------------------------
SELECT  name 이름, coalesce(cellular, home, office) 연락처
FROM    테이블명

--------------------------------------------------------------------------------
이름        연락처
--------------------------------------------------------------------------------
홍길동      010-1111-1111
심청        062-222-2222
전우치      062-444-4444
홍길순      null
--------------------------------------------------------------------------------





