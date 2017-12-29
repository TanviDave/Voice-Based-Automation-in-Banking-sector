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
<form:form action="updateStaff.htm" modelAttribute="sfvo">
<table border=1px style="border-collapse: collapse;">
<tr><th>StaffId</th><th>FirstName</th><th>LastName</th><th>ContactNo</th><th>EmailId</th><th>Password</th><th>ConfirmPassword</th><th>BranchId</th><th>PostId</th><th colspan="2">Action</th></tr>

<c:forEach items="${sessionScope.staffList1}" var="l3">

<c:choose>
<c:when test="${l3.staff_id eq sessionScope.editStaffList.staff_id}">
<tr>
	<td>${sessionScope.editStaffList.staff_id}<form:input type="hidden" value="${sessionScope.editStaffList.staff_id}" name="staff_id" path="staff_id"/></td>
	<td><form:input type="text" value="${sessionScope.editStaffList.firstName}" name="firstName" path="firstName"/></td>
	<td><form:input type="text" value="${sessionScope.editStaffList.lastName}" name="lastName" path="lastName"/></td>
	<td><form:input type="text" value="${sessionScope.editStaffList.contactNo}" name="contactNo" path="contactNo"/></td>
	<td><form:input type="text" value="${sessionScope.editStaffList.email_id}" name="email_id" path="email_id"/></td>
	<td><form:input type="text" value="${sessionScope.editStaffList.password}" name="password" path="password"/></td>
	<td><form:input type="text" value="${sessionScope.editStaffList.c_password}" name="c_password" path="c_password"/></td>
	<td>${sessionScope.editStaffList.branchId.branchName}<form:input type="hidden" value="${sessionScope.editStaffList.branchId.branchId}" name="branchId" path="branchId.branchId"/></td>
	<td>${sessionScope.editStaffList.postId.pType}<form:input type="hidden" value="${sessionScope.editStaffList.postId.postId}" name="postId" path="postId.postId"/></td>
	
	
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>
			<tr>
				<td>${l3.staff_id}</td>
				<td>${l3.firstName}</td>
				<td>${l3.lastName}</td>
				<td>${l3.contactNo}</td>
				<td>${l3.email_id}</td>
				<td>${l3.password}</td>
				<td>${l3.c_Password}</td>
				<td>${l3.branchId.branchName}</td>
				<td>${l3.postId.pType}</td>
				<td><a href="deleteStaff.htm?id=${l3.staff_id}">Delete</a></td>
				<td><a href="editStaff.htm?id=${l3.staff_id}">Edit</a></td>
			</tr>

</c:otherwise>
</c:choose>
		</c:forEach>
</table>
</form:form>
</body>
</html>