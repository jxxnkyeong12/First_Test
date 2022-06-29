--ANSI조인은 표준이다.
5.6 ANSI JOIN

ANSI JOIN 은 모든 DBMS에서 공통적으로 사용할수 있는 국제 표준 JOIN형식이다.

▶ INNER JOIN
INNER JOIN은 오라클의 EQUI JOIN과 같은 기능을 하는 JOIN형식이다.
FROM 절에 INNER JOIN을 사용하고 JOIN 조건은 ON 절에 명시한다.

[5-12] 사원의 사번, 이름, 부서코드, 부서명 정보를 조회한다.
오라클 조인
SELECT e.employee_id, e.first_name, e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+); --107개 나오고

ANISI JOIN ON
SELECT e.employee_id, e.first_name, e.department_id, d.department_name
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id;   --106개 나와

ANISI JOIN USING
SELECT e.employee_id, e.first_name, e.department_id, d.department_name
FROM employees e INNER JOIN departments d
USING (department_id);--컬럼명이 같이 때만 사용, 테이블명 삭제
--------------------------------------------------------------------------------
오라클 조인                         |   ANSI 조인
--------------------------------------------------------------------------------
5.SELECT    컬럼명1, 컬럼명2,...    | SELECT    컬럼명1, 컬럼명2,... 
1.FROM      테이블명1, 테이블명2,.. | FROM      테이블명1 INNER JOIN 테이블명2,.
2.WHERE     조인조건식              | ON        조인조건식
                                    | (또는) 
                                    | USING     (조인컬럼명만)
                                    |
  AND       일반조건식              | WHERE      일반조건식  --ON, USING 다음에 WHERE 사용  (on 써보니 안되더라...)
3.GROUP BY  조건식                  | GROUP By   
4.HAVING                            | HAVING
6.ORDER BY                          | ORDER BY
--------------------------------------------------------------------------------
[5-14] 80번 부서원의 사번, 이름, 부서코드, 부서명을 조회한다.
오라클 조인
SELECT e.employee_id, e.first_name, e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.department_id = 80; --34개

1)ANSI JOIN ON
SELECT e.employee_id, e.first_name, e.department_id, d.department_name 
FROM  employees e INNER JOIN departments d
ON e.department_id = d.department_id
--USING (department_id)
WHERE e.department_id = 80;   --34개

2)ANSI JOIN USING --얘는 식별자를 앞에 안두네....? e.이나 d.같은...
SELECT e.employee_id, e.first_name, department_id, d.department_name 
FROM  employees e INNER JOIN departments d
USING ( department_id )
WHERE department_id = 80;   --34개


JOIN 에 사용하는 테이블이 3개이상일 경우
첫 번째 JOIN 의 결과에
두 번째 JOIN 을 추가하는 형태로 JOIN 형식을 사용한다.

[5-15] 사원의 사번, 이름, 부서코드, 부서명, 위치코드, 도시 정보를 조회한다.
SELECT e.employee_id, e.first_name, e.department_id, d.department_name, l.location_id, l.city
FROM employees e, departments d, locations l   --fk로시작해서 PK로 끝내기
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id; --106개

1)ANSI JOIN ON
SELECT e.employee_id, e.first_name, e.department_id, d.department_name, l.location_id, l.city
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
INNER JOIN locations l   --fk로시작해서 PK로 끝내기
ON d.location_id = l.location_id; --106개

1)ANSI JOIN USING
SELECT e.employee_id, e.first_name, department_id, d.department_name, location_id, l.city
FROM employees e INNER JOIN departments d
USING (department_id) 
INNER JOIN locations l   --fk로시작해서 PK로 끝내기
USING (location_id); --106개 마우스로 더블클릭해보면 그 해당 문구 나와줘! 거기가서 앞에 지정해줬던거 지우면 돼~!
