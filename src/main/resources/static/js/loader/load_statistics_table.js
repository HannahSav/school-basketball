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
                        <td style="width: 5%; justify-content: center;">${position}</td>
                        <td style="width: 30%; justify-content: center; flex-direction: column;"><span>${player.first_name} ${player.last_name} </span> <span style="font-size: small">${player.team_name}</span></td>
                        <td style="width: 60%;"/>
                        <td style="width: 5%; justify-content: center;">${player.points}</td>
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
                        <td style="width: 5%; justify-content: center;">${position}</td>
                        <td style="width: 30%; justify-content: center; flex-direction: column;"><span>${player.first_name} ${player.last_name} </span> <span style="font-size: small">${player.team_name}</span></td>
                        <td style="width: 60%;"/>
                        <td style="width: 5%; justify-content: center;">${player.points}</td>
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
                        <td style="width: 5%; justify-content: center;">${position}</td>
                        <td style="width: 30%; justify-content: center; flex-direction: column;"><span>${player.first_name} ${player.last_name} </span> <span style="font-size: small">${player.team_name}</span></td>
                        <td style="width: 60%;"/>
                        <td style="width: 5%; justify-content: center;">${player.points}</td>
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
                        <td style="width: 5%; justify-content: center;">${position}</td>
                        <td style="width: 30%; justify-content: center; flex-direction: column;"><span>${player.first_name} ${player.last_name} </span> <span style="font-size: small">${player.team_name}</span></td>
                        <td style="width: 60%;"/>
                        <td style="width: 5%; justify-content: center;">${player.points}</td>
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
