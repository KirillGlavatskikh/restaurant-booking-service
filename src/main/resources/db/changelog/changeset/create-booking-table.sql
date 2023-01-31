CREATE TABLE booking(
    id                 SERIAL  NOT NULL UNIQUE,
    visitor_name       VARCHAR NOT NULL REFERENCES visitor (full_name) UNIQUE,
    establishment_name VARCHAR NOT NULL REFERENCES establishment (establishment_name),
    booking_time       TIME    NOT NULL,
    PRIMARY KEY (id, visitor_name)
)