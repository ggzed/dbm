/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : lsj

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 18/03/2024 15:54:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_info
-- ----------------------------
DROP TABLE IF EXISTS `auth_info`;
CREATE TABLE `auth_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id',
  `username` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `updater` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '更新人',
  `is_deleted` tinyint NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  INDEX `idx_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '权限信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_info
-- ----------------------------
INSERT INTO `auth_info` VALUES (1, '1', '1', '1', '2024-02-21 14:49:04', '2024-02-26 15:22:43', 'sys', 'sys', 0);
INSERT INTO `auth_info` VALUES (2, 'f8378895fa254760990c7e7fb1eb998d', '2', '2', '2024-02-21 18:19:56', '2024-02-26 15:22:44', 'sys', '', 0);

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '名称',
  `code` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '编码',
  `path` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `node_type` tinyint NULL DEFAULT NULL,
  `parent_id` bigint NOT NULL COMMENT '父id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `updater` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '更新人',
  `is_deleted` tinyint NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_username`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '权限信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES (1, '系统管理', 'SYS_MANAGE', '/system', 1, 0, '2024-02-21 14:49:04', '2024-02-26 18:02:07', 'sys', 'sys', 0);
INSERT INTO `menus` VALUES (2, '用户管理', 'USER', '/user', 2, 1, '2024-02-21 18:19:56', '2024-02-26 18:02:12', 'sys', 'sys', 0);
INSERT INTO `menus` VALUES (3, '角色管理', 'ROLE', '/role', 2, 1, '2024-02-26 16:27:32', '2024-02-26 18:02:15', 'sys', 'sys', 0);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id',
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `menus` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单列表',
  `code` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `updater` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '更新人',
  `is_deleted` tinyint NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_id`(`role_id` ASC) USING BTREE,
  INDEX `idx_username`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, '1', '管理员', '[2,3]', 'admin1', '2024-02-21 14:49:04', '2024-03-18 15:45:39', 'sys', 'sys', 0);
INSERT INTO `role_info` VALUES (2, 'f8378895fa254760990c7e7fb1eb998d', '用户', '', 'user', '2024-02-21 18:19:56', '2024-03-18 15:04:55', 'sys', 'sys', 1);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id',
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '真实姓名',
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户邮箱',
  `nickname` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '昵称',
  `avatar` int NOT NULL COMMENT '头像',
  `birthday` date NOT NULL COMMENT '生日',
  `sex` tinyint NULL DEFAULT 0 COMMENT '性别',
  `short_introduce` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '一句话介绍自己，最多50个汉字',
  `user_resume` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户提交的简历存放地址',
  `user_register_ip` int NOT NULL COMMENT '用户注册时的源ip',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_review_status` tinyint NOT NULL COMMENT '用户资料审核状态，1为通过，2为审核中，3为未通过，4为还未提交审核',
  `creator` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updater` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  INDEX `idx_username`(`name` ASC) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC, `user_review_status` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '网站用户基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '1', '张三12', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-03-18 15:35:50', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (2, '2', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (3, '3', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (4, '4', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (5, '5', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (6, '6', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (7, '7', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (8, '8', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (9, '9', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (10, '10', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');
INSERT INTO `user_info` VALUES (11, '11', '张三', 'zhangsan@qq.com', 'zhangsan', 1, '2024-02-28', 1, '...', '1', 1, 0, '2024-02-28 19:38:22', '2024-02-28 19:38:22', 1, 'sys', 'sys');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id',
  `role_id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `updater` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'sys' COMMENT '更新人',
  `is_deleted` tinyint NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  INDEX `idx_username`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户角色关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '1', '1', '2024-02-21 14:49:04', '2024-02-26 15:22:43', 'sys', 'sys', 0);
INSERT INTO `user_role` VALUES (2, 'f8378895fa254760990c7e7fb1eb998d', '2', '2024-02-21 18:19:56', '2024-02-26 15:22:44', 'sys', '', 0);

SET FOREIGN_KEY_CHECKS = 1;
