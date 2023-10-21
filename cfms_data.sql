/*
 Navicat Premium Data Transfer

 Source Server         : dbms
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : cfms

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 16/06/2021 15:40:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `admin_account` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `admin_passwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '管理员一号', 'root', '63a9f0ea7bb98050796b649e85481845');
INSERT INTO `admin` VALUES (2, '管理员二号', 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `clazz_id` int(11) NOT NULL AUTO_INCREMENT,
  `clazz_name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clazz_fee` float NOT NULL,
  PRIMARY KEY (`clazz_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, '计算机1班', 5000);
INSERT INTO `clazz` VALUES (2, '大数据1班', 4000);

-- ----------------------------
-- Table structure for clazzfee
-- ----------------------------
DROP TABLE IF EXISTS `clazzfee`;
CREATE TABLE `clazzfee`  (
  `clazzfee_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `clazz_id` int(11) NULL DEFAULT NULL,
  `clazzfee_time` datetime NOT NULL,
  `clazzfee_use` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clazzfee_change` float NOT NULL,
  `clazzfee_status` int(11) NOT NULL,
  PRIMARY KEY (`clazzfee_id`) USING BTREE,
  INDEX `FK_Relationship_2`(`stu_id`) USING BTREE,
  INDEX `FK_Relationship_3`(`clazz_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`clazz_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazzfee
-- ----------------------------
INSERT INTO `clazzfee` VALUES (1, 1, 1, '2021-06-16 15:36:58', '班费收入', 500, 0);
INSERT INTO `clazzfee` VALUES (2, 2, 1, '2021-06-16 15:37:38', '文印支出', -20, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `clazz_id` int(11) NULL DEFAULT NULL,
  `stu_name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stu_is_manager` int(11) NOT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE,
  INDEX `FK_Relationship_1`(`clazz_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`clazz_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 1, '张一', 1);
INSERT INTO `student` VALUES (2, 1, '张二', 0);
INSERT INTO `student` VALUES (3, 1, '张三', 0);
INSERT INTO `student` VALUES (4, 2, '李一', 1);
INSERT INTO `student` VALUES (5, 2, '李二', 0);
INSERT INTO `student` VALUES (6, 2, '李三', 0);

SET FOREIGN_KEY_CHECKS = 1;
