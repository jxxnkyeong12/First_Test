<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSPL 태그를 이용하기 위한 준비 ! ↑ -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#new_btn{
		position: fixed;
		right: 20%;
		top:20%;
		z-index: 999; /*  위에 좀 떠있어라*/
	
	}

</style>
</head>
<body>

<!-- $<-동적으로 request에 있는 자원에 접근해서 사용 
	bean을 만들어서 자동으로 데려오는거
-->
	<%@ include file = "/include/header.jsp"  %> <!-- 뒤로 한칸 올라가니가 /해줘 -->
	<h1>고객관리모듈 (JSTL)</h1>
	<button type="button" id ="new_btn" class="btn btn-primary" onclick="showModalInsert();">신규 고객 추가</button>
	
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

		<c:forEach items="${list}" var="dto">
		 <tr>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.gender}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
			<td>
			<!-- EL문법으로 showModal에 파라메터를 하나 전송 /그리고 전송된 파라메터를 alert으로 출력 -->
			<button type="button"  class="btn btn-secondary" onclick="showModal('${dto.id}','${dto.name}','${dto.gender}','${dto.email}','${dto.phone}');">정보 수정</button>
			</td>
    	</tr>

		</c:forEach>

		</tbody>
	</table>	
	
	

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">고객 추가 Modal</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       
       
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이름</label>
            <input type="text" name ="name" class="form-control" id="recipient-name">
            
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">성별</label>
            <input type="radio" checked="checked" name="gender" value="남"/>남
            <input type="radio" name="gender" value="여"/>여
          </div>
           <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이메일</label>
            <input type="text" name ="email" class="form-control" id="recipient-name">
            
          </div>
           <div class="mb-3">
            <label for="recipient-name" class="col-form-label">핸드폰</label>
            <input type="text" name ="phone" class="form-control" id="recipient-name">
            
          </div>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary"  name="submit" onclick="addCustomer();">추가</button>
      </div>
    </div>
  </div>
</div>
		<%@ include file="/include/footer.jsp"%>
		
		
		<script type="text/javascript">
			function showModalInsert() {  //①
				$('#exampleModal').modal('show'); //hide 숨김	
				$('[name=submit]').attr('onclick', 'addCustomer()');
			}
			
			function showModal(id, name, email, phone, gender) {//③
			 //  alert(id);
				$('[name=submit]').attr('onclick', 'modifyCustomer()');
			    $('[name=name]').val(name);
			   /* 일단보류! jquery로 나중에 처리  
			   if(gender =='남') {
			    	 $('[name=gender]')[0].attr('checkde' , false);  //false가 해제야
			    	 $('[name=gender]')[1].attr('checkde' , false);
			    }else {
			    	
			    } */
				/*   $('[name=gender]').val('email'); */
				  $('[name=email]').val(email);
				  $('[name=phone]').val(phone);
				  
				  $('#exampleModal').modal('show'); 
			}
			
			function addCustomer() {//②
				/* alert( $('[name=name]').val() );  jquery를 이용해서 name속성이 name의 값을 가져옴*/
				/* ajax<-통신 이용해서 insert.cu를 만들고 해당하는 Servlet까지 값을 전송해보기  */
			var gender=$('[name=gender]:checked').val();//자꾸 남자만 나와서 확인할려고 하는거 그리고 그 변수를 담아!
				$.ajax({
					url: 'insert.cu',
					data: {/*request.getParameter로 받아줄것(name) : <- 넣어줄 실제값   */
						  name:$('[name=name]').val(),
						  gender:$('[name=gender]:checked').val(),
						  email:$('[name=email]').val(),
						  phone:$('[name=phone]').val()
						  },
					success: function ( response) {
						  $('[name=name]').val('');
						  $('[name=gender]').val('');
						  $('[name=email]').val('');
						  $('[name=phone]').val('');
						/*  페이지전환이 아니라  out 객체를 통해서 값을 바로 써주면 그값을 가지고옴 */
					},error: function (req,msg) {
						alert(msg + " : ");
					}	  
				});
				location.reload(); // 바뀐 내용으로 새로고침
				$('#exampleModal').modal('hide');  //창 닫아지게 하는거
			
			}
			/*addCustomer 펑션을 만들고 input type에 들어있는 값들을 콘솔 또는alert 이용해서 띄워보기  */
		</script>
		
		
</body>
</html>