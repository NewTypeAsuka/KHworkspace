// 계산 버튼 클릭 시 input 태그에 작성된 값을 모두 읽어와 합한 결과를 alert로 출력
document.getElementById("calc").addEventListener("click", () => {
    const list = document.getElementsByClassName("in");
    let sum = 0;
    for(let i=0; i<list.length; i++){
        sum += Number(list[i].value);
    }
    alert(sum);
});

// 추가 버튼이 클릭되었을 때 .container 요소의 마지막 자식으로
// <div class="row">
//      <input type="number" class="in">
// </div> 요소 만들어서 추가하기
document.getElementById("add").addEventListener("click", () => {
    // 요소 만들기: document.createElement("태그명")
    // 요소 제거하기: 요소.remove()
    // 요소의 클래스 목록 확인하기: 요소.classList
    // 요소에 클래스 추가: 요소.classList.add("클래스명")
    // 요소에 클래스 제거: 요소.classList.remove("클래스명")
    // 요소에 속성, 값 추가: 요소.setAttribute("속성명", "값")
    // 요소에 속성, 값 제거: 요소.removeAttribute("속성명", "값")
    // 부모 요소의 마지막 자식 요소 추가: 부모요소.append("자식요소")
    // 부모 요소의 첫번째 자식 요소 추가: 부모요소.prepend("자식요소")
    // A의 다음 요소로 B를 추가: A.after(B)
    // A의 이전 요소로 B를 추가: A.before(B)
    const div = document.createElement("div");
    div.classList.add("row");
    const input = document.createElement("input");
    input.classList.add("in");
    input.setAttribute("type", "number");
    const span = document.createElement("span"); // span 요소 만들기
    span.classList.add("remove-row");
    span.innerHTML = "&times;";
    span.addEventListener("click", e => { // 만들어진 span 요소에 이벤트리스너 추가
        e.target.parentElement.remove(); // 클릭된 요소의 부모 요소 삭제 == row 삭제
    }); 
    div.prepend(input);
    div.append(span); // div의 마지막 자식으로 span 추가
    document.querySelector(".container").append(div);
});

// 삭제 버튼 동작 테스트
document.querySelector(".remove-row").addEventListener('click', e => {
    console.log(e.target.parentElement); // 이벤트가 발생한 요소의 부모 요소(.row)
    e.target.parentElement.remove();
});