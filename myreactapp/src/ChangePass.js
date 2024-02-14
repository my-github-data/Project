import React from 'react';
import { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import axios from "axios";

function ChangePass() {
    const history = useHistory(); // Initialize useHistory
    const [user, setUser] = useState({ emailId: "", password: "" });
    const [message, setMessage] = useState("");
    const url = "http://localhost:8080/user/changePassword";

    const onTextChange = (args) => {
        var usr1 = { ...user };
        usr1[args.target.name] = args.target.value;
        setUser(usr1);
    }

    const showMessage = (msgText) => {
        setMessage(msgText);
        window.setTimeout(() => {
            setMessage("");
        }, 3000);
    }

    const resetPass = () => {
        //debugger;
        axios.put("http://localhost:8080/user/changePassword", user).then((result) => {
            if (result.data != null) {
                showMessage("Password Changed!!");
                history.push("/login");
            }
        })
            .catch(error => {
                console.error("Axios request failed", error);
                // You can log the error details or handle it appropriately
            });
    }



    return (
        <div className="container">
            <div className="table-responsive">
                <table className="table-bordered">
                    <tbody>
                        <tr>
                            <td>Email</td>
                            <td><input type="email" name="emailId" value={user.emailId} onChange={onTextChange}></input></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" value={user.password} onChange={onTextChange}></input></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" onClick={resetPass} value="Reset"></input></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default ChangePass;
