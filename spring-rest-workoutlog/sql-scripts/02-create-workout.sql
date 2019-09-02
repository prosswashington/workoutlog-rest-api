--
-- Table structure for table `workout`
--

DROP TABLE IF EXISTS `workout`;

CREATE TABLE `workout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workout_name` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
