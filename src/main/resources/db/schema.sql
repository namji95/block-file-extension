drop table if exists fixed_extension cascade;

drop table if exists custom_extension cascade;

create table if not exists  fixed_extension
(
    id bigint auto_increment primary key,
    extension_name varchar(50) not null,
    bool boolean not null
);

create table if not exists  custom_extension
(
    id bigint auto_increment primary key,
    custom_extension_name varchar(50) not null
);