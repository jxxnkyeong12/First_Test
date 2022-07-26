<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h3>회원가입</h3>

<form method="post" action="joinRequest">
	<table border = '1' style = 'width: 600px'>
		<colgroup>
			<col width="140px">
		</colgroup>
		<tr>
			<th>성명</th>
			<td><input type = "text" name = "name"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<label><input type ='radio' name = "gender" value = '남' checked>남</label>
				<label><input type ='radio' name = "gender" value = '여'>여</label>
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type = "text" name = "email"></td>
		</tr>
		
	</table>
	<input type = 'submit' value ='HttpServletRequest'>
	<input type = 'submit' value ='@RequestParam' onclick="action = 'joinParam'">
	<input type = 'submit' value ='데이터객체' onclick="action = 'joinDataObject'">
	<input type = 'submit' value ='@PathVariable' onclick="go_submit(this.form)">
</form>

<script>
	function go_submit(f) {
		f.action = 'joinPath/'+ f.name.value + '/'+ f.gender.value+'/'+f.email.value;
	}
</script>
</body>
</html>