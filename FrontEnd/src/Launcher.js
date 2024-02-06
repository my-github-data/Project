import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './common.css';
import {Link, Switch, Route} from 'react-router-dom';
import Home from './Home';
import About from './About';
import Dashboard from './Dashboard';
import NotFound from './NotFound';
import Register from './Registration';
import Login from './Login';


function Launcher() {
    return ( <div className='container'>
                <img src='http://localhost:3000/logo.jpg' alt='logo'
                    className='logo'/>
                <hr></hr>
                    <Link to="/register">Register</Link> {" | "}
                    <Link to="/login">Login</Link> {" | "}
                    <Link to="/home">Home</Link> {" | "}
                    <Link to="/about">About Us</Link> {" | "}
                    <Link to="/db">Dashboard</Link> {" | "}
                <hr></hr>
                    <Switch>
                        <Route exact path="/register" component={Register}/>
                        <Route exact path="/login" component={Login}/>
                        <Route exact path="/home" component={Home}/>
                        <Route exact path="/about" component={About}/>
                        <Route exact path="/db" component={Dashboard}/>
                        <Route path="**" component={NotFound}/>
                    </Switch>
             </div> );
}

export default Launcher;