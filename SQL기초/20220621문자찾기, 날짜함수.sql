▶ 8. REPLACE(char, search_string I, replace_string)
문자열에서 특정문자열을 찾아 다른 문자열로 바꿔 반환하는 함수
--단어를 통째로 변환
  : REPLACE(대상문자열, 찾는문자열, 대체될문자열)
  : 대체될 문자열에서 생략시 기본값은 null이다.
  : [3-17]
  SELECT replace ('You are not alone', 'You', 'We') REP1,  --We are not alone 
         replace ('You are not alone', 'not') REP2, --You are  alone /not 자리에 공백이 위아래로 바뀌어!
         replace ('You are not alone', 'not', null) REP3  --You are  alone  /not을 null로 바꿔
  FROM dual;
  
 ------------------------------------------------------------------------------------------------------------ 
  ▶9.문자열에서 있는 특정 문자 전체를 다른 특정문자로 하나씩 1:1 대응해서 바꿔변환하는 함수
  --단어를 1:1로 변환
  [3-18] You -> We
         Y    ->W
         o   -> e
         u   -> null
  : TRANSLATE(대상문자열, 찾는문자열, 대체될문자열)
  SELECT translate ('You are not alone', 'You', 'We') REP1  --We are net alene 
  FROM dual;
  
  
 ▶ 10. ▎LENGTH(char)
LENGTH 함수는 문자열의 길이를 반환한다.

[예제 3-20] 
SELECT LENGTH( 'Every Sha-la-la-la' ) LEN1,  --18
       LENGTH( '무궁화 꽃이 피었습니다' ) LEN2 --12 공백도 문자라서 읽고 넘어가
FROM dual;

--------------------------------------------------------------------------------------------  

 ▶3.3 날짜함수 : 날짜와 더불어 시간을 연산 대상으로 한다.
  : 송금, 출결, 회원가입날짜, 결제시간
1. 시스템의 현재 날짜를 반환하는 함수 - SYSDATE
다른 함수와는 달리 파라미터가 없다.

SELECT SYSDATE
FROM dual;   --22/06/21

날짜 +/- 숫자 : 날짜
날짜 - 날짜 : 숫자

SELECT SYSDATE +1 tomorrow,--+1한 내일날짜가 나온다
       SYSDATE -1 yesterday-- -1한 어제날짜가 나온다.
FROM dual;

오늘날짜로부터 30일 이후의 날짜
SELECT SYSDATE +30  "30일후"-- AS(별명)숫자가 먼저 나올땐 "" 써줘야 한다
FROM dual;

밀리초까지 조회
SELECT SYSTIMESTAMP
FROM  dual;

2) ADD_MONTHS(date, n) : 특정날짜로 부터 몇개월 전/후의 날짜를 반환하는 함수
ADD_MONTS(날짜, +/-개월수)

오늘로부터 6개월 후와 3개월 전의 날짜 조회
SELECT ADD_MONTHS(SYSDATE, +6) "6개월후",
       ADD_MONTHS(SYSDATE, -3) "3개월전"
FROM dual;

3) MONTHS_BETWEEN(datel, date2) : 개월수의 차이를 조회하는 함수
 --: date1 > date2 이어야 함. --date1이 date2보다 커야 한다!
 
 휴가날짜(2022/08/01)와의 개월 수 차이 조회
SELECT MONTHS_BETWEEN(TO_DATE('2022/08/01'), SYSDATE) 휴가, --1.3388747013142174432497013142174432497
       TRUNC(MONTHS_BETWEEN(TO_DATE('2022/08/01'), SYSDATE),1) 휴가 --1.3
FROM dual;

[예제 ]여러분의 훈련기간 : 2022/04/25 ~ 2022/11/03
지난개월 수 
남은개월 수
SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, TO_DATE('2022/04/25')),1) 지난개월수,  --1.8
       TRUNC(MONTHS_BETWEEN(TO_DATE('2022/11/03'), SYSDATE),1) 남은개월수  --4.4
FROM dual;


-------------------------------------------------------------------------------------------------------

▶LAST_DAT(date)
 : 해당날짜가 포함된 달의 마지막 날짜를 반환다.
 날짜가 3월이면 31일을 반환하고 4월이면 30일을 반환다.
 SELECT LAST_DAY(SYSDATE) l1,
        LAST_DAY(ADD_MONTHS(SYSDATE, -3)) l2, --3개월전 ADD_MONTHS(SYSDATE, -3)
        LAST_DAY(ADD_MONTHS(SYSDATE, 6)) l3 --6개월후
 FROM dual;
 
 5. NEXT_DAY(date, char) : 해당날짜 이후의 날짜 중 char(요일)로 명시된[처음으로?!] 요일에 해당하는
 첫번째 날짜를 반환
 char에는 요일에 해당하는 문자 : 일요일, 월요일, 화요일, ,......와 약어인 일, 월, 화, ....를 사용할 수 있다.
 SELECT NEXT_DAY(SYSDATE, '일요일') n1,
        NEXT_DAY(SYSDATE, '일') n2,
        NEXT_DAY(SYSDATE, 1) n3      
 FROM dual;
 
 -----------------------------------------------------------------------------------------------
 
 ▶ 3.4 형변환함수
 문자화 함수 : TO_CHAR
 숫자화 함수 : TO_NUMBER
 날짜화 함수 : TO_DATE
      TO_CHAR      TO_DATE
         ->         ->    
 숫자         문자        날짜
 
         <-         <-
       TO_NUMBER    TO_CHAR
       
 1) 숫자화 함수 : TO_NUMER, 문자 ->숫자
 명시적 형변환
 SELECT '12345'       n1,   --문자라서 왼쪽정렬!
        TO_NUMBER('12345')  n2,  --숫자라서 오른쪽정렬이야!
        12345             n3  --숫자
 FROM dual;
 
 2) 문자화 함수 : TO_CHAR(숫자 날짜) 
 1- 숫자 -> 문자 : TO_CHAR(대상[, 포맷형식]) ☜ 포맷생략시 단순히 문자로만 변환
  9 : 한자리 숫자, 무효숫자 ('0000'1 앞에 0들 말하는거야)는 공백으로 채워짐, 자릿수가 부족하면 #으로 표시
  0 : 한자리 숫자, 무효숫자는 0으로 채워짐!, 자릿수가 부족하면 #으로 표시
  , : 천단위 표시
  L : 통화기호
  
SELECT 123456               c1,  --위에는 숫자 라서 오른쪽 정렬
       TO_CHAR(123456)      c2,   --아래는 문자! 라서 왼쪽정렬
       TO_CHAR(123456, '999999' )      c3,   --9999는 의미없는 공백
       TO_CHAR(123456, '9999' )      c4,   --이렇게 하면 공간이 부족해서 #이 떠
       TO_CHAR(123456, '999,999' )      c5,  --공백이 생겨!
       TO_CHAR(123456, '999,999,999' )      c6,  --공백이 생겨!
       TO_CHAR(123456, 'L999,999,999' )      c7,  --            ￦123,456
       TO_CHAR(123456, '$999,999,999' )      c8,  --
       TRIM(TO_CHAR(123456, '$999,999,999'))      c9,  --trim함수는 공백제거!
       TO_CHAR(123456, 'FML999,999,999' )      c10   --￦123,456 FML이라는 함수(옵션 공백제거)를 쓰면 예쁘게 나와
       
FROM  dual;

 
SELECT 123456               c1,  --위에는 숫자 라서 오른쪽 정렬
       TO_CHAR(123456)      c2,   --아래는 문자! 라서 왼쪽정렬
       TO_CHAR(123456, '00000000' )      c3,   --9999는 의미없는 공백
       TO_CHAR(123456, '0000' )      c4,   --이렇게 하면 공간이 부족해서 #이 떠
       TO_CHAR(123456, '000,000' )      c5,  --공백이 생겨!
       TO_CHAR(123456, '000,000,000' )      c6,  --공백이 생겨!
       TO_CHAR(123456, 'L000,000,000' )      c7,  --            ￦123,456
       TO_CHAR(123456, '$000,000,000' )      c8,  --
       TRIM(TO_CHAR(123456, '$000,000,000'))      c9,  --trim함수는 공백제거!
       TO_CHAR(123456, 'FML000,000,000' )      c10   --￦123,456 FML이라는 함수(옵션 공백제거)를 쓰면 예쁘게 나와
       
FROM  dual;


2) 날짜 - > 문자 : TO_CHAR(대상[, 표현방식]) 
표현형식
년 - YEAR :영문으로 표시, TWENTY TWENTY-TWO
     YYYY : 년도 4자리 -> 2000년 이후로 생김
     YY   : 년도 2자리 -> 2000년 이후로 생김
     RRRR : 년도 4자리 
     RR   : 년도 2자리
월 - MONTH : 월의 영문표기 모두 표시   --JAUNARY, 우리는 한글 윈도우를 쓰니까 변화가 없다
     MON   : 3글자로 된 월의 이름      -- JAN, 우리는 한글 윈도우를 쓰니까 변화가 없다
     MM    : 월 2자리  -- 01, 02 
일 - DD   : 일 2자리   -- 01, 02
요일 - DAY(한글, 월요일)
       DY(한글, 월, 화)  --약어가 나와
시   - HH : 12시각제
       H24 : 24시각제
분   - MI : 분 2자리
초   - SS : 초 2자리


SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD DAY DY HH24:MI:SS') c1,  --2022-06-21 화요일 화 12:50:00
       TO_CHAR(SYSDATE,'YEAR-MONTH-DAY') c2,   --TWENTY TWENTY-TWO-6월 -화요일
       TO_CHAR(SYSDATE,'YYYY-MM-DD') c3,   --2022-06-21
       TO_CHAR(SYSDATE,'YYYY-MM-DD DY') c4   --2022-06-21 화
FROM dual;


3- 날짜와 함수 : TO_DATE(대상[, 표현형식])
-- ▶ TO_DATE에 의해 변환된 날짜는 결과적으로 '/'로만 조회됨

SELECT '220621'   d1,  --220621
       TO_DATE('220621')  d2,  --22/06/21
       TO_DATE('220621','YY?MM?DD')   d3,    -->?거나 - 여도 결귝 /로만 조회된다!
       TO_DATE('220621','YY-MM-DD')   d4, 
       TO_DATE('20220621','YYYY-MM-DD')   d5,  --YYYY가 4자리니까 4자리에 맞춰서 앞에 2022해줘야해!
      TO_DATE('20220621','RRRR-MM-DD')   d7   --TO_DATE는 전부 /로 표기되지만 To_Char는 -도 돼고, 문자니까!!!!
FROM  dual;
         
--직접 입력된 날짜는 To_CHAR로 변환이 안됨
--SYSDATE, hire_date 등 날짜가 입력되어진 컬럼은 TO_CHAR 로 변환
         