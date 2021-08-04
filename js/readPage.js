fetch(`http://localhost:8080/Item/readAll`) 
    .then((response) => {
        if (response.status !== 200) { 
            console.error(`status: ${reponse.status}`);
            return;
        }
        response.json() 
        .then(data => readAllItems(data))
    }).catch((err)=> console.error(`Fetch Error: ${err}`)); 

function readAllItems(data) {
    let table = document.getElementById("table");
    for(let i = 0; i < data.length; i++) {
    let row = document.createElement("tr");

    let id = document.createElement("th");
    id.setAttribute("scope", "row");
    id.textContent = data[i].id;

    let category = document.createElement("td");
    category.textContent = data[i].category;

    let priority = document.createElement("td");
    priority.textContent = data[i].priority;

    let description = document.createElement("td");
    description.textContent = data[i].description;

    table.appendChild(row);
    row.appendChild(id);
    row.appendChild(category);
    row.appendChild(priority);
    row.appendChild(description);
    
    }
}