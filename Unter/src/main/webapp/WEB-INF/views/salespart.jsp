<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
<h3>Sales Parts List</h3>
<c:if test="${!empty listsalesparts}">
	<table class="table table-inverse">
		<thead>
		<tr>
			<th width="80">Address ID</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${listsalesparts}" var="salespart">
				<tr>
					<td>${salesparts.salesPartNo}</td>
					<td/>
					<td/>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
</div>
</body>
</html>