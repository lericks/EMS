-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2018 at 11:14 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ems`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(124) NOT NULL,
  `address` varchar(124) NOT NULL,
  `tagline` varchar(64) NOT NULL,
  `pin` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `name`, `address`, `tagline`, `pin`, `email`) VALUES
(1, 'Insert Company Name Here', 'Address Here', 'Tagline Here', 'KRA pin here', 'Email Here');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_number` int(11) NOT NULL,
  `name` varchar(124) NOT NULL,
  `gender` varchar(64) NOT NULL,
  `id_number` varchar(64) NOT NULL,
  `phone_number` varchar(64) NOT NULL,
  `physical_address` varchar(124) NOT NULL,
  `dob` varchar(64) NOT NULL,
  `department` varchar(124) NOT NULL,
  `position` varchar(124) NOT NULL,
  `responsibilities` varchar(360) NOT NULL,
  `bank` varchar(124) NOT NULL,
  `branch` varchar(64) NOT NULL,
  `acc_number` varchar(64) NOT NULL,
  `gross_income` varchar(124) NOT NULL,
  `kra_pin` varchar(124) NOT NULL,
  `nssf_number` int(124) NOT NULL,
  `nhif_number` varchar(124) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_number`, `name`, `gender`, `id_number`, `phone_number`, `physical_address`, `dob`, `department`, `position`, `responsibilities`, `bank`, `branch`, `acc_number`, `gross_income`, `kra_pin`, `nssf_number`, `nhif_number`) VALUES
(1, 'Erick Odhiambo', 'Male', '3302346454', '0701 395 564', 'Kisii - Town', '25/06/1990', 'ICT', 'Manager', 'Overall accountability and management of ICT equipments\nand staff', 'Equity', 'Kisii', '023464685', '120000', 'A251002535MP', 2563, '1235'),
(2, 'Bob Norris', 'Male', '32456692', '0723355656', 'Kitale', '20/7/1980', 'Maintenance', 'Technician', 'Maintenance of electrical equipments', 'KCB', 'Kitale', '32665335656', '150000', 'E2356564685', 8520, '6393'),
(3, 'David Rudisha', 'Male', '323253645', '0701937231', 'Kisii-Mwembe', '17/06/1989', 'Security', 'In charge', 'Guard of the premise', 'Cooperative', 'Kisii', '23545523252', '12500', 'A2356565756M', 20215, '3625456');

-- --------------------------------------------------------

--
-- Table structure for table `employee_leave`
--

CREATE TABLE `employee_leave` (
  `id` int(11) NOT NULL,
  `employee_number` varchar(64) NOT NULL,
  `leave_type` varchar(64) NOT NULL,
  `from_date` varchar(64) NOT NULL,
  `to_date` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_leave`
--

INSERT INTO `employee_leave` (`id`, `employee_number`, `leave_type`, `from_date`, `to_date`) VALUES
(4, '1', 'Annual Leave', '12/06/2018', '25/09/2018');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `level` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `level`) VALUES
('admin', 'admin', 'Admin'),
('nocks', 'nocks', 'Non - Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_number`),
  ADD UNIQUE KEY `id_number` (`id_number`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `acc_number` (`acc_number`),
  ADD UNIQUE KEY `nhif_number` (`nhif_number`),
  ADD UNIQUE KEY `nssf_number` (`nssf_number`),
  ADD UNIQUE KEY `kra_pin` (`kra_pin`);

--
-- Indexes for table `employee_leave`
--
ALTER TABLE `employee_leave`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `employee_number` (`employee_number`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `employee_leave`
--
ALTER TABLE `employee_leave`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
