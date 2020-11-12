
DROP TABLE IF EXISTS CONTRATO;
DROP TABLE IF EXISTS PERSONA;
DROP TABLE IF EXISTS PRODUCTO;

CREATE TABLE clausula (
    id            INTEGER NOT NULL,
    nombre        VARCHAR2(100) NOT NULL,
    descripcion   VARCHAR2(255) NOT NULL
);

ALTER TABLE clausula ADD CONSTRAINT clausula_pk PRIMARY KEY ( id );

CREATE TABLE contrato (
    id               INTEGER NOT NULL,
    dnicontratante   VARCHAR2(8) NOT NULL,
    dnicontratado    VARCHAR2(8) NOT NULL,
    fechaini         DATE NOT NULL,
    fechafin         DATE NOT NULL,
    tipo             VARCHAR2(3) NOT NULL
);

ALTER TABLE contrato ADD CONSTRAINT contrato_pk PRIMARY KEY ( id );

CREATE TABLE contrato_producto (
    idcontrato   INTEGER NOT NULL,
    idproducto   INTEGER NOT NULL
);

ALTER TABLE contrato_producto ADD CONSTRAINT contrato_producto_pk PRIMARY KEY ( idcontrato,
                                                                                idproducto );

CREATE TABLE persona (
    dni         VARCHAR2(8) NOT NULL,
    nombre      VARCHAR2(100) NOT NULL,
    apellido1   VARCHAR2(255) NOT NULL,
    apellido2   VARCHAR2(255),
    direccion   VARCHAR2(255) NOT NULL,
    telefono    VARCHAR2(9)
);

ALTER TABLE persona ADD CONSTRAINT persona_pk PRIMARY KEY ( dni );

CREATE TABLE producto (
    id           INTEGER NOT NULL,
    nombre       VARCHAR2(100) NOT NULL,
    tipo         VARCHAR2(3) NOT NULL,
    nocontrato   CHAR(1)
);

COMMENT ON COLUMN producto.nocontrato IS
    'CONTENDRA UN Y SI PERMITE LAS CLAUSULAS DEL TIPO DE CONTRATO Y UN N SI NO LAS PERMITE.';

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id );

CREATE TABLE producto_clausula (
    idproducto   INTEGER NOT NULL,
    idclausula   INTEGER NOT NULL
);

ALTER TABLE producto_clausula ADD CONSTRAINT producto_clausula_pk PRIMARY KEY ( idproducto,
                                                                                idclausula );

CREATE TABLE tipo_contrato (
    tipo          VARCHAR2(3) NOT NULL,
    nombre        VARCHAR2(100) NOT NULL,
    descripcion   VARCHAR2(255) NOT NULL
);

ALTER TABLE tipo_contrato ADD CONSTRAINT tipo_contrato_pk PRIMARY KEY ( tipo );

CREATE TABLE tipo_contrato_producto (
    tipo         VARCHAR2(3) NOT NULL,
    idproducto   INTEGER NOT NULL
);

ALTER TABLE tipo_contrato_producto ADD CONSTRAINT tipo_contrato_producto_pk PRIMARY KEY ( tipo,
                                                                                          idproducto );

CREATE TABLE tipo_producto_clausula (
    tipocontrato   VARCHAR2(3) NOT NULL,
    idclausula     INTEGER NOT NULL
);

ALTER TABLE tipo_producto_clausula ADD CONSTRAINT tipo_producto_clausula_pk PRIMARY KEY ( tipocontrato,
                                                                                          idclausula );

ALTER TABLE contrato
    ADD CONSTRAINT contratado_persona_fk FOREIGN KEY ( dnicontratado )
        REFERENCES persona ( dni );

ALTER TABLE contrato
    ADD CONSTRAINT contratante_persona_fk FOREIGN KEY ( dnicontratante )
        REFERENCES persona ( dni );

ALTER TABLE contrato_producto
    ADD CONSTRAINT contrato_producto_producto_fk FOREIGN KEY ( idproducto )
        REFERENCES producto ( id );

ALTER TABLE contrato
    ADD CONSTRAINT contrato_tipo_contrato_fk FOREIGN KEY ( tipo )
        REFERENCES tipo_contrato ( tipo );

ALTER TABLE producto_clausula
    ADD CONSTRAINT table_11_clausula_fk FOREIGN KEY ( idclausula )
        REFERENCES clausula ( id );

ALTER TABLE producto_clausula
    ADD CONSTRAINT table_11_producto_fk FOREIGN KEY ( idproducto )
        REFERENCES producto ( id );

ALTER TABLE tipo_producto_clausula
    ADD CONSTRAINT table_12_clausula_fk FOREIGN KEY ( idclausula )
        REFERENCES clausula ( id );

ALTER TABLE tipo_producto_clausula
    ADD CONSTRAINT table_12_tipo_contrato_fk FOREIGN KEY ( tipocontrato )
        REFERENCES tipo_contrato ( tipo );

ALTER TABLE tipo_contrato_producto
    ADD CONSTRAINT table_7_tipo_contrato_fk FOREIGN KEY ( tipo )
        REFERENCES tipo_contrato ( tipo );

ALTER TABLE contrato_producto
    ADD CONSTRAINT table_8_contrato_fk FOREIGN KEY ( idcontrato )
        REFERENCES contrato ( id );

ALTER TABLE tipo_contrato_producto
    ADD CONSTRAINT tipocontratproducto_fk FOREIGN KEY ( idproducto )
        REFERENCES producto ( id );

INSERT INTO PERSONA VALUES(49055610, 'PEPE', 'FLORES', 'MORENO','VALVERDE', '999999999');
INSERT INTO PERSONA VALUES(49055609, 'SARA', 'DIAZ', 'CONTIOSO','LA PALMA', '999888777');
INSERT INTO PERSONA VALUES(49055599, 'MANUEL', 'BAREA', 'VELEZ','ZALAMEA', '666666666');


