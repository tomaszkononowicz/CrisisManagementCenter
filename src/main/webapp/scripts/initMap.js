/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function initMap() {

    var locations = [
        ['Centrum Zarządzania Kryzysowego Wojewody Dolnośląskiego', 51.1099982,17.0493589,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Kujawsko-Pomorskiego', 53.1203116,17.9934356,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Łódzkiego', 51.7643592,19.4574304,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Lubelskiego', 51.2502505,22.5524617,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Lubuskiego', 52.7387834,15.2303899,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Małopolskiego', 50.065265,19.943337,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Mazowieckiego', 52.2430304,20.9982269,17],
        ['Centrum Zarządzania Kryzysowego Wojewody Opolskiego', 50.6677237,17.9191011,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Podkarpackiego', 50.0403053,22.0019946,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Podlaskiego', 53.12797,23.1694801,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Pomorskiego', 54.343516,18.646096,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Świętokrzyskiego', 50.8752746,20.6290697,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Warmińsko-Mazurskiego', 53.7770979,20.4858253,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Wielkopolskiego', 52.4111217,16.9191556,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Śląskiego', 50.254334,19.0235924,15],
        ['Centrum Zarządzania Kryzysowego Wojewody Zachodnio-Pomorskiego', 53.4311711,14.5662478,15],
        
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 7,
        center: new google.maps.LatLng(51.989503, 19.0249501),
    });

    var infowindow = new google.maps.InfoWindow();
    var marker, i;

    for (i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map
        });

        google.maps.event.addListener(marker, 'click', (function (marker, i) {
            return function () {
                infowindow.setContent(locations[i][0]);
                infowindow.open(map, marker);
            }
        })(marker, i));
    }
}
