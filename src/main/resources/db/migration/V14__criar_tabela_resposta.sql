drop table if exists TB_RESPOSTA;

/*==============================================================*/
/* Table: TB_RESPOSTA                                           */
/*==============================================================*/
create table TB_RESPOSTA
(
   ID                   Integer(10) not null,
   PACIENTE_ID          integer(10) not null,
   TIPO_PERGUNTA_ID     integer(10) not null,
   USUARIO_ID           Integer(10) not null,
   STR_RESPOSTA         text,
   DAT_CADASTRO         datetime,
   BOL_ATIVO            numeric(1),
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table TB_RESPOSTA add constraint FK_PACIENTE_RESPOSTA foreign key (PACIENTE_ID)
      references TB_PACIENTE (ID) on delete cascade on update cascade;

alter table TB_RESPOSTA add constraint FK_PERGUNTA_RESPOSTA foreign key (TIPO_PERGUNTA_ID)
      references TB_PERGUNTA (ID) on delete cascade on update cascade;

alter table TB_RESPOSTA add constraint FK_TIPO_RESPOSTA_PERGUNTA_RESPOSTA foreign key (TIPO_PERGUNTA_ID)
      references TB_TIPO_RESPOSTA_PERGUNTA (ID) on delete cascade on update cascade;

alter table TB_RESPOSTA add constraint FK_USUARIO_RESPOSTA foreign key (USUARIO_ID)
      references TB_USUARIO (ID) on delete cascade on update cascade;
