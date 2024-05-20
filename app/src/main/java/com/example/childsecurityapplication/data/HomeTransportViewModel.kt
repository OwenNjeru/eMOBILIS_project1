package com.example.childsecurityapplication.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.childsecurityapplication.model.HomeTransport
import com.example.childsecurityapplication.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class homeTransportviewmodel(var navController: NavController, var context: Context) {
    var authRepository: AuthViewModel


    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }

    }


    fun saveHomeTransport(name: String, time: String, busnumber: String, drivername: String) {
        var id = System.currentTimeMillis().toString()
        var homeTransportData = HomeTransport(name, time, busnumber,drivername, id)
        var homeTransportRef = FirebaseDatabase.getInstance().getReference()
            .child("HomeTransport/$id")

        homeTransportRef.setValue(homeTransportData).addOnCompleteListener {

            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewHomeTransports(
        homeTransport: MutableState<HomeTransport>,
        homeTransports: SnapshotStateList<HomeTransport>
    ): SnapshotStateList<HomeTransport> {
        var ref = FirebaseDatabase.getInstance().getReference().child("HomeTransports")


        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                homeTransports.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(HomeTransport::class.java)
                    homeTransport.value = value!!
                    homeTransports.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return homeTransports
    }
}