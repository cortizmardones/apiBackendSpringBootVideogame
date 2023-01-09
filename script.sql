
############ SCRIPT PARA GENERAR TABLAS ############ 

CREATE TABLE `db_videogame_system`.`categoria` (
  `id_Categoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `descripcion` VARCHAR(255) NULL,
  PRIMARY KEY (`id_Categoria`),
  UNIQUE INDEX `id_Categoria_UNIQUE` (`id_Categoria` ASC) VISIBLE);

use db_videogame_system;

select * from videogame;
select * from categoria;

ALTER TABLE categoria DROP COLUMN id;

insert into categoria values (null,"Aventura" , "");
insert into categoria values (null,"Survival Horror" , "");
insert into categoria values (null,"RPG" , "");

insert into videogame values (null,"Zelda: Breath Of The Wild" , 49999.9);
insert into videogame values (null,"Animal Crossing: New Horizons" , 56999.9);
insert into videogame values (null,"Red Dead Redemption 2" , 19990.9);

DELETE FROM videogame WHERE id_videogame = 12;

UPDATE videogame
SET nombre ='Zelda: Breath Of The Wild' WHERE id_videogame = 1;

## SQL (LENGUAJE ESTRUCTURADO DE CONSULTAS )

use entregable3;
select * from juego;

