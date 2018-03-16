CREATE TABLE `approvvigionamenti` (
  `data` int(11) NOT NULL,
  `id_fornitore` int(11) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  `quantita` int(11) NOT NULL,
  `costo_tot` decimal(10,0) NOT NULL,
  FOREIGN KEY (id_fornitore) REFERENCES fornitori(id),
  FOREIGN KEY (id_prodotto) REFERENCES magazzino(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `clienti` (
  `nome` varchar(128) NOT NULL,
  `cognome` varchar(128) NOT NULL,
  `indirizzo` varchar(128) NOT NULL,
  `telefono` varchar(128) NOT NULL,
  `id` int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `componenti` (
  `id_ordine` int(6) NOT NULL AUTO_INCREMENT,
  `prodotto` varchar(128) NOT NULL,
  `quantita` int(6) NOT NULL,
  `costo` decimal(65,0) NOT NULL,
  FOREIGN KEY (id_ordine) REFERENCES ordini(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `fornitori` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(128) NOT NULL,
  `telefono` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `sede` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `magazzino` (
  `id` int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `prodotto` varchar(128) NOT NULL,
  `categoria` varchar(128) NOT NULL,
  `descrizione` varchar(128) NOT NULL,
  `costo` decimal(65,0) NOT NULL,
  `quantita` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `ordini` (
  `id` int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_cliente` int(6) NOT NULL,
  `asporto` tinyint(1) NOT NULL,
  `costo_tot` decimal(65,0) NOT NULL,
  `data` date NOT NULL,
  `ora_prenotazione` time NOT NULL,
  `ora_consegna` time NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clienti(id),
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `approvvigionamenti`
  ADD PRIMARY KEY (`data`,`id_fornitore`);
  

