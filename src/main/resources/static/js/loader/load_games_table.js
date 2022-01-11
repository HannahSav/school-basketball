function load_games() {
    fetch("pastgames", {
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
            console.log(dataJson);
            dataJson.teamInfo.forEach(function (game) {
                document.getElementById("previousGamesTable").innerHTML +=
                    `<tr>
                            <td>${game.name_home_team}</td>
                            <td>${game.name_guest_team}</td>
                            <td>${game.points_home_team}</td>
                            <td>${game.points_guest_team}</td>
                            <td>${game.time}</td>
                            <td>${game.gym}</td>
                        </tr>`
            });
        })
        .catch(err => {
            if (err === "server") return
            console.log(err)
        })

    fetch("upcominggames", {
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
            console.log(dataJson);
            dataJson.teamInfo.forEach(function (game) {
                document.getElementById("upcomingGamesTable").innerHTML +=
                    `<tr>
                            <td>${game.name_home_team}</td>
                            <td>${game.name_guest_team}</td>
                            <td>${game.time}</td>
                            <td>${game.gym}</td>
                        </tr>`
                position++;
            });
        })
        .catch(err => {
            if (err === "server") return
            console.log(err)
        })
}

export { load_games };
