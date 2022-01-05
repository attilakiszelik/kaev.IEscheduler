INSERT INTO USERS (name, email, password, activation_key, enabled, locked) VALUES ('Admin', 'com.kaev.iescheduler@gmail.com', '$2a$10$8hWG55PXQbjOqmSL0R9Ge.ZsoJMQ9Pvja6q2ApxK/uZqt4pXp4oZq', 'already_activated', true, false)
INSERT INTO USERS (name, email, password, activation_key, enabled, locked) VALUES ('Attila', 'attila.kiszelik@gmail.com', '$2a$10$LC9rHQmamdeBEvBOsorx9OYGxNgb2tZlGwYdZfDcgkPQl9EC7kHV6', 'already_activated', true, false)
INSERT INTO USERS (name, email, password, activation_key, enabled, locked) VALUES ('Ankó', 'budahazi.a@gmail.com', '$2a$10$tbUt7DHsDKc.zSq1Dglxnu54JsN502kJfVmVjCwsGZ5cSAoaJGhAu', 'already_activated', true, false)

INSERT INTO ROLES (id, role) VALUES (1, 'ADMIN')
INSERT INTO ROLES (id, role) VALUES (2, 'USER')

INSERT INTO USERS_ROLES (user_id, role_id) VALUES (1, 1)
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (2, 2)
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (3, 2)

INSERT INTO VEHICLES (deleted,regnum,man,type,yop,owner_id) VALUES (false,'ABC-000','MAN','TGS',2000,1)
INSERT INTO VEHICLES (deleted,regnum,man,type,yop,owner_id) VALUES (false,'ABC-123','MAN','TGM',2000,2)
INSERT INTO VEHICLES (deleted,regnum,man,type,yop,owner_id) VALUES (false,'ABC-456','MAN','TGL',2000,2)
INSERT INTO VEHICLES (deleted,regnum,man,type,yop,owner_id) VALUES (false,'ABC-789','MAN','TGX',2000,2)
INSERT INTO VEHICLES (deleted,regnum,man,type,yop,owner_id) VALUES (false,'XYZ-000','MAN','eTGM',2000,3)

INSERT INTO EVENTS (date, time, user_id, vehicle_id, service, status) VALUES ('2021-01-05T00:00:00', '11:00', 2, 1, 'FEKBETETCSERE','accepted')