-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th10 28, 2019 lúc 12:53 PM
-- Phiên bản máy phục vụ: 5.7.23
-- Phiên bản PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shopgame`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donmua`
--


CREATE TABLE IF NOT EXISTS `donmua` (
  `Madonmua` int(11) NOT NULL AUTO_INCREMENT,
  `Mataikhoan` int(11) NOT NULL,
  `Manguoidung` varchar(50) NOT NULL,
  `Ngaymua` datetime NOT NULL,
  PRIMARY KEY (`Madonmua`),
  KEY `DONMUA_TAK_FK_idx` (`Mataikhoan`),
  KEY `DONMUA_NGD_FK_idx` (`Manguoidung`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hinhanh`
--


CREATE TABLE IF NOT EXISTS `hinhanh` (
  `Mahinhanh` int(11) NOT NULL AUTO_INCREMENT,
  `Mataikhoan` int(11) NOT NULL,
  `Hinhanh` longblob,
  PRIMARY KEY (`Mahinhanh`),
  KEY `HINHANH_TAK_FK_idx` (`Mataikhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE IF NOT EXISTS `nguoidung` (
  `Tendangnhap` varchar(50) NOT NULL,
  `Kichhoat` bit(1) NOT NULL,
  `Matkhau` varchar(100) NOT NULL,
  `Kieunguoidung` varchar(50) NOT NULL,
  `Tennguoidung` varchar(255) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Sodienthoai` varchar(50) NOT NULL,
  `Tien` double NOT NULL,
  PRIMARY KEY (`Tendangnhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`Tendangnhap`, `Kichhoat`, `Matkhau`, `Kieunguoidung`, `Tennguoidung`, `Email`, `Sodienthoai`, `Tien`) VALUES
('phu', b'1', '123', 'QUAN_TRI', 'Ngọc Phú', 'ngocphu@gmail.com', '152121012', 0);


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--


CREATE TABLE IF NOT EXISTS `taikhoan` (
  `Ma` int(11) NOT NULL AUTO_INCREMENT,
  `Loai` varchar(255) NOT NULL,
  `Gia` double NOT NULL,
  `Vip` int(11) NOT NULL,
  `Mua` bit(1) DEFAULT NULL,
  `Tentaikhoan` varchar(255) NOT NULL,
  `Matkhautaikhoan` varchar(255) NOT NULL,
  `Thongtin` varchar(255) NOT NULL,
  `Cauhoibaomat` varchar(255) NOT NULL,
  `Cautraloibaomat` varchar(255) NOT NULL,
  `Emailtaikhoan` varchar(50) DEFAULT NULL,
  `CMND` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Ma`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `donmua`
--
ALTER TABLE `donmua`
  ADD CONSTRAINT `DONMUA_NGD_FK` FOREIGN KEY (`Manguoidung`) REFERENCES `nguoidung` (`Tendangnhap`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `DONMUA_TAK_FK` FOREIGN KEY (`Mataikhoan`) REFERENCES `taikhoan` (`Ma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hinhanh`
--
ALTER TABLE `hinhanh`
  ADD CONSTRAINT `HINHANH_TAK_FK` FOREIGN KEY (`Mataikhoan`) REFERENCES `taikhoan` (`Ma`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
