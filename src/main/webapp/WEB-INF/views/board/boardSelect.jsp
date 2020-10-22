<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp">WebSiteName</c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="./${board}List">Notice</a></li>
      <li><a href="./member/memberList">Member</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  <h3>Notice Select Page</h3>
  <h3 id="num">${dto.num}</h3>
  <h3>Title : ${dto.title}</h3>
  <h3>Writer : ${dto.writer}</h3>
  <h3>Contents : ${dto.contents}</h3>
  <input type="button" title="${dto.num}" value="Delete" class="btn btn-warning" id="del">
  <input type="button" value="Update" class="btn btn-info" id="update">
  <c:if test="${board ne 'notice'}">
  <a href = "./${board}Reply?num=${dto.num}" class ="btn btn-info">Reply</a>
  </c:if>
</div>

<script type="text/javascript">
	//$("css선택자").action();
	$("#update").click(function() {
		location.href="./${board}Update?num=${dto.num}";
	});
	
	$("#del").click(function() {
		//var num =$("#num").html();
		var num = $(this).attr("title");
		alert(num);
		location.href="./${board}Delete?num="+num;
	});
	
	
	
</script>
</body>
</html>