<?php
/**
 * Created by PhpStorm.
 * User: Honza
 * Date: 04.12.2017
 * Time: 8:56
 */

namespace ApiModule\Managers;

use App\Exceptions\ScriptException;
use Nette\Utils\Strings;

/**
 * Class ScriptManager
 * @package ApiModule\Managers
 */
class ScriptManager
{
    /** @var string  */
    protected $path;

    /**
     * ScriptManager constructor.
     */
    public function __construct()
    {
        $this->path = __DIR__ . '/../scripts';
    }


    /**
     * @param string $name
     * @param array $args
     * @throws ScriptException
     */
    public function runScript($name, array $args = [])
    {
        $this->setScript($name);

        $arguments = $this->getArgumentsString($args);

        $result = shell_exec('python3 ' . $this->path . ' ' . $arguments);

        if ($result === null) {
            throw new ScriptException('Nullable response from script.');
        }
//        else if (!Strings::checkEncoding($result)) {
//            throw new ScriptException('Non UTF-8 result encoding.'); // json result needs UTF-8 characters
//        }
    }

    /**
     * @param array $args
     * @return string
     */
    protected function getArgumentsString(array $args)
    {
        $arg_string = '';

        foreach ($args as $key => $value) {
            $arg_string .= " --$key $value";
        }

        return $arg_string;
    }

    /**
     * @param string $name
     */
    protected function setScript($name)
    {
        $this->path .= '/' . $name;
    }
}