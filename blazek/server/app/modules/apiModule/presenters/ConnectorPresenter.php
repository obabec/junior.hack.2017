<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 29.11.2017
 * Time: 18:38
 */

namespace ApiModule\Presenters;


use Api\Models\ConnectorModel;

class ConnectorPresenter extends BaseApiPrenster
{
    /** @var  ConnectorModel */
    protected $connector;

    /**
     * ConnectorPresenter constructor.
     * @param ConnectorModel $connector
     */
    public function __construct(ConnectorModel $connector)
    {
        $this->connector = $connector;
        parent::__construct();
    }


    public function renderDefault()
    {
        $response = $this->connector->testClient();
        $this->sendJson(json_decode($response));
    }
}