import {useListActions} from "@/contexts/listActionContext";
import listAction from "@/core/listAction";
import {useForm} from "react-hook-form";
import {useEffect} from "react";
import {Modal, ModalBody, ModalHeader, ModalFooter, Row, Col, Button} from "reactstrap";
import {put} from "@/services/api";

export const UpdateUserDialog = ({isOpen}) => {
    const {state, dispatch} = useListActions();

    const toggle = () => dispatch({
        type: listAction.RESET
    });

    console.log(state.row);
    const {
        register,
        handleSubmit,
        formState: {errors},
        setValue
    } = useForm({
        mode: 'onSubmit',
        defaultValues: state.row
    });

    useEffect(() => {
        if (state.row) {
            setValue("firstName", state.row.firstName);
            setValue("lastName", state.row.lastName);
            setValue("email", state.row.email);
            setValue("id", state.row.id);
            setValue("contactNumber", state.row.contactNumber);
        }
    }, [state, setValue]);

    return (
        <Modal isOpen={isOpen} toggle={toggle}>
            <ModalHeader toggle={toggle}>Modal Title</ModalHeader>
            <ModalBody>
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

                    <Col md={6}>
                        <input type="text" className="form-control" placeholder="Email" {...register("email", {
                            required: "Email is required"
                        })} />
                        {errors && errors.email && (
                            <span className="text-danger">{errors.email.message}</span>
                        )}
                    </Col>

                    <Col md={6}>
                        <input type="text" className="form-control" placeholder="Contact number" {...register("contactNumber", {
                            required: "Contact number is required",
                            maxLength: 14,
                            minLength: 8,
                            validate: (value) => {
                                if(!/^[0-9]+$/.test(value))
                                {
                                    return "Enter a valid contact number";
                                }
                            }
                        })} />
                        {errors && errors.contactNumber && (
                            <span className="text-danger">{errors.contactNumber.message}</span>
                        )}
                    </Col>
                </Row>
            </ModalBody>

            <ModalFooter>
                <Button className="btn btn-success" type="button" onClick={handleSubmit(async (data) => {
                    await put("/user/update", data);

                    dispatch({
                        type: listAction.RELOAD,
                    });
                })}>
                    Submit
                </Button>
                <Button color="secondary" onClick={toggle}>
                    Cancel
                </Button>
            </ModalFooter>
        </Modal>
    );
};
export default UpdateUserDialog;