/*
 Navicat Premium Data Transfer

 Source Server         : 130.120.2.219
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : 130.120.2.219:3306
 Source Schema         : mins-demo

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 06/11/2018 15:25:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `SID` bigint(32) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL COMMENT '书名',
  `AUTHOR` varchar(64) DEFAULT NULL COMMENT '作者',
  `PRICE` float(10,2) DEFAULT NULL COMMENT '价格',
  `PUBLISH_DATE` datetime DEFAULT NULL COMMENT '发布日期',
  `CREATED` timestamp NULL DEFAULT NULL,
  `CREATED_BY` bigint(32) DEFAULT NULL,
  `LAST_UPDATED` timestamp NULL DEFAULT NULL,
  `LAST_UPDATED_BY` bigint(32) DEFAULT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('2035672420786044928', 'string', 'jeking', '300.00', null, '2020-02-20 10:21:34', null, '2020-02-20 10:21:34', null);
INSERT INTO `books` VALUES ('2035701712463003648', 'stri22ng', 'str22ing', '2020.00', null, '2020-02-20 10:50:10', null, '2020-02-20 10:50:10', null);

SET FOREIGN_KEY_CHECKS = 1;
