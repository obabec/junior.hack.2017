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
use Kdyby\Doctrine\EntityManager;

class HomeModel
{
    /** @var  ScriptManager */
    protected $scripManager;

    /** @var  EntityManager */
    protected $em;

    /**
     * HomeModel constructor.
     * @param ScriptManager $scripManager
     * @param EntityManager $em
     */
    public function __construct(ScriptManager $scripManager, EntityManager $em)
    {
        $this->scripManager = $scripManager;
        $this->em = $em;
    }

    /**
     * @param integer $argument
     */
    public function zamnkout($argument)
    {
        $this->em->getConnection()->update('pins', [
            'argument' => $argument
        ], [
            'id' => 11
        ]);
    }

    /**
     * @return array
     */
    public function readSvetlo()
    {
        return $this->em->getConnection()->fetchAll('SELECT * FROM pins WHERE id <= 10');
    }

    public function prepniSvetle($id, $argument)
    {
        $this->em->getConnection()->update('pins', [
            'argument' => $argument
        ], ['id' =>$id]);
    }

    /**
     * @return EntityManager
     */
    public function getEntityManager()
    {
        return $this->em;
    }
}