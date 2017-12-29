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
<form:form action="updateArea.htm" modelAttribute="avo">
<table border=1px style="border-collapse: collapse;" cellpadding="4">
<tr><th>AreaId</th><th>AreaName</th><th>State</th><th>City</th><th colspan="2">Action</th></tr>
<c:forEach items="${sessionScope.areaList1}" var="a">
<c:choose>
<c:when test="${a.areaId eq sessionScope.editAreaList.areaId}">
<tr>
	<td>${sessionScope.editAreaList.areaId}<form:input type="hidden" value="${sessionScope.editAreaList.areaId}" name="areaId" path="areaId"/></td>
	<td><form:input type="text" value="${sessionScope.editAreaList.areaName}" name="areaName" path="areaName"/></td>
	<td>${sessionScope.editAreaList.stateId.stateName}<form:input type="hidden" value="${sessionScope.editAreaList.stateId.stateId}" name="state" path="stateId.stateId"/></td>
	<td>${sessionScope.editAreaList.cityId.cityName}<form:input type="hidden" value="${sessionScope.editAreaList.cityId.cityId}" name="city" path="cityId.cityId"/></td>
	
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>


			<tr>
				<td>${a.areaId}</td>
				<td>${a.areaName}</td>
				<td>${a.stateId.stateName}</td>
				<td>${a.cityId.cityName}</td>
				
				<td><a href="deleteArea.htm?areaId=${a.areaId}">Delete</a></td>
				<td><a href="editArea.htm?areaId=${a.areaId}">Edit</a></td>
			</tr>

</c:otherwise>
</c:choose>
		</c:forEach>
</table>

</form:form>
</body>
</html>