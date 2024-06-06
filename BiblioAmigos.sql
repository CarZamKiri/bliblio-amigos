

-- Estado usuarios - Usuarios 
create table Estado_Usuarios(
    id_estatus serial primary key, 
    nombre_estado varchar(50) not null
); 

insert into Estado_Usuarios(nombre_estado)
values ('Activo', 'Inactivo')

-- Categorias - Libros 
create table Categoria_Libros(
    Id_Categoria serial primary key, 
    Categoria varchar(50) not null
);

-- Categorias - Biblioteca privada 
create table Categoria_bibliP(
   Id_Categoria serial primary key,
   Categoria varchar(50) not null
);

-- Genero - Libros 
create table genero(
    Id_genero serial primary key, 
    nombre varchar(50) not null
); 

-- Inserción de géneros literarios
insert into genero (nombre) values ('Ficción');
insert into genero (nombre) values ('No ficción');
insert into genero (nombre) values ('Ciencia ficción');
insert into genero (nombre) values ('Fantasía');
insert into genero (nombre) values ('Misterio');
insert into genero (nombre) values ('Thriller');
insert into genero (nombre) values ('Romance');
insert into genero (nombre) values ('Horror');
insert into genero (nombre) values ('Aventura');
insert into genero (nombre) values ('Biografía');
insert into genero (nombre) values ('Autobiografía');
insert into genero (nombre) values ('Memorias');
insert into genero (nombre) values ('Historia');
insert into genero (nombre) values ('Poesía');
insert into genero (nombre) values ('Drama');
insert into genero (nombre) values ('Humor');
insert into genero (nombre) values ('Ensayo');
insert into genero (nombre) values ('Crimen');
insert into genero (nombre) values ('Distopía');
insert into genero (nombre) values ('Paranormal');
insert into genero (nombre) values ('Viajes');
insert into genero (nombre) values ('Educativo');
insert into genero (nombre) values ('Juvenil');
insert into genero (nombre) values ('Infantil');
insert into genero (nombre) values ('Clásico');
insert into genero (nombre) values ('Comedia');
insert into genero (nombre) values ('Suspenso');
insert into genero (nombre) values ('Cuento corto');
insert into genero (nombre) values ('Gótica');
insert into genero (nombre) values ('Histórica');
insert into genero (nombre) values ('Novela gráfica');
insert into genero (nombre) values ('Realismo mágico');
insert into genero (nombre) values ('Policíaca');
insert into genero (nombre) values ('Western');


-- Autores - Libros
create table Autores(
    Id_autor serial primary key,
    nombre varchar(255) not null,
    biografia text
);

-- Editoriales - Libros 
create table Editoriales(
    Id_editorial serial primary key,
    nombre varchar(255) not null
);

-- USUARIOS 
create table Usuarios(
    ID serial primary key,
    nombre varchar(100) not null,
    nombreUsuario varchar(100) not null,
    Email varchar(255) not null,
    FechaNacimiento date not null,
    Genero int not null,
    Estado int not null,
    foreign key (Genero) references genero(Id_genero),
    foreign key (Estado) references Estado_Usuarios(id_estatus)
);

-- Contraseñas - Usuarios 
create table Contrasenas(
    Email varchar(255),
    Contrasena varchar(200) not null
	foreign key (Email) references Usuarios (Email)
);

-- Perfil usuario - Usuario
create table perfil_usuario(
    Id_usuario int primary key, 
    telefono varchar(20),
    imagenPerfil varchar(255),
    biografia text,
    intereses text,
    numeroVisitas int,
    foreign key (Id_usuario) references Usuarios(ID)
);

-- LIBROS
create table Libros(
    ID serial primary key,
    Titulo varchar(255) not null,
    Autor int not null,
    Genero int not null,
    anioPublicacion int,
    Editorial int not null,
    ISBN varchar(13) not null,
    Categoria int not null,
    foreign key (Autor) references Autores(Id_autor),
    foreign key (Genero) references genero(Id_genero),
    foreign key (Editorial) references Editoriales(Id_editorial),
    foreign key (Categoria) references Categoria_Libros(Id_Categoria)
);

-- Reseñas - Libros - Usuarios 
create table Resenas(
    Id_usuario int not null,
    Id_Libro int not null, 
    resena text,
    calificacion int, 
    fecha date not null,
    foreign key (Id_usuario) references Usuarios(ID),
    foreign key (Id_Libro) references Libros(ID),
    primary key (Id_usuario, Id_Libro)
);

-- Biblioteca Personal 
create table Biblioteca_p(
    LibroId int not null,
    UsuarioId int not null,
    notas text, 
    Categorias int not null,
    Estado varchar(255),
    fecha_in date,
    foreign key (LibroId) references Libros(ID),
    foreign key (UsuarioId) references Usuarios(ID),
    foreign key (Categorias) references Categoria_bibliP(Id_Categoria),
    primary key (LibroId, UsuarioId)
);
