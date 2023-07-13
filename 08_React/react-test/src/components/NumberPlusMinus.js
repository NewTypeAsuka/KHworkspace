import React, { useState } from 'react';

const NumberPlusMinus = () => {

    const [count, setCount] = useState('');

    return (

        <div className="numberContainer">
            <button className="minusBtn" onClick={() => setCount(count - 1)}>-</button>
            <div className="number">{count}</div>
            <button className="plusBtn" onClick={() => setCount(count + 1)}>+</button>
        </div>
    )
}

export default NumberPlusMinus;