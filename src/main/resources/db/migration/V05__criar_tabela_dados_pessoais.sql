drop table if exists TB_DADOS_PESSOAIS;

/*==============================================================*/
/* Table: TB_DADOS_PESSOAIS                                     */
/*==============================================================*/
create table TB_DADOS_PESSOAIS
(
   ID                   Integer(10) not null,
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
);

alter table TB_DADOS_PESSOAIS add constraint FK_PESSO_DADOS_PESSOAIS foreign key (ID)
      references TB_PESSOA (ID) on delete cascade on update cascade;
