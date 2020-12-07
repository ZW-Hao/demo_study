-- 创建数据库表
-- 创建产品表
create table productTable(
    productId number(10),
    productName varchar(20),
    productInformation varchar(20),
    categoryId number(10),
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