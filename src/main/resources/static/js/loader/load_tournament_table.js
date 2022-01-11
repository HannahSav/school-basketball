function load_tournament () {
    fetch("teaminfo", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(resp => {
            if (resp.status === 200) {
                return resp.json()
            } else {
                console.log("Status: " + resp.status)
                return Promise.reject("server")
            }
        })
        .then(dataJson => {
            let position = 1;
            dataJson.teamInfo.forEach(function (team) {
                document.getElementById("tournamentTable").innerHTML +=
                    `<tr>
                            <td>${position}</td>
                            <td><img height="50px" src="img/team/team${team.photo_id}.jpg" alt="team logo"></td>
                            <td><a href="team.html?id=${team.teamId}">${team.name}</a></td>
                            <td><p>${team.games_count}</p></td>
                            <td><p>${team.victories}</p></td>
                            <td><p>${team.draws}</p></td>
                            <td><p>${team.games_count - (team.victories + team.draws)}</p></td>
                            <td><p>${team.scored_home}</p></td>
                            <td><p>${team.scored_guest}</p></td>
                            <td><p>${team.tournament_score}</p></td>
                        </tr>`
                position++;
            });
        })
        .catch(err => {
            if (err === "server") return
            console.log(err)
        });
}

export { load_tournament };
