--
-- PostgreSQL database dump
--

-- Dumped from database version 14.13
-- Dumped by pg_dump version 14.13

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
-- Name: clientes; Type: TABLE; Schema: public; Owner: citizix_user
--

CREATE TABLE public.clientes (
    cedula_cliente bigint NOT NULL,
    direccion_cliente character varying,
    email_cliente character varying,
    nombre_cliente character varying,
    telefono_cliente character varying
);


ALTER TABLE public.clientes OWNER TO citizix_user;

--
-- Name: detalle_ventas; Type: TABLE; Schema: public; Owner: citizix_user
--

CREATE TABLE public.detalle_ventas (
    codigo_detalle_venta bigint NOT NULL,
    cantidad_producto integer,
    codigo_producto bigint,
    codigo_venta bigint,
    valor_total double precision,
    valor_venta double precision,
    valoriva double precision
);


ALTER TABLE public.detalle_ventas OWNER TO citizix_user;

--
-- Name: productos; Type: TABLE; Schema: public; Owner: citizix_user
--

CREATE TABLE public.productos (
    codigo_producto bigint NOT NULL,
    ivacompra double precision,
    nitproveedor bigint,
    nombre_producto character varying,
    precio_compra double precision,
    precio_venta double precision
);


ALTER TABLE public.productos OWNER TO citizix_user;

--
-- Name: proveedores; Type: TABLE; Schema: public; Owner: citizix_user
--

CREATE TABLE public.proveedores (
    nitproveedor bigint NOT NULL,
    ciudad_proveedor character varying,
    direccion_proveedor character varying,
    nombre_proveedor character varying,
    telefono_proveedor character varying
);


ALTER TABLE public.proveedores OWNER TO citizix_user;

--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: citizix_user
--

CREATE TABLE public.usuarios (
    cedula_usuario bigint NOT NULL,
    email_usuario character varying NOT NULL,
    nombre_usuario character varying,
    password character varying,
    usuario character varying
);


ALTER TABLE public.usuarios OWNER TO citizix_user;

--
-- Name: ventas; Type: TABLE; Schema: public; Owner: citizix_user
--

CREATE TABLE public.ventas (
    codigo_venta bigint NOT NULL,
    cedula_cliente bigint,
    cedula_usuario bigint,
    ivaventa double precision,
    total_venta double precision,
    valor_venta double precision
);


ALTER TABLE public.ventas OWNER TO citizix_user;

--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: citizix_user
--

COPY public.clientes (cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente) FROM stdin;
1	bogota	non@non.com	carlos	3210001111
2	cali	non2@non.com	pedro	3210001112
\.


--
-- Data for Name: detalle_ventas; Type: TABLE DATA; Schema: public; Owner: citizix_user
--

COPY public.detalle_ventas (codigo_detalle_venta, cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva) FROM stdin;
1	5	1001	1	5000	20000	123
2	1	1002	1	15000	20000	123
\.


--
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: citizix_user
--

COPY public.productos (codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra, precio_venta) FROM stdin;
1001	0.15	1	lapiz	900	1000
1002	0.16	2	diccionario	12000	15000
\.


--
-- Data for Name: proveedores; Type: TABLE DATA; Schema: public; Owner: citizix_user
--

COPY public.proveedores (nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor) FROM stdin;
1	bogota	cedritos	panamericana	3220001111
2	cali	unicentro	santillana	3220001112
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: citizix_user
--

COPY public.usuarios (cedula_usuario, email_usuario, nombre_usuario, password, usuario) FROM stdin;
1	non@non.com	admin	admin	admin
2	non2@non.com	user1	user1	user1
\.


--
-- Data for Name: ventas; Type: TABLE DATA; Schema: public; Owner: citizix_user
--

COPY public.ventas (codigo_venta, cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta) FROM stdin;
1	1	1	0.01	20000	20000
\.


--
-- Name: clientes cliente_pk; Type: CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT cliente_pk PRIMARY KEY (cedula_cliente);


--
-- Name: detalle_ventas detalle_ventas_pk; Type: CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.detalle_ventas
    ADD CONSTRAINT detalle_ventas_pk PRIMARY KEY (codigo_detalle_venta);


--
-- Name: productos productos_pk; Type: CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pk PRIMARY KEY (codigo_producto);


--
-- Name: proveedores proveedores_pk; Type: CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_pk PRIMARY KEY (nitproveedor);


--
-- Name: usuarios usuarios_pk; Type: CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pk PRIMARY KEY (cedula_usuario);


--
-- Name: ventas ventas_pk; Type: CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_pk PRIMARY KEY (codigo_venta);


--
-- Name: detalle_ventas detalle_ventas_productos_codigo_producto_fk; Type: FK CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.detalle_ventas
    ADD CONSTRAINT detalle_ventas_productos_codigo_producto_fk FOREIGN KEY (codigo_producto) REFERENCES public.productos(codigo_producto);


--
-- Name: detalle_ventas detalle_ventas_ventas_codigo_venta_fk; Type: FK CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.detalle_ventas
    ADD CONSTRAINT detalle_ventas_ventas_codigo_venta_fk FOREIGN KEY (codigo_venta) REFERENCES public.ventas(codigo_venta);


--
-- Name: productos productos_proveedores_nitproveedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_proveedores_nitproveedor_fk FOREIGN KEY (nitproveedor) REFERENCES public.proveedores(nitproveedor);


--
-- Name: ventas ventas_clientes_cedula_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_clientes_cedula_cliente_fk FOREIGN KEY (cedula_cliente) REFERENCES public.clientes(cedula_cliente);


--
-- Name: ventas ventas_usuarios_cedula_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: citizix_user
--

ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_usuarios_cedula_usuario_fk FOREIGN KEY (cedula_usuario) REFERENCES public.usuarios(cedula_usuario);


--
-- PostgreSQL database dump complete
--

