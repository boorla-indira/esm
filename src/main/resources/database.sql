/*
 * drop all the tables if there any
 */
drop table EMPLOYEE_SKILL;
drop table SKILL;
drop table EMPLOYEE;

/*
 * drop all the tables if there any
 */
create table EMPLOYEE (
   employee_id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   department  VARCHAR(30) NOT NULL,
   PRIMARY KEY (employee_id)
);
  
create table SKILL(
   skill_id BIGINT NOT NULL AUTO_INCREMENT,
   SKILLNAME VARCHAR(30) NOT NULL,
   PRIMARY KEY (skill_id)
);


CREATE TABLE EMPLOYEE_SKILL (
    employee_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id , skill_id),
    CONSTRAINT FK_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES EMPLOYEE (employee_id),
    CONSTRAINT FK_SKILL FOREIGN KEY (skill_id) REFERENCES SKILL (skill_id)
);

/* Insert Required Skills */
insert into SKILL values(1,'Project Management');
insert into SKILL values(2,'Estimation');
insert into SKILL values(3,'DevOps');
insert into SKILL values(4,'Java');

select * from skill;
select * from employee;
select * from employee_skill;



/*
to delete entries from tables
*/
/* first delete relationships */
/*
delete from employee_skill; 
delete from employee;
delete from skill;
*/

