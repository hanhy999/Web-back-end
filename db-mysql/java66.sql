-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 09, 2023 lúc 04:40 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java66`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `id` bigint(20) NOT NULL,
  `email` varchar(200) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`id`, `email`, `name`, `password`, `role`, `username`) VALUES
(34, 'truongvan6322@gmail.com22', 'HUHU', 'YUusPptmhlRTchtm2hehyw==', 'user', 'admin'),
(38, 'ádasd', 'Kenedy', '12345', 'admin', 'user'),
(48, 'truongvan6322@gmail.com23', 'HUHU', 'YUusPptmhlRTchtm2hehyw==', 'user', 'test213'),
(51, '123@gmail.com', '12312', 'rhxbeAGTL9QW8/CbE+0/8g==', 'user', 'user231'),
(52, 'truongvan6322@gmail.comádd', 'quyne', 'Hh3wadSSzlDo5agAN0KHGEto3QDfdRNIk7yTmaodblk=', 'user', 'adminnew'),
(58, 'ádasđsad', 'áda', 'H9FMam8z7+FgZ7lXQNHAAQ==', 'user', 'ád'),
(61, 'truongvan6322@gmail.comádasd', 's', 'YUusPptmhlRTchtm2hehyw==', 'user', 'ok'),
(66, 'truongvan6322@gmail.com2m', 'mails', 'YUusPptmhlRTchtm2hehyw==', 'user', 'mail'),
(74, 'truongvan6322@gmail.com23', 'dangky', 'YUusPptmhlRTchtm2hehyw==', 'user', 'dangkyroi'),
(81, 'truongvan6322@gmail.com', 'okk', 'YUusPptmhlRTchtm2hehyw==', 'user', 'okok');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(4, 'Phone'),
(6, 'Clothes'),
(8, 'Books'),
(9, 'Other'),
(14, 'test'),
(15, 'Headphone'),
(16, 'Games'),
(17, 'Charger'),
(18, 'Xiaomi Black Shark123'),
(26, 'joijio');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `coupon`
--

CREATE TABLE `coupon` (
  `id` int(11) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `percent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `coupon`
--

INSERT INTO `coupon` (`id`, `code`, `percent`) VALUES
(1, 'abcjkl', 5),
(2, 'vippro', 10),
(3, 'supper', 20),
(4, 'asdfghjkl', 30);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `accountid` bigint(20) DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `phone_number` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `accountid`, `address`, `create_date`, `email`, `phone_number`) VALUES
(20, 34, 'dklk', '2022-07-30 20:38:36', 'hjk@gmail.com', '234234234234');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_details`
--

CREATE TABLE `order_details` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `posts`
--

CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL,
  `desription` varchar(1000) NOT NULL,
  `image` varchar(1000) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `descriptions` varchar(1000) NOT NULL,
  `image` varchar(1000) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `price` double NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `descriptions`, `image`, `name`, `price`, `category_id`) VALUES
(1, 'no', 'https://cdn1.viettelstore.vn/images/Product/ProductImage/medium/1599441352.jpeg', 'Oppo A55', 3000000, 4),
(2, 'no', 'https://www.xtmobile.vn/vnt_upload/product/08_2019/thumbs/(600x600)_crop_asus-rog-phone-5.jpg', 'Asus ROG 56', 4000000, 4),
(4, 'Dessc', 'https://cdn1.viettelstore.vn/images/Product/ProductImage/medium/308737840.jpeg', 'IPhone ', 20000000, 4),
(5, 'desc', 'https://www.xtmobile.vn/vnt_upload/product/08_2019/thumbs/600_asus-rog-phone-5-pro.jpg', 'Asus ROG', 30000000, 4),
(6, 'ko', 'https://bizweb.dktcdn.net/thumb/large/100/414/728/products/cz-0340.jpg?v=1637578318000', 'Jacket', 20000000, 6),
(7, 'no', 'http://product.hstatic.net/200000260587/product/zve03574_56c04c2460ea433ba173a8f125da8a08_grande.png', 'Shirt', 4000000, 6),
(10, 'ko', 'https://images-na.ssl-images-amazon.com/images/I/41HYYxkFZ+L._SX331_BO1,204,203,200_.jpg', 'test', 100, 8),
(11, '123', 'https://images-na.ssl-images-amazon.com/images/I/91HfjIdXvrL.jpg', 'Clothes3333', 123, 8),
(13, 'desc', 'https://www.xtmobile.vn/vnt_upload/product/08_2019/thumbs/600_asus-rog-phone-5-ultimate.jpg', 'Asus ROG', 30000000, 9),
(14, 'KO', 'https://images.g2a.com/323x433/1x1x0/grand-theft-auto-v-rockstar-key-global/59e5efeb5bafe304c4426c47', 'GTA 5', 500000, 16),
(15, 'KO', 'https://cdn-diddb.nitrocdn.com/zYyORGRiZUAYwgTjejQFTFoToMqXrdYq/assets/static/optimized/rev-8f7f084/wp-content/uploads/2021/10/tai-nghe-bluetooth-meo-b39.jpg', 'RGB', 200000, 15),
(17, 'ko', 'https://www.xtmobile.vn/vnt_upload/product/08_2019/thumbs/600_asus-rog-phone-5-ultimate.jpg', 'Asus ', 20000000, 4);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `coupon`
--
ALTER TABLE `coupon`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjyu2qbqt8gnvno9oe9j2s2ldk` (`order_id`),
  ADD KEY `FK4q98utpd73imf4yhttm3w0eax` (`product_id`);

--
-- Chỉ mục cho bảng `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKijnwr3brs8vaosl80jg9rp7uc` (`category_id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `coupon`
--
ALTER TABLE `coupon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `posts`
--
ALTER TABLE `posts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `FK4q98utpd73imf4yhttm3w0eax` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKjyu2qbqt8gnvno9oe9j2s2ldk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Các ràng buộc cho bảng `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `FKijnwr3brs8vaosl80jg9rp7uc` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
