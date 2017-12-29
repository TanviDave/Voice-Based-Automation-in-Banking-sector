<%@page import="com.vo.LoanVo"%>
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



<form:form action="updateLoan.htm" modelAttribute="lvo">
<table border=1px style="border-collapse: collapse;" cellpadding="4">
<tr><th>LoanId</th><th>LoanType</th><th>LoanDescription</th><th colspan="2">Action</th></tr>

<c:forEach items="${sessionScope.list}" var="l3">
<c:choose>
<c:when test="${l3.loanId eq sessionScope.editLoanList.loanId}">
<tr>
	<td><form:input type="text" value="${sessionScope.editLoanList.loanId}" name="loanId" path="loanId"/></td>
	<td><form:input type="text" value="${sessionScope.editLoanList.lType}" name="lType" path="lType"/></td>
	<td><form:input type="text" value="${sessionScope.editLoanList.lDesc}" name="lDesc" path="lDesc"/></td>
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>
			<tr>
				<td>${l3.loanId}</td>
				<td>${l3.lType}</td>
				<td>${l3.lDesc}</td>
				<td><a href="deleteLoan.htm?id=${l3.loanId}">Delete</a></td>
				<td><a href="editLoan.htm?id=${l3.loanId}">Edit</a></td>
			</tr>
</c:otherwise></c:choose>

		</c:forEach>
</table>
</form:form>

</body>
</html>