CREATE TABLE IF NOT EXISTS treningsøkt (
	treningsøkt_id INT NOT NULL AUTO_INCREMENT,
	dato DATE NOT NULL,
	tidspunkt TIMESTAMP NOT NULL,
	varighet INT NOT NULL,
	form INT,
    prestasjon INT,
	PRIMARY KEY (treningsøkt_id)
);

CREATE TABLE IF NOT EXISTS notat (
	notat_id INT NOT NULL AUTO_INCREMENT,
	treningsøkt_id INT NOT NULL,
    tekst VARCHAR(1000) NOT NULL,
	PRIMARY KEY (notat_id),
    CONSTRAINT
		FOREIGN KEY (treningsøkt_id)
        REFERENCES treningsøkt (treningsøkt_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS øvelsesgruppe (
	øvelsesgruppe_id INT NOT NULL AUTO_INCREMENT,
    beskrivelse VARCHAR(500) NOT NULL,
	PRIMARY KEY (øvelsesgruppe_id)	
);

CREATE TABLE IF NOT EXISTS apparat (
	apparat_id int NOT NULL,
    navn VARCHAR(100) NOT NULL,
    beskrivelse VARCHAR(200) NOT NULL,
	PRIMARY KEY (apparat_id)
);

CREATE TABLE IF NOT EXISTS øvelse_med_apparat (
	navn VARCHAR(100) NOT NULL,
    apparat_id INT NOT NULL,
    øvelsesgruppe_id INT,
	PRIMARY KEY (navn),
    CONSTRAINT øvelse_fk1
		FOREIGN KEY (apparat_id)
		REFERENCES apparat (apparat_id)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
    CONSTRAINT øvelse_fk2
		FOREIGN KEY (øvelsesgruppe_id)
		REFERENCES øvelsesgruppe (øvelsesgruppe_id)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS øvelse_uten_apparat (
	navn VARCHAR(100) NOT NULL,
    beskrivelse VARCHAR(200) NOT NULL,
    øvelsesgruppe_id INT,
	PRIMARY KEY (navn),
    CONSTRAINT øvelse_u_fk1
		FOREIGN KEY (øvelsesgruppe_id)
		REFERENCES øvelsesgruppe (øvelsesgruppe_id)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS øvelse_med_apparat_i_økt (
	øvelse_navn VARCHAR(100) NOT NULL,
    treningsøkt_id INT NOT NULL,
    antall_kg INT NOT NULL,
    antall_set INT NOT NULL,
    PRIMARY KEY (øvelse_navn, treningsøkt_id),
    CONSTRAINT øvelse_apparat_fk1
		FOREIGN KEY (øvelse_navn)
        REFERENCES øvelse_med_apparat (navn)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT øvelse_apparat_fk2
		FOREIGN KEY (treningsøkt_id)
        REFERENCES treningsøkt (treningsøkt_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS øvelse_uten_apparat_i_økt (
	øvelse_navn VARCHAR(100) NOT NULL,
    treningsøkt_id INT NOT NULL,
    resultat VARCHAR(500),
    PRIMARY KEY (øvelse_navn, treningsøkt_id),
    CONSTRAINT øvelse_økt2_fk1
		FOREIGN KEY (øvelse_navn)
        REFERENCES øvelse_uten_apparat (navn)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT øvelse_økt2_fk2
		FOREIGN KEY (treningsøkt_id)
        REFERENCES treningsøkt (treningsøkt_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


