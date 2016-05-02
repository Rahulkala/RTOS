-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 09, 2013 at 09:25 AM
-- Server version: 5.5.20
-- PHP Version: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_master`
--

CREATE TABLE IF NOT EXISTS `category_master` (
  `category` varchar(15) NOT NULL,
  `discount` int(2) DEFAULT '0',
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category_master`
--

INSERT INTO `category_master` (`category`, `discount`) VALUES
('chinese', 0),
('indian', 0),
('Non-Veg', 0),
('pizza', 2),
('shakes', 0);

-- --------------------------------------------------------

--
-- Table structure for table `customer_master`
--

CREATE TABLE IF NOT EXISTS `customer_master` (
  `c_name` varchar(50) DEFAULT NULL,
  `c_email` varchar(25) NOT NULL,
  `c_dob` varchar(10) DEFAULT NULL,
  `c_address` varchar(50) DEFAULT NULL,
  `c_phone` varchar(11) DEFAULT NULL,
  `c_pwd` varchar(25) DEFAULT NULL,
  `que` varchar(30) DEFAULT NULL,
  `ans` varchar(30) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`c_email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_master`
--

INSERT INTO `customer_master` (`c_name`, `c_email`, `c_dob`, `c_address`, `c_phone`, `c_pwd`, `que`, `ans`, `status`) VALUES
('Darshan', 'a@abc.com', '1995-Jan-1', 'dslhf kjds f Vadodara/Baroda Gujarat', '83297973', 'abc', 'what is your petname?', 'dhaval', 'c'),
('admin', 'admin@abc.com', '1995-Jan-1', 'abcd Vadodara/Baroda Gujarat', '99990000', 'admin', 'what is your petname?', 'ad', 'a'),
('rahul', 'rkala26@gmail.com', '1995-Jan-1', 'A\\7 Manokamana 2 tarsali Vadodara/Baroda Gujarat', '9687583717', 'abc', 'what is your petname?', 'browney', 'c');

-- --------------------------------------------------------

--
-- Table structure for table `customer_order_master`
--

CREATE TABLE IF NOT EXISTS `customer_order_master` (
  `orderid` varchar(85) NOT NULL DEFAULT '',
  `customer_name` varchar(85) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `orderlist` blob,
  `bill` float(6,2) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_order_master`
--

INSERT INTO `customer_order_master` (`orderid`, `customer_name`, `date`, `orderlist`, `bill`) VALUES
('19FF736EF2D151A70BE283A8301617B3', 'Darshan', '2013-04-05', 0x5b636f6d2e72746f732e4f72646572496e666f40313462393163342c20636f6d2e72746f732e4f72646572496e666f403466316131395d, 55.00),
('37D8F88A75E5D26380F858F8AC917C84', 'Darshan', '2013-04-05', 0x5b636f6d2e72746f732e4f72646572496e666f406236356231372c20636f6d2e72746f732e4f72646572496e666f403136363433325d, 75.00),
('3F8C6FABE488DE660CF4FD816550868E', 'Darshan', '2013-04-05', 0x5b636f6d2e72746f732e4f72646572496e666f40313262316535342c20636f6d2e72746f732e4f72646572496e666f40316434343837625d, 40.00),
('55F2AB8A614E701A95B12033DEEF763B', 'Darshan', '2013-04-05', 0x5b636f6d2e72746f732e4f72646572496e666f403730656630395d, 15.00);

-- --------------------------------------------------------

--
-- Table structure for table `item_master`
--

CREATE TABLE IF NOT EXISTS `item_master` (
  `item_name` varchar(15) NOT NULL,
  `item_price` int(11) DEFAULT NULL,
  `category` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`item_name`),
  KEY `category` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_master`
--

INSERT INTO `item_master` (`item_name`, `item_price`, `category`) VALUES
('coco', 15, 'shakes'),
('Dal', 60, 'indian'),
('noodles', 40, 'chinese'),
('roti', 5, 'indian');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item_master`
--
ALTER TABLE `item_master`
  ADD CONSTRAINT `item_master_ibfk_1` FOREIGN KEY (`category`) REFERENCES `category_master` (`category`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
