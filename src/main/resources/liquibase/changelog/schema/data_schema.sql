-- Changeset 1: Добавление пользователей
INSERT INTO users (name, surname, birth_date, inn, snils, pass_number, login, password) VALUES
('Ivan', 'Ivanov', '1985-04-15 00:00:00', '123456789012', '12345678901', 'IV123456', 'ivan.ivanov@example.com', 'Pass@123'),
('Petr', 'Petrov', '1990-06-20 00:00:00', '234567890123', '23456789012', 'PT654321', 'petr.petrov@example.com', 'Pass@234'),
('Maria', 'Sidorova', '1988-02-11 00:00:00', '345678901234', '34567890123', 'MS789012', 'maria.sidorova@example.com', 'Pass@345'),
('Anna', 'Smirnova', '1992-12-30 00:00:00', '456789012345', '45678901234', 'AS890123', 'anna.smirnova@example.com', 'Pass@456'),
('Sergey', 'Sokolov', '1980-01-05 00:00:00', '567890123456', '56789012345', 'SS901234', 'sergey.sokolov@example.com', 'Pass@567'),
('Elena', 'Kuznetsova', '1987-09-14 00:00:00', '678901234567', '67890123456', 'EK012345', 'elena.kuznetsova@example.com', 'Pass@678'),
('Dmitry', 'Morozov', '1995-03-22 00:00:00', '789012345678', '78901234567', 'DM123457', 'dmitry.morozov@example.com', 'Pass@789'),
('Olga', 'Volkova', '1983-11-08 00:00:00', '890123456789', '89012345678', 'OV234568', 'olga.volkova@example.com', 'Pass@890'),
('Alexander', 'Lebedev', '1979-07-19 00:00:00', '901234567890', '90123456789', 'AL345679', 'alexander.lebedev@example.com', 'Pass@901'),
('Natalia', 'Pavlova', '1991-05-30 00:00:00', '012345678901', '01234567890', 'NP456780', 'natalia.pavlova@example.com', 'Pass@012');
--rollback DELETE * from users;
