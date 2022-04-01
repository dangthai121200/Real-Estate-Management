-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 01, 2022 lúc 03:38 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlybds`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batdongsan`
--

CREATE TABLE `batdongsan` (
  `bdsid` int(8) NOT NULL,
  `tinhtrang` int(11) NOT NULL,
  `dientich` float NOT NULL,
  `dongia` float NOT NULL,
  `chieudai` float NOT NULL,
  `chieurong` float NOT NULL,
  `masoqsdd` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hinhanh` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mota` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `huehong` float NOT NULL,
  `tenduong` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sonha` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phuong` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `quan` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thanhpho` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `loaiid` int(11) DEFAULT NULL,
  `khid` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hinhbds`
--

CREATE TABLE `hinhbds` (
  `hinhid` int(8) NOT NULL,
  `hinh` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bdsid` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hopdongchuyennhuong`
--

CREATE TABLE `hopdongchuyennhuong` (
  `cnid` int(8) NOT NULL,
  `giatri` float NOT NULL,
  `ngaylap` date NOT NULL,
  `trangthai` bit(1) NOT NULL,
  `khid` int(8) DEFAULT NULL,
  `bdsid` int(8) DEFAULT NULL,
  `dcid` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hopdongdatcoc`
--

CREATE TABLE `hopdongdatcoc` (
  `dcid` int(8) NOT NULL,
  `ngaylap` date NOT NULL,
  `ngayhethan` date NOT NULL,
  `trangthai` bit(1) NOT NULL,
  `giatri` float NOT NULL,
  `tinhtrang` int(11) NOT NULL,
  `khid` int(8) DEFAULT NULL,
  `bdsid` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hopdongkygui`
--

CREATE TABLE `hopdongkygui` (
  `kgid` int(8) NOT NULL,
  `giatri` float NOT NULL,
  `chiphidv` float NOT NULL,
  `ngaybd` date NOT NULL,
  `ngayketthuc` date NOT NULL,
  `trangthai` bit(1) NOT NULL,
  `khid` int(8) DEFAULT NULL,
  `bdsid` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `khid` int(8) NOT NULL,
  `hoten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachitt` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cmnd` int(9) NOT NULL,
  `ngaysinh` datetime NOT NULL,
  `sodienthoai` int(11) NOT NULL,
  `gioitinh` tinyint(1) NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `loaikh` bit(1) NOT NULL,
  `mota` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trangthai` bit(1) NOT NULL,
  `nvid` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaibds`
--

CREATE TABLE `loaibds` (
  `loaiid` int(11) NOT NULL,
  `tenloai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `nvid` int(8) NOT NULL,
  `taikhoan` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `matkhau` char(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tennv` char(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` int(11) NOT NULL,
  `diachi` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaysinh` date NOT NULL,
  `gioitinh` tinyint(1) NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `doanhthu` float DEFAULT NULL,
  `quyen` bit(1) NOT NULL,
  `trangthai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `yeucaukhachhang`
--

CREATE TABLE `yeucaukhachhang` (
  `ycid` int(8) NOT NULL,
  `dientich` float NOT NULL,
  `vitri` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mota` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL,
  `giat` float NOT NULL,
  `giaf` float NOT NULL,
  `dait` float NOT NULL,
  `daif` float NOT NULL,
  `rongt` float NOT NULL,
  `rongf` float NOT NULL,
  `loaiid` int(11) DEFAULT NULL,
  `khid` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `batdongsan`
--
ALTER TABLE `batdongsan`
  ADD PRIMARY KEY (`bdsid`),
  ADD KEY `loaiid` (`loaiid`),
  ADD KEY `khid` (`khid`);

--
-- Chỉ mục cho bảng `hinhbds`
--
ALTER TABLE `hinhbds`
  ADD PRIMARY KEY (`hinhid`),
  ADD KEY `bdsid` (`bdsid`);

--
-- Chỉ mục cho bảng `hopdongchuyennhuong`
--
ALTER TABLE `hopdongchuyennhuong`
  ADD PRIMARY KEY (`cnid`),
  ADD KEY `khid` (`khid`),
  ADD KEY `bdsid` (`bdsid`),
  ADD KEY `dcid` (`dcid`);

--
-- Chỉ mục cho bảng `hopdongdatcoc`
--
ALTER TABLE `hopdongdatcoc`
  ADD PRIMARY KEY (`dcid`),
  ADD KEY `khid` (`khid`),
  ADD KEY `bdsid` (`bdsid`);

--
-- Chỉ mục cho bảng `hopdongkygui`
--
ALTER TABLE `hopdongkygui`
  ADD PRIMARY KEY (`kgid`),
  ADD KEY `khid` (`khid`),
  ADD KEY `bdsid` (`bdsid`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`khid`),
  ADD KEY `nvid` (`nvid`);

--
-- Chỉ mục cho bảng `loaibds`
--
ALTER TABLE `loaibds`
  ADD PRIMARY KEY (`loaiid`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`nvid`);

--
-- Chỉ mục cho bảng `yeucaukhachhang`
--
ALTER TABLE `yeucaukhachhang`
  ADD PRIMARY KEY (`ycid`),
  ADD KEY `loaiid` (`loaiid`),
  ADD KEY `khid` (`khid`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `batdongsan`
--
ALTER TABLE `batdongsan`
  MODIFY `bdsid` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hinhbds`
--
ALTER TABLE `hinhbds`
  MODIFY `hinhid` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hopdongchuyennhuong`
--
ALTER TABLE `hopdongchuyennhuong`
  MODIFY `cnid` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hopdongdatcoc`
--
ALTER TABLE `hopdongdatcoc`
  MODIFY `dcid` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hopdongkygui`
--
ALTER TABLE `hopdongkygui`
  MODIFY `kgid` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `khid` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loaibds`
--
ALTER TABLE `loaibds`
  MODIFY `loaiid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `nvid` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `yeucaukhachhang`
--
ALTER TABLE `yeucaukhachhang`
  MODIFY `ycid` int(8) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `batdongsan`
--
ALTER TABLE `batdongsan`
  ADD CONSTRAINT `batdongsan_ibfk_1` FOREIGN KEY (`loaiid`) REFERENCES `loaibds` (`loaiid`),
  ADD CONSTRAINT `batdongsan_ibfk_2` FOREIGN KEY (`khid`) REFERENCES `khachhang` (`khid`);

--
-- Các ràng buộc cho bảng `hinhbds`
--
ALTER TABLE `hinhbds`
  ADD CONSTRAINT `hinhbds_ibfk_1` FOREIGN KEY (`bdsid`) REFERENCES `batdongsan` (`bdsid`);

--
-- Các ràng buộc cho bảng `hopdongchuyennhuong`
--
ALTER TABLE `hopdongchuyennhuong`
  ADD CONSTRAINT `hopdongchuyennhuong_ibfk_1` FOREIGN KEY (`khid`) REFERENCES `khachhang` (`khid`),
  ADD CONSTRAINT `hopdongchuyennhuong_ibfk_2` FOREIGN KEY (`bdsid`) REFERENCES `batdongsan` (`bdsid`),
  ADD CONSTRAINT `hopdongchuyennhuong_ibfk_3` FOREIGN KEY (`dcid`) REFERENCES `hopdongdatcoc` (`dcid`);

--
-- Các ràng buộc cho bảng `hopdongdatcoc`
--
ALTER TABLE `hopdongdatcoc`
  ADD CONSTRAINT `hopdongdatcoc_ibfk_1` FOREIGN KEY (`khid`) REFERENCES `khachhang` (`khid`),
  ADD CONSTRAINT `hopdongdatcoc_ibfk_2` FOREIGN KEY (`bdsid`) REFERENCES `batdongsan` (`bdsid`);

--
-- Các ràng buộc cho bảng `hopdongkygui`
--
ALTER TABLE `hopdongkygui`
  ADD CONSTRAINT `hopdongkygui_ibfk_1` FOREIGN KEY (`khid`) REFERENCES `khachhang` (`khid`),
  ADD CONSTRAINT `hopdongkygui_ibfk_2` FOREIGN KEY (`bdsid`) REFERENCES `batdongsan` (`bdsid`);

--
-- Các ràng buộc cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`nvid`) REFERENCES `nhanvien` (`nvid`);

--
-- Các ràng buộc cho bảng `yeucaukhachhang`
--
ALTER TABLE `yeucaukhachhang`
  ADD CONSTRAINT `yeucaukhachhang_ibfk_1` FOREIGN KEY (`loaiid`) REFERENCES `loaibds` (`loaiid`),
  ADD CONSTRAINT `yeucaukhachhang_ibfk_2` FOREIGN KEY (`khid`) REFERENCES `khachhang` (`khid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
