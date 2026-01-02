<?php
$cookie_name = "last_visit";
if (isset($_COOKIE[$cookie_name])) {
    echo "You last visited on: " . $_COOKIE[$cookie_name];
} else {
    echo "Welcome! This is your first visit.";
}
$current_time = date("d-m-Y h:i:s A");
setcookie($cookie_name, $current_time, time() + 365*24*60*60);
?>
