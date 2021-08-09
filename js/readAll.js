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
    let toDoList = document.getElementById("myUL");
    for(let i = 0; i < data.length; i++) {
    let anchor = document.createElement("a");
    let listItem = document.createElement("li");
    listItem.setAttribute("id", `toDoItem${data[i].id}`)
    listItem.textContent = data[i].category + " - " + data[i].description + " (" + data[i].priority + " PRIORITY)";
    anchor.appendChild(listItem);
    toDoList.appendChild(anchor);
    }
}
