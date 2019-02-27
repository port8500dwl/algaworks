drop table if exists TB_PERMISSAO;

/*==============================================================*/
/* Table: TB_PERMISSAO                                          */
/*==============================================================*/
create table TB_PERMISSAO
(
   ID                   Integer(10) not null auto_increment,
   STR_NOME             varchar(200) not null,
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1),
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_permissao(bol_ativo, dat_cadastro,str_nome)values
(1,'2019-02-20','CADASTRAR_CONSULTA'),
(1,'2019-02-20','PESQUISAR_CONSULTA'),
(1,'2019-02-20','CANCELAR_CONSULTAS'),
(1,'2019-02-20','CADASTRAR_PACIENTE'),
(1,'2019-02-20','PESQUISAR_PACIENTE'),
(1,'2019-02-20','CANCELAR_CADASTRO')