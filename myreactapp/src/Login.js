import { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom"; // Import useHistory
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import axios from "axios";
import "./Login.css"
import Navbar from "./Navbar";
import Footer from "./Footer";

function Login() {
    const history = useHistory(); // Initialize useHistory
    const [user, setUser] = useState({ emailId: "", password: "" });
    const [message, setMessage] = useState("");
    const url = "http://localhost:8080/login";

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

    const handleLogin = () => {
        //debugger;
        axios.post("http://localhost:8080/user/login", user).then((result) => {
            if (result.data != null) {
                showMessage("Login successfully!");
                localStorage.setItem("userId", result.data.id);
                history.push("/home"); 
            }
        })
            .catch(error => {
                console.error("Axios request failed", error);
            });
    }



    return (
        <>
            <Navbar />
            <div className="outcontainer">
                <div className="container">
                    <div className="form">
                        <h2>Login</h2>
                        <div className="box1">
                            <input type="email" name="emailId" placeholder="Email" value={user.emailId} onChange={onTextChange}></input>

                            <input type="password" name="password" placeholder="Password" value={user.password} onChange={onTextChange}></input>
                        </div>
                            <h6><Link to="/changepass">Change Password</Link></h6>
                        <div className="box2">

                            <button className="btn" type="submit" onClick={handleLogin}>Login</button>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default Login;
