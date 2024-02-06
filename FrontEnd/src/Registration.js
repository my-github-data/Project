import { useEffect, useState } from "react";
import axios from "axios";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';


function Register() {

    const [user, setUser] = useState({ name: "", emailId: "", phoneNo: "", password: "" })
    const url = "http://localhost:8080/user/register";

    const OnTextChange = (args) => {
        var user1 = {...user}
        user1[args.target.name] = args.target.value;
        setUser(user1);
    }

    const AddUser = ()=>{
        debugger;
        axios.post(url, user).then((result)=>{
            if(result.data.affectedRows !== undefined &&
                result.data.affectedRows > 0){
                }
        });
    }

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