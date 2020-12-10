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

create or replace function f2(v_name varchar2)
return  varchar2
as 
    v_productName varchar2(20);
    v_userid  number(10);
    v_username varchar2(20);
    v_time   varchar2(20);
    v_amount  varchar2(20);
   
begin 
    select a.userId,a.userName,b.orderTime,b.orderAmount
    into   v_userid,v_username,v_time,v_amount
    from userTable a,orders b
    where a.userId=b.userId and productName=v_name;
    
    -- dbms_output.put_line(v_userid)
    -- dbms_output.put_line(v_username)
    -- dbms_output.put_line(v_time)
    -- dbms_output.put_line(v_amount)
    return 'null';
end ;
/

begin 
    f2('matebook14');
end ;
/

--建立一个函数，输入一个商品名，查找到其供应商的id、姓名、电话、地址