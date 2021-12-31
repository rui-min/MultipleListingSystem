create table property(
id        bigint         not null           primary key,
address   varchar(300) not null,
price     int          not null
);

create table residential(
id             bigint            not null        primary key,
noParkingSpace int,
noStorage      int,
storageType    varchar(50),
entryDate      date not null,
buildDate      date,
constraint r_fk_id foreign key (id) references property(id)
		              on delete cascade    on update cascade
);

create table freehold(
id           bigint          not null        primary key,
familyType	 varchar(50)	 Default null,
isMultiGen	 boolean		 Default null,
houseType	 varchar(50)     not null,
constraint fh_fk_id foreign key (id) references property(id)
		              on delete cascade    on update cascade
);

