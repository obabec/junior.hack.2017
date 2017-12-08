<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 29.11.2017
 * Time: 18:17
 */

namespace ApiModule\Services;

use Nette\Http\Response;

/**
 * Class ApiResponse
 * @package ApiModule\Services
 */
class ApiResponse extends Response implements \JsonSerializable
{
    /**
     * Status for api response
     * @var string
     */
    const OK = 'OK';

    /**
     * Status for api response
     * @var string
     */
    const ERROR = 'ERROR';

    /**
     * ApiResponse constructor.
     */
    public function __construct()
    {
        $this->setCode(200);
        $this->info['code'] = 200;
        $this->info['status'] = self::OK;
        parent::__construct();
    }

    /**
     * Info about data response
     * @var array
     */
    protected $info = [];

    /**
     * Data from api response
     * @var array
     */
    protected $data = [];

    /**
     * @param mixed $data
     */
    public function setData($data)
    {
        $this->data[] = $data;
    }

    /**
     * @param string $errorMessage
     * @param integer $code
     */
    public function setError($errorMessage, $code = 400)
    {
        $this->info['code'] = $code;
        $this->info['status'] = self::ERROR;
        $this->info['message'] = $errorMessage;
    }

    /**
     * Specify data which should be serialized to JSON
     * @link http://php.net/manual/en/jsonserializable.jsonserialize.php
     * @return mixed data which can be serialized by <b>json_encode</b>,
     * which is a value of any type other than a resource.
     * @since 5.4.0
     */
    public function jsonSerialize()
    {
        $response = [];

        $response['info'] = $this->info;
        $response['data'] = $this->data;

        return $response;
    }
}