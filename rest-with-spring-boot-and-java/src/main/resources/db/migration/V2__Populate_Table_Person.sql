CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `first_name` varchar(80) NOT NULL,
    `last_name` varchar(80) NOT NULL,
    `address` varchar(100) NOT NULL,
    `gender` varchar(10) NOT NULL,
    PRIMARY KEY (`id`)
    );

INSERT INTO `person` (`id`, `address`, `first_name`, `gender`, `last_name`) VALUES
    (1, 'Aracaju-SE', 'Ricardo', 'Goat', 'Kaka'),
    (2, 'Kingston upon Thames, Grande Londres', 'Declan', 'Goat', 'Rice'),
    (5, 'Mvezo - South Africa', 'Nelson', 'Male', 'Mandela'),
    (6, 'Mvezo - South Africa', 'Nelson', 'Male', 'Mandela'),
    (7, 'Smiljan - Croatia', 'Nikola', 'Male', 'Tesla');