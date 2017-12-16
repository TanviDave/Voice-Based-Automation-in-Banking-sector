<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
[
{"areaId":0,
"areaName":"select"
}
<c:forEach items="${sessionScope.arealist}" var="i">
,{"areaId":"${i.areaId}",
"areaName":"${i.areaName}"
}
</c:forEach> 

]