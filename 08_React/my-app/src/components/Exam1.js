// node-modules 폴더에 있는 react 패키지를 가져옴
import React, { Component } from 'react';

// 클래스형 컴포넌트 만들기
// 1. Component 상속받기
// 2. render() 함수 작성하기(필수)
// 3. 만든 class를 export default로 지정하기
class Exam1 extends Component {
    
    constructor(props) {
        super(props);
        this.state = {count : 100};
    }
    handleClick = () => {
        this.setState( {count : this.state.count + 1} );
    }

    // 화면 렌더링 시 render() 함수에서 반환된 값이 화면에 출력
    render() {
        return (
            <>

                <h2>클래스형 컴포넌트</h2>
                <h1>Count: {this.state.count}</h1>
                <button onClick={this.handleClick}>증가</button>

            </>
        );
    }
}

export default Exam1;