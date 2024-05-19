insert into address (id, address_line1, address_line2, city, postal_code) values (1, 'xx', 'yy', 'Kraków', '62-030');
insert into address (id, address_line1, address_line2, city, postal_code) values (2, 'aa', 'bb', 'Poznań', '60-030');
insert into address (id, address_line1, address_line2, city, postal_code) values (3, 'bb', 'cc', 'Wrocław', '11-030');
insert into address (id, address_line1, address_line2, city, postal_code) values (4, 'cc', 'dd', 'Warszawa', '55-030');
insert into address (id, address_line1, address_line2, city, postal_code) values (5, '333', 'c333', 'Wrocław', '11-111');
insert into address (id, address_line1, address_line2, city, postal_code) values (6, 'zzzz', 'wert', 'Wrocław', '11-222');
insert into address (id, address_line1, address_line2, city, postal_code) values (7, 'yyyy', 'wwww', 'Wrocław', '55-333');


insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values (1, 'nr1', 'doctor1@wp.pl', 'Zenon','Nowak', 'SURGEON', '71-123-45-67', 1);
insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values (2, 'nr2', 'doctor2@wp.pl', 'Zenobiusz','Kwak', 'GP', '71-123-45-68', 2);
insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values (3, 'nr3', 'doctor3@wp.pl', 'Zeb','Kawa', 'DERMATOLOGIST', '71-123-45-69', 3);
insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values (4, 'nr4', 'doctor4@wp.pl', 'Funky','Koval', 'OCULIST', '71-123-45-60', 4);


insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id, dodana_kolumna) values (1, '1980-01-01', 'patient1@wp.pl', 'Pacjent','Pierwszy', '1234567890', '77-123-45-00', 5, 101);
insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id, dodana_kolumna) values (2, '1981-02-02', 'patient2@wp.pl', 'Pacjent2','Dwa', '1234567891', '77-123-45-01', 6, 102);
insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id, dodana_kolumna) values (3, '1983-03-03', 'patient3@wp.pl', 'Pacjent3','Trzy', '1234567892', '77-123-45-02', 7, 103);


insert into visit (id, description, time, doctor_id, patient_id) values (1, 'Opis 1', '2024-01-21 12:20:55', 1, 1);
insert into visit (id, description, time, doctor_id, patient_id) values (2, 'Opis 2', '2024-01-22 13:23:05', 1, 2);
insert into visit (id, description, time, doctor_id, patient_id) values (3, 'Opis 3', '2024-02-23 11:23:15', 2, 2);
insert into visit (id, description, time, doctor_id, patient_id) values (4, 'Opis 4', '2024-02-24 08:03:01', 3, 3);
insert into visit (id, description, time, doctor_id, patient_id) values (5, 'Opis 5', '2024-02-25 10:33:11', 4, 3);


insert into medical_treatment (id, description, type, visit_id) values (1, 'Jakis opis opis opis', 'RTG', 1);
insert into medical_treatment (id, description, type, visit_id) values (2, 'Jakis opis opis opis 2', 'EKG', 2);
insert into medical_treatment (id, description, type, visit_id) values (3, 'Jakis opis opis opis 3', 'RTG', 3);
insert into medical_treatment (id, description, type, visit_id) values (4, 'Jakis opis opis opis 4', 'EKG', 4);
insert into medical_treatment (id, description, type, visit_id) values (5, 'Jakis opis opis opis 5', 'USG', 5);
insert into medical_treatment (id, description, type, visit_id) values (6, 'Jakis opis opis opis 6', 'USG', 1);
insert into medical_treatment (id, description, type, visit_id) values (7, 'Jakis opis opis opis 7', 'USG', 2);
insert into medical_treatment (id, description, type, visit_id) values (8, 'Jakis opis opis opis 8', 'USG', 3);
