// 배열 생성 확인하기
document.getElementById("btn1").addEventListener("click", () => {
    const arr1 = new Array(); // 빈 배열
    const arr2 = new Array(3); // 3칸 배열
    const arr3 = []; // 빈 배열
    const arr4 = ['사과', '딸기', '바나나'];

    console.log(arr1);
    console.log(arr2);
    console.log(arr3);
    console.log(arr4);

    // 자료형 제한 없음 확인
    arr1[0] = '가나다';
    // 배열에 지정된 인덱스가 없으면 자동으로 추가
    // 중간에 인덱스를 건너 뛰더라도 건너 뛴 자리를 비워둠
    arr1[2] = 123;
    arr1[3] = 1.23;
    arr1[4] = true;
    arr1[5] = {"id":"user01", "pw":"pass01"};
    console.log(arr1);
});

// 배열 함수 확인하기
document.getElementById("btn2").addEventListener("click", () => {
    const arr = [];

    arr.push("김밥");
    arr.push("삼겹살");
    arr.push("갈비");
    arr.push("냉면");

    arr.unshift("샌드위치");
    arr.unshift("햄버거");

    console.log(arr.pop());
    console.log(arr);

    console.log(arr.shift());
    console.log(arr);

    console.log(arr.sort());

    const arr2 = [5, 3, 2, 10, 1];
    console.log(arr2.sort()); // arr2를 문자열로 기본 취급
    console.log(arr2.sort(function(a,b){return a-b})); // 정렬 기준 함수 추가
    console.log(arr2.sort((a,b) => b-a));

    console.log(arr.toString());
    console.log(arr.join("/"));
    arr.forEach(function(value){
        console.log("값: " + value);
    })
});