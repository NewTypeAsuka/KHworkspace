// id로 접근하기
function accessId(){ // 함수 선언
    // 함수 정의

    // id가 div1인 요소의 배경색을 얻어와
    // 배경색이 red이면 yellow로 변경
    // 배경색이 red가 아니면 red로 변경

    // 1) id가 div1인 요소를 얻어와 변수에 저장
    var div1 = document.getElementById("div1");
    // 2) div1의 배경색을 변수에 저장
    /* JS에서 CSS 관련 속성을 다룰 때는 style을 이용 */
    var bgColor = div1.style.backgroundColor;
    // 3) 배경색이 red일 때, 아닐 때에 대한 코드 작성
    if(bgColor == "red"){ /* JS는 문자열 비교 시에도 비교연산자 사용 */
        div1.style.backgroundColor = "yellow";
    } else {
        div1.style.backgroundColor = "red";
    }
}

// 클래스로 접근하기
function accessClass(){
    var div2Arr = document.getElementsByClassName("div2");
    // 배열.length: 배열 길이
    // 배열[i]: i번 인덱스 요소
    for(var i=0; i<div2Arr.length; i++){
        div2Arr[i].style.backgroundColor = "rgb(130, 220, "+(i*100)+")";
    }
}

// name으로 접근하기
function accessName(){
    // 1) name이 hobby인 요소를 모두 얻어와 변수에 저장
    var hobbyList = document.getElementsByName("hobby");
    // 2) 체크된 체크박스의 value를 저장할 변수 + 개수를 세기 위한 변수 선언
    var result = "";
    var count = 0;
    // 3) hobbyList 요소 반복 접근
    for(var i=0; i<hobbyList.length; i++){
        /* radio/checkbox 전용 속성: checked */
        /* 해당 요소가 check 되어 있으면 true, 아니면 false 반환 */
        if(hobbyList[i].checked){
            result += hobbyList[i].value + " ";
            count++;
        }
    }
    // 4) #div3에 내용 출력
    document.getElementById("div3").innerHTML = result + "<br><br>선택된 개수: " + count; 
}

// 태그로 접근하기
function accessTagName(){
    var arr = document.getElementsByTagName("li");
    // 각 li 요소에 작성된 색으로 글자색 변경
    for(var i=0; i<arr.length; i++){
        arr[i].style.color = arr[i].innerText;
    }
}

// CSS 선택자로 접근하기
function cssTest(){
    // querySelector("선택자"): 요소 1개 선택

    // 1개만 선택되는 요소
    document.querySelector("#cssDiv").style.border = "3px solid red";
    // 여러 요소 선택(첫번째 요소만 선택되는지 확인)
    document.querySelector("#cssDiv > div").style.fontSize = "30px";

    // querySelectorAll("선택자"): 모든 요소 선택
    var arr = document.querySelectorAll("cssDiv > div");
    for(var i=0; i<arr.length; i++){
        arr[i].style.backgroundColor = "orange";
    }
}

/* 카카오톡 채팅 만들기 */

// 입력 버튼 눌렀을 때 입력한 내용 채팅창에 출력
function readValue(){
    // 채팅 출력에 사용되는 변수 선언
    var container = document.getElementById("chattingContainer");
    var input = document.querySelector("#chattingInput");
    // 문자열.trim(): 문자열 양쪽 공백 제거
    if(input.value.trim().length > 0){ // input의 값이 비어있지 않다면
        // input에 입력된 값을 읽어와 container에 알맞은 형태로 누적
        container.innerHTML += "<p><span>" + input.value + "</span></p>";
        // 채팅 내용 출력 후 container의 스크롤 제일 밑으로 내리기
        container.scrollTop = container.scrollHeight;
    }
    input.value = ""; // 입력된 value을 지우기
    input.focus(); // 입력 후 input에 포커스 맞추기
}
// input 태그에 엔터가 눌러졌을 때
function inputEnter(){
    // console.log(window.event.key); // 현재 눌러진 키 반환
    if(window.event.key == "Enter") readValue();
}