<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL 조건문</title>
</head>
<body>
    <h1>4. 조건문 - if (c:if 태그)</h1>
    <pre>
        - 단독 if문(else 없음)
        - 속성은 test만 존재
        ** 주의사항 **
        1) test의 속성 값은 무조건 EL 구문으로 작성
        2) test의 속성 값은 true 또는 false가 나오는 조건식이여야 함
        3) test의 속성 값을 작성하는 "" 내부에는 앞뒤 공백이 존재해서는 안됨
    </pre>
    request에 세팅된 name: ${name} <%-- 홍길동 --%>
    <br>
    request에 세팅된 money: ${money} <%-- 50000 --%>
    <br>
    <c:if test="${ money==50000 }">
        <h3 style="color:gold">돈이 50000원 있습니다.</h3>
    </c:if>

<%-- EL에서 모든 비교는 == 또는 eq / != 또는 ne 사용 --%>
<%-- EL에서 문자열은 ''로 표현 --%>
    <c:if test="${name=='홍길동'}">
        <h3 style="color:red">이름은 홍길동입니다.</h3>
    </c:if>

    <hr>

    <h1>5. 조건문 - choose, when, otherwise</h1>
    <pre>
        choose: when, otherwise 태그를 감싸는 태그
            (이 안에 if ~ else if ~ else를 쓰겠다)
        when: if, else if 역할의 태그
            - 속성은 test 밖에 없음
        otherwise: else 역할, 속성 없음
    </pre>

    <%-- queryString: 주소에 작성된 파라미터 문자열 --%>
    <%--
        http://localhost/jstl/condition?val=500
        queryString 바꿔가면서 테스트
    --%>
    <%-- 
        lt(little): <
        gt(greater): >
        le(little or equal): <=
        ge(greater or equal): >=
    --%>
    <c:choose>
        <c:when test="${param.val gt 100}">
            100 초과
        </c:when>

        <c:when test="${param.val < 100}">
            100 미만
        </c:when>

        <c:otherwise>
            100과 같다
        </c:otherwise>
    </c:choose>
</body>
</html>