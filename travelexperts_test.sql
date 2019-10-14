-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2019 at 10:20 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travelexperts_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--

CREATE TABLE `countries` (
  `CountryId` int(11) NOT NULL,
  `CountryName` varchar(25) NOT NULL,
  `Age` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `countries`
--

INSERT INTO `countries` (`CountryId`, `CountryName`, `Age`) VALUES
(1, 'Canada', NULL),
(2, 'United States', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `provstates`
--

CREATE TABLE `provstates` (
  `ProvStateCode` varchar(2) NOT NULL,
  `ProvStateName` varchar(35) NOT NULL,
  `CountryId` int(11) NOT NULL DEFAULT 2
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `provstates`
--

INSERT INTO `provstates` (`ProvStateCode`, `ProvStateName`, `CountryId`) VALUES
('AB', 'Alberta', 1),
('AK', 'Alaska', 2),
('AL', 'Alabama', 2),
('AR', 'Arkansas', 2),
('AZ', 'Arizona', 2),
('BC', 'British Columbia', 1),
('CA', 'California', 2),
('CO', 'Colorado', 2),
('CT', 'Connecticut', 2),
('DE', 'Delaware', 2),
('FL', 'Florida', 2),
('GA', 'Georgia', 2),
('HI', 'Hawaii', 2),
('IA', 'Iowa', 2),
('ID', 'Idaho', 2),
('IL', 'Illinois', 2),
('IN', 'Indiana', 2),
('KS', 'Kansas', 2),
('KY', 'Kentucky', 2),
('LA', 'Louisiana', 2),
('MA', 'Massechusetts', 2),
('MB', 'Manitoba', 1),
('MD', 'Maryland', 2),
('ME', 'Maine', 2),
('MI', 'Michigan', 2),
('MN', 'Minnesota', 2),
('MO', 'Missouri', 2),
('MS', 'Mississippi', 2),
('MT', 'Montana', 2),
('NB', 'New Brunswick', 1),
('NC', 'North Carolina', 2),
('ND', 'North Dakota', 2),
('NE', 'Nebraska', 2),
('NH', 'New Hampshire', 2),
('NJ', 'New Jersey', 2),
('NL', 'Newfoundland & Labrador', 1),
('NM', 'New Mexico', 2),
('NS', 'Nova Scotia', 1),
('NT', 'Northwest Territories', 1),
('NU', 'Nunavut', 1),
('NV', 'Nevada', 2),
('NY', 'New York', 2),
('OH', 'Ohio', 2),
('OK', 'Oklahoma', 2),
('ON', 'Ontario', 1),
('OR', 'Oregon', 2),
('PA', 'Pennsylvania', 2),
('PE', 'Prince Edward Island', 1),
('QC', 'Quebec', 1),
('RI', 'Rhode Island', 2),
('SC', 'South Carolina', 2),
('SD', 'South Dakota', 2),
('SK', 'Saskatchewan', 1),
('TN', 'Tennessee', 2),
('TX', 'Texas', 2),
('UT', 'Utah', 2),
('VA', 'Virginia', 2),
('VT', 'Vermont', 2),
('WA', 'Washington', 2),
('WI', 'Wisconsin', 2),
('WV', 'West Virginia', 2),
('WY', 'Wyoming', 2),
('YT', 'Yukon', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`CountryId`);

--
-- Indexes for table `provstates`
--
ALTER TABLE `provstates`
  ADD PRIMARY KEY (`ProvStateCode`),
  ADD KEY `countryId` (`CountryId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `countries`
--
ALTER TABLE `countries`
  MODIFY `CountryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `provstates`
--
ALTER TABLE `provstates`
  ADD CONSTRAINT `countryId` FOREIGN KEY (`CountryId`) REFERENCES `countries` (`CountryId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
