<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> <!-- JSTL 사용을 위한 준비 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
  font-family: 'Arial';
  margin: 25px auto;
  border-collapse: collapse;
  border: 1px solid #eee;
  border-bottom: 2px solid #00cccc;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1), 0px 10px 20px rgba(0, 0, 0, 0.05), 0px 20px 20px rgba(0, 0, 0, 0.05), 0px 30px 20px rgba(0, 0, 0, 0.05);
}
table tr:hover {
  background: #f4f4f4;
}
table tr:hover td {
  color: #555;
}
table th, table td {
  color: #999;
  border: 1px solid #eee;
  padding: 12px 35px;
  border-collapse: collapse;
}
table th {
  background: #00cccc;
  color: #fff;
  text-transform: uppercase;
  font-size: 12px;
}
table th.last {
  border-right: none;
}

h1 {
	text-align: center;
	margin-top: 30px;
}
#new_btn {
	position: fixed;
	
}

</style>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<h1>고객관리모듈(JSTL)</h1>
<button type="button" id="new_btn" class="btn btn-primary" onclick="showModalInsert();">신규 고객 추가</button>
<!-- $ : 동적으로 request에 있는 자원에 접근해서 사용, bean을 만들어서 불러온다
 -->
 <table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>성별</th>
		<th>이메일</th>
		<th>핸드폰</th>
		<th>수정</th>
		
	</tr>
		
	<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.id}</td>
		<td>${dto.name}</td>
		<td>${dto.gender}</td>
		<td>${dto.email}</td>
		<td>${dto.phone}</td>
		<!-- EL 문법으로 showModal에 파라매터를 하나 전송 -->
		<td><button type="button" class="btn btn-secondary" onclick="showModal('${dto.id}', '${dto.name}', '${dto.gender}', '${dto.email}', '${dto.phone}');">정보수정</button></td>
	</tr>
	</c:forEach>
	</table>

	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">신규 추가 Modal</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	       
	          <div class="mb-3">
	            <label for="recipient-name" class="col-form-label">이름</label>
	            <input type="text" name="name" class="form-control" id="recipient-name">
	          </div>
	          <div class="mb-3">
	            <label for="recipient-name" class="col-form-label">성별</label>
	            <input type="radio" name="gender" value="남" />남
	            <input type="radio" name="gender" value="여" checked/>여
	          </div>
	          <div class="mb-3">
	            <label for="recipient-name" class="col-form-label">이메일</label>
	            <input type="text" name="email" class="form-control" id="recipient-name">
	          </div>
	          <div class="mb-3">
	            <label for="recipient-name" class="col-form-label">핸드폰</label>
	            <input type="text" name="phone" class="form-control" id="recipient-name">
	          </div>
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary" name="submit" onclick="addCustomer();">추가</button>
	      </div>
	    </div>
	  </div>
	</div>
	
<%@ include file="/include/footer.jsp" %>


<script type="text/javascript">
	function showModalInsert() {
		$('#exampleModal').modal('show');
		$('[name=submit]').attr('onclick', 'addCustomer()');
	}
	
	function showModal(id, name, email, phone, gender) {
		$('[name=submit]').attr('onclick', 'modifyCustomer()');
		
		
		/* 안 돼서 보류..
		if(gender == '남'){
			$('[name=gender]')[0].attr('checked', true);
			$('[name=gender]')[1].attr('checked', false);
		}
		*/
		
		$('[name=name]').val(name);
		//$('[name=gender]').val(gender);
		$('[name=email]').val(email);
		$('[name=phone]').val(phone);
		$('[name=id]').val(id);
		$('#exampleModal').modal('show');
		
	}

	/* addCustomer 펑션을 만들고 input type에 들어있는 값들을 콘솔 또는 alert 이용해서 띄워보기 */
	function addCustomer() {
		//alert($('[name=name]').val()); -> jQuery 이용해서 name 속성이 name의 값을 가져옴
		//ajax 이용해서 insert.cu를 만들고 해당하는 Servlet까지 전송하기
		$.ajax({
			url: 'insert.cu',
			data:{ /* request.parameter로 맏아줄 것(name) : ?? <- 넣어줄 실제 값 */
					name:$('[name=name]').val(),
					gender: $('[name=gender]:checked').val(),
					email: $('[name=email]').val(),
					phone: $('[name=phone]').val() },
			success : function (response) {
				/* 페이지 전환이 아니라 out 객체를 통해서 바로 값을 써주면 그 값을 가지고 옴 */
				$('[name=name]').val('');
				$('[name=gender]').val('');
				$('[name=email]').val('');
				$('[name=phone]').val('');
					
			}, error : function (req, msg) {
				alert(msg + " : ");
			}
		});
		
		location.reload();
		$('#exampleModal').modal('hide');
	}
</script>
</body>
</html>