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
<form:form action="updateCity.htm" modelAttribute="cvo">
<table border=1px style="border-collapse: collapse;" cellpadding="4">
<tr><th>CityId</th><th>CityName</th><th>State</th><th colspan="2">Action</th></tr>
<c:forEach items="${sessionScope.cityList1}" var="c">
<c:choose>
<c:when test="${c.cityId eq sessionScope.editCityList.cityId}">
<tr>
	<td>${sessionScope.editCityList.cityId}<form:input type="hidden" value="${sessionScope.editCityList.cityId}" name="cityId" path="cityId"/></td>
	<td><form:input type="text" value="${sessionScope.editCityList.cityName}" name="cityName" path="cityName"/></td>
	<td>${sessionScope.editCityList.stateId.stateName}<form:input type="hidden" value="${sessionScope.editCityList.stateId.stateId}" name="state" path="stateId.stateId"/></td>
	
	
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>

			<tr>
				<td>${c.cityId}</td>
				<td>${c.cityName}</td>
				<td>${c.stateId.stateName}</td>
				
				<td><a href="deleteCity.htm?cityId=${c.cityId}">Delete</a></td>
				<td><a href="editCity.htm?cityId=${c.cityId}">Edit</a></td>
			</tr>

</c:otherwise>
</c:choose>
		</c:forEach>
</table>

</form:form>
</body>
</html>