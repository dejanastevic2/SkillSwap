import axios from "axios";
export const Axios=axios.create({
    baseURL:'http://localhost:3000/',
    timeout:5000,
    headers:{
        'Content-Type':'application/json',

    },
});

export const get=async(url,params) =>{
    return await Axios.get(url,params);
}
export const post=async(url,params) =>{
    return await Axios.post(url,params);
}