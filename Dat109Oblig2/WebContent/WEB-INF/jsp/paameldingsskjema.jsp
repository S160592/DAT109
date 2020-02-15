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
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<c:choose>
					<c:when test="${feilmeldingFornavn==true}">
						<label for="fornavn">Fornavn:</label>
						<input id="fornavn" type="text" name="fornavn" value="" />
						<font id="feilmeldingFornavn" color="red">Ugyldig fornavn</font>
					</c:when>
					<c:otherwise>
						<label for="fornavn">Fornavn:</label>
						<input id="fornavn" type="text" name="fornavn"
							value="${verdiar.fornavn}" />
					</c:otherwise>
				</c:choose>

			</div>
			<div class="pure-control-group">

				<c:choose>
					<c:when test="${feilmeldingEtternavn==true}">
						<label for="etternavn">Etternavn:</label>
						<input id="etternavn" type="text" name="etternavn" value="" />
						<font id="feilmeldingEtternavn" color="red">Ugyldig
							etternavn</font>
					</c:when>
					<c:otherwise>
						<label for="etternavn">Etternavn:</label>
						<input id="etternavn" type="text" name="etternavn"
							value="${verdiar.etternavn}" />
					</c:otherwise>
				</c:choose>

			</div>
			<div class="pure-control-group">

				<c:choose>
					<c:when test="${feilmeldingMobil==true}">
						<label for="mobil">Mobil (8 siffer):</label>
						<input id="mobil" type="text" name="mobil" value="" />
						<font id="feilmeldingMobil" color="red">Ugyldig mobil</font>
					</c:when>
					<c:otherwise>
						<label for="mobil">Mobil (8 siffer):</label>
						<input id="mobil" type="text" name="mobil"
							value="${verdiar.mobilnr}" />
					</c:otherwise>
				</c:choose>

			</div>
			<div class="pure-control-group">

				<c:choose>
					<c:when test="${feilmeldingPassord==true}">
						<label for="password">Passord:</label>
						<input id="password" type="password" name="passord" value="" />
						<font id="feilmeldingPassord" color="red">Ugyldig passord</font>
					</c:when>
					<c:otherwise>
						<label for="password">Passord:</label>
						<input id="password" type="password" name="passord"
							value="${verdiar.passord}" />
					</c:otherwise>
				</c:choose>

			</div>
			<div class="pure-control-group">

				<c:choose>
					<c:when test="${feilmeldingPassordRepetert==true}">
						<label for="passordRepetert">Passord repetert:</label>
						<input id="passordRepetert" type="password" name="passordRepetert"
							value="" />
						<font id="feilmeldingPassordRepetert" color="red">Passordene
							må være like</font>
					</c:when>
					<c:when test="${feilmeldingPassord==true}">
						<label for="passordRepetert">Passord repetert:</label>
						<input id="passordRepetert" type="password" name="passordRepetert"
							value="" />
						<font id="feilmeldingPassordRepetert" color="red">Passordene
							må være like</font>
					</c:when>
					<c:otherwise>
						<label for="passordRepetert">Passord repetert:</label>
						<input id="passordRepetert" type="password" name="passordRepetert"
							value="${verdiar.passord}" />
					</c:otherwise>
				</c:choose>

			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label>

				<c:choose>
					<c:when test="${feilmeldingKjonn==true}">
						<input id="kjonn" type="radio" name="kjonn" value="mann"/> Mann 
						<input id="kjonn" type="radio" name="kjonn" value="kvinne"/> Kvinne
						<font id="feilmeldingKjonn" color="red">Du må oppgi kjonn</font>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${verdiar.kjonn=='mann'}">
								<input id="kjonn" type="radio" name="kjonn" value="mann" checked="checked" /> Mann 
								<input id="kjonn" type="radio" name="kjonn" value="kvinne" /> Kvinne
							</c:when>
							<c:when test="${verdiar.kjonn=='kvinne'}">
								<input id="kjonn" type="radio" name="kjonn" value="mann"/> Mann 
								<input id="kjonn" type="radio" name="kjonn" value="kvinne" checked="checked" /> Kvinne
							</c:when>
							<c:otherwise>
								<input id="kjonn" type="radio" name="kjonn" value="mann"/> Mann 
								<input id="kjonn" type="radio" name="kjonn" value="kvinne"/> Kvinne
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>

			</div>
			<div class="pure-controls">
				<button id="knappPaamelding" type="submit"
					class="pure-button pure-button-primary">Meld meg på</button>
			</div>
		</fieldset>
	</form>
	<script src="javascript/DeltagerValidering.js" charset="utf-8" defer></script>
</body>
</html>