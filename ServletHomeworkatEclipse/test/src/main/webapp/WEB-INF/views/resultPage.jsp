<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>result 페이지</title>
</head>
<body>
    <h1>${name}님의 구매 목록</h1>

    <h3>검은 펜 ${blackPen}개: ${blackPrice}</h3>
    <h3>빨간 펜 ${redPen}개: ${redPrice}</h3>
    <h3>파란 펜 ${bluePen}개: ${bluePrice}</h3>
    <h3>화이트 ${white}개: ${whitePrice}</h3>

    <hr>

    <h3>총합 ${total}원을 결제하셨습니다.</h3>

</body>
</html>