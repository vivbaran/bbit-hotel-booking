CREATE TABLE USER (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR(30) NOT NULL,
  LAST_NAME VARCHAR(30) NOT NULL,
  EMAIL VARCHAR(30) NOT NULL,
  PASSWORD VARCHAR(100) NOT NULL,
  MOBILE_NO VARCHAR(20) NOT NULL,
  ROLE VARCHAR(30) DEFAULT 0,
  CONSTRAINT USER_PK PRIMARY KEY (ID)
  )