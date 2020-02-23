<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Sok etter bil</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">

<style>
html, body {
	min-height: 100%;
}

body, div, form, input, select, p {
	padding: 0;
	margin: 0;
	outline: none;
	font-family: Roboto, Arial, sans-serif;
	font-size: 16px;
	color: #eee;
	width: -webkit-fill-available;
}

body {
	background: url("image/background.jpg") no-repeat center;
	background-size: cover;
}

h1, h2 {
	text-transform: uppercase;
	font-weight: 400;
}

h2 {
	margin: 0 0 0 8px;
}

.main-block {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100%;
	padding: 25px;
	background: rgba(0, 0, 0, 0.5);
}

.left-part, form {
	padding: 25px;
}

.left-part {
	text-align: center;
}

.fa-graduation-cap {
	font-size: 72px;
}

form {
	background: rgba(0, 0, 0, 0.7);
}

.title {
	display: flex;
	align-items: center;
	margin-bottom: 20px;
}

.info {
	display: flex;
	flex-direction: column;
}

input, select {
	padding: 5px;
	margin-bottom: 30px;
	background: transparent;
	border: none;
	border-bottom: 1px solid #eee;
}

input::placeholder {
	color: #eee;
}

option:focus {
	border: none;
}

option {
	background: black;
	border: none;
}

.checkbox input {
	margin: 0 10px 0 0;
	vertical-align: middle;
}

.checkbox a {
	color: #26a9e0;
}

.checkbox a:hover {
	color: #85d6de;
}

.btn-item, button {
	padding: 10px 5px;
	margin-top: 20px;
	border-radius: 5px;
	border: none;
	background: #26a9e0;
	text-decoration: none;
	font-size: 15px;
	font-weight: 400;
	color: #fff;
}

.btn-item {
	display: inline-block;
	margin: 20px 5px 0;
}

button {
	width: 100%;
}

button:hover, .btn-item:hover {
	background: #85d6de;
}

@media ( min-width : 568px) {
	html, body {
		height: 100%;
	}
	.main-block {
		flex-direction: row;
		height: calc(100% - 50px);
	}
	.left-part, form {
		flex: 1;
		height: auto;
	}
}
</style>
</head>
<body>
	<div class="main-block">
		<div class="left-part">
			<i class="fas fa-car fa-6"></i>
			<h1>Bilutleige A/S</h1>
			<div class="btn-group">
				<a class="btn-item" href="Utleige">Registrer utleige</a> <a
					class="btn-item" href="Innlevering">Regisrer innlevering</a>
			</div>
		</div>
		<form action="sok" method="post">
			<div class="title">
				<i class="fas fa-pencil-alt"></i>
				<h2>Søk etter ledig bil</h2>
			</div>
			<div class="info">
				<div id="fraDato">
					<label>Fra dato : </label> <input type="date" id="start" name="trip-start"
						>
				</div>

				<div id="fraDato">
					<label>Til dato : </label> <input type="date" id="start" name="trip-end"
						>
				</div>

				<div id="fraDato">
					<label>Fra lokasjon : </label> <select id=fraLokasjon name="fraLokasjon">
						<option value="1" selected>Førde</option>
						<option value="2">Sogndal</option>



					</select>
				</div>


				<div id="fraDato">
					<label>Til lokasjon : </label> <select id="tilLokasjon" name="tilLokasjon">
						<option value="1" selected>Førde</option>
						<option value="2">Sogndal</option>



					</select>

				</div>

				<div id="fraDato">
					<label>Biltype : </label> <select id="biltype" name="biltype">
						<option value="A" selected>Liten bil</option>
						<option value="B">Mellomstor bil</option>
						<option value="C">Stor bil</option>
						<option value="D">Stasjonsvogn</option>
					</select>
				</div>
			</div>
			<div class="checkbox">
				<input type="checkbox" name="checkbox"><span>I agree
					to the stupid agreement</span>
			</div>
			<button type="submit" href="/">Søk</button>
		</form>
	</div>
</body>
</html>