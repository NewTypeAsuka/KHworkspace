import React, { useState, useContext } from 'react';
import { TodoListContext } from './App';

const TodoList = () => {
    const { todoList, setTodoList, loginMember } = useContext(TodoListContext);
    const [inputTodo, setInputTodo] =  useState('');

    let keyIndex = 0;

    // 할 일 추가
    const handleAddTodo = () => {}

    // O, X 업데이트
    const handleToggleTodo = () => {}

    // 삭제
    const handleDeleteTodo = () => {}

    return(
        <>
            <h1>{loginMember.name}의 Todo List</h1>

            <div className="todo-container">

            <h3>할 일(Todo) 입력</h3>
            <div>
                <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)} />
                <button onClick={handleAddTodo}>Todo 추가</button>
            </div>

            <ul>
                {/* 배열.map : 기존 배열을 이용해서 새로운 배열 만들기 */}
                {todoList.map((todo, index) => (
                    <li key={keyIndex++}>
                        <div>
                            <span className={todo.isDone === 'O' ? 'todo-compleate' : ''}> {todo.title} </span>

                            <span>
                                <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                            </span>
                        </div>
                    </li>
                ))}
            </ul>
            {/* {배열명} */}

            </div>
        </>
    );
}

export default TodoList;