create table esm.EMPLOYEE (
   employee_id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   department  VARCHAR(30) NOT NULL,
   PRIMARY KEY (employee_id)
);
  
create table SKILL(
   skill_id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   PRIMARY KEY (skill_id)
);
  


CREATE TABLE EMPLOYEE_SKILL (
    employee_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id , skill_id),
    CONSTRAINT FK_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES EMPLOYEE (employee_id),
    CONSTRAINT FK_SKILL FOREIGN KEY (skill_id) REFERENCES SKILL (skill_id)
);
