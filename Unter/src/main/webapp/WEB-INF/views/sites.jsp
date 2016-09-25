<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<script type="text/javascript">
function search() {
	document.getElementById("searchfield").value = "TRUE";
    document.getElementById("site").submit();
}
</script>
</head>
<body>
	<!-- ----------------------------Add Site------------------------------------ -->
	<h1>
		Add a Site
	</h1>
	<c:url var="addAction" value="/site/add" ></c:url>
	<form:form id="site" action="${addAction}" commandName="site">
		<table>
			<tr>
				<td>
					<form:label path="siteId">
						<spring:message text="Site ID"/>
					</form:label>
				</td>
				<td>
					<form:input path="siteId" />
				</td> 
				<td>
					<form:errors path="siteId" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="addressId">
						<spring:message text="Address ID"/>
					</form:label>
				</td>
				<td>
					<form:input path="addressId" />
				</td> 
			</tr>
			<tr>
				<td>
					<form:label path="phoneNo1">
						<spring:message text="Phone No 1"/>
					</form:label>
				</td>
				<td>
					<form:input path="phoneNo1" />
				</td>
				<td>
					<form:errors path="phoneNo1" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="phoneNo2">
						<spring:message text="Phone No 2"/>
					</form:label>
				</td>
				<td>
					<form:input path="phoneNo2" />
				</td>
				<td>
					<form:errors path="phoneNo2" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>
					<form:hidden path="objid"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="searchfield" id = "searchfield">
				</td>
			</tr>
			<tr>
				<td colspan="1">
					<!--<c:if test="${!empty site.siteId}">
						<input type="submit"
							value="<spring:message text="Edit Site"/>" />
					</c:if> -->
					<input type="submit"
							value="<spring:message text="Save"/>" />
					<button type="reset" value="Reset">Reset</button>
					 <input type="button" value="Search" onclick="search()"/> 
				</td>
			</tr>
		</table>	
	</form:form>
<br>
	<!-- ----------------------------List Sites---------------------------------- -->
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