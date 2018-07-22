CREATE TABLE addresses (
  add_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  add_line1 VARCHAR(30) NULL,
  add_line2 VARCHAR(30) NULL,
  add_line3 VARCHAR(30) NULL,
  add_city VARCHAR(30) NULL,
  add_taluka VARCHAR(30) NULL,
  add_district VARCHAR(30) NULL,
  add_state VARCHAR(30) NULL,
  add_post_code VARCHAR(10) NULL,
  add_country VARCHAR(30) NULL,
  add_mobile VARCHAR(15) NULL,
  add_email VARCHAR(40) NULL,
  add_added TIMESTAMP NULL,
  add_added_by VARCHAR(45) NULL,
  PRIMARY KEY(add_id)
);

CREATE TABLE customer_accounts (
  cac_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  cac_cde_id MEDIUMINT(8) UNSIGNED NULL,
  cac_sac_id MEDIUMINT(8) UNSIGNED NULL,
  cac_lac_id MEDIUMINT(8) UNSIGNED NULL,
  cac_opening_bal INTEGER UNSIGNED NULL,
  cac_opening_month INTEGER UNSIGNED NULL,
  cac_application_fee SMALLINT UNSIGNED NULL,
  cac_introducer_cac_id MEDIUMINT(8) UNSIGNED NULL,
  cac_loan_guarantor_count TINYINT UNSIGNED NULL,
  cac_active TINYINT(1) UNSIGNED NULL,
  cac_opened TIMESTAMP NULL,
  cac_opened_by VARCHAR(45) NULL,
  PRIMARY KEY(cac_id)
);

CREATE TABLE customer_details (
  cde_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  cde_add_id MEDIUMINT(8) UNSIGNED NULL,
  cde_title VARCHAR(10) NULL,
  cde_first_name VARCHAR(40) NULL,
  cde_middle_name VARCHAR(40) NULL,
  cde_last_name VARCHAR(40) NULL,
  cde_dob DATE NULL,
  cde_gender VARCHAR(2) NULL,
  cde_occupation VARCHAR(20) NULL,
  cde_religion VARCHAR(20) NULL,
  cde_created TIMESTAMP NULL,
  cde_created_by VARCHAR(45) NULL,
  PRIMARY KEY(cde_id)
);

CREATE TABLE loan_accounts (
  lac_id MEDIUMINT(8) UNSIGNED NOT NULL,
  lac_cac_id MEDIUMINT(8) UNSIGNED NULL,
  lac_amount INTEGER UNSIGNED NULL,
  lac_emi SMALLINT UNSIGNED NULL,
  lac_emi_amount INTEGER UNSIGNED NULL,
  lac_rem_amount INTEGER UNSIGNED NULL,
  lac_emi_number SMALLINT UNSIGNED NULL,
  lac_pending_emi TINYINT UNSIGNED NULL,
  lac_interest_rate TINYINT UNSIGNED NULL,
  lac_fine INTEGER UNSIGNED NULL,
  lac_intimation TINYINT(2) UNSIGNED NULL,
  lac_guarantor1 MEDIUMINT(8) UNSIGNED NULL,
  lac_guarantor2 MEDIUMINT(8) UNSIGNED NULL,
  lac_approved TIMESTAMP NULL,
  lac_approved_by VARCHAR(45) NULL,
  PRIMARY KEY(lac_id)
);

CREATE TABLE share_accounts (
  sac_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  sac_balance INTEGER UNSIGNED NULL,
  sac_fine INTEGER UNSIGNED NULL,
  sac_rem_month TINYINT UNSIGNED NULL,
  sac_opened TIMESTAMP NULL,
  sac_opened_by VARCHAR(45) NULL,
  PRIMARY KEY(sac_id)
);

CREATE TABLE society_accounts (
  soc_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  soc_cac_id MEDIUMINT(8) UNSIGNED NOT NULL,
  soc_sac_amount INTEGER UNSIGNED NULL,
  soc_lac_amount INTEGER UNSIGNED NULL,
  soc_emergency_amount INTEGER UNSIGNED NULL,
  soc_loan_given_amount INTEGER UNSIGNED NULL,
  soc_fund INTEGER UNSIGNED NULL,
  soc_transacted TIMESTAMP NULL,
  soc_transacted_by VARCHAR(45) NULL,
  PRIMARY KEY(soc_id)
);

CREATE TABLE society_policies (
  spl_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  spl_start_date DATE NULL,
  spl_late_opening_charge_percent TINYINT UNSIGNED NULL,
  spl_application_fee SMALLINT UNSIGNED NULL,
  spl_monthly_share SMALLINT UNSIGNED NULL,
  spl_loan_interest_rate TINYINT UNSIGNED NULL,
  spl_loan_late_fee SMALLINT UNSIGNED NULL,
  spl_share_late_fee SMALLINT UNSIGNED NULL,
  spl_loan_max_amount INTEGER UNSIGNED NULL,
  spl_loan_max_emi SMALLINT UNSIGNED NULL,
  spl_payment_date DATE NULL,
  spl_payment_due_date DATE NULL,
  spl_updated TIMESTAMP NULL,
  spl_updated_by VARCHAR(45) NULL,
  PRIMARY KEY(spl_id)
);

CREATE TABLE society_preferences (
  spr_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  spr_name VARCHAR(50) NULL,
  spr_value VARCHAR(255) NULL,
  spr_created TIMESTAMP NULL,
  spr_created_by VARCHAR(45) NULL,
  spr_last_updated TIMESTAMP NULL,
  spr_last_updated_by VARCHAR(45) NULL,
  PRIMARY KEY(spr_id)
);

CREATE TABLE transactions (
  tra_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  tra_cac_id MEDIUMINT(8) UNSIGNED NULL,
  tra_lac_id MEDIUMINT(8) UNSIGNED NULL,
  tra_amount INTEGER UNSIGNED NULL,
  tra_late_fee SMALLINT UNSIGNED NULL,
  tra_particulars VARCHAR(255) NULL,
  tra_payment INTEGER UNSIGNED NULL,
  tra_collected DATE NULL,
  tra_collected_by VARCHAR(45) NULL,
  tra_transacted TIMESTAMP NULL,
  tra_transacted_by VARCHAR(45) NULL,
  PRIMARY KEY(tra_id)
);

CREATE TABLE users (
  use_username VARCHAR(45) NOT NULL,
  use_cac_id MEDIUMINT(8) UNSIGNED NULL,
  use_title VARCHAR(10) NULL,
  use_first_name VARCHAR(40) NOT NULL,
  use_last_name VARCHAR(40) NOT NULL,
  use_password VARCHAR(60) NOT NULL,
  use_active TINYINT(1) UNSIGNED NULL,
  use_logged_in TINYINT(1) UNSIGNED NULL,
  use_session_id VARCHAR(150) NULL,
  use_added TIMESTAMP NULL,
  use_added_by VARCHAR(45) NULL,
  PRIMARY KEY(use_username)
);

CREATE TABLE user_groups (
  ugr_id MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  ugr_name VARCHAR(40) NULL,
  ugr_administration SMALLINT UNSIGNED NULL,
  ugr_grade VARCHAR(40) NULL,
  PRIMARY KEY(ugr_id)
);

CREATE TABLE user_roles (
  usr_id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
  usr_use_username VARCHAR(45) NULL,
  usr_name VARCHAR(40) NULL,
  usr_ugr_id MEDIUMINT(8) UNSIGNED NULL,
  PRIMARY KEY(usr_id)
);


