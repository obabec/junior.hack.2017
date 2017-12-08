<?php
/**
 * Created by PhpStorm.
 * UserEntity: Honza
 * Date: 22.08.2017
 * Time: 15:45
 */

namespace App\Model\Entities;
use Doctrine\ORM\Mapping as ORM;

/**
 * Class BaseEntity
 * @package App\Model\Entities
 * @ORM\MappedSuperclass
 */
class BaseEntity
{
    /**
     * @var int
     * @ORM\Id
     * @ORM\Column(type="integer")
     * @ORM\GeneratedValue
     */
    public $id;
}