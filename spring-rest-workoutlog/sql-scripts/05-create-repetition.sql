--
-- Table structure for table `repetition`
--

DROP TABLE IF EXISTS `repetition`;

CREATE TABLE `repetition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exercise_id` int(11) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `repetitions` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`exercise_id`) REFERENCES exercise(id) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;