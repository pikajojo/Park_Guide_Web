import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/parks';

export const listParks = () => {
    return axios.get(REST_API_BASE_URL);
}

//cooperate with save park in the ParkComponent
//post method needs the parameter which is the park object together 
export const createPark = (park) => axios.post(REST_API_BASE_URL, park);