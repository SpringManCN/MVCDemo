/*
Navicat MySQL Data Transfer

Source Server         : rgbData
Source Server Version : 50619
Source Host           : 127.0.0.1:3306
Source Database       : rgboa_db

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-08-04 17:46:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for depart
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `uuid` varchar(45) NOT NULL,
  `departName` varchar(45) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `pid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FK_USER_DEPART_idx` (`pid`),
  CONSTRAINT `FK_DEPART_DEPART` FOREIGN KEY (`pid`) REFERENCES `depart` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES ('1', '技术部', '123', null);
INSERT INTO `depart` VALUES ('3', 'OA项目组1', '321', '1');
INSERT INTO `depart` VALUES ('402881ea479ad9dc01479ae005e50000', 'test', 'test', null);
INSERT INTO `depart` VALUES ('402881ea479b6dad01479b7aa7260000', '谁谁谁123', '谁谁谁123', '402881ea479ad9dc01479ae005e50000');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `uuid` varchar(45) NOT NULL,
  `text` varchar(45) DEFAULT NULL,
  `pid` varchar(45) DEFAULT NULL,
  `view` varchar(45) DEFAULT NULL,
  `contr` varchar(45) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FK_MENU_MENU_idx` (`pid`),
  CONSTRAINT `FK_MENU_MENU` FOREIGN KEY (`pid`) REFERENCES `menu` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户管理', null, null, null, null);
INSERT INTO `menu` VALUES ('2', '人员管理', '1', 'userList', 'userManage.UserController', null);
INSERT INTO `menu` VALUES ('3', '角色管理', '1', 'roleList', 'userManage.RoleController', null);
INSERT INTO `menu` VALUES ('4', '部门管理', '1', 'departView', 'userManage.DepartController', null);
INSERT INTO `menu` VALUES ('5', '系统管理', null, '', '', null);
INSERT INTO `menu` VALUES ('6', '菜单管理', '5', 'menuView', 'sysm.menuController', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `uuid` varchar(45) NOT NULL,
  `roleName` varchar(45) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '程序猿', '苦逼的程序员');
INSERT INTO `role` VALUES ('402881e7478f898601478f89c64b0000', 'test', 'test123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uuid` varchar(45) NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `realName` varchar(45) DEFAULT NULL,
  `roleId` varchar(45) DEFAULT NULL,
  `DepartId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FK_USER_ROLE_idx` (`roleId`),
  KEY `FK_USER_DEPART_idx` (`DepartId`),
  CONSTRAINT `FK_USER_DEPART` FOREIGN KEY (`DepartId`) REFERENCES `depart` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_ROLE` FOREIGN KEY (`roleId`) REFERENCES `role` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('402881e7478ac8f401478b5cc9da0000', 'springMan', '202CB962AC59075B964B07152D234B70', '春哥', '1', '1');
INSERT INTO `user` VALUES ('402881e7478ac8f401478b618b950001', 'springMan1', 'D41D8CD98F00B204E9800998ECF8427E', '春哥3', '1', '1');
INSERT INTO `user` VALUES ('402881e7478b961801478b99dbd30000', 'dyl', '9E542B7755A6C2F05C3F07E2DDF92AAF', '段云龙', '1', '1');
INSERT INTO `user` VALUES ('402881ea478c0c9d01478c0e2e8e0000', 'yj', '585790F98FF1DD61412AAD36654E0371', '杨景', null, null);
