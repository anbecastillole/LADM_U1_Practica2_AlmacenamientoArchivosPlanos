package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FrutaAdapter(items: List<Frutas>): RecyclerView.Adapter<FrutaAdapter.ViewHolder>() {
    private val items: List<Frutas>


    val titles = arrayOf("sí jala este","Soy","Ana","Castillo","Leal")
    val details = arrayOf("Mannzana","Fresa","Naranja","Frutas","Verde")
    val images = intArrayOf(R.drawable.betabel,R.drawable.brocoli,R.drawable.chayote,R.drawable.zanahoria,R.drawable.elote)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=items[i].nombre
        viewHolder.itemDetail.text=items[i].cantidad.toString()
        viewHolder.itemImage.setImageResource(items[i].imagen)
    }
    init { //ESTO
        this.items = items
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail= itemView.findViewById(R.id.item_detal)
        }
    }
}