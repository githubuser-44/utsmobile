package com.example.profilfakultas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFakultasData()
        fakultasParts.layoutManager = LinearLayoutManager(this)
        fakultasParts.setHasFixedSize(true)
        fakultasParts.adapter = FakultasAdapter(testData, { fakultasItem: FakultasData -> fakultasItemClicked(fakultasItem)})
    }

    private fun fakultasItemClicked(fakultasItem: FakultasData) {
        val showDetailActivityIntent = Intent(this, FakultasDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, fakultasItem.namaFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, fakultasItem.deskripsiFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, fakultasItem.listProdi.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, fakultasItem.fotoFakultas.toString())
        startActivity(showDetailActivityIntent)
    }

    private fun createFakultasData() : List<FakultasData> {
        val partList = ArrayList<FakultasData>()
        partList.add(FakultasData("Fakultas Ilmu Komputer", "1. Sistem Informasi\n2. Teknik Informatika", "Fakultas", R.drawable.logoupn))
        partList.add(FakultasData("Fakultas Teknik", "1. Teknik Kimia\n2. Teknik Industri\n3. Teknik Pangan\n4. Teknik Lingkungan\n5. Teknik Sipil", "Fakultas", R.drawable.logoupn))
        partList.add(FakultasData("Fakultas Ekonomi dan Bisnis", "1. Ekonomi Pembangunan\n2. Manajemen\n3. Akuntansi", "Fakultas", R.drawable.logoupn))
        partList.add(FakultasData("Fakultas  Pertanian", "1. Agroteknologi\n2. Agribisnis", "Fakultas", R.drawable.logoupn))
        partList.add(FakultasData("Hanif Ryandhika", "1. Tempat, Tanggal Lahir: Surabaya, 25 Agustus 1999\n2. Alamat: Perum The Gayungsari F23\n3. No.HP: 081234567890\n4. Email: haniferge@gmail.com\n5. Url Github: https://github.com/githubuser-44\n6. Riwayat Pendidikan: \n\t - SD Muhammadiyah \n\t - SMPN 4 Depok \n\t - SMA AL HIKMAH\n7. Penghargaan: Alhamdulillah Banyak ", "", R.drawable.erg))
        return partList

    }
}
