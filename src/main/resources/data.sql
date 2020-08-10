DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS route;
DROP TABLE IF EXISTS route_point;

CREATE TABLE user (
  id            BIGINT AUTO_INCREMENT   PRIMARY KEY,
  name          VARCHAR(100)            NOT NULL,
  email         VARCHAR(100)            NOT NULL
);

CREATE TABLE route (
  id            BIGINT AUTO_INCREMENT   PRIMARY KEY,
  code          VARCHAR(100)            NOT NULL,
  name          VARCHAR(100)            NOT NULL
);

CREATE TABLE route_point (
  id            BIGINT AUTO_INCREMENT   PRIMARY KEY,
  number        BIGINT AUTO_INCREMENT   NOT NULL,
  route_id      VARCHAR(100)            NOT NULL,
  lat           DECIMAL                 NOT NULL,
  lng           DECIMAL                 NOT NULL
);