drop table if EXISTS PEOPLE ;
create table PEOPLE(
  ID SERIAL PRIMARY KEY ,
  FIRST_NAME  varchar(255) not NULL,
  email VARCHAR (255)  null,
  age INT NULL );