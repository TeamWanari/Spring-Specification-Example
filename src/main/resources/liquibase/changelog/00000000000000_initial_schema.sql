CREATE TABLE sys_user (
  id         BIGSERIAL PRIMARY KEY    NOT NULL,
  email      VARCHAR(256)             NOT NULL,
  first_name VARCHAR(256)             NOT NULL,
  last_name  VARCHAR(256)             NOT NULL
);

INSERT INTO sys_user VALUES (1, 'example1@wanari.com', 'John', 'Doe');
INSERT INTO sys_user VALUES (2, 'example2@wanari.com', 'Jude', 'Cox');
INSERT INTO sys_user VALUES (3, 'example3@wanari.com', 'Logan', 'Brooks');
INSERT INTO sys_user VALUES (4, 'example4@wanari.com', 'Reece', 'Holmes');
INSERT INTO sys_user VALUES (5, 'example5@wanari.com', 'Billy', 'Cook');

CREATE TABLE address (
  id      BIGSERIAL PRIMARY KEY    NOT NULL,
  user_id BIGSERIAL                NOT NULL REFERENCES sys_user (id),
  zip     INT8                     NOT NULL,
  street  VARCHAR(255)             NOT NULL,
  city    VARCHAR(255)             NOT NULL
);

INSERT INTO address VALUES (1, 1, 1061, 'Paladino Gardens Northwest', 'Budapest');
INSERT INTO address VALUES (2, 1, 5423, 'East Sturbridge Garth', 'Budapest');
INSERT INTO address VALUES (3, 1, 3426, 'North Hycrest Walk', 'Budapest');
INSERT INTO address VALUES (4, 2, 5363, 'Little Lever', 'Budapest');
INSERT INTO address VALUES (5, 2, 2345, 'Demers Street', 'London');
INSERT INTO address VALUES (6, 2, 7786, 'South Skenes Street', 'London');
INSERT INTO address VALUES (7, 2, 8977, 'Woodvale Green', 'Budapest');
INSERT INTO address VALUES (8, 3, 7897, 'Crimmins Mews', 'Wien');
INSERT INTO address VALUES (9, 5, 7878, 'Turuga Bypass', 'Salt Lake City');
INSERT INTO address VALUES (10, 5, 8957, 'South Strawberry Canyon Garth', 'Sidney');
INSERT INTO address VALUES (11, 5, 5685, 'White Oak', 'Budapest');
INSERT INTO address VALUES (12, 5, 2346, 'East Summer Heights', 'Budapest');