<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 08.12.2017
 * Time: 20:50
 */

namespace App\Models;

use App\Model\Entities\Instruction;
use Kdyby\Doctrine\EntityManager;

/**
 * Class DbModel
 * @package App\Models
 */
class DbModel
{
    /** @var  EntityManager */
    protected $em;

    /**
     * DbModel constructor.
     * @param EntityManager $em
     */
    public function __construct(EntityManager $em)
    {
        $this->em = $em;
    }

    /**
     * @param integer $id
     * @param integer $value
     */
    public function updateLight($id, $value)
    {
        $this->em->getConnection()->update('pins', [
            'argument' => $value
        ], ['id' => $id]);
    }
}