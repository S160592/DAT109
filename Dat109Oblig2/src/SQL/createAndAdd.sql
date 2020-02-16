
drop table if exists public.reservasjon;
drop table if exists public.bil;
drop table if exists public.biltype;
drop table if exists public.kunde;
DROP TABLE IF exists public.utleigekontor;
DROP TABLE IF EXISTS public.adress;





CREATE TABLE public.biltype (
	typeid char(1) NOT NULL,
	description text NULL,
	CONSTRAINT biltype_pk PRIMARY KEY (typeid)
);

CREATE TABLE public.adress (
	id serial,
	gateadresse varchar(50) NOT NULL,
	postnummer varchar(4) NOT NULL,
	poststed varchar(50) NOT NULL,
	CONSTRAINT adress_pk PRIMARY KEY (id)
);

CREATE TABLE public.utleigekontor (
	id serial,
	telefonnr varchar(8) NOT NULL,
	adresse int4 NOT null,
	
	CONSTRAINT utleigekontor_pk PRIMARY KEY (id),
	CONSTRAINT utleigekontor_fk FOREIGN KEY (adresse) REFERENCES public.adress (id)
	
);





CREATE TABLE public.bil (
	regnr varchar(8) NOT NULL,
	typeid varchar(1) NOT NULL,
	staarVed int4,
	CONSTRAINT bil_pk PRIMARY KEY (regnr),
	CONSTRAINT bil_fk FOREIGN KEY (typeid) REFERENCES public.biltype(typeid),
	CONSTRAINT bil_utleigefk FOREIGN KEY (staarVed) REFERENCES public.utleigekontor(id)
);


CREATE TABLE public.kunde (
	fornavn varchar(50) NOT NULL,
	etternavn varchar(50) NOT NULL,
	adresse int4 NOT NULL,
	telefonnummer varchar(8) NULL,
	CONSTRAINT kunde_pk PRIMARY KEY (telefonnummer),
	CONSTRAINT kunde_fk FOREIGN KEY (adresse) REFERENCES public.adress(id)
);


CREATE TABLE public.reservasjon (
	reservasjonsid serial,
	fradato text ,
	tildato text ,
	bil varchar(8),
	kunde varchar(8) ,
	fralokasjon int4 not null,
	tillokasjon int4 not null,
	kmstandut integer not null,
	kmstandinn integer ,
	CONSTRAINT reservasjon_pk PRIMARY KEY (reservasjonsid),
	CONSTRAINT reservasjon_fk FOREIGN KEY (kunde) REFERENCES public.kunde(telefonnummer),
	CONSTRAINT reservasjon_fk_1 FOREIGN KEY (fralokasjon) REFERENCES public.utleigekontor(id),
	CONSTRAINT reservasjon_fk_2 FOREIGN KEY (tillokasjon) REFERENCES public.utleigekontor(id) deferrable,
	CONSTRAINT reservasjon_fk_3 FOREIGN KEY (bil) REFERENCES public.bil(regnr)
	
	);

INSERT INTO public.adress
(gateadresse, postnummer, poststed)
VALUES('Stykkje 6B', '6809', 'Førde'),
('Avsølevegen', '6856', 'Sogndal')
;


INSERT INTO public.utleigekontor
(telefonnr, adresse)
VALUES('81549300', 1),
('80012345', 2);

INSERT INTO public.biltype
(typeid, description)
VALUES('A', 'Liten bil'),
('B', 'Mellomstor bil'),
('C', 'Stor bil'),
('D', 'Stasjonsvogn');


INSERT INTO public.bil
(regnr, typeid, staarved)
VALUES('UC31787', 'A', 1),
('KH51737', 'A', 2);



INSERT INTO public.kunde
(fornavn, etternavn, adresse, telefonnummer)
VALUES('Borgar', 'Grande', 1, '81548300');


INSERT INTO public.reservasjon
(fradato, tildato, bil, kunde, fralokasjon, tillokasjon, kmstandut, kmstandinn)
VALUES('', '', 'UC31787', '81548300', 1, 2, 0, 0);


