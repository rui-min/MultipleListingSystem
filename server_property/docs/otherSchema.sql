create table CooperativeHome(
-- property 
id               bigint          not null        primary key,
address          varchar(300)    not null,
price            int             not null,
-- residential
noParkingSpace   int,
noStorage        int,
storageType      varchar(50),
entryDate        date            not null,
buildDate        date
);

create table MobileHome(
-- property 
id               bigint          not null        primary key,
address          varchar(300)    not null,
price            int             not null,
-- residential
noParkingSpace   int,
noStorage        int,
storageType      varchar(50),
entryDate        date            not null,
buildDate        date
);

create table Land(
-- property 
id               bigint          not null        primary key,
address          varchar(300)    not null,
price            int             not null
)