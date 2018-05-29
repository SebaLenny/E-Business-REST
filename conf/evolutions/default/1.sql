# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  id                            integer auto_increment not null,
  link                          varchar(255),
  name                          varchar(255),
  price                         float,
  description                   varchar(255),
  picture                       varchar(255),
  constraint pk_product primary key (id)
);


# --- !Downs

drop table if exists product;

