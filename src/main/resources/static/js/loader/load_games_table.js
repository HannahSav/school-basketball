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
            dataJson.teamInfo.forEach(function (game) {
                document.getElementById("previousGamesTable").innerHTML +=
                    `<tr>
                        <td style="width: 30%; flex-direction: column; align-items: start;"><span>${game.name_home_team}</span> <span>${game.name_guest_team}</span></td>
                        <td style="width: 20%; flex-direction: column; align-items: start;"><span>${game.points_home_team}</span> <span>${game.points_guest_team}</span></td>
                        <td style="width: 30%; flex-direction: column; align-items: start;"><span>${game.time.dayOfMonth}.${game.time.monthValue}.${game.time.year}</span><span>${game.time.hour}:${game.time.minute}</span></td>
                        <td style="width: 20%;">${game.gym}</td>
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
            dataJson.teamInfo.forEach(function (game) {
                document.getElementById("upcomingGamesTable").innerHTML +=
                    `<tr>
                        <td style="width: 50%; flex-direction: column; align-items: start;"><span>${game.name_home_team}</span> <span>${game.name_guest_team}</span></td>
                        <td style="width: 30%; flex-direction: column; align-items: start;"><span>${game.time.dayOfMonth}.${game.time.monthValue}.${game.time.year}</span><span>${game.time.hour}:${game.time.minute}</span></td>
                        <td style="width: 20%;">${game.gym}</td>
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
