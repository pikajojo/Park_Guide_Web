import React, {useEffect, useState} from 'react'
import { listParks, deletePark } from '../services/ParkService'
import { useNavigate } from 'react-router-dom'

const ListParkComponent = () => {

const [parks, setParks] = useState([])
const navigator  = useNavigate();

useEffect( () => {
    getAllParks();
}, [])


function getAllParks(){
    listParks().then( (response) =>{
        setParks(response.data);
}).catch((error) => {
    console.error(error);
})

}


function addNewPark()  {

    return navigator('/add-park');

}

function updatePark(id) {
    return navigator( `/edit-park/${id} `);
}

function removePark(id){
    console.log(id);

    deletePark(id)
    .then((response)=>{
        getAllParks();

    })
    .catch(error => {
        console.error(error);
    })

}
   


return (
    <div className='container'>
        <h2 className='text-center'>List of Parks</h2>
        <button className="btn btn-outline-info mb-2" onClick={addNewPark}>Add Park</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Park Name</th>
                    <th>Country</th>
                    <th>City</th>
                    <th>Standard Price</th>
                    <th>Web link</th>
                    <th>Action</th>

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
                        <td>{park.weblink}</td>
                        <td>
                            <button className='btn btn-outline-info mb-2 w-100'  onClick={() => updatePark(park.id)}>Update</button>
                            <button className='btn btn-outline-danger mb-2 w-100' onClick={() => removePark(park.id)}>Delete</button>
                        </td>
                    </tr>
                )}
            </tbody>

        </table>



        
    </div>




  )
}

export default ListParkComponent
