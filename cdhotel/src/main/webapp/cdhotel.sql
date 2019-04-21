/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : cdhotel

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-04-21 15:45:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cd_duty
-- ----------------------------
DROP TABLE IF EXISTS `cd_duty`;
CREATE TABLE `cd_duty` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `DUTYDATE` varchar(8) NOT NULL COMMENT '值班日期',
  `PERSONNAME` varchar(255) NOT NULL COMMENT '值班人员姓名',
  `PERSONID` int(8) NOT NULL COMMENT '值班人员id',
  `CREATENAME` varchar(255) NOT NULL COMMENT '创建人员名称',
  `CREATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='值班表';

-- ----------------------------
-- Records of cd_duty
-- ----------------------------

-- ----------------------------
-- Table structure for cd_order
-- ----------------------------
DROP TABLE IF EXISTS `cd_order`;
CREATE TABLE `cd_order` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `GUESTNAME` varchar(255) NOT NULL COMMENT '顾客姓名',
  `GUESTID` int(8) NOT NULL COMMENT '顾客id',
  `CREATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `EMPLOYEENAME` varchar(255) DEFAULT NULL COMMENT '操作人员姓名',
  `ORDERID` varchar(255) NOT NULL COMMENT '订单编号UUID ,可重复',
  `ROOMID` int(8) NOT NULL COMMENT '房间编号',
  `ROOMNAME` varchar(255) DEFAULT NULL COMMENT '房间名称',
  `MONEY` varchar(8) NOT NULL COMMENT '金额，两个小数点',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of cd_order
-- ----------------------------

-- ----------------------------
-- Table structure for cd_performance
-- ----------------------------
DROP TABLE IF EXISTS `cd_performance`;
CREATE TABLE `cd_performance` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `MONTH` varchar(6) NOT NULL COMMENT '月份yyyyMM',
  `PERSONNAME` varchar(255) NOT NULL,
  `PERSONID` int(8) NOT NULL,
  `PERFORMANCE` int(2) NOT NULL COMMENT '效绩 0到1，一位小数点',
  `EMOLUMENT` varchar(255) NOT NULL COMMENT '应发工资',
  `PAY` varchar(255) DEFAULT NULL COMMENT '实发工资',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工效绩表';

-- ----------------------------
-- Records of cd_performance
-- ----------------------------

-- ----------------------------
-- Table structure for cd_permission
-- ----------------------------
DROP TABLE IF EXISTS `cd_permission`;
CREATE TABLE `cd_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) NOT NULL,
  `roleid` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of cd_permission
-- ----------------------------
INSERT INTO `cd_permission` VALUES ('1', 'roomer:*', '1');
INSERT INTO `cd_permission` VALUES ('2', 'employee:*', '2');
INSERT INTO `cd_permission` VALUES ('3', 'admin:*', '3');

-- ----------------------------
-- Table structure for cd_role
-- ----------------------------
DROP TABLE IF EXISTS `cd_role`;
CREATE TABLE `cd_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of cd_role
-- ----------------------------
INSERT INTO `cd_role` VALUES ('1', 'roomer');
INSERT INTO `cd_role` VALUES ('2', 'employee');
INSERT INTO `cd_role` VALUES ('3', 'admin');

-- ----------------------------
-- Table structure for cd_room_list
-- ----------------------------
DROP TABLE IF EXISTS `cd_room_list`;
CREATE TABLE `cd_room_list` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `ROOMNAME` varchar(255) NOT NULL COMMENT '房间名称',
  `ROOMTYPE` int(8) NOT NULL COMMENT '房间类型ID',
  `STATUS` int(4) NOT NULL COMMENT '0：可售；1：已预订；已入住',
  `STARTTIME` varchar(14) DEFAULT NULL COMMENT '入住开始时间',
  `ENDTIME` varchar(14) DEFAULT NULL COMMENT '入住结束时间',
  `LASTNAME` int(8) NOT NULL COMMENT '最后操作人员id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间状态信息表';

-- ----------------------------
-- Records of cd_room_list
-- ----------------------------

-- ----------------------------
-- Table structure for cd_room_type
-- ----------------------------
DROP TABLE IF EXISTS `cd_room_type`;
CREATE TABLE `cd_room_type` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `TYPENAME` varchar(255) NOT NULL COMMENT '房间类型',
  `DESCRIBE` varchar(255) DEFAULT NULL COMMENT '房间描述',
  `PRICE` varchar(6) NOT NULL COMMENT '价格（每天），两位小数',
  `PICTUREURL` varchar(255) NOT NULL COMMENT '图片链接地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间类型表';

-- ----------------------------
-- Records of cd_room_type
-- ----------------------------

-- ----------------------------
-- Table structure for cd_signin
-- ----------------------------
DROP TABLE IF EXISTS `cd_signin`;
CREATE TABLE `cd_signin` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `SIGNINTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '签到时间',
  `USERNAME` varchar(255) NOT NULL COMMENT '签到人员',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工签到表';

-- ----------------------------
-- Records of cd_signin
-- ----------------------------

-- ----------------------------
-- Table structure for cd_user
-- ----------------------------
DROP TABLE IF EXISTS `cd_user`;
CREATE TABLE `cd_user` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(60) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `ROLE` varchar(4) NOT NULL COMMENT '角色：1顾客；2：员工；3：管理员',
  `CREATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间：自动插入',
  `CREATENAME` varchar(255) NOT NULL COMMENT '创建人员',
  `EMOLUMENT` varchar(255) DEFAULT NULL COMMENT '薪水',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='人员信息表';

-- ----------------------------
-- Records of cd_user
-- ----------------------------
INSERT INTO `cd_user` VALUES ('1', 'TOM', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-04-21 01:45:50', 'TOME', '0');
INSERT INTO `cd_user` VALUES ('2', 'employee', 'e10adc3949ba59abbe56e057f20f883e', '2', '2019-04-21 01:49:22', 'test', '1000.00');
INSERT INTO `cd_user` VALUES ('3', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '3', '2019-04-21 01:49:42', 'test', '10000.00');
