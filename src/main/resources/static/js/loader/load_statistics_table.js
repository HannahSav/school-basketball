function load_statistics() {
    fetch("best3p", {
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
            dataJson.teamInfo.forEach(function (player) {
                document.getElementById("statisticsThreePointTable").innerHTML +=
                    `<tr>
                            <td>${position}</td>
                            <td>${player.first_name} ${player.last_name}</td>
                            <td>${player.team_name}</td>
                            <td>${player.points}</td>
                        </tr>`
                position++;
            });
        })
        .catch(err => {
            if (err === "server") return
            console.log(err)
        })


    fetch("best2p", {
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
            dataJson.teamInfo.forEach(function (player) {
                document.getElementById("statisticsTwoPointTable").innerHTML +=
                    `<tr>
                            <td>${position}</td>
                            <td>${player.first_name} ${player.last_name}</td>
                            <td>${player.team_name}</td>
                            <td>${player.points}</td>
                        </tr>`
                position++;
            });
        })
        .catch(err => {
            if (err === "server") return
            console.log(err)
        })


    fetch("best1p", {
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
            dataJson.teamInfo.forEach(function (player) {
                document.getElementById("statisticsOnePointTable").innerHTML +=
                    `<tr>
                            <td>${position}</td>
                            <td>${player.first_name} ${player.last_name}</td>
                            <td>${player.team_name}</td>
                            <td>${player.points}</td>
                        </tr>`
                position++;
            });
        })
        .catch(err => {
            if (err === "server") return
            console.log(err)
        })

    fetch("bestrebounders", {
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
            dataJson.teamInfo.forEach(function (player) {
                document.getElementById("statisticsReboundsTable").innerHTML +=
                    `<tr>
                            <td>${position}</td>
                            <td>${player.first_name} ${player.last_name}</td>
                            <td>${player.team_name}</td>
                            <td>${player.points}</td>
                        </tr>`
                position++;
            });
        })
        .catch(err => {
            if (err === "server") return
            console.log(err)
        })
}

export { load_statistics };
