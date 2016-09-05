
CREATE TABLE rede_social (
                id_rede_social SERIAL NOT NULL,
                cv_descricao VARCHAR NOT NULL,
                CONSTRAINT rede_social_pk PRIMARY KEY (id_rede_social)
);


CREATE TABLE formulario (
                id_formulario SERIAL NOT NULL,
                dt_formulario DATE NOT NULL,
                char_informacoes_institucionais CHAR,
                char_servicos CHAR,
                char_comentarios CHAR,
                char_corpo_clinico CHAR,
                CONSTRAINT formulario_pk PRIMARY KEY (id_formulario)
);


CREATE TABLE formulario_redes_sociais (
                id_formulario_redes_sociais SERIAL NOT NULL,
                id_formulario SERIAL NOT NULL,
                id_rede_social SERIAL NOT NULL,
                CONSTRAINT formulario_redes_sociais_pk PRIMARY KEY (id_formulario_redes_sociais, id_formulario, id_rede_social)
);


CREATE TABLE pais (
                id_pais SERIAL NOT NULL,
                cv_descricao VARCHAR NOT NULL,
                CONSTRAINT pais_pk PRIMARY KEY (id_pais)
);


CREATE TABLE cidade (
                id_cidade SERIAL NOT NULL,
                cv_descricao VARCHAR NOT NULL,
                CONSTRAINT cidade_pk PRIMARY KEY (id_cidade)
);


CREATE TABLE tecnologia (
                id_tecnologia SERIAL NOT NULL,
                cv_descricao VARCHAR NOT NULL,
                CONSTRAINT tecnologia_pk PRIMARY KEY (id_tecnologia)
);


CREATE TABLE formulario_tecnologia (
                id_formulario_tecnologia SERIAL NOT NULL,
                id_formulario SERIAL NOT NULL,
                id_tecnologia SERIAL NOT NULL,
                CONSTRAINT formulario_tecnologia_pk PRIMARY KEY (id_formulario_tecnologia, id_formulario, id_tecnologia)
);


CREATE TABLE hospital (
                id_hospital SERIAL NOT NULL,
                id_pais SERIAL NOT NULL,
                id_cidade SERIAL NOT NULL,
                cv_site VARCHAR,
                cv_nome VARCHAR NOT NULL,
                CONSTRAINT hospital_pk PRIMARY KEY (id_hospital, id_pais, id_cidade)
);


CREATE TABLE formulario_hospital (
                id_formulario_hospital SERIAL NOT NULL,
                id_formulario SERIAL NOT NULL,
                id_hospital SERIAL NOT NULL,
                id_pais SERIAL NOT NULL,
                id_cidade SERIAL NOT NULL,
                CONSTRAINT formulario_hospital_pk PRIMARY KEY (id_formulario_hospital, id_formulario, id_hospital, id_pais, id_cidade)
);


ALTER TABLE formulario_redes_sociais ADD CONSTRAINT rede_social_formulario_redes_sociais_fk
FOREIGN KEY (id_rede_social)
REFERENCES rede_social (id_rede_social)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE formulario_tecnologia ADD CONSTRAINT formulario_formulario_tecnologia_fk
FOREIGN KEY (id_formulario)
REFERENCES formulario (id_formulario)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE formulario_redes_sociais ADD CONSTRAINT formulario_formulario_redes_sociais_fk
FOREIGN KEY (id_formulario)
REFERENCES formulario (id_formulario)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE formulario_hospital ADD CONSTRAINT formulario_formulario_hospital_fk
FOREIGN KEY (id_formulario)
REFERENCES formulario (id_formulario)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE hospital ADD CONSTRAINT pais_hospital_fk
FOREIGN KEY (id_pais)
REFERENCES pais (id_pais)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE hospital ADD CONSTRAINT cidade_hospital_fk
FOREIGN KEY (id_cidade)
REFERENCES cidade (id_cidade)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE formulario_tecnologia ADD CONSTRAINT tecnologia_formulario_tecnologia_fk
FOREIGN KEY (id_tecnologia)
REFERENCES tecnologia (id_tecnologia)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE formulario_hospital ADD CONSTRAINT hospital_formulario_hospital_fk
FOREIGN KEY (id_hospital, id_pais, id_cidade)
REFERENCES hospital (id_hospital, id_pais, id_cidade)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;