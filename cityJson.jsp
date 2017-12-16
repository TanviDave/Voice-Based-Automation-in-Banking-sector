<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
[
{"cityId":0,
"cityName":"select"
}
<c:forEach items="${sessionScope.citylist}" var="i">
,{"cityId":"${i.cityId}",
"cityName":"${i.cityName}"
}
</c:forEach> 

]