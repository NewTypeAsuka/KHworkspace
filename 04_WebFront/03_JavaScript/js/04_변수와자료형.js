var str = "JS코드를 함수 내부가 아닌 JS파일 또는 script 태그에 바로 작성하면 HTML 랜더링 시 바로 수행"; // 전역 변수

// clg -> 자동완성
console.log(str);

// 변수 선언 위치에 따른 구분
var num1 = 1;   // 전역 변수
num2 = 2;       // 전역 변수
console.log("num1(전역):" + num1);
console.log("num2(전역):" + num2);

function testFn(){
    var num3 = 3;   // function 지역 변수
    num4 = 4;       // 전역 변수

    console.log("함수 내부에서 선언된 (함수)num3: " + num3);
    console.log("함수 내부에서 선언된 (전역)num4: " + num4);

    if(true){
        var num5 = 5;   // function 지역 변수
        num6 = 6;       // 전역 변수
    }
    console.log("if문 종료 후 (if)num5: " + num5);
    console.log("if문 종료 후 (if)num6: " + num6);
}
// 함수 호출
testFn();

// num3 에러
// console.log("함수 밖에서 선언된 num3: " + num3);
// JS 코드 중간에 에러가 발생하면 같은 파일/함수 내 에러 이후 부분 코드가 해석되지 않음
console.log("함수 밖에서 선언된 (전역)num4: " + num4);

// console.log("함수 밖에서 (if)num5: " + num5); // num5 에러
console.log("함수 밖에서 (if)num6: " + num6);

// var 변수명 중복 확인
var testValue = 10;
console.log(testValue);
var testValue = 20;
console.log(testValue);

// let, const 확인
let let1 = 10;
// let let1 = 20; // 에러 감지

// const는 let과 같지만 상수인 점만 다름
const temp = 999;
// temp = 1000; // 타입 에러

function testFn2(){
    let let1 = 20;
    let let2 = 200;

    if(true){
        let let1 = 30;
        let let3 = 300;
    }
    // console.log("if문 내부 let3: " + let3); // 에러
}
testFn2();
// console.log("함수 내부에 선언한 let2: " + let2); // 에러

// var의 호이스팅: 변수가 선언되기도 전에 사용 가능하게 하는 기술
console.log(test); // undefined될 뿐 에러 안 남
var test = 10;
console.log(test);

// 자료형 확인
function typeTest(){
    const box = document.getElementById("typeBox");

    // undefined
    let temp;
    box.innerHTML = "temp: " + typeof temp;

    // string
    const name = "홍길동";
    box.innerHTML += "<br>name: " + name + " / " + typeof name;

    const gender = 'M';
    box.innerHTML += "<br>gender: " + gender + " / " + typeof gender;
    const phone = '01012341234';
    box.innerHTML += "<br>phone: " + phone + " / " + typeof phone;

    // number
    const age = 20;
    const height = 178.9;
    box.innerHTML += "<br>age: " + age + " / " + typeof age;
    box.innerHTML += "<br>height: " + height + " / " + typeof height;

    // boolean
    const isTrue = true;
    box.innerHTML += "<br>isTrue: " + isTrue + " / " + typeof isTrue;

    // object

    // JS의 배열(== object)
    const arr = [10, 20, 30, 40, 50];
    box.innerHTML += "<br>arr: " + arr + " / " + typeof arr;

    // Java의 객체: 클래스에 작성된 내용대로 heap 메모리에 할당
    // JS의 객체: {K:V} Map 형식 -> key는 무조건 string으로 고정
    const user = {"id":"user01", 'pw':'pass01', address:'서울시 중구'}
    box.innerHTML += "<br>user: " + user + " / " + typeof user;
    console.log(user);

    // 객체 V 출력 방법 1
    box.innerHTML += "<br>user.id: " + user.id;
    box.innerHTML += "<br>user.pw: " + user.pw;
    box.innerHTML += "<br>user.address: " + user.address;

    // 객체 V 출력 방법 2
    box.innerHTML += "<br>user['id']: " + user['id'];
    box.innerHTML += "<br>user['pw']: " + user['pw'];
    box.innerHTML += "<br>user['address']: " + user['address'];

    // function(함수도 자료형)
    const sumFn = function(n1, n2){return n1 + n2;}
    // 함수명만 작성: 함수에 작성된 코드가 그대로 출력
    box.innerHTML += "<br>sumFn: " + sumFn + " / " + typeof sumFn;
    // 함수명() 작성: 함수 실행
    box.innerHTML += "<br>sumFn(1, 2): " + sumFn(1, 2);

    // doubleFn 함수 호출
    box.innerHTML += "<br>doubleFn(sumFn): " + doubleFn(sumFn);
}

function doubleFn(fn){ // 전달받은 함수의 결과를 2배로 반환하는 함수
    return fn(1, 2) * 2;
}