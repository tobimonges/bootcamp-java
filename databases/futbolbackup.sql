PGDMP  :                
    |           social    17.2    17.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16514    social    DATABASE     y   CREATE DATABASE social WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE social;
                     postgres    false            �            1259    16516    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id integer NOT NULL,
    username character varying(100),
    email character varying(50),
    role character varying(100),
    created_at timestamp with time zone,
    id_user integer NOT NULL
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
       public               postgres    false    218                        0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
          public               postgres    false    217            �            1259    24576    usuarios_id_user_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_id_user_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.usuarios_id_user_seq;
       public               postgres    false    218                       0    0    usuarios_id_user_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.usuarios_id_user_seq OWNED BY public.usuarios.id_user;
          public               postgres    false    224            b           2604    16519    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    217    218    218            c           2604    24577    usuarios id_user    DEFAULT     t   ALTER TABLE ONLY public.usuarios ALTER COLUMN id_user SET DEFAULT nextval('public.usuarios_id_user_seq'::regclass);
 ?   ALTER TABLE public.usuarios ALTER COLUMN id_user DROP DEFAULT;
       public               postgres    false    224    218            �          0    16516    usuarios 
   TABLE DATA           R   COPY public.usuarios (id, username, email, role, created_at, id_user) FROM stdin;
    public               postgres    false    218   �                  0    0    usuarios_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.usuarios_id_seq', 30, true);
          public               postgres    false    217                       0    0    usuarios_id_user_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.usuarios_id_user_seq', 20, true);
          public               postgres    false    224            e           2606    16521    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public                 postgres    false    218            �   K  x��ӱN�@��z�)�͑���Jcab����fY���6�W����]%[h��v
�����~b=Ο�~��=��u]�q7�u\���Ɖm���n7TDX�I^*'��E~%�@@l�#G��kp\�>���4�������Ԍ���٢u�޽��v���� ���p�V=�G��d�n�CcV�w
��-۶����T/��N�ȧi� �՗Iu�*&�aA?X��_f��E�e�`��.�5���E	�>���X#J<G�@��c	(,OL�º��(<OU@��QT�,�U����] �́����(,OԐ�׳TI�s ���     