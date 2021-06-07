import React from "react";
import {HashRouter, Route, Switch} from 'react-router-dom';
import Login from './Login';
import Welcome from './Welcome';
import HomePage from './HomePage';

const Router = () => (
    <HashRouter>
        <Switch>
            <Route exact path = "/" component = {Login}/>
            <Route exact path = "/welcome" component = {Welcome}/>
            <Route exact path = "/homepage" component = {HomePage}/>
        </Switch>
    </HashRouter>
);

export default Router;