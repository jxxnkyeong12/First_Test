3장. 기본함수(단일결과행)------------------------------------------------------------------------------------------------
 : 숫자 함수, 문자함수, 날짜함수, 형변환 함수, 일반함수
  함수의 유형 : 단일(결과)행 함수, 다중(결과)행함수
  숫자함수    : ROUND, TRUNC,CEIL, FLOOR 
  문자함수    : UPPER, LOWER, TRIM, LTRIM/RTRIM, LPAD/RPAD
                SUBSTR, INSTR, REPLACE, TRANSLATE
  날짜함수    : SYSDATE, MONTHS_BETWEEN, ADD_MONTHS, LAST_DAY
  형변환함수  : TO_CHAR, TO_NUMBER, TO_DATE
  일반함수    : NVL, NVL2, COALESCE, DECODE, CASE~END
  
3.1 숫자 함수
▶ABS(n)
ABS 함수는 n의 절대값을 반환하는 함수이다.

[3-1]
SELECT ABS(32), ABS(-32)
FROM dual;

[3-2]
SELECT SIGN(32), SIGN(-32), SIGN(0)
FROM dual;

1) 반올림 함수 : ROUND (n [, i]), ROUND(숫자, 소수이하. 소수이상 자릿수)
                          --[]는 생략가능이여
소수이하/소수이상 자릿수 : 음수지정가능,생략시 default 0 -> 정수로 표현
소수이하 둘째자리까지 표현 : ROUND(123,56789, 2)0 ->1234.57 --두번째짜리까지만 보여주세요. 그리고 반올림 해주세요
소수이하/이상자리수     -3-2-1 0   1 2 3
                         1 2 3 4 . 5 6 7 8 9

SELECT ROUND(1234.56789, 2)    r1,  -- 1234.57
       ROUND(1234.56789, 1)    r2,  -- 1234.6
       ROUND(1234.56789, 0)    r3,  -- 1235
       ROUND(1234.56789)       r4,  -- 1235  : 정수로 표현, 일단위로 표현
       ROUND(1234.56789, -1)   r5,  -- 1230  : -1이면 0이 1개, 십단위로 표현
       ROUND(1234.56789, -2)   r6,  -- 1200  : -2이면 0이 2개, 백단위로 표현
       ROUND(1234.56789, -3)   r7   -- 1000  : -3이면 0이 3개, 천단위로 표현
FROM  dual;             


2) 무조건 버림함수 : TRUNC (n [, i], TRUNC(숫자, 소수이하. 소수이상 자릿수)
소수이하/소수이상 자릿수 : 음수지정가능,생략시 default 0 -> 정수로 표현
소수이하 둘째자리까지 표현 : TRUNC(1234.56789, 2)0 ->1234.56 --두번째짜리까지만 보여주세요. 그리고 반올림 해주세요
소수이하/이상자리수     -3-2-1 0   1 2 3
                         1 2 3 4 . 5 6 7 8 9

SELECT TRUNC(1234.56789, 2)    r1,  -- 1234.57
       TRUNC(1234.56789, 1)    r2,  -- 1234.6
       TRUNC(1234.56789, 0)    r3,  -- 1235
       TRUNC(1234.56789)       r4,  -- 1235  : 정수로 표현, 일단위로 표현
       TRUNC(1234.56789, -1)   r5,  -- 1230  : -1이면 0이 1개, 십단위로 표현
       TRUNC(1234.56789, -2)   r6,  -- 1200  : -2이면 0이 2개, 백단위로 표현
       TRUNC(1234.56789, -3)   r7   -- 1000  : -3이면 0이 3개, 천단위로 표현
FROM  dual; 

3)숫자보다 같거나 큰 정수를 반환하는 함수 : CEIL(n) - 무조건 올림 정수
게시판에서 페이지 나눌때(▶ 페이징처리) 페이지당 10개씩 출력시
0~1 사이에는 무수히 많은 실수
0.9999999999999999999999999999999 -- CEIL 로 표현하면 -> 1 
0.0000000000000000000000000000001 -- CEIL 로 표현하면 -> 1 
0 -- CEIL 로 표현하면 -> 0
12.1 -- CEIL 로 표현하면 -> 13

4)숫자보다 같거나 작은 정수를 반환하는 함수 : FLO(n) - 무조건 내림 정수
게시판에서 페이지 나눌때(▶ 페이징처리) 페이지당 10개씩 출력시
0~1 사이에는 무수히 많은 실수
FLOOR(0.9999999999999999999999999999999)   ->0
FLOOR(0.0000000000000000000000000000001)   ->0
FLOOR(0)   ->0
FLOOR(12.1)   ->0

숫자 데이터를 표현할 수 있는 함수 : ROUND, TRUNC, CEIL, FLOOR
소수점 데이터를 표현할 수 있는 함수 : ROUND, TRUNC
정수 데이터를 표현할 수 있는 함수 : CEIL, FLOOR, ROUND.TRUNC(2번째 파라미터가 0일때)

5) 나머지를 반환하는 함수 : MOD(m,n) MOD(숫자, 나눌숫자)
SELECT MOD(17,4)     m1,   --> 1
       MOD(17,-4)    m2,   --> 1
       MOD(-17,4)    m3,   --> -1
       MOD(17,4)     m4,   --> 1
       MOD(17,0)     m5   --> 17
FROM  dual;

                값           갯수   몫        나머지
 17   /   4 :   17     =      4     4           1
 17   /  -4 :   17     =     -4    -4           1
-17   /   4 :  -17     =      4    -4          -1
-17   /  -4 :  -17     =     -4     4          -1
 17   /   0 :   17     =      0     54645645    17
 
 
------------------------------------------------------------------------------------------------ 
 3.2 문자함수
 1. 대/소문자 변환함수 : UPPER/LOWER(문자)
 
 
 01. 문자/날짜 데이터 표현 : '' (홑따옴표)로 묶음
 성이 King  인 사원들의 사번, 성, 명 조회
 SELECT employee_id, last_name, first_name
 FROM employees
-- WHERE last_name = 'King';
 --WHERE LOWER(last_name) = 'king'; --앞에 lower안쓰고 소문자로 쓰면 안나와버려
 WHERE UPPER(last_name) = 'KING'; --소문자로 쓰면 안나와버려
 
 02. 성이 대소문자 무관하게 z가 포함되어 있는 사원들의 
 사번, 성, 명 조회
 SELECT employee_id, last_name, first_name
 FROM employees
-- WHERE LOWER(last_name) LIKE '%z%'
 WHERE UPPER(last_name) LIKE '%Z%';
 
------------------------------------------------------------------------------------------------
 2.파라미터로 받은 문자열에서 알파벳 단어 단위로 
첫글자를 대문자화, 나머지는 소문자화 하여 결과를 반환하는 함수 : INITCAP
SELECT  INITCAP('i am a boy')   CAP1,
        UPPER('i am a boy')   CAP2,
        LOWER('I AM A BOY')   CAP3
FROM dual;

SELECT  email, INITCAP(email) initcap,
        first_name, UPPER(first_name) upper, LOWER(first_name) lower
FROM employees;

------------------------------------------------------------------------------------------------
3.▶ LPAD(char1, n [, char2]), RPAD(char1, n [, char2])
   : 대상문자열에 채울문자를 채워서 반환하는 함수
  ▶ LPAD(대상, 전체크기[, 채울문자]), RPAD(대상, 전체크기 [, 채울문자]) --[]는 생략가능. ok?
   : 채울문자 생략시 기본값은 공백문자!
SELECT  LPAD('abc', 5, '?')     l1, -- 왼쪽을 물음표로 줬어       ->  ??abc
        LPAD('abc', 5)          l2, -- 기본값이 공백으로 들어갔어 ->    abc
        RPAD('abc', 5, '#')     r1,  -- 오른쪽에 #을 줬어         ->  abc##
        RPAD('abc', 5)          r2  -- 기본값이 공백으로 들어갔어 ->  abc  
FROM  dual;
   
------------------------------------------------------------------------------------------------
4. 문자 데이터에서 특정문자를 제거하고 반환하는 함수
: 제거할 문자는 한개만 지정가능하다. 생략시 공백!
: 파라미터 사이에 컴마 없음
: 제거할 위치 생략시 양쪽
▶ TRIM([LEADING, TRAILING, BOTH] [trim_char] [FROM] char)
▶ TRIM([제거할위치] [제거할문자] [FORM] 대상문자)
▶ TRIM([왼쪽, 오른쪽, 양쪽] [제거할문자한개] [FROM] 대상문자)

SELECT TRIM('a' FROM 'abcdcbaaaa')           t1, -- bcdcb
       TRIM(lEADING 'a' FROM 'abcdcbaaaa')   t2, -- bcdcbaaaa
       TRIM(TRAILING 'a' FROM 'abcdcbaaaa')  t3, -- abcdcb
       TRIM(BOTH 'a' FROM 'abcdcbaaaa')      t4, -- bcdcb
       '   abcdcbaaaa   '                    t5, --   abcdcbaaaa   내가 스페이스 남긴 만큼 공백 있어! 
       TRIM('   abcdcbaaaa   ')              t6  --abcdcbaaaa 양쪽 공백제거 됨
FROM dual;


------------------------------------------------------------------------------------------------
5. 문자데이터에 특정문자를 제거하고 반환하는 함수
  : 제거할 문자를 여러개 지정 가능  ☜ trim함수와의 차이점
--  ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
▶ LTRIM(char1 [,char2]), RTRIM(char1 [, char2])
▶ LTRIM(대상문자열 [,제거할문자'나열']), RTRIM(대상문자열 [, 제거할문자나열])
  : 제거할문자열 생략시 공백문자
SELECT  LTRIM('abcdcba','a')     t1,    --bcdcba
        LTRIM('abcdcba', 'ab')   t2,    --cdcba
        LTRIM('abcdcba', 'ba')   t3,     --cdcba  뒤바껴 있어요 어? ba중에 a있네? 싹둑- 어? ba중에 b있네? 싹둑- 요런...
        RTRIM('abcdcba', 'acb')   t4,     --abcd 오늘쪽에서부터 시작해
        RTRIM('abcdcba', 'abd')   t5,     --abcdc
        RTRIM('abcdcba', 'bc')    t6,       --abcdcba 오늘쪽에서부터 시작했을때 어?  bc 없네? 바로 출력-
        RTRIM('    abcdcba    ')   t7    --____abcdcba 앞에만 공백 그대로
FROM    dual;


------------------------------------------------------------------------------------------------

6. 문자열에서 문자열의 일부를 반환(몇번째부터 몇글자)하는 함수
  ▶SUBSTR(char, position, [, length])
  ▶SUBSTR(대상문자열, 시작위치, [, 몇글자])
  position : 음수지정가능 ☜ 오른쪽부터!
  length : 몇글자, 생략시, 문자열의 끝까지 반환
              1    5   9   13
SELECT SUBSTR('You are not alone',5,3) STR1, --are
       SUBSTR('You are not alone',5)   STR2,  --are not alone
       SUBSTR('You are not alone',0,5) STR3,  --You a 0번째는 문자열에서 없으니까 1로 가!
       SUBSTR('You are not alone',-5,3)STR4,  --alo
       SUBSTR('You are not alone',-5)  STR5  --alone
FROM dual;

------------------------------------------------------------------------------------------------

7.문자열에서 특정 문자열이 위치한 시작위치를 반환하는 함수
  ▶INSTR(char, search_string [, position] [,_th])  --문자열 안에있는것의 위치
  ▶INSTR(대상문자열, 찾을문자열 [, 문자열찾는시작위치] [,_몇번째거])
  문자열 찾는 시작 위치 : 음수지정가능, 
      음수지정시 오른쪽방향부터 - 왼쪽방향으로 쭉쭉쭉 계속 진행  
  몇번째거 : 생략가능, 기본값 : 1
              1     7   11 14 17 20
SELECT INSTR('Every Sha-la-la-la-la','la')        i1, --11번쨰 글자가 나와
       INSTR('Every Sha-la-la-la-la','la', 1,2)   i2, --14
       INSTR('Every Sha-la-la-la-la','la', 12,2)  i3, --17
       INSTR('Every Sha-la-la-la-la','la', 12,4)  i4, --0
       INSTR('Every Sha-la-la-la-la','la', 12)    i5, -- 14 생략시 기본값이 1! 첫번쨀 찾아라!
       INSTR('Every Sha-la-la-la-la','la', -3,2)  i6,  --14
       INSTR('Every Sha-la-la-la-la','la', -10)   i7  --11
FROM  dual;


jobs 테이블에서 업무코드, 업무제목, 직무, 직책 조회
직무와 직책은 업무코드에서 _ 를 기준으로 조회(직무_직책)

SELECT job_id , job_title, 
FROM   jobs;
--① _ 위치를 먼저 찾기
SELECT INSTR(job_id, '_') --3 첫번째부터 첫번째!
FROM    jobs;
--② 직무 _ 이전까지, 직책 _ 이후부터 끝까지
SELECT job_id,
       SUBSTR(job_id, 1, INSTR(job_id, '_')-1) 직무, //왼쪽이니까
       SUBSTR(job_id, 1, INSTR(job_id, '_')+1) 직책,
       job_title
FROM    jobs;
--------------------------------------------------------------------------------
job_id, 직무,  직책,   job_title
AD_PRES  AD    PRES    President
--------------------------------------------------------------------------------


--------------------------------------------------------------------------------
자기 이메일에서 id와 서비스제공자를 조회
hongildong@hanmail.net

나의 이메일                 id             서비스제공자
hongildong@hanmil.net     hongildong      hanmila.net
--------------------------------------------------------------------------------
--① '@'위치 찾기
SELECT INSTR('hongildong@hanmil.net', '@')
FROM  dual;

SELECT 'hongildong@hanmil.net'나의 이메일
       SUBSTR('hongildong@hanmail.net', 1, INSTR('hongildong@hanmail.net', '@')-1) id,
       SUBSTR('hongildong@hanmail.net', 1, INSTR('hongildong@hanmail.net', '@')+1) 서비스제공자
FROM dual;