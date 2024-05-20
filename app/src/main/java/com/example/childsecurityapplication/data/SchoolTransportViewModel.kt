package com.example.childsecurityapplication.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController

import com.example.childsecurityapplication.model.SchoolTransport
import com.example.childsecurityapplication.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class schoolTransportviewmodel(var navController: NavController, var context: Context) {
    var authRepository: AuthViewModel


    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }

    }


    fun saveSchoolTransport(name: String, time: String, busnumber: String, drivername: String) {
        var id = System.currentTimeMillis().toString()
        var schoolTransportData = SchoolTransport(name, time, busnumber,drivername, id)
        var schoolTransportRef = FirebaseDatabase.getInstance().getReference()
            .child("SchoolTransport/$id")

        schoolTransportRef.setValue(schoolTransportData).addOnCompleteListener {

            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewSchoolTransports(
        schoolTransport: MutableState<SchoolTransport>,
        schoolTransports: SnapshotStateList<SchoolTransport>
    ): SnapshotStateList<SchoolTransport> {
        var ref = FirebaseDatabase.getInstance().getReference().child("SchoolTransports")


        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
           
                schoolTransports.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(SchoolTransport::class.java)
                    schoolTransport.value = value!!
                    schoolTransports.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return schoolTransports
    }
}