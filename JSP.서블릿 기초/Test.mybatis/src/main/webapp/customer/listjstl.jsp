<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <!-- jstl 태그를 이용하기 위한 준비 ↑ -->   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 #new_btn{
 	position:  fixed;
 	right: 20%; /* 우측에서 20%정도 있는곳에 있어라 */
 	top: 20%;
 	z-index:999; /* 위로좀 떠있어라 */
 }

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- $ 표시가 제일 중요해! request에 있는 자원에 접근해서 사용!  이엘이 편하고 좋아
	-->



	<%@ include file="/include/header.jsp" %>
<h1 style="text-align: center;">고객관리 모듈</h1>
<button type="button"  id = "new_btn" class="btn btn-primary"  onclick="showModal();">신규 고객 추가</button> <!-- showModal()펑션을 만들어서 써보겠다 -->

	<table class = "styled-table"> 
	 <thead>
	 	<tr> 
	 		<th>아이디</th>
	 		<th>이름</th>
	 		<th>성별</th>
	 		<th>이메일</th>
	 		<th>핸드폰</th>
	 	</tr>
	 </thead>
	  <tbody>
	
	<c:forEach items="${list}" var = "dto"> <!-- 어떤걸 foreach로 돌릴것인가 list에 있는 dto를 뺄거다!  -->
		<%-- <p>${dto.id  }</p> --%> <!-- 앞에서 해봤던 List.get(i).getId() 이거를 이렇게 간단하게! -->
		<tr>
			<td>${dto.id }</td>
			<td>${dto.name }</td>
			<td>${dto.gender }</td>
			<td>${dto.email }</td>
			<td>${dto.phone }</td>
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
     <!-- form태그는 지워! -->
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이름</label>
            <input type="text" name = "name" class="form-control" id="recipient-name">
          </div>
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">성별</label>
            <input type="radio" name = "gender"  value= "남" checked="checked">남
            <input type="radio" name = "gender"  value= "여" >여
          </div>
           <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이메일</label>
            <input type="text" name = "email" class="form-control" id="recipient-name">
          </div>
           <div class="mb-3">
            <label for="recipient-name" class="col-form-label">핸드폰</label>
            <input type="text" name = "phone" class="form-control" id="recipient-name">
          </div>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" onclick="addCustomer();">추가</button>
      </div>
    </div>
  </div>
</div> 
<%@ include file="/include/footer.jsp" %>


		<script type="text/javascript">
		function showModal() {
			$('#exampleModal').modal('show'); //show는 클릭했을때 모달창을 보여주는거 hide는 숨김
		
		}
		/* addCustomer 펑션을 만들고 input type에 들어있는 값들을 콘솔 또는 alert이용해서 띄워보기  */
		/* 이부분은 작성하고 취소를 눌렀을때 뜨게 하는거야  */
		function addCustomer() {
			alert($('name'));
		}
		</script>
</body>
</html>