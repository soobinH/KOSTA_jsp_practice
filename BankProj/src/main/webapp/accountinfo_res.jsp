<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            text-align: center;
            margin-top: 50px;
        }
        
        #outer {
            width: 350px;
            border: 1px solid black;
            margin: 0 auto;
            padding: 25px 0;
            
        }

        #outer>div {
            margin-bottom: 15px;
        }

        #outer>div:last-child {
            margin-bottom: 0;
        }


        h2 {
            display: inline-block;
            width: 80px;
            text-align: center;
            font-size: 20px;
            margin: 0;
            vertical-align: middle;            
        }
        input {
            width:200px;
            height:22px;
            margin-left: 10px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<%@ include file = "header.jsp" %>
    <h1>계좌조회</h1>
    <div id="outer">
        <div>
            <h2>계좌번호</h2>
            <input type="text">
        </div>
        <div>
            <h2>이름</h2>
            <input type="text">
        </div>
        <div>
            <h2>잔액</h2>
            <input type="text">
        </div>
        <div>
            <h2>종류</h2>
            <input type="text">
        </div>
        <div>
            <h2>등급</h2>
            <input type="text">
        </div>
    </div>
    
</body>
</html>