import { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom"; // Import useHistory
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import axios from "axios";
import "./Login.css"

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
                if (result.data!=null) {
                    showMessage("Login successfully!");
                    history.push("/home"); // Redirect to home page
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
                            <td><Link to="/changepass">Change Password</Link></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" onClick={handleLogin}></input></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Login;
