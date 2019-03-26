import React from 'react';
import {Route, Switch} from 'react-router-dom';
import MainPage from "../components/MainPage";
import AdminPage from "../components/AdminPage";

function Layout() {
    return (
        <div className="container">
            <div className="">
                <div>
                    <div className="jumbotron">
                        <Switch>
                            <Route path="/" exact component ={MainPage}/>
                            <Route path="/admin" exact component ={AdminPage}/>

                        </Switch>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Layout;