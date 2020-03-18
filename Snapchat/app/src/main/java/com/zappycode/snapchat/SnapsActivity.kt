package com.zappycode.snapchat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class SnapsActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snaps)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val infalter = menuInflater
        infalter.inflate(R.menu.snaps,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.createSnap) {
            val intent = Intent(this, CreateSnapActivity::class.java)
            startActivity(intent)
        } else if (item?.itemId == R.id.logout) {
            mAuth.signOut()
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mAuth.signOut()
    }
}
