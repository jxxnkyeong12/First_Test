■ SELF JOIN
하나의 테이블을 두번 명시하여 동일한 테이블 두개로부터 JOIN을 통해 데이터를 조회하여 결과를 반환한다.
즉, 한테이블 내에서 두 데이터 컬럼이 연관관계가 있다.

[5-10] 사원의 사번, 이름, 매니저사번, 매니저이름 정보를 조회한다.   --매니저이름....?
SELECT e.employee_id, --e.first_name 이걸로 하면 같은 이름만 가져와서 안맞아!
       e.manager_id, m.employee_id, m.first_name manager_name
FROM  employees e, employees m  --새로 생성해서 매니저이름에 맞게....!
WHERE e.manager_id = m.employee_id (+)
ORDER BY e.employee_id;

