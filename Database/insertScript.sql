INSERT INTO user_groups (`ugr_id`, `ugr_name`, `ugr_administration`, `ugr_grade`) VALUES ('1', 'Default', '0', 'Default group');
INSERT INTO user_groups (`ugr_id`, `ugr_name`, `ugr_administration`, `ugr_grade`) VALUES ('2', 'Read-Only', '1', 'Read-Only group');
INSERT INTO user_groups (`ugr_id`, `ugr_name`, `ugr_administration`, `ugr_grade`) VALUES ('3', 'Standard', '2', 'Standard group');
INSERT INTO user_groups (`ugr_id`, `ugr_name`, `ugr_administration`, `ugr_grade`) VALUES ('4', 'Administrator', '3', 'Administrator group');
INSERT INTO user_groups (`ugr_id`, `ugr_name`, `ugr_administration`, `ugr_grade`) VALUES ('5', 'Super-User', '4', 'SuperUser group');


INSERT INTO users (`use_username`, `use_cac_id`, `use_first_name`, `use_last_name`, `use_password`, `use_active`, `use_logged_in`, `use_added`, `use_added_by`) VALUES ('super', '0000000', 'Super', 'User', 'super', '1', '0', current_timestamp, 'super');
INSERT INTO user_roles (`usr_id`, `usr_use_username`, `usr_name`, `usr_ugr_id`) VALUES ('1', 'super', 'Super-User', '5');

INSERT INTO society_policies (`spl_id`, `spl_start_date`, `spl_late_opening_charge_percent`, `spl_application_fee`, `spl_monthly_share`, `spl_loan_interest_rate`, `spl_loan_late_fee`, `spl_share_late_fee`, `spl_loan_max_amount`, `spl_loan_max_emi`, `spl_payment_day`, `spl_payment_due_day`, `spl_updated`, `spl_updated_by`) VALUES ('1', '2016-07-01', '10', '100', '500', '10', '10', '10', '10000', '12', '1', '1', '2019-02-20 00:00:00', 'super');
