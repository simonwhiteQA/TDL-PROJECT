var submit = document.getElementById("update");
submit.addEventListener("click", updateReq);

function updateReq() {
    let id = document.querySelector("#item").value;
    const req = new XMLHttpRequest();
    req.open("PUT", "http://localhost:8080/Item/update/" + id);
    req.onload = () => {
        if (req.status === 200) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    }
    var categoryVal = $('#category').val();
    var priorityVal = $('#priority').val();
    var descriptionVal = $('#description').val();

    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let data = { id: id, category: categoryVal, priority: priorityVal, description: descriptionVal };
    req.send(JSON.stringify(data));
};
