
CREATE TABLE GMRC_TRABAJADOR
(
	MRC_I_EMPLEADO       NUMBER NOT NULL ,
	MRC_C_TRABAJADOR     VARCHAR2(20) NULL ,
	MRC_D_APELLIDOS      VARCHAR2(100) NULL ,
	MRC_D_NOMBRES        VARCHAR2(100) NULL ,
	MRC_N_FOTOCHECK      NUMBER NULL ,
	MRC_D_SECCION        VARCHAR2(100) NULL ,
	MRC_C_DNI            VARCHAR2(100) NULL ,
	NRC_N_CARGOTRAB      NUMBER NULL ,
	NRC_C_TIPOTRAB       VARCHAR2(5) NULL ,
	MRC_D_TIPOTRAB       VARCHAR2(50) NULL ,
	MRC_F_INGRESO        DATE NULL ,
	MRC_F_NACIMIENTO     DATE NULL ,
	MRC_C_SEXO           VARCHAR2(1) NULL ,
	MRC_D_SEXO           VARCHAR2(50) NULL ,
	MRC_N_ESTADO         NUMBER NULL ,
	USC_C_USUCRE         VARCHAR2(30) NULL ,
	F_USUARIO_CREA       DATE NULL ,
	IP_TERMINAL_CREA     VARCHAR2(40) NULL ,
	USC_C_USUMOD         VARCHAR2(30) NULL ,
	F_USUARIO_MODIFICA   DATE NULL ,
	IP_TERMINAL_MODIFICA VARCHAR2(40) NULL ,
	MRC_C_RELOJ          NUMBER NULL 
);




COMMENT ON COLUMN GMRC_TRABAJADOR.MRC_I_EMPLEADO IS 'ID TABLA';




COMMENT ON COLUMN GMRC_TRABAJADOR.MRC_C_TRABAJADOR IS 'IGUAL QUE EL DNI';




COMMENT ON COLUMN GMRC_TRABAJADOR.MRC_N_FOTOCHECK IS 'DNI pero en numero sin los 0 adelante';




COMMENT ON COLUMN GMRC_TRABAJADOR.MRC_C_RELOJ IS 'Reloj al que pertenece cada empleado';



CREATE UNIQUE INDEX IDX_GMRC_TRABAJADOR_01 ON GMRC_TRABAJADOR
(MRC_I_EMPLEADO   ASC);



ALTER TABLE GMRC_TRABAJADOR
	ADD CONSTRAINT  PK_GMRC_TRABAJADOR PRIMARY KEY (MRC_I_EMPLEADO);



CREATE UNIQUE INDEX IDX_GMRC_TRABAJADOR_02 ON GMRC_TRABAJADOR
(MRC_C_DNI   ASC);



ALTER TABLE GMRC_TRABAJADOR
ADD CONSTRAINT  IDX_GMRC_TRABAJADOR_02 UNIQUE (MRC_C_DNI);



CREATE TABLE GMRD_MARCACION
(
	MRC_I_MARCACION      NUMBER NOT NULL ,
	MRC_N_FOTOCHECK      NUMBER NULL ,
	MRC_F_TIMESTAMP      DATE NULL ,
	MRC_F_FECHAMARC      DATE NULL ,
	MRC_C_RELOJ          NUMBER NULL ,
	MRC_N_ESTADO         NUMBER NULL ,
	USC_C_USUCRE         VARCHAR2(30) NULL ,
	F_USUARIO_CREA       DATE NULL ,
	IP_TERMINAL_CREA     VARCHAR2(40) NULL ,
	USC_C_USUMOD         VARCHAR2(30) NULL ,
	F_USUARIO_MODIFICA   DATE NULL ,
	IP_TERMINAL_MODIFICA VARCHAR2(40) NULL 
);




COMMENT ON COLUMN GMRD_MARCACION.MRC_I_MARCACION IS 'id tabla';




COMMENT ON COLUMN GMRD_MARCACION.MRC_N_FOTOCHECK IS 'dni pero en numero';




COMMENT ON COLUMN GMRD_MARCACION.MRC_F_TIMESTAMP IS 'fecha con hora';




COMMENT ON COLUMN GMRD_MARCACION.MRC_F_FECHAMARC IS 'fecha sola';




COMMENT ON COLUMN GMRD_MARCACION.MRC_C_RELOJ IS 'reloj al que pertenece ada empleado';



CREATE UNIQUE INDEX IDX_GMRD_MARCACION ON GMRD_MARCACION
(MRC_I_MARCACION   ASC);



ALTER TABLE GMRD_MARCACION
	ADD CONSTRAINT  PK_GMRD_MARCACION PRIMARY KEY (MRC_I_MARCACION);
	
	
	
CREATE SEQUENCE  "MARCACION"."SEQ_MRC_MARCACION_01"  MINVALUE 1 MAXVALUE 99999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;