
-----------------------

--Lineas

insert into Lineas(idLinea,nombre) values(1,'ZAPATOS DE BEBES');
insert into Lineas(idLinea,nombre) values(2,'ZAPATO DE CABALLEROS');
insert into Lineas(idLinea,nombre) values(3,'ZAPATOS NI�OS');
insert into Lineas(idLinea,nombre) values(4,'ROPA DE DAMAS');
insert into Lineas(idLinea,nombre) values(5,'ROPA DE CABELLEROS');
insert into Lineas(idLinea,nombre) values(6,'ROPA DE SE�ORITAS');
insert into Lineas(idLinea,nombre) values(7,'ROPA DE NI�OS');
insert into Lineas(idLinea,nombre) values(8,'ROPA DE NI�AS');



--Tabla control
insert into Control(Parametro,Valor) values('Lineas',1);
insert into Control(Parametro,Valor) values('Empleados',1);
insert into Control(Parametro,Valor) values('Clientes',1);
insert into Control(Parametro,Valor) values('Productos',25);
insert into Control(Parametro,Valor) values('Proveedores',1);
insert into Control(Parametro,Valor) values('Ventas',1);
insert into Control(Parametro,Valor) values('Compras',1);


-- Tabla: productos
Insert Into Productos Values ( 'A0001', 'Baby Class Calzado para bebe tallas 4 a 8',1, 35,45,200 );
Insert Into Productos Values ( 'A0002', 'Baby Line Calzado para bebe',1, 40,50, 170 );
Insert Into Productos Values ( 'A0003', 'Baby Magoo Calzado para bebe',1, 50,60, 567 );
Insert Into Productos Values ( 'A0004', 'Baby sandalia Sandalia',1, 35,45, 367 );
Insert Into Productos Values ( 'A0005', 'Balint Calzado para varon',2, 150,170, 876 );
Insert Into Productos Values ( 'A0006', 'Blucher Calzado para varon',2, 240,280, 267 );
Insert Into Productos Values ( 'A0007', 'Clucher 5 Calzado para varon',2, 180,200, 546 );
Insert Into Productos Values ( 'A0008', 'Ingland Calzado para varon',2, 230,260, 489 );
Insert Into Productos Values ( 'A0009', 'Steeper Clasico Calzado de monta�a',3, 280,310, 678 );
Insert Into Productos Values ( 'A0010', 'Steeper Plus Calzado de monta�a',3, 220,250, 3456 );
Insert Into Productos Values ( 'A0011', 'Steeper Light Calzado liviabno de monta�a',3, 160,180, 765 );
Insert Into Productos Values ( 'A0012', 'Casaca Bomber para dama', 4,330,350, 398 );
Insert Into Productos Values ( 'A0013', 'Casaca Corta para dama', 4,260,280, 845 );
Insert Into Productos Values ( 'A0014', 'Casaca de gamuza para dama',4, 240,260, 967 );
Insert Into Productos Values ( 'A0015', 'Casaca jean para dama', 4,190,210, 587 );
Insert Into Productos Values ( 'A0016', 'Casaca Sybilla para dama',4, 230,250, 845 );
Insert Into Productos Values ( 'A0017', 'Casaca cuero para varon',5, 180,200, 634 );
Insert Into Productos Values ( 'A0018', 'Casaca para varon de cuero de carnero',5, 270,290, 867 );
Insert Into Productos Values ( 'A0019', 'Casaca cuero clasica para varon', 5,260,280, 934 );
Insert Into Productos Values ( 'A0020', 'Casaca corta para varon',5, 190,210, 345 );
Insert Into Productos Values ( 'A0021', 'Casaca larga para varon', 5,450, 480,786 );
Insert Into Productos Values ( 'A0022', 'Sacon para varon',5, 390,410, 956 );
Insert Into Productos Values ( 'A0023', 'Abrigo Split para varon',5, 190, 210,378 );
Insert Into Productos Values ( 'A0024', 'Saco larga para varon',5, 280, 300,888 );


-- Tabla: Clientes

insert into clientes values( 'C0001', 'CORONEL CASTILLO ERIC GUSTAVO', 'AV lAS PALEMERAS 234 LOS OLIVOS', '10567892456', '987-6789' );
insert into clientes values( 'C0002', 'VALENCIA MORALES PEDRO HUGO', ' AV LA PAZ 567 MAGDALENA', '10567892456', '987-6789' );
insert into clientes values( 'C0003', 'MARCELO VILLALOBOS RICARDO', 'CALLE RISO PATRON 456 LINCE', '10567892456', '987-6789' );
insert into clientes values( 'C0004', 'ROMERO CASTILLO CARLOS ALBERTO', 'AV TACNA 234 LIMA','10567892456', '987-6789' );
insert into clientes values( 'C0005', 'ARANDA LUNA ALAN ALBERTO', 'AV AREQUIPA 678 SAN ISIDRO', '10567892456', '987-6789' );
insert into clientes values( 'C0006', 'AYALA PAZ JORGE LUIS', 'JR LAS ARTES 890 SAN BORJA', '11999966733', '987-6789' );
insert into clientes values( 'C0007', 'CHAVEZ CANALES EDGAR RAFAEL', 'AV PARADO 342 MIRAFLORES', '11999966733', '987-6789' );
insert into clientes values( 'C0008', 'FLORES CHAFLOQUE ROSA LIZET', 'AV JAVIER PRADO 456 LA MOLINA', '11999966733', '987-6789' );
insert into clientes values( 'C0009', 'FLORES SHUTE CRISTIAN RAFAEL', 'AV UNIVERSITARIA 234 LOS OLIVOS', '11999966733', '966-23854' );
insert into clientes values( 'C0010', 'GONZALES GARCIA GABRIEL ALEJANDRO', 'LA COSTANERA 231 SAN MIGUEL', '11999966733', '966-23854' );
insert into clientes values( 'C0011', 'LAY VALLEJOS JUAN CARLOS', 'AV AREANALES 567 LINCE', '11999966733', '966-23854' );
insert into clientes values( 'C0012', 'MONTALVO SOTO DEYSI LIDIA', 'AV BENAVIDES 123 SURCO', '11999966733', '966-23854' );
insert into clientes values( 'C0013', 'RICALDE RAMIREZ ROSARIO ESMERALDA', 'AV ANGAMOS 345 MIRAFLORES', '11999966733', '991-23546' );
insert into clientes values( 'C0014', 'RODRIGUEZ RAMOS ENRIQUE MANUEL', 'JR MERINO 123 LINCE', '11999966733', '991-23546' );
insert into clientes values( 'C0015', 'ROJAS OSCANOA FELIX NINO',  'AV ABANCAY 456 LIMA', '11999966733', '991-23546' );
insert into clientes values( 'C0016', 'TEJADA DEL AGUILA TANIA LORENA', 'JR PERU 456 PUEBLO LIBRE', '11999966733', '991-23546' );
insert into clientes values( 'C0017', 'VALDEVIESO LEYVA ROXANA', 'JR PESET 576 SURCO', '11999966733', '567-8907' );
insert into clientes values( 'C0018', 'VALENTIN COTRINA JUAN DIEGO', 'AV LA FONTANA 234 LA MOLINA', '11999966733', '991-23546' );
insert into clientes values( 'C0019', 'YAURICASA BAUTISTA YESABETH', 'AV UNIVERISTARIA 998 MAGDALENA', '11999966733', '991-23546' );
insert into clientes values( 'C0020', 'ZEGARRA GARCIA FERNANDO MOISES', 'JR JUNIN 456 SAN ISIDRO', '11999966733', '991-23546' );

-- Tabla: provedores

insert into Proveedores values( 'P0001', 'DISTRIBUIDORA IMPERIAL', 'AV lAS PALEMERAS 234 LOS OLIVOS ', '10567892456', '987-6789'  );
insert into Proveedores values( 'P0002', 'IMPORTACIONES NEPTUNO SAC', 'AV PERU 123 SMP ', '10566542456', '999-6789'  );
insert into Proveedores values( 'P0003', 'TIENDAS GAMARRA', 'AV GRAU 234 LIMA', '10567895554', '234-6789'  );
insert into Proveedores values( 'P0004', 'JOSE LUIS GALAN', 'AV PARDO 456 MIRAFLORES ', '10567892456', '453-6789'  );
insert into Proveedores values( 'P0005', 'DISTRIBUIDORA EL 9CITO', 'AV TUPAC AMARU 110 ', '10567895432', '234-6789'  );

--Tabla empleados 

insert into Empleados values('E0001','Luisa','Davolio','luisa@gmail.com','miguel','1234');
insert into Empleados values('E0002','Manolo','Gonzales','manolo@hotmail.com','jorge','1234');

commit;



