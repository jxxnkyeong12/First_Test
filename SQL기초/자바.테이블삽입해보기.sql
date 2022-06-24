-- ①USER_INFO 테이블에 테이블을 삽입(INSER)해보기.
SELECT  * FROM notice_six;
SELECT  * FROM userinfo;


--②
INSERT INTO USER_INFO(STUDENT_NO, USER_ID)
VALUES(1, '1');
            
--1 행 이(가) 삽입되었습니다.
--③ INSERT문을 사용해서 데이터를 수정하게 되면(추가) 트랙잭션이 발생 한다. (작업 한 결과를 임시로 가지고 있음.)
--어떤한 오류가 발생하거나 데이터 추가를 잘못한경우 되돌리수 있음. COMMIT(확정), ROLLBACK(취소)
SELECT * FROM USER_INFO;
SELECT * FROM student;
--④■
--ROLLBACk; 

--⑤■ 커밋을 하게 되면 다시 롤백할수가 없다 (== 임시=>확정, 이제는 임시데티어가 아니라 확정된데이터이기 때문에 ROLLBACK 으로는 되돌릴 수 없음)
COMMIT;
DELETE user_info 
where student_no= 1; 
--AND user_id= 'USER_ID' 이렇게 하면 선생님것만 바껴!

DELETE user_info WHERE student_no =1 AND user_id = 'l';
DELETE user_info WHERE student_no =1 AND user_id = 'hot';

ROLLBACK;

DELETE from student WHERE  

-- 모든 컬럼에 데이터를 넣는 경우에(데이터의 갯수가 컬럼갯수랑같을때) (COL1) <-생략할수가 있다. 여기에 먼저 확인을 해보고 
INSERT INTO user_info values(STUDENT_NO, USER_ID, USER_PW, FIRST_NAME, LAST_NAME, CREATE_YMD, UPDATE_YMD);


--CRUD 중에 u UPDATE 
--UPDATE 쿼리를 이용해서 내가 등록한 USER_INFO를 수정해보기.

UPDATE user_info
SET user_pw ='lg20'
Where student_no =1;

commit;

INSERT INTO USER_INFO (STUDENT_NO, USER_ID, USER_PW,FIRST_NAME, LAST_NAME, CREATE_YMD, UPDATE_YMD, ADMIN_YN, MONEY )
VALUES(1, 'k', 'k', 'k', 'k', sysdate, sysdate, 'n', 0) ;

SELECT *
FROM  user_info
WHERE user_id = 'k'; 

--CRUD D(DELETE) 삭제
DELETE FROM user_info WHERE student_no = 1 AND user_id='King';


ROLLBACK;

--로그인 처리를 위한 커리를 작성하시오(USER_INFO 테이블 이용)
--예) 사용자가 girok 아이디 입력, 1212 비밀번호 입력 => 로그인 됨.
--그외에 아이디 girok 아이디 입력, 1111 비밀번호 입력 = > 로그인 실패.
SELECT * FROM user_info;



--비밀번호는 그대로 's', first_name ='a', last_name = 'b'

UPDATE user_info
SET  user_pw = 's', first_name ='a', last_name = 'b'
WHERE user_id = 's';