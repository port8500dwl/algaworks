drop table if exists TB_TIPO_USUARIO;

/*==============================================================*/
/* Table: TB_TIPO_USUARIO                                       */
/*==============================================================*/
create table TB_TIPO_USUARIO
(
   ID                   Integer(10) not null auto_increment,
   STR_NOME             varchar(50),
   STR_DESCRICAO        varchar(60),
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_tipo_usuario (bol_ativo, dat_cadastro, str_descricao, str_nome) values
(1, '2019-02-20', 'Analisata de sistemas', 'Analisata de sistemas'),
(1, '2019-02-20', 'Contador', 'Contador'),
(0, '2019-02-20', 'Terapeuta', 'Terapeuta'),
(1, '2019-02-20', 'Copeira', 'Copeira')
