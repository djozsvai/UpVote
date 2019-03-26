import React from "react";


function PendingBallotList(props) {

    return (
        <table className="table-bordered table-striped">
            <thead>
            <tr className="table-success">
                <th>Title</th>
                <th>Description</th>
                <th>Votes</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {Object.entries(this.props.ballots).map(([id, value]) => {
                return (
                    <tr key={id}>
                        <td>{value.title}</td>
                        <td>{value.description}</td>
                        <td>{value.votes}</td>
                        <td>{accept}</td>
                        <td>{deny}</td>
                    </tr>
                )
            })}
            </tbody>
        </table>
    )

}
export default PendingBallotList;