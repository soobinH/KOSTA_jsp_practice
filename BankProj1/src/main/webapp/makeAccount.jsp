<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .header {
            text-align: center;
        }

        .container {
            width: 270px;
            margin: 0 auto;
            border: 1px solid black;
            padding: 10px;
        }

        .title {
            float: left;
            width: 70px;
            text-align: center;
            font-weight: bold;
        }

        .row {
            height: 30px;
        }

        input[type='submit'] {
            font-weight: bold;
            width: 120px;
            background-color: lightgray;
            display: block;
            margin: 0 auto;
        }
    </style>
    <script>
        window.onload = function () {
            let grade = document.getElementById("grade");
            let types =  document.querySelectorAll("input[name='type']");
            types.forEach(type=> {
                type.onchange = function() {
                    if(document.querySelector("input[name='type']:checked").value == 'normal') {
                        grade.disabled = true;
                    } else {
                        grade.disabled = false;
                    }
                }
            })
        }
    </script>
</head>

<body>
	<jsp:include page="header.jsp"/>
    <form action="makeAccount" method="post">
        <div class="header">
            <h3>계좌개설</h3>
        </div>
        <div class="container">
            <div class="row">
                <div class="title">계좌번호</div>
                <div class="input"><input type="text" name="id"></div>
            </div>
            <div class="row">
                <div class="title">이름</div>
                <div class="input"><input type="text" name="name"></div>
            </div>
            <div class="row">
                <div class="title">입금액</div>
                <div class="input"><input type="text" name="balance"></div>
            </div>
            <div class="row">
                <div class="title">종류</div>
                <div class="input">
                    <input type="radio" name="type" id="normal" value="normal" checked>
                    <label for="normal">일반</label>
                    <input type="radio" name="type" id="special" value="special">
                    <label for="special">특수</label>

                </div>
            </div>
            <div class="row">
                <div class="title">등급</div>
                <div class="input">
                    <select name="grade" id="grade" disabled>
                        <option>선택</option>
                        <option value="VIP">VIP</option>
                        <option value="Gold">Gold</option>
                        <option value="Silver">Silver</option>
                        <option value="Normal">Normal</option>
                    </select>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="개설">
            </div>
        </div>
    </form>
</body>

</html>