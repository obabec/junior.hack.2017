<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 29.11.2017
 * Time: 18:27
 */

namespace ApiModule\Presenters;


use ApiModule\Exceptions\ApiException;
use Tracy\Debugger;

class ApiPresenter extends BaseApiPrenster
{

    public function actionCreate()
    {
        $output = shell_exec( __DIR__ . '/pythonFake.bat');
        bdump($output);
        $this->template->output = $output;
    }

    public function actionDefault()
    {
        $response = $this->prepareResponse();

        try {




        } catch (ApiException $e) {
            $response->setError($e->getMessage());
            Debugger::log($e);
        } catch (\Exception $e) {
            $this->setServerError($response);
            Debugger::log($e);
        }

        $this->sendJson($response);
    }
}