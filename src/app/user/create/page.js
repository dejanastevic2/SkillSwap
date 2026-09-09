'use client';

import { useForm } from "react-hook-form";
import { Row, Col, Button } from "react-bootstrap";
import { post } from "../../../core/httpClient";
import { useRouter } from "next/navigation";

export default function UserCreate() {
    const router = useRouter();
    const {
        register,
        handleSubmit,
        formState: { errors }
    } = useForm({
        mode: "onSubmit",
    });

    const onSubmit = async (data) => {
        try {
            await post("user/create", data);
            router.push("/user/list"); // Vraća te na listu korisnika nakon uspešnog unosa
        } catch (error) {
            console.error("Greška pri kreiranju korisnika:", error);
        }
    };

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <Row className="mb-3">
                <Col md={6}>
                    <input type="text" className="form-control" placeholder="First Name" {...register("firstName", {
                        required: "First Name is required",
                        maxLength: 50,
                        minLength: 3,
                    })} />
                    {errors && errors.firstName && (
                        <span className="text-danger">{errors.firstName.message}</span>
                    )}
                </Col>
                <Col md={6}>
                    <input type="text" className="form-control" placeholder="Last Name" {...register("lastName", {
                        required: "Last Name is required",
                        maxLength: 50,
                        minLength: 3,
                    })} />
                    {errors && errors.lastName && (
                        <span className="text-danger">{errors.lastName.message}</span>
                    )}
                </Col>
            </Row>

            <Row className="mb-3">
                <Col md={6}>
                    <input type="email" className="form-control" placeholder="Email" {...register("email", {
                        required: "Email is required",
                    })} />
                    {errors && errors.email && (
                        <span className="text-danger">{errors.email.message}</span>
                    )}
                </Col>

                <Col md={6}>
                    <input type="text" className="form-control" placeholder="Contact Number" {...register("contactNumber", {
                        required: "Contact Number is required",
                        maxLength: 15,
                        minLength: 7,
                        validate: (value) => {
                            if (!/^[0-9]+$/.test(value)) {
                                return "Enter a valid contact number! ";
                            }
                        }
                    })} />
                    {errors && errors.contactNumber && (
                        <span className="text-danger">{errors.contactNumber.message}</span>
                    )}
                </Col>
            </Row>
            <Row>
                <Col md="12">
                    <Button className="btn btn-primary" type="submit">
                        Submit
                    </Button>
                </Col>
            </Row>
        </form>
    );
}