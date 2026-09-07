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
        
        #form-box {
            width: 400px;
            border: 1px solid black;
            margin: 0 auto;
            padding: 30px 0;
        }

        /* 각 입력 줄을 감싸는 div 스타일 */
        .row {
            margin-bottom: 15px;
            text-align: left;
            padding-left: 45px; /* 박스 안에서 요소들을 가운데로 밀어줌 */
        }
        
        h2 {
            display: inline-block;
            width: 80px; /* 모든 라벨 너비 통일 */
            text-align: center;
            font-size: 20px;
            margin: 0;
            vertical-align: middle;            
        }
        
        /* id 대신 속성 선택자 사용 */
        input[type="text"] {
            width: 200px;
            height: 22px;
            margin-left: 10px;
            vertical-align: middle;
        }

        /* 라디오 버튼과 셀렉트 박스 간격 및 정렬 */
        input[type="radio"], select {
            margin-left: 10px;
            vertical-align: middle;
        }

        select {
            height: 26px;
            width: 100px;
        }

        /* 버튼 영역 스타일 */
        .btn-row {
            text-align: center;
            margin-top: 25px;
        }

        button {
            width: 100px;
            height: 30px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file = "header.jsp" %>
    <h1>계좌 개설</h1>
    <div id="form-box">
        <div class="row">
            <h2>계좌번호</h2>
            <input type="text">
        </div>
        <div class="row">
            <h2>이름</h2>
            <input type="text">
        </div>
        <div class="row">
            <h2>입금액</h2>
            <input type="text">
        </div>
        <div class="row">
            <h2>종류</h2>
            <input type="radio" name="account" value="normal"> 일반
            <input type="radio" name="account" value="special"> 특수
        </div>
        <div class="row">
            <h2>등급</h2>
            <select name="grade">
                <option value="vip">vip</option>
                <option value="gold">gold</option>
                <option value="silver">silver</option>
                <option value="bronze">bronze</option>
                <option value="normal">normal</option>
            </select>
        </div>
        <div class="btn-row">
            <button>송금</button>
        </div>
    </div>
</body>
</html>