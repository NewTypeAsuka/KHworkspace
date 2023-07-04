import React, {useState} from 'react';

// 리액트는 컴포넌트의 상태가 변할 때마다 리렌더링 수행
const InputTest = () => {

    //        변수          함수
    const [inputValue, setInputValue] = useState('초기값');
    // inputValue: 값을 저장하는 변수
    // setInputValue: inputValue에 값을 대입하는 setter 역할의 함수

    const changeInputValue = (e) => {

        console.log(e.target.value);
        setInputValue(e.target.value);
    }

    return (

        // 첫 렌더링: value="초기값"
        // -> input의 값을 변경(컴포넌트의 상태 변화 -> 리렌더링 진행)
        //     + onChange(값이 변했을 때) -> changeInputValue 함수 실행
        //      -> inputValue에 e.target.value(변화된 값) 대입
        <input type="text" value={inputValue}
        
            // onChange={ (e) => {setInputValue(e.target.value)} }/>
            onChange={changeInputValue}/>
    );
};

export default InputTest;