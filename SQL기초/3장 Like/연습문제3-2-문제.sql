-----------------------------------------------------------------------------------------------
--[ 연습문제 3-2 ]                            
--01. 사원 테이블에서 이름(first_name)이 A로 시작하는 
--모든 사원의 이름과 이름의 길이를 조회(LENGTH()함수)하는 쿼리문 작성.
SELECT first_name name, LENGTH(first_name) length 
FROM  employees
WHERE first_name LIKE 'A%';



--02. 80번 부서원의 이름과 급여를 조회하는 쿼리문을 작성한다.
--단, 급여는 15자 길이로 왼쪽에 $ 기호가 채워진 형태로 표시되도록 한다.
SELECT department_id, first_name, LPAD(salary, 15, '$') lpad_salary
FROM  employees
WHERE department_id = 80;



--03. 60번 부서, 80번 부서, 100번 부서에 소속된 사원의 
-- 사번, 성, 전화번호, 전화번호의 지역번호, 개인번호를 조회하는 쿼리문 작성
-- 단, 개인번호의 컬럼은 private_number, 지역번호의 컬럼은 local_number 라고 표시하고, 
-- 지역번호는 515.124.4169 에서 515를 빼야하고
--            590.423.4568 에서 590, 
--            011.44.1344.498718 에서 011 이 지역번호라 한다.
--
-- 개인번호는 515.124.4169 에서 4169, 
--            590.423.4568 에서 4568, 
--      011.44.1344.498718 에서 498718 이 개인번호라 한다.
--                    
--부서코드가 60,80,100 인 부서에 속한 사원들의 
--사번, 성, 전화번호, 지역번호, 개인번호 조회하는 쿼리문 작성

첫번째 .의 위치를 알아야 한다. :INSTR(phone_number, '.' ,1,1)
부분문자열 반환 : SUBSTR(phone_number, 1, INSTR(phone_number, '.' ,1,1)-1)
마지막번째 . 의 위치    : INSTR(phone_number,'.',-1,1) -- -1은 오른쪽부터 찾는건데 
부분문자열 반환 : SUBSTR(phone_number, 1, INSTR(phone_number, '.' ,1,1)+1)
SELECT job_id, last_name, phone_number, LPAD(phone_number, 16, '010.') local_number
       SUBSTR(phone_number, 1, INSTR(phone_number, '.' ,1,1)-1) local_number,
       SUBSTR(phone_number, INSTR(phone_number, '.' ,-1,1)+1) private_number --마지막점의 위치!
FROM  employees
WHERE department_id IN (60, 80, 100);


--★★★★★★★★★★★★★★★★★결과
--                             local_number  private_number 
--박문수  515.124.4567         515           4567
--임꺽정  011.44.1344.467268   011           467268 
--홍길동  02.1234.5678         02            5678
--전우치  062.9874.5422        062           5422
--심청    0652.4523.6221       0652          6221

--04. JOBS 테이블에서 업무코드, 업무제목, 직무, 직책 조회
--직무, 직책은 업무코드에서 '_'기준으로 조회(직무_직책)

-----------------------------------------------------------------------------------------------




