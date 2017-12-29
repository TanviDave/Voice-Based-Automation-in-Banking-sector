<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="updatePost.htm" modelAttribute="pvo">
<table border=1px style="border-collapse: collapse;">
<tr><th>PostId</th><th>PostType</th><th>PostDescription</th><th colspan="2">Action</th></tr>

<c:forEach items="${sessionScope.postList1}" var="l3">
<c:choose>
<c:when test="${l3.postId eq sessionScope.editPostList.postId}">
<tr>
	<td>${sessionScope.editPostList.postId}<form:input type="hidden" value="${sessionScope.editPostList.postId}" name="postId" path="postId"/></td>
	<td><form:input type="text" value="${sessionScope.editPostList.pType}" name="pType" path="pType"/></td>
	<td><form:input type="text" value="${sessionScope.editPostList.pDesc}" name="pDesc" path="pDesc"/></td>
	
	
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>
			<tr>
				<td>${l3.postId}</td>
				<td>${l3.pType}</td>
				<td>${l3.pDesc}</td>
				<td><a href="deletePost.htm?id=${l3.postId}">Delete</a></td>
				<td><a href="editPost.htm?id=${l3.postId}">Edit</a></td>
			</tr>
</c:otherwise>
</c:choose>

		</c:forEach>
</table>
</form:form>

</body>
</html>