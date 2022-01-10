UPDATE usuario SET nascimento = SUBSTR(nascimento, strpos(nascimento,'/'), 7);
