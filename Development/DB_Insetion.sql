-- Insert data into the user table for multiple users
INSERT INTO clientt (NationalID, FullName, Email, Password, Username)
VALUES
('12345678901234', 'John Doe', 'john@example.com', 'password123', 'johndoe'),
('23456789012345', 'Jane Smith', 'jane@example.com', 'password456', 'janesmith'),
('34567890123456', 'Alice Johnson', 'alice@example.com', 'password789', 'alicejohnson');

-- Insert data into the Account table
INSERT INTO Account (AccNumber, balance)
VALUES
(1, 1000.00),
(2, 500.00),
(3, 750.00);

-- Insert data into the transact table
INSERT INTO transact (TransId, SourceAccount, DestinationAccount, Date, Amount)
VALUES
(1, 1, 2, '2024-05-11 10:00:00', 100.00),
(2, 3, 1, '2024-05-11 11:30:00', 250.00);
