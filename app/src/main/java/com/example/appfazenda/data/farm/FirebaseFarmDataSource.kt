package com.example.appfazenda.data.farm

import android.util.Log
import com.example.appfazenda.farm.model.Farm
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class FirebaseFarmDataSource @Inject constructor(
  database: FirebaseDatabase
): IFarmDataSource {

  private val reference: DatabaseReference = database.getReference("farm")
  private val idReference: DatabaseReference = database.getReference("lastFarmId")

  override suspend fun createFarm(farm: Farm): Farm {
    return suspendCoroutine { continuation ->
      reference
        .child(farm.id.toString())
        .setValue(farm)
        .addOnSuccessListener {
          continuation.resumeWith(Result.success(farm))
        }
        .addOnFailureListener{exception ->
          continuation.resumeWith(Result.failure(exception))
        }
    }
  }

  override suspend fun updateFarm(farm: Farm): Farm {
    return suspendCoroutine { continuation ->
      reference
        .child(farm.id.toString())
        .setValue(farm)
        .addOnSuccessListener {
          continuation.resumeWith(Result.success(farm))
        }
        .addOnFailureListener{exception ->
          continuation.resumeWith(Result.failure(exception))
        }
    }
  }

  override suspend fun getFarms(): List<Farm> {

    Log.i("teste", reference.toString())

    return suspendCoroutine { continuation ->

      reference.get().addOnSuccessListener { snapshot ->
        val farmsList = ArrayList<Farm>()
        if (snapshot.exists()) {
          val gson = Gson()
          for (i in snapshot.children) {
            val json = gson.toJson(i.value)
            val farm = gson.fromJson(json, Farm::class.java)

            farmsList.add(
              Farm(
                farm.id,
                farm.name,
                farm.value,
                farm.employeesNumber
              )
            )
          }
        }
        continuation.resumeWith(Result.success(farmsList))
      }.addOnFailureListener{ exception ->
        continuation.resumeWith(Result.failure(exception))
      }
    }
  }

  override suspend fun getFarmsByName(name: String): List<Farm> {
    return suspendCoroutine { continuation ->
      reference
        .orderByChild("name")
        .equalTo(name).get()
        .addOnSuccessListener { snapshot ->
          val farmsList = ArrayList<Farm>()
          if (snapshot.exists()) {
            val gson = Gson()
            for (i in snapshot.children) {
              val json = gson.toJson(i.value)
              val farm = gson.fromJson(json, Farm::class.java)

              farmsList.add(
                Farm(
                  farm.id,
                  farm.name,
                  farm.value,
                  farm.employeesNumber
                )
              )
            }
          }
          continuation.resumeWith(Result.success(farmsList))
        }.addOnFailureListener { exception ->
          continuation.resumeWith(Result.failure(exception))
        }
    }
  }

  override suspend fun getFarmsById(id: Int): List<Farm> {
    return suspendCoroutine { continuation ->
      reference
        .orderByKey()
        .equalTo(id.toString()).get()
        .addOnSuccessListener { snapshot ->
          val farmsList = ArrayList<Farm>()
          if (snapshot.exists()) {
            val gson = Gson()
            for (i in snapshot.children) {
              val json = gson.toJson(i.value)
              val farm = gson.fromJson(json, Farm::class.java)

              farmsList.add(
                Farm(
                  farm.id,
                  farm.name,
                  farm.value,
                  farm.employeesNumber
                )
              )
            }
          }
          continuation.resumeWith(Result.success(farmsList))
        }.addOnFailureListener { exception ->
          continuation.resumeWith(Result.failure(exception))
        }
    }
  }

  override suspend fun deleteFarm(id: Int): Int {
    return suspendCoroutine { continuation ->
      reference
        .child(id.toString())
        .removeValue()
        .addOnSuccessListener {
          continuation.resumeWith(Result.success(id))
        }
        .addOnFailureListener{exception ->
          continuation.resumeWith(Result.failure(exception))
        }
    }
  }

  override suspend fun getLastFarmId(): Int {
    return suspendCoroutine { continuation ->
      idReference.get().addOnSuccessListener { snapshot ->
        val idString = snapshot.value.toString()
        val id = idString.toInt()
        continuation.resumeWith(Result.success(id))
      }.addOnFailureListener{ exception ->
        continuation.resumeWith(Result.failure(exception))
      }
    }
  }

  override suspend fun updateLastFarmId(id: Int): Int {
    return suspendCoroutine { continuation ->
      idReference
        .setValue(id+1)
        .addOnSuccessListener {
          continuation.resumeWith(Result.success(id+1))
        }
        .addOnFailureListener{exception ->
          continuation.resumeWith(Result.failure(exception))
        }
    }
  }
}