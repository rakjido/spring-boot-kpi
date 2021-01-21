drop table if exists period cascade;
drop table if exists task cascade;

    create table task (
       task_id bigint not null auto_increment,
        complexity_status integer,
        impact_status integer,
        is_finished bit,
        remarks varchar(255),
        task_name varchar(255),
        task_type varchar(255),
        period_id bigint,
        primary key (task_id)
    );

CREATE TABLE PERIOD (
       PERIOD_ID BIGINT NOT NULL AUTO_INCREMENT,
        FROM_DATE DATE,
        TO_DATE DATE,
        PRIMARY KEY (PERIOD_ID)
    );

flush privileges;

alter table task
   add constraint task_constraint
   foreign key (PERIOD_ID)
   references PERIOD (PERIOD_ID);

alter table task
       add index task_index (task_id);

alter table period
       add index period_index (period_id);

