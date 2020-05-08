--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: kullanicilar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanicilar (
    kullanicino integer NOT NULL,
    kullaniciadi character varying(50) NOT NULL,
    kullanicisifre character varying(50) NOT NULL
);


ALTER TABLE public.kullanicilar OWNER TO postgres;

--
-- Name: kullanicilar_kullanicino_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.kullanicilar_kullanicino_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.kullanicilar_kullanicino_seq OWNER TO postgres;

--
-- Name: kullanicilar_kullanicino_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.kullanicilar_kullanicino_seq OWNED BY public.kullanicilar.kullanicino;


--
-- Name: kullanicilar kullanicino; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanicilar ALTER COLUMN kullanicino SET DEFAULT nextval('public.kullanicilar_kullanicino_seq'::regclass);


--
-- Data for Name: kullanicilar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.kullanicilar VALUES (1, 'kullaniciMelih', '123456');
INSERT INTO public.kullanicilar VALUES (2, 'cihazServisYetkilisi', 'akilli123cihaz456');


--
-- Name: kullanicilar_kullanicino_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.kullanicilar_kullanicino_seq', 4, true);


--
-- Name: kullanicilar kullanicilar_kullaniciadi_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT kullanicilar_kullaniciadi_key UNIQUE (kullaniciadi);


--
-- Name: kullanicilar kullanicilar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT kullanicilar_pkey PRIMARY KEY (kullanicino);


--
-- PostgreSQL database dump complete
--

