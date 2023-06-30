import React from 'react';

// props
// - 부모 컴포넌트가 자식 컴포넌트에게 데이터 전달 시 사용하는 객체
// - 부모에서 자식으로만 전달할 수 있음(역은 불가능)

test(); // 함수를 먼저 해석하기 때문에 찍힘
// PropsEx(); // 변수는 위에서부터 차례대로 해석하기 때문에 찍히지 않음(에러)

function test() { // 함수로 적는 전통적인 작성법
    console.log('test');
}

const ChildComponent = (props) => {

    return (
        <>
        
            <ul>
                <li>이름: {props.name}</li>
                <li>나이: {props.age}</li>
            </ul>

        </>
    );
}

const MenuPrint = (props) => {

    return (
        <h4>김밥:{props.김밥}, 떡볶이:{props.떡볶이}</h4>
    );
}

const PropsEx = (props) => { // 함수를 변수에 대입하는 요즘 트렌트의 작성법
    // props 매개변수: 부모로부터 전달받은 값이 담겨있는 객체

    console.log(props); // 객체 출력
    console.log(props.name); // 객체에 담긴 값 출력

    const menu = {'김밥':3000, '떡볶이':4000};

    return (
        <>

            <h1>{props.name}</h1>
            <ChildComponent name={props.name} age={props.name === '홍길동' ? 20 : 25}/> {/* PropsEx 밖에 export하지 못하기 떄문에 PropsEx에 담아서 export */}
            <MenuPrint {...menu}/>

        </>
    );
}

export default PropsEx;
