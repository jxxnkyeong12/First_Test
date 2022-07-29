<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<header>
<div class='category'>
	<ul>
		<li><a href="<c:url value='/'/>"> <img src='img/hanul.logo.png'></a></li>
		<li><a ${category eq 'cu' ? 'class="active"' : ''} href='list.cu'>고객관리</a></li>
		<li><a ${category eq 'hr' ? 'class="active"' : ''} href ='list.hr'>사원관리</a></li>
		<li><a ${category eq 'no' ? 'class="active"' : ''} >공지사항</a></li>
		<li><a ${category eq 'bo' ? 'class="active"' : ''} >방명록</a></li>
		<li><a ${category eq 'da' ? 'class="active"' : ''} >공공데이터</a></li>
		<li><a ${category eq 'vi' ? 'class="active"' : ''} >시각화</a></li>
	</ul>
</div>
</header>
<style>
header { 
	border-bottom:1px solid #ccc;
	display: flex; 
	justify-content: space-between;
	/* width: calc(100% - 200px); */
	padding: 0 100px;
}
header div.category ul { display: flex; font-weight: bold;  }
header div.category ul li:not(:last-child) { margin-right: 50px }
header div.category ul li a:hover
, header div.category ul li a.active { color: #0040ff; }

a { cursor: pointer; }

</style>


