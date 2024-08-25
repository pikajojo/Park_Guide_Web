import React, { useState } from 'react'
import { createPark } from '../services/ParkService'
import { useNavigate } from 'react-router-dom'

const ParkComponent = () => {
  const[name, setName] = useState('')
  const[country, setCountry] = useState('')
  const[city, setCity] = useState('')
  const[price, setPrice] = useState(0)
  const[weblink, setWeblink] = useState('')

  const navigator = useNavigate();

  const[errors, setErrors] = useState(
    {
      name:'',
      country:'',
      city:''
    }
  )

  function validateForm(){
    let valid = true;

    const errorcopy = {... errors};

    if (name.trim()){
      errorcopy.name = '';
    }else{
      errorcopy.name = 'Park name is required!';
      valid = false;
    }

    if (country.trim()){
      errorcopy.country = '';
    }else{
      errorcopy.country = 'Park country is required!';
      valid = false;
    }

    if (city.trim()){
      errorcopy.city = '';
    }else{
      errorcopy.city = 'Park city is required!';
      valid = false;
    }

    setErrors(errorcopy);

    return valid;


  }




  function savePark(e){
    e.preventDefault();

    if(validateForm){

    const park = {name, country, city, price ,weblink}

    createPark(park)
    .then((response)=>{

      console.log(response.data);
      navigator('/parks')

    })

    }

    
   

    

  }




  return (
    <div className='container'>
      <br />
      <br />
      <br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3' >
        <h2 className='text-center'>Add Park you like to go</h2>
        <div className='card-body'>
          <form>
            <div className='form-group mb-2'>
              <label className='form-label'>Name</label>
              <input type="text"
              name='name' 
              // the value here need to be the same as the first parameter in the useState
              value={name}
              placeholder='Enter the park name here'
              className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}

              onChange={(e) => setName(e.target.value)}/>
              <label className='form-label'>Country</label>
              <input type="text"
              name='country' 
              value={country}
              placeholder='Enter the park country here'
              className='form-control'
              onChange={(e)=>setCountry(e.target.value)}/>
              <label className='form-label'>City</label>
              <input type="text"
              name='city' 
              value={city}
              placeholder='Enter the park city here'
              className='form-control'
              onChange={(e)=>setCity(e.target.value)}/>
              <label className='form-label'>Price</label>
              <input type="number"
              step="0.01"
              name='price' 
              value={price}
              placeholder='Enter the park price here'
              className='form-control'
              onChange={(e)=>setPrice(e.target.value)}/>
              <label className='form-label'>Weblink</label>
              <input type="text"
              name='weblink' 
              value={weblink}
              placeholder='Enter the weblink here'
              className='form-control'
              onChange={(e)=>setWeblink(e.target.value)}/>


            </div>
          </form>

          <button className='btn btn-success' onClick = {savePark}>Submit</button>


        </div>

      </div>
    </div>
    </div>
  )
}

export default ParkComponent