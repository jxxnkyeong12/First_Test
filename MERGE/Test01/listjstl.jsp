<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL 태그를 이용하기 위한 준비 ↑  -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#new_btn{
		position: fixed;
		right: 20%;
		top: 20%;
		z-index: 999;
	}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- $<-동적으로 request에 있는 자원에 접근해서 사용
  -->
	<%@ include file="/include/header.jsp"%>
	<h1>고객관리 모듈(JSTL)</h1>
	<button type="button"  id="new_btn" class="btn btn-primary" onclick="showModal();" >신규 고객 추가</button>
	
	<table class="styled-table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>이메일</th>
				<th>핸드폰</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.gender}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
			<td>
			<!-- EL문법으로 showModal에 파라메터를 하나 전송 전송 된 파라메터를 alert 으로 출력 -->
			<button type="button"  class="btn btn-secondary" onclick="showModal('${dto.id}','${dto.name}','${dto.email }','${dto.phone }','${dto.gender }');" >정보 수정</button>
			</td>

		</tr>
	</c:forEach>
	
			</tbody>
	</table>
	
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">고객 추가</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이름</label>
            <input type="text" name="name" class="form-control" id="recipient-name">
          </div>
           <div class="mb-3">
            <label for="recipient-name" class="col-form-label">성별</label>
            <input type="radio" checked="checked" name="gender" value="남" />남
            <input type="radio" name="gender" value="여" />여
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
	
	
	<%@ include file="/include/footer.jsp"%>
	
	<script type="text/javascript">
		function showModal() {
			$('#exampleModal').modal('show');//hide 숨김
			$('[name=submit]').attr('onclick' ,'addCustomer()');
		}
		function showModal(id , name , email , phone , gender) {
			$('[name=submit]').attr('onclick' ,'modifyCustomer()');
			 $('[name=name]').val(name);
			/* 보류 => jquery로 나중에 처리  
			if(gender == '남'){
				 $('[name=gender]')[0].attr('checked' , false);
				 $('[name=gender]')[1].attr('checked' , false);
			 }else{
				 
			 } */
			//  $('[name=gender]').val('');
			  $('[name=email]').val(email);
			  $('[name=phone]').val(phone);
			  
			  $('#exampleModal').modal('show');
		}
		function addCustomer() {
			/* alert( $('[name=name]').val() );  jquery를 이용해서 name속성이 name의 값을 가져옴*/
			/* ajax<-통신 이용해서 insert.cu를 만들고 해당하는 Servlet까지 값을 전송해보기  */
			var gender = $('[name=gender]:checked').val();
			$.ajax({
				url: 'insert.cu',
				data: {/*request.getParameter로 받아줄것(name) : <- 넣어줄 실제값   */
					  name:$('[name=name]').val(),
					  gender:gender,
					  email:$('[name=email]').val(),
					  phone:$('[name=phone]').val()
					  },
				success: function ( response) {
					  $('[name=name]').val('');
					  $('[name=gender]').val('');
					  $('[name=email]').val('');
					  $('[name=phone]').val('');
				},error: function (req,msg) {
					alert(msg + " : ");
				}	  
			});
			
			location.reload();
			$('#exampleModal').modal('hide');
			
		}
		/*  addCustomer 평션을 만들고 input type에 들어있는 값들을 콘솔 또는 alert이용해서 띄워보기*/
	</script>
	
	
</body>
</html>