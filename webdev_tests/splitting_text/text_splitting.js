function textsplit(){

    var userText = document.getElementById("userText").value;
    var userChar = document.getElementById("char").value;
    var userWord = document.getElementById("word").value;
    var userModif = document.getElementById("modif").value;
    var array;
    var counter = 0;

    if(userChar.value != ""){
        array = userText.split(userChar);
        var regex = new RegExp(userWord, userModif);
        for (var i in array){
            if (regex.test(array[i])){
                counter++;
            }
        }   
    }

    else{
        var regex = new RegExp(userWord, userModif);
        for (var i in array){
            if (regex.test(array[i])){
                counter++;
            }
        }   
    }
    document.getElementById("result").innerHTML = "There is a total of " + array.length + " non-empty words in the text, including " + counter + " words matching the regex.";
}