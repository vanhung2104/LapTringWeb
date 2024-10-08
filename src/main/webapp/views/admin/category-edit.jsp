<%@ page language="java" contentType="text/html; charset=UTF-8"


pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>



<form action="<c:url value='/admin/category/edit'></c:url>" method="post"


enctype="multipart/form-data">


<input type="text" id="categoryid" name="categoryid" hidden="hidden" value="${cate.categoryid}"><br>


<label for="fname">Category name:</label><br>


<input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>


<label for="lname">Images:</label><br>


<c:if test="${cate.image.substring(0 , 5)=='https'}">


<c:url value="${cate.image}" var="imgUrl"></c:url>


</c:if>


<c:if test="${cate.image.substring(0 , 5)!='https'}">


<c:url value="/image?fname=${cate.image }" var="imgUrl"></c:url>


</c:if>


<img id="imagess" height="150" width="200" src="${imgUrl}" />


<input type="file" onchange="chooseFile(this)" id="images" name="images" value="${cate.image}">


<p>Status:</p>


  <input type="radio" id="ston" name="status" value="1" ${cate.status==1?'checked':'' } >


  <label for="html">Đang hoạt động</label><br>


  <input type="radio" id="stoff" name="status" value="0" ${cate.status!=1?'checked':'' }>


  <label for="css">Khóa</label><br>


<input type="submit" value="Update">


</form>