<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 08.12.2017
 * Time: 20:16
 */

namespace App\Presenters;


use App\Exceptions\ApiException;
use App\Models\DbModel;

class DbPresenter extends BasePresenter
{
    /** @var  DbModel */
    protected $dbmodel;

    /**
     * DbPresenter constructor.
     * @param DbModel $dbmodel
     */
    public function __construct(DbModel $dbmodel)
    {
        $this->dbmodel = $dbmodel;
        parent::__construct();
    }

    public function actionLigth()
    {
        $response = $this->prepareResponse();

        try {

            $arguments = $this->getParameters();

            if (!isset($arguments['id'])) {
                throw new ApiException('Missing id');
            }

            if ($arguments['id'] > 5 || $arguments['id'] < 1) {
                throw new ApiException('Id is out of range');
            }

            if ($arguments['value'] < 0 || $arguments['value'] > 100) {
                throw new ApiException('Value is out of range');
            }

            if (!isset($arguments['value'])) {
                throw new ApiException('Missing value');
            }

            $this->dbmodel->updateLight($arguments['id'], $arguments['value']);


            $response->setData(['OK']);
        } catch (ApiException $e) {
            $response->setError($e->getMessage());
        }

//        catch (\Exception $e) {
//            $response->setError('An unexcepted error occurred.', 500);
//        }

        $this->sendJson($response);
    }
}