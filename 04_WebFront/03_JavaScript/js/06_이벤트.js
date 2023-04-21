// 인라인 이벤트 모델 확인하기
function test1(el){
    el.style.backgroundColor = 'black';
    el.style.color = 'white';
}

// 고전 이벤트 모델 확인하기
// document.getElementById("test2a").onclick; // null 출력 -> 아직 click했을 때 동작할 함수가 없음
document.getElementById("test2a").onclick = function(){
    // function(){}: 익명 함수(이름이 없는 함수)
    // 재사용 목적이 아닌 특정 이벤트에 대한 기능을 만들 때 주로 사용
    alert("고전 이벤트 모델로 출력된 내용입니다.");
}
// test2a의 click 이벤트 동작 제거(이벤트 삭제)
document.getElementById("test2b").onclick = function(){
    document.getElementById("test2a").onclick = null;
    alert("이벤트를 제거하였습니다.");
}
// 고전 이벤트 모델 단점 확인하기
// -> 한 요소에 여러 이벤트 핸들러를 연결할 수 없음(마지막 작성된 핸들러가 앞에 작성된 핸들러를 덮어 씌움)
const c = document.getElementById("test2c");
c.onclick = function(){
    c.style.backgroundColor = 'pink';
}
c.onclick = function(){
    c.style.fontSize = '40px';
}

// 표준 이벤트 모델 확인하기
/* 
    [표준 이벤트 모델 작성 방법]
    요소.addEventListener(감지할 이벤트, 이벤트 핸들러);
    ex) test3.addEventListener("click", function(){});
*/
const test3 = document.getElementById("test3");
test3.addEventListener("click", function(){
    // 요소.clientWidth: 요소의 너비(CSS로 지정된 값을 읽어옴, readonly)
    // 요소.clientHeight: 요소의 높이(CSS로 지정된 값을 읽어옴, readonly)
    test3.style.width = test3.clientWidth + 20 + "px";
});
test3.addEventListener("click", function(){
    this.style.height = this.clientHeight + 20 + "px";
});
test3.addEventListener("click", function(e){
    // 이벤트 핸들러의 매개변수 e 또는 event: 현재 발생한 이벤트에 대한 모든 정보를 담고 있는 객체(이벤트 객체)
    // e.target: 이벤트가 발생한 현재 요소(== this)
    const currentWidth = e.target.clientWidth;
    if(currentWidth > 500 - 20){
        e.target.style.width = "200px";
        e.target.style.height = "200px";
    }
});

// 간이 계산기(표준 이벤트 모델)
const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
const result = document.getElementById("result");
const opList = document.getElementsByClassName("op");

// for of 구문(향상된 for문) -> 배열(Array), 유사 배열(HTMLCollection, NodeList, ...)
for(let op of opList){
    op.addEventListener('click', function(e){
        result.innerText
        = new Function("return " + Number(num1.value)
                                + e.target.innerText
                                + Number(num2.value))();
    });
}

// 박스 색 넣기
const boxList = document.getElementsByClassName("box");
const colorList = document.getElementsByClassName("color");
for(let i=0; i<boxList.length; i++){
    colorList[i].addEventListener('keyup', function(e){
        // boxList[i].style.backgroundColor = e.target.value;
        boxList[i].style.backgroundColor = colorList[i].value;
    })
}

// a 태그 기본 이벤트 제거
document.getElementById("moveGoogle").addEventListener("click", function(e){
    // e: 이벤트 객체
    e.preventDefault();
});

// form 태그 기본 이벤트 제거 1
// -> submit 버튼을 없애고 일반 button 타입 클릭되었을 때 조건이 맞으면 submit하게 만들기
document.getElementById("btn").addEventListener("click", function(){
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;
    if(id == 'user01' && pw == 'pass01'){
        // 아이디, 비밀번호가 일치할 때만 form 태그 제출
        // submit(): form 태그 제출
        document.testForm.submit();
    }
});

// form 태그 기본 이벤트 제거 2(인라인 이벤트 모델)
function fnCheck(){
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;
    if(id == 'user01' && pw == 'pass01'){
        // 아이디, 비밀번호가 일치할 때만 form 태그 제출
        // submit(): form 태그 제출
        return true;
    }
    return false;
}

// form 태그 기본 이벤트 제거 3(표준 이벤트 모델)
// -> name이 testForm인 form 태그에서 submit 이벤트가 발생했을 때
document.testForm.addEventListener("submit", function(e){
    e.preventDefault(); // 기본 이벤트 막기
})