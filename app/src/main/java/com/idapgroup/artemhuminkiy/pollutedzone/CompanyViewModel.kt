package com.idapgroup.artemhuminkiy.pollutedzone

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.idapgroup.artemhuminkiy.pollutedzone.data.Company
import com.idapgroup.artemhuminkiy.pollutedzone.data.DatabaseCompany
import java.util.*
import kotlin.collections.ArrayList


class CompanyViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var db : DatabaseCompany

    public var companies = MutableLiveData<MutableList<Company>>().apply { value = ArrayList() }

    public fun initDb() {
        db = DatabaseCompany.getInstance(this.getApplication())
    }

    init {
        initDb()
        companies.value!!.addAll(db.companyDao().companies())
    }

    fun addCompanie(name : String, address: String){
        val id = UUID.randomUUID().toString()
        companies.value!!.add(Company(id, name, address))
    }

    fun addCompanie(latitude : Double, longitude : Double){

    }
}