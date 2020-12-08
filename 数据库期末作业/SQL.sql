-- select * from productTable
-- where sortId=(
--     select sortId from productSort
--     where sortName='Phone'
-- );

-- select productName from productTable
-- where price=(
--     select max(price) from productTable
-- );

-- select initcap(substr(userName,1,5)) from userTable;

-- select * from userTable
-- where userName like '%zhang%';

-- select * from productTable
-- order by price asc;

-- select * from orders
-- where userName like 'zhangsan';

-- select a.userId,a.userName,b.orderTime,b.orderAmount 
-- from userTable a,orders b
-- where a.userId=b.userId and productName='matebook14';

select phone,supplierAddress from supplier
where supplierId=(
    select supplierId from productTable
    where productName='matepadpro'
);