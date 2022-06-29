--내장함수(COUNT, SUM, AVG, MAX, MIN)

DESC tblmember;  --not null 이기 때문에 반드시 값이 있어야 한다는 소리

ALIAS --가명, 애칭, 약어
SELECT COUNT(num)  인원수  --공백있으면 ""으로 주면돼! num 필드의 갯수
FROM  tblmember;

SELECT COUNT(*)  cnt--4 나와 위에 num도 쓰지만 대부분 cnt *를 많이쓰니까 이걸 많이 사용하도록해 
FROM  tblmember;


SELECT SUM(age) sum_age --159 나와! age의 합계
FROM  tblmember;

SELECT AVG(age) age_age --age의 평균 39.75 나와
FROM  tblmember;


SELECT MAX(age) max_age --age의 최대값 55 나와
FROM  tblmember;

SELECT MIN(age) min_age --age의 최소값 27 나와
FROM  tblmember;

--내년나이
SELECT  age "올해나이", age+1 "내년나이"
FROM    tblmember;

--서구에 사는 사람들의 나이 합계
SELECT  SUM(age) "나이합계"
FROM    tblmember
WHERE   addr LIKE '%서구%';   --57이 나와

--기타 연산
--num 이 1 이거나 3인 것의 레코드 검색

SELECT  *                 --3. 마지막 기입!
FROM    tblmember         --순서 1.
WHERE num = 1 OR num =3;  -- 2. 


SELECT  *                 --3.
FROM    tblmember         --순서 1.
WHERE num IN(1,3);        -- 2. 

--오늘날짜 출력: 날짜 서식은 '/'로만 출력 기본값이 문자야 
SELECT  SYSDATE  --22/06/15
FROM  dual;      --가짜테이블 

--날짜를 원하는 형태로 출력
SELECT  TO_CHAR(SYSDATE,'YYYY-MM-DD')  today --2022-06-15 문자야!
FROM    dual;

COMMIT;


--tblpanme 테이블 생성
CREATE TABLE tblpanme(
  code VARCHAR2(10)  PRIMARY KEY,
  part VARCHAR2(20),
  price NUMBER

);

DROP  TABLE tblpname; -- 삭제하지 말고 필드의 이름을 변경해야지!!!! 200명 데이터가 있으면 어케 ㅠ 다 날릴꺼야 ㅠ? 
--'ALTER TABLE' tblpan 'TO' tblpname; 이게 변경!


---앞에꺼 참고-tblmember 테이블에 phone 필드 이름을 mobilephone으로 변경
--ALTER   TABLE   tblmember
--RENAME  COLUMN  phone TO mobilephone; 




--레코드 입력
INSERT INTO tblpanme(code, part, price) VALUES('001','A영업부',3000);
INSERT INTO tblpanme VALUES('002','B영업부',6000);
INSERT INTO tblpanme VALUES('003','A영업부',2000);
INSERT INTO tblpanme VALUES('004','B영업부',5000);
INSERT INTO tblpanme VALUES('005','C영업부',1000);
INSERT INTO tblpanme VALUES('006','D영업부',4000);

--전체 레코드 검색
SELECT  *
FROM  tblpanme;

--작업확정
COMMIT;

--각부서'별'로 판매금액의 총합을 구하여 출력
SELECT  part, SUM(price) sum_price
FROM  tblpanme
GROUP BY part;   --group by 에는 select 절에서 그룹함수를 사용하지 않은 필드명을 지정해줘야 함


--각부서'별'(GROUP BY)로 판매금액의 총합(SUM_price)을 구하여 총합의 오름차순(ORDER(-순서가 있는) BY)으로 출력
SELECT   part, SUM(price)
FROM    tblpanme
--WHERE   조건절
GROUP BY  part
--HAVING  조건절
ORDER BY  sum(price) ASC; --정렬필드 ASC: 오름차순, 생략시 기본값, DESC : 내림차순!


--각부서'별'(GROUP BY)로 판매금액의 총합(SUM_price)을 구하여 총합의 내림차순(ORDER(-순서가 있는) BY)으로 출력
SELECT   part, SUM(price)
FROM    tblpanme
--WHERE   조건절
GROUP BY  part
--HAVING  조건절
ORDER BY  sum(price) DESC; --정렬필드 ASC: 오름차순, 생략시 기본값, DESC : 내림차순!

--부서명 출력 (중복된걸 제거하려면?!)
SELECT DISTINCT part 부서 --DISTINCT:중복제거
FROM tblpanme;

--부서의 갯수 출력
SELECT COUNT(DISTINCT part) cnt -- cnt 는 필드명이야
FROM tblpanme;


--각 부서'별'로 판매금액의 총합을 구하여 부서의 오름차순으로 정렬하여 출력
--단, 부서가 2개 이상 있는 부서만 대상으로 하세요.
--A영업부, B영업부의 결과를 출력 
--SELECT 필드
--FROM  테이블
--WHERE   조건
--GROUP BY 그룹지울 필드
--HAVING  조건
--ORDER BY  정렬순서;


SELECT part, SUM(price) sum_price
FROM  tblpanme
--WHERE   COUNT(part) >=2  --부서가 2개 이상, WHERE 절에서는 그룹함수 사용 불가
GROUP BY part
HAVING   COUNT(part) >=2 -- HAVING 절에서 그룹함수 사용가능, 일반 조건도 가능,
                          --HAVING 사용하려면 반드시 GROUP BY 절이 먼저 지정되어야 함
ORDER BY  part ASC;

그룹 함수를 사용하지 말아야 할 곳에서 제거해야 합니다.
 1. where절에서는 그룹함수 안됨 (HAVING절 사용해야 함)
 2. 오라클 프로시저에서 SELECT에 MIN, MAX같은 GROUP함수를 2개이상 사용시 발생함.


