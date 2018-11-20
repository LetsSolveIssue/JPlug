CREATE TABLE IF NOT EXISTS UserMaster (
  userId int(8) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  mailId varchar(40) NOT NULL,
  password varchar(15) NOT NULL,
  securityquestion varchar(50) NOT NULL,
  securityanswer varchar(100) NOT NULL,
  role int(1) NOT NULL,
  PRIMARY KEY (userId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
/
CREATE TABLE IF NOT EXISTS FolderMaster (
  folderId int(8) NOT NULL AUTO_INCREMENT,
  userId int(8) NOT NULL,
  folderName varchar(45) NOT NULL,
  folderPath varchar(500) NOT NULL,
  parentPath varchar(500) DEFAULT NULL,
  empty tinyint(1) NOT NULL,
  size int(8) NOT NULL,
  PRIMARY KEY (folderId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
/
CREATE TABLE IF NOT EXISTS Options (
  optionId int(8) NOT NULL AUTO_INCREMENT,
  optionKey varchar(200) NOT NULL,
  optionValue varchar(200) NOT NULL,
  userId int(8) NOT NULL,
  PRIMARY KEY (optionId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
/
CREATE TABLE IF NOT EXISTS PostMaster (
  postId int(8) NOT NULL AUTO_INCREMENT,
  postedBy int(8) NOT NULL,
  postTitle varchar(200) NOT NULL,
  postContents varchar(2000) NOT NULL,
  priority int(1) NOT NULL,
  datetime varchar(30) NOT NULL,
  postType int(1) NOT NULL,
  postStatus int(1) NOT NULL,
  userName varchar(20) NOT NULL,
  postCode varchar(2000) default NULL,
  PRIMARY KEY (postId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
/
CREATE TABLE IF NOT EXISTS PostMeta (
  postId int(8) NOT NULL,
  searchTag varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS postanswer (
  postId int(11) NOT NULL,
  postedBy varchar(30) NOT NULL,
  postDate varchar(30) NOT NULL,
  postTitle varchar(200) NOT NULL,
  postContent varchar(2000) NOT NULL,
  postCode varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
