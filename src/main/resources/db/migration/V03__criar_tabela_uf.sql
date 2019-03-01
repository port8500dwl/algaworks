drop table if exists TB_UF;

/*==============================================================*/
/* Table: TB_UF                                                 */
/*==============================================================*/
create table TB_UF
(
   ID                   Integer(10) not null auto_increment,
   STR_SIGLA            varchar(2) not null,
   STR_NOME             varchar(200),
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

insert into tb_uf (STR_SIGLA, STR_NOME, DAT_CADASTRO, BOL_ATIVO) values
('DF', 'Distrito Federal', '2019-02-28', 1),
('MA', 'Maranhão', '2019-02-28', 1),
('MG', 'Minas Gerais', '2019-02-28', 1),
('RJ', 'Rio de Janeiro', '2019-02-28', 1),
('SP', 'São Paulo', '2019-02-28', 1)
