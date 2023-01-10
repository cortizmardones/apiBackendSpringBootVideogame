
############ SCRIPT PARA GENERAR TABLAS ############ 

CREATE TABLE `db_videogame_system`.`categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `descripcion`  VARCHAR(255) NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE INDEX `id_categoria_UNIQUE` (`id_categoria` ASC) VISIBLE);

CREATE TABLE `db_videogame_system`.`videogame` (
  `id_videogame` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `precio` DECIMAL(6,1) NULL,
  `id_Categoria` INT NOT NULL ,
  PRIMARY KEY (`id_videogame`),
  UNIQUE INDEX `id_videogame_UNIQUE` (`id_videogame` ASC) VISIBLE,
  foreign key (id_categoria) references categoria(id_Categoria) on delete cascade on update cascade);

############ SCRIPT PARA CARGAR DATOS A LAS TABLAS ############ 

insert into categoria values (null,"Aventura" , "");
insert into categoria values (null,"Survival Horror" , "");
insert into categoria values (null,"RPG" , "");

insert into videogame values (null,"Zelda: Breath Of The Wild" , 49999.9,1);
insert into videogame values (null,"Animal Crossing: New Horizons" , 56999.9,1);
insert into videogame values (null,"Red Dead Redemption 2" , 19990.9,1);


############ QUERYS PARA OPERAR DATA ############ 

use db_videogame_system;

select * from videogame;
select * from categoria;

ALTER TABLE categoria DROP COLUMN id;

DELETE FROM videogame WHERE id_videogame = 12;

UPDATE videogame
SET nombre ='Zelda: Breath Of The Wild' WHERE id_videogame = 1;


