
SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `BcryptExample`;

CREATE DATABASE IF NOT EXISTS `BcryptExample`;

use `BcryptExample`;

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `permName` varchar(50) DEFAULT NULL,
  `permTag` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_permission` VALUES ('1', 'search the order', 'showOrder', '/showOrder');
INSERT INTO `sys_permission` VALUES ('2', 'add order', 'addOrder', '/addOrder');
INSERT INTO `sys_permission` VALUES ('3', 'edit order', 'updateOrder', '/updateOrder');
INSERT INTO `sys_permission` VALUES ('4', 'del order', 'deleteOrder', '/deleteOrder');

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_role` VALUES ('1', 'admin', 'Enable full permissions');
INSERT INTO `sys_role` VALUES ('2', 'add_user', 'Enable add and show');

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(10) DEFAULT NULL,
  `perm_id` int(10) DEFAULT NULL,
  KEY `FK_Reference_3` (`role_id`),
  KEY `FK_Reference_4` (`perm_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`perm_id`) REFERENCES `sys_permission` (`id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '2');

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `lastLoginTime` date DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `accountNonExpired` tinyint(1) DEFAULT NULL,
  `accountNonLocked` tinyint(1) DEFAULT NULL,
  `credentialsNonExpired` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_user` VALUES ('1', 'admin', 'Admin', '$2a$10$CKSuX5YBJqOQww3DikXnXeDjFzrPyWjmAFBEEtApb9TrNMVModmuS', '2018-11-13', '2018-11-13', 1, 1, 1, 1);
INSERT INTO `sys_user` VALUES ('2', 'userAdd', 'User', '$2a$10$CKSuX5YBJqOQww3DikXnXeDjFzrPyWjmAFBEEtApb9TrNMVModmuS', '2018-11-13', '2018-11-13', 1, 1, 1, 1);

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(10) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_2` (`role_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
