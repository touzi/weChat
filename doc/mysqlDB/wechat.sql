/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-01-16 18:30:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wechatPublicAccount
-- ----------------------------
DROP TABLE IF EXISTS `wechatPublicAccount`;
CREATE TABLE `wechatPublicAccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公众平台号的表',
  `accountId` varchar(255) DEFAULT NULL COMMENT '原始id',
  `appId` varchar(255) DEFAULT NULL COMMENT '应用id',
  `appSecret` varchar(255) DEFAULT NULL COMMENT '应用密钥',
  `inTime` datetime DEFAULT NULL COMMENT '绑定时间',
  `pwd` varchar(255) DEFAULT NULL,
  `ticket` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL COMMENT 'Token(令牌)',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `url` varchar(255) DEFAULT NULL COMMENT '本地接口URL',
  `userName` varchar(255) DEFAULT NULL,
  `validCode` varchar(255) DEFAULT NULL COMMENT '验证码',
  `validState` varchar(255) DEFAULT NULL COMMENT '公众号国家',
  `sysUserId` int(11) DEFAULT NULL COMMENT '管理员id',
  `encodingAESKey` varchar(255) DEFAULT NULL COMMENT '消息加解密密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket` (`ticket`),
  KEY `FK255DDC9054A1E57F` (`sysUserId`),
  KEY `FK255DDC906BAA8402` (`sysUserId`),
  KEY `FK255DDC90F9921F28` (`sysUserId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechatPublicAccount
-- ----------------------------
INSERT INTO `wechatPublicAccount` VALUES ('1', null, null, null, null, null, null, '900150983cd24fb0d6963f7d28e17f72', null, 'http://localhost/msg/ec0405c5aef93e771cd80e0db180b88b', null, '1548', null, '1', null);

-- ----------------------------
-- Table structure for wechatSysLog
-- ----------------------------
DROP TABLE IF EXISTS `wechatSysLog`;
CREATE TABLE `wechatSysLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(128) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `userName` varchar(200) NOT NULL,
  `logDateTime` varchar(22) NOT NULL,
  `logInfo` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechatSysLog
-- ----------------------------
INSERT INTO `wechatSysLog` VALUES ('27', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-15 21:42:46', 'sss->登录失败');
INSERT INTO `wechatSysLog` VALUES ('28', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-15 21:44:03', 'touzi->登录失败');
INSERT INTO `wechatSysLog` VALUES ('29', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-15 21:49:18', 'touzi->登录失败');
INSERT INTO `wechatSysLog` VALUES ('30', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-15 21:49:26', 'touzi->登录失败');
INSERT INTO `wechatSysLog` VALUES ('31', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-15 21:49:39', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('32', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-15 21:54:03', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('33', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-15 22:00:27', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('34', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-15 22:02:00', '->登录失败');
INSERT INTO `wechatSysLog` VALUES ('35', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-15 22:02:13', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('36', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-15 22:05:40', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('37', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-15 22:39:24', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('38', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-16 11:57:47', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('39', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-16 14:32:33', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('40', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-16 16:20:47', '注册新用户->6');
INSERT INTO `wechatSysLog` VALUES ('41', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-16 17:52:26', '注册新用户->10');
INSERT INTO `wechatSysLog` VALUES ('42', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-16 18:10:21', '注册新用户->11');
INSERT INTO `wechatSysLog` VALUES ('43', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-16 18:11:22', '注册新用户->12');
INSERT INTO `wechatSysLog` VALUES ('44', '0:0:0:0:0:0:0:1', '0', 'error', '2015-01-16 18:12:43', '注册新用户->13');
INSERT INTO `wechatSysLog` VALUES ('45', '0:0:0:0:0:0:0:1', '13', 'efg', '2015-01-16 18:12:56', '用户登录');
INSERT INTO `wechatSysLog` VALUES ('46', '0:0:0:0:0:0:0:1', '1', 'touzi', '2015-01-16 18:24:18', '用户登录');

-- ----------------------------
-- Table structure for wechatSysUser
-- ----------------------------
DROP TABLE IF EXISTS `wechatSysUser`;
CREATE TABLE `wechatSysUser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id,自增',
  `email` varchar(255) DEFAULT NULL COMMENT '注册登录邮箱',
  `inTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `isValid` varchar(255) DEFAULT NULL COMMENT '是否有效,1有效0无效',
  `phoneNo` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '等级',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `validUid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `valid_uid` (`validUid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechatSysUser
-- ----------------------------
INSERT INTO `wechatSysUser` VALUES ('1', 'policetouzi@163.com', '2015-01-16 10:34:38', '1', null, '69cd81c5266503e8839be622caf2b925', '0', 'touzi', null);

-- ----------------------------
-- Table structure for wechatUserGroup
-- ----------------------------
DROP TABLE IF EXISTS `wechatUserGroup`;
CREATE TABLE `wechatUserGroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户组id',
  `inTime` datetime DEFAULT NULL COMMENT '写入时间',
  `name` varchar(255) DEFAULT NULL COMMENT '用户组名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechatUserGroup
-- ----------------------------
INSERT INTO `wechatUserGroup` VALUES ('1', '2015-01-16 16:32:52', '管理员');
INSERT INTO `wechatUserGroup` VALUES ('2', '2015-01-16 16:47:04', 'Guest');

-- ----------------------------
-- Table structure for wechatUserInfo
-- ----------------------------
DROP TABLE IF EXISTS `wechatUserInfo`;
CREATE TABLE `wechatUserInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sysUserId` int(11) DEFAULT NULL COMMENT '对应sysUser的id',
  `city` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `headimgUrl` varchar(255) DEFAULT NULL COMMENT '标题URL',
  `language` varchar(255) DEFAULT NULL COMMENT '语言',
  `nickName` varchar(255) DEFAULT NULL COMMENT '昵称',
  `openId` varchar(255) DEFAULT NULL COMMENT '微信的openid',
  `province` varchar(255) DEFAULT NULL COMMENT '微信中带过来的用户信息中的地区',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `subscribe` varchar(255) DEFAULT NULL COMMENT '是否订阅',
  `subscribeTime` datetime DEFAULT NULL COMMENT '订阅时间',
  `unsubscribeTime` datetime DEFAULT NULL COMMENT '取消订阅的时间',
  `publicAccountId` int(11) DEFAULT NULL COMMENT '对应publicAccount的id',
  `wechatOpenId` varchar(255) DEFAULT NULL COMMENT '公众号订阅号原始id',
  `groupId` varchar(32) DEFAULT NULL COMMENT '用户组id',
  PRIMARY KEY (`id`),
  KEY `FKA9C826C99F275FAE` (`publicAccountId`),
  KEY `FKA9C826C9FFCFAA76` (`groupId`),
  KEY `FKA9C826C946F171D4` (`publicAccountId`),
  KEY `FKA9C826C92814BF9C` (`groupId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechatUserInfo
-- ----------------------------
INSERT INTO `wechatUserInfo` VALUES ('1', '1', null, null, null, null, null, null, null, null, null, null, null, '1', null, '1');
