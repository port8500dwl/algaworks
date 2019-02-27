drop table if exists TB_PACIENTE;

/*==============================================================*/
/* Table: TB_PACIENTE                                           */
/*==============================================================*/
create table TB_PACIENTE
(
   ID                   Integer(10) not null auto_increment,
   STR_NUMERO_PROTOCOLO varchar(50) not null,
   DAT_CADASTRO         datetime,
   STR_ATIVO            numeric(1,0),
   primary key (ID)
);

alter table TB_PACIENTE add constraint FK_PESSOA_PACIENTE foreign key (ID)
      references TB_PESSOA (ID) on delete restrict on update restrict;
