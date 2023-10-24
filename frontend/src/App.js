import React from 'react';
import './App.css';
import HomePage from './Components/HomePage/HomePage';
import LoginPage from './Components/LoginPage/LoginPage';
// import {BrowserRouter, Route, Routes} from 'react-router-dom';
// import Home from './Components/Pages/Home';
// import Search from './Components/Pages/Search';
// import Explore from './Components/Pages/Explore';

function App() {
  return (
    <div className="App">
      <LoginPage />
      {/* <HomePage /> */}
    </div>
  );
}

// function App(){
//   return(
//     <BrowserRouter>
//       <HomePage>
//         <Routes>
//           <Route path='/' element={<Home/>} />
//           <Route path='/home' element={<Home/>} />
//           <Route path='/search' element={<Search/>} />
//           <Route path='/explore' element={<Explore/>} />
//         </Routes>
//       </HomePage>
//     </BrowserRouter>
//   );
// }

export default App;
