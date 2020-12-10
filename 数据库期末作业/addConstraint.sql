建立主键约束
alter table productTable
add constraint pk_productId
primary key(productId);

alter table userTable
add constraint pk_userId
primary key(userId);

alter table orders
add constraint pk_orderId
primary key(orderId);

alter table supplier
add constraint pk_supplierId
primary key(supplierId);

alter table productSort
add constraint pk_sortId
primary key (sortId);

建立外键约束
产品表外键  类别id、供应商id
alter table productTable
add constraint fk_productTableone
foreign key(sortId)
references productSort(sortId);

alter table productTable
add constraint fk_productTabletwo
foreign key(supplierId)
references supplier(supplierId);

订单表外键  userId

alter table orders
add constraint fk_orderstwo
foreign key(userId)
references userTable(userId);

建立非空约束

alter table productTable modify productName not null;
alter table productTable modify productInformation not null;
alter table productTable modify sortId not null;
alter table productTable modify price not null;
alter table productTable modify supplierId not null;


alter table userTable modify userPassword not null;
alter table userTable modify userName not null;
alter table userTable modify userAge not null;
alter table userTable modify userSex not null;
alter table userTable modify userAddress not null;
alter table userTable modify userPhone not null;


alter table orders modify productId not null;
alter table orders modify productName not null;
alter table orders modify userId not null;
alter table orders modify userName not null;
alter table orders modify orderTime not null;
alter table orders modify orderAmount not null;


alter table supplier modify supplierName not null;
alter table supplier modify phone not null;
alter table supplier modify supplierAddress not null;



alter table productSort modify sortId not null;
alter table productSort modify sortName not null;



建立检查约束
alter table userTable 
add constraint ck_sex
check(userSex in ('man','woman'));

alter table userTable
add constraint ck_age
check(userAge between 1 and 100);