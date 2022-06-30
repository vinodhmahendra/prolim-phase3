drop table if exists todos;

create table todos ( id bigint auto_increment,username varchar(45),description varchar(45),target_date datetime,is_done boolean,primary key(id));