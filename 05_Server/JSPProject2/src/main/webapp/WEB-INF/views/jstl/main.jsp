<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    <%@ %>: 지시자 태그
    taglib: 태그 라이브러리 추가(JSTL, 커스텀태그)
    prefix: 접두사, 태그명 앞에 작성되는 단어 <c:if>
    uri(Uniform Resource Identifier): 자원을 식별하는 고유 문자열(ID)

    url(Uniform Resource Locator): 자원의 위치를 나타내는 문자열(경로) 
--%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL(Jsp Standard Tag Library)</title>
</head>
<body>
    <a href="condition">JSTL을 이용한 조건문(if, choose, when, otherwise)</a>
    <a href="loop">JSTL을 이용한 반복문(forEach)</a>

    <br>

    <h3><a href="student/selectAll">workbook에서 학생 전체 조회하기</a></h3>

    <h1>JSTL(Jsp Standard Tag Library)</h1>
    <pre>
        JSP에서 자주 사용되거나 공통적으로 사용되는 Java 코드(if, for, 변수선언, 형변환)를
        스크립틀릿 대신 HTML 태그 형식으로 태그화하여 표준으로 제공하는 라이브러리
    </pre>
    <h3>JSTL 라이브러리 다운로드 및 등록 방법</h3>
    <ol>
        <li>
            <a href="https://tomcat.apache.org/download-taglibs.cgi">JSTL 다운로드 페이지 이동</a>
            <br>
            Standard-1.2.5 -> Jar Files -> Impl, Spec, EL 다운로드
        </li>
        <li>
            /webapp/WEB-INF/lib 폴더에 라이브러리 파일(.jar) 추가
        </li>
        <li>
            JSTL 라이브러리를 사용하고자 하는 JSP 파일 상단에
            taglib JSP 지시자 태그 추가
        </li>
    </ol>

    <hr>

    <h1>1. 변수 선언(c:set 태그)</h1>
    <pre>
        - 변수 선언(지정된 scope에 속성 세팅)을 위한 태그
        - c:set에 작성 가능한 속성
        1) var: 선언할 변수명(속성 key)
        2) value: 대입할 값
        3) scope: page, request, session, application 중 하나 지정(기본값 page)
    </pre>

    <%
        // 스크립틀릿으로 pageScope에 속성 세팅하는 방법
        pageContext.setAttribute("num1", 10);
    %>
    <%-- JSTL(c:set)으로 pageScope에 속성 세팅하는 방법 --%>
    <c:set var="num2" value="20" scope="page"/>
    num1: ${num1}
    <br>
    num2: ${num2}
    <br>
    <%-- requestScope에 세팅 --%>
    <c:set var="num2" value="30" scope="request"/>
    num3: ${requestScope.num2}

    <hr>

    <h1>2. 변수 제거(c:remove 태그)</h1>
    <pre>
        - 변수 제거(내장 객체에 세팅된 속성 제거)를 위한 태그
        - c:remove에 작성 가능한 속성
        1) var: 삭제할 변수명(속성 key)
        2) scope: page, request, session, application 중 하나 지정(기본값이 모든 scope임에 주의)
    </pre>
    <% 
        pageContext.removeAttribute("num1");
    %>
    num1 제거 확인: ${num1}
    <br>
    <c:remove var="num2" scope="request"/>
    <%-- <c:remove var="num2"/> 기본값인 모든 scope 제거 --%>
    request num2 제거 확인: ${requestScope.num2}
    <br>
    page num2 제거 확인: ${pageScope.num2}

    <hr>

    <h1>3. 변수 출력(c:out 태그)</h1>
    <pre>
        - 변수 출력 O: \${key} EL 구문과 유사
        - 단 escapeXml="true" 설정 시 html 태그 해석 X
        - escapeXml="false" 설정 시 html 태그 해석 O
    </pre>
    <c:set var="temp" scope="session" value="<h1>점심시간</h1>"/>
    HTML 태그 해석 X: <c:out value="${temp}"/>
    <br>
    HTML 태그 해석 O: <c:out value="${temp}" escapeXml="false"/>
    <br>
    HTML 태그 해석 O: ${temp}
</body>
</html>