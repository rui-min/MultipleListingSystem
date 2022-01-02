CREATE TABLE Condo(
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
 -- condominium
unit_No           VARCHAR(50)    NOT NULL
);

CREATE TABLE StackedTownHouse(
-- property 
id               BIGINT          NOT NULL        PRIMARY KEY       AUTO_INCREMENT,
address          VARCHAR(300)    NOT NULL,
price            INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- condominium
unit_No           VARCHAR(50)    NOT NULL
);

CREATE TABLE TripleDeckers(
-- property 
id               BIGINT          NOT NULL        PRIMARY KEY         AUTO_INCREMENT,
address          VARCHAR(300)    NOT NULL,
price            INT             NOT NULL,
-- residential
no_parking_space  INT             DEFAULT 0,
no_storage        INT             DEFAULT 0,
storage_type      VARCHAR(50)     DEFAULT "Unknown",
entry_date        DATE            NOT NULL,
build_date        DATE,
 -- condominium
unit_No           VARCHAR(50)    NOT NULL
);
