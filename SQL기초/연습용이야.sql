--SQL문 반드시 외우기
--
--SELECT  절
--FORM    절
--WHERE   절
--GROUP BY절
--HAVING  절
--ORDER BY절

CREATE TABLE tblmember0 (
  num   NUMBER  PRIMARY KEY, --unique, not null ☜ primary key
  name  VARCHAR2(10),
  age   NUMBER,
  addr  VARCHAR2(50),
  tel   VARCHAR2(20)
--  ,phone  VARCHAR2(10)
);

DESC        tblmember0;


INSERT  INTO tblmember0
VALUES  (1,'홍길동',30,'광주시 서구 농성동','010-1111-1111'); 

DROP  TABLE tblmember0;

COMMIT;

FLASHBACK TABLE tblmember0 TO BEFORE DROP;