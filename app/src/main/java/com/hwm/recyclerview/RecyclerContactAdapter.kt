package com.hwm.recyclerview

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
            llView.setOnClickListener {
                // Handle click on the contact item

                val dialog = Dialog(llView.context, R.style.CustomDialog)
                // Inflate the dialog layout
                val dialogView = LayoutInflater.from(llView.context).inflate(R.layout.add_update_layout, null)
                dialog.setContentView(dialogView)
                val etName = dialogView.findViewById<EditText>(R.id.etName)
                val etNumber = dialogView.findViewById<EditText>(R.id.etNumber)
                val etAction = dialogView.findViewById<Button>(R.id.btnAction)
                val textView = dialogView.findViewById<TextView>(R.id.tvTitle)

                textView.text = "Update Contact"
                etAction.text = "Update"

                etName.setText(contact.name)
                etNumber.setText(contact.number)

                // Set the click listener for the "Update" button in the dialog
                etAction.setOnClickListener {
                    val name = etName.text.toString().trim()
                    val number = etNumber.text.toString().trim()

                    if (name.isEmpty() && number.isEmpty()) {
                        Toast.makeText(holder.itemView.context, "Name and Number are Empty", Toast.LENGTH_LONG).show()
                    } else if (name.isEmpty()) {
                        Toast.makeText(holder.itemView.context, "Name is Empty", Toast.LENGTH_LONG).show()
                    } else if (number.isEmpty()) {
                        Toast.makeText(holder.itemView.context, "Number is Empty", Toast.LENGTH_LONG).show()
                    } else {
                        contactList[position].name = name
                        contactList[position].number = number
                        notifyItemChanged(position)
                        dialog.dismiss()
                    }
                }
                // Show the dialog to the user
                dialog.show()
            }

            llView.setOnLongClickListener{
                // Handle long click on the contact item

                //setting alert Dialog Button
                var builder  = AlertDialog.Builder(llView.context)
                builder.setTitle("Delete Contact")
                builder.setMessage("Are you sure you want to delete this contact?")
                builder.setIcon(R.drawable.baseline_delete_24)
                builder.setPositiveButton("Yes"){
                    dialog,which->
                    contactList.removeAt(position)
                    notifyItemRemoved(position)
                }
                builder.setNegativeButton("No"){
                    dialog,which->
                }

                builder.show()
                true
            }
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
        val llView: LinearLayout = itemView.findViewById(R.id.llView)
    }
}
