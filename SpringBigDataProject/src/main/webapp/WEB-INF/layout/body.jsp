<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 
          <div id="extra">
						<div class="container">
							<div class="row no-collapse-1">
							   <c:forEach var="vo" items="${list }" varStatus="status">
							    <c:if test="${status.index<3 }">
								 <section class="4u"> <a href="#" class="image featured"><img src="${vo.poster }" width=150 height=180></a>
									<div class="box">
										<p style="font-size: 8pt">${vo.review }</p>
										<a href="#" class="button">상세보기</a> </div>
								 </section>
								</c:if>
							   </c:forEach>
							</div>
							<div class="row no-collapse-1">
							   <c:forEach var="vo" items="${list }" varStatus="status">
							    <c:if test="${status.index>=3 }">
								 <section class="4u"> <a href="#" class="image featured"><img src="${vo.poster }" width=150 height=180></a>
									<div class="box">
										<p style="font-size: 8pt">${vo.review }</p>
										<a href="#" class="button">상세보기</a> </div>
								 </section>
								</c:if>
							   </c:forEach>
							</div>
						</div>
					</div>

				<!-- Main -->
					<div id="main">
						<div class="container">
							<div class="row"> 
								
								<!-- Content -->
								<div class="6u">
									<section>
										<ul class="style">
											<li class="fa fa-wrench">
												<h3>알라딘</h3>
												<span>알라딘 주요 이벤트</span> 
										    </li>
											<li class="fa fa-leaf">
												<h3>교보서적</h3>
												<span>교보 서적 주요 이벤트</span> 
											</li>
										</ul>
									</section>
								</div>
								<div class="6u">
									<section>
										<ul class="style">
											<li class="fa fa-cogs">
												<h3>영풍문고</h3>
												<span>영풍문고 주요 이벤트</span> 
											</li>
											<li class="fa fa-road">
												<h3>반디앤루이스</h3>
												<span>반디앤루이스 주요 이벤트</span> 
											</li>
										</ul>
									</section>
								</div>
							</div>
						</div>
					</div>

	
</body>
</html>