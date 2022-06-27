<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询学生</title>

</head>

<body background="picture/background.jpg">

<#include 'top.ftl'>

<div style="width: 800px;margin: 0 auto">
    <#include 'left.ftl'>

    <form action="/Retrieve" method="post">
        <fieldset>
            <legend>学生详情</legend>
            <table class="formtable" style="width:50%">
                <tr>
                    <td>查询项:</td>
                    <td>
                        <select name="query_item" id="query_item">
                            <option value="card">学号</option>
                            <option value="name">姓名</option>
                            <option value="phone">手机号</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>关键字:</td>
                    <td>
                        <input name="queryValue" type="text" id="queryValue" />
                    </td>
                </tr>


                <tr>
                    <td style="margin-top: 20px;float: left">
                        <input type="button" value="搜索" class="btn btn-primary" onclick="queryStudentInfo()"/>
                        <input type="reset" value="重置" class="btn btn-primary"/>
                    </td>
                </tr>
                <tr style="margin-top: 15px;float: left">
                <tr>
                    <td style="color: red" id="isNullHint"> </td>
                </tr>
                <tr>
                    <td>姓名:</td>
                    <td id="_name"></td>
                </tr>
                <tr>
                    <td>学号:</td>
                    <td id="_card"></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td id="_sex"></td>
                </tr>
                <tr>
                    <td>手机号:</td>
                    <td id="_phone"></td>
                </tr>

            </table>


        </fieldset>


    </form>
</div>

<script>
    function queryStudentInfo() {

        let queryItem = $('#query_item option:selected') .val();
        //console.log('query_item',query_item)

        let queryField
        //查询关键字
        queryField =  document.getElementById("queryValue").value
        //console.log(queryField)

        //选择项
        if ('' === queryItem || null === queryItem){
            alert("请输入选择项");
        }

        if ('' === queryField || null === queryField){
            alert("请输入查询关键字");
        }

        if ('' === queryItem || null === queryItem || '' === queryField || null === queryField){
            return
        }
        $.ajax({
            type: "GET",
            url: 'queryStudent/' + queryItem + '/' + queryField,
            contentType: "application/json",
            success: function (result) {
                //console.log(result)

                if ('' === result){
                    document.getElementById("isNullHint").innerText = '查询学生信息为空';
                }else {
                    document.getElementById("isNullHint").innerText = '';
                }


                let isResultFlag = result === '';
                let finalCard = isResultFlag ? '' : result.card;
                let finalName = isResultFlag ? '' : result.name;
                let finalPhone = isResultFlag ? '' : result.phone;
                let finalSex = isResultFlag ? '' : result.sex;

                document.getElementById("_name").innerText = finalName;
                document.getElementById("_card").innerText = finalCard;
                document.getElementById("_phone").innerText = finalPhone;
                if (isResultFlag){
                    document.getElementById("_sex").innerText = '';
                }else {
                    let sexValue
                    if (1 === finalSex){
                        sexValue = '男'
                    }else if (2 === finalSex){
                        sexValue = '女'
                    }else {
                        sexValue = finalSex
                    }
                    document.getElementById("_sex").innerText = sexValue;
                }
            },
            error: function () {
                alert("请重新输入");
            }
        })
    }
</script>

</body>
</html>