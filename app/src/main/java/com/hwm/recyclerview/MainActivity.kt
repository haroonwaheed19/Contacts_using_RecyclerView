package com.hwm.recyclerview

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var contactList :MutableList<contactModal>
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: RecyclerContactAdapter
    private lateinit var fabAction: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.rvContactUs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fabAction = findViewById(R.id.fabAction)

        contactList = mutableListOf(
            contactModal(R.drawable.employee, "Haroon Waheed", "03001234567"),
            contactModal(R.drawable.female, "Ayesha Khan", "03011234567"),
            contactModal(R.drawable.employee, "Bilal Ahmed", "03021234567"),
            contactModal(R.drawable.employee, "Chaudhry Usman", "03031234567"),
            contactModal(R.drawable.female, "Dania Ali", "03041234567"),
            contactModal(R.drawable.female, "Eman Fatima", "03051234567"),
            contactModal(R.drawable.employee, "Faisal Shah", "03061234567"),
            contactModal(R.drawable.employee, "Ghulam Abbas", "03071234567"),
            contactModal(R.drawable.female, "Hina Malik", "03081234567"),
            contactModal(R.drawable.female, "Iram Batool", "03091234567"),
            contactModal(R.drawable.employee, "Junaid Akram", "03101234567"),
            contactModal(R.drawable.employee, "Kamran Siddiqi", "03111234567"),
            contactModal(R.drawable.employee, "Luqman Tariq", "03121234567"),
            contactModal(R.drawable.female, "Maira Zafar", "03131234567"),
            contactModal(R.drawable.female, "Nazia Iqbal", "03141234567"),
            contactModal(R.drawable.employee, "Omar Farooq", "03151234567"),
            contactModal(R.drawable.female, "Parveen Akhtar", "03161234567"),
            contactModal(R.drawable.employee, "Qasim Javed", "03171234567"),
            contactModal(R.drawable.female, "Rabia Noor", "03181234567"),
            contactModal(R.drawable.female, "Sana Javed", "03191234567"),
            contactModal(R.drawable.employee, "Tariq Mahmood", "03201234567"),
            contactModal(R.drawable.female, "Ummul Huda", "03211234567"),
            contactModal(R.drawable.employee, "Vijay Kumar", "03221234567"),
            contactModal(R.drawable.employee, "Wasiq Khan", "03231234567"),
            contactModal(R.drawable.female, "Xena Patel", "03241234567"),
            contactModal(R.drawable.female, "Yasmin Bibi", "03251234567"),
            contactModal(R.drawable.employee, "Zahid Ahmed", "03261234567"),
            contactModal(R.drawable.employee, "Adeel Shah", "03271234567"),
            contactModal(R.drawable.female, "Bismah Tariq", "03281234567"),
            contactModal(R.drawable.female, "Cynthia Johnson", "03291234567"),
            contactModal(R.drawable.employee, "Danish Raza", "03301234567"),
            contactModal(R.drawable.employee, "Ehsanullah", "03311234567"),
            contactModal(R.drawable.female, "Fariha Ali", "03321234567"),
            contactModal(R.drawable.female, "Gulrukh Bibi", "03331234567"),
            contactModal(R.drawable.employee, "Hassan Rafiq", "03341234567"),
            contactModal(R.drawable.employee, "Iftikhar Ali", "03351234567"),
            contactModal(R.drawable.female, "Javeria Qureshi", "03361234567"),
            contactModal(R.drawable.female, "Kiran Bibi", "03371234567"),
            contactModal(R.drawable.employee, "Liaquat Ali", "03381234567"),
            contactModal(R.drawable.employee, "Mohsin Niazi", "03391234567"),
            contactModal(R.drawable.female, "Naila Raza", "03401234567"),
            contactModal(R.drawable.female, "Omaima Khan", "03411234567"),
            contactModal(R.drawable.employee, "Pervaiz Iqbal", "03421234567"),
            contactModal(R.drawable.employee, "Qurban Ali", "03431234567"),
            contactModal(R.drawable.female, "Rashida Sultana", "03441234567"),
            contactModal(R.drawable.female, "Sadia Malik", "03451234567"),
            contactModal(R.drawable.employee, "Tariq Aziz", "03461234567"),
            contactModal(R.drawable.employee, "Umair Ahmed", "03471234567"),
            contactModal(R.drawable.female, "Veena Qureshi", "03481234567"),
            contactModal(R.drawable.female, "Warda Nisar", "03491234567")
        )
        adapter = RecyclerContactAdapter(contactList)
        recyclerView.adapter = adapter


        fabAction.setOnClickListener {
            val dialog = Dialog(this, R.style.CustomDialog)
            dialog.setContentView(R.layout.add_update_layout)

            val etName = dialog.findViewById<EditText>(R.id.etName)
            val etNumber = dialog.findViewById<EditText>(R.id.etNumber)
            val etAction = dialog.findViewById<Button>(R.id.btnAction)

            etAction.setOnClickListener {
                val name = etName.text.toString().trim()
                val number = etNumber.text.toString().trim()

                if (name.isEmpty() && number.isEmpty()) {
                    Toast.makeText(this, "Name and Number are Empty", Toast.LENGTH_LONG).show()
                } else if (name.isEmpty()) {
                    Toast.makeText(this, "Name is Empty", Toast.LENGTH_LONG).show()
                } else if (number.isEmpty()) {
                    Toast.makeText(this, "Number is Empty", Toast.LENGTH_LONG).show()
                } else {
                    contactList.add(contactModal(R.drawable.user, name, number))
                    adapter.notifyItemInserted(contactList.size - 1)
                    recyclerView.scrollToPosition(contactList.size - 1)
                    dialog.dismiss()
                }
            }

            dialog.show()
        }
    }

}