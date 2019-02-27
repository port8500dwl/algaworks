drop table if exists TB_TIPO_RESPOSTA_PERGUNTA;

/*==============================================================*/
/* Table: TB_TIPO_RESPOSTA_PERGUNTA                             */
/*==============================================================*/
create table TB_TIPO_RESPOSTA_PERGUNTA
(
   ID                   int not null auto_increment,
   STR_DESCRICAO        varchar(30) not null,
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1),
   primary key (ID)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_tipo_resposta_pergunta (bol_ativo, str_descricao, dat_cadastro) values
(1, 'Texto livre', '2019-02-20'),
(1, 'Seleção unica', '2019-02-20'),
(1, 'Multipla seleção', '2019-02-20'),
(1, 'Select', '2019-02-20')
