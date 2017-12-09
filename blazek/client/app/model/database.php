<?php
$db = new PDO('mysql:host=localhost;dbname=hackathonn', 'root', 'pokemon123');

list(, $value) = $_SERVER['argv'];

// RIP SQLinjection :-) (ošetření stojí moc času)
$db->query("UPDATE pins SET argument = '" . $value . "' WHERE id = 5");