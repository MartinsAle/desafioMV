--------------------------------------------------------
--  Arquivo criado - segunda-feira-fevereiro-14-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PCK_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##DEVELOPER"."PCK_CLIENTE" AS

  procedure listarClientes(p_result  out t_cursor) AS
  BEGIN
    open p_result for 
        select * from clientes order by idcli;
  END listarClientes;
  
  procedure cadastrarCliente(p_tipo_pessoa in c##developer.clientes.tipo_pessoa%type,
                                p_cpf in c##developer.clientes.cpf%type,
                                p_nome in c##developer.clientes.nome%type,
                                p_telefone in c##developer.clientes.telefone%type,
                                p_email in c##developer.clientes.email%type) is
  v_id number;
  BEGIN
    select clientes_seq.nextval INTO v_id from sys.dual;
    insert into clientes(idcli, tipo_pessoa, cpf, nome, telefone, email, data_criado) values(v_id, p_tipo_pessoa, p_cpf, p_nome, p_telefone, p_email, sysdate);
  
  END cadastrarCliente;

END PCK_CLIENTE;

/
