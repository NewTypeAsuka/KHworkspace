<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>index 페이지</title>
</head>
<body>

<form action="/orderProduct.do" method="POST">
    <h1>KH 온라인 문방구</h1>
    
    <table border="1">
        <thead>
<!-- 1행 -->
            <tr>
                <th colspan="3">주문자 명</th>
            </tr>
<!-- 2행 -->
            <tr>
                <td colspan="3" align="center">
                    <input type="text" name="name" id="nameId" style="width: 95%;">
                </td>
            </tr>
        </thead>
<!-- 3행 -->
        <tbody>
            <tr>
                <th>품목</th>
                <th>가격</th>
                <th>수량</th>
            </tr>
<!-- 4행 -->
            <tr>
                <td>검정 펜</td>
                <td>500원</td>
                <td>
                    <input type="number" name="blackPen" id="blackId" min="0" max="100" value="0">
                </td>
            </tr>
<!-- 5행 -->
            <tr>
                <td>빨간 펜</td>
                <td>700원</td>
                <td>
                    <input type="number" name="redPen" id="redId" min="0" max="100" value="0">
                </td>
            </tr>
<!-- 6행 -->
            <tr>
                <td>파란 펜</td>
                <td>700원</td>
                <td>
                    <input type="number" name="bluePen" id="blueId" min="0" max="100" value="0">
                </td>
            </tr>
<!-- 7행 -->
            <tr>
                <td>화이트</td>
                <td>1000원</td>
                <td>
                    <input type="number" name="white" id="whiteId" min="0" max="100" value="0">
                </td>
            </tr>
        </tbody>
<!-- 8행 -->
        <tfoot>
            <tr>
                <td colspan="3" align="center">
                    <button type="submit">구매</button>
                    <button type="button" id="resetBtn">초기화</button>
                </td>
            </tr>
        </tfoot>
    </table>
</form>
<script>
    // 초기화 버튼 눌렀을 때 초기화하는 기능
    document.getElementById("resetBtn").addEventListener("click", () => {
        document.getElementById("nameId").value = "";
        document.getElementById("blackId").value = 0;
        document.getElementById("redId").value = 0;
        document.getElementById("blueId").value = 0;
        document.getElementById("whiteId").value = 0;
    });
</script>
</body>
</html>