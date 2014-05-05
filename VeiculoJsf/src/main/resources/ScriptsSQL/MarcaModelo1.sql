use veiculojsf_db;




#todas marcas e modelos de carros



INSERT INTO `marca` (`mar_id`, `mar_nome`, `mar_flag`) VALUES
(1, 'Agrale', 1),
(2, 'Aston Martin', 1),
(3, 'Audi', 1),
(4, 'Bentley', 1),
(5, 'BMW', 1),
(6, 'Changan', 1),
(7, 'Chery', 1),
(8, 'GM/Chevrolet', 1),
(9, 'Chrysler', 1),
(10, 'Citroën', 1),
(11, 'Dodge', 1),
(12, 'Effa', 1),
(13, 'Ferrari', 1),
(14, 'Fiat', 1),
(15, 'Ford', 1),
(16, 'Geely', 1),
(17, 'Hafei', 1),
(18, 'Honda', 1),
(19, 'Hyundai', 1),
(20, 'Iveco', 1),
(21, 'Jac Motors', 1),
(22, 'Jaguar', 1),
(23, 'Jeep', 1),
(24, 'Jinbei', 1),
(25, 'Kia', 1),
(26, 'Lamborghini', 1),
(27, 'Land Rover', 1),
(28, 'Lifan', 1),
(29, 'Mahindra', 1),
(30, 'Mahindra', 1),
(31, 'Maserati', 1),
(32, 'Mercedes-Benz', 1),
(33, 'MG Motors', 1),
(34, 'Mini', 1),
(35, 'Mitsubishi', 1),
(36, 'Nissan', 1),
(37, 'Peugeot', 1),
(38, 'Porsche', 1),
(39, 'Ram', 1),
(40, 'Renault', 1),
(41, 'Smart', 1),
(42, 'Ssangyong', 1),
(43, 'Subaru', 1),
(44, 'Suzuki', 1),
(45, 'Toyota', 1),
(46, 'Troller', 1),
(47, 'Volkswagen', 1),
(48, 'Volvo', 1),
(49, 'Yamaha',1),
(50, 'Kawasaki',1),
(51, 'Kasinski',1),
(52, 'Harley-Davidson',1),
(53, 'Ducati',1),
(54, 'Sundown',1),
(55, 'Dafra',1);



INSERT INTO `modelo` (`mod_id`, `mod_nome`, `mod_flag`, `mar_id`) VALUES

#Agrale
(1, 'Marruá', 1, 1),

#Aston Martin
(2, 'DB9 Volante', 1, 2),
(3, 'DBS Coupe', 1, 2),
(4, 'DBS Volante', 1, 2),
(5, 'Rapide', 1, 2),
(6, 'V12 Vantage Coupe', 1, 2),
(7, 'V8 Vantage Coupe', 1, 2),
(8, 'V8 Vantage Roadster', 1, 2),
(9, 'Virage', 1, 2),

#Audi
(10, 'A1', 1, 3),
(11, 'A3', 1, 3),
(12, 'A3 Sedan', 1, 3),
(13, 'A4 Avant', 1, 3),
(14, 'A4 Sedã', 1, 3),
(15, 'A5', 1, 3),
(16, 'A7', 1, 3),
(17, 'A8', 1, 3),
(18, 'Q5', 1, 3),
(19, 'Q7', 1, 3),
(20, 'R8', 1, 3),
(21, 'R8 GT', 1, 3),
(22, 'RS 3 Sportback', 1, 3),
(23, 'RS 5', 1, 3),
(24, 'RS6 Avant', 1, 3),
(25, 'TT Coupé', 1, 3),
(26, 'TT Roadster', 1, 3),

#Bentley
(27, 'Continental Flying Spur', 1, 4),
(28, 'Continental Supersports Coupé', 1, 4),

#BMW
(29, 'Série 1', 1, 5),
(30, 'Série 1 Cabrio', 1, 5),
(31, 'Série 1 Coupé', 1, 5),
(32, 'Série 1 M', 1, 5),
(33, 'Série 3 Cabrio', 1, 5),
(34, 'Série 3 M3 Coupé', 1, 5),
(35, 'Série 3 M3 Sedã', 1, 5),
(36, 'Série 3 Sedã', 1, 5),
(37, 'Série 5 Gran Turismo', 1, 5),
(38, 'Série 5 Sedã', 1, 5),
(39, 'Série 7 Sedã', 1, 5),
(40, 'X1', 1, 5),
(41, 'X3', 1, 5),
(42, 'X5', 1, 5),
(43, 'X6', 1, 5),
(44, 'Z4 Roadster', 1, 5),

#Changan
(45, 'Chana Cargo', 1, 6),
(46, 'Chana Family', 1, 6),
(47, 'Chana Utility', 1, 6),

#Chery
(48, 'Celer Hatch', 1, 7),
(49, 'Celer Sedan', 1, 7),
(50, 'Cielo Hatch', 1, 7),
(51, 'Cielo Sedan', 1, 7),
(52, 'Face', 1, 7),
(53, 'QQ', 1, 7),
(54, 'S-18', 1, 7),
(55, 'Tiggo', 1, 7),

#GM/Chevrolet
(56, 'Agile', 1, 8),
(57, 'Astra Hatch', 1, 8),
(58, 'Astra Sedan', 1, 8),
(59, 'Blazer', 1, 8),
(60, 'Camaro', 1, 8),
(61, 'Captiva', 1, 8),
(62, 'Celta', 1, 8),
(63, 'Classic', 1, 8),
(64, 'Cobalt', 1, 8),
(65, 'Corsa Hatch', 1, 8),
(66, 'Corsa Sedã', 1, 8),
(67, 'Cruze', 1, 8),
(68, 'Cruze Sport6', 1, 8),
(69, 'Malibu', 1, 8),
(70, 'Meriva', 1, 8),
(71, 'Montana', 1, 8),
(72, 'Omega', 1, 8),
(73, 'Onix', 1, 8),
(74, 'Prisma', 1, 8),
(75, 'S10', 1, 8),
(76, 'Sonic', 1, 8),
(77, 'Spin', 1, 8),
(78, 'Tracker', 1, 8),
(79, 'Trailblazer', 1, 8),
(80, 'Vectra', 1, 8),
(81, 'Vectra GT', 1, 8),
(82, 'Zafira', 1, 8),

#Chrysler
(83, '300C', 1, 9),
(84, 'Town & Country', 1, 9),

#Citroën
(85, 'Aircross', 1, 10),
(86, 'C3', 1, 10),
(87, 'C3 Picasso', 1, 10),
(88, 'C4', 1, 10),
(89, 'C4 Pallas', 1, 10),
(90, 'C4 Picasso', 1, 10),
(91, 'C5', 1, 10),
(92, 'C5 Tourer', 1, 10),
(93, 'DS3', 1, 10),
(94, 'DS5', 1, 10),
(95, 'Jumper', 1, 10),
(96, 'Xsara Picasso', 1, 10),

#Dodge
(97, 'Journey', 1, 11),

#Effa
(98, 'Effa Hafei Furgão', 1, 12),
(99, 'Effa Hafei Picape Baú', 1, 12),
(100, 'Effa Hafei Picape Cabine Dupla', 1, 12),
(101, 'Effa Hafei Picape Cabine Simples', 1, 12),
(102, 'Effa Hafei Van', 1, 12),
(103, 'Effa M100', 1, 12),

#Ferrari
(104, '458', 1, 13),
(105, 'California', 1, 13),
(106, 'F599 GTO', 1, 13),

#Fiat
(107, '500', 1, 14),
(108, 'Bravo', 1, 14),
(109, 'Doblò', 1, 14),
(110, 'Doblò Cargo', 1, 14),
(111, 'Ducato', 1, 14),
(112, 'Fiorino', 1, 14),
(113, 'Freemont', 1, 14),
(114, 'Grand Siena', 1, 14),
(115, 'Idea', 1, 14),
(116, 'Linea', 1, 14),
(117, 'Mille', 1, 14),
(118, 'Palio', 1, 14),
(119, 'Palio Adventure', 1, 14),
(120, 'Palio Weekend', 1, 14),
(121, 'Punto', 1, 14),
(122, 'Siena EL', 1, 14),
(123, 'Strada', 1, 14),
(124, 'Uno', 1, 14),

#Ford
(125, 'Courier', 1, 15),
(126, 'EcoSport', 1, 15),
(127, 'Edge', 1, 15),
(128, 'F-250', 1, 15),
(129, 'Fiesta Rocam Hatch', 1, 15),
(130, 'Fiesta Rocam Sedan', 1, 15),
(131, 'Focus Hatch', 1, 15),
(132, 'Focus Sedan', 1, 15),
(133, 'Fusion', 1, 15),
(134, 'Ka', 1, 15),
(135, 'New Fiesta', 1, 15),
(136, 'New Fiesta Hatch', 1, 15),
(137, 'Ranger', 1, 15),
(138, 'Transit', 1, 15),

#Geely
(139, 'EC7', 1, 16),

#Hafei
(140, 'Pick-up', 1, 17),
(141, 'Towner Furgão', 1, 17),
(142, 'Towner Jr', 1, 17),
(143, 'Towner Passageiro', 1, 17),

#Honda
(144, 'Accord', 1, 18),
(145, 'CR-V', 1, 18),
(146, 'City', 1, 18),
(147, 'Civic', 1, 18),
(148, 'Fit', 1, 18),

#Hyundai
(149, 'Azera', 1, 19),
(150, 'Equus', 1, 19),
(151, 'HB20', 1, 19),
(152, 'HB20S', 1, 19),
(153, 'HB20X', 1, 19),
(154, 'HR', 1, 19),
(155, 'Santa Fe', 1, 19),
(156, 'Sonata', 1, 19),
(157, 'Tucson', 1, 19),
(158, 'Veloster', 1, 19),
(159, 'Veracruz', 1, 19),
(160, 'i30', 1, 19),
(161, 'i30 CW', 1, 19),
(162, 'iX35', 1, 19),

#Iveco
(163, 'Daily 35S14', 1, 20),

#Jac Motors
(164, 'J2', 1, 21),
(165, 'J3', 1, 21),
(166, 'J3 Turin', 1, 21),
(167, 'J5', 1, 21),
(168, 'J6', 1, 21),

#Jaguar
(169, 'XF Premium Luxury', 1, 22),
(170, 'XJ Supersport', 1, 22),
(171, 'XKR', 1, 22),

#Jeep
(172, 'Cherokee', 1, 23),
(173, 'Grand Cherokee', 1, 23),
(174, 'Wrangler', 1, 23),

#Jinbei
(175, 'Topic Furgão', 1, 24),
(176, 'Topic Passageiro', 1, 24),

#Kia
(177, 'Bongo', 1, 25),
(178, 'Cadenza', 1, 25),
(179, 'Carens', 1, 25),
(180, 'Carnival', 1, 25),
(181, 'Cerato', 1, 25),
(182, 'Mohave', 1, 25),
(183, 'Optima', 1, 25),
(184, 'Picanto', 1, 25),
(185, 'Sorento', 1, 25),
(186, 'Soul', 1, 25),
(187, 'Sportage', 1, 25),

#Lamborghini
(188, 'Gallardo LP 560 - 4', 1, 26),
(189, 'Gallardo LP 560 - 4 Spyder', 1, 26),

#Land Rover
(190, 'Defender', 1, 27),
(191, 'Discovery 4', 1, 27),
(192, 'Freelander 2', 1, 27),
(193, 'Range Rover Evoque', 1, 27),
(194, 'Range Rover Sport', 1, 27),
(195, 'Range Rover Vogue', 1, 27),

#Lifan
(196, '320', 1, 28),
(197, '620', 1, 28),

#Mahindra
(198, 'Mahindra Picape', 1, 29),
(199, 'Mahindra SUV', 1, 29),

#Maserati
(200, 'Gran Cabrio', 1, 30),
(201, 'Gran Turismo', 1, 30),
(202, 'Quattroporte', 1, 30),

#Mercedes-Benz
(203, 'CLA', 1, 31),
(204, 'Classe A', 1, 31),
(205, 'Classe B', 1, 31),
(206, 'Classe C', 1, 31),
(207, 'Classe C 250 Turbo Sport', 1, 31),
(208, 'Classe C 63 AMG Touring', 1, 31),
(209, 'Classe CL', 1, 31),
(210, 'Classe CLS 63 AMG', 1, 31),
(211, 'Classe E', 1, 31),
(212, 'Classe G', 1, 31),
(213, 'Classe GL', 1, 31),
(214, 'Classe GLK', 1, 31),
(215, 'Classe M', 1, 31),
(216, 'Classe S', 1, 31),
(217, 'Classe S 400 Hybrid', 1, 31),
(218, 'Classe SLK', 1, 31),
(219, 'Classe SLS AMG', 1, 31),

#MG Motors
(220, 'MG 550', 1, 32),
(221, 'MG 6', 1, 32),

#Mini
(222, 'Cooper', 1, 33),
(223, 'Cooper Cabrio', 1, 33),
(224, 'Cooper Countryman', 1, 33),
(225, 'Cooper S Clubman-Hampton', 1, 33),
(226, 'One', 1, 33),

#Mitsubishi
(227, 'ASX', 1, 34),
(228, 'L200 Outdoor', 1, 34),
(229, 'L200 Savana', 1, 34),
(230, 'L200 Triton', 1, 34),
(231, 'Lancer Evolution X', 1, 34),
(232, 'Outlander', 1, 34),
(233, 'Pajero Dakar', 1, 34),
(234, 'Pajero Full', 1, 34),
(235, 'Pajero Sport', 1, 34),
(236, 'Pajero TR4', 1, 34),

#Nissan
(237, 'Frontier', 1, 35),
(238, 'Grand Livina', 1, 35),
(239, 'Livina', 1, 35),
(240, 'March', 1, 35),
(241, 'Sentra', 1, 35),
(242, 'Tiida Hatch', 1, 35),
(243, 'Tiida Sedan', 1, 35),
(244, 'Versa', 1, 35),

#Peugeot
(245, '207', 1, 36),
(246, '207 SW', 1, 36),
(247, '207 Sedan', 1, 36),
(248, '208', 1, 36),
(249, '3008', 1, 36),
(250, '307', 1, 36),
(251, '308', 1, 36),
(252, '308 CC', 1, 36),
(253, '408', 1, 36),
(254, '508', 1, 36),
(255, 'Boxer', 1, 36),
(256, 'Hoggar', 1, 36),
(257, 'Partner', 1, 36),
(258, 'RCZ', 1, 36),

#Porsche
(259, '911', 1, 37),
(260, 'Boxster', 1, 37),
(261, 'Boxster S', 1, 37),
(262, 'Cayenne', 1, 37),
(263, 'Cayman', 1, 37),
(264, 'Cayman S', 1, 37),
(265, 'Panamera', 1, 37),

#Ram
(266, '2500', 1, 38),

#Renault
(267, 'Clio', 1, 39),
(268, 'Duster', 1, 39),
(269, 'Fluence', 1, 39),
(270, 'Grand Tour', 1, 39),
(271, 'Kangoo Express', 1, 39),
(272, 'Logan', 1, 39),
(273, 'Master', 1, 39),
(274, 'Sandero', 1, 39),
(275, 'Sandero Stepway', 1, 39),
(276, 'Symbol', 1, 39),

#Smart
(277, 'Fortwo MHD', 1, 40),
(278, 'Fortwo Passion Cabrio', 1, 40),
(279, 'Fortwo Passion Coupé', 1, 40),

#Ssangyong
(280, 'Actyon Sports', 1, 41),
(281, 'Korando', 1, 41),
(282, 'Kyron', 1, 41),

#Subaru
(283, 'Forester', 1, 42),
(284, 'Impreza Hatch', 1, 42),
(285, 'Impreza Sedã', 1, 42),
(286, 'Legacy', 1, 42),
(287, 'Outback', 1, 42),
(288, 'Tribeca', 1, 42),

#Suzuki
(289, 'Grand Vitara', 1, 43),
(290, 'Jimny', 1, 43),
(291, 'SX4', 1, 43),

#Toyota
(292, 'Camry', 1, 44),
(293, 'Corolla', 1, 44),
(294, 'Etios Hatch', 1, 44),
(295, 'Etios Sedã', 1, 44),
(296, 'Hilux', 1, 44),
(297, 'Prius', 1, 44),
(298, 'RAV4', 1, 44),
(299, 'SW4', 1, 44),

#Troller
(300, 'T4', 1, 45),

#Volkswagen
(301, 'Amarok', 1, 46),
(302, 'Crossfox', 1, 46),
(303, 'Fox', 1, 46),
(304, 'Fusca', 1, 46),
(305, 'Gol', 1, 46),
(307, 'Gol G4', 1, 46),
(308, 'Golf', 1, 46),
(309, 'Jetta', 1, 46),
(310, 'Jetta Variant', 1, 46),
(311, 'Kombi', 1, 46),
(312, 'Parati', 1, 46),
(313, 'Passat', 1, 46),
(314, 'Passat Variant', 1, 46),
(315, 'Polo', 1, 46),
(316, 'Polo Sedan', 1, 46),
(317, 'Saveiro', 1, 46),
(318, 'Space Cross', 1, 46),
(319, 'SpaceFox', 1, 46),
(320, 'Tiguan', 1, 46),
(321, 'Touareg', 1, 46),
(322, 'Up!', 1, 46),
(323, 'Voyage', 1, 46),

#Volvo
(324, 'C30', 1, 47),
(325, 'S60', 1, 47),
(326, 'V40', 1, 47),
(327, 'XC60', 1, 47),
(328, 'XC90', 1, 47);


