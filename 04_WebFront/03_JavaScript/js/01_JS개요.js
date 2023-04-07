// 이 파일 자체가 script 태그라고 생각

function btnClick2(){
    alert("Hello World");
}

// 다크모드
function darkMode(){
    const body = document.querySelector("body");
    // JS는 카멜 표기법
    body.style.backgroundColor = 'black';
    body.style.color = 'white';
}
// 라이트모드
function lightMode(){
    const body = document.querySelector("body");
    // JS는 카멜 표기법
    body.style.backgroundColor = 'white';
    body.style.color = 'black';
}