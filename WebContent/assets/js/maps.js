function initMap() {
  // console.log('Google Maps API version: ' + google.maps.version);

  var map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 40.4231, lng: -3.6881 }, 
    zoom: 5,
    mapTypeId: "roadmap",
    streetViewControl: false,
  });

  // Create the search box and link it to the UI element.
  const input = document.getElementById("pac-input");
  const searchBox = new google.maps.places.SearchBox(input);
  let marker = new google.maps.Marker({ map: map });

  // Bias the SearchBox results towards current map's viewport.
  map.addListener("bounds_changed", function () {
    searchBox.setBounds(map.getBounds());
  });

  // Listen for the event fired when the user selects a prediction and retrieve
  // more details for that place.
  searchBox.addListener("places_changed", function () {
    const result = searchBox.getPlaces();
    place = result[0];

    // console.log(place);

    if (result.length == 0) {
      return;
    }

    // Muestra mensaje si el objeto geometry no ha sido encontrado.
    if (!place.geometry) {
      console.log("Returned place contains no geometry");
      return;
    }

    // Se crea un Objeto cono la informacion de la localizacion
    // Se controla la exccion si es undefined no muetra nada
    // console.log(getInfoAddress(place));
    if (!getInfoAddress(place)) {
      console.log("Returned place contains no geometry");
      return;
    }
    const infoAddress = getInfoAddress(place);

    // Marcador y zoom y centrado en el mapa
    map.setZoom(15);
    map.setCenter(place.geometry.location);
		marker.setPosition(place.geometry.location);
		marker.setVisible(true);

    // Al hacer click en el maracdor, se realiza un zoom automatico
    marker.addListener('click', function() {
      map.setZoom(19);
      map.setCenter(marker.getPosition());
    });

    // Se pasa la info al DOM
    printInfoAddress(infoAddress);

    // Cambiar de posicion el marcador.
    map.addListener("click", function (e) {
      //console.log(e.placeId);
      //Se evita que salgan los globos de los elementos de interes del mapa.
      if (e.placeId) {
        e.stop();
      }
      marker.setPosition(e.latLng);
      map.setCenter(e.latLng);

      document.getElementById("inputGps").value = e.latLng.toString();
      document.getElementsByClassName("gps")[0].innerHTML =  `<b>Coordenadas: </b> ${e.latLng.toString()}`;
      // console.log(e.latLng.toString());
    });
  });
}

// Funcion que retorna un objeto con los datos necesarios.
function getInfoAddress(place) {
  // Objeto para pasar los dastos
  let o = {}

  // Se pasan los datos de primer nivel
  o["name"] = place.name;
  o["gps"] = place.geometry.location.toString();
  o["web"] = place.website;
  o["phone"] = place.formatted_phone_number;

  // Se pasan los datos del address_components, segundo nivel.
  // Constante para recorrer address_components
  const infoLocation = {
    street_number: "short_name",
	  route: "long_name",
    locality: "long_name",
    administrative_area_level_2: "long_name",
    administrative_area_level_1: "long_name",
    country: "long_name",
    countryCode: "short_name",
    postal_code: "short_name",
  };

  if (place.address_components) {
    for (var i = 0; i < place.address_components.length; i++) {
      let addressType = place.address_components[i].types[0];

      if (infoLocation[addressType]) {
        o[addressType] = place.address_components[i][infoLocation[addressType]];

        // Para el Pais se obtiene tb su nombre corto o codigo de pais.
        if (addressType == "country") {
          o["countryCode"] = place.address_components[i][infoLocation["countryCode"]];
          //console.log('pasa');
        }
      }
    }
  } else {
    return
  }
  return o;
}

// funcion que recore el objeto y devuele los valores al DOM
function printInfoAddress(infoAddress) {
  // Se crea un template par que muestre la info en la vista
  let tplInfo = ""
  const tplES = {
    name: "Nombre",
    web: "Web",
    phone: "Teléfono",
    gps: "Coordenadas",
    street_number: "Número",
    route: "Calle",
    locality: "Ciudad",
    administrative_area_level_2: "Provincia",
    administrative_area_level_1: "Región",
    country: "Pais",
    countryCode: "Código país",
    postal_code: "Código Postal",
  };

  for (const key in infoAddress) {
    if (infoAddress.hasOwnProperty(key) && infoAddress[key] !== undefined) {
      tplInfo += `<li class="small ${key}"><b>${tplES[key]}:</b> ${infoAddress[key]}</li>`;
      if (document.getElementsByName(key).length > 0) {
        document.getElementsByName(key)[0].value = infoAddress[key];
      }
      // console.log(`key: ${tplES[key]} - Valor: ${infoAddress[key]}`);
    }
  }

  // Se pasaan los datos
  document.getElementById("addressPreview").innerHTML = tplInfo;
  document.getElementById("inputStreet").value = infoAddress.route !== undefined ? `${infoAddress.route}, ${infoAddress.street_number}` : "";

  // document.getElementById("inputName").value = place.name !== undefined ? place.name : "";
  // document.getElementById("inputPhone").value = place.formatted_phone_number !== undefined ? place.formatted_phone_number.replace(/[^0-9]+/g, '')  : "";
  // document.getElementById("inputWeb").value = place.website !== undefined ? place.website : "";

  // console.log(marker.getPosition().toString());

  // document.getElementById("inputGps").value = marker.getPosition() !== undefined ? marker.getPosition().toString() : "";
}

