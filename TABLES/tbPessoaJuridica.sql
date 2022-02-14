--------------------------------------------------------
--  Arquivo criado - segunda-feira-fevereiro-14-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PESSOA_JURIDICA
--------------------------------------------------------

  CREATE TABLE "C##DEVELOPER"."PESSOA_JURIDICA" 
   (	"IDPJ" NUMBER(*,0), 
	"IDCLI" NUMBER(*,0), 
	"RAZAO_SOCIAL" VARCHAR2(50 BYTE), 
	"NOME_FANTASIA" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into C##DEVELOPER.PESSOA_JURIDICA
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PESSOA_JURIDICA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##DEVELOPER"."PESSOA_JURIDICA_PK" ON "C##DEVELOPER"."PESSOA_JURIDICA" ("IDPJ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PESSOA_JURIDICA
--------------------------------------------------------

  ALTER TABLE "C##DEVELOPER"."PESSOA_JURIDICA" MODIFY ("IDPJ" NOT NULL ENABLE);
  ALTER TABLE "C##DEVELOPER"."PESSOA_JURIDICA" MODIFY ("IDCLI" NOT NULL ENABLE);
  ALTER TABLE "C##DEVELOPER"."PESSOA_JURIDICA" ADD CONSTRAINT "PESSOA_JURIDICA_PK" PRIMARY KEY ("IDPJ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
