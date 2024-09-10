package com.hwm.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerContactAdapter(var contactList: MutableList<contactModal>) : RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>() {

    // Inflate the layout for each contact item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_row, parent, false)
        return ViewHolder(view)
    }

    // Bind the contact data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactList[position]
        holder.apply {
            imgContact.setImageResource(contact.img)
            txtName.text = contact.name
            txtNumber.text = contact.number
        }
    }

    // Return the total number of contacts
    override fun getItemCount(): Int {
        return contactList.size
    }

    // ViewHolder class to hold references to views in the contact_row layout
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgContact: ImageView = itemView.findViewById(R.id.imContact)
        val txtName: TextView = itemView.findViewById(R.id.Contact)
        val txtNumber: TextView = itemView.findViewById(R.id.ContactNumber)
    }
}
