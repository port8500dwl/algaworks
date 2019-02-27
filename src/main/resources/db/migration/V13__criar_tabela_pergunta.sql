drop table if exists TB_PERGUNTA;

/*==============================================================*/
/* Table: TB_PERGUNTA                                           */
/*==============================================================*/
create table TB_PERGUNTA
(
   ID                   Integer(10) not null auto_increment,
   STR_PERGUNTA         varchar(400),
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1),
   primary key (ID)
);
