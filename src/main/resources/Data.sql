INSERT INTO bus_info (bus_number, driver_name, phone_number, machine) VALUES ('63', 'Dmytroa', '0930536123', 'автобус');
INSERT INTO bus_info (bus_number, driver_name, phone_number, machine) VALUES ('64', 'Dmytrof', '0930536123', 'автобус');
INSERT INTO bus_info (bus_number, driver_name, phone_number, machine) VALUES ('65', 'Dmytro', '0930536123', 'bus');

INSERT INTO time_table (id_bus_info, `day`, begin_work, end_work) VALUES ('1', 'monday', '10:11:12', '10:11:12');
INSERT INTO time_table (id_bus_info, `day`, begin_work, end_work) VALUES ('1', 'friday', '10:11:12', '10:11:12');

INSERT INTO route (id_bus_info, street_name, start_coordinate, end_coordinate) VALUES ('1', 'Вовчинецька', '3423 4', '234 43');
INSERT INTO route (id_bus_info, street_name, start_coordinate, end_coordinate) VALUES ('1', 'Брати', '3423 4', '234 43');
INSERT INTO route (id_bus_info, street_name, start_coordinate, end_coordinate) VALUES ('1', 'Незалежності', '3423 4', '234 43');

INSERT INTO stop_stations (`name`, coordinate) VALUES ('Велес', '234 4');
INSERT INTO stop_stations (`name`, coordinate) VALUES ('Козачок', '234 4');
INSERT INTO stop_stations (`name`, coordinate) VALUES ('Ринок', '234 4');

INSERT INTO route_stop_stations(route_id, stop_stations_id) VALUES ('1', '1');
INSERT INTO route_stop_stations(route_id, stop_stations_id) VALUES ('3', '2');
INSERT INTO route_stop_stations(route_id, stop_stations_id) VALUES ('2', '3');