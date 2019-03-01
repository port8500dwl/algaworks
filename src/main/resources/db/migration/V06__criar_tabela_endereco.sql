drop table if exists TB_ENDERECO;

/*==============================================================*/
/* Table: TB_ENDERECO                                           */
/*==============================================================*/
create table TB_ENDERECO
(
   ID                   Integer(10) not null auto_increment,
   UF_ID                Integer(10) not null,
   PESSO_ID             Integer(10) not null,
   STR_ENDERECO         varchar(150),
   STR_CEP              varchar(12),
   STR_BAIRRO           varchar(150),
   STR_NUMERO           varchar(10),
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
);

alter table TB_ENDERECO add constraint FK_PESSOA_ENDERECO foreign key (PESSO_ID)
      references TB_PESSOA (ID) on delete cascade on update cascade;

alter table TB_ENDERECO add constraint FK_UF_ENDERECO foreign key (UF_ID)
      references TB_UF (ID) on delete cascade on update cascade;
