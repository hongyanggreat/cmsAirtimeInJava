/*
Navicat MySQL Data Transfer

Source Server         : AirTime SV1 - 3303
Source Server Version : 50719
Source Host           : localhost:3303
Source Database       : htc_payment

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-03-14 11:18:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for artime_request
-- ----------------------------
DROP TABLE IF EXISTS `artime_request`;
CREATE TABLE `artime_request` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for artime_request_charge
-- ----------------------------
DROP TABLE IF EXISTS `artime_request_charge`;
CREATE TABLE `artime_request_charge` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for artime_request_otp
-- ----------------------------
DROP TABLE IF EXISTS `artime_request_otp`;
CREATE TABLE `artime_request_otp` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=514 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for artime_response
-- ----------------------------
DROP TABLE IF EXISTS `artime_response`;
CREATE TABLE `artime_response` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for charge_online
-- ----------------------------
DROP TABLE IF EXISTS `charge_online`;
CREATE TABLE `charge_online` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `ACCESS_KEY` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `MSISDN` varchar(127) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_AT` datetime DEFAULT NULL,
  `CREATE_BY` int(11) DEFAULT NULL,
  `UPDATE_AT` datetime DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  `OTP` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=353 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for charge_online_log
-- ----------------------------
DROP TABLE IF EXISTS `charge_online_log`;
CREATE TABLE `charge_online_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `ACCESS_KEY` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `MSISDN` varchar(127) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_AT` datetime DEFAULT NULL,
  `CREATE_BY` int(11) DEFAULT NULL,
  `UPDATE_AT` datetime DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  `OTP` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=327 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for migration
-- ----------------------------
DROP TABLE IF EXISTS `migration`;
CREATE TABLE `migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_9505_request
-- ----------------------------
DROP TABLE IF EXISTS `tbl_9505_request`;
CREATE TABLE `tbl_9505_request` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PHONE` varchar(15) DEFAULT NULL,
  `CP_CODE` varchar(255) DEFAULT NULL,
  `GAME_CODE` varchar(255) DEFAULT NULL,
  `ACCOUNT` varchar(30) DEFAULT NULL,
  `TOTAL_AMOUNT` int(127) DEFAULT NULL,
  `OTHER_INFO` varchar(1000) DEFAULT NULL,
  `REQUEST_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `RESULT_CODE` varchar(2) DEFAULT NULL,
  `DESCRIPTION` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_9505_response
-- ----------------------------
DROP TABLE IF EXISTS `tbl_9505_response`;
CREATE TABLE `tbl_9505_response` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQUEST_ID` varchar(50) DEFAULT NULL COMMENT 'REQUEST_ID ',
  `CP_CODE` varchar(5) DEFAULT NULL COMMENT 'cpCode ',
  `GAME_CODE` varchar(3) DEFAULT NULL COMMENT 'gameCode ',
  `ACCOUNT` varchar(127) DEFAULT NULL COMMENT 'account ',
  `PHONE` varchar(255) DEFAULT NULL COMMENT 'isdn ',
  `TOTAL_AMOUNT` int(20) DEFAULT NULL COMMENT 'totalAmount ',
  `REQUEST_TIME` varchar(255) DEFAULT '' COMMENT 'requestTime ',
  `SUMIT_TIME` datetime DEFAULT NULL,
  `PROVIDER` varchar(10) DEFAULT NULL COMMENT 'provider ',
  `CHANNEL` varchar(10) DEFAULT NULL COMMENT 'channel ',
  `RESULT_CODE` varchar(3) DEFAULT NULL COMMENT 'resultCode ',
  `OTHER_INFO` varchar(2000) DEFAULT NULL COMMENT 'otherInfo ',
  `DESCRIPTION` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_accounts
-- ----------------------------
DROP TABLE IF EXISTS `tbl_accounts`;
CREATE TABLE `tbl_accounts` (
  `ACC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PARENT_ID` int(11) DEFAULT NULL,
  `USERNAME` varchar(127) DEFAULT NULL COMMENT 'User name cho dich vu',
  `PASSWORD` varchar(127) DEFAULT NULL COMMENT 'Dung De Login cho Account rieng biet khong phu thuoc va Partner',
  `CP_CODE` varchar(127) DEFAULT NULL COMMENT 'Dung de Doi Soat',
  `FULL_NAME` varchar(127) DEFAULT NULL,
  `DESCRIPTION` varchar(511) DEFAULT NULL,
  `ADDRESS` varchar(511) DEFAULT NULL,
  `PHONE` varchar(127) DEFAULT NULL COMMENT 'Co the nhap 1 hoac nhieu so',
  `EMAIL` varchar(127) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `CREATE_BY` int(11) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(127) DEFAULT NULL,
  `USER_TYPE` tinyint(2) DEFAULT '0' COMMENT 'Is Admin or Sub (0 Default is Sub) 1: Admin ...',
  `STATUS` smallint(4) DEFAULT NULL,
  `OPTION_DATA` varchar(4000) DEFAULT NULL COMMENT 'cau truc du lieu Json Key - Value (true-false)',
  PRIMARY KEY (`ACC_ID`),
  UNIQUE KEY `UNIQUE_USERNAME` (`USERNAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_airtime_charge_resquest
-- ----------------------------
DROP TABLE IF EXISTS `tbl_airtime_charge_resquest`;
CREATE TABLE `tbl_airtime_charge_resquest` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_airtime_err_charge_req
-- ----------------------------
DROP TABLE IF EXISTS `tbl_airtime_err_charge_req`;
CREATE TABLE `tbl_airtime_err_charge_req` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=317 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_airtime_err_otp_req
-- ----------------------------
DROP TABLE IF EXISTS `tbl_airtime_err_otp_req`;
CREATE TABLE `tbl_airtime_err_otp_req` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=865 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_airtime_logs
-- ----------------------------
DROP TABLE IF EXISTS `tbl_airtime_logs`;
CREATE TABLE `tbl_airtime_logs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_airtime_otp_request
-- ----------------------------
DROP TABLE IF EXISTS `tbl_airtime_otp_request`;
CREATE TABLE `tbl_airtime_otp_request` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_airtime_request
-- ----------------------------
DROP TABLE IF EXISTS `tbl_airtime_request`;
CREATE TABLE `tbl_airtime_request` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=139 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_airtime_response
-- ----------------------------
DROP TABLE IF EXISTS `tbl_airtime_response`;
CREATE TABLE `tbl_airtime_response` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYS_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_REQUEST_ID` varchar(127) DEFAULT NULL,
  `CP_CODE` varchar(127) DEFAULT NULL,
  `USER_NAME` varchar(127) DEFAULT NULL,
  `GAME_CODE` varchar(127) DEFAULT NULL,
  `MSISDN` varchar(127) DEFAULT NULL,
  `PRICE` varchar(127) DEFAULT '',
  `OTP` varchar(127) DEFAULT NULL,
  `RS_MPS` varchar(127) DEFAULT NULL,
  `RS_AHP` varchar(127) DEFAULT NULL,
  `CHARGER_TIME` varchar(127) DEFAULT NULL COMMENT ' ',
  `SUB_SERVICE` varchar(127) DEFAULT NULL,
  `OTHER_INFO` varchar(4000) DEFAULT NULL COMMENT 'accesskey + signature + servicePin +otherInfo+ command + category + params +  content + ip + data + realTime',
  `REQUEST_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_articles
-- ----------------------------
DROP TABLE IF EXISTS `tbl_articles`;
CREATE TABLE `tbl_articles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) NOT NULL,
  `ALIAS` varchar(255) NOT NULL,
  `IMAGE` varchar(255) DEFAULT NULL,
  `CATE_ID` int(11) NOT NULL,
  `POSITION` int(11) DEFAULT NULL,
  `DESCRIPTION` text,
  `CONTENT` longtext,
  `STATUS` int(11) NOT NULL DEFAULT '1',
  `TAG` varchar(255) DEFAULT NULL,
  `META_KEYWORD` varchar(255) DEFAULT NULL,
  `VIEW` int(11) DEFAULT '0',
  `CREATED_BY` int(11) NOT NULL,
  `CREATED_AT` int(11) NOT NULL,
  `UPDATED_AT` int(11) DEFAULT NULL,
  `UPDATED_BY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_cardcharging_response
-- ----------------------------
DROP TABLE IF EXISTS `tbl_cardcharging_response`;
CREATE TABLE `tbl_cardcharging_response` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQUEST_ID` int(11) NOT NULL,
  `TRAND_ID` varchar(255) NOT NULL,
  `SYS_ID` varchar(255) NOT NULL,
  `CP_CODE` varchar(255) NOT NULL,
  `CP_USER` varchar(127) NOT NULL,
  `SERIAL_NO` varchar(255) NOT NULL,
  `CARD_CODE` varchar(255) NOT NULL,
  `AMOUNT` int(255) NOT NULL,
  `SUBMIT_TIME` int(11) NOT NULL,
  `RESPONSE_TIME` bigint(18) NOT NULL,
  `LOG_TIME` bigint(18) NOT NULL,
  `PR_RESULT` varchar(255) NOT NULL,
  `PR_DESC` varchar(1024) NOT NULL,
  `GATE_WAY` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_group_account
-- ----------------------------
DROP TABLE IF EXISTS `tbl_group_account`;
CREATE TABLE `tbl_group_account` (
  `GROUP_ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(127) NOT NULL,
  `MODULE_ID` varchar(255) NOT NULL DEFAULT 'all_module',
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `CREATE_DATE` int(11) NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `UPDATE_DATE` int(11) DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  `STATUS` tinyint(2) NOT NULL,
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_group_acc_detail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_group_acc_detail`;
CREATE TABLE `tbl_group_acc_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACC_ID` varchar(255) NOT NULL,
  `GROUP_ID` int(11) NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `CREATE_DATE` int(11) NOT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  `UPDATE_DATE` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_group_permission
-- ----------------------------
DROP TABLE IF EXISTS `tbl_group_permission`;
CREATE TABLE `tbl_group_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` int(11) NOT NULL,
  `MODULE_ID` int(11) NOT NULL,
  `ACC_ID` varchar(255) DEFAULT NULL,
  `STATUS` tinyint(4) NOT NULL,
  `ALL_RIGHT` bit(1) DEFAULT b'0',
  `LIST_RIGHT` bit(1) DEFAULT NULL,
  `VIEW_RIGHT` bit(1) DEFAULT b'0',
  `ADD_RIGHT` bit(1) DEFAULT b'0',
  `EDIT_RIGHT` bit(1) DEFAULT b'0',
  `DEL_RIGHT` bit(1) DEFAULT b'0',
  `UP_RIGHT` bit(1) DEFAULT NULL COMMENT 'up load ',
  `DOWN_RIGHT` bit(1) DEFAULT NULL COMMENT 'Down load',
  `DESCRIPTION` varchar(511) DEFAULT NULL,
  `CREATE_DATE` int(11) NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `UPDATE_DATE` int(11) DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_modules
-- ----------------------------
DROP TABLE IF EXISTS `tbl_modules`;
CREATE TABLE `tbl_modules` (
  `MODULE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RESOURCE` varchar(1023) NOT NULL,
  `NAME` varchar(511) NOT NULL,
  `DESCRIPTION` varchar(511) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  `TYPE` int(1) NOT NULL COMMENT '0: Admin 1: user',
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`MODULE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_provider
-- ----------------------------
DROP TABLE IF EXISTS `tbl_provider`;
CREATE TABLE `tbl_provider` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `POS` int(11) DEFAULT NULL,
  `CODE` varchar(127) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `CLASS_SEND` varchar(512) NOT NULL,
  `PROVIDER_OPTIONS` varchar(2000) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_service
-- ----------------------------
DROP TABLE IF EXISTS `tbl_service`;
CREATE TABLE `tbl_service` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `ALIAS` varchar(255) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  `DESCRIPTION` varchar(511) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_permission`;
CREATE TABLE `tbl_user_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACC_ID` int(11) NOT NULL,
  `MODULE_ID` int(11) NOT NULL,
  `ALL_RIGHT` bit(1) DEFAULT NULL,
  `LIST_RIGHT` bit(1) DEFAULT NULL,
  `VIEW_RIGHT` bit(1) DEFAULT NULL,
  `ADD_RIGHT` bit(1) DEFAULT NULL,
  `EDIT_RIGHT` bit(1) DEFAULT NULL,
  `DEL_RIGHT` bit(1) DEFAULT NULL,
  `UP_RIGHT` bit(1) DEFAULT NULL,
  `DOWN_RIGHT` bit(1) DEFAULT NULL,
  `DESCRIPTION` varchar(511) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  `STATUS` tinyint(4) NOT NULL,
  `IS_RIGHT` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_user_service
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_service`;
CREATE TABLE `tbl_user_service` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CP_CODE` varchar(10) NOT NULL,
  `GAME_NAME` varchar(255) DEFAULT NULL,
  `CODE_GAME` varchar(10) NOT NULL,
  `USERNAME` varchar(127) NOT NULL,
  `SERVICE_PIN` varchar(127) NOT NULL,
  `ACCESS_KEY` varchar(255) DEFAULT NULL,
  `SECRET_KEY` varchar(255) DEFAULT NULL,
  `SERVICE_TYPE` int(11) NOT NULL COMMENT 'AirTime,9029,6x88 ...9055',
  `URL_CALLBACK` varchar(500) DEFAULT NULL,
  `IP_ALLOW` varchar(2000) DEFAULT NULL,
  `ROUTE_TABLE` varchar(4000) DEFAULT NULL,
  `OPTION_DATA` varchar(2000) DEFAULT NULL,
  `DESCRIPTION` varchar(511) DEFAULT NULL,
  `STATUS` int(11) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
DROP TRIGGER IF EXISTS `trigger_name`;
DELIMITER ;;
CREATE TRIGGER `trigger_name` AFTER DELETE ON `charge_online` FOR EACH ROW BEGIN

   INSERT INTO charge_online_log
   ( USER_NAME,
     CP_CODE,
     GAME_CODE,
			ACCESS_KEY,
			PRICE,
			MSISDN,
			STATUS,
			CREATE_AT,
			CREATE_BY
	)
   VALUES
   ( 
	OLD.USER_NAME,
	OLD.CP_CODE,
	OLD.GAME_CODE,
	OLD.ACCESS_KEY,
	OLD.PRICE,
	OLD.MSISDN,
	OLD.STATUS,
	OLD.CREATE_AT,
	OLD.CREATE_BY
	);

END
;;
DELIMITER ;
