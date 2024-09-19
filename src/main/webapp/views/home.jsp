<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.account == null}">
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li><a href="${pageContext.request.contextPath }/login">Login </a>
							| <a href="${pageContext.request.contextPath }/register">Register </a>
								<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li> <p>Xin chào ${sessionScope.account.fullname}
						| <a href="${pageContext.request.contextPath }/logout">Logout </a>
						</p>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>


</body>
</html>