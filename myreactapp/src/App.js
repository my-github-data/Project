// App.js
import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import Login from './Login';
import Home from './Home';

function App() {
  return (
    <div>
      <Switch>
        <Route exact path="/login" component={Login} />
        <Route exact path="/home" component={Home} />
        <Redirect exact from="/" to="/login" />
      </Switch>
    </div>
  );
}

export default App;
