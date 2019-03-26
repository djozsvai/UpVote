import React from "react";


function ApprovedBallotListNoVote(props) {

    return (
        <table className="table-bordered table-striped">
            <thead>
            <tr className="table-success">
                <th>Title</th>
                <th>Description</th>
                <th>Votes</th>

            </tr>
            </thead>
            <tbody>
            {Object.entries(this.props.ballots).map(([id, value]) => {
                return (
                    <tr key={id}>
                        <td>{value.title}</td>
                        <td>{value.description}</td>
                        <td>{value.votes}</td>
                    </tr>
                )
            })}
            </tbody>
        </table>
    )

}
export default ApprovedBallotListNoVote;