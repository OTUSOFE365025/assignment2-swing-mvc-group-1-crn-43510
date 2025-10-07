create database lab3;
use lab3;

create table lab3.Hotel(
	hotelNo int primary key,
	hotelName varchar(20),
    city varchar(20)
);

create table lab3.Room(
	roomNo int,
    hotelNo int,
    type varchar(20),
    price int,
    primary key(roomNo, hotelNo),
    foreign key (hotelNo) references Hotel(hotelNo)
);

create table lab3.Guest(
	guestNo int primary key,
    guestName varchar(30),
    guestAddress varchar(50)
);

create table lab3.Booking(
	hotelNo int,
    guestNo int,
    dateFrom date,
    dateTo date,
    roomNo int,
	primary key(hotelNo, guestNo, roomNo),
    foreign key (hotelNo) references Hotel(hotelNo),
    foreign key (guestNo) references Guest(guestNo),
    foreign key (roomNo) references Room(roomNo)
);




    
	






