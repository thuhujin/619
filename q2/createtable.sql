DROP TABLE IF EXISTS `tweets`;
SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_database = utf8;
SET character_set_results = utf8;
SET character_set_server = utf8;
CREATE TABLE `tweets` (
  `user_id` varchar(15) NOT NULL,
  `time` varchar(35) NOT NULL,
  `tweet_id` varchar(25) NOT NULL,
  `score` int(10) DEFAULT NULL,
  `content` varchar(2000) NOT NULL
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
LOAD DATA INFILE "sample" INTO TABLE tweets FIELDS TERMINATED BY "\t";
CREATE INDEX id_time on tweets(user_id, time);