○ SQL(Structured Query Language) 명령어
- 데이터베이스에서 자료를 검색하고 수정하고 삭제하는 등을 위한 데이터베이스 언어이다.
- 관계형 데이터베이스를 처리하기 위해 고안된 언어이다.
- 독자적인 문법을 갖는 DB표준 언어이다.(ISO에 의해서 지정)
- 대다수 데이터베이스는 SQL을 사용하여 데이터를 조회, 입력, 수정, 삭제한다.

※ SQL 명령문의 종류
DQL : Data Query Language(질의어), SELECT
DML : Data Manipulation Language(데이터 조작어), INSERT, UPDATE, DELETE
TCL : Transaction Control Language(트랜젝션 처리어), COMMIT, ROLLBACK, SAVEPOINT

DDL : Data Definition Language(데이터 정의어), CREATE, ALTER, DROP, TRUNCATE, RENAME
DCL : Data Control Language(데이터 제어어), GRANT, REVOKE

-----------------------------------------------------------------------------------------------
DQL - SELECT문 ☞ 저장된 데이터를 조회

DML - INSERT문 ☞ 새로운 데이터를 삽입
DML - UPDATE문 ☞ 기존의 데이터를 변경
DML - DELETE문 ☞ 기존의 데이터를 삭제

TCL - COMMIT ☞ 변경된 내용을 영구 저장
TCL - ROLLBACK  ☞ 변경되기 이전 상태로 되돌림
TCL - SAVEPOINT ☞ 특정 위치까지는 영구 저장 혹은 이전 상태로 되돌릴 수 있도록 
        트랜잭션 중에 저장점을 만들 때 사용
        
DDL - CREATE문 ☞ 새로운 테이블을 생성
DDL - ALTER문  ☞ 기존의 테이블을 변경(컬럼 추가, 컬럼 크기 변경 등)
DDL - TRUNCATE문 ☞ 객체내의 데이터를 삭제(자르다-란 뜻이 있다)
                   DML의 DELETE문과의 차이점 : TCL의 ROLLBACK으로 삭제하기 이전 상태로 되돌릴 수 없다.
DDL - DROP문 ☞ 기존 테이블을 삭제할 때 사용
               테이블의 내용과 구조 자체를 모두 제거한다.
DDL - RENAME문 ☞ 기존의 테이블의 이름을 변경

DCL - GRANT문 ☞ 사용자에게 특정 권한을 부여할 때 사용
DCL - REVOKE문 ☞ 사용자에게 부여했던 특정 권한을 제거할 때 사용 (revoke 뜻이 취소)
-----------------------------------------------------------------------------------------------

○ SQL*PLUS 명령어
- 툴에서 출력 형식을 지정하는 등 환경을 설정한다.
- SQL 명령문을 저장하거나 편집 기능을 제공한다.
- 컬럼이나 데이터의 출력형식을 지정하며, 환경을 설정하는 기능을 포함한다.
- SQL 문을 실행시키고 그 결과를 볼 수 있도록 오라클에서 제공하는 툴이다.
-----------------------------------------------------------------------------------------------
  SQL 문                                    |  SQL*PLUS 문(SQL + 툴 자체명령)
-----------------------------------------------------------------------------------------------
- 관계형 DB의 ANSI 표준 언어                |  - SQL 문을 실행시킬 수 있는 오라클의 툴(도구)
- 여러 줄 실행                              |  - 한 줄 실행 
- 종결문자(;)의 사용으로 여러줄을 사용해도  |  - 종결문자(;)가 없기 때문에 여러줄을 사용할려면 
  끝에 종결문자(;)를 넣으면 한줄로 인식     |    연결문자(-)를 사용해 주어야함
- 키워드 단축 불가                          |  - 키워드 단축 가능
- 버퍼에 마지막 명령문 저장                 |  - 버퍼 저장 안함
-----------------------------------------------------------------------------------------------

※ SQL과 PL/SQL, SQL*Plus의 차이점
- SQL      : 관계형 데이터베이스에 저장된 데이터에 Access하기 위하여 사용하는 표준언어 이다.
- PL/SQL   : SQL문을 사용하여 프로그램을 작성할 수 있도록 확장해 놓은 
             오라클의 Procedural Language 이다.
- SQL*Plus : SQL 및 PL/SQL 문장을 실행할 수 있는 환경을 제공하는 오라클의 Tool 이다.
-----------------------------------------------------------------------------------------------














