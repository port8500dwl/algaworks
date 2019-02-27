drop table if exists TB_PESSOA;

/*==============================================================*/
/* Table: TB_PESSOA                                             */
/*==============================================================*/
create table TB_PESSOA
(
   ID                   integer(10) not null auto_increment,
   PROFISSAO_ID         Integer(10) not null,
   STR_NOME             varchar(100) not null,
   STR_SOBRENOME        varchar(100),
   DAT_NASCIMENTO        datetime not null,
   STR_EMAIL            varchar(100),
   STR_SEXO             varchar(1),
   STR_ESTADO_CIVIL     varchar(1),
   STR_ALTURA           varchar(4),
   STR_PESO             varchar(4),
   STR_FILHOS           varchar(4),
   STR_PROFISSAO        varchar(100),
   STR_INDICACAO        varchar(4),
   STR_NOME_INDICACAO   varchar(100),
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table TB_PESSOA add constraint FK_PROFISSAO_PESSOA foreign key (PROFISSAO_ID)
      references TB_PROFISSAO (ID) on delete restrict on update restrict;
      
insert into tb_pessoa (bol_ativo, dat_cadastro, str_nome, str_altura, dat_nascimento, str_email, str_estado_civil, str_filhos, str_indicacao, str_nome_indicacao, str_peso, profissao_id, str_sexo, str_sobrenome) 
values
    (1, '2019-01-20', 'Vinicius', '190', '1980-12-21', 'viniciuscopa@gmail.com', '0', 0, '0', '90', '90', 1, '0', 'Rodrigues da silva')
      
