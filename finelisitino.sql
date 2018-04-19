-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Apr 19, 2018 alle 10:09
-- Versione del server: 10.1.16-MariaDB
-- Versione PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pizza`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `approvvigionamenti`
--

CREATE TABLE `approvvigionamenti` (
  `data` int(11) NOT NULL,
  `id_fornitore` int(11) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  `quantita` int(11) NOT NULL,
  `costo_tot` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `clienti`
--

CREATE TABLE `clienti` (
  `nome` varchar(128) NOT NULL,
  `cognome` varchar(128) NOT NULL,
  `indirizzo` varchar(128) NOT NULL,
  `telefono` varchar(128) NOT NULL,
  `id` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `componenti`
--

CREATE TABLE `componenti` (
  `id_ordine` int(6) NOT NULL,
  `prodotto` varchar(128) NOT NULL,
  `quantita` int(6) NOT NULL,
  `costo` decimal(65,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitori`
--

CREATE TABLE `fornitori` (
  `id` int(11) NOT NULL,
  `nome` varchar(128) NOT NULL,
  `telefono` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `sede` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `listino`
--

CREATE TABLE `listino` (
  `id` int(11) NOT NULL,
  `prodotto` varchar(128) NOT NULL,
  `costo` decimal(65,2) NOT NULL,
  `categoria` varchar(128) NOT NULL,
  `descrizione` varchar(230) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `listino`
--

INSERT INTO `listino` (`id`, `prodotto`, `costo`, `categoria`, `descrizione`) VALUES
(1, 'Marinara', '3.40', 'Pizza', 'Pomodoro, olio, origano, aglio'),
(2, 'Biancaneve', '4.40', 'Pizza', 'mozzarella'),
(3, 'Margherita', '4.40', 'Pizza', 'mozzarella, pomodoro'),
(4, 'Funghi', '4.90', 'Pizza', 'mozzarella, pomodoro, funghi'),
(5, 'Luisiana', '4.90', 'Pizza', 'pomodoro, pancetta, cipolla, fagioli'),
(6, 'Napoli', '4.90', 'Pizza', 'mozzarella, pomodoro, acciughe, origano'),
(7, 'Pugliese', '4.90', 'Pizza', 'mozzarella, pomodoro, cipolla'),
(8, 'Brianzola', '5.40', 'Pizza', 'mozzarella, pomodoro, salsiccia'),
(9, 'Calabrese', '5.40', 'Pizza', 'mozzarella, pomodoro, salame piccante'),
(10, 'Leggera', '5.40', 'Pizza', 'pomodoro, spinaci, ricotta, grana'),
(11, 'Patapizza', '5.40', 'Pizza', 'mozzarella, pomodoro, patatine fritte'),
(12, 'Prosciutto', '5.40', 'Pizza', 'mozzarella, pomodoro, prosciutto'),
(13, 'Rucoloa', '5.40', 'Pizza', 'mozzarella, pomodoro, rucola'),
(14, 'Siciliana', '5.40', 'Pizza', 'mozzarella, pomodoro, acciughe, olive, origano'),
(15, 'Wurstel', '5.40', 'Pizza', 'mozzarella, pomodoro, wurstel'),
(16, 'Zola', '5.40', 'Pizza', 'mozzarella, pomodoro, zola'),
(17, 'Braccio di ferro', '5.90', 'Pizza', 'mozzarella, pomodoro, wurstel, spinaci'),
(18, 'Colonnata', '5.90', 'Pizza', 'mozzarella, pomodoro, lardo di colonnata'),
(19, 'Gratinata', '5.90', 'Pizza', 'mozzarella, pomodoro, grana, melanzane'),
(20, 'Messicana', '5.90', 'Pizza', 'pomodoro, salame piccante, fagioli, peperoni, peperoncino'),
(21, 'Prociutto e Funghi', '5.90', 'Pizza', 'mozzarella, pomodoro, prosciutto, funghi'),
(22, 'Romana', '5.90', 'Pizza', 'mozzarella, pomodoro, acciughe, olive, capperi, origano'),
(23, 'Stella', '5.90', 'Pizza', 'mozzarella, pomodoro, salame dolce'),
(24, 'Tonno', '5.90', 'Pizza', 'mozzarella, pomodoro, tonno'),
(25, 'Americana', '6.40', 'Pizza', 'mozzarella, pomodoro, wurstel, patatine fritte'),
(26, 'Contadina', '6.40', 'Pizza', 'mozzarella, pomodoro, uovo, asparagi'),
(27, 'Dinamite', '6.40', 'Pizza', 'mozzarella, pomodoro, pancetta, cipolla, zola'),
(28, 'Monzese', '6.40', 'Pizza', 'mozzarella, pomodoro, salsiccia, scamorza'),
(29, 'Parmese', '6.40', 'Pizza', 'mozzarella, pomodoro, crudo di parma'),
(30, '4 Formaggi', '6.40', 'Pizza', 'mozzarella, pomodoro, fontina, zola, grana'),
(31, '4 Stagioni', '6.40', 'Pizza', 'mozzarella, pomodoro, prosciutto, carciofi, funghi'),
(32, 'Pescatora', '6.40', 'Pizza', 'mozzarella, pomodoro, cipolla, tonno'),
(33, 'Porcini', '6.40', 'Pizza', 'mozzarella, pomodoro, funghi porcini'),
(34, 'Prosciutto e Wurstel', '6.40', 'Pizza', 'mozzarella, pomodoro, prosciutto, wurstel'),
(35, 'Tirolese', '6.40', 'Pizza', 'mozzarella, pomodoro, wurstel, pancetta, crauti'),
(36, 'Trevisana', '6.40', 'Pizza', 'mozzarella, pomodoro, trevisana, scamorza'),
(37, 'Tropea', '6.40', 'Pizza', 'mozzarella, pomodoro, cipolla, pomodoro fresco, grana a scaglie'),
(38, 'Bavarese', '6.90', 'Pizza', 'mozzarella, pomodoro, wurstel, crauti, patate'),
(39, 'Bonton', '6.90', 'Pizza', 'mozzarella, pomodoro, tonno, patate'),
(40, 'Brontolo', '6.90', 'Pizza', 'mozzarella, pomodoro, salame piccante, cipolla, brie'),
(41, 'Capricciosa', '6.90', 'Pizza', 'mozzarella, pomodoro, prosciutto, olive, carciofi, funghi'),
(42, 'Cosacca', '6.90', 'Pizza', 'mozzarella, scamorza, prosciutto di praga'),
(43, 'Del Ronco', '6.90', 'Pizza', 'mozzarella, patate, zola, grana'),
(44, 'Dolcevita', '6.90', 'Pizza', 'mozzarella, pomodoro, speck, peperoni'),
(45, 'Francese', '6.90', 'Pizza', 'mozzarella, pomodoro, brie, prosciutto di praga'),
(46, 'Friabria', '6.90', 'Pizza', 'mozzarella, salsiccia, friarielli'),
(47, 'Genovese', '6.90', 'Pizza', 'mozzarella, rucola, pesto, stracchino'),
(48, 'Primavera', '6.90', 'Pizza', 'mozzarella, pomodoro, rucola, pomodoro fresco, gramna a scaglie'),
(49, 'Rustica', '6.90', 'Pizza', 'mozzarella, pomodoro, speck, rucola'),
(50, 'Saporita', '6.90', 'Pizza', 'mozzarella, pomodoro, speck, rucola'),
(51, 'Strafusa', '6.90', 'Pizza', 'mozzarella, pomodoro, stracchino, funghi, salame piccante'),
(52, 'Sumela', '6.90', 'Pizza', 'mozzarella, pomodoro, salsiccia, patate, funghi, rosmarino'),
(53, 'Treciccia', '6.90', 'Pizza', 'mozzarella, pomodoro, salsiccia, trevisana, grana'),
(54, 'Triveneto', '6.90', 'Pizza', 'mozzarella, pomodoro, speck, trevisana'),
(55, 'Bea', '7.40', 'Pizza', 'mozzarella, pomodoro, prosciutto, zucchine, stracchino'),
(56, 'Buongustaio', '7.40', 'Pizza', 'mozzarella, pomodoro, pancetta, tonno, peperoni'),
(57, 'Canadese', '7.40', 'Pizza', 'mozzarella, pomodoro, salmone'),
(58, 'Carioca', '7.40', 'Pizza', 'mozzarella, pomodoro, salame piccante, zola, peperoni'),
(59, 'Clusoe', '7.40', 'Pizza', 'mozzarella, pomodoro, patate, olive, grana, pomodoro fresco'),
(60, 'Delicata', '7.40', 'Pizza', 'mozzarella, pomodoro, bresaola, taleggio'),
(61, 'Gamberuco', '7.40', 'Pizza', 'mozzarella, pomodoro, gamberetti, rucola'),
(62, 'Montanara', '7.40', 'Pizza', 'mozzarella, pomodoro, spinaci, funghi porcini, grana'),
(63, 'Mostrusa', '7.40', 'Pizza', 'mozzarella, salame piccante, stracchino, rucola'),
(64, 'Ortolana', '7.40', 'Pizza', 'mozzarella, pomodoro, peperoni, zucchine, melanzane'),
(65, 'Sfiziosa', '7.40', 'Pizza', 'mozzarella, pomodoro, Salame dolce, taleggio, mais'),
(66, '4 P', '7.90', 'Pizza', 'mozzarella, pomodoro, funghi porcini, panna, prosciutto'),
(67, 'Albese', '7.90', 'Pizza', 'mozzarella, funghi porcini, olio tartufato, grana a scaglie'),
(68, 'Boscaiola', '7.90', 'Pizza', 'mozzarella, pomodoro, salsiccia, funghi porcini, grana'),
(69, 'Dello Zio', '7.90', 'Pizza', 'mozzarella, pomodoro, grana, zola, gamberetti'),
(70, 'Esosa', '7.90', 'Pizza', 'mozzarella, pomodoro, friarielli, scamorza, salame piccante'),
(71, 'Frutti di mare', '7.90', 'Pizza', 'mozzarella, pomodoro, frutti di mare'),
(72, 'Pantera rosa', '7.90', 'Pizza', 'mozzarella, pomodoro, grana, funghi porcini, asparagi'),
(73, 'Pavel', '7.90', 'Pizza', 'mozzarella, prosciutto di praga, patate, stracchino'),
(74, 'Viennese', '7.90', 'Pizza', 'mozzarella, pomodoro, speck, patate, brie'),
(75, 'Bismark', '8.40', 'Pizza', 'mozzarella, pomodoro, prosciutto cotto, zola, pancetta, grana, uovo'),
(76, 'Bufalina', '8.40', 'Pizza', 'mozzarella, rucola, pomodoro fresco, mozzarella di bufala'),
(77, 'Condita', '8.40', 'Pizza', 'mozzarella, pomodoro, zucchine, zola, gamberetti'),
(78, 'Mari & Monti', '8.40', 'Pizza', 'mozzarella, pomodoro, funhi porcini, gamberetti'),
(79, 'Romagnola', '8.40', 'Pizza', 'mozzarella, pomodoro, crudo di parma, rucola, stracchino'),
(80, 'Tiramisu', '8.40', 'Pizza', 'mozzarella, pomodoro, prosciutto cotto, funghi, carciofi, salame picante, pancetta, olive'),
(81, 'Valtellina', '8.40', 'Pizza', 'mozzarella, pomodoro, funghi porcini, bresaola'),
(82, 'Bomba', '8.90', 'Pizza', 'mozzarella, pomodoro, peperoni, tonno, cipolla, salame piccante, fagioli, peperoncino'),
(83, 'Esotica', '8.90', 'Pizza', 'mozzarella, gamberetti, panna, pomodoro fresco, rucola'),
(84, 'Gustosa', '8.90', 'Pizza', 'mozzarella, pomodoro, lardo di colonnata, taleggio, funghi porcini'),
(85, 'Verderosa', '8.90', 'Pizza', 'mozzarella, panna, rucola, salmone'),
(86, 'Meridiana', '9.40', 'Pizza', 'mozzarella, pomodoro, gamberetti, zucchine, pomodoro fresco, panna, grana'),
(87, 'Regina', '9.40', 'Pizza', 'mozzarella, pomodoro, gamberetti, salmone'),
(88, 'Calzone Liscio', '5.90', 'Pizza', 'mozzarella, pomodoro, prosciutto cotto, grana'),
(89, 'Calzone 4 Formaggi', '6.40', 'Pizza', 'mozzarella, pomodoro, zola, fontina, grana'),
(90, 'Calzone Farcito', '6.40', 'Pizza', 'mozzarella, pomodoro, prosciutto cotto, carciofi, funghi, grana'),
(91, 'Calzone Imperiale', '7.40', 'Pizza', 'mozzarella, pomodoro, rucola, gamberetti'),
(92, 'Focaccia Salata', '2.90', 'Pizza', 'olio, sale'),
(93, 'Focaccia Cotto', '3.90', 'Pizza', 'olio, sale, prosciutto cotto'),
(94, 'Focaccia Colonnata', '4.40', 'Pizza', 'olio, sale'),
(95, 'Focaccia Patate', '4.40', 'Pizza', 'olio, sale, rosmarino, patate, grana'),
(96, 'Focaccia Speck', '4.40', 'Pizza', 'olio, sale, speck'),
(97, 'Focaccia Bresaola', '4.90', 'Pizza', 'olio, sale, bresaola'),
(98, 'Focaccia Filigrana', '4.90', 'Pizza', 'olio, sale, friarielli, grana'),
(99, 'Focaccia Parma', '4.90', 'Pizza', 'olio, sale, crudo di parma'),
(100, 'Focaccia Ortolana', '5.90', 'Pizza', 'olio, sale, peperoni, melanzane, zucchine'),
(101, 'Focaccia Peppa', '5.90', 'Pizza', 'olio, sale, patate, stracchino, pesto, grana'),
(102, 'Focaccia Bufala', '6.90', 'Pizza', 'olio, sale, origano, mozzarella di bufala, rucola, pomodorini'),
(103, 'Focaccia Ripiena Nutella', '3.40', 'Pizza', 'nutella'),
(104, 'Focaccia Ripiena Cotto e Mozza', '4.90', 'Pizza', 'mozzarella, prosciutto cotto'),
(105, 'Focaccia Ripiena Praga Scamorza', '5.40', 'Pizza', 'praga, scamorza'),
(106, 'Focaccia Ripiena Salame e Stracco', '5.40', 'Pizza', 'salame dolce e stracchino'),
(107, 'Focaccia Ripiena Speck e Scamorza', '5.40', 'Pizza', 'speck, scamorza'),
(108, 'Focaccia Ripiena Crudo e Brie', '5.90', 'Pizza', 'crudo di parma, brie'),
(109, 'Baguette Liscia', '5.40', 'Pizza', 'mozzarella, prosciutto cotto'),
(110, 'Baguette Del Tirolo', '6.90', 'Pizza', 'mozzarella, brie, speck'),
(111, 'Baguette Classica', '7.40', 'Pizza', 'mozzarella, crudo di parma, stracchino'),
(112, 'Bacon', '5.50', 'Panino', 'hamburger, pomodoro, insalata, bacon, salsa barbeque'),
(113, 'Krukko', '5.50', 'Panino', 'hamburger, speck, grana a scaglie, vellutata di funghi porcini'),
(114, 'Calabro', '5.50', 'Panino', 'hamburger, cipolla dorata, peperoni arrostiti, n duja, salsa pink'),
(115, 'Cheesebruger', '5.50', 'Panino', 'hamburger, brie, salsa tartara, ketchup, tabasco'),
(116, 'Egg Burger', '5.50', 'Panino', 'hamburger, uovo alla piastra, bacon, cheddar, maionese'),
(117, 'Mex Burger', '5.50', 'Panino', 'hamburger, jalapenos verde, pomodoro, cheddar, guacamole'),
(118, 'Pink Burger', '5.50', 'Panino', 'hamburger, cheddar, insalata, pomodoro, salsa pink'),
(119, 'Chicken Burger', '5.50', 'Panino', 'petto di pollo impanato (100 gr.), insalata, pomodoro, maionese'),
(120, 'Crunch Burger', '7.50', 'Panino', 'petto di pollo impanato (200 gr.), insalata, pomodoro, maionese'),
(121, 'Poldo', '7.50', 'Panino', 'petto di pollo e uovo alla piastra, bacon, insalata, grana a scaglie, maoinese'),
(122, 'Iron Chick', '7.50', 'Panino', 'petto di pollo e uovo alla piastra, cheddar, peperoni arrostiti, pesto, maionese'),
(123, 'Fish Burger', '6.50', 'Panino', 'filetto di merluzzo impanato, insalata, pomodoro, maionese'),
(124, 'Vegan Burger', '6.50', 'Panino', 'hamburger vegano, insalata, pomodoro, guacamole'),
(125, 'Hot Dog', '4.00', 'Panino', 'wurstel, salsa a scelta'),
(126, 'Bread Pig', '5.50', 'Panino', 'salamella, panpizza, peperoni arrostiti, cipolla dorata'),
(127, 'Patatine Fritte', '2.50', 'Stuzzicheria', '240 gr.'),
(128, 'Crocchette di Patate', '2.50', 'Stuzzicheria', '8 pezzi'),
(129, 'Anelli di Cipolla', '2.90', 'Stuzzicheria', '8 pezzi'),
(130, 'Panzerotto pomodoro e mozzarella', '3.00', 'Stuzzicheria', 'pasta della pizza fritta e farcita con pomodoro e mozzarella'),
(131, 'Panzerotto Cotto', '3.00', 'Stuzzicheria', 'pasta della pizza fritta e farcita con pomodoro, mozzarella e prosciutto cotto'),
(132, 'Panzerotto Nutella', '3.00', 'Stuzzicheria', 'pasta della pizza fritta e farcita con della nutella'),
(133, 'Mini Arancini', '3.50', 'Stuzzicheria', '6 pezzi'),
(134, 'Mozzarelline', '3.50', 'Stuzzicheria', '8 pezzi'),
(135, 'Olive Ascolane', '3.50', 'Stuzzicheria', '8 pezzi'),
(136, 'Palline di Melanzane', '3.50', 'Stuzzicheria', '6 pezzi'),
(137, 'Patapollo', '3.50', 'Stuzzicheria', '6 pezzi'),
(138, 'Speedy Pollo', '3.50', 'Stuzzicheria', '8 pezzi'),
(139, 'Verdure in Pastella', '3.50', 'Stuzzicheria', '240 gr.'),
(140, 'Alette di Pollo', '3.90', 'Stuzzicheria', '6 pezzi'),
(141, 'Jalapenos', '3.90', 'Stuzzicheria', '4 pezzi'),
(142, 'Nagghy', '3.90', 'Stuzzicheria', '6 pezzi'),
(143, 'Patatine Max.', '3.90', 'Stuzzicheria', '350 gr.'),
(144, 'Golosa', '7.50', 'Stuzzicheria', 'insalata mista, pomodoro, tonno, mais, mozzarella di bufala, uovo sodo'),
(145, 'Greca', '7.50', 'Stuzzicheria', 'insalata mista, pomodoro, olive, peperoni, cipolla, formaggio feta'),
(146, 'Kaori', '8.50', 'Stuzzicheria', 'insalata mista, pomodoro, olive, philadelphia, crudo di parma'),
(147, 'Longobarda', '8.50', 'Stuzzicheria', 'insalata mista, pomodoro, rucola, grana a scaglie, bresaola'),
(148, 'Superba', '8.50', 'Stuzzicheria', 'insalata mista, petto di pollo alla piastra, bacon croccante, grana a scaglie'),
(149, 'Acqua 50 cl.', '1.00', 'Bibite', 'naturale o frizzante'),
(150, 'Bibita in Lattina 33 cl.', '1.90', 'Bibite', 'coco cola, fanta, sprite, coco cola zero, chinotto'),
(151, 'Bibita in Bottiglia 50 cl.', '2.20', 'Bibite', 'coco cola, fanta, sprite, coco cola zero, chinotto'),
(152, 'Birra in Bottiglia 33 cl.', '2.90', 'Bibite', 'beck''s, forst, menabrea, warsteiner, heinekein'),
(153, 'Bibita in Bottiglia 1.5 l.', '3.50', 'Bibite', 'coco cola, fanta, sprite, coco cola zero, chinotto'),
(154, 'Birra in Bottiglia 66 cl.', '3.70', 'Bibite', 'beck''s, forst, menabrea, warsteiner, heinekein');

-- --------------------------------------------------------

--
-- Struttura della tabella `magazzino`
--

CREATE TABLE `magazzino` (
  `id` int(6) NOT NULL,
  `prodotto` varchar(128) NOT NULL,
  `quantita` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini`
--

CREATE TABLE `ordini` (
  `id` int(6) NOT NULL,
  `id_cliente` int(6) NOT NULL,
  `asporto` tinyint(1) NOT NULL,
  `costo_tot` decimal(65,0) NOT NULL,
  `data` date NOT NULL,
  `ora_prenotazione` time NOT NULL,
  `ora_consegna` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `approvvigionamenti`
--
ALTER TABLE `approvvigionamenti`
  ADD PRIMARY KEY (`data`,`id_fornitore`);

--
-- Indici per le tabelle `clienti`
--
ALTER TABLE `clienti`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `fornitori`
--
ALTER TABLE `fornitori`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `listino`
--
ALTER TABLE `listino`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `magazzino`
--
ALTER TABLE `magazzino`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordini`
--
ALTER TABLE `ordini`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `clienti`
--
ALTER TABLE `clienti`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `fornitori`
--
ALTER TABLE `fornitori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `listino`
--
ALTER TABLE `listino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;
--
-- AUTO_INCREMENT per la tabella `magazzino`
--
ALTER TABLE `magazzino`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `ordini`
--
ALTER TABLE `ordini`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
