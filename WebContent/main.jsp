<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"  %>

<%@ page import="user.User"%>
<%@ page import="user.UserDAO"%>
<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 뷰포트 -->

<meta name="viewport" content="width=device-width">

<!-- 스타일시트 참조  -->

<link rel="stylesheet" href="css/bootstrap.min.css">

<title>nosdo 게시판 웹사이트</title>

</head>

<body>
<%
	String userID=null;
	if(session.getAttribute("userID")!=null){
		userID=(String)session.getAttribute("userID");
	}

%>
 <!-- 네비게이션  -->

 <nav class="navbar navbar-default">

  <div class="navbar-header">

   <button type="button" class="navbar-toggle collapsed" 

    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"

    aria-expaned="false">

     <span class="icon-bar"></span>

     <span class="icon-bar"></span>

     <span class="icon-bar"></span>

    </button>

    <a class="navbar-brand" href="main.jsp">NOSDO</a>
    
    <a class="navbar-brand" href="bbs.jsp">게시판</a>

  </div>

  <div class="navbar-header" id="#bs-example-navbar-collapse-1">

  
   
   <%
   if(userID==null){
	   
	   
   %>
   <ul class="navbar-header">

		<li class="dropdown"><a href="#" class="dropdown-toggle"

					data-toggle="dropdown" role="button" aria-haspopup="true"

					aria-expanded="false">접속하기<span class="caret"></span></a>

					<ul class="dropdown-menu">

						<li class="active"><a href="login.jsp">로그인</a></li>

						<li><a href="join.jsp">회원가입</a></li>



					</ul>
					</li>
		
  	</ul>
   <% 
   } else {
	   
   %>
   
   
  <ul class="navbar-header">

					<li class="dropdown"><a href="#" class="dropdown-toggle"

						data-toggle="dropdown" role="button" aria-haspopup="true"

						aria-expanded="false">회원관리<span class="caret"></span></a>

						<ul class="dropdown-menu">

							<li><a href="logoutAction.jsp">로그아웃</a></li>

						</ul></li>

				</ul>
   <% 
   
   }
   %>
	
	
    

  

  </div> 

 </nav>


 

 

 <!-- 애니매이션 담당 JQUERY -->

 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 

 <!-- 부트스트랩 JS  -->

 <script src="js/bootstrap.js"></script>

 

</body>

</html>
