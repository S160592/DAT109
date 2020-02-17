drop table if exists borgar.faktura;

drop table if exists borgar.reservasjon;

drop table if exists borgar.bil;

drop table if exists borgar.biltype;

drop table if exists borgar.kunde;

drop table if exists borgar.utleigekontor;

drop table if exists borgar.adress;

create table borgar.biltype ( typeid char(1) not null,
description text null,
dagspris integer not null,
constraint biltype_pk primary key (typeid) );

create table borgar.adress ( id serial,
gateadresse varchar(50) not null,
postnummer varchar(4) not null,
poststed varchar(50) not null,
constraint adress_pk primary key (id) );

create table borgar.utleigekontor ( id serial,
telefonnr varchar(8) not null,
adresse int4 not null,
constraint utleigekontor_pk primary key (id),
constraint utleigekontor_fk foreign key (adresse) references borgar.adress (id) );

create table borgar.bil ( regnr varchar(8) not null,
typeid varchar(1) not null,
merke varchar(20) not null,
staarVed int4,
farge varchar not null,
constraint bil_pk primary key (regnr),
constraint bil_fk foreign key (typeid) references borgar.biltype(typeid),
constraint bil_utleigefk foreign key (staarVed) references borgar.utleigekontor(id) );

create table borgar.kunde ( fornavn varchar(50) not null,
etternavn varchar(50) not null,
adresse int4 not null,
telefonnummer varchar(8) null,
kredittkortnr varchar(16) null,
constraint kunde_pk primary key (telefonnummer),
constraint kunde_fk foreign key (adresse) references borgar.adress(id) );

create table borgar.reservasjon ( reservasjonsid serial,
fradato timestamp ,
tildato timestamp ,
bil varchar(8) not null,
kunde varchar(8) not null,
fralokasjon int4 not null,
tillokasjon int4 not null,
kmstandut integer not null,
kmstandinn integer ,
constraint reservasjon_pk primary key (reservasjonsid),
constraint reservasjon_fk foreign key (kunde) references borgar.kunde(telefonnummer),
constraint reservasjon_fk_1 foreign key (fralokasjon) references borgar.utleigekontor(id),
constraint reservasjon_fk_2 foreign key (tillokasjon) references borgar.utleigekontor(id) deferrable,
constraint reservasjon_fk_3 foreign key (bil) references borgar.bil(regnr) );

create table borgar.faktura ( fakturanr serial not null,
reservasjon int4 not null,
constraint db_faktura_pk primary key (fakturanr),
constraint db_faktura_fk foreign key (reservasjon) references borgar.reservasjon(reservasjonsid) );

insert
	into
	borgar.adress (gateadresse,
	postnummer,
	poststed)
values('Stykkje 6B',
'6809',
'Førde'),
('Avsølevegen',
'6856',
'Sogndal') ;

insert
	into
	borgar.utleigekontor (telefonnr,
	adresse)
values('81549300',
1),
('80012345',
2);

insert
	into
	borgar.biltype (typeid,
	description,
	dagspris)
values('A',
'Liten bil',
1000),
('B',
'Mellomstor bil',
1200),
('C',
'Stor bil',
1350),
('D',
'Stasjonsvogn',
1550);

insert
	into
	borgar.bil (regnr,
	typeid,
	staarved,
	merke,
	farge)
values('UC31787',
'A',
1,
'Kia',
'svart'),
('KH51979',
'A',
2,
'Skoda',
'kvit'),
('AB11111',
'C',
2,
'VW',
'Blå'),
('AB22222',
'B',
1,
'Kia',
'Gul');

insert
	into
	borgar.kunde (fornavn,
	etternavn,
	adresse,
	telefonnummer,
	kredittkortnr)
values('Borgar',
'Grande',
1,
'81548300','');

insert
	into
	borgar.reservasjon (
	bil,
	kunde,
	fralokasjon,
	tillokasjon,
	kmstandut,
	kmstandinn)
values(

'UC31787',
'81548300',
1,
2,
0,
0);
