
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListParkComponent from './components/ListParkComponent'
import { BrowserRouter, Route, Routes} from 'react-router-dom'
import ParkComponent from './components/ParkComponent'

function App() {


  return (

    <>
    <BrowserRouter>

    
    <HeaderComponent />

    <Routes>

      {/* //http://localhost/3000 */}
      <Route path='/' element={ <ListParkComponent />}>
      </Route>



      {/* //http://localhost/3000/Parks */}
      <Route path='/parks' element={ <ListParkComponent />}>
      </Route>


      {/* //http://localhost/3000/add-park */}
      <Route path='/add-park' element= {<ParkComponent />}>

      </Route>

    </Routes>

    <FooterComponent />

    </BrowserRouter>
    
    </>
          
  )
}

export default App
