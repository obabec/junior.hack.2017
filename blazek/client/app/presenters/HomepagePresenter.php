<?php

namespace App\Presenters;


use App\Exceptions\ApiException;
use App\Exceptions\ScriptException;
use App\Models\HomeModel;
use Nette\Utils\FileSystem;
use Tracy\Debugger;

class HomepagePresenter extends BasePresenter
{


    /**
     * @var HomeModel
     * @inject
     */
    public $homeModel;

    public function actionDefault()
    {
//        $date = new \DateTime();
//        for ($i = 0; $i < 20; $i++) {
//            $connection = $this->homeModel->getEntityManager()->getConnection();
//            $value = (rand() % 3) + 25;
//            $date = $date->modify('+30 minutes');
//            $connection->insert('event', [
//                'time' => $date->format('Y-m-d H:i:s'),
//                'argument' => $value
//            ]);
//        }
    }

    public function actionChangeCash()
    {
        $response = $this->prepareResponse();
        $params = $this->getParameters();

        try {

            if (!isset($params['value'])) {
                throw new ApiException('Missing value');
            }

            if ($params['value'] < 0) {
                throw new ApiException('Out of range');
            }

            $this->homeModel->getEntityManager()->getConnection()->update('tarif', [
                'cash' => $params['value']
            ], [
                'id' => 1
            ]);
        } catch (ApiException $e) {
          $response->setError($e->getMessage());
        } catch (\Exception $e) {
            $response->setError('An unexcepted error occurred.');
            Debugger::log($e);
        }
        $this->sendJson($response);
    }

    public function actionTopeni()
    {
        $response = $this->prepareResponse();
        $data = $this->homeModel->getEntityManager()->getConnection()->fetchColumn('SELECT argument FROM pins WHERE id = 6');

        $response->setData($data);


        $this->sendJson($response);
    }


    public function actionEvents()
    {
        $response = $this->homeModel->getEntityManager()->getConnection()->fetchColumn('SELECT AVG(argument) FROM event');
        $events = $this->homeModel->getEntityManager()->getConnection()->fetchAll('SELECT * FROM event');
        $this->sendJson([$response, $events]);
    }

    public function actionLock()
    {
        $response = $this->prepareResponse();
        $parameters = $this->getParameters();

        try {
            if (!isset($parameters['value'])) {
                throw new ApiException('Missing value');
            }

            if ($parameters['value'] > 1 || $parameters['value'] < 0) {
                throw new ApiException('Out of range.');
            }

            $this->homeModel->zamnkout($parameters['value']);
        } catch (ApiException $e) {
            $response->setError($e->getMessage());
        } catch (\Exception $e) {
            $response->setError('An unexcepted error occurred.');
        }
        $this->sendJson($response);
    }

    public function actionGetLight()
    {
        $response = $this->prepareResponse();

        try {
            $data = $this->homeModel->readSvetlo();

            $response->setData($data);
        } catch (ApiException $e) {
            $response->setError($e->getMessage());
        }
//        catch (\Exception $e) {
//          $response->setError('An unexcepted error occurred.');
//        }

        $this->sendJson($response);
    }

//    public function actionWatt()
//    {
//        $response = $this->prepareResponse();
//
//        try {
//            $value = FileSystem::read(self::FILE);
//
//            $response->setData(['output' => trim($value)]);
//
//        } catch (\Exception $e) {
//            $response->setError('An unexcepted error occurred.');
//        }
//        $this->sendJson($response);
//    }

    public function actionLight()
    {
        $response = $this->prepareResponse();
        $parameters = $this->getParameters();

        try {

            if (!isset($parameters['id'])) {
                throw new ApiException('Missing id');
            }

            if (!isset($parameters['value'])) {
                throw new ApiException('Missiong value');
            }

            $this->homeModel->prepniSvetle($parameters['id'], $parameters['value']);


        } catch (ApiException $e) {
            $response->setError($e->getMessage());
        } catch (\Exception $e) {
            $response->setError('An unexcepted error occurred.');
        }

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
