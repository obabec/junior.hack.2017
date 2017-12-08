<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 29.11.2017
 * Time: 17:57
 */

namespace ApiModule\Presenters;


use ApiModule\Services\ApiResponse;
use App\Presenters\BasePresenter;
use Nette\Http\Response;

abstract class BaseApiPrenster extends BasePresenter
{
    protected $apiModel;
    /** @var  Response */
    protected $response;

    /**
     * @param Response $response
     */
    public function injectResponse(Response $response)
    {
        $this->response = $response;
    }

    public function actionGet()
    {
        $this->notImplemented();
    }

    public function actionCreate()
    {
        $this->notImplemented();
    }

    public function actionDelete()
    {
        $this->notImplemented();
    }

    public function actionList()
    {
        $this->notImplemented();
    }

    public function actionUpdate()
    {
        $this->notImplemented();
    }

    /**
     * @return void
     */
    protected function notImplemented()
    {
        $response = $this->prepareResponse();
        $response->setError('Not implemented action: ' . $this->getAction());
        $this->sendJson($response);
    }

    /**
     * @return ApiResponse
     */
    protected function prepareResponse()
    {
        return new ApiResponse();
    }

    /**
     * @param ApiResponse $response
     */
    protected function setServerError(ApiResponse $response)
    {
        $response->setCode(500);
        $response->setError('internal server error', 500);
    }
}