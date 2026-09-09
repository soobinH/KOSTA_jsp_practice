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
        
        div {
            width: 500px;
            border: 1px solid black;
            margin: 0 auto;
            padding: 25px 0;
            
        }
        h2 {
            display: inline-block;
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

        button {
            width: 100px;
            height: 30px;
            margin-top: 15px;
            margin-left: 40px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file = "header.jsp" %>

    <h1>계좌 조회</h1>
    <div>
        <h2>계좌번호</h2>
        <input type="text"><br>
        <button onclick="location.href='accountinfo_res.html'">조회</button>
    </div>
    
</body>
</html>