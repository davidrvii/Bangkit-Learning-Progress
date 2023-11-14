package com.example.myfavnba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var favNBA: RecyclerView
    private val list = ArrayList<nbaPlayer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        favNBA = findViewById(R.id.fav_nba)
        favNBA.setHasFixedSize(true)

        list.addAll(getListNBA())
        showRecyclerList()
    }

    private fun getListNBA(): ArrayList<nbaPlayer> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataTim = resources.getStringArray(R.array.data_team)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataKelahiran = resources.getStringArray(R.array.Kelahiran)
        val dataNoPunggung = resources.getStringArray(R.array.no_punggung)
        val dataTinggi = resources.getStringArray(R.array.tinggi)
        val dataStatus = resources.getStringArray(R.array.status)
        val dataDescription = resources.getStringArray(R.array.description)
        val listNBA = ArrayList<nbaPlayer>()
        for (i in dataName.indices) {
            val player = nbaPlayer(
                dataName[i],
                dataTim[i],
                dataPhoto.getResourceId(i, -1),
                dataKelahiran[i],
                dataNoPunggung[i],
                dataTinggi[i],
                dataStatus[i],
                dataDescription[i]
            )
            listNBA.add(player)
        }
        return listNBA
    }

    private fun showRecyclerList() {
        favNBA.layoutManager = LinearLayoutManager(this)
        val listnbaPlayerAdapter = nbaPlayerAdapter(list)
        favNBA.adapter = listnbaPlayerAdapter

        listnbaPlayerAdapter.setOnitemClickCallback(object : nbaPlayerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: nbaPlayer) {
                showSelectedPlayer(data)
            }
        })
    }

    private fun showSelectedPlayer(player: nbaPlayer) {
        val intent = Intent(this, playerDetail::class.java)
        intent.putExtra(playerDetail.EXTRA_PLAYER, player)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_page) {
                val about = Intent(this@MainActivity, about::class.java)
                startActivity(about)
            }
        return super.onOptionsItemSelected(item)
    }
}