fetch(`http://localhost:8080/Item/readAll`) // 1
    .then((response) => {
        if (response.status !== 200) {  //  2
            console.error(`status: ${reponse.status}`);
            return;
        }
        response.json() // 3
        .then(data => readAllItems(data))
    }).catch((err)=> console.error(`Fetch Error: ${err}`)); // 5

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
