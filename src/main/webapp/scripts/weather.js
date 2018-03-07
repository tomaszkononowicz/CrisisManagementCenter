/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//api.openweathermap.org/data/2.5/forecast/daily?q=London,UK&cnt=16&APPID=2508abecb6d9037229e719a6adc445af



function showWeather() {
    //jezeli miasto jest puste
    var city = $("input[name='city']").val();
    var countryCode = 'PL';
    var lang = 'pl';
    var units = 'metric';
    var cnt = 16;
    var url = 'http://api.openweathermap.org/data/2.5/forecast/daily?q=' + city + "," + countryCode;
    var appID = '2508abecb6d9037229e719a6adc445af';
    $('#weatherContainer').empty();
    $.getJSON(url, {APPID: appID, cnt: cnt, units: units, lang: lang}, function (data) {
        if (!($.isEmptyObject(data))) {          
            var table = $('<table id="weatherTable">').appendTo($('#weatherContainer'));
            var row = $('<tr>').appendTo(table);
            $('<th>').text("Data").appendTo(row);
            $('<th>').text("Temperatura w dzień [℃]").appendTo(row);
            $('<th>').text("Temperatura w nocy [℃]").appendTo(row);
            $('<th>').text("Pogoda").appendTo(row);
            $('<th>').text("").appendTo(row);
            $('<th>').text("Ciśnienie [hPa]").appendTo(row);
            $('<th>').text("Wilgotność [%]").appendTo(row);
            $.each(data.list, function (i, list) {
                var row = $('<tr>').appendTo(table);
                var date = new Date();
                date.setDate(date.getDate() + i);
                //$('<td>').text(date + 86400000  new Date(new Date().getMilliseconds() + 86400000*i).toLocaleDateString()).appendTo(row);
                $('<td>').text(date.toLocaleDateString()).appendTo(row);
                $('<td>').text(list.temp.day).appendTo(row);
                $('<td>').text(list.temp.night).appendTo(row);
                $('<td>').text(list.weather[0].description).appendTo(row);
                $('<td>').append('<img src="http://openweathermap.org/img/w/' + list.weather[0].icon + '.png">').appendTo(row);
                $('<td>').text(list.pressure).appendTo(row);
                $('<td>').text(list.humidity).appendTo(row);
            });
        } else {
            $('<p>').text("Podane miasto nie istnieje w Polsce");
        }
    });
}


