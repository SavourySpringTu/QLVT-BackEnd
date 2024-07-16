
DROP DATABASE qlvt;
CREATE DATABASE qlvt;
USE qlvt;


CREATE TABLE vaitro(
	maquyen NCHAR(3) PRIMARY KEY NOT NULL,
    tenquyen NVARCHAR(15)
);
CREATE TABLE chinhanh(
	macn NCHAR(10) PRIMARY KEY NOT NULL,
    tencn NVARCHAR(100) NOT NULL,
    diachi NVARCHAR(100) NOT NULL,
    sdt NCHAR(15) NOT NULL
);
CREATE TABLE vattu(
	mavt NCHAR(4) PRIMARY KEY NOT NULL,
    tenvt NVARCHAR(20) NOT NULL,
    donvitinh NVARCHAR(10) NOT NULL,
    soluongton INT NOT NULL
);

CREATE TABLE kho(
	makho NCHAR(4) NOT NULL PRIMARY KEY ,
    tenkho NVARCHAR(30) NOT NULL,
    diachi NVARCHAR(100) NOT NULL,
    macn NCHAR(10) NOT NULL,
    FOREIGN KEY (macn) REFERENCES chinhanh(macn)
);
CREATE TABLE nhanvien(
	manv INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    hoten NVARCHAR(25) NOT NULL,
    email NCHAR(30),
    socmnd NVARCHAR(20) NOT NULL,
    diachi NVARCHAR(100),
    ngaysinh DATE,
    matkhau NCHAR(20) NOT NULL,
    luong INT NOT NULL,
    macn NCHAR(10) NOT NULL,
    maquyen NCHAR(3) NOT NULL,
    trangthai BIT NOT NULL,
    FOREIGN KEY (maquyen) REFERENCES vaitro(maquyen),
    FOREIGN KEY (macn) REFERENCES chinhanh(macn)
);
CREATE TABLE dathang(
	maddh INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ngay DATE NOT NULL,
    nhacc NVARCHAR(100),
    manv INT NOT NULL,
    makho NCHAR(4) NOT NULL,
    FOREIGN KEY (manv) REFERENCES nhanvien(manv)
);
CREATE TABLE ctddh(
	maddh INT NOT NULL,
    mavt NCHAR(4) NOT NULL,
    soluong INT NOT NULL,
    dongia FLOAT NOT NULL,
    FOREIGN KEY (mavt) REFERENCES vattu(mavt),
    FOREIGN KEY (maddh) REFERENCES dathang(maddh),
    CONSTRAINT PK_CTDDH PRIMARY KEY (maddh,mavt)
);
CREATE TABLE phieunhap(
	mapn INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ngay DATE NOT NULL,
	maddh NCHAR(8) NOT NULL,
    manv INT NOT NULL,
    makho NCHAR(4) NOT NULL,
    FOREIGN KEY (manv) REFERENCES nhanvien(manv),
    FOREIGN KEY (makho) REFERENCES kho(makho)
);
CREATE TABLE ctpn(
	mapn INT NOT NULL,
    mavt NCHAR(4) NOT NULL,
    soluong INT NOT NULL,
    dongia FLOAT NOT NULL,
    FOREIGN KEY (mavt) REFERENCES vattu(mavt),
    FOREIGN KEY (mapn) REFERENCES phieunhap(mapn),
    CONSTRAINT PK_CTPN PRIMARY KEY (mapn,mavt)
);

CREATE TABLE giohang(
	magh INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mahk INT
);

CREATE TABLE khachhang(
	makh INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	email NCHAR(30) NOT NULL, 
    sdt NCHAR(15),
    hoten NVARCHAR(25) NOT NULL,
    diachi NVARCHAR(100),
    matkhau NCHAR(20) NOT NULL,
    magh INT NOT NULL,
    FOREIGN KEY (magh) REFERENCES giohang(magh)
);

CREATE TABLE ctgh(
	mavt NCHAR(4) NOT NULL,
    magh INT NOT NULL,
    soluong INT NOT NULL,
    dongia FLOAT NOT NULL,
    FOREIGN KEY (magh) REFERENCES giohang(magh),
    FOREIGN KEY (mavt) REFERENCES vattu(mavt),
    CONSTRAINT PK_CTGH PRIMARY KEY (mavt, magh)
);

CREATE TABLE phieuxuat(
	mapx INT PRIMARY KEY AUTO_INCREMENT,
    ngay DATE NOT NULL,
    makh INT,
    manv INT,
    makho NCHAR(4) NOT NULL,
	FOREIGN KEY (manv) REFERENCES nhanvien(manv),
    FOREIGN KEY (makho) REFERENCES kho(makho),
    FOREIGN KEY (makh) REFERENCES khachhang(makh)
);
CREATE TABLE ctpx(
	mapx INT NOT NULL,
    mavt NCHAR(4) NOT NULL,
    soluong INT NOT NULL,
    dongia FLOAT NOT NULL,
    FOREIGN KEY (mavt) REFERENCES vattu(mavt),
    FOREIGN KEY (mapx) REFERENCES phieuxuat(mapx),
    CONSTRAINT PK_CTPX PRIMARY KEY (mapx,mavt)
);
INSERT INTO vaitro (maquyen,tenquyen) VALUES ('Q01', 'Cong Ty');
INSERT INTO vaitro (maquyen,tenquyen) VALUES ('Q02', 'Chi Nhanh');
INSERT INTO vaitro (maquyen,tenquyen) VALUES ('Q03', 'Nhan Vien');
INSERT INTO chinhanh (macn,tencn, diachi, sdt) VALUES ('CN01', 'Ha Noi', '12O Quang Trung Hoan Kiem Ha Noi','0123456789');
INSERT INTO chinhanh (macn,tencn, diachi, sdt) VALUES ('CN02', 'Ho Chi Minh', '1 Le Thanh Ton Q1 Ho Chi Minh','0987654321');
INSERT INTO nhanvien (hoten, socmnd,diachi,ngaysinh,luong,matkhau,macn,maquyen,trangthai) VALUES ('Bui Xuan Tu','036201001464','30 Quang Trung Hoan Kiem',20011111,2000,'123','CN01','Q03',0);
INSERT INTO vattu (mavt,tenvt,donvitinh,soluongton) VALUES ('LG01', 'Ti vi LG 24 inch', 'Cai',10);
INSERT INTO vattu (mavt,tenvt,donvitinh,soluongton) VALUES ('SS01', 'Ti vi SS 80 inch', 'Cai',10);
INSERT INTO kho (makho, tenkho, diachi, macn) VALUES ('HN01', 'Kho Hoan Kiem', '55 Ho Giang Vo','CN01');
INSERT INTO kho (makho, tenkho, diachi, macn) VALUES ('HM01', 'Kho Ka Đao', '55 Lê Thánh Tôn ','CN02');
INSERT INTO dathang (ngay,nhacc,manv,makho) VALUES (20230905, 'LG Viet Nam',1,'HN01');
INSERT INTO dathang (ngay,nhacc,manv,makho) VALUES (20230905, 'Sam Sung Việt Nam',1,'HN01');
INSERT INTO ctddh(maddh,mavt,soluong,dongia) VALUES (1,'LG01',10,1000);
INSERT INTO ctddh(maddh,mavt,soluong,dongia) VALUES (1,'SS01',10,1000);
INSERT INTO ctddh(maddh,mavt,soluong,dongia) VALUES (2,'LG01',10,1000);
INSERT INTO ctddh(maddh,mavt,soluong,dongia) VALUES (2,'SS01',10,1000);
INSERT INTO phieunhap(ngay,maddh,manv,makho) VALUES (2020905,1,1,'HN01');
INSERT INTO giohang (magh) VALUES (1);
INSERT INTO giohang (magh) VALUES (2);
INSERT INTO giohang (magh) VALUES (3);
INSERT INTO khachhang (hoten,email,sdt,matkhau,diachi,magh) VALUES ('xuantu', 'tuxuanbui1111@gmail.com','0562129598','123','b7/8L Tran Dai Nghia HCM','1');
INSERT INTO khachhang (hoten,email,sdt,matkhau,diachi,magh) VALUES ('khaibui', 'buikhai0509@gmail.com','0963959667','123','b7/8L Tran Dai Nghia HCM','2');
INSERT INTO khachhang (hoten,email,sdt,matkhau,diachi,magh) VALUES ('lehuong', 'lethihuong1974@gmail.com','01212587066','123','b7/8L Tran Dai Nghia HCM','3');

INSERT INTO phieunhap (ngay,manv,makho) VALUES (20240614,1,'HN01');
INSERT INTO phieunhap (ngay,manv,makho) VALUES (20240614,1,'HN01');
INSERT INTO ctpn (mapn,mavt,soluong,dongia) VALUES (1,'LG01',10,5000);
