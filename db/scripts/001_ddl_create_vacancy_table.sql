create table vacancy (
   id serial primary key,
   title varchar(255),
   description text,
   createDate timestamp,
   visible boolean,
   cityId int
);