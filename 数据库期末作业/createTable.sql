-- 创建数据库表
-- 创建产品表
create table productTable(
    productId number(10),
    productName varchar(20),
    productInformation varchar(20),
    sortId number(10),
    price number(10),
    supplierId number(10)
);

-- 创建用户表
create table userTable(
    userId number(10),
    userPassword number(10),
    userName varchar(20),
    userAge number(10),
    userSex varchar(10),
    userAddress varchar(10),
    userPhone varchar(11)
);

-- 创建订单表
create table orders(
    orderId number(5),
    productId number(5),
    productName varchar(15),
    userId number(10),
    userName varchar(20),
    orderTime varchar(20),
    orderAmount number(10)
);

-- 创建供应商表
create table supplier(
    supplierId number(5),
    supplierName varchar(20),
    phone varchar(11),
    supplierAddress varchar(10)
);

-- 创建分类表
create table productSort(
    sortId number(10),
    sortName varchar(20)
);



