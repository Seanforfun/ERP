-- Table "tbl_deptmodel" DDL

CREATE TABLE `tbl_deptmodel` (
  `uuid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `tele` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Table "tbl_emp_role" DDL

CREATE TABLE `tbl_emp_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empuuid` bigint(20) NOT NULL,
  `roleuuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- Table "tbl_empmodel" DDL

CREATE TABLE `tbl_empmodel` (
  `uuid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tele` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `birthday` bigint(20) DEFAULT NULL,
  `deptuuid` bigint(20) DEFAULT NULL,
  `lastLoginTime` bigint(20) NOT NULL,
  `lastLoginIp` varchar(255) NOT NULL,
  `loginTimes` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Table "tbl_goods" DDL

CREATE TABLE `tbl_goods` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `origin` varchar(30) NOT NULL,
  `producer` varchar(30) NOT NULL,
  `unit` varchar(30) NOT NULL,
  `inprice` double NOT NULL,
  `outprice` double NOT NULL,
  `goodsTypeuuid` bigint(20) NOT NULL,
  `useNum` int(11) NOT NULL,
  `minNum` int(11) NOT NULL,
  `maxNum` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Table "tbl_goodstype" DDL

CREATE TABLE `tbl_goodstype` (
  `UUID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `supplierUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Table "tbl_menumodel" DDL

CREATE TABLE `tbl_menumodel` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `url` varchar(255) NOT NULL,
  `puuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=707 DEFAULT CHARSET=utf8;

-- Table "tbl_operdetail" DDL

CREATE TABLE `tbl_operdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `operTime` bigint(20) NOT NULL,
  `type` int(1) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `storeUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Table "tbl_order" DDL

CREATE TABLE `tbl_order` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(30) NOT NULL,
  `creator` bigint(20) NOT NULL,
  `createTime` bigint(20) NOT NULL,
  `checker` bigint(20) DEFAULT NULL,
  `checkTime` bigint(20) DEFAULT NULL,
  `completer` bigint(20) DEFAULT NULL,
  `endTime` bigint(20) DEFAULT NULL,
  `ordertype` int(1) NOT NULL,
  `type` int(3) NOT NULL,
  `totalNum` int(11) NOT NULL,
  `totalPrice` double(10,2) NOT NULL,
  `supplierUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Table "tbl_orderdetail" DDL

CREATE TABLE `tbl_orderdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  `price` double(10,2) NOT NULL,
  `orderUuid` bigint(20) NOT NULL,
  `surplus` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- Table "tbl_resourcesmodel" DDL

CREATE TABLE `tbl_resourcesmodel` (
  `UUID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Table "tbl_role_menu" DDL

CREATE TABLE `tbl_role_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleuuid` bigint(20) NOT NULL,
  `menuuuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- Table "tbl_role_resources" DDL

CREATE TABLE `tbl_role_resources` (
  `UUID` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleuuid` bigint(20) NOT NULL,
  `resourcesuuid` bigint(20) NOT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- Table "tbl_rolemodel" DDL

CREATE TABLE `tbl_rolemodel` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Table "tbl_store" DDL

CREATE TABLE `tbl_store` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `empUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Table "tbl_storedetail" DDL

CREATE TABLE `tbl_storedetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `storeUuid` bigint(20) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


-- Table "tbl_suppliermodel" DDL

CREATE TABLE `tbl_suppliermodel` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `needs` int(1) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
