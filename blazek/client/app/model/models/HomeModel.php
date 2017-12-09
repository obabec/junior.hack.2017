<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 09.12.2017
 * Time: 9:13
 */

namespace App\Models;


use Doctrine\ORM\Mapping\Entity;
use Kdyby\Doctrine\EntityManager;

class HomeModel
{

    /** @var  EntityManager */
    protected $em;
    /**
     * HomeModel constructor.
     * @param EntityManager $em
     */
    public function __construct(EntityManager $em)
    {
        $this->em = $em;
    }

    /**
     * @param integer $argument
     */
    public function zamnkout($argument)
    {
//        $argument = (bool)$argument;
        $this->em->getConnection()->update('pins', [
            'argument' => 1
        ], [
            'id' => 11
        ]);
        sleep(2);
        $this->em->getConnection()->update('pins', [
            'argument' => 0
        ], [
            'id' => 11
        ]);
    }
    /**
     * @return array
     */
    public function readSvetlo()
    {
        return $this->em->getConnection()->fetchAll('SELECT * FROM pins');
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