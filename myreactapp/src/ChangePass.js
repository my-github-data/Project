import React from 'react';
import { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import axios from "axios";
import './ChangePass.css';
import Navbar from './Navbar';
import Footer from './Footer';

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
        <>
            <Navbar />
            <div className="outcontainer2">
                <div className="container">
                    <div className="form">
                        <h3>Reset Password</h3>
                        <div className="box1">
                            <input type="email" name="emailId" placeholder="Email" value={user.emailId} onChange={onTextChange}></input>
                            <input type="password" name="password" placeholder="New Password" value={user.password} onChange={onTextChange}></input>
                            <div class="box2">
                                <input type="submit" className='btn' onClick={resetPass} value="Reset"></input>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default ChangePass;
