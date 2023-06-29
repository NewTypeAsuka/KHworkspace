import './App.css';
import Ex1 from './components/Exam1'; // 동일한 폴더 내에 있는(./) components 폴더의 Exam1.js를 가져와 Ex1이란 이름으로 사용
import Ex2 from './components/Exam2'; // 동일한 폴더 내에 있는(./) components 폴더의 Exam2.js를 가져와 Ex2이란 이름으로 사용

function App() {
  // 리액트의 컴포넌트는 딱 하나의 요소만을 반환할 수 있음
  // -> 여러 요소를 반환하고 싶을 떄는 부모 요소로 묶어서 반환(Spring에서 Map에 담는 것 처럼)
  return (
    /* fragment(<> </>): 반환되는 요소를 감싸는 부모 요소를 대신하는 유령 태그(해석이 안됨) */
    <>

      {/* jsx 주석 */}
      <h1>Hello React!</h1>
      <div>Wow! It's React!</div>

      <Ex1/>
      <Ex2/>
      
    </>
  );
}

export default App;