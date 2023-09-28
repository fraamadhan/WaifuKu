package com.example.waifuku

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var rvWaifus : RecyclerView
    private val list = ArrayList<Waifu>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runBlocking {
            delay(2000)
        }
        supportActionBar?.title = "Waifu List"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#800000")))

        rvWaifus =findViewById(R.id.rv_waifus)
        rvWaifus.setHasFixedSize(true)

        list.addAll(getListWaifus())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.user_profille, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val user = UserAccount(
            "Fakhri Fajar Ramadhan",
            "fakhrifajarrr@gmail.com",
        )
        when (item.itemId){
            R.id.about_page -> {
                val moveToUserProfile = Intent(this@MainActivity, UserAccountActivity::class.java)
                moveToUserProfile.putExtra(UserAccountActivity.EXTRA_DATA, user)
                startActivity(moveToUserProfile)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getListWaifus() : ArrayList<Waifu>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataDetail = resources.getStringArray(R.array.data_detail)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listWaifu = ArrayList<Waifu>()

        for(i in dataName.indices){
            val waifu = Waifu(dataName[i], dataDescription[i], dataDetail[i], dataPhoto.getResourceId(i, -1))
            listWaifu.add(waifu)
        }
        return listWaifu
    }

    private fun showRecyclerList(){
        rvWaifus.layoutManager = LinearLayoutManager(this)
        val listWaifuAdapter = ListsWaifuAdapter(list)
        rvWaifus.adapter = listWaifuAdapter

        listWaifuAdapter.setOnItemClickCallback(object : ListsWaifuAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Waifu) {
//                showSelectedHero(data)
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(DetailActivity.EXTRA_DATA, data)
                startActivity(intentToDetail)
            }

        })
    }
}