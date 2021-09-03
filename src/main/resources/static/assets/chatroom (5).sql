-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 03, 2021 lúc 11:48 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `chatroom`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `attach`
--

CREATE TABLE `attach` (
  `id` int(11) NOT NULL,
  `messageId` varchar(50) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `attach`
--

INSERT INTO `attach` (`id`, `messageId`, `filename`) VALUES
(103, '2f8213f2-28c7-4fb3-9d5c-d7db92010513', 'f6935936-1f1d-490d-9460-3bcbbce99052.jpg'),
(104, 'd3a1092c-b68e-4d91-8ae4-2697a3ba7354', 'fc5af6f2-b498-4d8f-b7cb-7312103ee05b.jpg'),
(105, 'd3a1092c-b68e-4d91-8ae4-2697a3ba7354', 'a2606642-1319-40f2-921d-6ee3ff27a831.jpg'),
(106, 'd3a1092c-b68e-4d91-8ae4-2697a3ba7354', '1b02ad4b-5d26-4876-8270-9987461bf43f.jpg'),
(107, '64882e9b-c27b-438f-aff5-2cb6e84dc329', '6069c37b-1236-48ee-bae9-39205e75e869.jpg'),
(108, '88e25f1c-32f7-44dc-b0f6-71d6c6bf7807', '3e070ff3-68d9-4752-9fff-619b66badd35.png'),
(110, '601a3dc0-4664-4bf0-b74b-ae1d296c0c42', '81c8eeda-c487-4f7f-a804-f6d84e622a4b.jpg'),
(111, '601a3dc0-4664-4bf0-b74b-ae1d296c0c42', '27dc5f08-636d-4e26-b5b0-a64d84fa0903.jpg'),
(112, '601a3dc0-4664-4bf0-b74b-ae1d296c0c42', 'f2a52d50-1d7d-4dd6-a2cb-1cd1d3e3ebbc.jpg'),
(113, '7e6f5054-56a6-42f2-8861-da659679221d', '8d57e6df-ec7a-4dfd-9575-a49bd0875fd2.jpg'),
(114, '7e6f5054-56a6-42f2-8861-da659679221d', 'e9d5eb1a-65d1-44a0-8fee-c9445fcc1444.jpg'),
(115, '539b3e8b-9a26-4d59-ab85-6547eed5aecd', '5b7aa368-bf08-4a90-8d6a-eae6d29ab684.jpg'),
(116, '539b3e8b-9a26-4d59-ab85-6547eed5aecd', '5231245c-78e6-4ca0-8933-8c6ebffa7190.jpg'),
(117, '3361c27f-e3b2-4136-9a13-d8368aea0733', '525e137c-0524-4d04-885e-b4d597c8e38b.jpg'),
(118, '3361c27f-e3b2-4136-9a13-d8368aea0733', '241eb621-6253-4c9f-b7e3-9ac29d9edb64.jpg'),
(120, 'b3d66859-2604-4d2c-8142-0f5c738e7125', '72c64683-d253-45de-ab53-64182f97b991.jpg'),
(121, '105040bc-3872-4ecc-9a38-68686cc72a53', 'efa5500b-bdb4-43fe-b458-264bef56f602.jpg'),
(123, '105040bc-3872-4ecc-9a38-68686cc72a53', '880f927e-1062-450b-b4ea-6d397c8c44a8.jpg'),
(124, '105040bc-3872-4ecc-9a38-68686cc72a53', '24b4f4d6-1e9c-4fd9-9c3d-e3a927d990f7.jpg'),
(125, '83d86253-3dae-4bb9-8c9e-6651b9811e01', 'f2faad69-781c-40bc-9a57-e2d1def560df.jpg'),
(126, '9686e8c5-6392-455d-b761-5b0f6368f61e', '9fdb3720-164c-4db8-939a-1b2e73c11add.jpg'),
(127, '97e75199-27fc-47d4-a2a4-33a7e5207dac', 'f17fc811-ee21-483b-8cd4-5dc8fa05b31c.jpg'),
(128, '97e75199-27fc-47d4-a2a4-33a7e5207dac', '6f6dc13a-dba7-4eed-b1eb-e550483da94e.jpg'),
(130, '779da550-7ed0-4535-a9d9-7302ad76408c', 'a8627bff-0a82-45cc-8a8e-b0022d526404.docx'),
(131, 'b6a8faff-47ca-4fd5-b59f-3064730dbedd', '7dc0f24d-48f8-4d1b-834c-d38f629c07c6.jpg'),
(134, '2664b0ad-f2d4-4e95-9ed4-3aba9a71eb72', '3b44eb4b-ae11-4b8b-8ed8-d6cad96b66ab.jpg'),
(135, '2664b0ad-f2d4-4e95-9ed4-3aba9a71eb72', 'd9d566c0-848c-43eb-92ab-a7ffdd0129a9.jpg'),
(143, '1053c653-aeb7-434d-9d5a-f45d4b846617', '6449c9ff-ab71-45e4-8c86-239ffa09a75a.jpg'),
(145, 'c021743e-5f0a-4d8c-86b2-2fc2367b9eba', '1edfad88-0bda-456d-b281-c4acce599793.jpg'),
(146, 'c021743e-5f0a-4d8c-86b2-2fc2367b9eba', 'd6179d44-9540-40fe-bdce-8198df809a0c.jpg'),
(147, '076391db-657e-4573-93ad-224f7ff4a1e2', '93c01e25-e328-40d7-9edc-25fb1bdf3518.jpg'),
(148, '07e2bb40-0c2c-49c1-84ed-ef214322a6af', '5b4a8e5b-e38f-4f18-9bdf-62369f7f6e30.jpg'),
(149, 'cec87e23-e02d-41b2-9277-2f2a76157e48', 'ec5fffca-8d7d-4743-a4af-9dc124a6a192.jpg'),
(150, 'cec87e23-e02d-41b2-9277-2f2a76157e48', '786768c3-b52b-4fda-a903-b51f2703a6e4.jpg'),
(151, 'cec87e23-e02d-41b2-9277-2f2a76157e48', 'e83a5ac6-f35a-4dc2-8d06-d735a63d9297.jpg'),
(152, 'cec87e23-e02d-41b2-9277-2f2a76157e48', '065430df-d240-4506-b52d-51eb515bdea1.jpg'),
(153, 'e8de0d6f-1566-42e2-a48c-d669270f49f3', '3633be7d-4be2-468e-a638-c364d29ffc10.jpg'),
(154, 'e8de0d6f-1566-42e2-a48c-d669270f49f3', '1c98467b-46ee-4b5b-a4d0-53e52a171809.jpg'),
(155, '7bab22f5-e0b7-4abe-b5bc-c7bfa70fcefb', '443d9565-9462-4282-8a6c-bddcd8f6c3f2.jpg'),
(156, 'ce376b16-452c-4f7d-94cf-eba0f1810a82', 'f82c6efc-720a-44fa-a068-1313b33e2bba.jpg'),
(157, '9a13e589-02d6-41c5-bbbf-2dc3df6f646e', '5cb2b3ce-9c58-4780-9aad-62188d251c36.jpg'),
(158, 'b8cb64b9-b039-4db7-9337-14cebe9591db', '1f78de9b-0024-4e89-8c00-21fcf0b83d75.gif'),
(159, 'b8cb64b9-b039-4db7-9337-14cebe9591db', '68579242-f8dc-43ba-a9f1-07e5c2dbfa9c.jpg'),
(160, '6ae4dee0-d90f-4dff-a0c1-7bcf59eac97f', '17f7b6d4-47a8-4b40-a535-883546c6b4e3.jpg'),
(161, '6ae4dee0-d90f-4dff-a0c1-7bcf59eac97f', 'ea9be9d3-baf1-419c-b1b5-ce625ca33f1b.jpg'),
(162, 'cc33bc25-17d1-48fb-a326-a92ed86ad71c', '29d9bbc7-6658-4062-91b9-c04b2d4d0174.png'),
(163, 'cc33bc25-17d1-48fb-a326-a92ed86ad71c', '93c64436-a4fb-442c-a3f5-26529dcd2af2.png'),
(164, '803d2e20-25c3-41d4-9e10-5fc3903a19ff', '843af687-eb4e-4222-9b40-9b2a723b4f89.jpg'),
(165, '31bd4b86-80d4-49e4-84b3-74bc3bcbf035', '5b27682a-37ca-4b13-a1b0-a19c1ac4607f.jpg'),
(166, 'cf1c7ef7-4690-4f8e-8c87-5d94628b6b5a', 'e549143e-9971-4066-a885-2e0687dc3425.jpg'),
(167, 'bc3c072c-7137-41d8-a41f-48b6ecbed903', '57f255c6-83b1-4539-9fb4-c5a67584e990.jpg'),
(168, 'bc3c072c-7137-41d8-a41f-48b6ecbed903', 'cfb7e18d-d31d-45b0-a41a-95fbb8e10eea.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `friend`
--

CREATE TABLE `friend` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `friendId` int(11) DEFAULT NULL,
  `day` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `friend`
--

INSERT INTO `friend` (`id`, `userId`, `friendId`, `day`, `status`) VALUES
(1, 1, 3, '2021-09-06', 'FRIEND'),
(2, 3, 2, '2021-09-07', 'FRIEND'),
(3, 1, 3, '2021-09-19', 'WAIT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `message`
--

CREATE TABLE `message` (
  `id` varchar(50) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `roomId` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `content` text DEFAULT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `message`
--

INSERT INTO `message` (`id`, `userId`, `roomId`, `type`, `time`, `content`, `status`) VALUES
('058280e4-9dcb-4f26-83fe-752c0dda5bac', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:54:16', 'lol', 'READ'),
('076391db-657e-4573-93ad-224f7ff4a1e2', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 14:59:03', 'toph', 'READ'),
('07e2bb40-0c2c-49c1-84ed-ef214322a6af', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:00:36', 'ok', 'READ'),
('0d9a835a-db9b-4d81-b2ca-dcfd3b917e06', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:54:42', 'gọi cc😆😜', 'READ'),
('0f276138-1361-452b-a0f7-cb5260e8bf58', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 16:47:03', '😀😀😀😀😀', 'READ'),
('0fe159a5-b02c-43f5-88e3-d5488193cc47', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 17:41:38', 'fdd', 'READ'),
('1', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-02 00:00:00', 'Hello', 'READ'),
('10', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:34:05', 'r', 'READ'),
('100', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 16:33:04', 'ew', 'READ'),
('101', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 16:58:48', 'e', 'READ'),
('102', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:31:14', 're', 'READ'),
('103', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:31:49', 'qqaaa', 'READ'),
('104', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:32:57', 'ưe', 'READ'),
('105', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:33:26', 'àd', 'READ'),
('105040bc-3872-4ecc-9a38-68686cc72a53', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 22:06:22', 'à', 'READ'),
('1053c653-aeb7-434d-9d5a-f45d4b846617', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-30 10:25:06', 'hí', 'READ'),
('106', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:33:31', 'lolo', 'READ'),
('107', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:34:57', 'qưeqwe', 'READ'),
('108', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:36:27', 'wwwwwwwwww', 'READ'),
('109', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:38:48', 'test tin phát', 'READ'),
('11', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:34:24', 'wwwwwwwwwwwww', 'READ'),
('110', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:45:40', 'test cc', 'READ'),
('111', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:46:02', 'test cl', 'READ'),
('112', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:47:25', 'eeeeeeee', 'READ'),
('113', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 17:47:45', 'qqq', 'READ'),
('12', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:34:34', '23444', 'READ'),
('12e40e88-7d1a-4de0-853a-b624e77bf309', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:47:27', 'ek ku', 'READ'),
('13', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:35:40', '1312312', 'READ'),
('14', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:36:03', 'e', 'READ'),
('15', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 12:35:46', 'test phat', 'READ'),
('16', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:07:51', 'ek kuu', 'READ'),
('17', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:12:12', 'eeeeeee', 'READ'),
('18', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:15:33', 'hu', 'READ'),
('19', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:15:39', 'e', 'READ'),
('1e927dfb-daca-401d-9bad-4eec7cdb4aa0', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:42:57', 'qqq', 'READ'),
('1f6a4331-6469-4c98-bc27-2be46f289384', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 22:19:54', 'qqqqqqqqqq', 'READ'),
('2', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-10 05:18:14', 'hiiiiiiiii', 'READ'),
('20', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:18:05', 'ee', 'READ'),
('21', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:20:09', 'w', 'READ'),
('22', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:22:01', 'e', 'READ'),
('23', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:25:37', 'qưe', 'READ'),
('24', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:26:54', 'qưe', 'READ'),
('25', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:28:11', 'ưer', 'READ'),
('26', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:30:30', 'ưer', 'READ'),
('2664b0ad-f2d4-4e95-9ed4-3aba9a71eb72', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-26 14:08:51', 'hí hí', 'READ'),
('27', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:33:48', 'fdđ', 'READ'),
('28', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:34:09', 'eeee', 'READ'),
('29', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:35:37', 'sao', 'READ'),
('2f8213f2-28c7-4fb3-9d5c-d7db92010513', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 20:27:52', 'xem đi', 'READ'),
('2fbb73f2-11f1-4e90-acd8-72c733b56bc9', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-29 14:24:41', 'qqq', 'READ'),
('3', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:23:55', 'alo alo', 'READ'),
('30', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:42:14', 'q', 'READ'),
('30758509-21be-42e6-8e0d-bd68c02909df', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:50:32', 'fd', 'READ'),
('31', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:56:36', 'uuuu', 'READ'),
('3178e8d4-d235-43d7-a3c1-4516e5134d32', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 21:36:45', 'a', 'READ'),
('31bd4b86-80d4-49e4-84b3-74bc3bcbf035', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:56:50', 'sdf', 'READ'),
('32', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 21:56:46', 'eeed', 'READ'),
('33', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 22:05:56', '😍😜😍', 'READ'),
('3361c27f-e3b2-4136-9a13-d8368aea0733', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 22:03:48', 'his his', 'READ'),
('34', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 16:13:50', 'lol', 'READ'),
('35', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 16:31:41', 'ek', 'READ'),
('36', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 16:32:51', 'ekkkkkkk', 'READ'),
('36a974a6-8c50-4de6-8c39-1a871e10db44', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:54:11', 'qw', 'READ'),
('36f9e384-0a20-4708-a85c-df542ab0c40a', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 21:36:28', 'qqq', 'READ'),
('37', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 16:40:59', 'alo alo', 'READ'),
('37a6a3c3-a180-457e-8625-9c90e7b8916d', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-30 10:14:52', 'q', 'READ'),
('38', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 16:41:02', '1234', 'READ'),
('38d359ae-3b8b-4c72-8013-019808b8067f', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 20:18:09', 'xem đi', 'READ'),
('39', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 16:41:04', 'eeee', 'READ'),
('3affdb7f-4b6b-4fa4-bfc9-9b22d1e9ed18', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-30 10:13:39', 'eee', 'READ'),
('3c30f1a5-9992-4ea3-bb41-292b3ef4d6a8', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 20:45:32', 'áaaa', 'READ'),
('3ed70b5b-59c0-4016-9d68-5e5e9fdc53c2', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-29 14:24:38', 'qqq', 'READ'),
('4', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:24:33', 'sao ku', 'READ'),
('40', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 16:52:26', 'eeeee', 'READ'),
('409dd353-a721-4cde-a0de-442e550cf668', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 20:29:19', 'âqs', 'READ'),
('41', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:03:54', 'weew', 'READ'),
('42', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:08:08', 'eefef', 'READ'),
('43', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:19:08', 'w', 'READ'),
('437d329b-5215-4779-bf95-001c199c7642', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-26 14:16:04', 'sdfđ', 'READ'),
('44', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:19:15', 'ew', 'READ'),
('45', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:22:37', 'we', 'READ'),
('45f6b16d-ccfe-4037-9712-60ffd95ca08d', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:43:08', 'qq', 'READ'),
('46', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:24:32', 'werre', 'READ'),
('460b6f47-0318-4aec-b229-39da7e141ed6', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 20:53:04', 'a', 'READ'),
('47', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:28:02', 'werddd', 'READ'),
('48', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:30:31', 'wrsafsaavaa', 'READ'),
('49', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:30:46', 'we', 'READ'),
('497681b7-f484-4e6b-8a93-16d479654d6a', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:50:38', 'hello', 'READ'),
('5', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:26:00', 'w', 'READ'),
('50', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 17:32:05', 'alo alo', 'READ'),
('51', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:47:40', 'qq', 'READ'),
('5187bc2e-24f8-4f44-a7f9-248a0b6e8983', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 20:48:30', 'df', 'READ'),
('52', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:48:01', 'f', 'READ'),
('53', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:48:42', 'wes', 'READ'),
('536f1665-7fe8-4e5a-8f4d-01143c1157a0', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 20:22:35', 'q', 'READ'),
('539b3e8b-9a26-4d59-ab85-6547eed5aecd', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 22:01:36', 'sfd', 'READ'),
('54', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:48:56', 'fw', 'READ'),
('55', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:49:02', 'fd', 'READ'),
('56', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:49:47', 'wer', 'READ'),
('57', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:51:06', 'q', 'READ'),
('58', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:51:52', 'wre', 'READ'),
('59', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:53:51', 'wre', 'READ'),
('5ebf717b-8f3d-45d4-9bf8-e956366fa453', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:53:46', 'fd', 'READ'),
('5f2c32a0-d2e5-40be-b944-0c7c7da9d3e2', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:47:38', 'cc', 'READ'),
('6', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:26:29', 'qqqq', 'READ'),
('60', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:53:54', 'reeeeee', 'READ'),
('601a3dc0-4664-4bf0-b74b-ae1d296c0c42', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 21:46:38', 'xem', 'READ'),
('61', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:54:48', 'wer', 'READ'),
('62', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:54:59', 'ads', 'READ'),
('63', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 20:58:32', 'asfdfs', 'READ'),
('64', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:04:52', 'afsdfaasdf', 'READ'),
('64882e9b-c27b-438f-aff5-2cb6e84dc329', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 20:29:41', 'q', 'READ'),
('65', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:05:13', 'qqqqqqqqqqqqqq', 'READ'),
('66', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:05:23', 'qqqqqqqq', 'READ'),
('66b5b8a6-fa6b-4dca-b852-0221c9bfc258', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:48:48', 'okkk', 'READ'),
('67', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:10:00', 'd', 'READ'),
('68', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:11:08', 'qqqqqqqqqqqqqqqqqqqqqqqqqq', 'READ'),
('69', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:11:16', 'qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq', 'READ'),
('6ae4dee0-d90f-4dff-a0c1-7bcf59eac97f', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:22:41', 'toph', 'READ'),
('6bb9c698-6b97-4def-9340-4d39abda6b2e', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:50:50', 'ok', 'READ'),
('7', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:26:34', 'qqq', 'READ'),
('70', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:11:29', 'àdssssssssssssssssssssssssssssssssssssssssss', 'READ'),
('71', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:11:32', 'e', 'READ'),
('72', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:11:44', 'qưrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrwqerwqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr', 'READ'),
('73', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:12:10', 'ádfasd\nấdfsadf\nádffd', 'READ'),
('74', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:12:17', 'dfffffffffff', 'READ'),
('75', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:12:20', 'ưeeeeeeeeeeefafsdf', 'READ'),
('76', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:22:30', 'fdddddddddddddddddddddddddddddddddddddddddddddddddrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr1233333333333333333333333333', 'READ'),
('77', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:52:09', 'r', 'READ'),
('779da550-7ed0-4535-a9d9-7302ad76408c', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-26 09:33:38', 'aaa', 'READ'),
('78', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:53:23', 'qew', 'READ'),
('781b3a17-3bfb-402c-a655-2956d8325dd3', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-30 10:14:54', 'q', 'READ'),
('78607fb6-11db-4302-a796-d2762616ec18', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-25 20:17:38', 'dddd', 'READ'),
('7892fe14-adc1-44c0-ae87-f8fed4d4caf3', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 09:55:19', 'a', 'READ'),
('79', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-17 21:59:42', 'alo chào các alo chào các alo chào các alo chào các alo chào các alo chào các alo chào các alo chào các', 'READ'),
('7bab22f5-e0b7-4abe-b5bc-c7bfa70fcefb', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:06:08', 'ww', 'READ'),
('7e6f5054-56a6-42f2-8861-da659679221d', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 21:59:46', 'aaaaaaaaaaaaa', 'READ'),
('7ff5246f-7b04-4d5c-b8cb-2d1adc43b8ff', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-25 09:42:18', 'sdf', 'READ'),
('8', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:26:40', 'lool', 'READ'),
('80', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:10:35', 'lol', 'READ'),
('803d2e20-25c3-41d4-9e10-5fc3903a19ff', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:51:46', 'ád', 'READ'),
('81', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:12:31', 'qqq', 'READ'),
('82', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:46:14', 'cmm', 'READ'),
('8225ff31-ea84-4ee0-9d55-4c1b69169384', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-26 14:04:52', 'sss', 'READ'),
('83', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:46:36', 'aaaaaaaaaaaaa', 'READ'),
('83d86253-3dae-4bb9-8c9e-6651b9811e01', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 22:07:08', 'dddđ', 'READ'),
('84', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:46:47', 'qqqq', 'READ'),
('84d3fab7-7605-4353-927d-e91813579589', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 21:59:34', 'asd', 'READ'),
('85', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:47:36', 'nhắn cl', 'READ'),
('86', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:48:10', 'qqqq', 'READ'),
('87', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:48:27', 'aaaaaaaaaaaaa', 'READ'),
('88', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:50:22', 'ừewe', 'READ'),
('888f8227-25b5-4b37-88c3-7198254ab211', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 20:45:42', 'dđ', 'READ'),
('88e25f1c-32f7-44dc-b0f6-71d6c6bf7807', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 21:45:24', 'đc ko', 'READ'),
('89', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:51:47', 'àd', 'READ'),
('8c071fea-0a83-4a24-af33-ea52ad51e601', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 21:40:31', 'aaa', 'READ'),
('9', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-16 10:28:35', 'qq', 'READ'),
('90', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 17:56:43', 'qq', 'READ'),
('91', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 18:01:38', 'ưq', 'READ'),
('92', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 18:02:32', 'fdsd', 'READ'),
('925a43f1-77e6-441f-8a2f-f1640547c644', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 14:35:19', 'teeettttt', 'READ'),
('93', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 18:15:53', 'ưeew', 'READ'),
('94', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-19 18:16:07', 'qqq', 'READ'),
('941bbaed-7b13-4260-89a1-071012915844', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 20:20:43', 'xịn', 'READ'),
('95', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 15:53:37', 'd', 'READ'),
('96', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 15:54:20', 'sao ku', 'READ'),
('9686e8c5-6392-455d-b761-5b0f6368f61e', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 22:11:33', 's', 'READ'),
('96e840b5-6650-4327-9bc4-b48bf3612134', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-26 17:07:11', 'wwwwwwww', 'READ'),
('97', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 15:54:32', 'saf', 'READ'),
('97617037-4ed4-413a-8ccd-f54feec7609e', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 21:58:36', 'q', 'READ'),
('97820b15-143b-4b6d-b187-bd95289f174d', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-25 09:48:16', 'asd', 'READ'),
('97e75199-27fc-47d4-a2a4-33a7e5207dac', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 22:17:22', 'his his', 'READ'),
('98', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 15:54:44', 'qqqqqqqq', 'READ'),
('99', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-22 16:20:12', 'Q', 'READ'),
('9a13e589-02d6-41c5-bbbf-2dc3df6f646e', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:12:22', 'qqqq', 'READ'),
('ae406f47-b6e9-4a36-a31c-0fc5bc3fb433', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 20:48:37', 'dffffffffff', 'READ'),
('b0f7bb81-8192-4ad1-8020-a8150f0c8aec', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-30 10:11:46', 'sdf', 'READ'),
('b3d66859-2604-4d2c-8142-0f5c738e7125', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 22:05:42', 'nốt', 'READ'),
('b6a8faff-47ca-4fd5-b59f-3064730dbedd', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-26 11:28:29', 'aaaaaaaaaaa', 'READ'),
('b8cb64b9-b039-4db7-9337-14cebe9591db', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:21:17', 'sfd', 'READ'),
('b9b82a34-6db2-4bd7-82cf-f494dc6a817a', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:45:11', 'w', 'READ'),
('ba33f5b0-a8da-438a-b1af-acdfe5cce324', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-30 10:14:55', 'q', 'READ'),
('bac4009b-eaf1-4f4c-89ba-3b02214bbf50', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-25 22:05:27', 'oke', 'READ'),
('bc25b0ab-5750-4a1b-8ab0-e95dc85beeb5', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-29 14:24:46', 'ư', 'READ'),
('bc3c072c-7137-41d8-a41f-48b6ecbed903', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:59:52', 'toph', 'READ'),
('beacec56-5cad-474a-954e-80d979a117c6', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:54:02', 'q', 'READ'),
('bfd78700-cace-4ac5-beee-7c7d5bfcc092', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 17:41:33', 'asfdsf', 'READ'),
('c021743e-5f0a-4d8c-86b2-2fc2367b9eba', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 14:57:58', 'oke', 'READ'),
('c2494de3-f09a-4fd1-9cc1-25e0a30c0936', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 17:41:43', 'qqq', 'READ'),
('c384cc01-32cf-4080-aae0-8417c34d994a', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-30 10:14:51', 'q', 'READ'),
('cc33bc25-17d1-48fb-a326-a92ed86ad71c', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:49:16', 'okkk', 'READ'),
('ce376b16-452c-4f7d-94cf-eba0f1810a82', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:07:13', 'sdf', 'READ'),
('cec87e23-e02d-41b2-9277-2f2a76157e48', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:00:46', 'yes', 'READ'),
('cf1c7ef7-4690-4f8e-8c87-5d94628b6b5a', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:58:50', 'pro', 'READ'),
('d3a1092c-b68e-4d91-8ae4-2697a3ba7354', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-08-25 20:28:41', 'nữa', 'READ'),
('d46a93b2-9bd9-4211-90a1-512a2c44f385', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 17:41:09', 'aaaaaaaaaaaaaa', 'READ'),
('dba128a1-d8b0-4ec5-b7b0-e631b9d21933', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 21:59:25', 'sfa', 'READ'),
('ddbac792-7eda-4029-8497-ed10a1c95308', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:54:22', 'sdf', 'READ'),
('e1cb02f0-27ad-4334-8c15-45c7226539d7', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-23 22:20:20', 'qqq', 'READ'),
('e59556e0-a576-4710-a000-dd49e9ebb3cd', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-30 10:14:57', 'q', 'READ'),
('e828f9c8-7d29-4ecb-988e-f300868d48e5', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:51:55', 'df', 'READ'),
('e8de0d6f-1566-42e2-a48c-d669270f49f3', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'ATTACK', '2021-09-01 15:02:40', 'okkk', 'READ'),
('ed1c0464-cad4-4a3d-9ae9-12399d13aa8f', 3, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-09-01 14:48:52', 'ư', 'READ'),
('f089867a-16e5-4755-85a6-772d67267506', 1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 'CHAT', '2021-08-24 20:24:56', 'qqqqqqqqqqqqqqqqqq', 'READ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

CREATE TABLE `room` (
  `id` varchar(50) NOT NULL,
  `groupchat` bit(1) DEFAULT NULL,
  `name` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`id`, `groupchat`, `name`) VALUES
('a9cf354e-3c24-45b8-85f4-8a46197a15cd', b'0', 0),
('e35eb390-8854-4d74-aba5-7023d2c22f61', b'0', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roomdetail`
--

CREATE TABLE `roomdetail` (
  `id` int(11) NOT NULL,
  `roomId` varchar(50) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `roomdetail`
--

INSERT INTO `roomdetail` (`id`, `roomId`, `userId`) VALUES
(1, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 1),
(2, 'a9cf354e-3c24-45b8-85f4-8a46197a15cd', 3),
(3, 'e35eb390-8854-4d74-aba5-7023d2c22f61', 3),
(4, 'e35eb390-8854-4d74-aba5-7023d2c22f61', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  `lastonline` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `firstname`, `lastname`, `email`, `password`, `image`, `birthdate`, `role`, `lastonline`) VALUES
(1, 'admin', 'Thành', 'Nguyễn Đức', 'admin@gmail.com', '$2a$10$6LZucgkwCfXT8c0UWxp4tOYY1dH0frALxeFW4GnEJJwqU0f5epDgC', 'avt.png', '2021-08-03', 'ROLE_ADMIN', '0000-00-00 00:00:00'),
(2, 'trung', 'Trung', 'Nguyễn Đức', 'trung@gmail.com', '$2a$10$6LZucgkwCfXT8c0UWxp4tOYY1dH0frALxeFW4GnEJJwqU0f5epDgC', 'avt.png', '2021-08-01', 'ROLE_ADMIN', '0000-00-00 00:00:00'),
(3, 'quang', 'Quang', 'Đặng Tiến', 'quang@gmail.com', '$2a$10$6LZucgkwCfXT8c0UWxp4tOYY1dH0frALxeFW4GnEJJwqU0f5epDgC', 'avt.png', '2021-07-12', 'ROLE_ADMIN', '0000-00-00 00:00:00');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `attach`
--
ALTER TABLE `attach`
  ADD PRIMARY KEY (`id`),
  ADD KEY `messageId` (`messageId`);

--
-- Chỉ mục cho bảng `friend`
--
ALTER TABLE `friend`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`),
  ADD KEY `friendId` (`friendId`);

--
-- Chỉ mục cho bảng `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`),
  ADD KEY `roomId` (`roomId`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `roomdetail`
--
ALTER TABLE `roomdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `roomId` (`roomId`),
  ADD KEY `userId` (`userId`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `attach`
--
ALTER TABLE `attach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=169;

--
-- AUTO_INCREMENT cho bảng `friend`
--
ALTER TABLE `friend`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `roomdetail`
--
ALTER TABLE `roomdetail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `attach`
--
ALTER TABLE `attach`
  ADD CONSTRAINT `attach_ibfk_1` FOREIGN KEY (`messageId`) REFERENCES `message` (`id`);

--
-- Các ràng buộc cho bảng `friend`
--
ALTER TABLE `friend`
  ADD CONSTRAINT `friend_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `friend_ibfk_2` FOREIGN KEY (`friendId`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`);

--
-- Các ràng buộc cho bảng `roomdetail`
--
ALTER TABLE `roomdetail`
  ADD CONSTRAINT `roomdetail_ibfk_1` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `roomdetail_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
