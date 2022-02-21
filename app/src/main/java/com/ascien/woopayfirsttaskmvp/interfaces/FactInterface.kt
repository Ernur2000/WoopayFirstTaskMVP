package com.ascien.woopayfirsttaskmvp.interfaces

interface FactInterface {
    interface FactModel{
        fun getFact(presenter: FactPresenter)
        fun getFactS(): String
    }
    interface FactView{
        fun updateViewData()
    }
    interface FactPresenter{
        fun networkCall()
        fun showFact() : String
        fun UIAutoUpdate()
    }
}