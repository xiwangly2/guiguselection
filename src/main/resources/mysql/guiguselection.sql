/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : guiguselection

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 26/09/2023 21:48:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roles` json NULL,
  `buttons` json NULL,
  `routes` json NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, 'https://example.com/avatar.jpg', 'admin', 'TqVd9i4ow3fWPyIB7HFyrV/DL8bQwMp5uTruxWTZ7lc=:JkPaqEX/ztA8OfVOVhtqRbjKMWAxfXdhsOeCk5jkHuhZJkULnN9COU+R7I2EBuPyBFEBkXruEvAKmNwD/5hBMg==', 'New User Description', 'user_token', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, 'https://example.com/avatar.jpg', 'root', 'mWGLfxNa3Y6rh8G4JAFDSZ4u5qb1GOIVzc4kanR02F8=:EIyZoqywDHbI6O7jgmaxHS9wtnlHTzv7ZFKpzFQt9+3thDODfRAmqUrqjCsCpVQDdRYcJ4nVjAlS1j2ecaKqYw==', 'New User Description', 'user_token1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_buttons
-- ----------------------------
DROP TABLE IF EXISTS `user_buttons`;
CREATE TABLE `user_buttons`  (
  `user_id` bigint(20) NOT NULL,
  `buttons` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_buttons
-- ----------------------------
INSERT INTO `user_buttons` VALUES (1, 'button1');
INSERT INTO `user_buttons` VALUES (1, 'button2');
INSERT INTO `user_buttons` VALUES (2, 'button1');
INSERT INTO `user_buttons` VALUES (2, 'button2');
INSERT INTO `user_buttons` VALUES (3, 'button1');
INSERT INTO `user_buttons` VALUES (3, 'button2');
INSERT INTO `user_buttons` VALUES (4, 'button1');
INSERT INTO `user_buttons` VALUES (4, 'button2');
INSERT INTO `user_buttons` VALUES (5, 'button1');
INSERT INTO `user_buttons` VALUES (5, 'button2');
INSERT INTO `user_buttons` VALUES (6, 'button1');
INSERT INTO `user_buttons` VALUES (6, 'button2');
INSERT INTO `user_buttons` VALUES (7, 'button1');
INSERT INTO `user_buttons` VALUES (7, 'button2');

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`  (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES (1, 'user');
INSERT INTO `user_roles` VALUES (1, 'member');
INSERT INTO `user_roles` VALUES (2, 'user');
INSERT INTO `user_roles` VALUES (2, 'member');
INSERT INTO `user_roles` VALUES (3, 'user');
INSERT INTO `user_roles` VALUES (3, 'member');
INSERT INTO `user_roles` VALUES (4, 'user');
INSERT INTO `user_roles` VALUES (4, 'member');
INSERT INTO `user_roles` VALUES (5, 'user');
INSERT INTO `user_roles` VALUES (5, 'member');
INSERT INTO `user_roles` VALUES (6, 'user');
INSERT INTO `user_roles` VALUES (6, 'member');
INSERT INTO `user_roles` VALUES (7, 'user');
INSERT INTO `user_roles` VALUES (7, 'member');

-- ----------------------------
-- Table structure for user_routes
-- ----------------------------
DROP TABLE IF EXISTS `user_routes`;
CREATE TABLE `user_routes`  (
  `user_id` bigint(20) NOT NULL,
  `routes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_routes
-- ----------------------------
INSERT INTO `user_routes` VALUES (1, 'route1');
INSERT INTO `user_routes` VALUES (1, 'route2');
INSERT INTO `user_routes` VALUES (2, 'route1');
INSERT INTO `user_routes` VALUES (2, 'route2');
INSERT INTO `user_routes` VALUES (3, 'route1');
INSERT INTO `user_routes` VALUES (3, 'route2');
INSERT INTO `user_routes` VALUES (4, 'route1');
INSERT INTO `user_routes` VALUES (4, 'route2');
INSERT INTO `user_routes` VALUES (5, 'route1');
INSERT INTO `user_routes` VALUES (5, 'route2');
INSERT INTO `user_routes` VALUES (6, 'route1');
INSERT INTO `user_routes` VALUES (6, 'route2');
INSERT INTO `user_routes` VALUES (7, 'route1');
INSERT INTO `user_routes` VALUES (7, 'route2');

SET FOREIGN_KEY_CHECKS = 1;
