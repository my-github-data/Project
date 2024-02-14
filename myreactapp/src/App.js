import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import Login from './Login';
import Home from './Home'; // Import the Home component correctly
import Register from './Register';
import ChangePass from './ChangePass';

function App() {
  return (
    <div>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/home" component={Home} />
        <Route exact path="/login" component={Login} />
        <Route exact path="/register" component={Register} />
        <Route exact path="/changepass" component={ChangePass} />
        <Redirect to="/" />
      </Switch>
    </div>
  );
}

export default App;
