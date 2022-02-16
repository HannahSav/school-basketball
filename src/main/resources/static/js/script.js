import { load_tournament } from './loader/load_tournament_table.js';
import { load_statistics } from './loader/load_statistics_table.js';
import { load_games } from './loader/load_games_table.js';

let currentMode;
let currentOption;
function changeMode(mode, option) {
    currentMode.style.display = 'none';
    currentMode = document.getElementById(mode);
    currentMode.style.display = 'block';
    currentOption.style.borderBottom = 'none';
    currentOption = document.getElementById(option);
    currentOption.style.borderBottom = '2px solid orange';
}

document.addEventListener("DOMContentLoaded", function(event) {

    currentMode = document.getElementById("tournamentTableWrapper");
    currentOption = document.getElementById("tournamentTableOption");

    document.getElementById("tournamentTableOption").addEventListener("click", () => {
        changeMode('tournamentTableWrapper', 'tournamentTableOption');
    });

    document.getElementById("statisticsOption").addEventListener("click", () => {
        changeMode('statisticsTableWrapper', 'statisticsOption');
    });

    document.getElementById("gamesOption").addEventListener("click", () => {
        changeMode('gamesTableWrapper', 'gamesOption');
    });

    load_tournament();
    load_statistics();
    load_games();

});
