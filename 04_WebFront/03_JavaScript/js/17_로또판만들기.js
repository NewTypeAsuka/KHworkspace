const lottoBoard = document.getElementById("lottoBoard");
const createBtn = document.getElementById("createBtn");

createBtn.addEventListener("click", () => {
    lottoBoard.innerHTML = ""; // 이전에 생성된 내용 모두 삭제
    for(let i=1; i<=45; i++){
        const div = document.createElement("div");
        div.innerText = i;
        div.classList.add("number");
        div.addEventListener("click", e => { // div가 클릭되었을 때 배경색 변경/제거 + 6개 제한
            if(e.target.classList.contains("actice")) {
                e.target.classList.toggle("active");
            } else {
                if(document.getElementsByClassName("active").length >= 6){
                    alert("6개까지만 선택할 수 있습니다.");
                    return;
                }
                e.target.classList.toggle("active");
            }
        });
        lottoBoard.append(div);
    }
});

document.getElementsByClassName("number").addEventListener("click", () => {
    
});