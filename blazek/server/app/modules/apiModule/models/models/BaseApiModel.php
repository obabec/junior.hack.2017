<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 29.11.2017
 * Time: 17:55
 */

namespace Api\Models;

use App\Models\BaseModel;
use GuzzleHttp\Client;
use Kdyby\Doctrine\EntityManager;

class BaseApiModel extends BaseModel
{
    /**
     * @var Client
     */
    protected $guzzle;

    /**
     * BaseApiModel constructor.
     * @param Client $guzzle
     * @param EntityManager $em
     */
    public function __construct(EntityManager $em, Client $guzzle)
    {
        $this->guzzle = $guzzle;
        parent::__construct($em);
    }
}