<!DOCTYPE html>
<?php
    $numOfVisits = 1;
    if(isset($_COOKIE["numOfVisits"])){
        $numOfVisits = $_COOKIE["numOfVisits"];
        $numOfVisits++;
    }
    if(isset($_COOKIE["visited"])){
        $visited = $_COOKIE["visited"];
    }
    date_default_timezone_set("America/New_York");
    setcookie("numOfVisits", $numOfVisits, time() + 20);
    setcookie("visited", date("D F d H:i:s T Y", time()), time() + 20);
?>
<html lang = "en">
    <head>
        <title> Assignment 4 Question 2 </title>
        <meta charset = "utf-8"/>
    </head>

    <body>
        <h1> Assignment 4 Question 2 </h1>
        <?php
            if($numOfVisits == 1){
                echo "Welcome to my webpage! It is the first time that you are here.";
            }
            else{
                echo "Hello, you have visited my webpage $numOfVisits time(s) .";
                echo "<br> Last time you visited my webpage on: $visited.";
            }
        ?>

    </body>
</html>