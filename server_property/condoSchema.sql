create table Condo(
-- property 
id               bigint          not null        primary key,
address          varchar(300)    not null,
price            int             not null,
-- residential
noParkingSpace   int             default 0,
noStorage        int             default 0,
storageType      varchar(50)     default "Unknown",
entryDate        date            not null,
buildDate        date,
 -- condominium
unit_No           varchar(50)    not null
);

create table StackedTownHouse(
-- property 
id               bigint          not null        primary key,
address          varchar(300)    not null,
price            int             not null,
-- residential
noParkingSpace   int             default 0,
noStorage        int             default 0,
storageType      varchar(50)     default "Unknown",
entryDate        date            not null,
buildDate        date,
 -- condominium
unit_No           varchar(50)    not null
);

create table TripleDeckers(
-- property 
id               bigint          not null        primary key,
address          varchar(300)    not null,
price            int             not null,
-- residential
noParkingSpace   int             default 0,
noStorage        int             default 0,
storageType      varchar(50)     default "Unknown",
entryDate        date            not null,
buildDate        date,
 -- condominium
unit_No           varchar(50)    not null
);