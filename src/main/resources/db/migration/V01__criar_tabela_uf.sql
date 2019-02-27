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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_uf (STR_SIGLA, STR_NOME, dat_cadastro, BOL_ATIVO) values
('DF', 'Distrito federal', '2019-02-20', 1),
('BA', 'Bahia', '2019-02-20', 1),
('MG', 'Minis Gerais', '2019-02-20',1),
('AM', 'Amapá', '2019-02-20',1)
