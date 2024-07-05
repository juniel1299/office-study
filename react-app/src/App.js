import Button from "./Button";
import styles from "./App.module.css";
import {useState, useEffect } from "react";
function App() {
  const [counter,setValue] = useState(0);
  const onClick =() => setValue((prev) => prev + 1);
  console.log("I run all the time");
  useEffect(() => {
    console.log("Call the API");
  },[]);
  //useEffect는 한번만 실행할 때 쓰는거 , 안 쓰면 항상 실행되는거 
  return (
   
    <div>
       <h1>{counter}</h1>
       <button onClick={onClick}>click me </button>
    </div>

  );
}

export default App;
