/*
Navicat MySQL Data Transfer

Source Server         : shaw
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2022-08-31 16:17:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `h_photo`
-- ----------------------------
DROP TABLE IF EXISTS `h_photo`;
CREATE TABLE `h_photo` (
  `photo` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`photo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of h_photo
-- ----------------------------
INSERT INTO `h_photo` VALUES ('D:\\Java-project\\photo\\good2.jpg', 'hao', '222');
INSERT INTO `h_photo` VALUES ('D:\\Java-project\\photo\\good3.jpg', 'lin', '123456');

-- ----------------------------
-- Table structure for `h_room`
-- ----------------------------
DROP TABLE IF EXISTS `h_room`;
CREATE TABLE `h_room` (
  `roomnum` int NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `type` text NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`roomnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of h_room
-- ----------------------------
INSERT INTO `h_room` VALUES ('1801', '未预订', '', '双人标间', '299');
INSERT INTO `h_room` VALUES ('1802', '未预订', '', '单人标间', '500');
INSERT INTO `h_room` VALUES ('1803', 'shaw', '123456', '情趣房', '1000');
INSERT INTO `h_room` VALUES ('1804', '未预订', '', '总统套房', '2000');
INSERT INTO `h_room` VALUES ('1805', '未预订', '', '亲子房', '800');

-- ----------------------------
-- Table structure for `h_user`
-- ----------------------------
DROP TABLE IF EXISTS `h_user`;
CREATE TABLE `h_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of h_user
-- ----------------------------
INSERT INTO `h_user` VALUES ('1', 'admin', '123456', '2022-08-18 15:51:30', '10086@qq.com', '10086');
INSERT INTO `h_user` VALUES ('2', 'shaw', '123456', '2022-08-18 15:51:46', '10086@136.com', '18801');
INSERT INTO `h_user` VALUES ('3', 'hao', '222', '2022-08-18 15:52:15', '222', '222');
INSERT INTO `h_user` VALUES ('11', 'lin', '123456', '2022-08-04 19:49:29', '123456', '123456');
INSERT INTO `h_user` VALUES ('12', 'guo', '123456', '2022-08-05 19:49:50', '123456', '123456');
INSERT INTO `h_user` VALUES ('13', 'xiao', '123456', '2022-07-06 19:50:03', '123456', '123456');
INSERT INTO `h_user` VALUES ('15', 'pong', '123456', '2022-08-02 14:06:23', '123456', '123456');
INSERT INTO `h_user` VALUES ('16', 'uni', '111', '2022-08-02 14:06:44', '111', '123456');
INSERT INTO `h_user` VALUES ('17', 'ling', '11111', '2022-08-02 14:07:02', '123456', '123456');
INSERT INTO `h_user` VALUES ('18', 'ooook', '111111', '2022-08-09 14:07:19', '11111', '111111');
INSERT INTO `h_user` VALUES ('19', 'iuyh', '1531351', '2022-07-26 14:07:40', '1515313', '15315313');
INSERT INTO `h_user` VALUES ('20', 'hu', '131231', '2022-09-10 14:07:56', '45453435', '54534354');
INSERT INTO `h_user` VALUES ('21', 'iuiu', '121212', '2022-08-03 14:08:12', '4122123', '1231313');
INSERT INTO `h_user` VALUES ('22', 'jha', '111111', '2022-08-19 15:30:03', '11111', '111111');
INSERT INTO `h_user` VALUES ('23', 'jack', '1111112', '2022-08-19 15:30:03', '111112', '11111');
INSERT INTO `h_user` VALUES ('24', 'kkk', '1112222', '2022-08-19 15:30:03', '1111111', '11111');
INSERT INTO `h_user` VALUES ('26', 'jkljlj', '22222', '2022-08-19 15:30:03', '3232', '323');
INSERT INTO `h_user` VALUES ('28', 'aaaaaa', '2222222', '2022-08-19 15:30:03', '32323', '232');
INSERT INTO `h_user` VALUES ('29', 'aaaaw', '2222222', '2022-08-19 15:30:03', '2', '323');
INSERT INTO `h_user` VALUES ('30', 'aaaa1111', '222', '2022-08-19 15:30:03', '323', '2');
INSERT INTO `h_user` VALUES ('31', 'zzzzs', '2', '2022-08-19 15:30:03', '232', '22');
INSERT INTO `h_user` VALUES ('32', 'qq', '111', '2022-08-04 10:38:25', '111', '111');
INSERT INTO `h_user` VALUES ('33', 'qwe', '11122', '2022-08-20 16:54:26', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('34', 'qwe', '11122', '2022-08-20 16:54:53', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('35', 'qwe', '11122', '2022-08-22 09:47:18', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('36', 'qwe', '11122', '2022-08-22 09:50:58', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('37', 'qwe', '11122', '2022-08-22 09:52:07', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('38', 'qwe', '11122', '2022-08-22 09:54:03', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('39', 'qwe', '11122', '2022-08-22 09:55:22', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('40', 'qwe', '11122', '2022-08-22 09:55:37', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('41', 'qwe', '11122', '2022-08-22 09:56:40', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('42', 'qwe', '11122', '2022-08-22 09:59:13', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('43', 'qwe', '11122', '2022-08-22 10:01:08', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('44', 'qwe', '11122', '2022-08-22 10:01:54', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('45', 'qwe', '11122', '2022-08-22 10:02:00', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('46', 'qwe', '11122', '2022-08-22 10:10:04', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('47', 'qwe', '11122', '2022-08-22 10:10:16', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('48', 'qwe', '11122', '2022-08-22 10:10:46', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('49', 'qwe', '11122', '2022-08-22 10:59:15', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('50', 'qwe', '11122', '2022-08-22 10:59:35', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('51', 'qwe', '11122', '2022-08-22 11:00:25', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('52', 'qwe', '11122', '2022-08-22 11:00:34', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('53', 'qwe', '11122', '2022-08-22 11:00:52', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('54', 'qwe', '11122', '2022-08-22 11:05:37', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('55', 'qwe', '11122', '2022-08-22 11:06:28', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('56', 'qwe', '11122', '2022-08-22 11:07:47', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('57', 'qwe', '11122', '2022-08-22 11:08:02', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('58', 'qwe', '11122', '2022-08-22 13:08:02', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('59', 'qwe', '11122', '2022-08-22 13:09:53', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('60', 'qwe', '11122', '2022-08-22 13:16:31', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('61', 'qwe', '11122', '2022-08-22 13:17:12', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('62', 'qwe', '11122', '2022-08-22 13:19:03', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('63', 'qwe', '11122', '2022-08-22 13:20:03', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('64', 'qwe', '11122', '2022-08-22 13:34:30', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('65', 'qwe', '11122', '2022-08-22 13:38:16', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('66', 'qwe', '11122', '2022-08-22 13:40:13', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('67', 'qwe', '11122', '2022-08-22 13:42:41', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('68', 'qwe', '11122', '2022-08-22 19:56:51', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('69', 'iuiu', '121212', '2022-08-22 20:20:55', '1069', '1069');
INSERT INTO `h_user` VALUES ('70', 'iuiu', '121212', '2022-08-22 20:21:11', '1069', '1069');
INSERT INTO `h_user` VALUES ('71', 'iuiu', '111', '2022-08-22 20:22:25', '111111', '1111111');
INSERT INTO `h_user` VALUES ('72', 'iuiu', '1111', '2022-08-22 20:23:30', '11111', '1111');
INSERT INTO `h_user` VALUES ('73', 'iuiu', '111112', '2022-08-22 20:24:32', '112121', '12121212');
INSERT INTO `h_user` VALUES ('74', 'iuiu', '11', '2022-08-22 20:25:19', '121212', '121212');
INSERT INTO `h_user` VALUES ('75', 'iu', '33', '2022-08-22 20:26:01', '113', '333');
INSERT INTO `h_user` VALUES ('76', 'iuiu', '11111', '2022-08-22 20:26:35', '1111', '111');
INSERT INTO `h_user` VALUES ('77', 'qwe', '11122', '2022-08-22 20:27:53', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('78', 'qwe', '11122', '2022-08-22 20:29:19', '1221', 'aaaaa');
INSERT INTO `h_user` VALUES ('79', 'qwe', '11122', '2022-08-22 20:32:06', '1221', 'aaaaa');

-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('1', 'x', 'x');
INSERT INTO `people` VALUES ('2', 'h', 'h');
INSERT INTO `people` VALUES ('3', 's', 's');
INSERT INTO `people` VALUES ('4', 'hh', '1122');
