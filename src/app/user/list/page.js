import {useEffect, useState} from "react";

'use-client';
export const tableColumns=[
    {
        name: "First Name",
        selector:(row)=> `${row.firstName}`, //f-ja koja prolazi kroz niz podataka i govori tabeli koje polje iz svakog reda treba da prikaze u toj koloni.
        sortable:false
    },
    {
        name: "Last Name",
        selector:(row)=> `${row.lastName}`,
        sortable:false
    }
]

export default function UserList(){
    const [pageNumber,setPageNumber]=useState(1);
    const[pageSize,setPage]=useState(10);


    const {getData,loading, data}=userListData(`user/get-user-page-list?pageNumber=${pageNumber-1}&pageSize=${pageSize}`);

    useEffect(() => {
        getData(`user/get-user-page-list?pageNumber=${pageNumber-1}&pageSize=${pageSize}`)
    }, [pageSize,pageNumber]);

    const  handlePageChange=async (page)=>{
        setPageNumber(page);
    }
    const handlePerRowsChange=async(newPerPage,page)=>{
        setPageNumber(page);
        setPageSize(newPerPage);
    }
}