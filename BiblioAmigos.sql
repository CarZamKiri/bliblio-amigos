-- Estado usuarios - Usuarios 
create table Estado_Usuarios(
    id_estatus serial primary key, 
    nombre_estado varchar(50) not null
); 

insert into Estado_Usuarios(nombre_estado)
values ('Activo'), ('Inactivo');

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
insert into genero (nombre) values 
('Ficción'), ('No ficción'), ('Ciencia ficción'), ('Fantasía'), ('Misterio'), 
('Thriller'), ('Romance'), ('Horror'), ('Aventura'), ('Biografía'), 
('Autobiografía'), ('Memorias'), ('Historia'), ('Poesía'), ('Drama'), 
('Humor'), ('Ensayo'), ('Crimen'), ('Distopía'), ('Paranormal'), 
('Viajes'), ('Educativo'), ('Juvenil'), ('Infantil'), ('Clásico'), 
('Comedia'), ('Suspenso'), ('Cuento corto'), ('Gótica'), ('Histórica'), 
('Novela gráfica'), ('Realismo mágico'), ('Policíaca'), ('Western');

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
    Email varchar(255) not null unique,
    FechaNacimiento date not null,
    Genero int not null,
    Estado int not null,
    foreign key (Genero) references genero(Id_genero),
    foreign key (Estado) references Estado_Usuarios(id_estatus)
);

-- Contraseñas - Usuarios 
create table Contrasenas(
    Email varchar(255) primary key,
    Contrasena varchar(200) not null,
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
