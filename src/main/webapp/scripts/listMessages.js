/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function listMessages(amount) {
    amount = amount || 20;
    var region = $("select[name='region']").val();
    var priority = $("select[name='priority']").val();
    $('#messagesContainer').empty();
    $.getJSON('resources/messages/list/', {region: region, priority: priority}, function (data) {
        if (!($.isEmptyObject(data))) {
        var table = $('<table id="table">').appendTo($('#messagesContainer'));
        $.each(data, function (i, message) {
            var row = $('<tr>').appendTo(table);
            if (message.priority == 1) row.css('background-color', '#FFF565');
            if (message.priority == 2) row.css('background-color', '#FFA05A');
            if (message.priority == 3) row.css('background-color', '#FF535A');
            $('<td>').append('<img src="images/' + message.shortText + '.png">').appendTo(row);
            $('<td>').text(message.region).appendTo(row);
            $('<td>').text(new Date(message.date).toLocaleDateString()).appendTo(row);
            $('<td>').text(message.shortText).appendTo(row);
            $('<td>').text(message.text).appendTo(row);
            return i<amount-1;
        });
    } else {
        $('<p>').text("Aktualnie brak komunikatów do wyświetlenia");
    }
    });
}



