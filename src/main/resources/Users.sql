use tacocloud2;
create table Users(
	username varchar(50) not null primary key,
	password varchar(500) not null,
	enabled bit not null
);

create table Authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

insert into dbo.Users (username, password, enabled) values ('yoko', 'littner', 1);

insert into dbo.Authorities (username, authority) values ('yoko', 'ROLE_USER');