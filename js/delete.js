const delReq = () => {
    let id = document.querySelector("#delete-id").value;
    console.log(id);
    fetch("http://localhost:8080/Item/delete/" + id, {
        method: 'DELETE'
    }).then((data) => {
        console.log(data)
        if(data.status === 204) {
            console.log("delete success");
        }
    }).catch((error) => {
            console.log("Oops..." + error);
        });
}

var submit = document.getElementById("delete-btn");
submit.addEventListener("click", delReq);
