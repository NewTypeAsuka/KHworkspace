document.getElementById("createBtn").addEventListener("click", () => {
    const lottoList = [];

    while(lottoList.length < 6){
        const random = Math.floor(Math.random()*45+1);
        if(lottoList.indexOf(random) == -1) lottoList.push(random);
    }

    lottoList.sort((a,b) => a-b);

    for(let i=0; i<lottoList.length; i++){
        container.children[i].innerText = lottoList[i];
    }
});
