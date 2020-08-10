<%@page import="javax.security.auth.callback.ConfirmationCallback"%>

	<%@ page language="java" contentType="text/html; charset=UTF-8"

		pageEncoding="UTF-8"%>

	<%@ page import="java.io.PrintWriter"%>

	<%@ page import="movies.Movies"%>

	<%@ page import="movies.MoviesDAO"%>

	<%@ page import="java.util.ArrayList"%>

	<!DOCTYPE html>

	<html>

	<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- 뷰포트 -->

	<meta name="viewport" content="width=device-width" initial-scale="1">

	<!-- 스타일시트 참조  -->

	<link rel="stylesheet" href="css/bootstrap.css">

	<title>nosdo 영상 교육</title>

	<style type="text/css">

		a, a:hover {

			color: #000000;

			text-decoration: none;
			
			
		}
		td {
        
        
       



        
      }
	</style>

	</head>

	<body>

		<%

			//로긴한사람이라면	 userID라는 변수에 해당 아이디가 담기고 그렇지 않으면 null값

			String userID = null;

			if (session.getAttribute("userID") != null) {

				userID = (String) session.getAttribute("userID");

	

			}

	

			int pageNumber = 1; //기본 페이지 넘버

	

			//페이지넘버값이 있을때

			if (request.getParameter("pageNumber") != null) {

				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));

			}

		%>

	

	

		<!-- 네비게이션  -->

		<nav class="navbar navbar-default">

			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"

					data-toggle="collapse" data-target="bs-example-navbar-collapse-1"

					aria-expaned="false">

					<span class="icon-bar"></span> <span class="icon-bar"></span> <span

						class="icon-bar"></span>

				</button>

				<a class="navbar-brand" href="Movie.jsp">영상교육게시판</a>
				<!-- <a href="main.jsp">메인</a> -->

				

			</div>

			<div class="navbar-header"

				id="#bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav">

					

				</ul>

	

	

				<%

					//라긴안된경우

					if (userID == null) {

				%>

				

				<%

					} else {

				%>

				
				</ul>

				<%

					}

				%>

			</div>

		</nav>

		<!-- 게시판 -->

		<div class="container">

			<div class="row">

				<table class="table table-striped"

					style="text-align: center; border: 1px solid #dddddd">

					<thead>

						<tr>
							<th style="background-color: #eeeeee; text-align: center;"></th>
							
							

							<th style="background-color: #eeeeee; text-align: center;">제목</th>

							

						</tr>

					</thead>

					<tbody>

						<%

							MoviesDAO MoviesDAO = new MoviesDAO();

							ArrayList<Movies> list = MoviesDAO.getList(pageNumber);

							for (int i = 0; i < list.size(); i++) {
							
						%>

						<tr>
							<td>
							<a href="<%=list.get(i).getLink()%>" target="_blank">
							<img src="<%=list.get(i).getimage()%>" width=150 height=150 ><a></td>
							
							<td><a href="<%=list.get(i).getLink()%>" ><%=list.get(i).gettitle()%> </a></td>
							
							
						<!--<%=list.get(i).getimage()%>-->

						</tr>

	

						<%

							}

						%>

	

					</tbody>

				</table>

				<!-- 페이지 넘기기 -->

				<%

					if (pageNumber != 1) {

				%>

				<a href="Movie.jsp?pageNumber=<%=pageNumber - 1%>"

					class="btn btn-success btn-arrow-left">이전</a>

				<%

					}

					if (MoviesDAO.nextPage(pageNumber+1)) {

				%>

				<a href="Movie.jsp?pageNumber=<%=pageNumber + 1%>"

					class="btn btn-success btn-arrow-left">다음</a>

				<%

					}

				%>

	

	

				<!-- 회원만넘어가도록 -->

				<%

					//if logined userID라는 변수에 해당 아이디가 담기고 if not null

					if (session.getAttribute("userID") != null) {

				%>

				

				<%

					} else {

				%>


				<%

					}

				%>

	

			</div>

		</div>

	

	

	

	

		<!-- 애니매이션 담당 JQUERY -->

		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

		<!-- 부트스트랩 JS  -->

		<script src="js/bootstrap.js"></script>

	

	</body>

	</html>

