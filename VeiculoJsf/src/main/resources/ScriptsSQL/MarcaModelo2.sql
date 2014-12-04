use veiculojsf_db;




#todas marcas e modelos de motos


INSERT INTO `modelo` (`mod_id`, `mod_nome`, `mod_flag`, `mar_id`) VALUES

#Honda
(329, 'Pop 100', 1, 18),
(330, 'Lead 110', 1, 18),
(331, 'Nova BIZ 125', 1, 18),
(332, 'CG 125 Fan', 1, 18),
(333, 'CG 125 Cargo', 1, 18),
(334, 'CG 150 Fan', 1, 18),
(335, 'CG 150 Titan Mix', 1, 18),
(336, 'NXR 150 Bros', 1, 18),
(337, 'CRF 230F', 1, 18),
(338, 'XRE 300', 1, 18),
(339, 'CB 300R', 1, 18),
(340, 'CB 600F Hornet', 1, 18),
(341, 'XL 700V Transalp', 1, 18),
(342, 'Shadow 750', 1, 18),
(343, 'CBR 600RR', 1, 18),
(344, 'CBR 1000RR Fireblade', 1, 18),
(345, 'VFR 1200F', 1, 18),
(346, 'GL 1800 Gold Wing', 1, 18),
(347, 'TRX 420 FourTrax', 1, 18),

#Yamaha
(348, 'T115 CRYPTON', 1, 49),
(349, 'NEO AT 115', 1, 49),
(350, 'FACTOR YBR 125', 1, 49),
(351, 'FAZER YS250', 1, 49),
(352, 'XTZ 125 X', 1, 49),
(353, 'XJ6 N', 1, 49),
(354, 'XJ6 F', 1, 49),
(355, 'XTZ 125', 1, 49),
(356, 'LANDER XTZ 250', 1, 49),
(357, 'XTZ 250 TÉNÉRÉ', 1, 49),
(358, 'XT 660R', 1, 49),
(359, 'TT-R 125E', 1, 49),
(360, 'TT-R 125LWE', 1, 49),
(361, 'TT-R 230', 1, 49),
(362, 'XVS950A MIDNIGHT STAR', 1, 49),
(363, 'XT 1200Z SUPER TÉNÉRÉ', 1, 49),
(364, 'YZF-R1', 1, 49),
(365, 'YZ 85 LW', 1, 49),
(366, 'YZ 250 F', 1, 49),
(367, 'YZ 450 F', 1, 49),
(368, 'WR 250 F', 1, 49),
(369, 'WR 450 F', 1, 49),
(370, 'GRIZZLY 125', 1, 49),
(371, 'GRIZZLY 350', 1, 49),
(372, 'GRIZZLY 700', 1, 49),
(373, 'YFM 350 R', 1, 49),
(374, 'YFM 700 R', 1, 49),
(375, 'YFZ 450 R', 1, 49),

#Kawasaki
(376, 'Ninja ZX-6R', 1, 50),
(377, 'Ninja ZX-10R', 1, 50),
(378, 'Ninja ZX-14', 1, 50),
(379, 'Ninja 250R', 1, 50),
(380, 'ER-6n', 1, 50),
(381, 'Z750', 1, 50),
(382, 'Z1000', 1, 50),
(383, 'Vulcan 900 Classic', 1, 50),
(384, 'Vulcan 900 Custom', 1, 50),
(385, 'Vulcan 900 Classic LT', 1, 50),
(386, 'D-Tracker X', 1, 50),
(387, 'Versys', 1, 50),
(388, 'KX65', 1, 50),
(389, 'KLX110', 1, 50),
(390, 'KX250F', 1, 50),
(391, 'KX450F', 1, 50),

#Susuki
(392, 'Yes 125 ED CARGO', 1, 44),
(393, 'Yes 125ED', 1, 44),
(394, 'GS500', 1, 44),
(395, 'GSX650F', 1, 44),
(396, 'Bandit 650', 1, 44),
(397, 'Bandit 650S', 1, 44),
(398, 'Bandit 1250', 1, 44),
(399, 'Bandit 1250S', 1, 44),
(400, 'B-King 1300', 1, 44),
(401, 'Intruder 125 ED CARGO', 1, 44),
(402, 'Intruder 125ED', 1, 44),
(403, 'Boulevard M800', 1, 44),
(404, 'Boulevard M1500', 1, 44),
(405, 'Burgman 125 Automatic', 1, 44),
(406, 'Burgman 400 Automatic', 1, 44),
(407, 'Burgman 650', 1, 44),
(408, 'DR-Z400E', 1, 44),
(409, 'DL650 V-Strom', 1, 44),
(410, 'GSX-R750', 1, 44),
(411, 'GSX-R1000', 1, 44),
(412, 'GSX1300R Hayabusa', 1, 44),
(413, 'QuadRunner 160', 1, 44),
(414, 'Ozark 250', 1, 44),
(415, 'KingQuad 400AS 4x4', 1, 44),
(416, 'KingQuad 450AXi 4x4', 1, 44),
(417, 'KingQuad 750AXi 4x4', 1, 44),
(418, 'QuadRacer R450', 1, 44),

#Kasinski
(419, 'Win 110', 1, 51),
(420, 'Prima 150', 1, 51),
(421, 'Prima Electra', 1, 51),
(422, 'CRZ 150', 1, 51),
(423, 'CRZ 150 SM', 1, 51),
(424, 'Mirage 150', 1, 51),
(425, 'Mirage 250', 1, 51),
(426, 'Mirage 650', 1, 51),
(427, 'Comet GT 250', 1, 51),
(428, 'Comet GT 250R', 1, 51),
(429, 'Comet GT 650R', 1, 51),

#Harley-Davidson
(430, '883 Roadster', 1, 52),
(431, 'Iron 883™', 1, 52),
(432, 'XR1200X™', 1, 52),
(433, 'Super Glide® Custom', 1, 52),
(434, 'Super Glide', 1, 52),
(435, 'Road King® Classic', 1, 52),
(436, 'Ultra Classic™ Electra Glide', 1, 52),
(437, 'Fat Boy®', 1, 52),
(438, 'Heritage Softail® Classic', 1, 52),
(439, 'Heritage Custom', 1, 52),
(440, 'Rocker™ C', 1, 52),
(441, 'Fat Boy® Special', 1, 52),
(442, 'Softail Deluxe', 1, 52),
(443, 'V-Rod®', 1, 52),
(444, 'Night Rod® Special', 1, 52),
(445, 'V-Rod Muscle', 1, 52),

#BMW
(446, 'G 450 X ', 1, 5),
(447, 'G 650 GS', 1, 5),
(448, 'F 650 GS', 1, 5),
(449, 'F 800 GS', 1, 5),
(450, 'R 1200 GS', 1, 5),
(451, 'R 1200 GS Adventure', 1, 5),
(452, 'R 1200 RT', 1, 5),
(453, 'F 800 R', 1, 5),
(454, 'K 1300 R', 1, 5),
(455, 'K 1300 S RR', 1, 5),
(456, 'S 1000', 1, 5),

#Ducati
(457, 'Hypermotard 796', 1, 53),
(458, 'Hypermotard 1100 EVO', 1, 53),
(459, 'Monster 696', 1, 53),
(460, 'Monster 1100', 1, 53),
(461, 'Monster 1100 S', 1, 53),
(462, 'Multistrada 1200', 1, 53),
(463, 'Multistrada 1200 S', 1, 53),
(464, 'Streetfighter', 1, 53),
(465, 'Streetfighter S', 1, 53),
(466, 'Superbike 848', 1, 53),
(467, 'Superbike 1198', 1, 53),
(468, 'Superbike 1198 S', 1, 53),

#Sundown
(469, 'MOTARD 125cc', 1, 54),
(470, 'STX 125cc', 1, 54),
(471, 'Web', 1, 54),
(472, 'Web Evo', 1, 54),
(473, 'Future', 1, 54),
(474, 'Future Sport', 1, 54),
(475, 'Hunter 100', 1, 54),
(476, 'Hunter', 1, 54),
(477, 'Max SE', 1, 54),
(478, 'Max SED', 1, 54),

#Dafra
(479, 'Zig', 1, 55),
(480, 'Smart 125', 1, 55),
(481, 'Laser 150', 1, 55),
(482, 'Citycom 300i', 1, 55),
(483, 'Super 50', 1, 55),
(484, 'Super 100', 1, 55),
(485, 'Speed 150', 1, 55),
(486, 'Apache 150', 1, 55),
(487, 'Kansas 150', 1, 55);



