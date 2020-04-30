function calculateTotal(){
    var totalPrice = 0;
    
    var roseNumb = document.getElementById("rose").value;
    var lilyNumb = document.getElementById("lily").value;
    var scallaNumb = document.getElementById("scalla").value;
    var orchidNumb = document.getElementById("orchid").value;
    var daisyNumb = document.getElementById("daisy").value;

    var regex = new RegExp("^[0-9]*$");
    if ((!(regex.test(roseNumb))|| roseNumb.length == 0) ||
        (!(regex.test(lilyNumb))|| lilyNumb.length == 0)||
        (!(regex.test(scallaNumb))|| scallaNumb.length == 0) ||
        (!(regex.test(orchidNumb))|| orchidNumb.length == 0) ||
        (!(regex.test(daisyNumb))|| daisyNumb.length == 0) ||
        ((!(document.getElementById("premium").checked))&& !(document.getElementById("standard").checked))) {
            alert("Your inputs are not correct. At least one of them is either blank or not a number.");
    }
    else{
        totalPrice += roseNumb*5.5 + lilyNumb*7.5 + scallaNumb*4.0 + orchidNumb*8.0 + daisyNumb*7.0;
            var deliveryPrice = 0;
        if (document.getElementById("premium").checked){
            totalPrice += 6;
            deliveryPrice = 6;
        }
        else if (document.getElementById("standard").checked){
            totalPrice += 2;
            deliveryPrice = 2;
        }

        document.getElementById("line1").innerHTML = "Red Roses (unit(s) = " + roseNumb + "): $" + roseNumb*5.5;
        document.getElementById("line2").innerHTML = "Yellow Lily (unit(s) = " + lilyNumb + "): $" + lilyNumb*7.5;
        document.getElementById("line3").innerHTML = "White Mini Calla(unit(s) = " + scallaNumb + "): $" + scallaNumb*4.0;
        document.getElementById("line4").innerHTML = "Pink Orchid (unit(s) = " + orchidNumb + "): $" + orchidNumb*8.0;
        document.getElementById("line5").innerHTML = "Orange Daisy (unit(s) = " + daisyNumb + "): $" + daisyNumb*7.0;
        document.getElementById("line6").innerHTML =  "Delivery: $" + deliveryPrice;
        document.getElementById("line7").innerHTML = "Final Price: $" + totalPrice;

    }

    
}