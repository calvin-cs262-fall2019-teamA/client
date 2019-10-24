
-- Drop previous versions of the tables if they they exist, in reverse order of foreign keys.
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS groupEvent;
DROP TABLE IF EXISTS personGroupChatLink;
DROP TABLE IF EXISTS groupChat;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS listener;
DROP TABLE IF EXISTS Person;

--create a table for person
CREATE TABLE Person(
		ID integer PRIMARY KEY,
		emailAddress varchar(50) NOT NULL,
		name varchar(50) NOT NULL,
		password varchar(50) NOT NULL,
		showName boolean,
		profleDescription varchar(100),
		profPicture varbinary(max),
		showPicture boolean,
		phoneNum varchar(15) NOT NULL,
		showPhoneNum boolean);

--create a listener 
CREATE TABLE listener(
		personID integer references Person(ID),
		iscounselor boolean); --to check if they are peer or conselor

CREATE TABLE patient(
		personID integer references Person(ID));

CREATE TABLE groupChat(
		ID integer PRIMARY KEY,
		isPublic boolean,
		name varchar(50) NOT NULL,
		description varchar(100));

CREATE TABLE personGroupChatLink(
		personID integer references Person(ID),
		gorupChatID integer references groupChatID(ID));

CREATE TABLE groupEvent(
		ID integer PRIMARY KEY,
		name varchar(50) NOT NULL,
		description varchar(100),
		location varchar(50) NOT NULL,
		aDate date NOT NULL,
		aTime time NOT NULL
		);

CREATE TABLE appointment(
		ID integer PRIMARY KEY,
		personID integer references Person(ID),
		personID integer references Person(ID),
		location varchar(50) NOT NULL,
		aDate date NOT NULL,
		aTime time NOT NULL
		);

GRANT SELECT ON Person TO PUBLIC;
GRANT SELECT ON listener TO PUBLIC;
GRANT SELECT ON patient TO PUBLIC;
GRANT SELECT ON groupChat TO PUBLIC;
GRANT SELECT ON personGroupChatLink TO PUBLIC;
GRANT SELECT ON groupEvent TO PUBLIC;
GRANT SELECT ON appointment TO PUBLIC;