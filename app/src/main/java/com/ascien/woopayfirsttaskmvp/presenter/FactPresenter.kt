package com.ascien.woopayfirsttaskmvp.presenter

import com.ascien.woopayfirsttaskmvp.interfaces.FactInterface
import com.ascien.woopayfirsttaskmvp.model.repos.FactRepos

class FactPresenter(factView: FactInterface.FactView) : FactInterface.FactPresenter{
    private var view: FactInterface.FactView = factView
    private var model: FactInterface.FactModel = FactRepos()
    override fun networkCall() {
        model.getFact(this)
    }

    override fun showFact(): String {
        return model.getFactS()
    }

    override fun UIAutoUpdate() {
        view.updateViewData()
    }
}