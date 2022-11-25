use tacocloud2;
IF NOT EXISTS (
    SELECT * FROM sys.tables t 
    JOIN sys.schemas s ON (t.schema_id = s.schema_id) 
    WHERE s.name = 'dbo' AND t.name = 'Ingredient') 
	create table dbo.Ingredient (
	  id varchar(4) not null,
	  name varchar(25) not null,
	  type varchar(10) not null,
	  PRIMARY KEY (id)
	);
go
IF NOT EXISTS (
    SELECT * FROM sys.tables t 
    JOIN sys.schemas s ON (t.schema_id = s.schema_id) 
    WHERE s.name = 'dbo' AND t.name = 'Taco') 
	create table dbo.Taco 
	(
	  id int IDENTITY(1,1) NOT NULL,
	  name varchar(50) not null,
	  createdAt datetime not null,
	  PRIMARY KEY (id)
	); 
go
IF NOT EXISTS (
    SELECT * FROM sys.tables t 
    JOIN sys.schemas s ON (t.schema_id = s.schema_id) 
    WHERE s.name = 'dbo' AND t.name = 'Taco_Ingredients') 
	create table dbo.Taco_Ingredients (
	  taco int not null,
	  ingredient varchar(4) not null,
	  FOREIGN KEY (taco) REFERENCES Taco(id),
	  FOREIGN KEY (ingredient) REFERENCES Ingredient(id)
	);
go
IF NOT EXISTS (
    SELECT * FROM sys.tables t 
    JOIN sys.schemas s ON (t.schema_id = s.schema_id) 
    WHERE s.name = 'dbo' AND t.name = 'Taco_Order') 
	create table dbo.Taco_Order (
		id int IDENTITY(1,1) NOT NULL,
		name varchar(50) not null,
		street varchar(50) not null,
		city varchar(50) not null,
		state varchar(2) not null,
		zip varchar(10) not null,
		ccNumber varchar(16) not null,
		ccExpiration varchar(5) not null,
		ccCVV varchar(3) not null,
		placedAt datetime not null,
		PRIMARY KEY (id)
	);
go
IF NOT EXISTS (
    SELECT * FROM sys.tables t 
    JOIN sys.schemas s ON (t.schema_id = s.schema_id) 
    WHERE s.name = 'dbo' AND t.name = 'Taco_Order_Tacos') 
	create table dbo.Taco_Order_Tacos (
	  tacoOrder int not null,
	  taco int not null,
	  FOREIGN KEY (tacoOrder) REFERENCES Taco_Order(id),
	  FOREIGN KEY (taco) REFERENCES Taco(id)
	); 
go
delete from dbo.Taco_Order_Tacos;
delete from dbo.Taco_Ingredients;
delete from dbo.Taco;
delete from dbo.Taco_Order;
delete from dbo.Ingredient;
go
insert into dbo.Ingredient (id, name, type)
                values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into dbo.Ingredient (id, name, type)
                values ('COTO', 'Corn Tortilla', 'WRAP');
insert into dbo.Ingredient (id, name, type)
                values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into dbo.Ingredient (id, name, type)
                values ('CARN', 'Carnitas', 'PROTEIN');
insert into dbo.Ingredient (id, name, type)
                values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into dbo.Ingredient (id, name, type)
                values ('LETC', 'Lettuce', 'VEGGIES');
insert into dbo.Ingredient (id, name, type)
                values ('CHED', 'Cheddar', 'CHEESE');
insert into dbo.Ingredient (id, name, type)
                values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into dbo.Ingredient (id, name, type)
                values ('SLSA', 'Salsa', 'SAUCE');
insert into dbo.Ingredient (id, name, type)
				values ('SRCR', 'Sour Cream', 'SAUCE'); 
go

