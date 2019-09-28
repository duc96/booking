CREATE TABLE admin_user_session (
    user_id INT PRIMARY KEY IDENTITY (1, 1),
    password VARCHAR (600) not null,
    fullname VARCHAR (250) NOT NULL,
    address1 VARCHAR (250),
    address2 VARCHAR (250),
    city VARCHAR(100),
    country VARCHAR(100),
    zipcode VARCHAR(50),
    createby int,
    cretatedate DATETIME DEFAULT GETDATE(),
);

CREATE TABLE admin_user_session (
    session_id INT PRIMARY KEY IDENTITY (1, 1),
    user_id INT NOT NULL,
    token VARCHAR (250) NOT NULL,
    lastmodified DATETIME DEFAULT GETDATE(),
    cretatedate DATETIME DEFAULT GETDATE(),
    isdeleted int DEFAULT 0
);