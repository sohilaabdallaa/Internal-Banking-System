-- Create user table
CREATE TABLE clinet (
    NationalID VARCHAR(14) PRIMARY KEY,
    FullName VARCHAR(255),
    Email VARCHAR(255),
    Password VARCHAR(20),
    Username VARCHAR(25)
);

-- Create Account Table
CREATE TABLE Account (
    AccNumber VARCHAR(14) PRIMARY KEY,
    balance DECIMAL(8)
);

-- Create Transaction Table
CREATE TABLE transact (
    TransId INT PRIMARY KEY,
    SourceAccount INT,
    DestinationAccount INT,
    Date DATETIME,
    Amount DECIMAL(10, 2)
);

