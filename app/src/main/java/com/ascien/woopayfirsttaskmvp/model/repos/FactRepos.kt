package com.ascien.woopayfirsttaskmvp.model.repos

import android.util.Log
import com.ascien.woopayfirsttaskmvp.interfaces.FactInterface
import com.ascien.woopayfirsttaskmvp.model.api.JobAPI
import com.ascien.woopayfirsttaskmvp.model.api.JobServices
import com.ascien.woopayfirsttaskmvp.model.datamodel.Fact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactRepos : FactInterface.FactModel{
    private var fact = "bbb"
    private var apiclient: JobServices?=null

    init {
        apiclient = JobAPI.client.create(JobServices::class.java)
    }
    override fun getFact(presenter: FactInterface.FactPresenter) {
        val call = apiclient?.getFact()
        call?.enqueue(object : Callback<Fact>{
            override fun onResponse(call: Call<Fact>, response: Response<Fact>) {
                if (response.isSuccessful){
                    var results = response.body()?.fact
                    fact = results.toString()
                    presenter.UIAutoUpdate()
                }
            }

            override fun onFailure(call: Call<Fact>, t: Throwable) {
                Log.d("error",t.toString())
            }

        })
    }

    override fun getFactS(): String {
        return fact
    }
}