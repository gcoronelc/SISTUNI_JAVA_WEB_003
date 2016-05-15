--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: guest; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE guest (
    id bigint NOT NULL,
    name character varying(100),
    signingdate date
);


ALTER TABLE public.guest OWNER TO postgres;

--
-- Name: COLUMN guest.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN guest.name IS 'Nombre del invitado
';


--
-- Name: sequence; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sequence (
    seq_name character varying(50) NOT NULL,
    seq_count bigint
);


ALTER TABLE public.sequence OWNER TO postgres;

--
-- Data for Name: guest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY guest (id, name, signingdate) FROM stdin;
1		2016-05-14
2		2016-05-14
3		2016-05-14
4	Emilio	2016-05-14
\.


--
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sequence (seq_name, seq_count) FROM stdin;
GUEST_SEQUENCE	4
\.


--
-- Name: guest_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY guest
    ADD CONSTRAINT guest_pk PRIMARY KEY (id);


--
-- Name: sequence_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sequence
    ADD CONSTRAINT sequence_pk PRIMARY KEY (seq_name);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

