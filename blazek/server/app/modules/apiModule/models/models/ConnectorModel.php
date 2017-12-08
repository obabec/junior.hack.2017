<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 29.11.2017
 * Time: 18:39
 */

namespace Api\Models;


use GuzzleHttp\Client;
use GuzzleHttp\Psr7\Request;
use Kdyby\Doctrine\EntityManager;
use Nette\Neon\Neon;

class ConnectorModel extends BaseApiModel
{
    /** @var  array */
    protected $config;
    /** @var  string */
    protected $client;

    /**
     * @param string $query
     * @return string
     */
    protected function getClient($query)
    {
        $client = $this->client;
        return $client . '?' . $query;
    }

    /**
     * ConnectorModel constructor.
     * @param EntityManager $em
     * @param Client $guzzle
     */
    public function __construct(EntityManager $em, Client $guzzle)
    {
        $this->config = Neon::decode(file_get_contents(ROOT_DIR. '/app/config/api.neon'));
        $this->client = $this->config['clientURL'];
        parent::__construct($em, $guzzle);
    }

    /**
     * @return string
     */
    public function testClient()
    {
        $data = http_build_query([
           'test' => 'data'
        ]);
        $response = $this->guzzle->request('GET', $this->getClient($data));
        $reponseData = $response->getBody()->getContents();
        return $reponseData;
    }
}