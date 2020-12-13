set ServerOutput ON;
set linesize 1200;
set pagesize 30;

--编写一个过程，输出手机类中的所有信息
-- create or replace procedure p1
-- as  cursor c is 
--     select productId ,productName,productInformation,sortId,price,supplierId
--     from productTable
--     where sortId=(
--             select sortId from productSort
--             where sortName='Phone'
--             );

-- begin 

--     for v_x in c 
--     loop 
--         dbms_output.put_line('---------------------------');
--         dbms_output.put_line('productId: '||v_x.productId);
--         dbms_output.put_line('productName: '||v_x.productName);
--         dbms_output.put_line('productInformation: '||v_x.productInformation);
--         dbms_output.put_line('sortId: '||v_x.sortId);
--         dbms_output.put_line('price: '||v_x.price);
--         dbms_output.put_line('supplierId: '||v_x.supplierId);
       

--     end loop;


-- end;
-- /

-- create or replace function f1
-- return varchar2
-- as 
--     v_productName varchar2(20);
   
-- begin 
--     select productName 
--     into v_productName
--     from productTable
--     where price=(
--     select max(price) from productTable
--     );
--     return v_productName;
-- end ;
-- /

-- begin 
--     dbms_output.put_line('The most expensive product is ');
--     dbms_output.put_line(f1);
-- end ;
-- /


-- 编写一个过程，查找所有用户名中包含zhang的用户信息
-- create or replace procedure p2
-- as  cursor c is 
--         select  userId,userPassword,userName,userAge,userSex,userAddress,userPhone
--         from userTable
--         where userName like '%zhang%';
-- begin 

--     for v_x in c 
--     loop 

--         dbms_output.put_line('---------------------------');
--         dbms_output.put_line('userId: '||v_x.userId);
--         dbms_output.put_line('userPassword: '||v_x.userPassword);
--         dbms_output.put_line('userName: '||v_x.userName);
--         dbms_output.put_line('userAge: '||v_x.userAge);
--         dbms_output.put_line('userSex: '||v_x.userSex);
--         dbms_output.put_line('userAddress: '||v_x.userAddress);
--         dbms_output.put_line('userPhone: '||v_x.userPhone);
       

--     end loop;


-- end;
-- /


-- declare 
--         cursor c is
--             select orderId,productId,productName,userId,userName,orderTime,orderAmount
--             from orders
--             where userName like 'zhangsan';
-- begin
--     for var_record in c
--     loop

--         dbms_output.put_line('------------------------------');
--         dbms_output.put_line('orderId:  '||var_record.orderId);
--         dbms_output.put_line('productId:  '||var_record.productId);
--         dbms_output.put_line('productName:  '||var_record.productName);
--         dbms_output.put_line('userId:  '||var_record.userId);
--         dbms_output.put_line('userName:  '||var_record.userName);
--         dbms_output.put_line('orderTime:  '||var_record.orderTime);
--         dbms_output.put_line('orderAmount:  '||var_record.orderAmount);      
--     end loop;

-- end ;
-- /

--建立一个函数，输入一个商品名，查找到购买此商品的用户id、用户名、订单时间、订单金额

-- create or replace function f2
-- return  varchar2
-- as 
--     cursor c is
--         select a.userId,a.userName,orderTime,orderAmount
--         from userTable a,orders b
--         where a.userId=b.userId and productName='matebook14';

   
-- begin 
    
--     for var in c
--     loop

--     dbms_output.put_line('userId:  '||var.userId);
--     dbms_output.put_line('userName:  '||var.userName);
--     dbms_output.put_line('orderTime:  '||var.orderTime);
--     dbms_output.put_line('orderAmount:  '||var.orderAmount);
--     dbms_output.put_line('--------------------------');

--     end loop;
    
--     -- dbms_output.put_line(v_userid)
--     -- dbms_output.put_line(v_username)
--     -- dbms_output.put_line(v_time)
--     -- dbms_output.put_line(v_amount)
--     return null;
-- end ;
-- /

-- begin 
--     dbms_output.put_line(f2);
-- end ;
-- /




--建立一个函数，输入一个商品名，查找这个商品供应商的电话号码和地址信息

-- create or replace function f3(v_name in varchar2)
-- return  varchar2
-- as 
--     -- v_name varchar2(20);
--     cursor c is
--         select phone,supplierAddress 
--         from supplier
--         where supplierId=(
--             select supplierId from productTable
--             where productName=v_name
--         );

   
-- begin 
    
--     for var in c
--     loop
--     dbms_output.put_line('--------------------------');
--     dbms_output.put_line('phone:  '||var.phone);
--     dbms_output.put_line('supplierAddress:  '||var.supplierAddress);

--     end loop;
    
--     return null;
-- end ;
-- /

-- begin 
--     dbms_output.put_line(f3('&v_name'));
-- end ;
-- /

-- create or replace trigger c
-- after insert or delete or update
-- on supplier
-- begin 
--     dbms_output.put_line('changes happened  '||sysdate);
-- end;
-- /

-- insert into supplier(
--     supplierId ,
--     supplierName ,
--     phone ,
--     supplierAddress 
-- )
-- values(4,'padSupplier','4230999','shanghai');


--当用户id发生改变时，订单表中的用户id也要同时更新
-- create or replace trigger d
-- after update
-- on userTable
-- for each row

-- begin 
--     update orders
--     set userName =:new.userName
--     where userName=:old.userName;

-- end;
-- /


--创建序列

-- create sequence userTable_seq
-- increment by 1
-- start with 123;

-- create sequence productTable_seq
-- increment by 1
-- start with 1;

-- 创建视图，查询商品id 商品名 供应商名称，供应商电话
-- create view v1 as 
-- select productId,productName,supplierName,phone
-- from productTable,supplier
-- where productTable.sortId=supplier.supplierId;


-- select * from v1;

