drop table if exists TB_TIPO_USUARIO;

/*==============================================================*/
/* Table: TB_TIPO_USUARIO                                       */
/*==============================================================*/
create table TB_TIPO_USUARIO
(
   ID                   Integer(10) not null auto_increment,
   STR_NOME             varchar(50),
   STR_DESCRICAO        varchar(60),
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
);