--角色信息
create table roles(
       rid number(10) primary key,  --角色编号
       rname varchar2(100) not null unique,--角色名称
       mark varchar2(200),
       status number(2)
);
--角色序列
create sequence seq_roles_cid start with 1001;

insert into roles values(seq_roles_cid.nextval,'超级管理员','管理所有',1);
select * from adminInfo
commit;
--后台管理员信息表
create table adminInfo(
       aid number(10) primary key,--用户登录
       aname varchar2(100),--管理员姓名
       pwd varchar2(20),
       rid number(10) constraints FK_roles_rid references roles(rid),  --角色编号
       email varchar2(100) unique, --邮箱
	   tel varchar2(15),
       photo varchar2(400),
       status number(2),  --0 和 1   0表示为审核 1是审核未通过  2 已审核   3 冻结
       mark varchar2(400)
);
insert into adminInfo values(seq_adminInfo_sid.nextval,'张三','a',1001,'398239397@qq.com',null,null,2,null);
commit

create view adminInfos as select a.*,rname from adminInfo a,roles r where a.rid=r.rid;
--后台管理员序列
create sequence seq_adminInfo_sid start with 1001;




--用户表
create table userInfo(
       uid number(10) primary key,  --会员
       uname varchar2(100) not null unique,--登录名
       relname varchar2(100),--真实姓名
       pwd varchar2(20) not null,--密码
       tel varchar2(20) unique,--电话
       email varchar2(15) unique,--邮箱
       photo varchar2(200),--图片
       prov varchar2(100),--省份
       city varchar2(100),--城市
       area varchar2(100),--地区
       grande number(10,2),--积分
       status number(2)
       
);
--用户表序列

create sequence seq_userInfo_uid start with 1001;

--商品类型
create table goodstype(
       tid number(10) primary key,
       tname varchar2(100) not null unique,
       des varchar2(200), --描述
       status number(2) --类型状态
);
--商品序列
create sequence seq_goodstype_tid start with 1001;

--店铺信息

create table shopping(
       spid number(20) primary key,--店铺编号
       sname varchar2(200),--店铺名称
       aid number(10) --商家编号
            constraints FK_shopping_adminIno_aid references adminInfo(aid), 
       tid number(10) --类型
            constraints FK_shopping_goodstype_tid references goodstype(tid), 
        prov varchar2(100),--省份
       city varchar2(100),--城市
       area varchar2(100),--地区
       points varchar2(400),--详细地址
       tel varchar2(15),--联系方式
       info clob,--店铺信息
       status number(2)--状态
);          
create sequence seq_shopping_spid start with 1001;
--商品表
create table goods(
       gid number(20) primary key ,--商品编号
       gname varchar2(200),-- 商品名称
       des varchar2(200),--描述
       price number(10,8),--商品原价
       pic varchar2(2000),--商品展示的图片
       status number(2)--商品状态
       spid number(10) --商家编号
            constraints FK_goods_shopping_spid references shopping(spid), 
);
--活动表
create table goodsAction(
       gaid number(10) primary key,--活动编号
       gid number(20)--商品id
            constraints FK_goodsAction_goods_gid references adminInfo(gid), 
       aprice number(10,2),--活动价格
       personnum number(2),--几人餐
       title varchar2(200),--活动标题
       startdate date,--活动开始时间
       startend date,--活动结束时间
       tishi varchar2(400),--温馨提示
       content clob--活动介绍
);
create sequence seq_goodsAction_gaid start with 1001;
--消息表
create table message(
       mid number(10) primary key ,
       title varchar2(200),--消息标题
       content varchar2(4000),--消息内容
       mdate date--时间
);
create sequence seq_message_mid start with 1001;

create table orders(
       oid varchar2(200) primary key,
       odate date, --订单时间
       usid number(10)  --用户id
            constraints FK_orders_userInfo_usid references userInfo(usid),
        gaid number(10) --类型id
            constraints FK_orders_goodstype_gaid references goodsAction(gaid),
        nums number(10),--数量
        totalprice number(10,8),--总金额
        status number(2)--状态
);
select * from adminInfo where aname='张三' and pwd='a' and status=2 and rid=1001;
update adminInfo set photo='images/userPic.PNG' where aname='张三';
