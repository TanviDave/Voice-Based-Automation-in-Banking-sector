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
<form:form action="updateLoanRate.htm" modelAttribute="lrvo">
<table border=1px style="border-collapse: collapse;" cellpadding="4">
<tr><th>LoanRateId</th><th>LoanType</th><th>LoanRate</th><th colspan="2">Action</th></tr>

<c:forEach items="${sessionScope.loanRateList1}" var="lr">
<c:choose>
<c:when test="${lr.loanRateId eq sessionScope.editLoanRateList.loanRateId}">
<tr>
	<td>${sessionScope.editLoanRateList.loanRateId}<form:input type="hidden" value="${sessionScope.editLoanRateList.loanRateId}" name="loanRateId" path="loanRateId"/></td>
	<td>${sessionScope.editLoanRateList.loanType.lType}<form:input type="hidden" value="${sessionScope.editLoanRateList.loanType.loanId}" name="loanType" path="loanType.loanId"/></td>
	<td><form:input type="text" value="${sessionScope.editLoanRateList.loanRate}" name="loanRate" path="loanRate"/></td>
	<td colspan="2"><input type="submit" value="update"></td>
</tr>
</c:when>
<c:otherwise>
			<tr>
				<td>${lr.loanRateId}</td>
				<td>${lr.loanType.lType}</td>
				<td>${lr.loanRate}</td>
				<td><a href="deleteLoanRate.htm?loanRateId=${lr.loanRateId}">Delete</a></td>
				<td><a href="editLoanRate.htm?loanRateId=${lr.loanRateId}">Edit</a></td>
			</tr>
</c:otherwise>
</c:choose>

		</c:forEach>
</table>
</form:form>

</body>
</html>