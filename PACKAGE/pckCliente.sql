--------------------------------------------------------
--  Arquivo criado - segunda-feira-fevereiro-14-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PCK_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##DEVELOPER"."PCK_CLIENTE" AS 

    type t_cursor is ref cursor;

  procedure listarClientes(p_result  out t_cursor);
  
  procedure cadastrarCliente(p_tipo_pessoa in c##developer.clientes.tipo_pessoa%type,
                                p_cpf in c##developer.clientes.cpf%type,
                                p_nome in c##developer.clientes.nome%type,
                                p_telefone in c##developer.clientes.telefone%type,
                                p_email in c##developer.clientes.email%type);
END PCK_CLIENTE;

/
