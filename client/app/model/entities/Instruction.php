<?php
/**
 * Created by PhpStorm.
 * User: Jan Blažek <jan.blazek@finnology.com>
 * Date: 08.12.2017
 * Time: 17:31
 */

namespace App\Model\Entities;

use Doctrine\ORM\Mapping as ORM;

/**
 * Class Instruction
 * @package App\Model\Entities
 * @ORM\Entity
 */
class Instruction extends BaseEntity
{

    /**
     * @var integer
     * @ORM\Column(type="integer")
     */
    private $argument;


    /**
     * @param integer $argument
     */
    public function setArgument($argument)
    {
        $this->argument = $argument;
    }

    /**
     * @return int
     */
    public function getArgument()
    {
        return $this->argument;
    }
}