function initMap(){
    var uluru = {lat: 47.910245, lng: 33.401028};
     var map = new google.maps.Map(document.getElementById('map_img'), {
       zoom: 10,
       center: uluru
     });
     var map_modal = new google.maps.Map(document.getElementById('map-modal'),{
        zoom: 12,
        center: uluru
     });
     var marker = new google.maps.Marker({
       position: uluru,
       map: map
     });
     var marker_modal = new google.maps.Marker({
        position: uluru,
        map: map_modal
     });
}