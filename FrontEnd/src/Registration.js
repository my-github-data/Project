import { useEffect, useState } from "react";
import axios from "axios";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";


function Register() {
    const history = useHistory();
    const [user, setUser] = useState({ name: "", emailId: "", phoneNo: "", password: "" })
    const [message, setMessage]=useState("");
    const url = "http://localhost:8080/user/register";

    const OnTextChange = (args) => {
        var user1 = { ...user }
        user1[args.target.name] = args.target.value;
        setUser(user1);
    }
    const showMessage=(msgText)=>{
        setMessage(msgText);
        window.setTimeout(()=>{
            setMessage("");
        },3000);
    }
    const AddUser = () => {
        axios.post(url, user)
            .then((result) => {
                if (result.data != null) {
                    console.log(result);
                    showMessage("Registered Successfully!!");
                    history.push("/login");
                }
            })
            .catch((error) => {
                console.error('Error adding user:', error);
                if (error.response) {
                    // The request was made and the server responded with a status code
                    // that falls out of the range of 2xx
                    console.error('Response data:', error.response.data);
                    console.error('Response status:', error.response.status);
                    console.error('Response headers:', error.response.headers);
                } else if (error.request) {
                    // The request was made but no response was received
                    console.error('No response received. Request:', error.request);
                } else {
                    // Something happened in setting up the request that triggered an Error
                    console.error('Error setting up the request:', error.message);
                }
                showMessage("Error registering user. Please try again.");
            });
    };
    

    // const ClearBoxes = ()=>{
    //     setUser({ name: "", emailId: "", phoneNo: "", password: "" });
    // }

    return (<div className="container">
        <div className="table-responsive">
            <table className="table table-bordered">
                <tbody>
                    <tr>
                        <td>UserName</td>
                        <td>
                            <input name="name" value={user.name} onChange={OnTextChange} />
                        </td>
                    </tr>
                    <tr>
                        <td>EmailId</td>
                        <td>
                            <input name="emailId" value={user.emailId} onChange={OnTextChange} />
                        </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>
                            <input name="phoneNo" value={user.phoneNo} onChange={OnTextChange} />
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input name="password" value={user.password} onChange={OnTextChange} />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button className="btn btn-success" onClick={AddUser}>Add User</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>)
}

export default Register;