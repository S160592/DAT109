<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p>Det er kun registrerte deltagere som får sjå deltagerlisten.</p>
	<div id="test">
		<p>

			<c:choose>
				<c:when test="${feilmelding==true}">
					<font id="feilmeldingFornavn" color="red">Ugyldig brukarnavn/passord</font>
				</c:when>
			</c:choose>




		</p>
	</div>
	
	<form action="index.html" method="post"
		class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="mobil">Mobil:</label> <input id="inputPhone" type="text"
					name="mobil" />
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input id="inputPassword"
					type="password" name="passord" />

			</div>
			<div class="pure-controls">
				<button id="knapp" type="submit"
					class="pure-button pure-button-primary">Logg inn</button>

			</div>
		</fieldset>
	</form>
	<button style="position:relative; left:175px; " class="pure-button pure-button-primary" 
	onclick="window.location.href = 'Paamelding';">Trykk her om du ikkje er påmeldt</button>
	<script src="javascript/login.js" charset="utf-8" defer></script>
</body>

</html>
