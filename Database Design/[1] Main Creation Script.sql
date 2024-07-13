-- -----------------------------------------------------
-- Schema hoa_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS hoa_db;
CREATE SCHEMA IF NOT EXISTS hoa_db;
USE hoa_db;

-- -----------------------------------------------------
-- Table regions
-- -----------------------------------------------------
DROP TABLE IF EXISTS regions;
CREATE TABLE IF NOT EXISTS regions (
  region		VARCHAR(45) NOT NULL,
  PRIMARY KEY	(`region`)
);

-- -----------------------------------------------------
-- Table provinces
-- -----------------------------------------------------
DROP TABLE IF EXISTS provinces;
CREATE TABLE IF NOT EXISTS provinces (
  province_name VARCHAR(45) NOT NULL,
  region 		VARCHAR(45) NOT NULL,
  PRIMARY KEY 	(province_name),
  INDEX 		(region ASC),
  FOREIGN KEY	(region)
    REFERENCES	regions(region)
);

-- -----------------------------------------------------
-- Table cities
-- -----------------------------------------------------
DROP TABLE IF EXISTS cities;
CREATE TABLE IF NOT EXISTS cities (
  city			VARCHAR(45) NOT NULL,
  province		VARCHAR(45) NOT NULL,
  PRIMARY KEY	(city),
  INDEX			(province ASC),
  FOREIGN KEY	(province)
    REFERENCES	provinces(province_name)
);

-- -----------------------------------------------------
-- Table zipcodes
-- -----------------------------------------------------
DROP TABLE IF EXISTS zipcodes;
CREATE TABLE IF NOT EXISTS zipcodes (
  zipcode		INT NOT NULL,
  brgy			VARCHAR(45) NOT NULL,
  city			VARCHAR(45) NOT NULL,
  province		VARCHAR(45) NOT NULL,
  PRIMARY KEY	(zipcode),
  INDEX			(city ASC),
  INDEX			(province ASC),
  FOREIGN KEY	(city)
    REFERENCES	cities(city),
  FOREIGN KEY	(province)
    REFERENCES	provinces(province_name)
);

-- -----------------------------------------------------
-- Table address
-- -----------------------------------------------------
DROP TABLE IF EXISTS address;
CREATE TABLE IF NOT EXISTS address (
  address_id	INT NOT NULL,
  stno			VARCHAR(45) NOT NULL,
  stname		VARCHAR(45) NOT NULL,
  brgy			VARCHAR(45) NOT NULL,
  city			VARCHAR(45) NOT NULL,
  province		VARCHAR(45) NOT NULL,
  zipcode		INT NOT NULL,
  x_coord		FLOAT NOT NULL,
  y_coord		FLOAT NOT NULL,
  PRIMARY KEY	(address_id),
  INDEX			(city ASC),
  INDEX			(province ASC),
  INDEX			(zipcode ASC),
  FOREIGN KEY	(city)
    REFERENCES	cities(city),
  FOREIGN KEY	(province)
    REFERENCES	provinces(province_name),
  FOREIGN KEY	(zipcode)
    REFERENCES	zipcodes(zipcode)
);

-- -----------------------------------------------------
-- Table hoa
-- -----------------------------------------------------
DROP TABLE IF EXISTS hoa;
CREATE TABLE IF NOT EXISTS hoa (
  hoa_name			VARCHAR(45) NOT NULL,
  office_add		INT NOT NULL,
  year_est			INT(4) NOT NULL,
  website			VARCHAR(45) NULL,
  subd_name			VARCHAR(45) NOT NULL,
  dues_collection	VARCHAR(45) NOT NULL,
  PRIMARY KEY		(hoa_name),
  UNIQUE INDEX		(subd_name ASC),
  INDEX				(office_add ASC),
  FOREIGN KEY		(office_add)
    REFERENCES		address(address_id)
);

-- -----------------------------------------------------
-- Table individual
-- -----------------------------------------------------
DROP TABLE IF EXISTS individual;
CREATE TABLE IF NOT EXISTS individual (
  individual_id		INT NOT NULL,
  indiv_lastname	VARCHAR(45) NOT NULL,
  indiv_firstname	VARCHAR(45) NOT NULL,
  indiv_mi			VARCHAR(45) NOT NULL,
  email				VARCHAR(45) NOT NULL,
  birthday			DATE NOT NULL,
  gender			ENUM('M', 'F') NOT NULL,
  fb_url			VARCHAR(45) NULL,
  picture			BLOB NOT NULL,
  indiv_type		ENUM('R', 'H', 'HR') NOT NULL,
  PRIMARY KEY		(individual_id),
  UNIQUE INDEX		(email ASC),
  UNIQUE INDEX		(fb_url ASC)
);

-- -----------------------------------------------------
-- Table homeowner
-- -----------------------------------------------------
DROP TABLE IF EXISTS homeowner;
CREATE TABLE IF NOT EXISTS homeowner (
  homeowner_id	INT(5) NOT NULL,
  years_ho		INT(2) NOT NULL,
  undertaking	TINYINT(1) NOT NULL,
  membership	TINYINT(1) NOT NULL,
  is_resident	TINYINT(1) NOT NULL,
  current_add	INT NOT NULL,
  other_add		INT NULL,
  other_email	VARCHAR(45) NULL,
  hoa_name		VARCHAR(45) NOT NULL,
  individual_id	INT NOT NULL,
  PRIMARY KEY	(homeowner_id),
  INDEX			(hoa_name ASC),
  INDEX			(current_add ASC),
  INDEX			(other_add ASC),
  INDEX			(individual_id ASC),
  FOREIGN KEY	(hoa_name)
    REFERENCES	hoa(hoa_name),
  FOREIGN KEY	(current_add)
    REFERENCES	address(address_id),
  FOREIGN KEY	(other_add)
    REFERENCES	address(address_id),
  FOREIGN KEY	(individual_id)
    REFERENCES	individual(individual_id)
);

-- -----------------------------------------------------
-- Table officer_positions
-- -----------------------------------------------------
DROP TABLE IF EXISTS officer_positions;
CREATE TABLE IF NOT EXISTS officer_positions (
  position_name	VARCHAR(25) NOT NULL,
  PRIMARY KEY	(position_name)
);

-- -----------------------------------------------------
-- Table elections
-- -----------------------------------------------------
DROP TABLE IF EXISTS elections;
CREATE TABLE IF NOT EXISTS elections (
  elec_date			DATE NOT NULL,
  venue				VARCHAR(45) NOT NULL,
  quorum			TINYINT(1) NOT NULL,
  witness_lastname	VARCHAR(45) NOT NULL,
  witness_firstname	VARCHAR(45) NOT NULL,
  witness_mi		VARCHAR(45) NOT NULL,
  witness_mobile	BIGINT(10) NOT NULL,
  hoa_name			VARCHAR(45) NOT NULL,
  PRIMARY KEY		(elec_date),
  FOREIGN KEY		(hoa_name)
    REFERENCES		hoa(hoa_name)
);

-- -----------------------------------------------------
-- Table hoa_officer
-- -----------------------------------------------------
DROP TABLE IF EXISTS hoa_officer;
CREATE TABLE IF NOT EXISTS hoa_officer (
  officer_id	INT(5) NOT NULL,
  homeowner_id	INT(5) NOT NULL,
  position_name	VARCHAR(25) NOT NULL,
  office_start	DATE NOT NULL,
  office_end	DATE NOT NULL,
  elec_date		DATE NOT NULL,
  PRIMARY KEY	(officer_id),
  INDEX			(homeowner_id ASC),
  INDEX			(position_name ASC),
  INDEX			(elec_date ASC),
  FOREIGN KEY	(homeowner_id)
    REFERENCES	homeowner(homeowner_id),
  FOREIGN KEY	(position_name)
    REFERENCES	officer_positions(position_name),
  FOREIGN KEY	(elec_date)
    REFERENCES	elections(elec_date)
);

-- -----------------------------------------------------
-- Table hoa_files
-- -----------------------------------------------------
DROP TABLE IF EXISTS hoa_files;
CREATE TABLE IF NOT EXISTS hoa_files (
  file_id			INT NOT NULL,
  file_name			VARCHAR(45) NOT NULL,
  description		VARCHAR(45) NOT NULL,
  location			VARCHAR(45) NOT NULL,
  file_type			ENUM('document', 'spreadsheet', 'pdf', 'image', 'others') NOT NULL,
  date_submitted	DATETIME NOT NULL,
  file_owner		VARCHAR(45) NOT NULL,
  file_uploader		INT(5) NOT NULL,
  hoa_name			VARCHAR(45) NOT NULL,
  PRIMARY KEY		(file_id),
  INDEX				(hoa_name ASC),
  INDEX				(file_uploader ASC),
  FOREIGN KEY		(hoa_name)
    REFERENCES		hoa(hoa_name),
  FOREIGN KEY		(file_uploader)
    REFERENCES		hoa_officer(officer_id)
);

-- -----------------------------------------------------
-- Table property
-- -----------------------------------------------------
DROP TABLE IF EXISTS property;
CREATE TABLE IF NOT EXISTS property (
  property_code		VARCHAR(6) NOT NULL,
  size				DECIMAL NOT NULL,
  turnover			DATE NOT NULL,
  property_type		ENUM('R', 'C') NOT NULL,
  homeowner_id		INT(5) NOT NULL,
  PRIMARY KEY		(property_code),
  INDEX				(homeowner_id ASC),
  FOREIGN KEY		(homeowner_id)
    REFERENCES		homeowner(homeowner_id)
);


-- -----------------------------------------------------
-- Table household
-- -----------------------------------------------------
DROP TABLE IF EXISTS household;
CREATE TABLE IF NOT EXISTS household (
  household_id		INT(5) NOT NULL,
  PRIMARY KEY		(household_id)
);

-- -----------------------------------------------------
-- Table resident
-- -----------------------------------------------------
DROP TABLE IF EXISTS resident;
CREATE TABLE IF NOT EXISTS resident (
  resident_id			INT(5) NOT NULL,
  is_renter				TINYINT(1) NOT NULL,
  relation_ho			VARCHAR(45) NOT NULL,
  undertaking			TINYINT(1) NOT NULL,
  household_id			INT(5) NOT NULL,
  authorized_resident	TINYINT(1) NOT NULL,
  individual_id			INT NOT NULL,
  PRIMARY KEY			(resident_id),
  INDEX					(household_id ASC),
  INDEX					(individual_id ASC),
  FOREIGN KEY			(household_id)
    REFERENCES			household(household_id),
  FOREIGN KEY			(individual_id)
    REFERENCES			individual(individual_id)
);

-- -----------------------------------------------------
-- Table receipt
-- -----------------------------------------------------
DROP TABLE IF EXISTS receipt;
CREATE TABLE IF NOT EXISTS receipt (
  or_no			INT NOT NULL,
  transact_date DATETIME NOT NULL,
  total_amount	FLOAT NOT NULL,
  PRIMARY KEY	(or_no)
);

-- -----------------------------------------------------
-- Table resident_idcard
-- -----------------------------------------------------
DROP TABLE IF EXISTS resident_idcard;
CREATE TABLE IF NOT EXISTS resident_idcard (
  resident_idcardno		VARCHAR(10) NOT NULL,
  date_requested		DATETIME NOT NULL,
  request_reason		VARCHAR(45) NOT NULL,
  date_issued			DATETIME NOT NULL,
  authorizing_officer	VARCHAR(45) NOT NULL,
  or_no					INT NULL,
  amount_paid			FLOAT NOT NULL,
  id_status				ENUM('Active', 'Inactive', 'Lost') NOT NULL,
  resident_id			INT(5) NOT NULL,
  PRIMARY KEY			(resident_idcardno),
  INDEX					(resident_id ASC),
  INDEX					(or_no ASC),
  FOREIGN KEY			(resident_id)
    REFERENCES			resident(resident_id),
  FOREIGN KEY			(or_no)
    REFERENCES			receipt (or_no)
);

-- -----------------------------------------------------
-- Table mobile
-- -----------------------------------------------------
DROP TABLE IF EXISTS mobile;
CREATE TABLE IF NOT EXISTS mobile (
  mobile_no		BIGINT(10) NOT NULL,
  individual_id INT NOT NULL,
  PRIMARY KEY	(mobile_no),
  INDEX			(individual_id ASC),
  FOREIGN KEY	(individual_id)
    REFERENCES	individual(individual_id)
);

-- -----------------------------------------------------
-- Table vehicle
-- -----------------------------------------------------
DROP TABLE IF EXISTS vehicle;
CREATE TABLE IF NOT EXISTS vehicle (
  plate_no			VARCHAR(7) NOT NULL,
  owner_lastname	VARCHAR(45) NOT NULL,
  owner_firstname	VARCHAR(45) NOT NULL,
  owner_mi			VARCHAR(45) NOT NULL,
  resident_id		INT(5) NULL,
  vehicle_class		ENUM('P', 'C') NOT NULL,
  vehicle_type		ENUM('sedan', 'SUV', 'MPV/AUV', 'van', 'truck', 'motorcycle/scooter', 'others') NOT NULL,
  date_registered	DATETIME NOT NULL,
  reg_fee			DECIMAL NOT NULL,
  or_no				INT NOT NULL,
  PRIMARY KEY		(plate_no),
  INDEX				(resident_id ASC),
  INDEX				(or_no ASC),
  FOREIGN KEY		(resident_id)
    REFERENCES		resident(resident_id),
  FOREIGN KEY		(or_no)
    REFERENCES		receipt(or_no)
);

-- -----------------------------------------------------
-- Table orcr
-- -----------------------------------------------------
DROP TABLE IF EXISTS orcr;
CREATE TABLE IF NOT EXISTS orcr (
  orcr			VARCHAR(45) NOT NULL,
  plate_no		VARCHAR(7) NOT NULL,
  years_valid	VARCHAR(45) NOT NULL,
  orcr_file		INT NOT NULL,
  PRIMARY KEY	(orcr),
  INDEX			(plate_no ASC),
  INDEX			(orcr_file ASC),
  FOREIGN KEY	(plate_no)
    REFERENCES	vehicle(plate_no),
  FOREIGN KEY	(orcr_file)
    REFERENCES	hoa_files(file_id)
);

-- -----------------------------------------------------
-- Table sticker
-- -----------------------------------------------------
DROP TABLE IF EXISTS sticker;
CREATE TABLE IF NOT EXISTS sticker (
  sticker_id			INT NOT NULL,
  year_valid			INT(4) NOT NULL,
  plate_no				VARCHAR(7) NOT NULL,
  owner_type			ENUM('R', 'NR') NOT NULL,
  authorizing_officer	INT(5) NOT NULL,
  date_acquired			DATETIME NOT NULL,
  amount_paid			DECIMAL NOT NULL,
  or_no					INT NULL,
  PRIMARY KEY			(sticker_id),
  INDEX					(plate_no ASC),
  INDEX					(authorizing_officer ASC),
  INDEX					(or_no ASC),
  FOREIGN KEY			(plate_no)
    REFERENCES			vehicle(plate_no),
  FOREIGN KEY			(authorizing_officer)
    REFERENCES			hoa_officer(officer_id),
  FOREIGN KEY			(or_no)
    REFERENCES			receipt(or_no)
);

-- -----------------------------------------------------
-- Table hoaofficer_sched
-- -----------------------------------------------------
DROP TABLE IF EXISTS hoaofficer_sched;
CREATE TABLE IF NOT EXISTS hoaofficer_sched (
  officer_id	INT(5) NOT NULL,
  sched_time	ENUM('AM', 'PM') NOT NULL,
  avail_Mon		TINYINT(1) NULL,
  avail_Tue		TINYINT(1) NULL,
  avail_Wed		TINYINT(1) NULL,
  avail_Thu		TINYINT(1) NULL,
  avail_Fri		TINYINT(1) NULL,
  avail_Sat		TINYINT(1) NULL,
  avail_Sun		TINYINT(1) NULL,
  PRIMARY KEY	(officer_id, sched_time),
  INDEX			(officer_id ASC),
  FOREIGN KEY	(officer_id)
    REFERENCES	hoa_officer(officer_id)
);

-- -----------------------------------------------------
-- Table asset
-- -----------------------------------------------------
DROP TABLE IF EXISTS asset;
CREATE TABLE IF NOT EXISTS asset (
  asset_id			VARCHAR(10) NOT NULL,
  asset_name		VARCHAR(45) NOT NULL,
  description		VARCHAR(45) NOT NULL,
  date_acquired		DATE NOT NULL,
  for_rent			TINYINT(1) NOT NULL,
  asset_value		FLOAT NOT NULL,
  asset_type		ENUM('P', 'E', 'F', 'O') NOT NULL,
  asset_status		ENUM('W', 'DE', 'FR', 'FD', 'DI') NOT NULL,
  location			VARCHAR(45) NOT NULL,
  location_x		FLOAT NOT NULL,
  location_y		FLOAT NOT NULL,
  hoa_name			VARCHAR(45) NOT NULL,
  asset_container	VARCHAR(10) NULL,
  PRIMARY KEY		(asset_id),
  INDEX				(hoa_name ASC),
  INDEX				(asset_container ASC),
  FOREIGN KEY		(hoa_name)
    REFERENCES		hoa(hoa_name),
  FOREIGN KEY		(asset_container)
    REFERENCES		asset(asset_id)
);

-- -----------------------------------------------------
-- Table commercial_prop
-- -----------------------------------------------------
DROP TABLE IF EXISTS commercial_prop;
CREATE TABLE IF NOT EXISTS commercial_prop (
  property_code			VARCHAR(6) NOT NULL,
  commercial_type		ENUM('O', 'L', 'R', 'M') NOT NULL,
  commercial_maxten		INT NOT NULL,
  INDEX					(property_code ASC),
  PRIMARY KEY			(property_code),
  FOREIGN KEY			(property_code)
    REFERENCES			property(property_code)
);

-- -----------------------------------------------------
-- Table residential_prop
-- -----------------------------------------------------
DROP TABLE IF EXISTS residential_prop;
CREATE TABLE IF NOT EXISTS residential_prop (
  property_code VARCHAR(6) NOT NULL,
  household_id	INT(5) NOT NULL,
  INDEX			(property_code ASC),
  PRIMARY KEY	(property_code),
  INDEX			(household_id ASC),
  FOREIGN KEY	(property_code)
    REFERENCES	property(property_code),
  FOREIGN KEY	(household_id)
    REFERENCES	household(household_id)
);


-- -----------------------------------------------------
-- Add records to regions
-- -----------------------------------------------------
INSERT INTO	regions
	VALUES	('Region I'),
			('Region II'),
			('Region III'),
			('Region IV-A'),
            ('Region IV-B'),
            ('Region V'),
            ('Region VI'),
            ('Region VII'),
            ('Region VIII'),
            ('Region IX'),
            ('Region X'),
            ('Region XI'),
            ('Region XII'),
            ('Region XIII'),
            ('NCR'),
            ('CAR'),
            ('BARMM');

-- -----------------------------------------------------
-- Add records to provinces
-- -----------------------------------------------------
INSERT INTO	provinces
	VALUES	('Metro Manila','NCR'),
			('Bataan','Region III'),
			('Batangas','Region IV-A'),
			('Cavite','Region IV-A'),
            ('Laguna','Region IV-A');

-- -----------------------------------------------------
-- Add records to cities
-- -----------------------------------------------------
INSERT INTO	cities
	VALUES	('Manila','Metro Manila'),
			('Pasay','Metro Manila'),
			('Pasig','Metro Manila'),
			('Dasmarinas','Cavite'),
            ('Santa Rosa','Laguna');
            
-- -----------------------------------------------------
-- Add records to zipcodes
-- -----------------------------------------------------
INSERT INTO	zipcodes
	VALUES	('1001','680','Manila','Metro Manila'),
			('1002','780','Manila','Metro Manila'),
			('1003','880','Manila','Metro Manila');

-- -----------------------------------------------------
-- Add records to address
-- -----------------------------------------------------
INSERT INTO	address
	VALUES	(10000020, '24', 'De La Salle St.', '680', 'Manila', 'Metro Manila', 1001, 123.4567, 234.5678),
			(10000021, '45', 'De La Salle St.', '680', 'Manila', 'Metro Manila', 1001, 345.6789, 456.7890),
			(10000022, '77', 'Benilde St.', '680', 'Manila', 'Metro Manila', 1001, 567.8901, 678.9101),
            (10000023, '13', 'Mutien-Marie St.', '680', 'Manila', 'Metro Manila', 1001, 789.1011, 891.0111),
            (10000024, '50', 'Green Archer St.', '780', 'Manila', 'Metro Manila', 1002, 910.1112, 101.1121),
            (10000025, '11', 'Reims St.', '780', 'Manila', 'Metro Manila', 1002, 131.4151, 617.1819);

-- -----------------------------------------------------
-- Add records to hoa
-- -----------------------------------------------------
INSERT INTO	hoa
	VALUES	('Animo HOA', 10000020, 1911, 'www.animohoa.ph', 'Animo Green Homes', '15'),
			('Archer’s HOA', 10000024, 1999, 'www.archershoa.ph', 'Archer’s Residences', '10'),
			('Berde 1 HOA', 10000025, 2005, 'www.berdehoa.ph', 'Berde Subdivision 1', '20');

-- -----------------------------------------------------
-- Add records to individual
-- -----------------------------------------------------
INSERT INTO	individual
	VALUES	(2023202410, 'Dela Cruz', 'Juan', 'R', 'juandelacruz@gmail.com', '2000-01-05', 'M', 'jdlcruz', 'pic1.jpg', 'R'),
			(2023202411, 'Dela Cruz', 'Juanita', 'G', 'juanitadelacruz@gmail.com', '2002-10-10', 'F', 'juanitadlc', 'pic2.jpg', 'HR'),
			(2023202412, 'Rizal', 'Jose', 'P', 'joserizal@gmail.com', '1961-06-19', 'M', 'jprizal', 'pic3.jpg', 'HR'),
			(2023202413, 'Bonifacio', 'Andres', 'A', 'andresbonifacio@gmail.com', '1983-11-30', 'M', NULL, 'pic4.jpg', 'R'),
			(2023202414, 'Silang', 'Gabriela', 'R', 'gabrielasilang@gmail.com', '1991-03-19', 'F', 'grsilang', 'pic5.jpg', 'HR'),
			(2023202415, 'Luna', 'Juan', 'M', 'juanluna@gmail.com', '1991-03-19', 'M', 'jluna', 'pic5.jpg', 'H');

-- -----------------------------------------------------
-- Add records to homeowner
-- -----------------------------------------------------
INSERT INTO	homeowner
	VALUES	(30011, 5, 1, 1, 1, 10000021, NULL, NULL, 'Animo HOA', 2023202411),
			(30012, 12, 1, 1, 1, 10000022, NULL, NULL, 'Animo HOA', 2023202412),
			(30013, 10, 1, 1, 1, 10000023, NULL, NULL, 'Animo HOA', 2023202414),
            (30014, 6, 1, 1, 1, 10000024, NULL, NULL, 'Animo HOA', 2023202415);

-- -----------------------------------------------------
-- Add records to officer_positions
-- -----------------------------------------------------
INSERT INTO	officer_positions
	VALUES	('President'),
			('Vice-President'),
			('Secretary'),
			('Treasurer'),
			('Auditor');

-- -----------------------------------------------------
-- Add records to elections
-- -----------------------------------------------------
INSERT INTO	elections
	VALUES	('2022-1-12', 'Animo Clubhouse', 0, 'Aquino', 'Melchora', 'B',9172001434, 'Animo HOA'),
			('2022-11-19', 'Animo Clubhouse', 0, 'Del Pilar', 'Gregorio', 'A',9224657809, 'Animo HOA'),
			('2022-11-26', 'Animo Clubhouse', 1, 'Balagtas', 'Francisco', 'K',9224657809, 'Animo HOA');

-- -----------------------------------------------------
-- Add records to hoa_officer
-- -----------------------------------------------------
INSERT INTO	hoa_officer
	VALUES	(99901, 30012, 'President', '2023-01-09','2024-01-07','2022-11-26'),
			(99902, 30013, 'Secretary', '2023-01-09','2024-01-07','2022-11-26');

-- -----------------------------------------------------
-- Add records to hoa_files
-- -----------------------------------------------------
INSERT INTO	hoa_files
	VALUES	(555556661,'bylaws.pdf', 'notarized by-laws','D:/Animo HOA Documents/', 'pdf', '2020-03-17', 'Jose Rizal', 99901, 'Animo HOA'),
			(555556662,'ABC1234-ORCR2022.pdf', 'ABC1234 ORCR 2022','D:/Animo HOA Documents/Vehicle Registration/', 'pdf', '2022-05-06', 'Juan Dela Cruz', 99902, 'Animo HOA'),
            (555556663,'DEF6789-ORCR2022.pdf', 'DEF6789 ORCR 2022','D:/Animo HOA Documents/Vehicle Registration/', 'pdf', '2022-05-10', 'Emilio Aguinaldo', 99902, 'Animo HOA');

-- -----------------------------------------------------
-- Add records to property
-- -----------------------------------------------------
INSERT INTO	property
	VALUES	('B35L02', 300.00, '2018-02-15', 'R', 30011),
			('B11L08', 180.00, '2011-03-16', 'R', 30012),
            ('B42L09', 225.00, '2013-04-17', 'R', 30013),
            ('B25L10', 250.00, '2017-05-18', 'R', 30014),
            ('B39L13', 180.00, '2020-06-19', 'C', 30014);

-- -----------------------------------------------------
-- Add records to household
-- -----------------------------------------------------
INSERT INTO	household
	VALUES	(42001),
			(42002),
			(42003),
            (42004);

-- -----------------------------------------------------
-- Add records to resident
-- -----------------------------------------------------
INSERT INTO	resident
	VALUES	(40011, 0, 'husband', 1, 42001, 1, 2023202410),
			(40012, 0, 'homeowner', 1, 42001, 1, 2023202411),
            (40013, 0, 'homeowner', 1, 42002, 1, 2023202412),
            (40014, 1, 'none', 1, 42003, 0, 2023202413),
            (40015, 0, 'homeowner', 1, 42004, 1, 2023202414);

-- -----------------------------------------------------
-- Add records to receipt
-- -----------------------------------------------------
INSERT INTO	receipt
	VALUES	(202379991,'2023-07-20',1500.00),
			(202379992,'2023-08-25',2250.00),
            (202379993,'2023-09-01',830.00);

-- -----------------------------------------------------
-- Add records to resident_idcard
-- -----------------------------------------------------
INSERT INTO	resident_idcard
	VALUES	('ANIMO22001', '2022-01-30', 'New ID', '2022-02-04', 99902, NULL, 0.00, 'Active', 40013),
			('ANIMO22002', '2022-02-20-', 'New ID', '2022-02-04-', 99902, NULL, 0.00, 'Active', 40011),
            ('ANIMO22003', '2022-02-20', 'New ID', '2022-02-04', 99902, NULL, 0.00, 'Active', 40012);

-- -----------------------------------------------------
-- Add records to mobile
-- -----------------------------------------------------
INSERT INTO	mobile
	VALUES	(9175459870, 2023202410),
			(9173110229, 2023202411),
            (9207639255, 2023202412),
            (9226974142, 2023202413),
            (9181008621, 2023202414),
            (9224489773, 2023202415);

-- -----------------------------------------------------
-- Add records to vehicle
-- -----------------------------------------------------
INSERT INTO	vehicle
	VALUES	('ABC1234', 'Dela Cruz', 'Juan', 'R', 40011, 'P', 'SUV', '2023-07-20', 150.00, 202379991),
			('DEF6789', 'Aguinaldo', 'Emilio', 'N', NULL, 'C', 'truck', '2023-09-01', 500.00, 202379992);

-- -----------------------------------------------------
-- Add records to orcr
-- -----------------------------------------------------
INSERT INTO	orcr
	VALUES	('ORCR-109634885P', 'ABC1234', '2023-02-20 to 2024-02-19', 555556662),
			('ORCR-217459009C', 'DEF6789', '2023-06-25 to 2024-06-24', 555556663);

-- -----------------------------------------------------
-- Add records to sticker
-- -----------------------------------------------------
INSERT INTO	sticker
	VALUES	(202300100, 2023, 'ABC1234', 'R', 99902, '2023-07-20', 0.00, NULL),
			(202300600, 2023, 'DEF6789', 'NR', 99902, '2023-09-01', 1500.00, 202379992);

-- -----------------------------------------------------
-- Add records to hoaofficer_sched
-- -----------------------------------------------------
INSERT INTO	hoaofficer_sched
	VALUES	(99901, 'AM', 1, 1, 1, 1, 1, 1, 1),
			(99902, 'PM', 1, 1, 1, 1, 1, 1, 1);

-- -----------------------------------------------------
-- Add records to asset
-- -----------------------------------------------------
INSERT INTO	asset
	VALUES	('P000000001', 'Animo HOA Clubhouse', 'clubhouse', '1995-10-06', 1, 18000000.00, 'P', 'W', '24 De La Salle St.', 123.4567, 234.5678, 'Animo HOA', NULL),
			('E000000001', 'LED projector', 'projector', '2021-12-01', 1, 75000.00, 'E', 'W', '24 De La Salle St.', 123.4567, 234.5678, 'Animo HOA', 'P000000001'),
            ('P000000002', 'Animo HOA Basketball Court', 'basketball court', '1996-04-01', 1, 9000000.00, 'P', 'W', '01 Benilde St.', 543.2100, 765.4321, 'Animo HOA', NULL);

-- -----------------------------------------------------
-- Add records to commercial_prop
-- -----------------------------------------------------
INSERT INTO	commercial_prop
	VALUES	('B39L13','M',10);

-- -----------------------------------------------------
-- Add records to residential_prop
-- -----------------------------------------------------
INSERT INTO	residential_prop
	VALUES	('B35L02', 42001),
			('B11L08', 42002),
            ('B42l09', 42003),
            ('B25L10', 42004);

-- GROUP 5


-- ------------------------
-- ADDITIONAL DATA
-- --------------------------
INSERT INTO provinces
	 VALUES	('La Union', 'Region I'),
			('Pangasinan', 'Region I'),
			('Batanes', 'Region II'),
			('Cagayan', 'Region II'),
			('Bulacan', 'Region III'),
			('Pampanga', 'Region III'),
			('Benguet', 'CAR'),
			('Ifugao', 'CAR');

INSERT INTO cities
	VALUES 	('San Fernando', 'La Union'),
			('Calasiao', 'Pangasinan'),
			('Basco', 'Batanes'),
			('Tuguegarao', 'Cagayan'),
			('Malolos', 'Bulacan'),
			('Lingayen', 'Pampanga'),
			('La Trinidad', 'Benguet'),
			('Lagawe', 'Ifugao'),
			('Quezon', 'Metro Manila');

INSERT INTO zipcodes
	VALUES 	('2500', 'Kagawad', 'San Fernando', 'La Union'),
			('2418', 'Ambonao', 'Calasiao', 'Pangasinan'),
			('3900', 'Chanarian', 'Basco', 'Batanes'),
			('3500', 'Buntun', 'Tuguegarao', 'Cagayan'),
			('3000', 'Anilao', 'Malolos', 'Bulacan'),
			('2401', 'Capandanan', 'Lingayen', 'Pampanga'),
			('2601', 'Poblacion', 'La Trinidad', 'Benguet'),
			('3600', 'Caba', 'Lagawe', 'Ifugao'),
			('1209', 'Bel-Air', 'Manila', 'Metro Manila'),
			('1126', 'Batasan Hills', 'Quezon', 'Metro Manila');

INSERT INTO address
	VALUES 	(10000026, '5', 'Samuel Street', 'Poblacion', 'La Trinidad', 'Benguet', 2601, 2719.90, 2091.80),
			(10000027, '7', 'Narra Street', 'Batasan Hills', 'Quezon', 'Ifugao', 1126, 2619.10, 2391.85), /*inconsistency: wala namang quezon city sa Ifugao*/
			(10000028, '8', 'Katipunan Street', 'Caba', 'Lagawe', 'Ifugao', 2601, 2115.70, 2193.50), /*inconsistency: mali yung zipcode*/
			(10000029, '3', 'Yakal Street', 'Bel-Air', 'Manila', 'Metro Manila', 1209, 2156.70, 2321.55),
			(10000030, '6', 'Maya Street', 'Buntun', 'Tuguegarao', 'Cagayan', 3500, 2136.76, 2393.50),
			(10000031, '7', 'Samuel Street', 'Poblacion', 'La Trinidad', 'Benguet', 2601, 2720.90, 2081.80), 
			(10000032, '8', 'Narra Street', 'Batasan Hills', 'Quezon', 'Metro Manila', 1126, 2629.10, 2390.85), 
			(10000033, '5', 'Katipunan Street', 'Caba', 'Lagawe', 'Ifugao', 3600, 2135.60, 2113.50),
			(10000034, '16', 'Yakal Street', 'Bel-Air', 'Manila', 'Metro Manila', 1209, 2145.70, 2319.55),
			(10000035, '9', 'Maya Street', 'Buntun', 'Tuguegarao', 'Cagayan', 3500, 21264.70, 2333.55); 

INSERT INTO hoa
	VALUES	('Green Meadows HOA', 10000026, 1998, 'www.greenmeadowshoa.org', 'Green Meadows','1000'),
			('Lakeside Estates HOA', 10000027, 2005, 'www.lakesideestateshoa.com', 'Lakeside Estates','2000'),
			('Narra Park HOA', 10000028, 1990, 'www.oakwoodparkhoa.org', 'Narra Park','1500'),
			('Willow Creek Heights HOA', 10000029, 2003, 'www.willowcreekestateshoa.com', 'Willow Creek Heighs','1700'),
			('Sunflower Hills HOA', 10000030, 2010, 'www.sunflowerhillshoa.com', 'Sunflower Hills','2000');

INSERT INTO individual
	VALUES 	(2023202416,'Smith','John','A','john8@gmail.com','1985-04-15','M','john.smith', 'pic7.jpg','R'),
			(2023202417,'Johnson','Sarah','M','sarah.j@gmail.com','1990-12-03','F','sarah.johnson', 'pic8.jpg','HR'),
			(2023202418,'Brown','Michael','J','mbrown@gmail.com','1978-08-21','M','michael.brown', 'pic9.jpg','R'),
			(2023202419,'Davis','Emily','R','emilyd@gmail.com','1995-05-10','F','emily.davis', 'pic10.jpg','R'),
			(2023202420,'Wilson','Robert','L','robert.wilson@gmail.com','1980-11-30','M','robert.wilson', 'pic11.jpg','HR');
            
INSERT INTO homeowner
	VALUES 	(30015, 5, 1, 0, 1, 10000034, NULL, 'sj58@hotmail.com', 'Animo HOA', 2023202417),
			(30016, 4, 1, 0, 0, 10000035, NULL, 'robertwil@hotmail.com', 'Animo HOA', 2023202420);
            
INSERT INTO officer_positions
	VALUES ('Board Member');

INSERT INTO	hoa_officer
	VALUES	(99903, 30011, 'Treasurer', '2023-01-09','2024-01-07', '2022-11-19'),
			(99904, 30014, 'Auditor', '2023-01-09','2024-01-07', '2022-11-19'),
			(99905, 30015, 'Board Member', '2023-01-09','2024-01-07', '2022-11-19'),
            (99906, 30016, 'Vice-President', '2023-01-09','2024-01-07', '2022-11-26');

INSERT INTO	property
	VALUES	('B40L01', 300.00, '2018-02-15', 'R', 30015),
			('B40L02', 180.00, '2011-03-16', 'R', 30015),
            ('B42L10', 225.00, '2013-04-17', 'R', 30015),
            ('B26L11', 250.00, '2017-05-18', 'R', 30016),
            ('B39L14', 180.00, '2020-06-19', 'C', 30016);

INSERT INTO	household
	VALUES	(42005),
			(42006),
			(42007);

INSERT INTO	resident
	VALUES	(40016, 1, 'parent', 1, 42005, 1, 2023202416),
			(40017, 1, 'homeowner', 1, 42005, 1, 2023202417),
			(40018, 1, 'none', 1, 42006, 0, 2023202418),
			(40019, 0, 'parent', 1, 42007, 1, 2023202419),
			(40020, 0, 'homeowner', 1, 42007, 1, 2023202420);


-- -----------------------------------------------------
--  2A: Table committees
-- -----------------------------------------------------
DROP TABLE IF EXISTS committee;
CREATE TABLE IF NOT EXISTS committee (
 	committee_id			INT(3)	NOT NULL,
    organizing_officer		INT(5)	NOT NULL,
	PRIMARY KEY (committee_id),
    FOREIGN KEY (organizing_officer)
		REFERENCES hoa_officer (officer_id)
);
-- -----------------------------------------------------
-- 2A: Table programs
-- -----------------------------------------------------
DROP TABLE IF EXISTS program;
CREATE TABLE IF NOT EXISTS program (
    program_id 				INT(6) 			NOT NULL,
    committee_id			INT(3)			NOT NULL,
    program_name			VARCHAR(45)		NOT NULL,
	program_desc			TEXT		 	NOT NULL,
    program_purpose 		TEXT		 	NOT NULL,
    intended_participants	VARCHAR(100)	NOT NULL,
	sponsoring_officer		INT(5)			NOT NULL,
    max_participants		INT(5)			NOT NULL,
    start_date				DATE			NOT NULL,
    end_date				DATE 			NOT NULL,
    reg_start_date			DATE			NOT NULL,
    program_status			ENUM('Open for Registration', 'Closed for Registration', 'Ongoing', 'Cancelled', 'Completed') NOT NULL,
    budget					DECIMAL(9, 2)	NOT NULL,

	PRIMARY KEY	(program_id),
	FOREIGN KEY	(committee_id)
		REFERENCES	committee(committee_id),
	FOREIGN KEY	(sponsoring_officer)
		REFERENCES	hoa_officer(officer_id)
        
);


-- -----------------------------------------------------
-- 2A: Table committee_membership
-- -----------------------------------------------------
DROP TABLE IF EXISTS committee_membership;
CREATE TABLE IF NOT EXISTS committee_membership (
 	membership_id	INT(5)		NOT NULL,
    committee_id	INT(3)		NOT NULL,
	resident_id		INT(5)	 	NOT NULL,
    start_date		DATE		NOT NULL,
    end_date		DATE,
    is_head			BOOLEAN		NOT NULL,
    
    PRIMARY KEY (membership_id),
    FOREIGN KEY (committee_id)
		REFERENCES committee (committee_id),
	FOREIGN KEY (resident_id)
		REFERENCES resident (resident_id)
);

    
-- -----------------------------------------------------
-- 2A: INITIAL DATA
-- -----------------------------------------------------
INSERT INTO committee
		VALUES 	(001, 99901), 
				(002, 99904), 
				(003, 99901), 
                (004, 99902); 
                
INSERT INTO program
		VALUES 	(202300, 1, 'Halloween 2023', 'A halloween program.',
					'To hold a trick-or-treat for residents.', 'Interested residents', 
                    99901, 10, '2023-10-31', '2023-11-01', '2023-10-24', 'Completed', 3000),
				(202301, 2, 'Christmas Lighting 2023', 'A christmas program.', 
					'To celebrate the Christmas',  'Every Christian resident', 
                    99901, 5, '2023-12-25', '2023-12-25', '2023-12-17', 'Open for Registration', 10000),
				(202400, 3, 'New Year 2024', 'A new year program', 
					'To welcome the new year ', 'Every resident', 
                    99902, 10, '2023-12-31', '2024-01-01', '2023-12-24', 'Closed for Registration', 15000),     
				(202401, 1, 'Homeowners Meeting 2024', 'The annual planning conference', 
					'To plan for the year', 'Every homeowner', 
                    99904, 5, '2024-02-01', '2024-02-01', '2024-01-25', 'Closed for Registration', 3000),
				(202402, 4, 'Cleanup Drive 2024', 'A cleaning program',
					'To clean the HOA',  'Young residents', 
                    99903, 5, '2024-03-15', '2024-03-22', '2024-03-08', 'Closed for Registration', 7500);
                    

INSERT INTO committee_membership
		VALUES 	(70001, 1, 40011, '2023-10-01', '2023-11-02', 1),	
				(70002, 1, 40012, '2023-10-02', '2024-02-02', 0),
				(70003, 1, 40013, '2023-10-02', NULL, 0),
				(70004, 1, 40014, '2023-10-04', NULL, 0),

				(70005, 2, 40012, '2023-11-20', NULL, 1),
				(70006, 2, 40011, '2023-11-20', NULL, 0),
				(70007, 2, 40013, '2023-11-21', NULL, 0),
				(70008, 2, 40014, '2023-11-22', NULL, 0),

				(70009, 3, 40015, '2024-12-01', NULL, 1),
				(70010, 3, 40016, '2024-12-10', NULL, 0),
				(70011, 3, 40017, '2024-12-15', NULL, 0),
				(70012, 3, 40018, '2024-12-01', NULL, 0),

				(70013, 4, 40017, '2024-03-01', NULL, 1),
				(70014, 4, 40020, '2023-03-04', NULL, 0),
				(70015, 4, 40019, '2023-03-01', NULL, 0),
				(70016, 4, 40014, '2023-03-04', NULL, 0),
                
                (70018, 1, 40020, '2023-11-03', NULL, 1),
                (70019, 1, 40015, '2024-02-03', NULL, 0);


--  2b ------------------------------------------------------------------------
DROP TABLE IF EXISTS expense;
CREATE TABLE IF NOT EXISTS expense (
    or_no           INT             NOT NULL,
    program_id      INT(4)          NOT NULL,
    payment_date    DATE            NOT NULL,
    `description`   VARCHAR(45)     NOT NULL,
    amount          DECIMAL(9,2)    NOT NULL,
    com_memb        INT(5)          NOT NULL,
	file_id         INT             NOT NULL,
    is_endorsed	    BOOLEAN			NOT NULL,

    PRIMARY KEY (or_no),
    FOREIGN KEY (program_id)
        REFERENCES program (program_id),
    FOREIGN KEY (com_memb)
        REFERENCES committee_membership (membership_id),
    FOREIGN KEY (or_no)
        REFERENCES receipt (or_no),
    FOREIGN KEY (file_id)
        REFERENCES hoa_files (file_id)
);

DROP TABLE IF EXISTS expense_type;
CREATE TABLE IF NOT EXISTS expense_type (
    expense_num		INT	         NOT NULL,
    `type`          ENUM('Manpower', 'Services', 'Materials', 'Others')    NOT NULL,

    PRIMARY KEY (expense_num, `type`),
    FOREIGN KEY (expense_num)
        REFERENCES expense (or_no)
);

DROP TABLE IF EXISTS request;
CREATE TABLE IF NOT EXISTS request (
    request_id      INT(6)      NOT NULL,
    program_id      INT(4)      NOT NULL,
    justification   TEXT		NOT NULL,
    date_requested  DATE        NOT NULL,
    is_endorsed     BOOLEAN     NOT NULL,
    `status`        ENUM('For Approval', 'Approved', 'Disapproved')     NOT NULL,

    PRIMARY KEY (request_id),	
    FOREIGN KEY (program_id)
        REFERENCES program (program_id)
);

DROP TABLE IF EXISTS rejected_request;
CREATE TABLE IF NOT EXISTS rejected_request(
	request_id			INT(6)			NOT NULL,
    rejection_reason	TEXT			NOT NULL,
    PRIMARY KEY (request_id),
    FOREIGN KEY (request_id)
		REFERENCES request (request_id)
);

DROP TABLE IF EXISTS evidence;
CREATE TABLE IF NOT EXISTS evidence (
    evidence_id     INT(6)      NOT NULL,
    `description`   VARCHAR(45) NOT NULL,
    file_id         INT         NOT NULL,
    resident_id     INT(5)      NOT NULL,
    officer_id      INT(5)      NOT NULL,
    date_submitted  DATE        NOT NULL,

    PRIMARY KEY (evidence_id),
    FOREIGN KEY (file_id)
        REFERENCES hoa_files (file_id),
    FOREIGN KEY (resident_id)
        REFERENCES resident (resident_id),
    FOREIGN KEY (officer_id)
        REFERENCES hoa_officer (officer_id)
);

INSERT INTO receipt
			VALUES  (202379999, '2023-10-30 00:00:00', 2500),
					(202380000, '2023-12-30 00:00:00', 3000),
                    (202380001, '2024-03-10 00:00:00', 1200),
                    (202380002, '2024-01-31 09:57:27', 2000);
            
INSERT INTO hoa_files
			VALUES  (555556664, 'COMM1Pumpkin.pdf', 'COMM 1 - Pumpkin Baskets', 'D:/Animo HOA Documents/Programs/expense/', 'pdf', '2023-10-31', 'Jose Rizal', 99901, 'Animo HOA'),
					(555556665, 'COMM3Performers.pdf', 'COMM 3 - Performers', 'D:/Animo HOA Documents/Programs/expense/', 'pdf', '2023-12-31', 'Gabriela Silang', 99902, 'Animo HOA'),
                    (555556666, 'COMM4Cleaning.pdf', 'COMM 4 - Cleaning Materials', 'd:/Animo HOA Documents/Programs/expense/', 'pdf', '2024-03-10', 'Juanita Dela Cruz', 99903, 'Animo HOA'),
                    (555556667, 'ChristmasTree.jpeg', 'COMM 2 - Christmas Tree', 'D:/Animo HOA Documents/Programs/', 'image', '2024-01-01', 'Jose Rizal', 99901, 'Animo HOA'),
                    (555556668, 'Participants.jpeg', 'COMM 2 - Christmas Lighting Participants', 'D:/Animo HOA Documents/Programs/', 'image', '2024-01-01', 'Jose Rizal', 99901, 'Animo HOA'),
                    (555556669, 'Fireworks.jpeg', 'COMM 3 - Fireworks during New Year', 'D:/Animo HOA Documents/Programs/', 'image', '2024-01-03', 'Gabriela Silang', 99902, 'Animo HOA'),
                    (555556670, 'COMM1Snacks.pdf', 'COMM 1 - Snacks', 'D:/Animo HOA Documents/Programs/expense/', 'pdf', '2023-10-31', 'Jose Rizal', 99901, 'Animo HOA');
INSERT INTO expense
			VALUES  (202379999, 202300, '2023-10-30', 'Pumpkin baskets for trick-or-treating', 2500.00, 70001, 555556664, 1),
					(202380002, 202401, '2024-01-31', 'Snacks for the attendees', 2000.00, 70001, 555556670, 1),
					(202380000, 202400, '2023-12-30', 'Performers for the New Year', 3000.00, 70009, 555556665, 1),
                    (202380001, 202402, '2024-03-10', 'Cleaning materials for the drive', 1200.00, 70013, 555556666, 1);

INSERT INTO expense_type
			VALUES  (202379999, 'Materials'),
					(202380002, 'Services'),
					(202380002, 'Manpower'),
                    (202380000, 'Manpower'),
                    (202380001, 'Materials');

INSERT INTO request
			VALUES  (000001, 202301, 'To allow more participants to join', '2023-12-15', 1, 'Disapproved'),
					(000002, 202400, 'Fireworks for the celebration', '2023-12-20', 1, 'Approved'),
                    (000003, 202402, 'To cater to more volunteers for the drive', '2024-03-05', 1, 'For approval');

INSERT INTO rejected_request
			VALUES 	(000001, 'Only few residents are Christians');

INSERT INTO evidence
			VALUES  (000001, 'Picture of the Christmas tree', 555556667, 40012, 99901, '2024-01-01'),
					(000002, 'Picture of the participants', 555556668, 40011, 99901, '2024-01-01'),
                    (000003, 'Fireworks during the New Year', 555556669, 40017, 99902, '2024-01-03');

-- 2C ------------
DROP TABLE IF EXISTS registration;
CREATE TABLE IF NOT EXISTS registration (
	register_id 		INT (4) NOT NULL,
	resident_id 		INT (5) NOT NULL,
	program_id  		INT (4) NOT NULL,
	`status`    		ENUM('pending', 'rejected', 'approved') NOT NULL,
    approving_officer	INT (5) NOT NULL,
    
	PRIMARY KEY (register_id),
	FOREIGN KEY (resident_id) 
		REFERENCES resident (resident_id),
    FOREIGN KEY (program_id)  
		REFERENCES program (program_id),
	FOREIGN KEY (approving_officer)
		REFERENCES committee_membership (membership_id)
);

DROP TABLE IF EXISTS rejected_reg;
CREATE TABLE IF NOT EXISTS rejected_reg (
	register_id       	INT (4) 			NOT NULL,
	rejection_reason	VARCHAR (255)   	NOT NULL,
    
	PRIMARY KEY (register_id),
    FOREIGN KEY (register_id) 
		REFERENCES registration (register_id)
);

DROP TABLE IF EXISTS accepted_reg;
CREATE TABLE IF NOT EXISTS accepted_reg (
	register_id			INT(4)		NOT NULL,
    PRIMARY KEY (register_id),
    FOREIGN KEY (register_id)
		REFERENCES registration (register_id)
);

DROP TABLE IF EXISTS attendance;
CREATE TABLE IF NOT EXISTS attendance (
  attendance_id INT (4)   	NOT NULL,
  resident_id   INT (5)   	NOT NULL,
  program_id    INT (4)   	NOT NULL,
  register_id	INT (4), 
  time_in       DATETIME  NOT NULL,
  time_out      DATETIME  NOT NULL,

	PRIMARY KEY (attendance_id),
	FOREIGN KEY (resident_id) 
		REFERENCES resident (resident_id),
    FOREIGN KEY (program_id)  
		REFERENCES program (program_id),
	FOREIGN KEY (register_id)
		REFERENCES accepted_reg (register_id)
);

DROP TABLE IF EXISTS feedback;
CREATE TABLE IF NOT EXISTS feedback (
	attendance_id	INT(4) 		NOT NULL,
	created_at  	DATETIME    NOT NULL,
    feedback		TEXT		NOT NULL,
	rating      	INT (2) 	NOT NULL,
	suggestions 	TEXT,
    
	PRIMARY KEY (attendance_id), 
    FOREIGN KEY (attendance_id)
		REFERENCES attendance(attendance_id)
);

INSERT INTO registration  
      VALUES  (5001, 40016, 202300, 'approved', 70001),
              (5002, 40017, 202300, 'approved', 70004),
              (5003, 40020, 202300, 'approved', 70001),
              (5007, 40018, 202300, 'rejected', 70001),
              (5004, 40018, 202401, 'pending', 70002);

INSERT INTO rejected_reg  
	VALUES  (5007, 'Did not satisfy the program requirements: Not a homeowner');

INSERT INTO accepted_reg
	VALUES	(5001),
			(5002),
			(5003);

INSERT INTO attendance  
      VALUES  (0001, 40016, 202300, 5001, '2023-10-31 17:04:32', '2023-11-01 04:14:01' ),
              (0002, 40020, 202300, 5002, '2023-10-31 17:12:20', '2023-11-01 04:13:23' ),
              (0003, 40018, 202300, 5003, '2023-10-31 17:13:04', '2023-11-01 04:12:56' ),
              (0004, 40019, 202300, NULL, '2023-10-31 17:15:10', '2023-11-01 04:13:46' ),
              (0005, 40012, 202300, NULL, '2023-10-31 23:01:58', '2023-11-01 04:06:01' );

INSERT INTO feedback  
      VALUES  (0001, '2023-11-01 04:13:01', 'Very fun program, keep it up!', 9, NULL),
              (0003, '2023-11-01 04:12:01', 'Wish there were more food to eat. But I had a great time!.', 8, 'I suggest that they add more ventilation to the place'),
              (0004, '2023-11-01 04:13:01', 'It was a long program', 5, NULL);


-- 2d --------------
DROP TABLE IF EXISTS asset_transfer;
CREATE TABLE IF NOT EXISTS asset_transfer (
	transfer_id	INT(4)	NOT NULL,
	asset_id	VARCHAR(10)	NOT NULL,
    sched_date	DATE	NOT NULL,
    actual_date	DATE	NOT NULL,
    officer_id	INT(5)	NOT NULL,
    source_address_id INT NOT NULL,
    dest_address_id INT NOT NULL,
    transfer_cost	FLOAT	NOT NULL,
    transferer_lastname	VARCHAR(45)	NOT NULL,
    transferer_firstname	VARCHAR(45)	NOT NULL,
    transferer_mobileno	BIGINT(10)	NOT NULL,
    or_no	INT	NOT NULL,
    status	ENUM('S','O','C','D')	NOT NULL,
    deleted_at		DATETIME,
    
	PRIMARY KEY (transfer_id),
    FOREIGN KEY (asset_id)
		REFERENCES asset (asset_id),
    FOREIGN KEY (officer_id)
		REFERENCES hoa_officer (officer_id),
	FOREIGN KEY			(or_no)
		REFERENCES			receipt(or_no),
	FOREIGN KEY			(source_address_id)
		REFERENCES			address(address_id),
	FOREIGN KEY			(dest_address_id)
		REFERENCES			address(address_id)
);

INSERT INTO receipt
		VALUES 	(202379994, '2023-10-15', 3000.00),
				(202379995, '2023-10-15', 10000.00),
                (202379996, '2023-11-15', 15000.00),
                (202379997, '2023-01-15', 3000.00),
                (202379998, '2023-02-15', 7500.00);


INSERT INTO asset_transfer
			VALUES (2001, 'P000000001', '2023-09-20', '2023-09-25', 99903, 10000020, 10000025, 10000.50, 'Hopkins', 'John', 9817263519, 202379994, 'C', NULL),
				   (2002, 'E000000001', '2023-10-15', '2023-10-17', 99904, 10000021, 10000024, 30000.75, 'Johnson', 'Martha', 9175812791, 202379995, 'D', '2023-10-18 00:00:01'),
                   (2003, 'P000000002', '2023-11-20', '2023-11-20', 99905, 10000022, 10000023, 10500.55, 'Adams', 'Gerald', 9628361701, 202379996, 'S', NULL),
                   (2004, 'P000000001', '2023-11-10', '2023-11-15', 99906, 10000025, 10000021, 20000.50, 'Hopkins', 'John', 9817263519, 202379997, 'O', NULL);
                   