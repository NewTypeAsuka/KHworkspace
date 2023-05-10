// 좋아요 버튼이 클릭되었을 때
const boardLike = document.getElementById("boardLike");

boardLike.addEventListener("click", e => {

    // 로그인 여부 검사
    if(loginMemberNo == ""){
        alert("로그인 후 이용해주세요");
        return;
    }

    let check; // 기존에 좋아요 X(빈 하트): 0 / 좋아요 O(꽉 찬 하트): 1

    // contains("클래스명"): 클래스가 있으면 true, 없으면 false 반환
    if(e.target.classList.contains("fa-regular")){
        check = 0;
    } else {
        check = 1;
    }

    // ajax로 서버로 제출할 파라미터를 모아둔 JS 객체
    const data = {"boardNo": boardNo, "memberNo": loginMemberNo, "check": check};

    // ajax 코드 작성
    fetch("/board/like", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(response => response.text()) // 응답 객체를 필요한 형태로 파싱
    .then(count => { // 파싱된 데이터를 받아서 처리하는 코드 작성
        console.log("count: " + count);

        if(count == -1){ // INSERT, DELETE 실패 시
            console.log("좋아요 처리에 실패했습니다.");
            return;
        }

        // toggle(): 클래스가 있으면 없애고, 없으면 추가하고
        e.target.classList.toggle("fa-regular");
        e.target.classList.toggle("fa-solid");

        // 현재 게시글의 좋아요 수를 화면에 출력
        e.target.nextElementSibling.innerText = count;
    })
    .catch(err => {
        console.log("에외가 발생하였습니다.");
        console.log(err);
    })
    
});