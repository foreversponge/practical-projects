function validateVariable(){

    var userVariable = document.getElementById("varName").value;
    var regex = new RegExp("^[a-z]([a-zA-Z]|[0-9]|_)*$", "g");

    if(userVariable.length == 0 || regex.test(userVariable)) {
        document.getElementById("varName").className = "";
    }
    else{
        document.getElementById("varName").className  = "error";
    }
}

var array = [];

function addVariable(){

    var list = document.getElementById("list");
    var newVar = document.createElement("li");
    var userVariable = document.getElementById("varName").value;
    var regex = new RegExp("^[a-z]([a-zA-Z]|[0-9]|_)*$", "g");
    
    if(regex.test(userVariable) && (array.indexOf(userVariable) == -1)){
        newVar.appendChild(document.createTextNode(userVariable));
        list.append(newVar);
        array.push(userVariable);
    }

}