create database alert_to_care;
use alert_to_care;


Create table icu_info(
	icu_Id int NOT NULL AUTO_INCREMENT,
	layout varchar(2) NOT NULL,
	icu_Maximum_Capacity int NOT NULL,
    PRIMARY KEY (icu_Id)
);

Create table device_info(
	device_Id int NOT NULL AUTO_INCREMENT,
	spo2 int NOT NULL,
	bpm int NOT NULL,
    respRate int NOT NULL,
    PRIMARY KEY (device_Id)
);

Create table bed_info(
	bed_Id int NOT NULL AUTO_INCREMENT,
	device_Id int NOT NULL,
	icu_Id int NOT NULL,
    bed_Status boolean NOT NULL,
    PRIMARY KEY (bed_Id),
    FOREIGN KEY (device_Id) REFERENCES device_info(device_Id),
    FOREIGN KEY (icu_Id) REFERENCES icu_info(icu_Id)
);

Create table alert_info(
	alert_Id int NOT NULL AUTO_INCREMENT,
	bed_Id int NOT NULL,
    error_Message varchar(20) NOT NULL,
    PRIMARY KEY (alert_Id),
    FOREIGN KEY (bed_Id) REFERENCES bed_info(bed_Id)
);

Create table patient_info(
	patient_Id int NOT NULL AUTO_INCREMENT,
	name varchar(20) NOT NULL,
	age int NOT NULL,
    bed_Id int NOT NULL,
    PRIMARY KEY (patient_Id),
    FOREIGN KEY (bed_Id) REFERENCES bed_info(bed_Id)
);

insert into icu_info (layout,icu_Maximum_Capacity) values ('L', 5);
insert into icu_info (layout,icu_Maximum_Capacity) values ('U', 5);

insert into device_info(spo2,bpm,respRate) values (20,30,40);
insert into device_info(spo2,bpm,respRate) values (20,50,50);
insert into device_info(spo2,bpm,respRate) values (50,30,40);
insert into device_info(spo2,bpm,respRate) values (20,90,30);
insert into device_info(spo2,bpm,respRate) values (10,30,40);
insert into device_info(spo2,bpm,respRate) values (30,90,40);
insert into device_info(spo2,bpm,respRate) values (20,30,10);
insert into device_info(spo2,bpm,respRate) values (20,50,40);
insert into device_info(spo2,bpm,respRate) values (20,60,40);
insert into device_info(spo2,bpm,respRate) values (20,70,40);

insert into bed_info(device_Id,icu_Id,bed_Status) values (1,1,true);
insert into bed_info(device_Id,icu_Id,bed_Status) values (2,1,false);
insert into bed_info(device_Id,icu_Id,bed_Status) values (3,1,false);
insert into bed_info(device_Id,icu_Id,bed_Status) values (4,1,true);
insert into bed_info(device_Id,icu_Id,bed_Status) values (5,1,true);
insert into bed_info(device_Id,icu_Id,bed_Status) values (6,2,false);
insert into bed_info(device_Id,icu_Id,bed_Status) values (7,2,false);
insert into bed_info(device_Id,icu_Id,bed_Status) values (8,2,true);
insert into bed_info(device_Id,icu_Id,bed_Status) values (9,2,true);
insert into bed_info(device_Id,icu_Id,bed_Status) values (10,2,false);


insert into alert_info(bed_Id,error_Message) values (1,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (2,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (3,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (4,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (5,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (6,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (7,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (8,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (9,'Vital is Normal');
insert into alert_info(bed_Id,error_Message) values (10,'Vital is Normal');


insert into patient_info(name,age,bed_Id) values ('ram',25,1);
insert into patient_info(name,age,bed_Id) values ('ravi',24,9);