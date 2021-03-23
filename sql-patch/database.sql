DROP DATABASE IF EXISTS woc_covid;
CREATE DATABASE woc_covid;
USE woc_covid;

CREATE TABLE state (
  id int(11) NOT NULL AUTO_INCREMENT,
  state_code varchar(255) NOT NULL UNIQUE,
  state_name varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL UNIQUE,
  name varchar(255) NOT NULL,
  mobile bigint(20) DEFAULT NULL,
  login_id varchar(255) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  created_date datetime(6) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE covid_case (
  id int(11) NOT NULL AUTO_INCREMENT,
  state_id int(11) DEFAULT NULL,
  total_cases int(11) DEFAULT NULL,
  active_cases int(11) DEFAULT NULL,
  recover_cases int(11) DEFAULT NULL,
  death_cases int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_covid_cases_state_id (state_id),
  CONSTRAINT fk_covid_cases_state_id FOREIGN KEY (state_id) REFERENCES state (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;