drop table if exists TB_USUARIO;

/*==============================================================*/
/* Table: TB_USUARIO                                            */
/*==============================================================*/
create table TB_USUARIO
(
   ID                   Integer(10) not null auto_increment,
   TIPO_USUARIO_ID      Integer(10) not null,
   STR_LOGIN            varchar(50) not null,
   STR_SENHA            varchar(50),
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table TB_USUARIO add constraint FK_PESSOA_SUARIO foreign key (ID)
      references TB_PESSOA (ID) on delete cascade on update cascade;

alter table TB_USUARIO add constraint FK_TIPO_USUARIO_USUARIO foreign key (TIPO_USUARIO_ID)
      references TB_TIPO_USUARIO (ID) on delete cascade on update cascade;
