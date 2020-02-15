<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">

			<th>Kjønn</th>

			<th align="left">Navn</th>

			<th align="left">Mobil</th>

		</tr>
		<c:forEach var="deltakar" items="${deltakarar}" varStatus="loop">

			<tr bgcolor="#ffffff">
				<c:choose>
					<c:when test="${innloggaMobilnr==deltakar.mobilnr}">
						<tr bgcolor="#aaffaa">
					</c:when>
					<c:otherwise>
						<tr bgcolor="#ffffff">
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${deltakar.kjonn=='mann'}">
						<td align="center">&#9794;</td>
					</c:when>
					<c:otherwise>
						<td align="center">&#9792;</td>
					</c:otherwise>
				</c:choose>

				<td>${deltakar.fornavn} ${deltakar.etternavn}</td>
				<td>${deltakar.mobilnr}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="Ferdig" method="post">
		<button type="submit" class="btn-link">Ferdig</button>
	</form>

</body>
</html>