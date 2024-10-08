<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglib.jsp"%>
<a href="<c:url value="/admin/category/add"/>">Add Category</a>
<table>
	<tr>
		<th>STT</th>
		<th>Images</th>
		<th>Category Name</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<tr>
		<c:forEach items="${cateList}" var="cate" varStatus="STT">
			<tr class="odd gradeX">
				<td>${STT.index+1 }</td>
				<c:if test="${cate.image.substring(0,5)=='https'}">
				<c:url value="${cate.image }" var="imgUrl"></c:url>
				</c:if>
				<c:if test="${cate.image.substring(0,5)!='https'}">
				<c:url value="/image?fname=${cate.image }" var="imgUrl"></c:url>
				</c:if>
				<td><img height="150" width="200" src="${imgUrl}" /></td>
				<td>${cate.categoryname }</td>
				<td>${cate.status}</td>
				<td><a
					href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>">
						Sửa</a> <a
					href="<c:url value='/admin/category/delete?id=${cate.categoryid }'/>">
						Xóa</a>
			</tr>
		</c:forEach>

	</tr>
</table>