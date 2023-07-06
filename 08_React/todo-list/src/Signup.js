import React, { useState, createContext } from 'react';

const SignupContainer = () => {

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');
    const [pwCheck, setPwCheck] = useState('');
    const [name, setName] = useState('');
    const [result, setResult] = useState('');

    const [idValidation, setIdValidation] = useState(false);
    // false: 사용 불가
    // true: 사용 가능

    // 아이디 중복 체크 함수
    const idCheck = (inputId) => {
        // inputId: 입력한 아이디

        setId(inputId); // id 변수에 입력받은 아이디 대입

        // 4글자 미만, 15자 초과 검사 X
        if(inputId.trim().length < 4 || inputId.trim().length > 15) {
            setIdValidation(false);
            return;
        }

        fetch("/idCheck?id="+inputId)
        .then(resp => resp.text())
        .then(result => {
            console.log(`result: ${result}`);
            if(result == 0) { // 중복 X -> 사용 가능
                setIdValidation(true);
            } else { // 중복 O -> 사용 불가능
                setIdValidation(false);
            }
        })
        .catch(e => console.log(e));


    }

    // 회원가입 함수
    const signup = () => {

        const inputId = document.getElementById('inputId');
        const inputPw = document.getElementById('inputPw');
        const inputPwCheck = document.getElementById('inputPwCheck');
        const inputName = document.getElementById('inputName');

        if(id === 'hacking!') {
            setResult('아이디는 user01이고 비밀번호는 pass01이야!');
            return;
        }
        if(id === '') {
            setResult('아이디를 입력해주세요!');
            inputId.focus();
            return;
        }
        if(pw === '' || pwCheck === '') {
            setResult('비밀번호를 입력해주세요!');
            inputPw.focus();
            return;
        }
        if(name === '') {
            setResult('닉네임을 입력해주세요!');
            inputName.focus();
            return;
        }

        // 0. 아이디가 사용 불가인 경우(짧거나 중복인 상태)
        if(!idValidation) {
            alert('아이디를 다시 입력해주세요!');
            return;
        }

        // 1. 비밀번호와 비밀번호 확인이 일치하지 않으면 alert '비밀번호가 일치하지 않습니다.' 출력 후 return
        if(pw !== pwCheck) {
            // alert('비밀번호가 일치하지 않습니다!');
            setResult('비밀번호가 일치하지 않습니다!');
            return;
        }

        // *** 회원가입 요청(비동기, POST) ***
        fetch("/signup", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ // JS Object -> JSON
                id: id,
                pw: pw,
                name: name
            }) 
        })
        .then(resp => resp.text())
        .then(result => {
            // 2. id === 'user01', pw === 'pass01'이 맞으면 result에 '회원가입 성공' 출력 후 모든 input 내용 삭제
            // 3. id === 'user01', pw === 'pass01'이 아니면 result에 '아이디 또는 비밀번호가 일치하지 않습니다.' 출력
            if(result > 0) {
                setResult('회원가입에 성공했습니다!');
                setId('');
                setPw('');
                setPwCheck('');
                setName('');
            } else {
                setResult('회원가입에 실패했습니다!');
            }
        })
        .catch(e => console.log(e));

    }

    return (
    
        <div className="signup-container">
            <label>
                ID: <input id="inputId" type="text" onChange={ e => {
                    // setId(e.target.value)
                    idCheck(e.target.value)
                    } } value={id} className={idValidation ? '' : 'id-error'} autoComplete='off'></input>
            </label>
            <label>
                PW: <input id="inputPw" type="password" onChange={ e => {setPw(e.target.value)} } value={pw} autoComplete='off'></input>
            </label>
            <label>
                PW CHECK: <input id="inputPwCheck" type="password" onChange={ e => {setPwCheck(e.target.value)} } value={pwCheck} autoComplete='off'></input>
            </label>
            <label>
                NAME: <input id="inputName" type="text" onChange={ e => {setName(e.target.value)} } value={name} autoComplete='off'></input>
            </label>
            <hr/>
            <div className="btnBox">
                <button onClick={signup}>가입하기</button>
            </div>
            <hr/>
            <h3 className="result">{result}</h3>
        </div>
    );
}

export default SignupContainer;