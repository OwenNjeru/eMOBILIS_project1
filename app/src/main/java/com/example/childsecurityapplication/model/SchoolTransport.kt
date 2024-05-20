package com.example.childsecurityapplication.model

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.childsecurityapplication.data.AuthViewModel
import com.example.childsecurityapplication.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SchoolTransport{
    var name:String=""
    var time:String=""
    var busnumber:String=""
    var drivername:String=""
    var id:String=""

    constructor(name:String,time:String,busnumber:String,drivername:String,id:String){
        this.name=name
        this.time=time
        this.busnumber=busnumber
        this.drivername=drivername
        this.id=id

    }
    constructor()
}