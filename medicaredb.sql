-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2024 at 07:24 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medicare`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `id` bigint(20) NOT NULL,
  `appointment_date` varchar(255) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `doctor_id` bigint(20) NOT NULL,
  `patient_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`id`, `appointment_date`, `purpose`, `doctor_id`, `patient_id`) VALUES
(3, '2024-09-09', 'Pain ', 1, 2),
(4, '2024-09-08', 'Fever ', 5, 1),
(5, '2024-09-08', 'Toothach ', 1, 1),
(6, '2024-09-09', 'Root Canal ', 1, 1),
(7, '2024-09-08', 'Alignment ', 1, 2),
(8, '2024-09-09', 'Pain ', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` bigint(20) NOT NULL,
  `chamber_address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fees` double NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `visiting_days` varchar(255) DEFAULT NULL,
  `visiting_hours` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `chamber_address`, `email`, `fees`, `gender`, `image_url`, `mobile`, `name`, `password`, `qualification`, `specialization`, `visiting_days`, `visiting_hours`) VALUES
(1, 'KIIT Square', 'john@gmail.com', 500, 'Male', '98ab71e1-ce26-4e84-8bf5-ddec996d48ad_doc-1.jpg', '8745698569', 'John Smith', 'Test@1234', 'BDS', 'Dentist', 'All Day', '07AM - 09 AM'),
(2, 'Nalco Square', 'jane@gmail.com', 1000, 'Female', '3eb5e04d-281b-498c-9409-24ba6e35ae7e_doc-2.jpg', '7856489658', 'Jane Smith', 'Test@1234', 'MBBS', 'Skin Specialist', 'Saturday, Sunday', '08AM -10-AM, 05PM - 8PM'),
(4, 'KIIT Square', 'sara@gmail.com', 500, 'Female', 'cd231d4b-7f1a-4ce6-b12b-9e7ac9a8e73c_doc-6.jpeg', '6569856325', 'Sara Smith', 'Test@1234', 'BDS', 'Dentist', 'All Day', '08AM -10-AM, 05PM - 8PM'),
(5, 'Patiya, BBSR', 'bimal@gmail.com', 500, 'Male', '95478ef1-a847-4c81-96aa-3f780d8f657b_doc-4.jpg', '8423658975', 'Bimal M.', 'Test@1234', 'MBBS', 'General Physician', 'All Day', '07AM - 09 AM'),
(6, 'Nalco Square', 'kamal@gmail.com', 600, 'Male', 'f5312797-2350-4579-80ab-d8e3748564ed_doc-5.jpg', '8236478596', 'Kamal Rout', 'Test@1234', 'MBBS, MD', 'Orthopedic', 'All Day', '08AM -10-AM, 05PM - 8PM');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `id` bigint(20) NOT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `mobile` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`id`, `date_of_birth`, `email`, `gender`, `mobile`, `name`, `password`) VALUES
(1, '2024-08-26', 'rams@gmail.com', 'Male', 9874569256, 'Ram Sharma', 'Test@1234'),
(2, '2024-08-26', 'radha@gmail.com', 'Female', 8956478956, 'Radha Sen', 'Test@1234'),
(3, '2024-08-26', 'ajay@gmail.com', 'Male', 7561239856, 'Ajay Kar', 'Test@1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmujeo4tymoo98cmf7uj3vsv76` (`doctor_id`),
  ADD KEY `FK8exap5wmg8kmb1g1rx3by21yt` (`patient_id`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKcaifv0va46t2mu85cg5afmayf` (`email`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKa370hmxgv0l5c9panryr1ji7d` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `FK8exap5wmg8kmb1g1rx3by21yt` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  ADD CONSTRAINT `FKmujeo4tymoo98cmf7uj3vsv76` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
