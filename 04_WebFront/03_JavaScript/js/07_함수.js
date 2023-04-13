// 기본 함수
function clickCount(btn){
    btn.innerText = Number(btn.innerText) + 1;
    if(btn.innerText > 20) btn.innerText = 0;
}

// 익명 함수
const t2 = document.getElementById("target2");
const b2 = document.getElementById("btn2");
const colorList = ['red', 'orange', 'yellow', 'green', 'blue'];
let index = -1;
b2.addEventListener("click", function(){
    t2.style.color = colorList[++index];
    if(index == 4) index = -1;
});

// 즉시 실행 함수
// 1) 속도적 우위
function testFn(){
    console.log("일반 함수");
}
testFn();

(function(){
    console.log("즉시 실행 함수");
})();

// 2) 변수명 중복 문제 해결
const str = "전역 변수";
(function(){
    const str = "지역 변수";
    console.log(str);
})()
console.log(str);

// 화살표 함수
// 1) 기본 형태
// 익명 함수: function(){}
// 화살표 함수: () => {}
document.querySelector('#button1').addEventListener("click", () => {
    alert("화살표 함수의 기본 형태");
});

// 2) 매개 변수 1개
// 익명 함수: function(e){}
// 화살표 함수: (e) => {} / e => {}
// 3) 매개 변수 0개 또는 2개 이상이면 소괄호 생략 불가능
document.querySelector('#button2').addEventListener("click", e => {
    e.target.style.backgroundColor = "pink";
})

// 4) 함수 정의 부분에 return 구문만 있을 경우
document.querySelector('#button4').addEventListener("click", () => {
    printConsole(function(num){return num * 10;}); // 익명 함수
    printConsole(num => num * 100); // 화살표 함수
    // 5) 함수 정의 부분에 return 구문만 있지만 자료형이 object인 경우
    const temp = {"price": 100, "name":'사탕'};
    console.log(temp);
    console.log(typeof temp);
    printConsole(num => {return {"price": 100, "name":'사탕'}}) // {return} 생략 불가
    printConsole(num => temp) // object를 변수에 저장해서 return하는 것은 가능
});
function printConsole(fn){
    // 매개 변수로 함수를 받아와 수행 결과를 콘솔에 출력
    console.log(fn(2));
};

// 화살표 함수 사용 시 this 문제점
const button6 = document.querySelector("#button6");
button6.addEventListener("click", function(e){
    e.target.style.backgroundColor = "black";
});
button6.addEventListener("click", e => {
    e.target.style.color = "white";
});
button6.addEventListener("click", function(){
    console.log(this);
    // 이벤트 핸들러로 지정된 익명 함수의 this == 이벤트가 발생한 요소
    this.style.fontSize = "25px";
});
button6.addEventListener("click", () => {
    console.log(this);
    // 화살표 함수에서 this를 작성하면 이벤트가 발생한 요소가 아닌
    // 창 자체를 나타내는 window 객체 반환
    this.style.border = "3px soild pink";
});