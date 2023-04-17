const count = document.getElementById("count");
const content = document.getElementById("content");
content.addEventListener("input", e => {
    // input: box 안에 붙여넣기하는 경우까지 모두 인식
    count.innerText = e.target.value.length;
    if(e.target.value.length > 100){
        count.classList.add("error");
    } else {
        count.classList.remove("error");
    }
    // 요소.classList.toggle("클래스명"):
    // 요소에 클래스가 없으면 추가(true 반환), 없으면 제거(false 반환)
});