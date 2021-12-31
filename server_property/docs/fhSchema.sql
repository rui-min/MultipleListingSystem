create table VacationHome(
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
 -- freehold
familyType	     varchar(50)	 Default null, -- single family/ multifamily
floors           int             Default 1,
isMultiGen	     boolean		 Default null
);

create table SemiDetached(
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
 -- freehold
familyType	     varchar(50)	 Default null, -- single family/ multifamily
floors           int             Default 1,
isMultiGen	     boolean		 Default null
);

create table FarmHouse(
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
 -- freehold
familyType	     varchar(50)	 Default null, -- single family/ multifamily
floors           int             Default 1,
isMultiGen	     boolean		 Default null
);

create table TownHouse(
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
 -- freehold
familyType	     varchar(50)	 Default null, -- single family/ multifamily
floors           int             Default 1,
isMultiGen	     boolean		 Default null
);

create table DetachedHome(
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
 -- freehold
familyType	     varchar(50)	 Default null, -- single family/ multifamily
floors           int             Default 1,
isMultiGen	     boolean		 Default null
);

create table Multilex(
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
 -- freehold
familyType	     varchar(50)	 Default null, -- single family/ multifamily
floors           int             Default 1,
isMultiGen	     boolean		 Default null,
-- multilex
units            int             Default 2
);
