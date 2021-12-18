package iamzen.`in`.passwordsave

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PassWordTableViewHolder(view: View):RecyclerView.ViewHolder(view){
    val name = view.findViewById<TextView>(R.id.name)
    val password = view.findViewById<TextView>(R.id.passWord)
    val delete = view.findViewById<ImageButton>(R.id.deleteButton)



}
class PassWordTableAdapter(val context: Context, val listener:PassWordDelete): RecyclerView.Adapter<PassWordTableViewHolder>() {

    private val application = ArrayList<PassWordTable>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassWordTableViewHolder {
        val viewHolder = PassWordTableViewHolder(LayoutInflater.from(context).inflate(R.layout.password_item_list,parent,false))
        viewHolder.delete.setOnClickListener{
            listener.deleteButton(application[viewHolder.adapterPosition])
        }

        return viewHolder
    }


    override fun onBindViewHolder(holder: PassWordTableViewHolder, position: Int) {
        val currentPosition = application[position]
        holder.name.text = currentPosition.name
        holder.password.text = currentPosition.password


    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newData: List<PassWordTable>){
        application.clear()
        application.addAll(newData)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return application.size
    }
}

interface PassWordDelete {
    fun deleteButton(passWord:PassWordTable)
}