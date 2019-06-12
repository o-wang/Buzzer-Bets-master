const http = require('http');
const nba = require ('nba');
var today = new Date();
var date;
var game = "";

var i;
//for (i = 0; i < 5; i++){
//    var day_calc = parseInt(today.getDate(), 10) + i;
//    var date = (today.getMonth()+1)+'/'+day_calc.toString()+'/'+today.getFullYear();
////    console.log(date);
//    if (i === 4){
//        nba.stats.scoreboard({gameDate: date}).then(result => {
//            print_game(result);
//        });
//    }
//    else{
//        nba.stats.scoreboard({gameDate: date}).then(result => {
//            assign_game(result);
//        });
//    }
//}

nba.stats.scoreboard({gameDate: "06/16/2019"}).then(result => {
    print_game(result);
});
//nba.stats.scoreboard({gameDate: "06/16/2019"}).then(console.log);

//function assign_game(result){
//    if (result.gameHeader.length > 0){
//        game += JSON.stringify(result.gameHeader);
////        console.log(game);
//    }
//}

function print_game(result){
    if (result.gameHeader.length > 0){
        game += JSON.stringify(result.gameHeader);
        console.log(game);
    }
}
//console.log(game);
//nba.stats.scoreboard({gameDate: "06/10/2019"}).then(set_game_var);

//nba.stats.teamStats({ teamId: '1610612737'}).then(console.log);