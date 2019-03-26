import React, {Component, Fragment} from 'react';
import axios from "axios";
import ApprovedBallotList from "./ApprovedBallotList";

class MainPage extends Component {

    state = {
        ballots: []
    };

    componentDidMount() {
        this.getApprovedList();
    }

    getApprovedList = () => {
        axios.get("http://localhost:8080/api/ballots")
            .then(response => {
                this.setState({ballots: response.data});
            })
            .catch(error => console.warn(error))
    };

    addVote = () => {
        axios.put("http://localhost:8080/api/ballots/")
            .then(this.getApprovedList)
    };


    getApprovedBallots = () => {
        return <ApprovedBallotList
            ballots={this.state.ballots}
        />
    };


    render() {

        return (

            <Fragment>
                <h2>Running Ballots</h2>
                <br/>
                <div>
                    {this.getApprovedBallots()}
                </div>

            </Fragment>

        )
    }
}
export default MainPage;