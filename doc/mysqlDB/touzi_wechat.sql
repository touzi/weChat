-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-01-27 10:10:26
-- 服务器版本： 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `touzi_wechat`
--

-- --------------------------------------------------------

--
-- 表的结构 `wechat_public_account`
--

CREATE TABLE IF NOT EXISTS `wechat_public_account` (
`id` int(11) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `app_id` varchar(255) DEFAULT NULL,
  `app_secret` varchar(255) DEFAULT NULL,
  `in_time` datetime DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `ticket` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `url_para` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `valid_code` varchar(255) DEFAULT NULL,
  `valid_state` varchar(255) DEFAULT NULL,
  `sys_user_id` int(11) NOT NULL,
  `encoding_aes_key` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='公众号表';

--
-- 转存表中的数据 `wechat_public_account`
--

INSERT INTO `wechat_public_account` (`id`, `account_id`, `app_id`, `app_secret`, `in_time`, `pwd`, `ticket`, `token`, `update_time`, `url`, `url_para`, `user_name`, `valid_code`, `valid_state`, `sys_user_id`, `encoding_aes_key`) VALUES
(1, 'gh_b046aecb765c', 'wx8395cdf652ffcaad', '29c16bb365d4bbc6f7709ccb887d8351', '2015-01-27 17:00:58', NULL, 'f622411e57562684d8482d44fa46fe20', '40d083909d4ebbc1a70a2bf4577b4928', '2015-01-27 17:06:41', 'http://localhost/msg/f049355fcbdfe46437f4aba788e1e78c', 'f049355fcbdfe46437f4aba788e1e78c', NULL, '7850', '2', 1, 'CSAmOaA7sPlv7wcnJKcrCSXeaIZhLxd7Fxh5RV8i4Vm');

-- --------------------------------------------------------

--
-- 表的结构 `wechat_req_msg_log`
--

CREATE TABLE IF NOT EXISTS `wechat_req_msg_log` (
`id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `in_event_type` varchar(255) DEFAULT NULL,
  `in_from_user_name` varchar(255) DEFAULT NULL,
  `in_to_user_name` varchar(255) DEFAULT NULL,
  `in_content` longtext,
  `in_time` datetime DEFAULT NULL,
  `msg_id` bigint(20) DEFAULT NULL,
  `out_event_type` varchar(255) DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `out_content` longtext,
  `out_from_user_name` varchar(255) DEFAULT NULL,
  `out_to_user_name` varchar(255) DEFAULT NULL,
  `public_account_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='微信交互日志表';

--
-- 转存表中的数据 `wechat_req_msg_log`
--

INSERT INTO `wechat_req_msg_log` (`id`, `create_time`, `in_event_type`, `in_from_user_name`, `in_to_user_name`, `in_content`, `in_time`, `msg_id`, `out_event_type`, `out_time`, `out_content`, `out_from_user_name`, `out_to_user_name`, `public_account_id`) VALUES
(1, '2015-01-27 17:06:45', 'text', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 'gh_b046aecb765c', '7850', '2015-01-27 17:06:41', 6108945037159111088, 'text', '2015-01-27 17:06:41', '验证成功!', 'gh_b046aecb765c', 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', 1);

-- --------------------------------------------------------

--
-- 表的结构 `wechat_sys_log`
--

CREATE TABLE IF NOT EXISTS `wechat_sys_log` (
`id` int(11) NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `log_info` longtext,
  `log_datetime` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统日志';

--
-- 转存表中的数据 `wechat_sys_log`
--

INSERT INTO `wechat_sys_log` (`id`, `ip`, `user_id`, `user_name`, `log_info`, `log_datetime`) VALUES
(1, '127.0.0.1', 1, NULL, '用户退出', '2015-01-27 16:51:11'),
(2, '127.0.0.1', 0, 'error', '注册新用户->1', '2015-01-27 16:51:42'),
(3, '127.0.0.1', 1, NULL, '用户登录', '2015-01-27 16:51:51');

-- --------------------------------------------------------

--
-- 表的结构 `wechat_sys_user`
--

CREATE TABLE IF NOT EXISTS `wechat_sys_user` (
`id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `in_time` datetime DEFAULT NULL,
  `is_valid` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '等级',
  `user_name` varchar(255) DEFAULT NULL,
  `valid_u_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

--
-- 转存表中的数据 `wechat_sys_user`
--

INSERT INTO `wechat_sys_user` (`id`, `email`, `in_time`, `is_valid`, `phone_no`, `pwd`, `score`, `user_name`, `valid_u_id`) VALUES
(1, 'policetouzi@163.com', '2015-01-27 16:51:42', '1', NULL, '69cd81c5266503e8839be622caf2b925', 0, 'touzi', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `wechat_user_group`
--

CREATE TABLE IF NOT EXISTS `wechat_user_group` (
`id` int(11) NOT NULL,
  `in_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='微信分组表';

--
-- 转存表中的数据 `wechat_user_group`
--

INSERT INTO `wechat_user_group` (`id`, `in_time`, `name`) VALUES
(1, '2015-01-27 09:27:13', '管理员');

-- --------------------------------------------------------

--
-- 表的结构 `wechat_user_info`
--

CREATE TABLE IF NOT EXISTS `wechat_user_info` (
`id` int(11) NOT NULL,
  `sys_user_id` int(11) DEFAULT NULL COMMENT '对应sysUser的id',
  `city` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `headimg_url` varchar(255) DEFAULT NULL COMMENT '标题URL',
  `language` varchar(255) DEFAULT NULL COMMENT '语言',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信的openid',
  `province` varchar(255) DEFAULT NULL COMMENT '微信中带过来的用户信息中的地区',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `subscribe` varchar(255) DEFAULT NULL COMMENT '是否订阅',
  `subscribe_time` datetime DEFAULT NULL COMMENT '订阅时间',
  `unsubscribe_time` datetime DEFAULT NULL COMMENT '取消订阅的时间',
  `public_account_id` int(11) DEFAULT NULL COMMENT '对应publicAccount的id',
  `wechat_open_id` varchar(255) DEFAULT NULL COMMENT '公众号订阅号原始id',
  `group_id` varchar(32) DEFAULT NULL COMMENT '用户组id'
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='微信交互日志表';

--
-- 转存表中的数据 `wechat_user_info`
--

INSERT INTO `wechat_user_info` (`id`, `sys_user_id`, `city`, `country`, `headimg_url`, `language`, `nick_name`, `open_id`, `province`, `sex`, `subscribe`, `subscribe_time`, `unsubscribe_time`, `public_account_id`, `wechat_open_id`, `group_id`) VALUES
(6, 1, NULL, NULL, NULL, NULL, NULL, 'oYU9BuOgn3mdq3RWqgV2I5xTR7EA', NULL, NULL, 'true', '2015-01-27 17:06:41', NULL, 1, 'gh_b046aecb765c', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `wechat_public_account`
--
ALTER TABLE `wechat_public_account`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wechat_req_msg_log`
--
ALTER TABLE `wechat_req_msg_log`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wechat_sys_log`
--
ALTER TABLE `wechat_sys_log`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wechat_sys_user`
--
ALTER TABLE `wechat_sys_user`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wechat_user_group`
--
ALTER TABLE `wechat_user_group`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wechat_user_info`
--
ALTER TABLE `wechat_user_info`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `wechat_public_account`
--
ALTER TABLE `wechat_public_account`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `wechat_req_msg_log`
--
ALTER TABLE `wechat_req_msg_log`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `wechat_sys_log`
--
ALTER TABLE `wechat_sys_log`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `wechat_sys_user`
--
ALTER TABLE `wechat_sys_user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `wechat_user_group`
--
ALTER TABLE `wechat_user_group`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `wechat_user_info`
--
ALTER TABLE `wechat_user_info`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
