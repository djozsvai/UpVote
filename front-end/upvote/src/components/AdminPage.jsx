import React, {Component, Fragment} from 'react';
import axios from "axios";
import ApprovedBallotListNoVote from "./ApprovedBallotList";
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
        return <ApprovedBallotListNoVote
            ballots={this.state.approvedBallots}
        />
    };

    getPendingBallots = () => {
        return <PendingBallotList
            ballots={this.state.pendingBallots}
        />
    };

    getApproveButton = () => {
        return (
            <div className="col-sm text-center">
                <a role="button" onClick={this.approve}>
                    <span>Approve</span>
                </a>
            </div>
        )
    };

    getDenyButton = () => {
        return (
            <div className="col-sm text-center">
                <a role="button" onClick={this.deny}>
                    <span>Deny</span>
                </a>
            </div>
        )
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