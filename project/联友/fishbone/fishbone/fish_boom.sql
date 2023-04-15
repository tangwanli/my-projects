/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : fish_boom

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-11-20 11:22:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc
-- ----------------------------
DROP TABLE IF EXISTS `doc`;
CREATE TABLE `doc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` char(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` varchar(255) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `creator` char(50) DEFAULT NULL,
  `size` varchar(255) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_document_project` (`pid`),
  KEY `fk_document_task` (`tid`),
  CONSTRAINT `fk_document_project` FOREIGN KEY (`pid`) REFERENCES `proj` (`id`),
  CONSTRAINT `fk_document_task` FOREIGN KEY (`tid`) REFERENCES `task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc
-- ----------------------------
INSERT INTO `doc` VALUES ('6', '19', '鱼骨_接口文档_未修订版1.xlsx', '2019-10-28 22:34:39', '项目里面的文件', null, null, '0');
INSERT INTO `doc` VALUES ('7', '19', '鱼骨_数据库设计.xlsx', '2019-10-28 22:34:51', '项目里面的文件', null, null, '0');
INSERT INTO `doc` VALUES ('8', '19', 'response.png', '2019-11-13 13:58:59', '项目里面的文件', null, 'dre', '5620');
INSERT INTO `doc` VALUES ('9', '19', '备注.txt', '2019-11-13 15:06:41', null, null, 'kanye', '774');
INSERT INTO `doc` VALUES ('10', '19', '鱼刺_接口文档_完整版_20191015.xlsx', '2019-11-13 15:06:53', null, null, 'kanye', '38024');
INSERT INTO `doc` VALUES ('11', '53', 'user.xlsx', '2019-11-16 14:16:41', null, null, 'kanye', '8937');

-- ----------------------------
-- Table structure for grou
-- ----------------------------
DROP TABLE IF EXISTS `grou`;
CREATE TABLE `grou` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grou
-- ----------------------------
INSERT INTO `grou` VALUES ('1', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('2', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('3', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('4', 'Postman项目成员');
INSERT INTO `grou` VALUES ('5', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('6', 'Postman项目成员');
INSERT INTO `grou` VALUES ('7', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('8', 'Postman项目成员');
INSERT INTO `grou` VALUES ('9', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('10', 'Postman项目成员');
INSERT INTO `grou` VALUES ('11', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('12', 'Postman项目成员');
INSERT INTO `grou` VALUES ('13', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('14', 'Postman项目成员');
INSERT INTO `grou` VALUES ('15', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('16', 'Postman项目成员');
INSERT INTO `grou` VALUES ('17', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('18', 'Postman项目成员');
INSERT INTO `grou` VALUES ('19', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('20', 'Postman项目成员');
INSERT INTO `grou` VALUES ('21', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('22', 'Postman项目成员');
INSERT INTO `grou` VALUES ('23', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('24', 'Postman项目成员');
INSERT INTO `grou` VALUES ('25', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('26', 'Postman项目成员');
INSERT INTO `grou` VALUES ('27', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('28', 'Postman项目成员');
INSERT INTO `grou` VALUES ('29', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('30', 'Postman项目成员');
INSERT INTO `grou` VALUES ('31', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('32', 'Postman项目成员');
INSERT INTO `grou` VALUES ('33', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('34', 'Postman项目成员');
INSERT INTO `grou` VALUES ('35', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('36', 'Postman项目成员');
INSERT INTO `grou` VALUES ('37', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('38', 'Postman项目成员');
INSERT INTO `grou` VALUES ('39', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('40', 'Postman项目成员');
INSERT INTO `grou` VALUES ('41', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('42', 'Postman项目成员');
INSERT INTO `grou` VALUES ('43', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('44', 'Postman项目成员');
INSERT INTO `grou` VALUES ('45', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('46', 'Postman项目成员');
INSERT INTO `grou` VALUES ('47', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('48', 'Postman项目成员');
INSERT INTO `grou` VALUES ('49', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('50', 'Postman项目成员');
INSERT INTO `grou` VALUES ('51', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('52', 'Postman项目成员');
INSERT INTO `grou` VALUES ('53', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('54', 'Postman项目成员');
INSERT INTO `grou` VALUES ('55', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('56', 'Postman项目成员');
INSERT INTO `grou` VALUES ('57', 'Postman项目抄送人');
INSERT INTO `grou` VALUES ('58', 'Postman项目成员');
INSERT INTO `grou` VALUES ('71', '');
INSERT INTO `grou` VALUES ('72', '');
INSERT INTO `grou` VALUES ('73', '');
INSERT INTO `grou` VALUES ('74', '');
INSERT INTO `grou` VALUES ('77', '');
INSERT INTO `grou` VALUES ('78', '');
INSERT INTO `grou` VALUES ('79', '');
INSERT INTO `grou` VALUES ('80', '');
INSERT INTO `grou` VALUES ('81', '');
INSERT INTO `grou` VALUES ('82', '');
INSERT INTO `grou` VALUES ('83', '');
INSERT INTO `grou` VALUES ('84', '');
INSERT INTO `grou` VALUES ('85', '');
INSERT INTO `grou` VALUES ('86', '');
INSERT INTO `grou` VALUES ('87', '');
INSERT INTO `grou` VALUES ('88', '');
INSERT INTO `grou` VALUES ('89', '');
INSERT INTO `grou` VALUES ('90', '');
INSERT INTO `grou` VALUES ('91', '');
INSERT INTO `grou` VALUES ('92', '');
INSERT INTO `grou` VALUES ('93', '');
INSERT INTO `grou` VALUES ('94', '');
INSERT INTO `grou` VALUES ('95', '');
INSERT INTO `grou` VALUES ('96', '');
INSERT INTO `grou` VALUES ('97', '');
INSERT INTO `grou` VALUES ('98', '');
INSERT INTO `grou` VALUES ('99', '');
INSERT INTO `grou` VALUES ('100', '');
INSERT INTO `grou` VALUES ('101', '');
INSERT INTO `grou` VALUES ('102', '');
INSERT INTO `grou` VALUES ('103', '');
INSERT INTO `grou` VALUES ('104', '');
INSERT INTO `grou` VALUES ('105', '');
INSERT INTO `grou` VALUES ('106', '');
INSERT INTO `grou` VALUES ('107', '');
INSERT INTO `grou` VALUES ('108', '');
INSERT INTO `grou` VALUES ('109', '');
INSERT INTO `grou` VALUES ('110', '');
INSERT INTO `grou` VALUES ('111', '');
INSERT INTO `grou` VALUES ('112', '');
INSERT INTO `grou` VALUES ('113', '');
INSERT INTO `grou` VALUES ('114', '');
INSERT INTO `grou` VALUES ('115', '');
INSERT INTO `grou` VALUES ('116', '');
INSERT INTO `grou` VALUES ('117', '');
INSERT INTO `grou` VALUES ('118', '');
INSERT INTO `grou` VALUES ('119', '');
INSERT INTO `grou` VALUES ('120', '');
INSERT INTO `grou` VALUES ('121', '');
INSERT INTO `grou` VALUES ('122', '');
INSERT INTO `grou` VALUES ('123', '');
INSERT INTO `grou` VALUES ('124', '');
INSERT INTO `grou` VALUES ('125', '');
INSERT INTO `grou` VALUES ('126', '');
INSERT INTO `grou` VALUES ('127', '');
INSERT INTO `grou` VALUES ('128', '');
INSERT INTO `grou` VALUES ('129', '');
INSERT INTO `grou` VALUES ('130', '');
INSERT INTO `grou` VALUES ('131', '');
INSERT INTO `grou` VALUES ('132', '');
INSERT INTO `grou` VALUES ('133', '');
INSERT INTO `grou` VALUES ('134', '');
INSERT INTO `grou` VALUES ('135', '');
INSERT INTO `grou` VALUES ('136', '');
INSERT INTO `grou` VALUES ('137', '');
INSERT INTO `grou` VALUES ('138', '');
INSERT INTO `grou` VALUES ('139', '');
INSERT INTO `grou` VALUES ('140', '');
INSERT INTO `grou` VALUES ('141', '');
INSERT INTO `grou` VALUES ('142', '');
INSERT INTO `grou` VALUES ('143', '');
INSERT INTO `grou` VALUES ('144', '');
INSERT INTO `grou` VALUES ('147', '');
INSERT INTO `grou` VALUES ('148', '');
INSERT INTO `grou` VALUES ('149', '');
INSERT INTO `grou` VALUES ('150', '');
INSERT INTO `grou` VALUES ('151', '');
INSERT INTO `grou` VALUES ('152', '');
INSERT INTO `grou` VALUES ('153', '');
INSERT INTO `grou` VALUES ('154', '');
INSERT INTO `grou` VALUES ('155', '');
INSERT INTO `grou` VALUES ('156', '');
INSERT INTO `grou` VALUES ('157', '');
INSERT INTO `grou` VALUES ('158', '');
INSERT INTO `grou` VALUES ('159', '');
INSERT INTO `grou` VALUES ('160', '');
INSERT INTO `grou` VALUES ('161', '');
INSERT INTO `grou` VALUES ('162', '');
INSERT INTO `grou` VALUES ('163', '');
INSERT INTO `grou` VALUES ('164', '');
INSERT INTO `grou` VALUES ('165', '');
INSERT INTO `grou` VALUES ('166', '');
INSERT INTO `grou` VALUES ('167', '');
INSERT INTO `grou` VALUES ('168', '');
INSERT INTO `grou` VALUES ('169', '');
INSERT INTO `grou` VALUES ('170', '');
INSERT INTO `grou` VALUES ('171', '');
INSERT INTO `grou` VALUES ('172', '');
INSERT INTO `grou` VALUES ('173', '');
INSERT INTO `grou` VALUES ('174', '');
INSERT INTO `grou` VALUES ('175', '');
INSERT INTO `grou` VALUES ('176', '');
INSERT INTO `grou` VALUES ('177', '');
INSERT INTO `grou` VALUES ('178', '');
INSERT INTO `grou` VALUES ('179', '');
INSERT INTO `grou` VALUES ('180', '');
INSERT INTO `grou` VALUES ('181', '');
INSERT INTO `grou` VALUES ('182', '');
INSERT INTO `grou` VALUES ('183', '');
INSERT INTO `grou` VALUES ('184', '');
INSERT INTO `grou` VALUES ('185', '');
INSERT INTO `grou` VALUES ('186', '');
INSERT INTO `grou` VALUES ('187', '');
INSERT INTO `grou` VALUES ('188', '');
INSERT INTO `grou` VALUES ('189', '');
INSERT INTO `grou` VALUES ('190', '');
INSERT INTO `grou` VALUES ('191', '');
INSERT INTO `grou` VALUES ('192', '');
INSERT INTO `grou` VALUES ('197', '');
INSERT INTO `grou` VALUES ('198', '');
INSERT INTO `grou` VALUES ('199', '');
INSERT INTO `grou` VALUES ('200', '');
INSERT INTO `grou` VALUES ('201', '');
INSERT INTO `grou` VALUES ('202', '');
INSERT INTO `grou` VALUES ('206', '');
INSERT INTO `grou` VALUES ('207', '');
INSERT INTO `grou` VALUES ('208', '');
INSERT INTO `grou` VALUES ('209', '');
INSERT INTO `grou` VALUES ('210', '');
INSERT INTO `grou` VALUES ('211', '');
INSERT INTO `grou` VALUES ('212', '');
INSERT INTO `grou` VALUES ('213', '');
INSERT INTO `grou` VALUES ('214', '');
INSERT INTO `grou` VALUES ('215', '');
INSERT INTO `grou` VALUES ('216', '');
INSERT INTO `grou` VALUES ('217', '');
INSERT INTO `grou` VALUES ('218', '');
INSERT INTO `grou` VALUES ('219', '');
INSERT INTO `grou` VALUES ('220', '');
INSERT INTO `grou` VALUES ('221', '');
INSERT INTO `grou` VALUES ('222', '');
INSERT INTO `grou` VALUES ('223', '');
INSERT INTO `grou` VALUES ('224', '');
INSERT INTO `grou` VALUES ('225', '');
INSERT INTO `grou` VALUES ('226', '');
INSERT INTO `grou` VALUES ('227', '');
INSERT INTO `grou` VALUES ('228', '');
INSERT INTO `grou` VALUES ('229', '');
INSERT INTO `grou` VALUES ('230', '');
INSERT INTO `grou` VALUES ('231', '');
INSERT INTO `grou` VALUES ('232', '');
INSERT INTO `grou` VALUES ('233', '');
INSERT INTO `grou` VALUES ('234', '');
INSERT INTO `grou` VALUES ('235', '');
INSERT INTO `grou` VALUES ('236', '');
INSERT INTO `grou` VALUES ('237', '');
INSERT INTO `grou` VALUES ('238', '');
INSERT INTO `grou` VALUES ('239', '');
INSERT INTO `grou` VALUES ('240', '');
INSERT INTO `grou` VALUES ('241', '');
INSERT INTO `grou` VALUES ('242', '');
INSERT INTO `grou` VALUES ('243', '');
INSERT INTO `grou` VALUES ('244', '');
INSERT INTO `grou` VALUES ('245', '');
INSERT INTO `grou` VALUES ('246', '');
INSERT INTO `grou` VALUES ('247', '');
INSERT INTO `grou` VALUES ('248', '');
INSERT INTO `grou` VALUES ('249', '');
INSERT INTO `grou` VALUES ('250', '');
INSERT INTO `grou` VALUES ('251', '');
INSERT INTO `grou` VALUES ('252', '');
INSERT INTO `grou` VALUES ('253', '');
INSERT INTO `grou` VALUES ('254', '');
INSERT INTO `grou` VALUES ('255', '');
INSERT INTO `grou` VALUES ('256', '');
INSERT INTO `grou` VALUES ('257', '');
INSERT INTO `grou` VALUES ('258', '');
INSERT INTO `grou` VALUES ('259', '');
INSERT INTO `grou` VALUES ('260', '');
INSERT INTO `grou` VALUES ('261', '');
INSERT INTO `grou` VALUES ('262', '');
INSERT INTO `grou` VALUES ('263', '');
INSERT INTO `grou` VALUES ('264', '');
INSERT INTO `grou` VALUES ('265', '');
INSERT INTO `grou` VALUES ('266', '');
INSERT INTO `grou` VALUES ('267', '');
INSERT INTO `grou` VALUES ('268', '');
INSERT INTO `grou` VALUES ('269', '');
INSERT INTO `grou` VALUES ('270', '');
INSERT INTO `grou` VALUES ('271', '');
INSERT INTO `grou` VALUES ('272', '');
INSERT INTO `grou` VALUES ('273', '');
INSERT INTO `grou` VALUES ('274', '');
INSERT INTO `grou` VALUES ('275', '');
INSERT INTO `grou` VALUES ('276', '');
INSERT INTO `grou` VALUES ('277', '');
INSERT INTO `grou` VALUES ('278', '');
INSERT INTO `grou` VALUES ('279', '');
INSERT INTO `grou` VALUES ('280', '');
INSERT INTO `grou` VALUES ('281', '');
INSERT INTO `grou` VALUES ('282', '');
INSERT INTO `grou` VALUES ('283', '');
INSERT INTO `grou` VALUES ('284', '');
INSERT INTO `grou` VALUES ('285', '');
INSERT INTO `grou` VALUES ('286', '');
INSERT INTO `grou` VALUES ('287', '');
INSERT INTO `grou` VALUES ('288', '');
INSERT INTO `grou` VALUES ('289', '');
INSERT INTO `grou` VALUES ('290', '');
INSERT INTO `grou` VALUES ('291', '');
INSERT INTO `grou` VALUES ('292', '');
INSERT INTO `grou` VALUES ('293', '');
INSERT INTO `grou` VALUES ('294', '');
INSERT INTO `grou` VALUES ('295', '');
INSERT INTO `grou` VALUES ('296', '');
INSERT INTO `grou` VALUES ('297', '');
INSERT INTO `grou` VALUES ('298', '');
INSERT INTO `grou` VALUES ('299', '');
INSERT INTO `grou` VALUES ('300', '');

-- ----------------------------
-- Table structure for itera
-- ----------------------------
DROP TABLE IF EXISTS `itera`;
CREATE TABLE `itera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  `demand_num` int(10) DEFAULT NULL,
  `defect_num` int(10) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itera
-- ----------------------------
INSERT INTO `itera` VALUES ('1', null, null, null, '2019-10-14 15:12:46', null, null, null);
INSERT INTO `itera` VALUES ('2', null, null, null, '2019-10-14 15:40:16', null, null, null);
INSERT INTO `itera` VALUES ('3', null, null, null, '2019-10-14 15:41:35', null, null, null);
INSERT INTO `itera` VALUES ('4', 'leegen', '5', '5', '2019-10-14 13:21:22', '2019-10-14 13:21:22', '2', 'Test');
INSERT INTO `itera` VALUES ('5', 'leegen', '5', '5', '2019-10-14 13:21:22', '2019-10-14 13:21:22', '2', 'Test');
INSERT INTO `itera` VALUES ('6', 'leegen', '5', '5', '2019-10-14 13:21:22', '2019-10-14 13:21:22', '2', 'Test');

-- ----------------------------
-- Table structure for modal
-- ----------------------------
DROP TABLE IF EXISTS `modal`;
CREATE TABLE `modal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modal
-- ----------------------------

-- ----------------------------
-- Table structure for opera
-- ----------------------------
DROP TABLE IF EXISTS `opera`;
CREATE TABLE `opera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `creator` char(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_op_project` (`pid`),
  KEY `fk_op_task` (`tid`),
  CONSTRAINT `fk_op_project` FOREIGN KEY (`pid`) REFERENCES `proj` (`id`),
  CONSTRAINT `fk_op_task` FOREIGN KEY (`tid`) REFERENCES `task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=373 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opera
-- ----------------------------
INSERT INTO `opera` VALUES ('153', '19', null, 'kanye', '132132', '2019-11-11 15:17:23');
INSERT INTO `opera` VALUES ('165', '19', null, 'kanye', '13123123', '2019-11-11 15:52:48');
INSERT INTO `opera` VALUES ('205', null, '62', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test2\",\"name\":\"uzi\",\"id\":3,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-12 11:22:49');
INSERT INTO `opera` VALUES ('206', null, '62', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test2\",\"name\":\"uzi\",\"id\":3,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"},{\"acco\":\"Test3\",\"name\":\"offset\",\"id\":4,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-12 11:22:59');
INSERT INTO `opera` VALUES ('209', null, '62', 'kanye', '修改任务', '2019-11-12 11:49:52');
INSERT INTO `opera` VALUES ('210', null, '62', 'kanye', '修改任务', '2019-11-12 11:49:55');
INSERT INTO `opera` VALUES ('217', '19', null, 'kanye', '修改项目', '2019-11-12 15:47:45');
INSERT INTO `opera` VALUES ('218', '19', null, 'kanye', '修改项目抄送人为：[{\"acco\":\"yunwei001\",\"name\":\"Test2\",\"id\":1,\"dept\":\"智能网联\",\"position\":\"产品经理\"},{\"acco\":\"Test2\",\"name\":\"uzi\",\"id\":3,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"},{\"acco\":\"Test1\",\"name\":\"wukong\",\"id\":2,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-12 15:51:15');
INSERT INTO `opera` VALUES ('219', '19', null, 'kanye', '修改项目项目到期时间为：2019-09-02 00:00:00', '2019-11-12 15:51:24');
INSERT INTO `opera` VALUES ('220', '19', null, 'kanye', '修改项目项目到期时间为：2019-11-09 00:00:00', '2019-11-12 15:51:30');
INSERT INTO `opera` VALUES ('221', '19', null, 'kanye', '修改项目项目优先级为：低', '2019-11-12 15:51:33');
INSERT INTO `opera` VALUES ('222', '19', null, 'kanye', '修改项目项目描述为：postman测试\ndsadsgfdsfsd', '2019-11-12 15:51:42');
INSERT INTO `opera` VALUES ('223', '19', null, 'kanye', '修改项目项目经理为：{\"acco\":\"Test1\",\"name\":\"wukong\",\"id\":2,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}', '2019-11-12 15:51:56');
INSERT INTO `opera` VALUES ('224', null, '72', 'kanye', '新建项目：11111111', '2019-11-12 15:53:21');
INSERT INTO `opera` VALUES ('225', null, '73', 'kanye', '新建项目：44444', '2019-11-12 16:11:18');
INSERT INTO `opera` VALUES ('229', null, '75', 'kanye', '新建项目：67', '2019-11-12 16:31:54');
INSERT INTO `opera` VALUES ('238', null, '72', 'kanye', '修改任务任务状态为：进行中', '2019-11-12 17:32:59');
INSERT INTO `opera` VALUES ('239', null, '72', 'kanye', '修改任务任务进度为：100%', '2019-11-12 17:33:02');
INSERT INTO `opera` VALUES ('241', '19', null, 'kanye', '32131321', '2019-11-12 17:37:27');
INSERT INTO `opera` VALUES ('250', '52', null, 'kanye', '修改项目抄送人为：[{\"acco\":\"yunwei001\",\"name\":\"Test2\",\"id\":1,\"dept\":\"智能网联\",\"position\":\"产品经理\"},{\"acco\":\"Test1\",\"name\":\"wukong\",\"id\":2,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"},{\"acco\":\"Test4\",\"name\":\"kanye\",\"id\":5,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-13 15:23:39');
INSERT INTO `opera` VALUES ('251', '52', null, 'kanye', '修改项目项目描述为：测试项目\n3231312', '2019-11-13 15:24:24');
INSERT INTO `opera` VALUES ('252', '52', null, 'kanye', '321321312', '2019-11-13 15:24:27');
INSERT INTO `opera` VALUES ('253', '52', null, 'kanye', '修改项目项目到期时间为：2019-09-30 00:00:00', '2019-11-13 15:24:36');
INSERT INTO `opera` VALUES ('254', '52', null, 'kanye', '修改项目项目到期时间为：2019-12-07 00:00:00', '2019-11-13 15:24:45');
INSERT INTO `opera` VALUES ('255', null, '75', 'kanye', '修改任务', '2019-11-13 15:33:04');
INSERT INTO `opera` VALUES ('256', null, '73', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test2\",\"name\":\"uzi\",\"id\":3,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"},{\"acco\":\"Test4\",\"name\":\"kanye\",\"id\":5,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"},{\"acco\":\"Test3\",\"name\":\"offset\",\"id\":4,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-13 16:22:06');
INSERT INTO `opera` VALUES ('257', null, '73', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test3\",\"name\":\"offset\",\"id\":4,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"},{\"acco\":\"Test4\",\"name\":\"kanye\",\"id\":5,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-13 16:27:08');
INSERT INTO `opera` VALUES ('258', null, '73', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test3\",\"name\":\"offset\",\"id\":4,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-13 16:28:28');
INSERT INTO `opera` VALUES ('259', null, '73', 'kanye', '修改任务抄送人为：[]', '2019-11-13 16:39:58');
INSERT INTO `opera` VALUES ('260', null, '73', 'kanye', '修改任务', '2019-11-13 16:42:38');
INSERT INTO `opera` VALUES ('261', null, '73', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test1\",\"name\":\"wukong\",\"id\":2,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-13 17:06:25');
INSERT INTO `opera` VALUES ('262', null, '73', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test1\",\"name\":\"wukong\",\"id\":2,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"},{\"acco\":\"Test2\",\"name\":\"uzi\",\"id\":3,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-13 17:09:16');
INSERT INTO `opera` VALUES ('263', null, '73', 'kanye', '修改任务抄送人为：[{\"acco\":\"Test1\",\"name\":\"wukong\",\"id\":2,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}]', '2019-11-13 17:10:26');
INSERT INTO `opera` VALUES ('264', null, '73', 'kanye', '修改任务抄送人为：空', '2019-11-13 17:33:24');
INSERT INTO `opera` VALUES ('265', null, '73', 'kanye', '修改任务抄送人为：offset', '2019-11-13 17:58:49');
INSERT INTO `opera` VALUES ('266', null, '73', 'kanye', '修改任务抄送人为：offsetkanyeuzi', '2019-11-13 17:58:55');
INSERT INTO `opera` VALUES ('267', null, '73', 'kanye', '修改任务抄送人为：offsetkanye', '2019-11-13 17:58:59');
INSERT INTO `opera` VALUES ('268', null, '73', 'kanye', '修改任务抄送人为：offset', '2019-11-13 17:59:01');
INSERT INTO `opera` VALUES ('269', null, '73', 'kanye', '修改任务抄送人为：', '2019-11-13 17:59:03');
INSERT INTO `opera` VALUES ('270', null, '73', 'kanye', '修改任务负责人为：uzi', '2019-11-13 18:00:01');
INSERT INTO `opera` VALUES ('271', null, '73', 'kanye', '修改任务', '2019-11-13 18:00:10');
INSERT INTO `opera` VALUES ('272', null, '73', 'kanye', '修改任务负责人为：[{\"acco\":\"Test3\",\"name\":\"offset\",\"id\":4,\"dept\":\"智能网联\",\"position\":\"软件开发工程师\"}],offset', '2019-11-13 18:11:25');
INSERT INTO `opera` VALUES ('273', null, '73', 'kanye', '修改任务负责人为：,uzi', '2019-11-13 18:13:05');
INSERT INTO `opera` VALUES ('274', null, '73', 'kanye', '修改任务负责人为：[wukong]', '2019-11-13 18:20:59');
INSERT INTO `opera` VALUES ('275', null, '73', 'kanye', '修改任务负责人为：NULL', '2019-11-13 18:21:03');
INSERT INTO `opera` VALUES ('276', null, '73', 'kanye', '修改任务抄送人为：[offset, kanye, uzi, wukong]', '2019-11-13 18:21:09');
INSERT INTO `opera` VALUES ('277', null, '73', 'kanye', '修改任务抄送人为：[offset, kanye, uzi]', '2019-11-13 18:21:12');
INSERT INTO `opera` VALUES ('278', null, '73', 'kanye', '修改任务抄送人为：[offset, kanye]', '2019-11-13 18:21:14');
INSERT INTO `opera` VALUES ('279', null, '73', 'kanye', '修改任务抄送人为：[offset]', '2019-11-13 18:21:15');
INSERT INTO `opera` VALUES ('280', null, '73', 'kanye', '修改任务抄送人为：[offset, wukong]', '2019-11-13 18:21:47');
INSERT INTO `opera` VALUES ('281', null, '73', 'kanye', '修改任务抄送人为：[offset, wukong, dre, uzi]', '2019-11-13 18:21:50');
INSERT INTO `opera` VALUES ('282', null, '73', 'kanye', '修改任务', '2019-11-13 18:21:52');
INSERT INTO `opera` VALUES ('283', null, '73', 'kanye', '修改任务任务开始时间为：2019-10-28 00:00:00', '2019-11-13 18:22:11');
INSERT INTO `opera` VALUES ('284', null, '73', 'kanye', '修改任务任务到期时间为：2019-11-15 00:00:00', '2019-11-13 18:22:13');
INSERT INTO `opera` VALUES ('285', null, '73', 'kanye', '修改任务负责人为：[wukong]', '2019-11-13 18:22:15');
INSERT INTO `opera` VALUES ('286', null, '73', 'kanye', '修改任务任务内容为：44444444\n\nhkj', '2019-11-13 18:22:58');
INSERT INTO `opera` VALUES ('287', null, '73', 'kanye', '修改任务任务状态为：进行中', '2019-11-13 18:23:01');
INSERT INTO `opera` VALUES ('288', null, '73', 'kanye', '修改任务任务进度为：100%', '2019-11-13 18:23:05');
INSERT INTO `opera` VALUES ('289', null, '73', 'kanye', '修改任务任务状态为：进行中', '2019-11-13 18:23:36');
INSERT INTO `opera` VALUES ('290', null, '73', 'kanye', '修改任务任务进度为：100%', '2019-11-13 18:23:39');
INSERT INTO `opera` VALUES ('291', null, '73', 'kanye', '修改任务任务内容为：444444443213123\nfdsfsad', '2019-11-13 18:23:47');
INSERT INTO `opera` VALUES ('294', null, '73', 'kanye', '修改任务所属项目为：fish_boom', '2019-11-14 15:10:03');
INSERT INTO `opera` VALUES ('295', null, '73', 'kanye', '修改任务所属项目为：Postman', '2019-11-14 15:10:08');
INSERT INTO `opera` VALUES ('296', null, '73', 'kanye', '修改任务所属项目为：fish_bone', '2019-11-14 15:10:15');
INSERT INTO `opera` VALUES ('297', null, '73', 'kanye', '修改任务抄送人为：[wukong, uzi, offset, dre, kanye, Test2]', '2019-11-14 15:10:27');
INSERT INTO `opera` VALUES ('298', null, '73', 'kanye', '修改任务抄送人为：[wukong, kanye, Test2]', '2019-11-14 15:10:38');
INSERT INTO `opera` VALUES ('299', null, '73', 'kanye', '修改任务抄送人为：[wukong, kanye]', '2019-11-14 15:10:41');
INSERT INTO `opera` VALUES ('300', null, '73', 'kanye', '修改任务负责人为：NULL', '2019-11-14 15:10:45');
INSERT INTO `opera` VALUES ('301', null, '73', 'kanye', '修改任务负责人为：[kanye]', '2019-11-14 15:10:48');
INSERT INTO `opera` VALUES ('302', null, '73', 'kanye', '修改任务任务开始时间为：2019-10-29 00:00:00', '2019-11-14 15:10:52');
INSERT INTO `opera` VALUES ('303', null, '73', 'kanye', '修改任务任务到期时间为：2019-11-20 00:00:00', '2019-11-14 15:10:55');
INSERT INTO `opera` VALUES ('314', null, '73', 'kanye', '修改任务优先级为：重要', '2019-11-14 15:15:48');
INSERT INTO `opera` VALUES ('316', null, '62', 'kanye', '修改任务任务到期时间为：2019-11-22 00:00:00', '2019-11-14 15:29:58');
INSERT INTO `opera` VALUES ('317', null, '62', 'kanye', '修改任务任务到期时间为：2019-11-25 00:00:00', '2019-11-14 15:30:01');
INSERT INTO `opera` VALUES ('318', null, '62', 'kanye', '修改任务任务开始时间为：2019-09-01 00:00:00', '2019-11-14 15:30:02');
INSERT INTO `opera` VALUES ('319', null, '62', 'kanye', '修改任务任务到期时间为：2019-12-07 00:00:00', '2019-11-14 15:30:04');
INSERT INTO `opera` VALUES ('321', null, '73', 'kanye', '修改任务任务到期时间为：2019-11-21 00:00:00', '2019-11-14 16:02:29');
INSERT INTO `opera` VALUES ('322', null, '80', 'kanye', '新建项目：wode', '2019-11-14 16:04:44');
INSERT INTO `opera` VALUES ('323', null, '81', 'kanye', '新建项目：wode2', '2019-11-14 16:05:26');
INSERT INTO `opera` VALUES ('324', null, '81', 'kanye', '修改任务优先级为：紧急', '2019-11-14 16:05:33');
INSERT INTO `opera` VALUES ('325', null, '80', 'kanye', '修改任务优先级为：重要紧急', '2019-11-14 16:05:55');
INSERT INTO `opera` VALUES ('326', null, '75', 'kanye', '修改任务优先级为：重要紧急', '2019-11-14 16:06:24');
INSERT INTO `opera` VALUES ('327', null, '75', 'kanye', '修改任务任务状态为：进行中', '2019-11-14 16:06:27');
INSERT INTO `opera` VALUES ('328', null, '80', 'kanye', '修改任务优先级为：普通', '2019-11-14 16:06:43');
INSERT INTO `opera` VALUES ('329', null, '80', 'kanye', '修改任务优先级为：重要紧急', '2019-11-14 16:13:41');
INSERT INTO `opera` VALUES ('330', null, '80', 'kanye', '修改任务任务状态为：进行中', '2019-11-14 16:15:02');
INSERT INTO `opera` VALUES ('331', null, '80', 'kanye', '修改任务任务进度为：10%', '2019-11-14 16:15:06');
INSERT INTO `opera` VALUES ('332', null, '80', 'kanye', '修改任务任务进度为：40%', '2019-11-14 16:15:14');
INSERT INTO `opera` VALUES ('333', null, '80', 'kanye', '修改任务任务进度为：100%', '2019-11-14 16:15:22');
INSERT INTO `opera` VALUES ('334', null, '81', 'dre', '修改任务任务状态为：进行中', '2019-11-14 16:39:03');
INSERT INTO `opera` VALUES ('335', null, '81', 'dre', '修改任务任务进度为：10%', '2019-11-14 16:39:07');
INSERT INTO `opera` VALUES ('336', null, '81', 'dre', '修改任务任务进度为：20%', '2019-11-14 16:39:16');
INSERT INTO `opera` VALUES ('337', null, '82', 'dre', '新建项目：性能测试', '2019-11-14 17:54:23');
INSERT INTO `opera` VALUES ('338', null, '83', 'kanye', '新建项目：综合测试', '2019-11-14 17:55:39');
INSERT INTO `opera` VALUES ('339', null, '84', 'kanye', '新建项目：负责人', '2019-11-14 18:11:50');
INSERT INTO `opera` VALUES ('340', null, '83', 'kanye', '修改任务任务内容为：dre造数据', '2019-11-14 18:17:52');
INSERT INTO `opera` VALUES ('341', null, '81', 'kanye', '修改任务任务进度为：100%', '2019-11-15 09:00:18');
INSERT INTO `opera` VALUES ('342', null, '62', 'kanye', '修改任务任务进度为：100%', '2019-11-15 09:00:26');
INSERT INTO `opera` VALUES ('343', null, '75', 'kanye', '修改任务任务进度为：100%', '2019-11-15 09:01:11');
INSERT INTO `opera` VALUES ('344', null, '63', 'kanye', '修改任务负责人为：[offset]', '2019-11-15 09:01:20');
INSERT INTO `opera` VALUES ('345', null, '63', 'kanye', '修改任务任务进度为：100%', '2019-11-15 09:01:24');
INSERT INTO `opera` VALUES ('346', null, '85', 'kanye', '新建项目：测试样例', '2019-11-15 09:20:47');
INSERT INTO `opera` VALUES ('347', null, '75', 'kanye', '修改任务任务到期时间为：2019-11-05 00:00:00', '2019-11-15 09:28:42');
INSERT INTO `opera` VALUES ('348', null, '85', 'kanye', '修改任务任务开始时间为：2019-11-30 00:00:00', '2019-11-15 09:40:47');
INSERT INTO `opera` VALUES ('349', null, '85', 'kanye', '修改任务任务开始时间为：2019-10-29 00:00:00', '2019-11-15 09:45:21');
INSERT INTO `opera` VALUES ('350', null, '85', 'kanye', '修改任务任务开始时间为：2019-11-09 00:00:00', '2019-11-15 09:45:26');
INSERT INTO `opera` VALUES ('351', null, '85', 'kanye', '修改任务任务开始时间为：2019-11-05 00:00:00', '2019-11-15 09:47:49');
INSERT INTO `opera` VALUES ('352', null, '85', 'kanye', '修改任务任务开始时间为：2019-11-15 00:00:00', '2019-11-15 09:47:54');
INSERT INTO `opera` VALUES ('353', null, '85', 'kanye', '修改任务任务开始时间为：2019-11-16 00:00:00', '2019-11-15 09:47:55');
INSERT INTO `opera` VALUES ('355', '53', null, 'kanye', '修改项目项目到期时间为：2019-10-08 00:00:00', '2019-11-16 14:06:34');
INSERT INTO `opera` VALUES ('356', '53', null, 'kanye', '修改项目项目到期时间为：2019-11-28 00:00:00', '2019-11-16 14:07:03');
INSERT INTO `opera` VALUES ('357', '53', null, 'kanye', '121', '2019-11-16 14:07:06');
INSERT INTO `opera` VALUES ('358', '53', null, 'kanye', '修改项目项目成员为：[uzi]', '2019-11-16 14:07:13');
INSERT INTO `opera` VALUES ('359', '53', null, 'kanye', '修改项目项目成员为：[uzi, wukong, kanye]', '2019-11-16 14:07:24');
INSERT INTO `opera` VALUES ('360', '53', null, 'kanye', '修改项目抄送人为：[offset, dre, Test2]', '2019-11-16 14:07:30');
INSERT INTO `opera` VALUES ('361', '53', null, 'kanye', '修改项目项目描述为：tesst33333dsadsads\n\ndsadsad', '2019-11-16 14:07:41');
INSERT INTO `opera` VALUES ('362', null, '86', 'kanye', '新建任务：test task', '2019-11-16 14:10:01');
INSERT INTO `opera` VALUES ('363', null, '86', 'kanye', '修改任务负责人为：[wukong]', '2019-11-16 14:10:59');
INSERT INTO `opera` VALUES ('364', null, '86', 'kanye', '修改任务抄送人为：[wukong, offset, kanye, uzi]', '2019-11-16 14:11:04');
INSERT INTO `opera` VALUES ('365', null, '86', 'kanye', '修改任务任务状态为：进行中', '2019-11-16 14:11:15');
INSERT INTO `opera` VALUES ('366', null, '86', 'kanye', '修改任务任务进度为：100%', '2019-11-16 14:11:27');
INSERT INTO `opera` VALUES ('367', null, '86', 'kanye', '修改任务任务内容为：task1111132131\n32131', '2019-11-16 14:11:35');
INSERT INTO `opera` VALUES ('368', null, '87', 'kanye', '新建任务：111', '2019-11-16 14:13:53');
INSERT INTO `opera` VALUES ('369', null, '88', 'kanye', '新建任务：3424324', '2019-11-16 14:14:24');
INSERT INTO `opera` VALUES ('370', null, '89', 'kanye', '新建任务：434324', '2019-11-16 14:14:35');
INSERT INTO `opera` VALUES ('371', null, '89', 'kanye', '修改任务所属项目为：test33333', '2019-11-16 14:14:41');
INSERT INTO `opera` VALUES ('372', null, '90', 'kanye', '新建任务：7687687', '2019-11-16 14:14:54');

-- ----------------------------
-- Table structure for proj
-- ----------------------------
DROP TABLE IF EXISTS `proj`;
CREATE TABLE `proj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  `creator` char(50) DEFAULT NULL,
  `pm_uid` int(11) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `priority` tinyint(4) DEFAULT NULL,
  `partner_gid` int(11) DEFAULT NULL,
  `c_gid` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `percent` char(50) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `last_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `code` varchar(255) DEFAULT NULL,
  `is_control` tinyint(4) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  PRIMARY KEY (`id`,`c_gid`),
  KEY `fk_pm_uid` (`pm_uid`),
  KEY `fk_partner_gid` (`partner_gid`),
  KEY `fk_c_gid` (`c_gid`),
  CONSTRAINT `fk_c_gid` FOREIGN KEY (`c_gid`) REFERENCES `grou` (`id`),
  CONSTRAINT `fk_partner_gid` FOREIGN KEY (`partner_gid`) REFERENCES `grou` (`id`),
  CONSTRAINT `fk_pm_uid` FOREIGN KEY (`pm_uid`) REFERENCES `grou` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proj
-- ----------------------------
INSERT INTO `proj` VALUES ('19', 'fish_bone', 'wukong', '2', '2019-10-13 17:04:50', '2019-11-09 00:00:00', '0', '188', '190', 'postman测试\ndsadsgfdsfsd', '38%', '0', '2019-10-16 11:52:12', '123', '1', '2019-09-02 00:00:00');
INSERT INTO `proj` VALUES ('20', 'fish_boom', 'wukong', '1', '2019-10-13 17:04:50', '2019-10-16 17:04:50', '3', '54', '187', 'postman测试', '100%', '0', '2019-10-16 11:52:20', '123', '1', '2019-10-11 10:29:25');
INSERT INTO `proj` VALUES ('21', 'salt_fish', 'wukong', '1', '2019-10-13 17:04:50', '2019-10-17 17:04:50', '2', '56', '55', 'postman测试', '0', '1', '2019-10-16 11:52:27', '123', '1', '2019-09-26 10:29:37');
INSERT INTO `proj` VALUES ('22', 'Postman', 'wukong', '1', '2019-10-14 17:04:50', '2019-10-17 17:04:50', '2', '58', '57', 'postman测试', '0', '1', '2019-10-16 11:52:31', '123', '1', '2019-10-22 10:31:02');
INSERT INTO `proj` VALUES ('23', '1', 'kanye', '2', null, '2019-11-16 00:00:00', '3', '148', '147', '1', '0%', '0', '2019-11-11 16:48:30', null, null, '2019-10-27 00:00:00');
INSERT INTO `proj` VALUES ('24', '123', 'kanye', '3', null, '2019-11-13 00:00:00', '3', '150', '149', '123', '0%', '0', '2019-11-11 16:50:41', null, null, '2019-10-27 00:00:00');
INSERT INTO `proj` VALUES ('26', '1', 'kanye', '3', null, '2019-11-11 17:48:10', '1', '154', '153', '1', '0%', '0', '2019-11-11 17:48:55', null, null, '2019-11-11 17:48:10');
INSERT INTO `proj` VALUES ('35', '4444', 'kanye', '3', null, '2019-11-29 00:00:00', '3', '174', '173', '4444', '0%', '0', '2019-11-12 11:14:17', null, null, '2019-11-03 00:00:00');
INSERT INTO `proj` VALUES ('36', '111', 'kanye', '2', null, '2019-11-22 00:00:00', '3', '176', '175', '111', '0%', '0', '2019-11-12 11:15:06', null, null, '2019-10-28 00:00:00');
INSERT INTO `proj` VALUES ('37', '55555555555555555555', 'kanye', '2', null, '2019-11-15 00:00:00', '3', '186', '185', '555555555555555', '100%', '0', '2019-11-12 15:36:43', null, null, '2019-11-03 00:00:00');
INSERT INTO `proj` VALUES ('38', '7777777777777777777777777788', 'kanye', '3', null, '2019-11-12 16:12:38', '1', '200', '199', '77', '0%', '0', '2019-11-12 16:13:28', null, null, '2019-11-12 16:12:38');
INSERT INTO `proj` VALUES ('39', '1141414141412', 'kanye', '6', null, '2019-11-12 16:14:54', '1', '202', '201', '124124214', '0%', '0', '2019-11-12 16:15:53', null, null, '2019-11-12 16:14:54');
INSERT INTO `proj` VALUES ('47', '454545', 'kanye', '4', null, '2019-11-13 10:30:01', '1', '225', '224', '5454', '0%', '0', '2019-11-13 10:30:53', null, null, '2019-11-13 10:30:01');
INSERT INTO `proj` VALUES ('48', '67676', 'kanye', '3', null, '2019-11-13 10:31:30', '1', '227', '226', '676767', '0%', '0', '2019-11-13 10:32:20', null, null, '2019-11-13 10:31:30');
INSERT INTO `proj` VALUES ('49', '787878', 'kanye', '3', null, '2019-11-13 10:32:41', '1', '229', '228', '78787', '0%', '0', '2019-11-13 10:33:25', null, null, '2019-11-13 10:32:41');
INSERT INTO `proj` VALUES ('51', '4545454', 'kanye', '8', null, '2019-11-13 10:37:04', '1', '233', '232', '4545454', '0%', '0', '2019-11-13 10:37:49', null, null, '2019-11-13 10:37:04');
INSERT INTO `proj` VALUES ('52', 'Test123', 'kanye', '3', null, '2019-12-07 00:00:00', '3', '237', '238', '测试项目\n3231312', '0%', '0', '2019-11-13 15:23:20', null, null, '2019-09-30 00:00:00');
INSERT INTO `proj` VALUES ('53', 'test33333', 'kanye', '3', null, '2019-11-28 00:00:00', '3', '289', '290', 'tesst33333dsadsads\n\ndsadsad', '20%', '0', '2019-11-16 14:07:41', null, null, '2019-10-08 00:00:00');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `f_gid` int(11) DEFAULT NULL,
  `c_gid` int(11) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `priority` tinyint(4) DEFAULT NULL,
  `finish_date` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  `version` char(50) DEFAULT NULL,
  `itera` char(50) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `modal` char(50) DEFAULT NULL,
  `last_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creator` char(50) DEFAULT NULL,
  `is_milestone` tinyint(4) DEFAULT NULL,
  `percent` tinyint(4) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_f_grou` (`f_gid`),
  KEY `fk_c_grou` (`c_gid`),
  KEY `fk_t_proj` (`pid`),
  CONSTRAINT `fk_c_grou` FOREIGN KEY (`c_gid`) REFERENCES `grou` (`id`),
  CONSTRAINT `fk_f_grou` FOREIGN KEY (`f_gid`) REFERENCES `grou` (`id`),
  CONSTRAINT `fk_t_proj` FOREIGN KEY (`pid`) REFERENCES `proj` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('9', '任务Test', 'T20191027', '0', '这是一个任务啊', '130', '80', '2019-10-17 16:20:32', '2019-10-25 20:20:32', '0', null, '2', '', '', '19', '', '2019-10-21 11:18:33', 'offset', '1', null, '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('27', '任务Test', 'T20191027', '0', '这是一个任务啊', '101', '102', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '2', '', '', '20', '', '2019-10-21 11:18:35', 'offset', '1', '10', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('61', '任务Test', 'T20191027', '0', '这是一个任务啊', '81', '82', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '2', '', '', '19', '', '2019-10-21 11:18:35', 'kanye', '1', '1', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('62', '任务Test', 'T20191027', '0', '这是一个任务啊', '172', '184', '2019-10-17 16:20:32', '2019-12-07 00:00:00', '2', null, '2', '', '', '19', '', '2019-11-15 09:00:26', 'kanye', '1', '10', '2019-09-01 00:00:00');
INSERT INTO `task` VALUES ('63', '任务Test', 'T20191027', '0', '这是一个任务啊', '283', '82', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '2', '', '', '19', '', '2019-11-15 09:01:24', 'kanye', '1', '10', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('64', '任务Test', 'T20191027', '0', '这是一个任务啊', '81', '82', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '1', '', '', '19', '', '2019-10-21 11:18:35', 'kanye', '1', '1', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('65', '任务Test', 'T20191027', '0', '这是一个任务啊', '81', '82', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '1', '', '', '19', '', '2019-10-21 11:18:35', 'kanye', '1', '1', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('66', '任务Test', 'T20191027', '0', '这是一个任务啊', '81', '82', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '1', '', '', '19', '', '2019-10-21 11:18:35', 'kanye', '1', '1', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('67', '任务Test', 'T20191027', '0', '这是一个任务啊', '81', '82', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '1', '', '', '19', '', '2019-10-21 11:18:35', 'kanye', '1', '1', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('68', '任务Test', 'T20191027', '0', '这是一个任务啊', '81', '82', '2019-10-17 16:20:32', '2019-11-02 12:02:20', '0', null, '1', '', '', '19', '', '2019-10-21 11:18:35', 'kanye', '1', '1', '2019-09-26 16:56:41');
INSERT INTO `task` VALUES ('72', '11111111', null, '1', '111111', '191', '192', null, '2019-11-22 00:00:00', '3', null, '2', null, null, '37', null, '2019-11-12 15:53:21', 'kanye', null, '10', '2019-11-04 00:00:00');
INSERT INTO `task` VALUES ('73', '44444', null, '0', '444444443213123\nfdsfsad', '271', '269', null, '2019-11-21 00:00:00', '1', null, '2', null, null, '19', null, '2019-11-14 16:02:29', 'kanye', null, '10', '2019-10-29 00:00:00');
INSERT INTO `task` VALUES ('75', '67', null, '0', '76', '207', null, null, '2019-11-05 00:00:00', '3', null, '2', null, null, '20', null, '2019-11-15 09:28:42', 'kanye', null, '10', '2019-11-12 16:30:58');
INSERT INTO `task` VALUES ('80', 'wode', null, '0', 'wo', '274', '273', null, '2019-11-15 00:00:00', '3', null, '2', null, null, '20', null, '2019-11-14 16:15:22', 'kanye', null, '10', '2019-11-14 16:03:17');
INSERT INTO `task` VALUES ('81', 'wode2', null, '0', 'wode2', '276', '275', null, '2019-11-16 00:00:00', '2', null, '2', null, null, '20', null, '2019-11-15 09:00:18', 'kanye', null, '10', '2019-11-14 16:04:17');
INSERT INTO `task` VALUES ('82', '性能测试', null, '0', '造数据', '278', '277', null, '2019-11-15 00:00:00', '2', null, '0', null, null, '19', null, '2019-11-14 17:54:23', 'dre', null, null, '2019-11-14 17:53:19');
INSERT INTO `task` VALUES ('83', '综合测试', null, '0', 'dre造数据', '280', '279', null, '2019-11-15 00:00:00', '2', null, '0', null, null, '19', null, '2019-11-14 17:55:39', 'kanye', null, null, '2019-11-14 17:54:15');
INSERT INTO `task` VALUES ('84', '负责人', null, '0', '呃呃呃', '282', '281', null, '2019-11-15 00:00:00', '2', null, '0', null, null, '19', null, '2019-11-14 18:11:50', 'kanye', null, null, '2019-11-14 18:10:28');
INSERT INTO `task` VALUES ('85', '测试样例', null, '1', 'bug', '285', '284', null, '2019-11-18 00:00:00', '1', null, '0', null, null, '22', null, '2019-11-15 09:47:55', 'kanye', null, null, '2019-11-16 00:00:00');
INSERT INTO `task` VALUES ('86', 'test task', null, '0', 'task1111132131\n32131', '293', '294', null, '2019-11-29 00:00:00', '0', null, '2', null, null, '53', null, '2019-11-16 14:11:35', 'kanye', null, '10', '2019-11-06 00:00:00');
INSERT INTO `task` VALUES ('87', '111', null, '0', '111', '296', '295', null, '2019-11-16 14:12:25', '2', null, '0', null, null, '53', null, '2019-11-16 14:13:53', 'kanye', null, null, '2019-11-11 00:00:00');
INSERT INTO `task` VALUES ('88', '3424324', null, '0', '432432', '298', '297', null, '2019-11-16 00:00:00', '2', null, '0', null, null, '53', null, '2019-11-16 14:14:24', 'kanye', null, null, '2019-11-13 00:00:00');
INSERT INTO `task` VALUES ('89', '434324', null, '0', '343243', '299', null, null, '2019-11-16 14:13:46', '0', null, '0', null, null, '53', null, '2019-11-16 14:14:41', 'kanye', null, null, '2019-11-16 14:13:46');
INSERT INTO `task` VALUES ('90', '7687687', null, '0', '68768768', '300', null, null, '2019-11-16 14:14:04', '0', null, '0', null, null, '53', null, '2019-11-16 14:14:54', 'kanye', null, null, '2019-11-16 14:14:04');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acco` char(50) NOT NULL,
  `name` char(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `dept` char(25) DEFAULT NULL,
  `position` char(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `acco` (`acco`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yunwei001', 'Test2', '2efb37f2e95a13a831e30e6405be6708', 'gZ3mhvrkeZGe8gMskafqEA==', '智能网联', '产品经理');
INSERT INTO `user` VALUES ('2', 'Test1', 'wukong', 'dc971c8657d4ef74e3d996f7bbf6782f', '5KnwN+7sAPv4lt6eOicpLg==', '智能网联', '软件开发工程师');
INSERT INTO `user` VALUES ('3', 'Test2', 'uzi', '39cb7156231e3c3e8de640b6c19abdd7', 'REhYYo9LsdJM6sn34JfVig==', '智能网联', '软件开发工程师');
INSERT INTO `user` VALUES ('4', 'Test3', 'offset', 'd22958c6625b9548288697caafd5a7a5', 'cxhS34WKW3c7ib0UXGmMdw==', '智能网联', '软件开发工程师');
INSERT INTO `user` VALUES ('5', 'Test4', 'kanye', 'e6f0da0a7bd118c0c6a623d9b5ea336a', 'gjHOLvRR9d9RiXo7ov8keg==', '智能网联', '软件开发工程师');
INSERT INTO `user` VALUES ('6', 'Test5', 'dre', 'd77e98acbef82e3d5d19fd4d467dab98', 'LN7umgp2TUYu1ocpvn2AJw==', '智能网联', '软件开发工程师');
INSERT INTO `user` VALUES ('7', 'Test6', 'suge', 'f59556c83dbbed5878d3158489205ab6', '2UK/JX8o1J33b9CuEz0DPQ==', '智能网联', '软件开发工程师');
INSERT INTO `user` VALUES ('8', 'Test7', 'Tim', '7bcc2bb5ffbd1c915d6684f58b16cc5d', 'zrGoT5vnFSkA4OUStvbjwA==', '智能网联', '软件开发工程师');
INSERT INTO `user` VALUES ('9', 'lzy123', '李某', '7402ce82ee55b95399105cb966508c35', 'HLKhwPRJqjoQiYnznCU/Hg==', '智能网联', '技术总监');
INSERT INTO `user` VALUES ('10', 'xiewencai', 'xiewencai', 'a97a2f91df6d3cfb903c3c08de313bc9', 'mAB2YF8w8u3xKRPdMFe2xw==', '智能网联', '总裁');

-- ----------------------------
-- Table structure for user_grou
-- ----------------------------
DROP TABLE IF EXISTS `user_grou`;
CREATE TABLE `user_grou` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_group_user` (`uid`),
  KEY `fk_user_group` (`gid`),
  CONSTRAINT `fk_group_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_user_group` FOREIGN KEY (`gid`) REFERENCES `grou` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=411 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_grou
-- ----------------------------
INSERT INTO `user_grou` VALUES ('31', '3', '53');
INSERT INTO `user_grou` VALUES ('32', '2', '54');
INSERT INTO `user_grou` VALUES ('33', '3', '55');
INSERT INTO `user_grou` VALUES ('34', '2', '56');
INSERT INTO `user_grou` VALUES ('35', '3', '57');
INSERT INTO `user_grou` VALUES ('36', '2', '58');
INSERT INTO `user_grou` VALUES ('82', '3', '77');
INSERT INTO `user_grou` VALUES ('83', '4', '77');
INSERT INTO `user_grou` VALUES ('84', '5', '77');
INSERT INTO `user_grou` VALUES ('87', '3', '79');
INSERT INTO `user_grou` VALUES ('88', '4', '79');
INSERT INTO `user_grou` VALUES ('89', '5', '79');
INSERT INTO `user_grou` VALUES ('90', '1', '80');
INSERT INTO `user_grou` VALUES ('91', '2', '80');
INSERT INTO `user_grou` VALUES ('137', '6', '99');
INSERT INTO `user_grou` VALUES ('138', '6', '100');
INSERT INTO `user_grou` VALUES ('139', '6', '101');
INSERT INTO `user_grou` VALUES ('140', '6', '102');
INSERT INTO `user_grou` VALUES ('141', '3', '103');
INSERT INTO `user_grou` VALUES ('142', '1', '103');
INSERT INTO `user_grou` VALUES ('143', '1', '104');
INSERT INTO `user_grou` VALUES ('144', '4', '104');
INSERT INTO `user_grou` VALUES ('145', '2', '104');
INSERT INTO `user_grou` VALUES ('146', '3', '104');
INSERT INTO `user_grou` VALUES ('147', '5', '104');
INSERT INTO `user_grou` VALUES ('148', '4', '105');
INSERT INTO `user_grou` VALUES ('149', '4', '106');
INSERT INTO `user_grou` VALUES ('150', '2', '106');
INSERT INTO `user_grou` VALUES ('151', '1', '106');
INSERT INTO `user_grou` VALUES ('152', '5', '106');
INSERT INTO `user_grou` VALUES ('153', '4', '107');
INSERT INTO `user_grou` VALUES ('154', '2', '107');
INSERT INTO `user_grou` VALUES ('155', '1', '107');
INSERT INTO `user_grou` VALUES ('156', '3', '107');
INSERT INTO `user_grou` VALUES ('157', '5', '107');
INSERT INTO `user_grou` VALUES ('158', '2', '108');
INSERT INTO `user_grou` VALUES ('159', '3', '108');
INSERT INTO `user_grou` VALUES ('160', '5', '108');
INSERT INTO `user_grou` VALUES ('161', '1', '109');
INSERT INTO `user_grou` VALUES ('162', '2', '109');
INSERT INTO `user_grou` VALUES ('163', '3', '109');
INSERT INTO `user_grou` VALUES ('164', '4', '109');
INSERT INTO `user_grou` VALUES ('165', '5', '109');
INSERT INTO `user_grou` VALUES ('166', '3', '112');
INSERT INTO `user_grou` VALUES ('167', '1', '113');
INSERT INTO `user_grou` VALUES ('168', '2', '113');
INSERT INTO `user_grou` VALUES ('169', '3', '113');
INSERT INTO `user_grou` VALUES ('170', '4', '113');
INSERT INTO `user_grou` VALUES ('171', '2', '114');
INSERT INTO `user_grou` VALUES ('172', '3', '114');
INSERT INTO `user_grou` VALUES ('173', '4', '114');
INSERT INTO `user_grou` VALUES ('174', '3', '115');
INSERT INTO `user_grou` VALUES ('175', '4', '115');
INSERT INTO `user_grou` VALUES ('176', '4', '116');
INSERT INTO `user_grou` VALUES ('177', '4', '117');
INSERT INTO `user_grou` VALUES ('178', '2', '117');
INSERT INTO `user_grou` VALUES ('179', '1', '117');
INSERT INTO `user_grou` VALUES ('180', '3', '117');
INSERT INTO `user_grou` VALUES ('181', '5', '117');
INSERT INTO `user_grou` VALUES ('182', '1', '118');
INSERT INTO `user_grou` VALUES ('183', '2', '118');
INSERT INTO `user_grou` VALUES ('184', '3', '118');
INSERT INTO `user_grou` VALUES ('185', '4', '118');
INSERT INTO `user_grou` VALUES ('186', '1', '119');
INSERT INTO `user_grou` VALUES ('187', '2', '119');
INSERT INTO `user_grou` VALUES ('188', '4', '119');
INSERT INTO `user_grou` VALUES ('189', '1', '120');
INSERT INTO `user_grou` VALUES ('190', '4', '120');
INSERT INTO `user_grou` VALUES ('191', '4', '121');
INSERT INTO `user_grou` VALUES ('192', '3', '125');
INSERT INTO `user_grou` VALUES ('195', '2', '127');
INSERT INTO `user_grou` VALUES ('196', '5', '128');
INSERT INTO `user_grou` VALUES ('197', '8', '128');
INSERT INTO `user_grou` VALUES ('198', '3', '129');
INSERT INTO `user_grou` VALUES ('199', '4', '129');
INSERT INTO `user_grou` VALUES ('200', '3', '130');
INSERT INTO `user_grou` VALUES ('201', '8', '131');
INSERT INTO `user_grou` VALUES ('202', '8', '132');
INSERT INTO `user_grou` VALUES ('203', '2', '132');
INSERT INTO `user_grou` VALUES ('204', '4', '132');
INSERT INTO `user_grou` VALUES ('205', '6', '132');
INSERT INTO `user_grou` VALUES ('206', '6', '133');
INSERT INTO `user_grou` VALUES ('207', '8', '133');
INSERT INTO `user_grou` VALUES ('208', '6', '134');
INSERT INTO `user_grou` VALUES ('209', '2', '136');
INSERT INTO `user_grou` VALUES ('210', '4', '136');
INSERT INTO `user_grou` VALUES ('211', '6', '136');
INSERT INTO `user_grou` VALUES ('212', '2', '137');
INSERT INTO `user_grou` VALUES ('213', '4', '137');
INSERT INTO `user_grou` VALUES ('214', '2', '138');
INSERT INTO `user_grou` VALUES ('218', '5', '144');
INSERT INTO `user_grou` VALUES ('222', '3', '147');
INSERT INTO `user_grou` VALUES ('223', '4', '147');
INSERT INTO `user_grou` VALUES ('224', '1', '149');
INSERT INTO `user_grou` VALUES ('225', '2', '149');
INSERT INTO `user_grou` VALUES ('226', '3', '149');
INSERT INTO `user_grou` VALUES ('237', '2', '171');
INSERT INTO `user_grou` VALUES ('238', '4', '172');
INSERT INTO `user_grou` VALUES ('239', '2', '173');
INSERT INTO `user_grou` VALUES ('240', '3', '173');
INSERT INTO `user_grou` VALUES ('241', '2', '175');
INSERT INTO `user_grou` VALUES ('242', '4', '175');
INSERT INTO `user_grou` VALUES ('244', '5', '178');
INSERT INTO `user_grou` VALUES ('245', '8', '178');
INSERT INTO `user_grou` VALUES ('246', '2', '178');
INSERT INTO `user_grou` VALUES ('247', '1', '178');
INSERT INTO `user_grou` VALUES ('248', '3', '178');
INSERT INTO `user_grou` VALUES ('249', '4', '178');
INSERT INTO `user_grou` VALUES ('250', '1', '179');
INSERT INTO `user_grou` VALUES ('251', '3', '179');
INSERT INTO `user_grou` VALUES ('252', '4', '179');
INSERT INTO `user_grou` VALUES ('253', '5', '179');
INSERT INTO `user_grou` VALUES ('254', '8', '179');
INSERT INTO `user_grou` VALUES ('255', '1', '180');
INSERT INTO `user_grou` VALUES ('256', '3', '180');
INSERT INTO `user_grou` VALUES ('257', '5', '180');
INSERT INTO `user_grou` VALUES ('258', '8', '180');
INSERT INTO `user_grou` VALUES ('259', '1', '181');
INSERT INTO `user_grou` VALUES ('260', '3', '181');
INSERT INTO `user_grou` VALUES ('261', '8', '181');
INSERT INTO `user_grou` VALUES ('264', '3', '183');
INSERT INTO `user_grou` VALUES ('265', '3', '184');
INSERT INTO `user_grou` VALUES ('266', '4', '184');
INSERT INTO `user_grou` VALUES ('267', '2', '185');
INSERT INTO `user_grou` VALUES ('268', '3', '185');
INSERT INTO `user_grou` VALUES ('269', '6', '185');
INSERT INTO `user_grou` VALUES ('270', '3', '187');
INSERT INTO `user_grou` VALUES ('271', '2', '187');
INSERT INTO `user_grou` VALUES ('272', '3', '188');
INSERT INTO `user_grou` VALUES ('273', '1', '189');
INSERT INTO `user_grou` VALUES ('274', '3', '189');
INSERT INTO `user_grou` VALUES ('275', '1', '190');
INSERT INTO `user_grou` VALUES ('276', '3', '190');
INSERT INTO `user_grou` VALUES ('277', '2', '190');
INSERT INTO `user_grou` VALUES ('278', '5', '191');
INSERT INTO `user_grou` VALUES ('279', '2', '192');
INSERT INTO `user_grou` VALUES ('280', '3', '192');
INSERT INTO `user_grou` VALUES ('281', '6', '192');
INSERT INTO `user_grou` VALUES ('284', '2', '197');
INSERT INTO `user_grou` VALUES ('285', '3', '198');
INSERT INTO `user_grou` VALUES ('286', '5', '198');
INSERT INTO `user_grou` VALUES ('287', '6', '201');
INSERT INTO `user_grou` VALUES ('288', '5', '201');
INSERT INTO `user_grou` VALUES ('293', '5', '207');
INSERT INTO `user_grou` VALUES ('299', '2', '236');
INSERT INTO `user_grou` VALUES ('300', '1', '236');
INSERT INTO `user_grou` VALUES ('301', '1', '238');
INSERT INTO `user_grou` VALUES ('302', '2', '238');
INSERT INTO `user_grou` VALUES ('303', '5', '238');
INSERT INTO `user_grou` VALUES ('304', '3', '239');
INSERT INTO `user_grou` VALUES ('305', '5', '239');
INSERT INTO `user_grou` VALUES ('306', '4', '239');
INSERT INTO `user_grou` VALUES ('307', '4', '240');
INSERT INTO `user_grou` VALUES ('308', '5', '240');
INSERT INTO `user_grou` VALUES ('309', '4', '241');
INSERT INTO `user_grou` VALUES ('310', '2', '243');
INSERT INTO `user_grou` VALUES ('311', '2', '244');
INSERT INTO `user_grou` VALUES ('312', '3', '244');
INSERT INTO `user_grou` VALUES ('313', '2', '245');
INSERT INTO `user_grou` VALUES ('314', '2', '246');
INSERT INTO `user_grou` VALUES ('315', '3', '246');
INSERT INTO `user_grou` VALUES ('316', '2', '247');
INSERT INTO `user_grou` VALUES ('317', '2', '249');
INSERT INTO `user_grou` VALUES ('318', '4', '250');
INSERT INTO `user_grou` VALUES ('319', '4', '251');
INSERT INTO `user_grou` VALUES ('320', '5', '251');
INSERT INTO `user_grou` VALUES ('321', '3', '251');
INSERT INTO `user_grou` VALUES ('322', '4', '252');
INSERT INTO `user_grou` VALUES ('323', '5', '252');
INSERT INTO `user_grou` VALUES ('324', '4', '253');
INSERT INTO `user_grou` VALUES ('325', '3', '255');
INSERT INTO `user_grou` VALUES ('326', '4', '256');
INSERT INTO `user_grou` VALUES ('327', '3', '257');
INSERT INTO `user_grou` VALUES ('328', '2', '258');
INSERT INTO `user_grou` VALUES ('329', '4', '260');
INSERT INTO `user_grou` VALUES ('330', '5', '260');
INSERT INTO `user_grou` VALUES ('331', '3', '260');
INSERT INTO `user_grou` VALUES ('332', '2', '260');
INSERT INTO `user_grou` VALUES ('333', '4', '261');
INSERT INTO `user_grou` VALUES ('334', '5', '261');
INSERT INTO `user_grou` VALUES ('335', '3', '261');
INSERT INTO `user_grou` VALUES ('336', '4', '262');
INSERT INTO `user_grou` VALUES ('337', '5', '262');
INSERT INTO `user_grou` VALUES ('338', '4', '263');
INSERT INTO `user_grou` VALUES ('339', '4', '264');
INSERT INTO `user_grou` VALUES ('340', '2', '264');
INSERT INTO `user_grou` VALUES ('341', '4', '265');
INSERT INTO `user_grou` VALUES ('342', '2', '265');
INSERT INTO `user_grou` VALUES ('343', '6', '265');
INSERT INTO `user_grou` VALUES ('344', '3', '265');
INSERT INTO `user_grou` VALUES ('345', '2', '266');
INSERT INTO `user_grou` VALUES ('346', '2', '267');
INSERT INTO `user_grou` VALUES ('347', '3', '267');
INSERT INTO `user_grou` VALUES ('348', '4', '267');
INSERT INTO `user_grou` VALUES ('349', '6', '267');
INSERT INTO `user_grou` VALUES ('350', '5', '267');
INSERT INTO `user_grou` VALUES ('351', '1', '267');
INSERT INTO `user_grou` VALUES ('352', '2', '268');
INSERT INTO `user_grou` VALUES ('353', '5', '268');
INSERT INTO `user_grou` VALUES ('354', '1', '268');
INSERT INTO `user_grou` VALUES ('355', '2', '269');
INSERT INTO `user_grou` VALUES ('356', '5', '269');
INSERT INTO `user_grou` VALUES ('357', '5', '271');
INSERT INTO `user_grou` VALUES ('359', '2', '273');
INSERT INTO `user_grou` VALUES ('360', '8', '273');
INSERT INTO `user_grou` VALUES ('361', '5', '274');
INSERT INTO `user_grou` VALUES ('362', '5', '275');
INSERT INTO `user_grou` VALUES ('363', '7', '275');
INSERT INTO `user_grou` VALUES ('364', '6', '275');
INSERT INTO `user_grou` VALUES ('365', '5', '276');
INSERT INTO `user_grou` VALUES ('366', '3', '277');
INSERT INTO `user_grou` VALUES ('367', '4', '277');
INSERT INTO `user_grou` VALUES ('368', '5', '278');
INSERT INTO `user_grou` VALUES ('369', '7', '279');
INSERT INTO `user_grou` VALUES ('370', '8', '279');
INSERT INTO `user_grou` VALUES ('371', '6', '280');
INSERT INTO `user_grou` VALUES ('372', '5', '281');
INSERT INTO `user_grou` VALUES ('373', '4', '282');
INSERT INTO `user_grou` VALUES ('374', '4', '283');
INSERT INTO `user_grou` VALUES ('375', '10', '284');
INSERT INTO `user_grou` VALUES ('376', '9', '284');
INSERT INTO `user_grou` VALUES ('377', '8', '284');
INSERT INTO `user_grou` VALUES ('378', '7', '284');
INSERT INTO `user_grou` VALUES ('379', '2', '285');
INSERT INTO `user_grou` VALUES ('380', '3', '285');
INSERT INTO `user_grou` VALUES ('381', '5', '285');
INSERT INTO `user_grou` VALUES ('382', '4', '285');
INSERT INTO `user_grou` VALUES ('383', '6', '286');
INSERT INTO `user_grou` VALUES ('384', '2', '286');
INSERT INTO `user_grou` VALUES ('385', '4', '286');
INSERT INTO `user_grou` VALUES ('386', '3', '288');
INSERT INTO `user_grou` VALUES ('387', '3', '289');
INSERT INTO `user_grou` VALUES ('388', '2', '289');
INSERT INTO `user_grou` VALUES ('389', '5', '289');
INSERT INTO `user_grou` VALUES ('390', '4', '290');
INSERT INTO `user_grou` VALUES ('391', '6', '290');
INSERT INTO `user_grou` VALUES ('392', '1', '290');
INSERT INTO `user_grou` VALUES ('393', '2', '291');
INSERT INTO `user_grou` VALUES ('394', '5', '291');
INSERT INTO `user_grou` VALUES ('395', '4', '291');
INSERT INTO `user_grou` VALUES ('396', '5', '292');
INSERT INTO `user_grou` VALUES ('397', '2', '293');
INSERT INTO `user_grou` VALUES ('398', '2', '294');
INSERT INTO `user_grou` VALUES ('399', '4', '294');
INSERT INTO `user_grou` VALUES ('400', '5', '294');
INSERT INTO `user_grou` VALUES ('401', '3', '294');
INSERT INTO `user_grou` VALUES ('402', '2', '295');
INSERT INTO `user_grou` VALUES ('403', '4', '295');
INSERT INTO `user_grou` VALUES ('404', '5', '296');
INSERT INTO `user_grou` VALUES ('405', '2', '297');
INSERT INTO `user_grou` VALUES ('406', '4', '297');
INSERT INTO `user_grou` VALUES ('407', '6', '297');
INSERT INTO `user_grou` VALUES ('408', '5', '298');
INSERT INTO `user_grou` VALUES ('409', '5', '299');
INSERT INTO `user_grou` VALUES ('410', '5', '300');

-- ----------------------------
-- Table structure for vers
-- ----------------------------
DROP TABLE IF EXISTS `vers`;
CREATE TABLE `vers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` char(50) DEFAULT NULL,
  `demand_num` int(10) DEFAULT NULL,
  `defect_num` int(10) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_version_project` (`pid`),
  CONSTRAINT `fk_version_project` FOREIGN KEY (`pid`) REFERENCES `proj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vers
-- ----------------------------
DROP TRIGGER IF EXISTS `doc_up`;
DELIMITER ;;
CREATE TRIGGER `doc_up` BEFORE INSERT ON `doc` FOR EACH ROW if new.update_date is null then   
      set new.update_date = now();   
    end if
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `doc_update`;
DELIMITER ;;
CREATE TRIGGER `doc_update` BEFORE UPDATE ON `doc` FOR EACH ROW if new.update_date is null then   
      set new.update_date = now();   
    end if
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `default_datetime_proj1`;
DELIMITER ;;
CREATE TRIGGER `default_datetime_proj1` BEFORE INSERT ON `proj` FOR EACH ROW if new.last_update is null then   
      set new.last_update = now();   
    end if
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `default_datetime_proj2`;
DELIMITER ;;
CREATE TRIGGER `default_datetime_proj2` BEFORE UPDATE ON `proj` FOR EACH ROW if new.last_update is null then   
      set new.last_update = now();   
    end if
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `lastupdatedf`;
DELIMITER ;;
CREATE TRIGGER `lastupdatedf` BEFORE INSERT ON `task` FOR EACH ROW if new.last_update is null then   
      set new.last_update = now();   
    end if
;;
DELIMITER ;
