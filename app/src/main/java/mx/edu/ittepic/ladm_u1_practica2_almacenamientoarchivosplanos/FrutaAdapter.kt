package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.slideshow.SlideshowFragment
import java.security.AccessController.getContext


class FrutaAdapter(items: List<Frutas>): RecyclerView.Adapter<FrutaAdapter.ViewHolder>() {
    private val items: List<Frutas>
  //  lateinit var binding : AdapterFrutaBinding

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }

    fun editarRegistro(){

        //AlertDialog.Builder() builder = new SlideshowFragment().context?.let { AlertDialog.Builder(builder) }

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=items[i].nombre
        viewHolder.itemDetail.text=items[i].cantidad.toString()
        viewHolder.itemImage.setImageResource(items[i].imagen)
        viewHolder.card.setOnClickListener(View.OnClickListener {
            println("CLICK AL "+i)
           // AlertDialog.Builder(viewHolder.bindingAdapter).setTitle()

        })
    }
    init {
        this.items = items
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var card : CardView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail= itemView.findViewById(R.id.item_detal)
            card = itemView.findViewById<CardView>(R.id.card_view)

        }
    }
}