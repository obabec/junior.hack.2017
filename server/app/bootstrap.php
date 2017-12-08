<?php

require __DIR__ . '/../vendor/autoload.php';

define('ROOT_DIR', __DIR__ . '/..');

$configurator = new Nette\Configurator;

if(isset($_COOKIE['debug']) && $_COOKIE['debug'] === 'hackathon') {
    $configurator->setDebugMode(true);
} else {
    $configurator->setDebugMode(true);
}

$configurator->enableTracy(__DIR__ . '/../log');

$configurator->setTimeZone('Europe/Prague');
$configurator->setTempDirectory(__DIR__ . '/../temp');

$configurator->createRobotLoader()
	->addDirectory(__DIR__)
	->register();

$configurator->addConfig(__DIR__ . '/config/config.neon');
$configurator->addConfig(__DIR__ . '/config/config.local.neon');

$container = $configurator->createContainer();

return $container;
