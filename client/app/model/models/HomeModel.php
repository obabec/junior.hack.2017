<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 04.12.2017
 * Time: 9:40
 */

namespace App\Models;


use ApiModule\Managers\ScriptManager;
use App\Exceptions\ApiException;
use App\Exceptions\ScriptException;

class HomeModel
{
    /** @var  ScriptManager */
    protected $scripManager;

    /**
     * ScriptModel constructor.
     * @param ScriptManager $scripManager
     */
    public function __construct(ScriptManager $scripManager)
    {
        $this->scripManager = $scripManager;
    }


    public function neco()
    {
        try {
            // $this->scripManager->runScript();
        } catch (ScriptException $e) {
            throw new ApiException($e->getMessage());
        }
    }
}