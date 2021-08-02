
fetch(`https://api.punkapi.com/v2/beers/${j}`) // 1
    .then((response) => {
        if (response.status !== 200) {  //  2
            console.error(`status: ${reponse.status}`);
            return;
        }
        response.json()
            .then(data => 
                for (i = 0; i < data.length(); i++) {
                populateElements(data, i);
            })
    }).catch((err) => console.error(`${err}`));

