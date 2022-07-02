■ OUTER JOIN
오라클에서 기호 (+)를 사용하는 
OUTER JOIN과 같은 기능을 하는 JOIN형식이다.  --근데 어지간하면 Outer join 써!
FROM 절에 LEFT OUTER JOIN / RIGHT OUTER JOIN  을 사용하고 
JOIN 조건은 ON 절에 명시한다.

[5-16] 사원의 사번, 이름, 부서코드, 부서명 정보를 조회한다.
SELECT e.employee_id, e.last_name, e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);  --107개


ANSI JOIN ON
SELECT e.employee_id, e.last_name, e.department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d --왼쪽에 null 가져와!
ON e.department_id = d.department_id;  --107개
-- e.department_id가 fk니까 null인쪽이 왼쪽에다 쓴다했다

ANSI JOIN USING
SELECT e.employee_id, e.last_name, department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d --왼쪽에 null 가져와! null있는 쪽에 맞춰서 왼오 맞추는거야
USING (department_id);

모든 사원의 사번, 성, 부서코드, 부서명, 도시 조회
SELECT e.employee_id 사번, e.last_name 성, e.department_id 부서코드, d.department_name 부서명, l.city 도시
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id(+)
AND d.LOCATION_ID = l.LOCATION_ID(+);  --107개

ANSI JOIN ON
SELECT e.employee_id 사번, e.last_name 성, e.department_id 부서코드, d.department_name 부서명, l.city 도시
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
LEFT OUTER JOIN locations l
ON d.LOCATION_ID = l.LOCATION_ID;  --107개

ANSI JOIN USING
SELECT e.employee_id 사번, e.last_name 성, department_id 부서코드, d.department_name 부서명, l.city 도시
FROM employees e LEFT OUTER JOIN departments d
USING (department_id)
LEFT OUTER JOIN locations l
USING (location_id); --107개