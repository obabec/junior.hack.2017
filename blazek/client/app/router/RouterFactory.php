<?php

namespace App;

use Doctrine\ORM\Cache\Persister\Collection\ReadOnlyCachedCollectionPersister;
use Nette;
use Nette\Application\Routers\Route;
use Nette\Application\Routers\RouteList;


class RouterFactory
{
	use Nette\StaticClass;

	/**
	 * @return Nette\Application\IRouter
	 */
	public static function createRouter()
	{
		$router = new RouteList;
		$router[] = new Route('cash', 'Homepage:ChangeCash');
		$router[] = new Route('topeni', 'Homepage:topeni');
		$router[] = new Route('events','Homepage:events');
		$router[] = new Route('door', 'Homepage:lock');
		$router[] = new Route('read-light', 'Homepage:getLight');
        $router[] = new Route('light', 'Homepage:light');
		$router[] = new Route('<presenter>/<action>', 'Homepage:default');
		return $router;
	}
}
