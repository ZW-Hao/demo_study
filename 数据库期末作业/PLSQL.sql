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

declare 
    v_name_demo userTable.userName%type;--存储输入的用户名
    v_userid_demo userTable.userId%type;--存储所输入的用户名的id

    v_id orders.orderId%type;
    v_productId orders.productId%type;
    v_productName orders.productName%type;
    v_userId orders.userId%type;
    v_userName orders.userName%type;
    v_time orders.orderTime%type;
    v_amount orders.orderAmount%type;

    cursor mycur(vid number) is
    select orderId
    from orders
    where vid=userId;
    

begin 
    
    select userId 
    into v_userid_demo
    from userTable
    where userName='&v_name_demo';
    


end;
/

