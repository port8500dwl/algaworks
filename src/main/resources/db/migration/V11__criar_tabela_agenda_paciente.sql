drop table if exists TB_AGENDA_PACIENTE;

/*==============================================================*/
/* Table: TB_AGENDA_PACIENTE                                    */
/*==============================================================*/
create table TB_AGENDA_PACIENTE
(
   ID                   Integer(10) not null auto_increment,
   PACIENTE_ID          Integer(10) not null,
   DAT_CONSULTA         datetime,
   DAT_INICIO           datetime,
   DAT_FIM              datetime,
   DAT_CADASTRO         datetime,
   STR_STATUS           varchar(20),
   BOL_ATIVO            numeric(1,0),
   primary key (ID)
);

alter table TB_AGENDA_PACIENTE add constraint FK_PASCIENTE_AGENDA_PASCIENTE foreign key (PACIENTE_ID)
      references TB_PACIENTE (ID) on delete cascade on update cascade;
