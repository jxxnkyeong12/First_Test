<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class = 'page-list'>
<c:if test="${page.curBlock gt 1 }">
<a onclick="page(1)"><i class="fa-solid fa-angles-left"></i></a>
<a onclick = "page(${page.beginPage - page.blockPage})"><i class="fa-solid fa-angle-left"></i></a>
</c:if>

<c:forEach var = 'no' begin = '${ page.beginPage}' end ='${page.endPage }'>
	<c:if test="${no eq page.curPage }"><span>${no}</span></c:if>  <!--1번은 클릭안돼~!  -->
	<c:if test="${no ne page.curPage }"><a onclick = "page(${no})">${no}</a></c:if>  

</c:forEach>
<c:if test="${page.curBlock lt page.totalBlock }">	
	<a onclick="page(${page.endPage+1})"><i class="fa-solid fa-chevron-right"></i></a>
	<a onclick="page(${page.totalPage})"><i class="fa-solid fa-angles-right"></i></a>
</c:if>

</div>

<script>
	function page(no) {
		$('[name=curPage]').val( no );
		$('form').submit();
	}
</script>