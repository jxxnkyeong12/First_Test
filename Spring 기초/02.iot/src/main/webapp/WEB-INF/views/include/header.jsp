<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
<div class='category'>
	<ul>
		<li><a><img src='img/hanul.logo.png' /></a></li>
		<li><a class = 'active' href ='list.cu'>고객관리</a></li>
		<li><a>사원관리</a></li>
		<li><a>공지사항</a></li>
		<li><a>방명록</a></li>
		<li><a>공공데이터</a></li>
		<li><a>시각화</a></li>
	</ul>
</div>

</header>
<style>
header { 
	border-bottom: 1px solid #ccc;
	display: flex;
	justify-content: space-between;
	/* width: calc(100% - 200px); */
	padding: 0 100px;
}

header div.category ul {display: flex;  font-weight: bold; }
header div.category ul li:not(:last-child) { margin-right: 50px; } /* 마지막 애는 빼고 */
header div.category ul li a:hover, header div.category ul li a.active { color: #0040ff; }

a { cursor: pointer;}

</style>
<link rel='stylesheet' type='text/css' href ='css/common.css'>