drop table if exists TB_PROFISSAO;

/*==============================================================*/
/* Table: TB_PROFISSAO                                          */
/*==============================================================*/
create table TB_PROFISSAO
(
   ID                   Integer(10) not null auto_increment,
   STR_NOME             varchar(100) not null,
   STR_OBSERVACAO       text(5000),
   DAT_CADASTRO         timestamp,
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
);

insert  into tb_profissao (bol_ativo, dat_cadastro, str_nome, str_observacao) values 
(1, '2019-02-20', 'Analista de sistemas', 'Analista de sistemas'),
(1, '2019-02-20', 'Motorista', 'Motorista'),
(1, '2019-02-20', 'Terapeuta', 'Terapeuta'),
(1, '2019-02-20', 'Secretária', 'Secretária')
