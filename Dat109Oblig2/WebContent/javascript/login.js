"use strict";
 // Hent forskjellige element ein har nytte av
let inputPassword = document.getElementById("inputPassword");
let inputPhone = document.getElementById("inputPhone");
let knapp = document.getElementById("knapp");

// Lag variablar som skal avgjera om ein kan nytte "logg inn" knappen eller ikkje
let passordOK = false;
let brukarnavnOK = false;

// Sett "logg inn"-knappen til disabled ettersom input er tomt når sida lasar
knapp.disabled = true;

// Legg til hjelpetekst for aktuelle felt. 
// NB! Dette kunne ein også gjort i .jsp-fila. Hjelpeteksten ville då fungert for dei som køyrer nettlesaren med javascript avslått.
inputPhone.title = "Legg inn mobilnr";
inputPassword.title = "Password must contain: \n- an uppercase letter \n- a number \n- a haiku \n- a gang sign \n- a hieroglyph \n- and the blood of a virgin. \nEventuelt berre vera på over 15 tegn."
inputPhone.maxLength = 8;	

// event for input på inputPhone
inputPhone.addEventListener("input", event => {
	
	if (inputPhone.value.length === 8 &&  !isNaN(inputPhone.value)){
		
		inputPhone.style.backgroundColor = "SpringGreen";
		brukarnavnOK = true;
		if (passordOK){
			knapp.disabled = false
		}
	}else {
		brukarnavnOK = false;
		inputPhone.style.backgroundColor = "Salmon";
		knapp.disabled = true
	}
});

// event for input på inputPhone
inputPassword.addEventListener("input", event => {
	
	if (inputPassword.value.length > 3){
		inputPassword.style.backgroundColor = "SpringGreen";
		passordOK = true;
		if(brukarnavnOK){
			knapp.disabled = false;
		}
	}else {
		passordOK = false;
		inputPassword.style.backgroundColor = "Salmon";
		knapp.disabled = true
	}

});