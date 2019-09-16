create database booking;

use booking;

create table admin_home(
idadmin varchar(20) not null primary key,
username varchar(50) not null,
[password] int not null,
email varchar(50) not null,
idquanly varchar(50) not null,
constraint admin_quanly foreign key(idquanly) references quanly (idquanly)
)

create table quanly(
usernamequanly varchar(50) not null,
passwordquanly int not null,
emailquanly varchar(50) not null,
idquanly varchar(50) primary key,
)

create table khachhang(
usernamekhachhang varchar(50) not null primary key,
passwordkhachhang int not null,
emailkhachhang varchar(50) not null,
idkhachhang int identity (1,1)
)

create table phong(
namephong varchar(50) not null,
typephong varchar(50),
giaphong varchar(20),
sophong int primary key
)

create table hoadonphong(
usernamekhachhang varchar(50),
sophong int,
tongtien int,
ngaylayphong date,
ngaytraphong date,
constraint hoadon_sophong foreign key(sophong) references phong (sophong),
constraint hoadon_khachhang foreign key (usernamekhachhang) references khachhang (usernamekhachhang),
)

insert into quanly values ('admin',0123,'admin@gmail.com','ql01')
insert into khachhang values ('kh01',000,'kh01@gmail.com')

select * from quanly
select * from khachhang