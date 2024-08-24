import React, {useEffect, useState} from 'react'
import { listParks } from '../services/ParkService'

const ListParkComponent = () => {

const [parks, setParks] = useState([])

useEffect( () => {
    listParks().then( (response) =>{
        setParks(response.data);
}).catch((error) => {
    console.error(error);
})

}, [])
   


return (
    <div className='container'>
        <h2 className='text-center'>List of Parks</h2>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Park Name</th>
                    <th>Country</th>
                    <th>City</th>
                    <th>Standard Price</th>
                    <th>Web link</th>

                </tr>
            </thead>

            <tbody>
                {parks.map(park => 
                    <tr key={park.id}>
                        <td>{park.id}</td>
                        <td>{park.name}</td>
                        <td>{park.country}</td>
                        <td>{park.city}</td>
                        <td>{park.price}</td>
                        <td>{park.webLink}</td>
                    </tr>
                )}
            </tbody>

        </table>



        
    </div>




  )
}

export default ListParkComponent
