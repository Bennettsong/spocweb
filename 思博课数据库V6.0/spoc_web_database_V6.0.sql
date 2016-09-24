/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.6.10 : Database - spoc_web
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spoc_web` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spoc_web`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户权限编号',
  `usertype` varchar(20) DEFAULT NULL COMMENT '用户类型（值为1为管理员，2为普通用户）',
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户权限关系表';

/*Data for the table `admin` */

insert  into `admin`(`adminid`,`usertype`) values (1,'管理员'),(2,'普通用户');

/*Table structure for table `affair` */

DROP TABLE IF EXISTS `affair`;

CREATE TABLE `affair` (
  `aff_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `name` varchar(20) DEFAULT NULL COMMENT '联系人姓名',
  `phone` varchar(15) DEFAULT NULL COMMENT '联系人手机号',
  `content` varchar(1000) DEFAULT NULL COMMENT '具体内容',
  `flag` tinyint(1) DEFAULT NULL COMMENT '是否被处理',
  `doc` varchar(100) DEFAULT NULL COMMENT '附件路径',
  `type` varchar(50) DEFAULT NULL COMMENT '业务类别',
  `loginid` varchar(20) DEFAULT NULL COMMENT '审核业务的管理员',
  PRIMARY KEY (`aff_id`),
  KEY `adminid` (`loginid`),
  KEY `ccid` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='业务关系表';

/*Data for the table `affair` */

insert  into `affair`(`aff_id`,`name`,`phone`,`content`,`flag`,`doc`,`type`,`loginid`) values (1,'张三 ','18767545676',' 拍摄一部宣传片',0,'..infor/selfie/1.jpg','微课慕课',NULL);

/*Table structure for table `affair_category` */

DROP TABLE IF EXISTS `affair_category`;

CREATE TABLE `affair_category` (
  `acid` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务类别编号',
  `name` varchar(50) DEFAULT NULL COMMENT '业务类别名称',
  `flag` int(11) NOT NULL COMMENT '业务类别是否已经运行（0代表运行，1代表没有运行）',
  PRIMARY KEY (`acid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `affair_category` */

insert  into `affair_category`(`acid`,`name`,`flag`) values (1,'微课慕课',0),(2,'广告制作',0),(3,'宣传视频',0),(4,'行业软件',0),(5,'商业活动软件',0),(6,'英语翻译',0),(7,'VR视频',1),(8,'VR游戏',1),(9,'游戏软件',1);

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报名编号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `college` varchar(50) DEFAULT NULL COMMENT '学院',
  `grade` varchar(20) DEFAULT NULL COMMENT '年级',
  `major` varchar(50) DEFAULT NULL COMMENT '专业',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `grouptype` varchar(20) DEFAULT NULL COMMENT '组别',
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报名关系表';

/*Data for the table `apply` */

/*Table structure for table `charge_standard` */

DROP TABLE IF EXISTS `charge_standard`;

CREATE TABLE `charge_standard` (
  `csid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收费标准编号',
  `basic` varchar(20) DEFAULT NULL COMMENT '基础版',
  `advance` varchar(20) DEFAULT NULL COMMENT '进阶版',
  `careless` varchar(20) DEFAULT NULL COMMENT '无忧版',
  `acid` int(11) DEFAULT NULL COMMENT '业务类别编号',
  `tcid` int(11) DEFAULT NULL COMMENT '类型分类编号',
  PRIMARY KEY (`csid`),
  KEY `charge_standard_ibfk_1` (`acid`),
  KEY `charge_standard_ibfk_3` (`tcid`),
  CONSTRAINT `charge_standard_ibfk_3` FOREIGN KEY (`tcid`) REFERENCES `type_category` (`tcid`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `charge_standard_ibfk_1` FOREIGN KEY (`acid`) REFERENCES `affair_category` (`acid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `charge_standard` */

insert  into `charge_standard`(`csid`,`basic`,`advance`,`careless`,`acid`,`tcid`) values (1,'无','20张','50张',1,1),(4,'简易','炫酷','特效',1,6),(7,'20分钟','1小时','5小时',2,8);

/*Table structure for table `college` */

DROP TABLE IF EXISTS `college`;

CREATE TABLE `college` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院编号',
  `name` varchar(50) DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `college` */

insert  into `college`(`cid`,`name`) values (1,'农学院'),(2,'园艺园林学院'),(3,'植物保护学院'),(4,'动物科学技术学院'),(5,'动物医学院'),(6,'食品科学技术学院'),(7,'工学院'),(8,'资源环境学院'),(9,'理学院'),(10,'经济学院'),(11,'商学院'),(12,'公共管理与法学学院'),(13,'马克思主义学院'),(14,'外国语学院'),(15,'信息科学技术学院'),(16,'教育学院'),(17,'生物科学技术学院'),(18,'体育艺术学院'),(19,'国际学院'),(20,'继续教育学院'),(21,'东方科技学院');

/*Table structure for table `group_manage` */

DROP TABLE IF EXISTS `group_manage`;

CREATE TABLE `group_manage` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '小组编号',
  `name` varchar(20) NOT NULL COMMENT '组名',
  `description` varchar(200) DEFAULT NULL COMMENT '组描述',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `group_manage` */

insert  into `group_manage`(`gid`,`name`,`description`) values (1,'摄影组',NULL),(2,'平面设计组',NULL),(3,'特效组',NULL),(4,'程序组',NULL);

/*Table structure for table `honor` */

DROP TABLE IF EXISTS `honor`;

CREATE TABLE `honor` (
  `hid` int(11) NOT NULL AUTO_INCREMENT COMMENT '荣誉编号',
  `time` date DEFAULT NULL COMMENT '获奖时间',
  `img` varchar(100) DEFAULT NULL COMMENT '荣誉照片路径',
  `description` varchar(200) DEFAULT NULL COMMENT '荣誉介绍',
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='荣誉关系表';

/*Data for the table `honor` */

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `loginid` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `img` varchar(100) DEFAULT NULL COMMENT '照片路径',
  `date` date DEFAULT NULL COMMENT '出生年月',
  `college` varchar(100) DEFAULT NULL COMMENT '学院',
  `grade` varchar(20) DEFAULT NULL COMMENT '年级',
  `major` varchar(100) DEFAULT NULL COMMENT '专业',
  `qq` varchar(15) DEFAULT NULL COMMENT 'QQ',
  `phone` varchar(15) NOT NULL COMMENT '手机号',
  `address` varchar(60) DEFAULT NULL COMMENT '家庭住址',
  `introduction` varchar(600) DEFAULT NULL COMMENT '自我介绍',
  `job` varchar(400) DEFAULT NULL COMMENT '就业情况',
  `flag` varchar(20) DEFAULT NULL COMMENT '身份标识（表明老师还是学生）',
  `adminid` int(11) DEFAULT NULL COMMENT '用户权限',
  PRIMARY KEY (`loginid`),
  KEY `adminid` (`adminid`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`adminid`) REFERENCES `admin` (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生关系表';

/*Data for the table `member` */

/*Table structure for table `member_group` */

DROP TABLE IF EXISTS `member_group`;

CREATE TABLE `member_group` (
  `lgid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员小组编号',
  `loginid` varchar(20) DEFAULT NULL COMMENT '成员编号',
  `gid` int(11) DEFAULT NULL COMMENT '小组编号',
  PRIMARY KEY (`lgid`),
  KEY `sid` (`loginid`),
  KEY `gid` (`gid`),
  CONSTRAINT `member_group_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `group_manage` (`gid`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `member_group_ibfk_1` FOREIGN KEY (`loginid`) REFERENCES `member` (`loginid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生小组关系表';

/*Data for the table `member_group` */

/*Table structure for table `member_honor` */

DROP TABLE IF EXISTS `member_honor`;

CREATE TABLE `member_honor` (
  `lhid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员荣誉编号',
  `lid` varchar(20) DEFAULT NULL COMMENT '成员编号',
  `hid` int(11) DEFAULT NULL COMMENT '荣誉编号',
  PRIMARY KEY (`lhid`),
  KEY `lid` (`lid`),
  KEY `hid` (`hid`),
  CONSTRAINT `member_honor_ibfk_1` FOREIGN KEY (`lid`) REFERENCES `member` (`loginid`),
  CONSTRAINT `member_honor_ibfk_2` FOREIGN KEY (`hid`) REFERENCES `honor` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_honor` */

/*Table structure for table `member_product` */

DROP TABLE IF EXISTS `member_product`;

CREATE TABLE `member_product` (
  `lpid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员作品编号',
  `lid` varchar(20) DEFAULT NULL COMMENT '成员编号',
  `pid` int(11) DEFAULT NULL COMMENT '作品编号',
  PRIMARY KEY (`lpid`),
  KEY `sid` (`lid`),
  KEY `pid` (`pid`),
  CONSTRAINT `member_product_ibfk_1` FOREIGN KEY (`lid`) REFERENCES `member` (`loginid`),
  CONSTRAINT `member_product_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生作品关系表';

/*Data for the table `member_product` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '作品编号',
  `name` varchar(20) NOT NULL COMMENT '作品名称',
  `time` date DEFAULT NULL COMMENT '作品时间',
  `description` varchar(200) DEFAULT NULL COMMENT '作品介绍',
  `pro_path` varchar(100) NOT NULL COMMENT '作品路径',
  `img_path` varchar(100) DEFAULT NULL COMMENT '作品缩略图路径',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作品关系表';

/*Data for the table `product` */

/*Table structure for table `service_type` */

DROP TABLE IF EXISTS `service_type`;

CREATE TABLE `service_type` (
  `stid` int(11) NOT NULL AUTO_INCREMENT COMMENT '服务类型编号',
  `type` varchar(100) DEFAULT NULL COMMENT '服务类型',
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `service_type` */

insert  into `service_type`(`stid`,`type`) values (1,'美工类'),(2,'特效类'),(3,'拍摄类'),(4,'视频剪辑类'),(5,'动画类'),(6,'声音类'),(7,'其他');

/*Table structure for table `type_category` */

DROP TABLE IF EXISTS `type_category`;

CREATE TABLE `type_category` (
  `tcid` int(11) NOT NULL AUTO_INCREMENT COMMENT '服务分类编号',
  `description` varchar(100) DEFAULT NULL COMMENT '分类描述',
  `stid` int(11) DEFAULT NULL COMMENT '服务类型编号',
  PRIMARY KEY (`tcid`),
  KEY `type_category_ibfk_1` (`stid`),
  CONSTRAINT `type_category_ibfk_1` FOREIGN KEY (`stid`) REFERENCES `service_type` (`stid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `type_category` */

insert  into `type_category`(`tcid`,`description`,`stid`) values (1,'PPT模板',1),(2,'素材采集',1),(3,'图片处理',1),(4,'展示特效',2),(5,'字幕特效',2),(6,'片头',2),(7,'片尾',2),(8,'室内拍摄',3),(9,'室外拍摄',3),(10,'无人机拍摄',3),(11,'录屏',4),(12,'剪辑',4),(13,'视频字幕',4),(14,'2D动画',5),(15,'3D动画',5),(16,'网页动画',5),(17,'音频去噪',6),(18,'背景音乐',6),(19,'音效',6),(20,'魔音',6),(21,'配音',6),(22,'视频时长',7),(23,'策划设计',7),(24,'演员',7);

/*Table structure for table `affairs` */

DROP TABLE IF EXISTS `affairs`;

/*!50001 DROP VIEW IF EXISTS `affairs` */;
/*!50001 DROP TABLE IF EXISTS `affairs` */;

/*!50001 CREATE TABLE  `affairs`(
 `category` varchar(50) ,
 `service_type` varchar(100) ,
 `description` varchar(100) ,
 `basic` varchar(20) ,
 `advance` varchar(20) ,
 `careless` varchar(20) 
)*/;

/*Table structure for table `member_group_view` */

DROP TABLE IF EXISTS `member_group_view`;

/*!50001 DROP VIEW IF EXISTS `member_group_view` */;
/*!50001 DROP TABLE IF EXISTS `member_group_view` */;

/*!50001 CREATE TABLE  `member_group_view`(
 `lgid` int(11) ,
 `loginid` varchar(20) ,
 `gid` int(11) ,
 `name` varchar(20) 
)*/;

/*View structure for view affairs */

/*!50001 DROP TABLE IF EXISTS `affairs` */;
/*!50001 DROP VIEW IF EXISTS `affairs` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `affairs` AS select `affair_category`.`name` AS `category`,`service_type`.`type` AS `service_type`,`type_category`.`description` AS `description`,`charge_standard`.`basic` AS `basic`,`charge_standard`.`advance` AS `advance`,`charge_standard`.`careless` AS `careless` from (((`affair_category` join `service_type`) join `type_category`) join `charge_standard`) where ((`charge_standard`.`acid` = `affair_category`.`acid`) and (`charge_standard`.`tcid` = `type_category`.`tcid`) and (`type_category`.`stid` = `service_type`.`stid`)) */;

/*View structure for view member_group_view */

/*!50001 DROP TABLE IF EXISTS `member_group_view` */;
/*!50001 DROP VIEW IF EXISTS `member_group_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `member_group_view` AS select `member_group`.`lgid` AS `lgid`,`member_group`.`loginid` AS `loginid`,`member_group`.`gid` AS `gid`,`group_manage`.`name` AS `name` from (`member_group` join `group_manage`) where (`member_group`.`gid` = `group_manage`.`gid`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
