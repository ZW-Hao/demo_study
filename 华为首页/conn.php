<html>
<body>

<?php

$server="localhost";
$db_user="hzw";
$db_psw="123456";
$link=mysqli_connect($server,$db_user,$db_psw);
//验证是否连接到数据库
// if($link){
//     echo"成功";
// }



// mysqli_select_db("mywebodbc",$link);
mysqli_select_db($link,"mywebodbc");
$sql="select * from users";
// $result=mysqli_query($sql,$link);
$result=mysqli_query($link,$sql);



//取出表单数据
$namehtml=$_GET["name"];
$passwordhtml=$_GET["password"];
// echo $namehtml;
// echo $passwordhtml;



//取出数据库中存储的账号密码;
while($row=mysqli_fetch_assoc($result)) {
    $usernamehtml=$row['username'];
    $userpasswordhtml=$row['userpassword'];
    // echo $usernamehtml;
    // echo $userpasswordhtml;
    //验证账号密码是否能够登录网站
    if ($usernamehtml==$namehtml) {
       if($userpasswordhtml==$passwordhtml){
            //echo "已经登录网站";
           header("Location:http://localhost/huawei.html");
            break;
        }  
    }

    }


?>


</body>
</html>

