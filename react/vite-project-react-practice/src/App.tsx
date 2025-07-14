import { useState } from "react";
import "./App.css";

function App() {
  const [boolean, setBoolean] = useState(false);

  const testasyncfunc = async (): Promise<string> => {
    const response = await (() => {
      return new Promise<string>((resolve) => {
        setTimeout(() => {
          resolve("Hello World");
        }, 2000);
      });
    })();
    console.log(response);
    return response;
  };

  const testasyncfunc2 = async () => {
    setBoolean(true);
    const response: string = await testasyncfunc();
    if (response == "Hello World") {
      console.log("Hello World");
    } else {
      console.log("Not Hello World");
    }

    setBoolean(false);
    console.log("End of testasyncfunc2");
  };

  return (
    <>
      <div>
        <h1>My First React App</h1>
        <h2>Start editing to see some magic happen!</h2>
      </div>
      <button onClick={testasyncfunc2}>
        {boolean ? "Loading..." : "Not Loading"}
      </button>

      <button className="bg-red-500 text-white font-bold py-2 px-4 rounded">
        Click me
      </button>
    </>
  );
}

export default App;
