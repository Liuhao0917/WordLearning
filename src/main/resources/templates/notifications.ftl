<!DOCTYPE html>
<html>
<head>
  <title>首页</title>
  <style>
    li{list-style-type:none;margin-left: -40px}
    .img{
     width: 599px;
      height: 325px;
      border-radius: 10px;
    }
  </style>
</head>

<body background="picture/background.jpg">
<#include 'top.ftl'>
<div style="width: 800px;margin: 0 auto">
  <img class="img" src="picture/nuaa.jpg"/>
  <#include 'left.ftl'>
</div>

</body>
</html>
