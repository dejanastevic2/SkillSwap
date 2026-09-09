'use client';
import {useEffect, useState} from "react";
import useListData from "@/hooks/useListData";
import DataTable from "react-data-table-component";
import { Spinner } from "reactstrap";

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
    const [pageSize,setPageSize]=useState(10); //10prikaza nor 10 monitora na jednoj stranici


    const {getData, loading, data} = useListData(`user/get-page-list?pageNumber=${pageNumber-1}&pageSize=${pageSize}`);

    useEffect(() => {
        getData(`user/get-page-list?pageNumber=${pageNumber-1}&pageSize=${pageSize}`);
    }, [pageSize, pageNumber]);

    const handlePageChange=async (page)=>{
        setPageNumber(page);
    }
    const handlePerRowsChange=async(newPerPage,page)=>{
        setPageNumber(page);
        setPageSize(newPerPage);
    };
    console.log("Podaci sa backenda:", data);
    return (
        <>
            {data!=null && <DataTable data={data.users} //prikazi tabelu samo ako data postoji
                                      columns={tableColumns}
                                      striped={true}
                                      noHeader={true}
                                      pagination
                                      paginationServer
                                      progressPending={loading}
                                      paginationTotalRows={data.totalElements}
                                      onChangePage={handlePageChange}
                                      onChangeRowsPerPage={handlePerRowsChange}
                                      progressComponent={<Spinner color="danger">Ucitavanje...</Spinner>}
                                      highlightOnHover

            />}
        </>

    );
}