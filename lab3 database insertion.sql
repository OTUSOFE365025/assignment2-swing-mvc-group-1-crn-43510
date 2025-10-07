INSERT INTO Hotel (hotelNo, hotelName, city) VALUES
(1, 'Grand Palace', 'Paris'),
(2, 'Sunny Stay', 'New York'),
(3, 'Comfort Inn', 'Tokyo'),
(4, 'Breeze Hotel', 'Dubai'),
(5, 'Riverside Retreat', 'Sydney');

INSERT INTO Guest (guestNo, guestName, guestAddress) VALUES
(1, 'Alice Bennett', '12 Maple Street, London'),
(2, 'Daniel Hughes', '45 Oak Avenue, Manchester'),
(3, 'Sophie Turner', '9 Hillcrest Road, London'),
(4, 'Liam O’Connor', '27 Queen’s Way, Birmingham'),
(5, 'Grace Patel', '88 Riverside Lane, London'),
(6, 'Oliver Smith', '17 Elm Grove, Bristol'),
(7, 'Chloe Brown', '54 Westbrook Drive, Leeds'),
(8, 'Ethan Jones', '11 Park Crescent, London'),
(9, 'Mia Wilson', '63 Meadow Lane, Liverpool'),
(10, 'Noah Clarke', '101 Station Road, London');

INSERT INTO Room (roomNo, hotelNo, type, price) VALUES
(1, 1, 'single', 30.00),
(2, 1, 'double', 45.00),
(3, 1, 'family', 80.00),
(4, 2, 'single', 28.00),
(5, 2, 'double', 42.00),
(6, 2, 'family', 70.00),
(7, 3, 'single', 35.00),
(8, 3, 'double', 50.00),
(9, 3, 'family', 75.00),
(10, 4, 'single', 32.00),
(11, 4, 'double', 55.00),
(12, 4, 'family', 85.00),
(13, 5, 'single', 38.00),
(14, 5, 'double', 48.00),
(15, 5, 'family', 90.00),
(16, 1, 'single', 25.00),
(17, 2, 'double', 39.00),
(18, 3, 'family', 65.00),
(19, 4, 'single', 36.00),
(20, 5, 'double', 40.00);

INSERT INTO Booking (hotelNo, guestNo, roomNo, dateFrom, dateTo) VALUES
(1, 1, 1, '2025-10-01', '2025-10-05'),
(2, 2, 5, '2025-10-03', NULL),
(1, 3, 3, '2025-10-05', '2025-10-10'),
(2, 4, 6, '2025-10-07', '2025-10-09'),
(1, 5, 16, '2025-10-08', NULL),
(3, 6, 7, '2025-10-10', '2025-10-12'),
(4, 7, 10, '2025-10-12', '2025-10-14'),
(5, 8, 14, '2025-10-15', '2025-10-20'),
(3, 9, 9, '2025-10-18', NULL),
(5, 10, 20, '2025-10-20', '2025-10-25');



