DROP TABLE IF EXISTS financeiroGrupo;

CREATE TABLE financeiroGrupo (
	id INT NOT NULL UNIQUE,
  	CodProdt VARCHAR(10),
  	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS financeiroDetalhes;

CREATE TABLE financeiroDetalhes (
  identdLinhaBilat VARCHAR NOT NULL PRIMARY KEY,
  tpDeb_Cred VARCHAR(100),
  ISPBIFCredtd INT,
  ISPBIFDebtd INT,
  vlrLanc FLOAT,
  CNPJNLiqdantDebtd INT,
  nomCliDebtd VARCHAR(100),
  CNPJNLiqdantCredtd INT,
  nomCliCredtd VARCHAR(100),
  tpTranscSLC VARCHAR(100),
  FOREIGN KEY (identdLinhaBilat) REFERENCES financeiroGrupo(id)
);

