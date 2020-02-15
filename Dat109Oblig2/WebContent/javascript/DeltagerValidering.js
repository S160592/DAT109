"use strict";
// NB! Mykje av dette kan ein gjere direkte i HTML.
// Hent alle element
let inputFornavn = document.getElementById("fornavn");
let inputEtternavn = document.getElementById("etternavn");
let inputMobil = document.getElementById("mobil");
let inputPassword = document.getElementById("password");
let inputPasswordConfirm = document.getElementById("passordRepetert");
let inputKjonn = document.getElementsByName("kjonn");

let knappPaamelding = document.getElementById("knappPaamelding");


// Legg til hjelpetekst på tekstfelta
inputFornavn.title = "Legg inn fornavn";
inputEtternavn.title = "Legg inn etternavn";
inputMobil.title = "Legg inn mobilnr";
inputPassword.title = "Password must contain: \n- an uppercase letter \n- a number \n- a haiku \n- a gang sign \n- a hieroglyph \n- and the blood of a virgin. \nEventuelt berre vera på over 15 tegn."
inputPasswordConfirm.title = "Passorder må stå i samvar med passordet ovanfor";

// Avgjere om "Meld meg på" skal vera aktiv
let validFornavn = false;
let validEtternavn = false;
let validMobil = false;
let validPassord = false;
let validPassordRepeter = false;
let validKjonn = false;

// Tar sett knappen til ikkje aktiv
knappPaamelding.disabled = true;
inputMobil.maxLength = 8;	


// Sett opp lytter for endring
inputFornavn.addEventListener("input", checkInputFornavn);
inputEtternavn.addEventListener("input", checkInputEtternavn);
inputMobil.addEventListener("input", checkMobile);
inputPasswordConfirm.addEventListener("input", checkPasswords);
inputPassword.addEventListener("input", checkInputPassword);





// legg til lytter på kjønn
for (var i = 0, length = inputKjonn.length; i < length; i++)	{
	inputKjonn[i].addEventListener("change", event => {
		 validKjonn = true;
		 checkValid();
	});
}



function checkInputFornavn(){
	if (inputFornavn.value.length > 2 && inputFornavn.value.length < 23 ){
		inputFornavn.style.backgroundColor = "SpringGreen";
		validFornavn = true;	
	}else {
		validFornavn = false;
		inputFornavn.style.backgroundColor = "Salmon";
		knappPaamelding.disabled = true	
	}
	checkValid();
}

function checkInputPassword(){
	if (inputPassword.value.length > 3){
		validPassord = true;
		inputPassword.style.backgroundColor = "SpringGreen";
	}else {
		validPassord = false;
		inputPassword.style.backgroundColor = "Salmon";
	}
	checkPasswords();
	checkValid();
}



function checkInputEtternavn(){
	if (inputEtternavn.value.length > 2){
		inputEtternavn.style.backgroundColor = "SpringGreen";
		validEtternavn = true;
	}else {
		validEtternavn = false;
		inputEtternavn.style.backgroundColor = "Salmon";

		knappPaamelding.disabled = true	
	}
	checkValid();
}


function checkMobile(){
	if (inputMobil.value.length === 8 &&  !isNaN(inputMobil.value)){
		inputMobil.style.backgroundColor = "SpringGreen";
		validMobil = true;
	}else {
		validMobil = false;
		inputMobil.style.backgroundColor = "Salmon";
		
	}
	checkValid();
}

	
	



function checkPasswords(){
	if (inputPasswordConfirm.value === inputPassword.value){
		validPassordRepeter = true;
		inputPasswordConfirm.style.backgroundColor = "SpringGreen";
	}else {
		validPassordRepeter = false;
		inputPasswordConfirm.style.backgroundColor = "Salmon";
	}
	
	checkValid();
}


	
	

function check(){
	if(inputFornavn.value.length > 0){
		checkInputFornavn();
	}
	if(inputEtternavn.value.length > 0){
		checkInputEtternavn();	
	}
	if(inputMobil.value.length > 0){
		checkMobile();
	}
	if(inputPassword.value.length > 0){
		checkPasswords();
	}
	if(inputPasswordConfirm.value.length > 0){
		checkInputPassword();
	}
	
	for (var i = 0, length = inputKjonn.length; i < length; i++)	{
		console.log(inputKjonn[i].checked);
		if (inputKjonn[i].checked){
			 validKjonn = true;
		}
	}

	

}

// Sjekker om skjema er ok
function checkValid(){
	check
	if (validKjonn && validFornavn && validEtternavn && validMobil && validPassord && validPassordRepeter){
		knappPaamelding.disabled = false;
	}else {
		knappPaamelding.disabled = true;
	}	
}

document.addEventListener("DOMContentLoaded", check);