/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_wuliu2

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-08 19:35:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_carmessage`
-- ----------------------------
DROP TABLE IF EXISTS `tb_carmessage`;
CREATE TABLE `tb_carmessage` (
  `Code` int(11) NOT NULL AUTO_INCREMENT,
  `TradeMark` varchar(20) DEFAULT NULL,
  `Brand` varchar(50) DEFAULT NULL,
  `Style` varchar(30) DEFAULT NULL,
  `CarLoad` varchar(10) DEFAULT NULL,
  `UsedTime` varchar(50) DEFAULT NULL,
  `DriverName` varchar(30) DEFAULT NULL,
  `DriverTime` varchar(50) DEFAULT NULL,
  `LicenceNumber` varchar(50) DEFAULT NULL,
  `LicenceStyle` varchar(20) DEFAULT NULL,
  `TranspotStyle` varchar(20) DEFAULT NULL,
  `LinkMan` varchar(20) DEFAULT NULL,
  `LinkPhone` varchar(50) DEFAULT NULL,
  `Remark` varchar(100) DEFAULT NULL,
  `IssueDate` varchar(100) DEFAULT NULL,
  `UserName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_carmessage
-- ----------------------------
INSERT INTO `tb_carmessage` VALUES ('4', '渝ABCDEFG', 'hhh', 'hhhh', '34', '3', '张*明', '6', '452945934**', 'A类', '短途', '张先生', '0431577*****', '        经验丰富', '2018-07-04 00:00:00', 'jjjj');
INSERT INTO `tb_carmessage` VALUES ('11', '渝BCDEFGa', 'hehehe', '轿车', '200', '3', '张*军', '5', '220159357***', 'B类', '短途', '杨*洋', '0431-4593****', '  三成新的车', '2013-07-26 14:02:58', '杨*丽');
INSERT INTO `tb_carmessage` VALUES ('17', '渝CDEFGr', '面zz', '小车', '200', '3', '付*春', '35', '2201258593***', 'A类', '短途', '杨*丽', '130091****', '  111111111', '2013-07-26 14:02:58', 'bbbb');
INSERT INTO `tb_carmessage` VALUES ('25', '渝DEFGvse', '大卡车', '大车', '200', '12', '杨*小', '5', '220147258***', 'B', '短途', '吕*小', '0431-4593***', '车辆已经快要报废。', '2013-07-26 14:02:58', 'mmmmmm');
INSERT INTO `tb_carmessage` VALUES ('26', '渝ABCDesdFG', '一气*威', '重卡', '90', '2', '王*民', '5', 'jlc4127', 'A', '长途', '王先生', '13152******', '经验丰富', '2013-07-26 14:02:58', 'ggg');
INSERT INTO `tb_carmessage` VALUES ('27', '渝dfsfgd', '平柴', '141', '40', '4', '庄*续平', '5', '吉4236**', 'A', '长途', '庄先生', '1835*******', '无', '2013-07-26 14:02:58', 'ggg');
INSERT INTO `tb_carmessage` VALUES ('28', '渝wefwrwFG', '一汽平柴', '141', '50', '8', '张*续', '8', 'JLD46**', 'A', '长途', '张先生', '0431-577****', '经验丰富', '2013-07-26 14:02:58', 'ggg');
INSERT INTO `tb_carmessage` VALUES ('33', '渝ffwwereg', 'K货车', '普通货车', '100', '1', '在一', '2', '32', 'A', '长途', '上地', '5353', '  再接再厉 ', '2013-07-26 14:02:58', '00');
INSERT INTO `tb_carmessage` VALUES ('34', '1', '22222222222222222222', '1', '11', '1', '1', '1', '1', 'A', '长途', '1', '1', '  1', '2018-07-05', 'rock');
INSERT INTO `tb_carmessage` VALUES ('35', '', '', '', '', '', '', '', '', 'A', '长途', '', '', '', '2018-07-08', 'rock');

-- ----------------------------
-- Table structure for `tb_customer`
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `Password` varchar(16) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Question` varchar(50) DEFAULT NULL,
  `Result` varchar(50) DEFAULT NULL,
  `IssueDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES ('4', 'rock', '123', '1', '1', '1', '1', '1', '2017-10-1');
INSERT INTO `tb_customer` VALUES ('5', 'rock2', '1', '1', 'man', '1', '1', '1', '2018年7月5日 星期四');

-- ----------------------------
-- Table structure for `tb_enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `tb_enterprise`;
CREATE TABLE `tb_enterprise` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EnterpriseSort` varchar(50) DEFAULT NULL,
  `EnterpriseName` varchar(100) DEFAULT NULL,
  `Operation` varchar(100) DEFAULT NULL,
  `WorkArea` varchar(50) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Phone` varchar(200) DEFAULT NULL,
  `LinkMan` varchar(30) DEFAULT NULL,
  `HandSet` varchar(30) DEFAULT NULL,
  `Fax` varchar(30) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Http` varchar(50) DEFAULT NULL,
  `Intro` varchar(200) DEFAULT NULL,
  `IssueDate` varchar(80) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_enterprise
-- ----------------------------
INSERT INTO `tb_enterprise` VALUES ('13', '1111', '1111', '开发', '中国', '长春市', '0431-5772***', '王女士', '13844******', '12345-522-***', 'w*@1*3.com', 'www.*f.com.cn', '无', '2005-02-08', '11');
INSERT INTO `tb_enterprise` VALUES ('14', '2222', '2222', '外包', '长春市', '长春市', '0431-657****', '邓女士', '13156******', '231-564-***', 'd*@y*o.com.cn', 'www.c*c.com', '无', '2007-12-12', '11');
INSERT INTO `tb_enterprise` VALUES ('19', '3333', '3333', '开发', '长春市', '长春市', '0431-577****', '王先生', '13756******', '123-741-*****', 'www.w*@y*o.com', 'www.g*w.com', '暂无', '2006-02-11', '11');
INSERT INTO `tb_enterprise` VALUES ('20', '4444', '4444', '外包', '吉林省', '敦化市', '0433-62*****', '刘女士', '13862******', '325-890-******', 'ao*g@1*3.com', 'www.a*g.com', '暂无', '2006-02-11', '11');
INSERT INTO `tb_enterprise` VALUES ('21', '5555', '5555', '运输', '吉林省', '长春市吉林大路', '0431-45*****', '计*雅', '13009******', '0431-497****', 'm*@1*3.com', 'www.hon*i.com', '无', '2006-02-11', 'mmmmmm');
INSERT INTO `tb_enterprise` VALUES ('22', '6666', '6666', '消炎药', '吉林省', '长春市', '0431-49*****', '李*冉', '13009******', '0431-497****', 'q*@1*.com', 'www.qi**n.com', '无', '2006-02-11', 'mmmmmm');
INSERT INTO `tb_enterprise` VALUES ('24', '房地产', '房地产公司', '所有', '长春', '长春市二道区', '8977', '刘先生', '13666**', '0431-88**12', '88@**.com', 'http://www.o*.com', '各种建材料均销售', '2018-07-05', '00');
INSERT INTO `tb_enterprise` VALUES ('25', '1', '22222222222222222', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2018-07-05', 'rock');

-- ----------------------------
-- Table structure for `tb_goodsmeg`
-- ----------------------------
DROP TABLE IF EXISTS `tb_goodsmeg`;
CREATE TABLE `tb_goodsmeg` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GoodsStyle` varchar(50) DEFAULT NULL,
  `GoodsName` varchar(100) DEFAULT NULL,
  `GoodsNumber` varchar(50) DEFAULT NULL,
  `GoodsUnit` varchar(50) DEFAULT NULL,
  `StartProvince` varchar(100) DEFAULT NULL,
  `StartCity` varchar(20) DEFAULT NULL,
  `EndProvince` varchar(30) DEFAULT NULL,
  `EndCity` varchar(30) DEFAULT NULL,
  `Style` varchar(50) DEFAULT NULL,
  `TransportTime` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Link` varchar(200) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  `Remark` varchar(800) DEFAULT NULL,
  `Request` varchar(50) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_goodsmeg
-- ----------------------------
INSERT INTO `tb_goodsmeg` VALUES ('11', '电脑', '优质煤', '402', '台', '重庆市', '长寿', '吉林省', '长春市', '快速', '2018-07-05', '13756******', '王先生', '2018-07-05 00:00:00', '注意安全', '车况好', '312');
INSERT INTO `tb_goodsmeg` VALUES ('16', '冰箱', '洗衣机', '200', '台', '贵州省', '贵阳', '辽宁省', '大连', '快速', '2012-02-13', '0431-459****', '杨*冉', '2013-07-26 13:12:55', '一定按时送达。', '要求速度快，不要损坏货物', '11');
INSERT INTO `tb_goodsmeg` VALUES ('26', '铁皮车', '钢筋', '30000', '辆', '海南省', '海口', '吉林省', '长春', '普通', '2012-02-13', '0435-589****', '李*欣', '2013-07-26 13:12:55', '注意安全12\n156666', '加速行驶', '11');
INSERT INTO `tb_goodsmeg` VALUES ('30', '坦克', '木头', '2000', '辆', '四川省', '成都市', '辽宁省', '沈阳', '普通', '2012-02-13', '0431-45*****', '杨*丽', '2013-07-26 13:12:55', '运输过程中一定要小心安全。', '车辆一定要两成新。', '11');
INSERT INTO `tb_goodsmeg` VALUES ('34', '飞机', '手机', '3000', '架', '四川省', '南充市', '黑龙江省', '乌鲁木齐', '加急', '2012-02-11', '0431-45*****', '郭*威', '2013-07-26 13:12:55', '途中一定要注意安全。', '要求车速加快，三天内一定要到达，否则予以罚款。', 'gggggg');
INSERT INTO `tb_goodsmeg` VALUES ('35', '大炮', '计算器', '200', '台', '四川省', '绵阳市', '辽宁省', '长春市', '普通', '2012-03-05', '0431-45*****', '杨*心', '2013-07-26 13:12:55', '一定注意安全', '一定注意', 'gggggg');
INSERT INTO `tb_goodsmeg` VALUES ('37', ' DF-21', '楼房', '200', '枚', '四川省', '攀枝花市', '黑龙江省', '梅河市', '普通', '2012-02-11', '0431-45*****', '杨*阳', '2013-07-26 13:12:55', '途中一定要注意安全。', '一定要快速到达目的地。', 'mmmmmm');
INSERT INTO `tb_goodsmeg` VALUES ('40', '  666', '米*来宁', '100', ' 斤', '四川省', '西昌', '辽宁省', '沈阳市', '普通', '2012-02-13', '0431-45*****', '吕*萌', '2013-07-26 13:12:55', '途中一定要保证药业不被淋湿。', '车辆一定要慢行驶。', 'mmmmmm');
INSERT INTO `tb_goodsmeg` VALUES ('41', ' 1', '1', '1', ' 222222222222', '1', '1', '1', '1', '普通', '2018-07-08', '1', '1', '2018-07-08 00:00:00', '2222222222222222', '1', 'rock');

-- ----------------------------
-- Table structure for `tb_knowledge`
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge`;
CREATE TABLE `tb_knowledge` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Content` varchar(2000) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  `Reside` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_knowledge
-- ----------------------------
INSERT INTO `tb_knowledge` VALUES ('27', '车辆最近紧缺', '         因天气变化，车辆最近出现紧缺情况，请各部分做好应急准备。', '2018-07-05 00:00:00', '车辆');
INSERT INTO `tb_knowledge` VALUES ('28', '车辆停运', '            因天气变化，最近的车辆一切暂时停运，具体的信息另行通知。', '2018-07-05 00:00:00', '车辆123');
INSERT INTO `tb_knowledge` VALUES ('29', '货物减少', '      最近因天气变化，货物的发行情况不得很好，所以提醒各位，发货时一定要加小心，以免路滑发生意外情况。', '2013-07-26 13:09:55', '货物');
INSERT INTO `tb_knowledge` VALUES ('33', '1', '1', '2018-07-05 00:00:00', '1');

-- ----------------------------
-- Table structure for `tb_logistics`
-- ----------------------------
DROP TABLE IF EXISTS `tb_logistics`;
CREATE TABLE `tb_logistics` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Content` varchar(2000) DEFAULT NULL,
  `Author` varchar(50) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_logistics
-- ----------------------------
INSERT INTO `tb_logistics` VALUES ('9', '车辆紧缺', '      近日，过年临近，各条线路均出现车辆紧缺的情况。望各有关部分做好应急准备。', '刘刘', '2013-07-26 13:08:30');
INSERT INTO `tb_logistics` VALUES ('12', '长途停运', '      由于最近年期临近，加上最近天所变化，路面道滑，所有长途车辆暂时停时运行，运行日期另行通知。', '无语', '2013-07-26 13:08:30');
INSERT INTO `tb_logistics` VALUES ('13', '路面', '   路面道滑', '无语', '2013-07-26 13:08:30');
INSERT INTO `tb_logistics` VALUES ('18', '车辆急缺', '由于最近天气不好，一直下雪，所以长途车辆急缺，很多业主因天气状况不愿出行。', '小草', '2013-07-26 13:08:30');
INSERT INTO `tb_logistics` VALUES ('19', '1', '1', '1', '2018-07-05 00:00:00');

-- ----------------------------
-- Table structure for `tb_manager`
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES ('1', 'rock', '123', '55', 'dd');
INSERT INTO `tb_manager` VALUES ('2', 'tsdddd', 'ddd', '465465', 'tttt');

-- ----------------------------
-- Table structure for `tb_placard`
-- ----------------------------
DROP TABLE IF EXISTS `tb_placard`;
CREATE TABLE `tb_placard` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Content` varchar(1000) DEFAULT NULL,
  `Author` varchar(20) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_placard
-- ----------------------------
INSERT INTO `tb_placard` VALUES ('56', '1', '1', 'rock', '2015-01-01 00:00:00');
