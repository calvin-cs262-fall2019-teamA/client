
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
		profPicture bytea,
		showPicture boolean,
		phoneNum varchar(15) NOT NULL,
		showPhoneNum boolean);

--create a listener 
CREATE TABLE listener(
		personID integer REFERENCES Person(ID),
		iscounselor boolean); --to check if they are peer or conselor

-- create a patient
CREATE TABLE patient(
		personID integer REFERENCES Person(ID));

--create a group chat
CREATE TABLE groupChat(
		ID integer PRIMARY KEY,
		isPublic boolean,
		name varchar(50) NOT NULL,
		description varchar(100));

--create a person group chat link
CREATE TABLE personGroupChatLink(
		personID integer REFERENCES Person(ID),
		groupChatID integer REFERENCES groupChat(ID));

-- create a group event
CREATE TABLE groupEvent(
		ID integer PRIMARY KEY,
		name varchar(50) NOT NULL,
		description varchar(100),
		location varchar(50) NOT NULL,
		aDate date NOT NULL,
		aTime time NOT NULL
		);

--crate an appointment 
CREATE TABLE appointment(
		ID integer PRIMARY KEY,
		personID integer REFERENCES Person(ID),
		location varchar(50) NOT NULL,
		aDate date NOT NULL,
		aTime time NOT NULL
		);

--allow users to select data from table
GRANT SELECT ON Person TO PUBLIC;
GRANT SELECT ON listener TO PUBLIC;
GRANT SELECT ON patient TO PUBLIC;
GRANT SELECT ON groupChat TO PUBLIC;
GRANT SELECT ON personGroupChatLink TO PUBLIC;
GRANT SELECT ON groupEvent TO PUBLIC;
GRANT SELECT ON appointment TO PUBLIC;

-- insert to person: ID, email, name, password, showName, profleDescription, profPic, showPic, phoneNum, showPhoneNum
INSERT INTO Person VALUES(1, 'sam@gmail.com', 'Sam', '12345', FALSE, 'I want to talk to people', 'profpic.png',  FALSE, '616-616-6161', FALSE); 
INSERT INTO Person VALUES(2, 'sambridhi@gmail.com', 'Sebrina', '12345', TRUE, 'I want to fo to group ebents', 'profpic.png',  FALSE, '616-616-6161', FALSE); 
INSERT INTO Person VALUES(3, 'samsam@gmail.com', 'Hellen', '12345', FALSE, 'I am not sure', 'profpic.png',  TRUE, '616-555-6161', TRUE); 
INSERT INTO Person VALUES(4, 'sam123@gmail.com', 'John', '12345', TRUE, 'I like having conversation', 'profpic.png',  TRUE, '616-345-6161', FALSE); 
INSERT INTO Person VALUES(5, 'sam321@gmail.com', 'Jonhnathan', '12345', FALSE, 'I want to talk to people', 'profpic.png',  FALSE, '616-754-6161', FALSE); 
INSERT INTO Person VALUES(6, 'sam11@gmail.com', 'Vanderbee', '12345', TRUE, 'No description', 'profpic.png',  TRUE, '616-235-6161', TRUE); 
INSERT INTO Person VALUES(7, 'sam10@gmail.com', 'Devries', '12345', FALSE, NULL , 'profpic.png',  FALSE, '616-754-6161', FALSE); 

-- insert into listener: personID, iscounselor
INSERT INTO listener VALUES(1, TRUE);
INSERT INTO listener VALUES(2, FALSE);
INSERT INTO listener VALUES(3, FALSE);
INSERT INTO listener VALUES(3, FALSE);
INSERT INTO listener VALUES(3, FALSE);

--insert into patient: personID
INSERT INTO patient VALUES(3);
INSERT INTO patient VALUES(4);
INSERT INTO patient VALUES(5);
INSERT INTO patient VALUES(6);

--insert into group chat: ID, isPublic, name, description
INSERT INTO groupChat VALUES(1, TRUE, 'Chat1', 'I am good at listening.');
INSERT INTO groupChat VALUES(2, TRUE, 'Chat2', 'I am good having conversation.');
INSERT INTO groupChat VALUES(3, FALSE, 'Chat3', 'I am a good listener');
INSERT INTO groupChat VALUES(4, FALSE, 'Chat4', 'I like talking to people');

--insert into personGroupChatLink: personID, groupChatID
INSERT INTO personGroupChatLink VALUES(1,2);
INSERT INTO personGroupChatLink VALUES(2,3);
INSERT INTO personGroupChatLink VALUES(1,4);
INSERT INTO personGroupChatLink VALUES(3,4);

--insert into groupEvents: ID, name, description, location, aDate, aTime
INSERT INTO groupEvent VALUES(1,'Hellen','An event for serniors', 'SC320', '12/12/2000', '1:00:00');
INSERT INTO groupEvent VALUES(2,'Alem', 'An event for juniors','SC330', '12/13/2000', '2:00:00');
INSERT INTO groupEvent VALUES(3,'John', 'An event for college students','SC 331', '12/10/2000', '3:00:00');
INSERT INTO groupEvent VALUES(4,'Vanderbee', 'An event everybody','SC221', '1/1/2000', '4:00:00');

--insert into appointment: ID, personID, location, aDate, aTime
INSERT INTO appointment VALUES(1,2, 'SC221', '12/12/2000', '1:00:00');
INSERT INTO appointment VALUES(2,3, 'SC331', '1/12/2000', '2:00:00');
INSERT INTO appointment VALUES(3,4, 'SC331', '1/12/2000', '3:00:00');
INSERT INTO appointment VALUES(4,1, 'SC220', '5/12/2000', '4:00:00');

SELECT name FROM Person
WHERE showName = TRUE;

SELECT password FROM Person
WHERE name = 'Sebrina';


SELECT name FROM groupChat 
WHERE isPublic = TRUE;

