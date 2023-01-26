CREATE TABLE visitor(
    id SERIAL NOT NULL UNIQUE,
    full_name VARCHAR(1000) NOT NULL UNIQUE,
    password VARCHAR(1000) NOT NULL CHECK(LENGTH(password) > 0),
    is_active BOOLEAN NOT NULL,
    PRIMARY KEY (id, full_name)
)