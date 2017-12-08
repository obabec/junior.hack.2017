<?php

namespace App\Presenters;


use App\Exceptions\ApiException;
use App\Exceptions\ScriptException;
use Tracy\Debugger;

class HomepagePresenter extends BasePresenter
{
	public function actionDefault()
    {
        $response = $this->prepareResponse();

        $data = $this->getParameters();
        $data['message'] = 'response from client';

        $response->setData($data);
        $this->sendJson($response);
    }

	public function actionScript()
    {
        $response = $this->prepareResponse();

        try {

            $script = $this->getParameter('name');

            if ($script === null) {
                throw new ApiException('Missing argument: name');
            }



        } catch (ApiException $e) {
            $response->setError($e->getMessage());
            Debugger::log($e);
        } catch (\Exception $e) {
            $response->setError('Server error', 500);
            Debugger::log($e);
        }

        $this->sendJson($response);
    }
}
