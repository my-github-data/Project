import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import Login from './Login';
import Home from './Home'; // Import the Home component correctly
import Register from './Register';
import ChangePass from './ChangePass';
import PackageM from './PackageM';
import PackageN from './PackageN';
import PackageI from './PackageI';
import Package from './Package';
import PackageData from './PackageData';
import Enquiry from './Enquiry';
import AboutUs from './AboutUs';
import Feedback from './Feedback';
import Review from './Review';

function App() {
  return (
    <div>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/home" component={Home} />
        <Route exact path="/enquiry" component={Enquiry} />
        <Route exact path="/aboutus" component={AboutUs} />
        <Route exact path="/login" component={Login} />
        <Route exact path="/register" component={Register} />
        <Route exact path="/changepass" component={ChangePass} />
        <Route exact path="/packages" component={Package} />
        <Route exact path="/packagesm" component={PackageM} />
        <Route exact path="/packagesn" component={PackageN} />
        <Route exact path="/packagesi" component={PackageI} />
        <Route path="/packagedata/:id" component={PackageData} />
        <Route path="/review/:packageId" component={Review} />
        <Route path="/feedback" component={Feedback} />
        <Redirect to="/" />
      </Switch>
    </div>
  );
}

export default App;
