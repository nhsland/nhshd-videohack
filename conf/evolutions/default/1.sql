# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table appointment (
  id                        bigint not null,
  patient                   varchar(255),
  start                     varchar(255),
  end                       varchar(255),
  title                     varchar(255),
  body                      varchar(255),
  status                    varchar(255),
  email                     varchar(255),
  meeting_id                varchar(255),
  constraint pk_appointment primary key (id))
;

create table user (
  id                        bigint not null,
  email                     varchar(255),
  constraint pk_user primary key (id))
;

create sequence appointment_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists appointment;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists appointment_seq;

drop sequence if exists user_seq;

