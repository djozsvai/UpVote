import React, {Component, Fragment} from 'react';
import axios from "axios";
import ApprovedBallotList from "./ApprovedBallotList";
import CompleteBallotList from "./CompleteBallotList";
import PendingBallotList from "./PendingBallotList";

class AdminPage extends Component {

    state = {
        approvedBallots: [],
        pendingBallots: []
    };

    componentDidMount() {
        this.getApprovedList();
        this.getPendingList();
    }

    getApprovedList = () => {
        axios.get("http://localhost:8080/api/ballots")
            .then(response => {
                this.setState({ballots: response.data});
            })
            .catch(error => console.warn(error))
    };

    getPendingList = () => {
        axios.get("http://localhost:8080/api/ballots/pending")
            .then(response => {
                this.setState({ballots: response.data});
            })
            .catch(error => console.warn(error))
    };

    approve = (title) => {
        axios.put("http://localhost:8080/api/ballots/" + title)
            .then(this.getPendingList)
    };

    deny = (title) => {
        axios.delete("http://localhost:8080/api/ballots/" + title)
            .then(this.getPendingList)
    };

    getApprovedBallots = () => {
        return <ApprovedBallotList
            ballots={this.state.ballots}
        />
    };

    getAllBallots = () => {
        return <CompleteBallotList
            ballots={this.state.ballots}
        />
    };

    getPendingBallots = () => {
        return <PendingBallotList
            ballots={this.state.ballots}
        />
    };

    render() {

        return (

            <Fragment>
                <h2>Running Ballots</h2>
                <br/>
                <div>
                    {}
                </div>

            </Fragment>

        )
    }
}
export default AdminPage;