<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Spring MVC - MVC Crud Operation (CRM)</h2>
			</div>
			
			<div id="container" style="align:center">
				<div id="content">
				
				<input type="button" value="Add Customer" 
				onclick="window.location.href='showAddCustomerForm'; return false;"
				class="add-button"/>
				
					<table>
						<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
						</tr>
						<c:forEach var="tempcustomer" items="${customers}">
							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/customer/showUpdateCustomerForm">
								<c:param name="customerId" value="${tempcustomer.id}" />
							</c:url>
							
							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/customer/deleteCustomer">
								<c:param name="customerId" value="${tempcustomer.id}" />
							</c:url>
							
							<tr>
								<td>${tempcustomer.firstName}</td>
								<td>${tempcustomer.lastName}</td>
								<td>${tempcustomer.email}</td>
								<td>
									<!-- display the update link -->
									<a href="${updateLink}">Update</a> |
									<!-- display the delete link -->
									<a href="${deleteLink}" onclick="if (!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
								</td>
								
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>