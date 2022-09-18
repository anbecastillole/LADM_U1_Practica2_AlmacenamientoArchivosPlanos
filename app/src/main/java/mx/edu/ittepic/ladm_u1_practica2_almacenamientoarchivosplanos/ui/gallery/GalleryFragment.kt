package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.FrutaAdapter
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.Frutas
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.R
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.databinding.FragmentGalleryBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View =inflater.inflate(R.layout.fragment_gallery,container,false)
        var s= ""
        val botonguardar = view.findViewById<Button>(R.id.btnguardar)
       // val botonleer = view.findViewById<Button>(R.id.btnleer)
        val fresa = view.findViewById<CheckBox>(R.id.fresach)
        val zanahoria = view.findViewById<CheckBox>(R.id.zanahoriach)
        val fresac =view.findViewById<EditText>(R.id.fresacant)
        val zanac = view.findViewById<EditText>(R.id.zanahoriacant)
        //prueba custom adapter
        var items: List<Frutas> = ArrayList()
        val adapter = FrutaAdapter(items)
        val recyclerView = view.findViewById<RecyclerView>(R.id.reclyclerView)//
        //val adapter = CustomAdapterA()//
        recyclerView.layoutManager= LinearLayoutManager(context)//
       //
        view.findViewById<RecyclerView>(R.id.reclyclerView).visibility = INVISIBLE //PROVISIONAL HASTA QUE EL CUSTOM TOME VALORES DE ARREGLOS


        botonguardar.setOnClickListener {
            if (fresa.isChecked()){ s+=("fresa:"+fresac.text.toString()+":") }
            if (zanahoria.isChecked()){ s+=("zanahoria:"+zanac.text.toString()+":") }

            var data = s;
            var mensaje = ""
            if (guardarEnMemoriaInterna(data)== true) {
                mensaje = "SE GUARDO CON EXITO"
            } else {
                mensaje = "ERROR AL GUARDAR"
            }

            getActivity()?.let { it1 -> AlertDialog.Builder(it1).setMessage(mensaje).setPositiveButton("ok"){d,i->d.dismiss()}
                .show()
            }
        }
/*
        botonleer.setOnClickListener {
            view.findViewById<RecyclerView>(R.id.reclyclerView).visibility = VISIBLE
            //zana.setText("HOLA")
            var contenido = ""
            contenido=abrirDesdeMemoriaInterna()


            var msj = ""
            if (contenido.isEmpty()==true) {

                msj = "ERROR, NO SE PUDO LEER"
            } else {

                Log.wtf("myWTFTag",contenido)
                if(contenido=="fresa"){Log.wtf("myWTFTag","adentro");items = listOf(Frutas(R.drawable.fresas,"Fresas","12".toInt()))}
                msj = "SE  LEYÓ CORRECTAMENTE"
                recyclerView.adapter=adapter
            }
            getActivity()?.let { it1 -> AlertDialog.Builder(it1).setMessage(msj).setPositiveButton("ok"){ d, i->d.dismiss()}
                .show() }
            }
*/

/*
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root*/
/*
        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return view
    }

    private fun guardarEnMemoriaInterna(data:String): Boolean {
        try {
            var flujoSalida = OutputStreamWriter(getActivity()?.openFileOutput("archivo.txt", Context.MODE_PRIVATE))
            flujoSalida.write(data)
            flujoSalida.flush()
            flujoSalida.close()
        }catch(io: IOException){
            return false
        }
        return true
    }

    private fun abrirDesdeMemoriaInterna(): String {
        var data=""
        try {

            var flujoEntrada = BufferedReader(InputStreamReader(getActivity()?.openFileInput("archivo.txt")))
            data= flujoEntrada.readLine()
            flujoEntrada.close()
        }catch(io: IOException){
            return ""
        }
        return data
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


class CustomAdapterA: RecyclerView.Adapter<CustomAdapterA.ViewHolder>() {

    val titles = arrayOf("sí jala este","Soy","Ana","Castillo","Leal")
    val details = arrayOf("Mannzana","Fresa","Naranja","Frutas","Verde")
    val images = intArrayOf(R.drawable.betabel,R.drawable.brocoli,R.drawable.chayote,R.drawable.zanahoria,R.drawable.elote)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemDetail.text=details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
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