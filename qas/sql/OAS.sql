--学生量化考核系统数据库设计
create user OAS identified by a;
grant dba to OAS;


--管理员表
create table manager(
       mId int primary key,
       mName varchar2(20) not null,
       mPwd varchar2(64) ,
       mEmail varchar2(20)
);
create sequence seq_manager_mId start with 4001;
insert into manager values(seq_manager_mId.nextval,'张三','123456','1393950470@qq.com');

--学生表
create table student(
       sNo int primary key,   --学号
       sName varchar2(20) not null,
       cId int,--班级id  
       sPwd varchar2(64) not null ,
       sEmail varchar2(20),
       timId varchar2(64),
       foreign key (cId) references classes(cId) on delete cascade 
       foreign key (timId) references timetable(timId) on delete cascade 
);

insert into student values(13480101,'张政',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13580101,'陈国志',1305,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com',''); 
insert into student values(13480102,'夏雨泽',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com',''); 
insert into student values(13480103,'苏荷',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480104,'蒋琪芳',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480105,'邓立程',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480106,' 蔡元培',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480107,' 谢永言',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480108,' 曾伟',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480109,' 马睿',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480110,' 吕兴平',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');
insert into student values(13480111,' 丁当',1306,'10470c3b4b1fed12c3baac014be15fac67c6e815','1393950470@qq.com','');



--教师表
create table teacher(
       tId int primary key,
       tName varchar2(20) not null,
       tPwd varchar2(64),
       tEmail varchar2(20)
);
create sequence seq_teacher_tId start with 3001;
insert into teacher values(seq_teacher_tId.nextval,'宋明达','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');
insert into teacher values(seq_teacher_tId.nextval,'陈子宏','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');
insert into teacher values(seq_teacher_tId.nextval,'周莹','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');
insert into teacher values(seq_teacher_tId.nextval,'苏欣然','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');
insert into teacher values(seq_teacher_tId.nextval,'王云','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');

--学生会
create table studentUnion(
       suId int primary key,
       suName varchar2(20) not null,
       suPwd varchar2(64),
       suEmail varchar2(20)
);
create sequence seq_studentUnion_suId start with 2001;
insert into studentUnion values(seq_studentUnion_suId.nextval,'王子成','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');
insert into studentUnion values(seq_studentUnion_suId.nextval,'唐杰','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');
insert into studentUnion values(seq_studentUnion_suId.nextval,'林雅静','10470c3b4b1fed12c3baac014be15fac67c6e815','3403302300@qq.com');

--班级信息表
create table classes(
       cId int primary key,
       cName varchar(20)
);
create sequence seq_classes_cId start with 1301;
insert into classes values(seq_classes_cId.nextval,'1301班');
insert into classes values(seq_classes_cId.nextval,'1302班');
insert into classes values(seq_classes_cId.nextval,'1303班');
insert into classes values(seq_classes_cId.nextval,'1304班');
insert into classes values(seq_classes_cId.nextval,'1305班');
insert into classes values(seq_classes_cId.nextval,'1306班');


--考核项目表
create table Quantization(
       qId int primary key,
       qName varchar2(200) not null,--加分或扣分项目名
       qScore number(5,2) --加分或扣分数值
);
create sequence seq_Quantization_qId start with 1; 

insert into Quantization values(seq_Quantization_qId.nextval,'全国科技竞赛一等奖',6);
insert into Quantization values(seq_Quantization_qId.nextval,'全国科技竞赛二等奖',4);
insert into Quantization values(seq_Quantization_qId.nextval,'全国科技竞赛鼓励奖',1);
insert into Quantization values(seq_Quantization_qId.nextval,'省级科技竞赛一等奖',4);
insert into Quantization values(seq_Quantization_qId.nextval,'省级科技竞赛二等奖',2);
insert into Quantization values(seq_Quantization_qId.nextval,'省级科技竞赛鼓励奖',0.5);
insert into Quantization values(seq_Quantization_qId.nextval,'校级科技竞赛一等奖',2);
insert into Quantization values(seq_Quantization_qId.nextval,'校级科技竞赛二等奖',1);
insert into Quantization values(seq_Quantization_qId.nextval,'校级科技竞赛鼓励奖',0.3);
insert into Quantization values(seq_Quantization_qId.nextval,'院级科技竞赛一等奖',1);
insert into Quantization values(seq_Quantization_qId.nextval,'院级科技竞赛二等奖',0.7);
insert into Quantization values(seq_Quantization_qId.nextval,'院级科技竞赛鼓励奖',0.1);

insert into Quantization values(seq_Quantization_qId.nextval,'全国论文一等奖',6);
insert into Quantization values(seq_Quantization_qId.nextval,'全国论文二等奖',4);
insert into Quantization values(seq_Quantization_qId.nextval,'全国论文鼓励奖',1);
insert into Quantization values(seq_Quantization_qId.nextval,'省级论文一等奖',4);
insert into Quantization values(seq_Quantization_qId.nextval,'省级论文二等奖',2);
insert into Quantization values(seq_Quantization_qId.nextval,'省级论文鼓励奖',0.5);
insert into Quantization values(seq_Quantization_qId.nextval,'校级论文一等奖',2);
insert into Quantization values(seq_Quantization_qId.nextval,'校级论文二等奖',1);
insert into Quantization values(seq_Quantization_qId.nextval,'校级论文鼓励奖',0.3);
insert into Quantization values(seq_Quantization_qId.nextval,'院级论文一等奖',1);
insert into Quantization values(seq_Quantization_qId.nextval,'院级论文二等奖',0.7);
insert into Quantization values(seq_Quantization_qId.nextval,'院级论文鼓励奖',0.1);

--学生考核记录表
create table appraise(
       sNo int ,
       qId int ,
       author varchar2(10),
       aTime date ,--记录时间
       primary key(sNo,qId),
       foreign key(sNo) references Student(sNo), 
       foreign key(qId) references Quantization(qId)
);
insert into appraise values(13480101,2,'王子成',sysdate);

--学科表
create table timetable(
	timId int primary key,
	timName varchar2(20)
);
create sequence seq_timetable_clid start with 1;
insert into timetable values(seq_timetable_clid.nextval,'数据库');
insert into timetable values(seq_timetable_clid.nextval,'高等数学');
insert into timetable values(seq_timetable_clid.nextval,'线性代数');
insert into timetable values(seq_timetable_clid.nextval,'概率与统计');
insert into timetable values(seq_timetable_clid.nextval,'数据结构');
insert into timetable values(seq_timetable_clid.nextval,'操作系统');
insert into timetable values(seq_timetable_clid.nextval,'计算机组成原理');
insert into timetable values(seq_timetable_clid.nextval,'通信原理');
insert into timetable values(seq_timetable_clid.nextval,'计算机网络');


--教师授课表
create table teaching(
	tId int,
	timId int,
	cId int,
	primary key(tId,timId,cId),
	foreign key(tId) references teacher(tId), 
	foreign key(timId) references timetable(timId), 
	foreign key(cId) references classes(cId)
)
insert into teaching values(3001,1,1305);
insert into teaching values(3001,1,1306);
insert into teaching values(3002,2,1301);
insert into teaching values(3002,2,1306);
insert into teaching values(3003,3,1302);
insert into teaching values(3003,3,1306);
insert into teaching values(3021,4,1303);
insert into teaching values(3021,4,1306);
insert into teaching values(3041,5,1304);
insert into teaching values(3041,5,1306);

--成绩表
create table score(
     sNo int , 
     timId int ,
     sGrade int ,
     sAuthor varchar2(20),
     sTime date ,
     primary key(sNo,timId),
     foreign key(sNo) references student(sNo),--用于取学生姓名，学号
     foreign key(timId) references timetable(timId)
);
insert into score values(13480101,1,86,'','');
insert into score values(13480101,2,78,'','');





 
