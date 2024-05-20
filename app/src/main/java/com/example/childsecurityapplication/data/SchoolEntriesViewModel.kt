package com.example.childsecurityapplication.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.childsecurityapplication.model.HomeTransport
import com.example.childsecurityapplication.model.SchoolEntries
import com.example.childsecurityapplication.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



    class schoolEntriesviewmodel(var navController: NavController, var context: Context) {
        var authRepository: AuthViewModel
        var progress: ProgressDialog

        init {
            authRepository = AuthViewModel(navController, context)
            if (!authRepository.isloggedin()) {
                navController.navigate(ROUTE_LOGIN)
            }
            progress = ProgressDialog(context)
            progress.setTitle("Loading")
            progress.setMessage("Please wait...")
        }


        fun saveSchoolEntries(name: String, lastclass: String, lastteacher: String) {
            var id = System.currentTimeMillis().toString()
            var schoolEntriesData = SchoolEntries(name, lastclass, lastteacher, id)
            var schoolEntriesRef = FirebaseDatabase.getInstance().getReference()
                .child("SchoolEntries/$id")
            progress.show()
            schoolEntriesRef.setValue(schoolEntriesData).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        fun viewSchoolEntriess(
            schoolEntries: MutableState<SchoolEntries>,
            schoolEntriess: SnapshotStateList<SchoolEntries>
        ): SnapshotStateList<SchoolEntries> {
            var ref = FirebaseDatabase.getInstance().getReference().child("SchoolEntries")

            progress.show()
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    progress.dismiss()
                    schoolEntriess.clear()
                    for (snap in snapshot.children) {
                        val value = snap.getValue(SchoolEntries::class.java)
                        schoolEntries.value = value!!
                        schoolEntriess.add(value)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                }
            })
            return schoolEntriess
        }
    }

