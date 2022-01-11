import { load_tournament } from './loader/load_tournament_table.js';
import { load_statistics } from './loader/load_statistics_table.js';
import { load_games } from './loader/load_games_table.js';

let currentMode;
function changeMode(i) {
    currentMode.style.display = 'none';
    currentMode = document.getElementById(i);
    currentMode.style.display = 'block';
}

document.addEventListener("DOMContentLoaded", function(event) {

    currentMode = document.getElementById("tournamentTableWrapper");

    document.getElementById("tournamentTableOption").addEventListener("click", () => {
        changeMode('tournamentTableWrapper');
    });

    document.getElementById("statisticsOption").addEventListener("click", () => {
        changeMode('statisticsTableWrapper');
    });

    document.getElementById("gamesOption").addEventListener("click", () => {
        changeMode('gamesTableWrapper');
    });

    load_tournament();
    load_statistics();
    load_games();

});
