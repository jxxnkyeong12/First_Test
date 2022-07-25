--공지글관리
create table notice (

id     NUMBER   CONSTRAINT notice_id_pk PRIMARY key /*PK*/, 
title  VARCHAR2(300) not null /*제목*/,
content VARCHAR2(4000) not null/*내용*/ ,
writer  varchar2(50)  /*작성자의 id가 담겨질 컬럼*/,
writerdate    date  default sysdate  /*작성일자*/,
readcnt   number   default 0  /*조회수*/
  
);

desc notice;
alter table notice
add constraint notice_id_pk PRIMARY KEY(id);


alter table notice 
modify (title not null, content not null);

--notice 테이블의 PK인 id 컬럼에 적용할 시퀀스
create   SEQUENCE  seq_notice  --공지사항에 반영할 시퀀스
start with 1 increment by 1;


--notice 테이블의 PK인 id 컬럼에 시퀀스를 자동적용시킬 트리거(만들거나, 그 처리내용을 바꾸는 replace 구문을 넣어주면 다시 컴파일 할수 있다)
--create or replace trigger trg_notice
-- notice 테이블에 데이터행을 insert 할때 PK인 id컬럼에 시퀀스값을 담는 처리를 한다
create trigger trg_notice
 before insert on notice
 for each row
begin
  select seq_notice.nextval into :new.id from dual;
end;
/


select name from customer;
select seq_notice.nextval from dual;

시퀀스명.currval, 시퀀스명.nextval 

insert into notice( id, title, content, writer)
values (seq_notice.nextval, '테스트 공지글입니다', '테스트 공지글', 'admin' );

commit;

select * from notice;





ROLLBACK;


--회원관리 테이블 생성
DROP  TABLE mamber;
create table member (
  userid   VARCHAR2(50) constraint member_userid_pk primary key /*회원아이디*/,
  name    varchar2(50) not null/*회원명*/,
  userpw    varchar2(30)  not null /*비밀번호*/,
  gender    varchar2(3) default '여' not null/*성별: 남/여 근데 디폴트는 적용해놔도. 화면엔 어차피 적용안돼~*/,
  email     varchar2(50) not null  /*이메일*/,
  birth     date   /*생년월일*/,
  phone      varchar2(13) /*전화번호*/,
  address  varchar2(300)  /*주소*/,
  admin   varchar2(1)  default 'N' /*관리자여부 Y/N으로 표현 근데 여긴 회원가입이니까 관리지가 아니잖아. n!*/
 
);

insert into member (userid, userpw, name, email, admin)
values ('admin' , 'Manager', '관리자', 'admin@hanuledu.co.kr', 'Y');

insert into member (userid, userpw, name, email, admin)
values ('admin2' , 'Manager', '운영자', 'admin@hanuledu.co.kr', 'Y');

commit;