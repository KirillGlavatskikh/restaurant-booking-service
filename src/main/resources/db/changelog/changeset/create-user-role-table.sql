CREATE TABLE user_role(
    visitor_id SERIAL NOT NULL REFERENCES visitor(id),
    role VARCHAR NOT NULL
)