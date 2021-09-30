# EscuelaMaven
Base del codigo SQL

BEGIN;


CREATE TABLE IF NOT EXISTS public.colegio
(
    idcolegio serial NOT NULL,
    tipo character(50) NOT NULL,
    ciudad character(50) NOT NULL,
    nombre character(50),
    PRIMARY KEY (idcolegio)
);

CREATE TABLE IF NOT EXISTS public.estudiante
(
    idestudiante serial NOT NULL,
    primer_nom character(50) NOT NULL,
    primer_ape character(50) NOT NULL,
    seg_nom character(50),
    seg_ape character(50),
    activo boolean NOT NULL,
    colegio_idcolegio integer NOT NULL,
    historial character(50) NOT NULL,
    origen_idorigen integer NOT NULL,
    PRIMARY KEY (idestudiante)
);

CREATE TABLE IF NOT EXISTS public.inform_salud
(
    idinf_salud serial NOT NULL,
    estudiante_idestudiante integer NOT NULL,
    num_seguro_social character(50),
    grupo_sang character(50),
    PRIMARY KEY (idinf_salud)
);

CREATE TABLE IF NOT EXISTS public.origen
(
    idorigen serial NOT NULL,
    estado character(50),
    ciudad character(50),
    PRIMARY KEY (idorigen)
);

CREATE TABLE IF NOT EXISTS public.tutor
(
    idacudiente serial NOT NULL,
    estudiante_idestudiante integer NOT NULL,
    ident_madre character(100),
    ident_padre character(100),
    nom_madre character(100),
    nom_padre character(100),
    direc_elec character(100),
    telefono character(10),
    telefono_2 character(10),
    PRIMARY KEY (idacudiente)
);

ALTER TABLE public.estudiante
    ADD FOREIGN KEY (colegio_idcolegio)
    REFERENCES public.colegio (idcolegio)
    NOT VALID;


ALTER TABLE public.estudiante
    ADD FOREIGN KEY (origen_idorigen)
    REFERENCES public.origen (idorigen)
    NOT VALID;


ALTER TABLE public.inform_salud
    ADD FOREIGN KEY (estudiante_idestudiante)
    REFERENCES public.estudiante (idestudiante)
    NOT VALID;


ALTER TABLE public.tutor
    ADD FOREIGN KEY (estudiante_idestudiante)
    REFERENCES public.estudiante (idestudiante)
    NOT VALID;

END;
