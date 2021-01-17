https://www.techbeamers.com/sql-query-questions-answers-for-practice/

#database Important Concept

`create database school;`

`use school;`
`show databases;`
`show tables;`

`create table if not exists student
(
    student_name  varchar(30),
    student_id    int,
    mobile_number varchar(20)
);`

`alter table student
    add column country varchar(10) default 'India';`

`describe student;`

`select *
from student;`

`create table IF NOT EXISTS address
(
    id       int(10) unsigned auto_increment primary key,
    flat_no  varchar(10),
    street   varchar(20),
    reg_date timestamp default current_timestamp on update current_timestamp
);`

`describe address;`
`insert into address (flat_no, street, reg_date)
VALUES (34, 'Handi Kundi', now());`
`insert into address (flat_no, street, reg_date)
VALUES (34, 'Sankisa', now());`

`select *
from address;`

`truncate address;`


`create table IF NOT EXISTS todelete
(
    id       int(10) unsigned auto_increment primary key,
    flat_no  varchar(10),
    street   varchar(20),
    reg_date timestamp default current_timestamp on update current_timestamp
);`

`describe todelete;`
`drop TABLE todelete;`

`show tables;`

`delete
from address
where flat_no = 32;`
`select *
from address;`

`update address
set street='Acharauda panchayat'
where flat_no = 32;`

`select flat_no
from address
limit 1;`

`select *
from address
limit 1,2;`

select *
from address
order by flat_no desc;

show tables;

alter table todelete rename tododelete;
describe address;
create view house_no_view AS
SELECT flat_no
from address;

describe house_no_view;

select *
from house_no_view;

create procedure total_house_with_arg()
begin
    select count(*) from address;
end;

call total_house(4);

call total_house_with_arg();

create procedure find_street_name(in street_name int, out street_count int)
begin
    select count(*) from address where flat_no = street_name;
end;

call find_street_name(32, @street_count);

select @street_count;

#todo function creation
drop TABLE UNrepresentative;
show tables;

select *
from user;

create database org;
use org;
show databases;
show tables;

# drop table if exists Title;
# drop table if exists Bonus;
# drop table if exists Worker;
#

CREATE TABLE Worker
(
    WORKER_ID    INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME   CHAR(25),
    LAST_NAME    CHAR(25),
    SALARY       INT(15),
    JOINING_DATE DATETIME,
    DEPARTMENT   CHAR(25)
);

INSERT INTO Worker
    (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT)
VALUES (001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
       (002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
       (003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
       (004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
       (005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
       (006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
       (007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
       (008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');

CREATE TABLE Bonus
(
    WORKER_REF_ID INT,
    BONUS_AMOUNT  INT(10),
    BONUS_DATE    DATETIME,
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker (WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Bonus
    (WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE)
VALUES (001, 5000, '16-02-20'),
       (002, 3000, '16-06-11'),
       (003, 4000, '16-02-20'),
       (001, 4500, '16-02-20'),
       (002, 3500, '16-06-11');

CREATE TABLE Title
(
    WORKER_REF_ID INT,
    WORKER_TITLE  CHAR(25),
    AFFECTED_FROM DATETIME,
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker (WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Title
    (WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM)
VALUES (001, 'Manager', '2016-02-20 00:00:00'),
       (002, 'Executive', '2016-06-11 00:00:00'),
       (008, 'Executive', '2016-06-11 00:00:00'),
       (005, 'Manager', '2016-06-11 00:00:00'),
       (004, 'Asst. Manager', '2016-06-11 00:00:00'),
       (007, 'Executive', '2016-06-11 00:00:00'),
       (006, 'Lead', '2016-06-11 00:00:00'),
       (003, 'Lead', '2016-06-11 00:00:00');

show tables;

select *
from Worker;
select *
from Title;
select *
from Bonus;

#interview question on practice
select FIRST_NAME as Name
from Worker;
select upper(FIRST_NAME) as Name
from Worker;

select distinct DEPARTMENT
from Worker;

select substring(FIRST_NAME, 1, 2)
from Worker;

select INSTR(FIRST_NAME, binary 'a')
from Worker
where FIRST_NAME = 'Amitabh';
#Remove whitespace from right side
select RTRIM(FIRST_NAME)
from Worker;

select LTRIM(FIRST_NAME)
from Worker;

select distinct length(DEPARTMENT)
from Worker;

select replace(FIRST_NAME, 'a', 'A')
from Worker;

select *
from Worker;

select concat(FIRST_NAME, ' ', LAST_NAME) as 'fullname'
from Worker;

select *
from Worker
order by FIRST_NAME desc;

select *
from Worker
where FIRST_NAME in ('Vipul', 'Satish');

select FIRST_NAME
from Worker
where FIRST_NAME not in ('Vipul', 'Satish');

select *
from Worker
where FIRST_NAME like '%a';
select *
from Worker
where FIRST_NAME like '%a%';
select *
from Worker
where DEPARTMENT like 'Admin%';

select *
from Worker
where FIRST_NAME like '______h';

select *
from Worker
where SALARY between 100000 and 500000;

select *
from Worker
where year(JOINING_DATE) = 2014
  and month(JOINING_DATE) = 2;

#Write an SQL query to fetch worker names with salaries >= 50000 and <= 100000.

select concat(FIRST_NAME, ' ', LAST_NAME) as FullName
from Worker
where WORKER_ID in (select WORKER_ID from Worker where SALARY between 100000 and 500000);

select DEPARTMENT, count(WORKER_ID) as No_of_Workers
from Worker
group by DEPARTMENT
order by No_of_Workers desc;

# Write an SQL query to print details of the Workers who are also Managers.

select W.FIRST_NAME, T.WORKER_TITLE
from Worker W
         join Title T on W.WORKER_ID = T.WORKER_REF_ID
    and T.WORKER_TITLE in ('Manager');

# Write an SQL query to fetch duplicate records having matching data in some fields of a

select WORKER_TITLE, AFFECTED_FROM, count(*)
from Title
group by WORKER_TITLE, AFFECTED_FROM
having count(*) > 1

# Write an SQL query to show only odd rows from a table.
select *
from Worker
where mod(WORKER_ID, 2) <> 0;

# Write an SQL query to show only even rows from a table.

select *
from Worker
where mod(WORKER_ID, 2) = 0;

# Write an SQL query to clone a new table from another table.

CREATE TABLE WorkerClone LIKE Worker;

# Write an SQL query to show the current date and time.

select current_time();
select current_date;
select now();

#Write an SQL query to show the top n (say 10) records of a table.

select *
from Worker
order by SALARY desc
limit 10;

select *
from Worker
order by SALARY desc;

# nth salary,  2nd largest salary

select *
from Worker
order by SALARY desc
limit 2,1;

# Write an SQL query to fetch the list of employees with the same salary.
select distinct W.WORKER_ID, W.FIRST_NAME, W.SALARY
from Worker W,
     Worker W1
where W.SALARY = W1.SALARY
  and W.WORKER_ID != W1.WORKER_ID;

# Write an SQL query to show the second highest salary from a table.


select max(SALARY)
from Worker
where SALARY not in (select max(SALARY) from Worker);

# Write an SQL query to fetch the first 50% records from a table.
select *
from Worker
where WORKER_ID <= (select count(WORKER_ID / 2) from Worker);

# Write an SQL query to fetch the names of workers who earn the highest salary.

select FIRST_NAME, SALARY
from Worker
where SALARY = (select max(SALARY) from Worker);

# Write an SQL query to fetch departments along with the total salaries paid for each of them.
select DEPARTMENT, sum(SALARY)
from Worker
group by DEPARTMENT;
