import React, { useState } from 'react';

const InputPrint = () => {

    const [result, setResult] = useState('');
    const [temp, setTemp] = useState('');

    return (

        <div className="inputContainer">
            <div className="topBox">
                <input className="inputText" type="text" onChange={e => setTemp(e.target.value)}></input>
                <button className="sendBtn" onClick={() => setResult(temp)}>보내기</button>
            </div>
            <div className="bottomBox">
                <h2 className="result">{result}</h2>
            </div>
        </div>
    )
}

export default InputPrint;