<?php
    if(empty($_POST["famName"] || empty($_POST["phoneNum"]))){
        $error = true;
    }
    else{
        $error = false;
    }
?>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <title> Assignment 4 Question 3 </title>
        <meta charset = "utf-8"/>
    </head>

    <body>
        <h1> Assignment 4 Question 3 </h1>
        <?php
            if($error == true){ ?>
                <p> Sorry, there were blank entries. Please go back and try again. </p>
            <?php }
            else {
                if(preg_match("/^\(\d\d\d\)-\d\d\d-\d\d\d\d/", $_POST["phoneNum"]) && preg_match("/^[A-Z][a-z]*$/", $_POST["famName"]) && strlen($_POST["famName"]) <= 30){ ?>
                    <p> Great! <?php echo $_POST["famName"]; ?>, your phone number, <?php echo $_POST["phoneNum"]; ?>, has been submitted! </p>
                <?php } 
                else{ ?>
                    <p> Sorry, at least one of the entries you submitted is invalid. Please go back and try again. </p>
                <?php
                }
             } ?>
    </body>
</html>