<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 29.11.2017
 * Time: 17:30
 */

namespace App\Models;


use Kdyby\Doctrine\EntityManager;

abstract class BaseModel
{
    /** @var  EntityManager */
    protected $em;

    /**
     * BaseModel constructor.
     * @param EntityManager $em
     */
    public function __construct(EntityManager $em)
    {
        $this->em = $em;
    }
}