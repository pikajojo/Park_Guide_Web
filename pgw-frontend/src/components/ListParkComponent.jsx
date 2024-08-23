import React from 'react'

const ListParkComponent = () => {

const dummyData = [
   {"id":1,
    "name": "Botany Park",
    "country": "China",
    "city": "Jinan",
    "price": "0",
    "webLink":"ddd",
   } ,
   {"id":2,
    "name": "Animal Park",
    "country": "China",
    "city": "Jinan",
    "price": "0",
    "webLink":"ddd",
   } ,
   {"id":3,
    "name": "Forest Park",
    "country": "China",
    "city": "Jinan",
    "price": "0",
    "webLink":"ddd",
   } ,
]


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
                {dummyData.map(park => 
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
