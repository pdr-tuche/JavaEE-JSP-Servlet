create database escola;
use escola;

-- Criação da tabela "turma"
CREATE TABLE turma (
  id INT PRIMARY KEY auto_increment,
  nome VARCHAR(50),
  turno VARCHAR(50)
);

-- Criação da tabela "aluno"
CREATE TABLE aluno (
  matricula INT PRIMARY KEY auto_increment,
  nome VARCHAR(50),
  turma_id INT,
  FOREIGN KEY (turma_id) REFERENCES turma(id)
);

show tables;
describe turma;

insert into turma (nome, turno) values ('1C', 'manha');
insert into aluno (nome, turma_id) values ('Rogerin','1');

select * from turma;
select * from aluno;

select * from turma where nome = '1C';
select * from aluno where matricula = 1;

select * from turma order by nome;
select * from aluno order by nome;

select * from turma where id = 2;
select * from aluno where matricula = 1;

update turma set nome ='7c' where id = 4;
update aluno set turma_id = 4 where matricula = 2;

delete from turma where id = 3;