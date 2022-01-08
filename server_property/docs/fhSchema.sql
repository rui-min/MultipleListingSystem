CREATE TABLE VacationHome(
-- property 
id                BIGINT          NOT NULL        AUTO_INCREMENT,
address           VARCHAR(300)    NOT NULL,
price             INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- freehold
family_type	     VARCHAR(50)	     DEFAULT NULL, -- single family/ multifamily
floors           INT                 DEFAULT 1,
is_multi_gen	 BOOLEAN			 DEFAULT NULL,
PRIMARY KEY (id)
);

CREATE TABLE SemiDetached(
-- property 
id               BIGINT          NOT NULL        PRIMARY KEY     AUTO_INCREMENT,
address          VARCHAR(300)    NOT NULL,
price            INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- freehold
family_type	     VARCHAR(50)	     DEFAULT NULL, -- single family/ multifamily
floors           INT                 DEFAULT 1,
is_multi_gen	 BOOLEAN		     DEFAULT NULL
);

CREATE TABLE FarmHouse(
-- property 
id               BIGINT          NOT NULL        PRIMARY KEY  AUTO_INCREMENT,
address          VARCHAR(300)    NOT NULL,
price            INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- freehold
family_type	     VARCHAR(50)	     DEFAULT NULL, -- single family/ multifamily
floors           INT                 DEFAULT 1,
is_multi_gen	 BOOLEAN		     DEFAULT NULL
);

CREATE TABLE TownHouse(
-- property 
id               BIGINT          NOT NULL        PRIMARY KEY  AUTO_INCREMENT,
address          VARCHAR(300)    NOT NULL,
price            INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- freehold
family_type	     VARCHAR(50)	     DEFAULT NULL, -- single family/ multifamily
floors           INT                 DEFAULT 1,
is_multi_gen	 BOOLEAN		     DEFAULT NULL
);

CREATE TABLE DetachedHome(
-- property 
id               BIGINT          NOT NULL        PRIMARY KEY      AUTO_INCREMENT,
address          VARCHAR(300)    NOT NULL,
price            INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- freehold
family_type	     VARCHAR(50)	     DEFAULT NULL, -- single family/ multifamily
floors           INT                 DEFAULT 1,
is_multi_gen	 BOOLEAN		     DEFAULT NULL
);

CREATE TABLE Multilex(
-- property 
id               BIGINT          NOT NULL        PRIMARY KEY      AUTO_INCREMENT,
address          VARCHAR(300)    NOT NULL,
price            INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- freehold
family_type	     VARCHAR(50)	     DEFAULT NULL, -- single family/ multifamily
floors           INT                 DEFAULT 1,
is_multi_gen	 BOOLEAN		     DEFAULT NULL,
-- multilex
units            INT             DEFAULT 2
);
