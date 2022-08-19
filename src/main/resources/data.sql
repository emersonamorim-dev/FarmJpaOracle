CREATE TABLE remedy (
id NUMBER GENERATED ALWAYS AS IDENTITY ,
product varchar2(255) not null,
marca varchar2(255) not null,
industry varchar2(255) not null,
joiningdate DATE default sysdate
);

INSERT INTO remedy ( product , marca , industry ) values (  'Neosaldina' , 'Nycomed' , 'Suica' )