set ServerOutput ON;
-- declare
--     v_id productTable.productId%type;
--     v_name productTable.productName%type;
--     v_information productTable.productInformation%type;
--     v_sort productTable.sortId%type;
--     v_price productTable.Price%type;
--     v_supplier productTable.supplierId%type;
--      v_name_demo productTable.productName%type;
-- begin 
--     select productId,productName,productInformation,sortId,Price,supplierId
--     into v_id,v_name,v_information,v_sort,v_price,v_supplier
--     from productTable 
--     where productName='&v_name_demo';
--     dbms_output.put_line('id :'||v_id);
--     dbms_output.put_line('name :'||v_name);
--     dbms_output.put_line('information :'||v_information);
--     dbms_output.put_line('sortid :'||v_sort);
--     dbms_output.put_line('price :'||v_Price);
--     dbms_output.put_line('supplier :'||v_supplier);

-- end;
-- /

-- declare 
--     v_name_demo userTable.userName%type;--存储输入的用户名
--     v_userid_demo userTable.userId%type;--存储所输入的用户名的id

--     v_id orders.orderId%type;
--     v_productId orders.productId%type;
--     v_productName orders.productName%type;
--     v_userId orders.userId%type;
--     v_userName orders.userName%type;
--     v_time orders.orderTime%type;
--     v_amount orders.orderAmount%type;
    

-- begin 
--     --只能返回一条信息
--     select userId 
--     into v_userid_demo
--     from userTable
--     where userName='&v_name_demo';
    

--     select orderId,productId,productName,userId,userName,orderTime,orderAmount
--     into v_id,v_productId,v_productName,v_userId,v_userName,v_time,v_amount
--     from orders
--     where userId=v_userid_demo;

--     dbms_output.put_line('orderId:  '||v_id);
--     dbms_output.put_line('productId:  '||v_productId);
--     dbms_output.put_line('productName:  '||v_productName);
--     dbms_output.put_line('userId:  '||v_userId);
--     dbms_output.put_line('userName:  '||v_userName);
--     dbms_output.put_line('orderTime:  '||v_time);
--     dbms_output.put_line('orderAmount:  '||v_amount);

-- end;
-- /

--使用游标进行改进

-- declare 

--     v_name_demo userTable.userName%type;--存储输入的用户名
--     v_userid_demo userTable.userId%type;--存储所输入的用户名的id
--     v_amount_sum orders.orderAmount%type;--订单总金额
--     cursor mycur(vid number) is
--     select orderId,productId,productName,userId,userName,orderTime,orderAmount
--     from orders
--     where vid=userId;
-- begin 
    
--     select userId 
--     into v_userid_demo
--     from userTable
--     where userName='&v_name_demo';
--     v_amount_sum:=0;
    
--     for var_record in mycur(v_userid_demo)
--     loop
--         v_amount_sum:=v_amount_sum+var_record.orderAmount;
--         dbms_output.put_line('orderId:  '||var_record.orderId);
--         dbms_output.put_line('productId:  '||var_record.productId);
--         dbms_output.put_line('productName:  '||var_record.productName);
--         dbms_output.put_line('userId:  '||var_record.userId);
--         dbms_output.put_line('userName:  '||var_record.userName);
--         dbms_output.put_line('orderTime:  '||var_record.orderTime);
--         dbms_output.put_line('orderAmount:  '||var_record.orderAmount);
--         dbms_output.put_line('------------------------');  
--     end loop;
--     dbms_output.put_line('amountsum:'||v_amount_sum);

-- end;
-- /

-- declare 
--     --输入一个商品名，查询所有买过此商品的用户信息
--     v_productName productTable.productName%type;
--     v_userid_demo userTable.userId%type;


--     cursor mycur(vid number) is
--     select userId,userName,userAge,userSex,userPhone
--     from userTable
--     where vid=userId;

-- begin 
--     select userId 
--     into v_userid_demo
--     from orders
--     where productName='&v_productName';

--     for var_record in mycur(v_userid_demo)
--     loop
--         dbms_output.put_line('userId:  '||var_record.userId);
--         dbms_output.put_line('userName:  '||var_record.userName);
--         dbms_output.put_line('userAge:  '||var_record.userAge);
--         dbms_output.put_line('userSex:  '||var_record.userSex);
--         dbms_output.put_line('userPhone:  '||var_record.userPhone);
--     end loop;

-- end;
-- /

declare
-- 输入一个用户名，若找到和他买相同产品的用户则输出用户信息，若找不到则返回无其他人购买此商品
-- 找到时输出用户信息
--若找不到相应的信息则应该输出null
    v_name userTable.userName%type;--储存输入的用户名
    -- 根据用户名找到购买的商品id，在查询购买此商品的用户信息，如果查找到购买这个商品的用户则输出相应的信息
    --如果查找不到其他购买者，则返回无其他人购买此产品

    cursor mycur(vid number) is
    select 

    

begin 



end;
/
    

    

