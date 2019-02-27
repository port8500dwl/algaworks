drop table if exists TB_TERMO_COMPROMISSO;

/*==============================================================*/
/* Table: TB_TERMO_COMPROMISSO                                  */
/*==============================================================*/
create table TB_TERMO_COMPROMISSO
(
   ID                   Integer(10) not null auto_increment,
   PACIENTE_ID          Integer(10),
   STR_TEXTO_TERMO      longtext not null,
   DAT_CADASTRO         datetime,
   BOL_ACEITO           numeric(1,0) not null,
   primary key (ID)
);

alter table TB_TERMO_COMPROMISSO add constraint FK_PACIENTE_TERMO foreign key (PACIENTE_ID)
      references TB_PACIENTE (ID) on delete restrict on update restrict;
