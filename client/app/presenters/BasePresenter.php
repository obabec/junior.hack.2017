<?php

namespace App\Presenters;

use App\Services\ApiResponse;
use Nette;


/**
 * Base presenter for all application presenters.
 */
abstract class BasePresenter extends Nette\Application\UI\Presenter
{
    /**
     * @return ApiResponse
     */
    public function prepareResponse()
    {
        return new ApiResponse();
    }
}
