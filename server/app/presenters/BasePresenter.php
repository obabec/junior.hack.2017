<?php

namespace App\Presenters;

use Nette;


/**
 * Base presenter for all application presenters.
 */
abstract class BasePresenter extends Nette\Application\UI\Presenter
{
    protected function createTemplate()
    {
        $this->setLayout(__DIR__ . '/templates/@layout.latte');
        return parent::createTemplate();
    }
}
