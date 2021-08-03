var submit = document.getElementById("submit");
submit.addEventListener("click", postReq);

function postReq() {
    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/Item/create");
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
    let data = { category: categoryVal, priority: priorityVal, description: descriptionVal };
    req.send(JSON.stringify(data));
};











