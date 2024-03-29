<%@page import="edu.kh.jsp.model.dto.Book"%> <%-- JSP 표현식은 다른 패키지의 클래스 import 필요(EL은 필요 없음) --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EL 결과</title>
</head>
<body>
    <h1>EL을 이용해서 출력하기</h1>

    <h3>파라미터</h3>
    <ul>
        <li>\${param.name속성값}: request에 담긴 파라미터 얻어오기(1개)</li>
        <li>\${paramValues}: 모든 파라미터를 배열로 얻어오기</li>
        <li>\${paramValues.name속성값[index]}: 모든 파라미터를 담은 배열의 index번째 value 얻어오기(1개)</li>
    </ul>
    <p>
        이름: ${param.inputName}<br>
        나이: ${param.inputAge}<br>
        opt: ${param.opt}<br>
        <br><br>
        opt[0]: ${paramValues.opt[0]}<br>
        opt[1]: ${paramValues.opt[1]}<br>
        opt[2]: ${paramValues.opt[2]}<br>
    </p>

    <hr>

    <h3>세팅된 속성(attribute) 출력하기</h3>
    <ul>
        <li>기본: \${key} (key는 세팅한 속성의 key 값)</li>
        <li>배열 또는 List: \${key[index]}</li>
        <li>DTO 또는 Map: \${key.필드명 또는 K}</li>
    </ul>

    <p>
        address: ${address}<br>
        strList: ${strList}<br>
        book: ${book}<br>
        <br><br>
        strList[0]: ${strList[0]}<br>
        strList[1]: ${strList[1]}<br>
        strList[2]: ${strList[2]}<br>
        strList[3]: ${strList[3]}<br>
        <br><br>
        book의 title 필드(JSP 표현식): 
            <%= ((Book)request.getAttribute("book")).getTitle() %>
        <br>
        book의 title 필드(EL): ${book.title}<br>
        book의 writer 필드(EL): ${book.writer}<br>
        book의 price 필드(EL): ${book.price}<br>
    </p>

    <hr>

    <h1>EL은 null, 비어있다를 같은 것으로 생각한다.</h1>
    ${list1} / ${list2}

    <h4>empty 연산자</h4>
    ${empty list1} / ${empty list2}
</body>
</html>