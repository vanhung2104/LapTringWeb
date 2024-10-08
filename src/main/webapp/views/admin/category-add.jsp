<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp"%>

<form action="<c:url value="/admin/category/insert"/>" method="post" enctype="multipart/form-data">
	<label for="fname">Category Name:</label><br> 
	<input type="text" id="categoryname" name="categoryname"><br> 
	<label for="lname">Link Image:</label><br> 
	<input type="text" id="image" name="image"><br> 
	
	<label for="lname">Upload file:</label><br> 
	<input type="file" id="image1" name="image1"><br> 
	
	<label for="lname">Status:</label><br>
	<input type="radio" id="statuson" name="status" value = "1">
	<label for="lname">Hoạt động</label><br>
	<input type="radio" id = "statusoff" name="status" value = "0">
	<label for="lname">Khóa</label><br>
	<input type="submit" value="insert">
</form>
