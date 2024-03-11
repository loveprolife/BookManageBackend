DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT '',
                        `author` varchar(255) DEFAULT '',
                        `publicationyear` varchar(255) DEFAULT '',
                        `ISBN` varchar(255) DEFAULT '',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
