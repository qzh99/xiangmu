--角色信息表
create table roleinfo(
       rid number(10) primary key,            --角色编号
       rname varchar2(100) not null unique,   --角色名称
       mark varchar2(200),                    --角色描述
       status number(2)                       --状态
)
select * from roleinfo where rid = rid;
delete from roleinfo where rid=1022
delete from roleinfo where rid in(1024,1025)
insert into roleinfo values(seq_roles_id.nextval,'超级管理员','管理所有角色',1);
commit;


--角色表的序列
create sequence seq_roles_id start with 1001;

--后台管理员信息表
create table adminInfo(
       aid number(10) primary key,      --管理员编号
       aname varchar2(100),             --管理员姓名
       pwd varchar2(100),               --密码
       rid number(10)                   
           constraints FK_admininfo_rid references roleinfo(rid),
       email varchar2(100) unique,      --注册邮箱：没有做 非空判断
       tel varchar2(15),                --练习方式
       photo varchar2(400),             --图像
       status number(2)                 --0：未审核，1：审核未通过，2：已审核可以正常登录，3：冻结
)
--后台管理员信息表的序列
create sequence seq_admininfo_aid start with 1001;

select * from adminInfo where aname=aname and pwd=pwd;
select aid from admininfo where 1=1 and rid=1037
select * from admininfo a,roleinfo b where a.rid=b.rid and aid=1047;
select a.*,b.rname,b.mark from admininfo a,roleinfo b where a.rid=b.rid
update admininfo set aid=aid,pwd=2016 where email=1261834439@qq.com
insert into admininfo values(seq_admininfo_aid.nextval,'喻辉','001','1037','398239397@qq.com','110','',2);
select * from admininfos where aid=1001 and pwd=001 and status=2 and rid = 1001
commit;

--前台注册用户
create table userinfo(
       userid number primary key,                  --会员编号
       username varchar2(100) not null unique,     --昵称
       realname varchar2(100),                     --真实姓名
       pwd varchar2(100),                          --加密之后的密码
       tel varchar2(15) not null unique,           --手机号码
       photo varchar2(400),                        --图像
       province varchar2(100),                     --省份
       city varchar2(100),                         --城市
       area varchar2(100),                         --地区
       credit number(10),                          --积分
       status number(2)                            --状态
)
create sequence seq_userinfo_userid start with 1001;

select * from userinfo;
truncate table userInfo
delete userinfo where userid=1012;
commit;

--商品类型
create table goodstype(
        tid number(10) primary key,                 --类型编号
        tname varchar2(100) not null unique,       --类型名称
        discribe varchar2(200),                    --类型描述
        status number(2)                           --类型状态
)
create sequence seq_goodstype_tid start with 1001;
select * from goodstype

--商店信息
create table shopstore(
       ssid number(20) primary key,                --店铺编号
       sname varchar2(200),                        --店铺名称
       aid number(10)                              --商家编号
           constraints FK_shopstore_aid references admininfo(aid),
       tid number(10)                              --店铺类型
           constraints FK_shopstore_tid references goodstype(tid),
       province varchar2(100),                     --省份
       city varchar2(100),                         --城市
       area varchar2(100),                         --地区
       points varchar2(400),                       --详细地址
       tel varchar2(50),                           --联系方式
       info clob,                                  --店铺信息
       --date date,                                  --商店的注册日期，也就是核审通过的日期
       status number(2)                            
)
create sequence seq_shopstore_ssid start with 1001;
select * from shopstore;
delete from shopstore where ssid=1001
select a.*,b.aname,c.tname from shopstore a,admininfo b,goodstype c where a.aid=b.aid and a.tid=c.tid
--商品信息表
create table wowogoods(
       gid number(10) primary key,                 --商品编号
       gname varchar2(200),                        --名称
       discribe varchar2(200),                     --商品描述
       price number(10,8),                         --原价
       tid number(10)
           constraints FK_wowogoods_tid references goodstype(tid),
       pic varchar2(2000),                         --商品展示的图片
       status number(2),
       ssid number(20)
            constraints FK_wowogoods_ssid references shopstore(ssid)
);
select * from wowogoods;
select * from goodstype order by tid desc
--自定义商品信息表
create table wowogoods(
       goodsid number(10) primary key,               --商品编号，主键
       shop number(20) references shopping(spid),  --属于哪一个商店的
       goodstype number(10) references goodstype(tid),--商品的类型
       tag varchar2(20),                             --标签，是否可预约
       title varchar2(100),                          --标题：也算是商品名
       mark varchar2(100),                           --简单描述
       wowoprice number(10,2),                        --窝窝价
       price number(10,2),                            --原价
       pic varchar2(2000)                           --商品图片
);
---------
select * from (select a.*,rownum rn from (select * from goodstype order by tid desc) a where rownum<=5) where rn>0


select i.title,i.mark,i.pic,i.wowoprice,i.price,i.tag,j.sname,j.area from wowogoods i,shopstore j where i.shop=j.ssid and goodstype=1001 and gname like %海南% and sname like %零食%
--要在前台显示要查出一下字段：title mark sname area tag pic wowoprice price 地区和商店名在商店表里面，其他的都在自己表里面
select i.title,i.mark,i.pic,i.wowoprice,i.price,i.tag,j.sname,j.area from wowogoods i,shopstore j where i.shop=j.ssid;
select i.*,j.sname,k.tname from wowogoods i,shopstore j,goodstype k where i.shop=j.ssid and i.goodstype=k.tid
insert into wowogoods values(seq_wowogoods_goodsid.nextval,1002,1001,'','','',20,10,'')
create sequence seq_wowogoods_goodsid start with 100000;
drop table wowogoods
delete from wowogoods where goodsid=100060;
commit;
select * from wowogoods
--商品活动表
create table goodsdiscount(
       gdid number(10) primary key,                
       gid number(10)
           constraints FK_goodsdiscount_gid references goods(gid),
       gdprice number(10,2),                       --活动价格
       personnum number(2),                        --几人餐
       title varchar2(200),                        --活动标题
       startdate date,                             --活动开始日期
       enddate date,                               --活动结束日期
       presentation varchar2(4000),                --温馨提示
       content clob                                --活动介绍
)
create sequence seq_goodsdiscount_gdid start with 1001;

--消息表
create table message(
       mid number(10) primary key,                --消息编号
       aid number(10)
           constraints FK_message_aid references admininfo(aid),
       title varchar2(200),                       --消息标题
       content varchar2(4000),                    --消息内容
       mdate date                                 --消息时间
)
create sequence seq_message_mid start with 1001;

--订单表
create table orders(
       oid number(20) primary key,             --订单编号
       odate date,                                --订单日期
       userid number(10) references userinfo(userid) not null,--会员编号
       gid number(10) references goods(gid) not null,--商品编号
       num number(10),                           --订单数量
       totalprice number(10,8),                   --总额
       status number(2)                           
);
commit;
select * from orders;
drop table orders;
create sequence seq_orders_oid start with 1001;
--赋予scott用户创建视图的权限
grant create view to scott;
--创建一个管理员视图
create view admininfos as select a.*,rname from admininfo a,roleinfo r where a.rid=r.rid;

--商品的详细信息表
create table details(
       did number(10) primary key,         --主键，
       goodsid number(10) references wowogoods(goodsid) unique,--外键，属于那一个商品的详细信息
       validatedate varchar2(100),                  --截止日期
       num varchar2(100),                  --限购数量，用文字表述
       userule varchar2(100),              --使用规则，文字表述
       isbooked varchar2(50),              --是否预约
       other varchar(2000),                --其他提示
       photo varchar2(2000)                --商品介绍，主要应该是放图片信息
);
create sequence seq_details_did start with 10001;

select * from details;
drop table details;
delete from details;
commit;
--需要的字段
       --有效日期，写个截至日期把 。
       --限购数量；本商品不限购买
       --使用规则；每张窝窝券限以为男士和以为女士/两位女士使用
       --预约提醒；该商品无需预约
       --其他提示；可能会有多条，插入 数据的时候用一个符号隔开     
       --套餐内容，包括：内容，单价，数量/规格，总计
       --商品介绍，应该就是一些文字和图片   
