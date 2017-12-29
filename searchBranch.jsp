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
<form:form action="updateBranch.htm" modelAttribute="bvo">
<table border=1px style="border-collapse: collapse;" cellpadding="4">
<tr><th>BranchId</th><th>BranchName</th><th>State</th><th>City</th><th>Area</th><th colspan="2">Action</th></tr>
<c:forEach items="${sessionScope.branchList1}" var="b">
<c:choose>
<c:when test="${b.branchId eq sessionScope.editBranchList.branchId}">
<tr>
	<td>${sessionScope.editBranchList.branchId}<form:input type="hidden" value="${sessionScope.editBranchList.branchId}" name="branchId" path="branchId"/></td>
	<td><form:input type="text" value="${sessionScope.editBranchList.branchName}" name="branchName" path="branchName"/></td>
	<td>${sessionScope.editBranchList.stateId.stateName}<form:input type="hidden" value="${sessionScope.editBranchList.stateId.stateId}" name="state" path="stateId.stateId"/></td>
	<td>${sessionScope.editBranchList.cityId.cityName}<form:input type="hidden" value="${sessionScope.editBranchList.cityId.cityId}" name="city" path="cityId.cityId"/></td>
	<td>${sessionScope.editBranchList.areaId.areaName}<form:input type="hidden" value="${sessionScope.editBranchList.areaId.areaId}" name="area" path="areaId.areaId"/></td>
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>

			<tr>
				<td>${b.branchId}</td>
				<td>${b.branchName}</td>
				<td>${b.stateId.stateName}</td>
				<td>${b.cityId.cityName}</td>
				<td>${b.areaId.areaName}</td>
				<td><a href="deleteBranch.htm?branchId=${b.branchId}">Delete</a></td>
				<td><a href="editBranch.htm?branchId=${b.branchId}">Edit</a></td>
			</tr>

</c:otherwise>
</c:choose>

</c:forEach>		
</table>
</form:form>

</body>
</html>