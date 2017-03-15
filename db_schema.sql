CREATE TABLE `property` (
  `key` varchar(500) NOT NULL,
  `value` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `property` VALUES ('error.not_valid','There is no valid {0} ID found');