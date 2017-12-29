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
<form:form action="updateState.htm" modelAttribute="svo">
<table border=1px style="border-collapse: collapse;" cellpadding="4">
<tr><th>StateId</th><th>StateName</th><th colspan="2">Action</th></tr>
<c:forEach items="${sessionScope.stateList1}" var="s">
<c:choose>
<c:when test="${s.stateId eq sessionScope.editStateList.stateId}">
<tr>
	<td>${sessionScope.editStateList.stateId}<form:input type="hidden" value="${sessionScope.editStateList.stateId}" name="stateId" path="stateId"/></td>
	<td><form:input type="text" value="${sessionScope.editStateList.stateName}" name="stateName" path="stateName"/></td>
	
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>


			<tr>
				<td>${s.stateId}</td>
				<td>${s.stateName}</td>
				
				
				<td><a href="deleteState.htm?stateId=${s.stateId}">Delete</a></td>
				<td><a href="editState.htm?stateId=${s.stateId}">Edit</a></td>
			</tr>
</c:otherwise>
</c:choose>

		</c:forEach>
</table>
</form:form>

</body>
</html>