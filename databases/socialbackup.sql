PGDMP      .            
    |           social    17.2    17.2                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false                       1262    16514    social    DATABASE     y   CREATE DATABASE social WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE social;
                     postgres    false            �            1259    16537    comentarios    TABLE     �   CREATE TABLE public.comentarios (
    id integer NOT NULL,
    comentario text,
    user_id integer,
    post_id integer,
    estado character varying(50),
    created_at timestamp with time zone
);
    DROP TABLE public.comentarios;
       public         heap r       postgres    false            �            1259    16536    comentarios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.comentarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.comentarios_id_seq;
       public               postgres    false    222                       0    0    comentarios_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.comentarios_id_seq OWNED BY public.comentarios.id;
          public               postgres    false    221            �            1259    16523    posts    TABLE     �   CREATE TABLE public.posts (
    id integer NOT NULL,
    titulo character varying(255),
    mensaje text,
    user_id integer,
    estado character varying(50),
    created_at timestamp with time zone
);
    DROP TABLE public.posts;
       public         heap r       postgres    false            �            1259    16522    posts_id_seq    SEQUENCE     �   CREATE SEQUENCE public.posts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.posts_id_seq;
       public               postgres    false    220                       0    0    posts_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.posts_id_seq OWNED BY public.posts.id;
          public               postgres    false    219            �            1259    16555 
   seguidores    TABLE     �   CREATE TABLE public.seguidores (
    seguidor_user_id integer,
    seguido_user_id integer,
    created_at timestamp with time zone
);
    DROP TABLE public.seguidores;
       public         heap r       postgres    false            �            1259    16516    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id integer NOT NULL,
    username character varying(100),
    email character varying(50),
    role character varying(100),
    created_at timestamp with time zone
);
    DROP TABLE public.usuarios;
       public         heap r       postgres    false            �            1259    16515    usuarios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public               postgres    false    218                       0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
          public               postgres    false    217            g           2604    16540    comentarios id    DEFAULT     p   ALTER TABLE ONLY public.comentarios ALTER COLUMN id SET DEFAULT nextval('public.comentarios_id_seq'::regclass);
 =   ALTER TABLE public.comentarios ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    222    221    222            f           2604    16526    posts id    DEFAULT     d   ALTER TABLE ONLY public.posts ALTER COLUMN id SET DEFAULT nextval('public.posts_id_seq'::regclass);
 7   ALTER TABLE public.posts ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    219    220    220            e           2604    16519    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    217    218    218            	          0    16537    comentarios 
   TABLE DATA           [   COPY public.comentarios (id, comentario, user_id, post_id, estado, created_at) FROM stdin;
    public               postgres    false    222   �$                 0    16523    posts 
   TABLE DATA           Q   COPY public.posts (id, titulo, mensaje, user_id, estado, created_at) FROM stdin;
    public               postgres    false    220   �$       
          0    16555 
   seguidores 
   TABLE DATA           S   COPY public.seguidores (seguidor_user_id, seguido_user_id, created_at) FROM stdin;
    public               postgres    false    223   �$                 0    16516    usuarios 
   TABLE DATA           I   COPY public.usuarios (id, username, email, role, created_at) FROM stdin;
    public               postgres    false    218   %                  0    0    comentarios_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.comentarios_id_seq', 1, false);
          public               postgres    false    221                       0    0    posts_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.posts_id_seq', 1, false);
          public               postgres    false    219                       0    0    usuarios_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.usuarios_id_seq', 1, false);
          public               postgres    false    217            m           2606    16544    comentarios comentarios_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.comentarios
    ADD CONSTRAINT comentarios_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.comentarios DROP CONSTRAINT comentarios_pkey;
       public                 postgres    false    222            k           2606    16530    posts posts_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.posts DROP CONSTRAINT posts_pkey;
       public                 postgres    false    220            i           2606    16521    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public                 postgres    false    218            o           2606    16550 $   comentarios comentarios_post_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.comentarios
    ADD CONSTRAINT comentarios_post_id_fkey FOREIGN KEY (post_id) REFERENCES public.posts(id);
 N   ALTER TABLE ONLY public.comentarios DROP CONSTRAINT comentarios_post_id_fkey;
       public               postgres    false    4715    222    220            p           2606    16545 $   comentarios comentarios_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.comentarios
    ADD CONSTRAINT comentarios_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.usuarios(id);
 N   ALTER TABLE ONLY public.comentarios DROP CONSTRAINT comentarios_user_id_fkey;
       public               postgres    false    218    222    4713            n           2606    16531    posts posts_user_id_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.usuarios(id);
 B   ALTER TABLE ONLY public.posts DROP CONSTRAINT posts_user_id_fkey;
       public               postgres    false    218    220    4713            q           2606    16563 *   seguidores seguidores_seguido_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.seguidores
    ADD CONSTRAINT seguidores_seguido_user_id_fkey FOREIGN KEY (seguido_user_id) REFERENCES public.usuarios(id);
 T   ALTER TABLE ONLY public.seguidores DROP CONSTRAINT seguidores_seguido_user_id_fkey;
       public               postgres    false    4713    218    223            r           2606    16558 +   seguidores seguidores_seguidor_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.seguidores
    ADD CONSTRAINT seguidores_seguidor_user_id_fkey FOREIGN KEY (seguidor_user_id) REFERENCES public.usuarios(id);
 U   ALTER TABLE ONLY public.seguidores DROP CONSTRAINT seguidores_seguidor_user_id_fkey;
       public               postgres    false    218    4713    223            	      x������ � �            x������ � �      
      x������ � �            x������ � �     