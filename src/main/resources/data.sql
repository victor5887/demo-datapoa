DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id            BIGINT AUTO_INCREMENT   PRIMARY KEY,
  name          VARCHAR(100)            NOT NULL,
  email         VARCHAR(100)            NOT NULL
);