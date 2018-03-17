CREATE TABLE 'Medico' (
	'IdMedico' int(4) NOT NULL PRIMARY KEY,
    'Nome' varchar(20) NOT NULL,
    'Cognome' varchar(20) NOT NULL,
    'Specializzazione' varchar(30) NOT NULL,
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE 'Visita' (
    'IdPaziente' int(11) NOT NULL,
    'IdMedico' int(4) NOT NULL,
	'IdAmbulatorio' int(11) NOT NULL,
    'IdVisita' int(30) NOT NULL PRIMARY KEY,
	'GiornoVisita' date NOT NULL,
	FOREIGN KEY (IdPaziente) REFERENCES Paziente(IdPaziente)
	FOREIGN KEY (IdMedico) REFERENCES Medico(IdMedico)
	FOREIGN KEY (IdAmbulatorio) REFERENCES Ambulatorio(IdAmbulatorio)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE 'Paziente' (
    'IdPaziente' int(11) NOT NULL,
	'IdVisita' int(11) NOT NULL,
    'Nome' int(4) NOT NULL,
    'Cognome' int(30) NOT NULL PRIMARY KEY,
	'GiornoVisita' date NOT NULL,
	FOREIGN KEY (IdVisita) REFERENCES Visita(IdVisita)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE 'Ambulatorio' (
    'IdAmbulatorio' int(11) NOT NULL,
	'NomeAmbulatorio' int(11) NOT NULL,
	FOREIGN KEY (IdVisita) REFERENCES Visita(IdVisita)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;