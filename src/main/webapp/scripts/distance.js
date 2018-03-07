/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getDistance() {
    var source = $("input[name='source']").val();
    var destination = $("select[name='destination']").val();
    
    var WCZK = [      
                "WCZK Wrocław",
                "WCZK Bydgoszcz",
                "WCZK Łódź",
                "WCZK Lublin",
                "WCZK Gorzów Wielkopolski",
                "WCZK Kraków",
                "WCZK Warszawa",
                "WCZK Opole",
                "WCZK Rzeszów",
                "WCZK Białystok",
                "WCZK Gdańsk",
                "WCZK Kielce",
                "WCZK Olsztyn",
                "WCZK Poznań",
                "WCZK Katowice",
                "WCZK Szczecin"
    ];
    var locations = [  
        "51.1099982,17.0493589",
        "53.1203116,17.9934356",
        "51.7643592,19.4574304",
        "51.2502505,22.5524617",
        "52.7387834,15.2303899",
        "50.065265,19.943337",
        "52.2430304,20.9982269",
        "50.6677237,17.9191011",
        "50.0403053,22.0019946",
        "53.12797,23.1694801",
        "54.343516,18.646096",
        "50.8752746,20.6290697",
        "53.7770979,20.4858253",
        "52.4111217,16.9191556",
        "50.254334,19.0235924",
        "53.4311711,14.5662478"
    ];
    //TODO przecinki
    var destinationCord = locations[$.inArray(destination, WCZK)];
    
    $.getJSON("resources/geo/distance", {source: source, destination: destinationCord}, function (data) {
        $('#distanceContainer').empty();
        if (data.originAddresses[0].length != 0) {
        var table = $('<table id="distanceTable">').appendTo($('#distanceContainer'));
            var row = $('<tr>').appendTo(table);
            $('<th>').text("Początek trasy").appendTo(row);
            $('<th>').text("Koniec trasy").appendTo(row);
            $('<th>').text("Długość drogi").appendTo(row);
            $('<th>').text("Przewidywany czas podróży").appendTo(row);
            var row = $('<tr>').appendTo(table);
            $('<td>').text(data.originAddresses[0]).appendTo(row);
            $('<td>').text(destination + " (" + data.destinationAddresses[0] + ")").appendTo(row);
            $('<td>').text(data.rows[0].elements[0].distance.humanReadable).appendTo(row);
            $('<td>').text(data.rows[0].elements[0].duration.humanReadable).appendTo(row);
        } else {
            $('<p>').text("Podane miasto nie istnieje w Polsce").appendTo($('#distanceContainer'));
        
        }

    });
}