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
		<h3>Site List</h3>
		<c:if test="${!empty listSites}">
			<table class="table table-inverse">
				<thead>
				<tr>
					<th width="80">Site ID</th>
					<th width="120">Address ID</th>
					<th width="120">Phone no 1</th>
					<th width="120">Phone no 2</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${listSites}" var="site">
						<tr>
							<td>${site.siteId}</td>
							<td>${site.addressId}</td>
							<td>${site.phoneNo1}</td>
							<td>${site.phoneNo2}</td>
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