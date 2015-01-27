-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-01-27 02:07:53
-- 服务器版本： 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `wechat`
--

-- --------------------------------------------------------

--
-- 表的结构 `wechatPublicAccount`
--

CREATE TABLE IF NOT EXISTS `wechatpublicaccount` (
`id` int(11) NOT NULL,
  `accountId` varchar(255) DEFAULT NULL COMMENT '原始id',
  `appId` varchar(255) DEFAULT NULL COMMENT '应用id',
  `appSecret` varchar(255) DEFAULT NULL COMMENT '应用密钥',
  `inTime` datetime DEFAULT NULL COMMENT '绑定时间',
  `pwd` varchar(255) DEFAULT NULL,
  `ticket` varchar(255) DEFAULT NULL COMMENT '二维码信息',
  `token` varchar(255) DEFAULT NULL COMMENT 'Token(令牌)',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `url` varchar(255) DEFAULT NULL COMMENT '本地接口URL',
  `urlPara` varchar(255) DEFAULT NULL COMMENT 'url后的参数',
  `userName` varchar(255) DEFAULT NULL,
  `validCode` varchar(255) DEFAULT NULL COMMENT '验证码',
  `validState` varchar(255) DEFAULT NULL COMMENT '对接步骤',
  `sysUserId` int(11) DEFAULT NULL COMMENT '管理员id',
  `encodingAESKey` varchar(255) DEFAULT NULL COMMENT '消息加解密密钥'
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `wechatPublicAccount`
--

INSERT INTO `wechatPublicAccount` (`id`, `accountId`, `appId`, `appSecret`, `inTime`, `pwd`, `ticket`, `token`, `updateTime`, `url`, `urlPara`, `userName`, `validCode`, `validState`, `sysUserId`, `encodingAESKey`) VALUES
(1, 'gh_b046aecb765c', 'wx8395cdf652ffcaad', '29c16bb365d4bbc6f7709ccb887d8351', '2015-01-20 15:05:26', NULL, '7777777777', '900150983cd24fb0d6963f7d28e17f72', '2015-01-21 16:53:03', 'http://localhost/msg/ec0405c5aef93e771cd80e0db180b88b', 'ec0405c5aef93e771cd80e0db180b88b', NULL, '1548', '2', 1, 'CSAmOaA7sPlv7wcnJKcrCSXeaIZhLxd7Fxh5RV8i4Vm');

-- --------------------------------------------------------

--
-- 表的结构 `wechatreqmsglog`
--

CREATE TABLE IF NOT EXISTS `wechatreqmsglog` (
`id` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `inEventType` varchar(255) DEFAULT NULL COMMENT '消息类型',
  `inFromUserName` varchar(255) DEFAULT NULL COMMENT '从什么地方发送',
  `inToUserName` varchar(255) DEFAULT NULL,
  `inContent` longtext COMMENT '请求xml',
  `inTime` datetime DEFAULT NULL COMMENT '发送时间',
  `msgId` bigint(20) DEFAULT NULL COMMENT '接收微信的消息时中有',
  `outEventType` varchar(255) DEFAULT NULL COMMENT '请求消息类型',
  `outTime` datetime DEFAULT NULL COMMENT '回调时间',
  `outContent` longtext COMMENT '回复xml',
  `outFromUserName` varchar(255) DEFAULT NULL,
  `outToUserName` varchar(255) DEFAULT NULL COMMENT '发送给谁',
  `publicAccountId` int(11) NOT NULL COMMENT 'wechatPublicAccount的id'
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `wechatreqmsglog`
--

INSERT INTO `wechatreqmsglog` (`id`, `createTime`, `inEventType`, `inFromUserName`, `inToUserName`, `inContent`, `inTime`, `msgId`, `outEventType`, `outTime`, `outContent`, `outFromUserName`, `outToUserName`, `publicAccountId`) VALUES
(1, '2015-01-23 14:53:37', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'help', '2015-01-23 14:53:34', 6107426388262745162, 'text', '2015-01-23 14:53:34', '	发送 help 可获得帮助，发送 "美女" 可看美女，发送 news 可看新闻，发送 music 可听音乐，你还可以试试发送图片、语音、位置、收藏等信息，看会有什么 。公众号持续更新中，想要更多惊喜欢迎每天关注 ^_^', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(2, '2015-01-23 15:01:33', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'help', NULL, 6107428432667178304, 'text', '2015-01-23 15:01:31', '	发送 help 可获得帮助，发送 "美女" 可看美女，发送 news 可看新闻，发送 music 可听音乐，你还可以试试发送图片、语音、位置、收藏等信息，看会有什么 。公众号持续更新中，想要更多惊喜欢迎每天关注 ^_^', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(3, '2015-01-23 15:03:24', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'Help', NULL, 6107428909408548205, 'text', '2015-01-23 15:03:23', '	发送 help 可获得帮助，发送 "美女" 可看美女，发送 news 可看新闻，发送 music 可听音乐，你还可以试试发送图片、语音、位置、收藏等信息，看会有什么 。公众号持续更新中，想要更多惊喜欢迎每天关注 ^_^', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(4, '2015-01-23 16:15:41', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'help', '2015-01-23 16:15:41', 6107447536681713350, 'text', '2015-01-23 16:15:41', '	发送 help 可获得帮助，发送 "美女" 可看美女，发送 news 可看新闻，发送 music 可听音乐，你还可以试试发送图片、语音、位置、收藏等信息，看会有什么 。公众号持续更新中，想要更多惊喜欢迎每天关注 ^_^', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(5, '2015-01-23 16:15:41', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'help', '2015-01-23 16:15:43', 6107447536681713350, 'text', '2015-01-23 16:15:43', '	发送 help 可获得帮助，发送 "美女" 可看美女，发送 news 可看新闻，发送 music 可听音乐，你还可以试试发送图片、语音、位置、收藏等信息，看会有什么 。公众号持续更新中，想要更多惊喜欢迎每天关注 ^_^', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(6, '2015-01-23 16:23:00', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'news', '2015-01-23 16:22:58', 6107449422172356485, 'news', '2015-01-23 16:22:58', '[com.jfinal.weixin.sdk.msg.out.News@15bfc674, com.jfinal.weixin.sdk.msg.out.News@617df4d3]', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(7, '2015-01-23 16:55:29', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'news', '2015-01-23 16:55:27', 6107457793063617324, 'news', '2015-01-23 16:55:27', 'abc', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(8, '2015-01-23 17:15:38', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'news', '2015-01-23 17:15:39', 6107462985679078654, 'news', '2015-01-23 17:15:39', '0:JFinal 1.8 发布，JAVA 极速 WEB+ORM 框架|现在就加入 JFinal 极速开发世界，节省更多时间去跟女友游山玩水 ^_^|http://mmbiz.qpic.cn/mmbiz/zz3Q6WSrzq1ibBkhSA1BibMuMxLuHIvUfiaGsK7CC4kIzeh178IYSHbYQ5eg9tVxgEcbegAu22Qhwgl5IhZFWWXUw/0|http://mp.weixin.qq.com/s?__biz=MjM5ODAwOTU3Mg==&mid=200313981&idx=1&sn=3bc5547ba4beae12a3e8762ababc8175#rd1:JFinal 1.6 发布,JAVA极速WEB+ORM框架|JFinal 1.6 主要升级了 ActiveRecord 插件，本次升级全面支持多数源、多方言、多缓|http://mmbiz.qpic.cn/mmbiz/zz3Q6WSrzq0fcR8VmNCgugHXv7gVlxI6w95RBlKLdKUTjhOZIHGSWsGvjvHqnBnjIWHsicfcXmXlwOWE6sb39kA/0|http://mp.weixin.qq.com/s?__biz=MjM5ODAwOTU3Mg==&mid=200121522&idx=1&sn=ee24f352e299b2859673b26ffa4a81f6#rd', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(9, '2015-01-23 17:31:15', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', 'music', '2015-01-23 17:31:14', 6107467010063435365, 'music', '2015-01-23 17:31:14', 'Listen To Your Heart|建议在 WIFI 环境下流畅欣赏此音乐|http://www.jfinal.com/Listen_To_Your_Heart.mp3|music|http://www.jfinal.com/Listen_To_Your_Heart.mp3', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(10, '2015-01-23 17:39:49', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', '123', '2015-01-23 17:39:47', 6107469217676625755, 'text', '2015-01-23 17:39:47', '	文本消息已成功接收，内容为： 123\n\n	发送 help 可获得帮助，发送 "美女" 可看美女，发送 news 可看新闻，发送 music 可听音乐，你还可以试试发送图片、语音、位置、收藏等信息，看会有什么 。公众号持续更新中，想要更多惊喜欢迎每天关注 ^_^', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1),
(11, '2015-01-23 17:42:23', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', '美女', '2015-01-23 17:42:22', 6107469879101589397, 'news', '2015-01-23 17:42:22', '0:我们只看美女|又一大波美女来袭，我们只看美女 ^_^|https://mmbiz.qlogo.cn/mmbiz/zz3Q6WSrzq3DmIGiadDEicRIp69r1iccicwKEUOKuLhYgjibyU96ia581gCf5o3kicqz6ZLdsDyUtLib0q0hdgHtZOf4Wg/0|http://mp.weixin.qq.com/s?__biz=MjM5ODAwOTU3Mg==&mid=202080887&idx=1&sn=0649c67de565e2d863bf3b8feee24da0#rd', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1);

-- --------------------------------------------------------

--
-- 表的结构 `wechatsyslogs`
--

CREATE TABLE IF NOT EXISTS `wechatsyslogs` (
`id` int(11) NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `logDateTime` datetime DEFAULT NULL,
  `logInfo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `wechatSysUser`
--

CREATE TABLE IF NOT EXISTS `wechatsysuser` (
`id` int(11) NOT NULL COMMENT '主键id,自增',
  `email` varchar(255) DEFAULT NULL COMMENT '注册登录邮箱',
  `inTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `isValid` varchar(255) DEFAULT NULL COMMENT '是否有效,1有效0无效',
  `phoneNo` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '等级',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `validUid` varchar(255) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `wechatSysUser`
--

INSERT INTO `wechatSysUser` (`id`, `email`, `inTime`, `isValid`, `phoneNo`, `pwd`, `score`, `userName`, `validUid`) VALUES
(1, 'policetouzi@163.com', '2015-01-16 10:34:38', '1', NULL, '69cd81c5266503e8839be622caf2b925', 0, 'touzi', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `wechatUserGroup`
--

CREATE TABLE IF NOT EXISTS `wechatusergroup` (
`id` int(11) NOT NULL COMMENT '用户组id',
  `inTime` datetime DEFAULT NULL COMMENT '写入时间',
  `name` varchar(255) DEFAULT NULL COMMENT '用户组名'
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `wechatUserGroup`
--

INSERT INTO `wechatUserGroup` (`id`, `inTime`, `name`) VALUES
(1, '2015-01-16 16:32:52', '管理员'),
(2, '2015-01-16 16:47:04', 'Guest');

-- --------------------------------------------------------

--
-- 表的结构 `wechatUserInfo`
--

CREATE TABLE IF NOT EXISTS `wechatuserinfo` (
`id` int(11) NOT NULL,
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
  `groupId` varchar(32) DEFAULT NULL COMMENT '用户组id'
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `wechatUserInfo`
--

INSERT INTO `wechatUserInfo` (`id`, `sysUserId`, `city`, `country`, `headimgUrl`, `language`, `nickName`, `openId`, `province`, `sex`, `subscribe`, `subscribeTime`, `unsubscribeTime`, `publicAccountId`, `wechatOpenId`, `groupId`) VALUES
(1, 1, NULL, NULL, NULL, NULL, NULL, 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', NULL, NULL, 'true', '2015-01-21 16:53:03', NULL, 1, 'gh_b046aecb765c', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `wechatPublicAccount`
--
ALTER TABLE `wechatPublicAccount`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `ticket` (`ticket`), ADD KEY `FK255DDC9054A1E57F` (`sysUserId`), ADD KEY `FK255DDC906BAA8402` (`sysUserId`), ADD KEY `FK255DDC90F9921F28` (`sysUserId`);

--
-- Indexes for table `wechatreqmsglog`
--
ALTER TABLE `wechatreqmsglog`
 ADD PRIMARY KEY (`id`), ADD KEY `FK7068134C9F275FAE` (`publicAccountId`), ADD KEY `FK7068134C46F171D4` (`publicAccountId`);

--
-- Indexes for table `wechatsyslogs`
--
ALTER TABLE `wechatsyslogs`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wechatSysUser`
--
ALTER TABLE `wechatSysUser`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `valid_uid` (`validUid`);

--
-- Indexes for table `wechatUserGroup`
--
ALTER TABLE `wechatUserGroup`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wechatUserInfo`
--
ALTER TABLE `wechatUserInfo`
 ADD PRIMARY KEY (`id`), ADD KEY `FKA9C826C99F275FAE` (`publicAccountId`), ADD KEY `FKA9C826C9FFCFAA76` (`groupId`), ADD KEY `FKA9C826C946F171D4` (`publicAccountId`), ADD KEY `FKA9C826C92814BF9C` (`groupId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `wechatPublicAccount`
--
ALTER TABLE `wechatPublicAccount`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `wechatreqmsglog`
--
ALTER TABLE `wechatreqmsglog`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `wechatsyslogs`
--
ALTER TABLE `wechatsyslogs`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `wechatSysUser`
--
ALTER TABLE `wechatSysUser`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id,自增',AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `wechatUserGroup`
--
ALTER TABLE `wechatUserGroup`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户组id',AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `wechatUserInfo`
--
ALTER TABLE `wechatUserInfo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
