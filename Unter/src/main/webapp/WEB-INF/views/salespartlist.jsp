<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Insert title here</title>   
<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"
    rel="stylesheet">
</head> 
<body>

<div class="container">
<h3>Sales Part List</h3>
<c:if test="${!empty listSalesP}">
	<table class="table table-striped">
	<thead>
	<tr>
		<th width="80">Sales Part No</th>
		<th width="120">description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${listSalesP}" var="salesPart">
		<tr>
			<td>${salesPart.salesPartId}</td>
			<td>${salesPart.description}</td>
			<td/>
			<td/>
			<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
		</tr>
		</tbody>
	</c:forEach>
	</table>
</c:if>
</div>
<script src="webjars/jquery/3.1.0/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>