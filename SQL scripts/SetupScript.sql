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

CREATE TABLE IF NOT EXISTS øvelse(
	øvelse_id INT NOT NULL,
	navn VARCHAR(100) NOT NULL,
    apparat_id INT NOT NULL,
    beskrivelse VARCHAR(500),
	PRIMARY KEY (øvelse_id),
    CONSTRAINT øvelse_fk1
		FOREIGN KEY (apparat_id)
		REFERENCES apparat (apparat_id)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS øvelse_i_økt (
	øvelse_id INT NOT NULL,
    treningsøkt_id INT NOT NULL,
    antall_kg INT NOT NULL,
    antall_set INT NOT NULL,
    PRIMARY KEY (øvelse_id, treningsøkt_id),
    CONSTRAINT øvelse_økt_fk1
		FOREIGN KEY (øvelse_id)
        REFERENCES øvelse (øvelse_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT øvelse_økt_fk2
		FOREIGN KEY (treningsøkt_id)
        REFERENCES treningsøkt (treningsøkt_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS øvelse_i_øvelsegruppe (
	øvelse_id INT NOT NULL,
    øvelsesgruppe_id INT NOT NULL,
    resultat VARCHAR(500),
    PRIMARY KEY (øvelse_id, øvelsesgruppe_id),
    CONSTRAINT øvelse_gruppe_fk1
		FOREIGN KEY (øvelse_id)
        REFERENCES øvelse (øvelse_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT øvelse_gruppe_fk2
		FOREIGN KEY (øvelsesgruppe_id)
        REFERENCES øvelsesgruppe (øvelsesgruppe_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);



