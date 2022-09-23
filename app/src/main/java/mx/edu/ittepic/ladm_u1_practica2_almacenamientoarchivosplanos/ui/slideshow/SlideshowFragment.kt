package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.slideshow
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_slideshow.*
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.FrutaAdapter
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.Frutas
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.R
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.databinding.FragmentSlideshowBinding
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.gallery.GalleryFragment
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
class SlideshowFragment : Fragment() {
    private var _binding: FragmentSlideshowBinding? = null
    var items = mutableListOf(Frutas(R.drawable.ic_baseline_shopping_basket_24,"NOMBRE FRUTA/VERDURA",0))
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val view: View =inflater.inflate(R.layout.fragment_slideshow,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.reclyclerView)
        val btnVer = view.findViewById<Button>(R.id.btnver)
        val btnEditar=view.findViewById<Button>(R.id.btnEditar)
        val btnEliminar=view.findViewById<Button>(R.id.btneliminar)
        // AQUI
        //Lo que hacemos es llevarlo a la pantalla de frutas y verduras para que elija de nuevo sus productos
        btnEditar.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            // reemplazamos este fragment con el otro en realidad se reemplaza el contenido del layout
            transaction.replace(
                R.id.relativelayout,
                GalleryFragment()
            )
            // Commit la transaccion
            transaction.commit()
            //Ocultar botones y etiquetas del actual
            btnVer.setVisibility(View.GONE);
            btnEditar.setVisibility(View.GONE);
            btnEliminar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            titulo1.setVisibility(View.GONE);
        }
        btnVer.setOnClickListener {
            btnVer.visibility=(INVISIBLE)
            btneliminar.visibility=(VISIBLE)
            btnEditar.visibility=(VISIBLE)
            var mensaje=""
            var contenido=""
            contenido = abrirDesdeMemoriaInterna()
            if (contenido.equals("")) {

                mensaje = "ERROR, asegurate de guardar artículos en carrito"
                btneliminar.visibility=(INVISIBLE)
                btnEditar.visibility=(INVISIBLE)
            } else {
                println(contenido)
                mensaje="¡Gracias por elegirnos!"
                //SPLIT
                val words = contenido.split(':')
                val chunks = words.chunked(2) //junta de a 2 = [fruta, cantidad]
                for (item in chunks) {

                    if (item[0]=="fresa"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.fresas, "Fresas", item[1].toInt()));
                    }
                    if (item[0]=="durazno"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.durazno,"Duraznos",item[1].toInt()));
                    }
                    if (item[0]=="guayaba"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.guayabas,"Guayabas",item[1].toInt()));
                    }
                    if (item[0]=="mango"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.mango,"Mangos",item[1].toInt()));
                    }
                    if (item[0]=="melon"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.melon,"Melon",item[1].toInt()));
                    }
                    if (item[0]=="naranja"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.naranja,"Naranjas",item[1].toInt()));
                    }
                    if (item[0]=="pina"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.pina,"Piña",item[1].toInt()));
                    }
                    if (item[0]=="platano"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.platano,"Platanos",item[1].toInt()));
                    }
                    if (item[0]=="sandia"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.sandia,"Sandia",item[1].toInt()));
                    }
                    if (item[0]=="uvas"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.uvas,"Uvas",item[1].toInt()));
                    }
                    if (item[0]=="betabel"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.betabel,"Betabel",item[1].toInt()));
                    }
                    if (item[0]=="cebolla"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.cebolla,"Cebolla",item[1].toInt()));
                    }
                    if (item[0]=="chayote"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.chayote,"Chayote",item[1].toInt()));
                    }
                    if (item[0]=="chile"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.chileserrano,"Chile",item[1].toInt()));
                    }
                    if (item[0]=="elote"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.elote,"Elote",item[1].toInt()));
                    }
                    if (item[0]=="jitomate"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.jitomate,"Jitomates",item[1].toInt()))
                    }
                    if (item[0]=="papa"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.papa,"Papas",item[1].toInt()));
                    }
                    if (item[0]=="pepino"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.pepino,"Pepino",item[1].toInt()));
                    }
                    if (item[0]=="zanahoria"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.zanahoria,"Zanahorias",item[1].toInt()));
                    }
                    if (item[0]=="brocoli"){
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.brocoli,"Brocoli",item[1].toInt()));
                    }
                    if (item[0]==""){continue}

                }

            }

            getActivity()?.let { it1 -> AlertDialog.Builder(it1).setMessage(mensaje).setPositiveButton("ok"){ d, i->d.dismiss()}
                .show()
            }

            val adapter = FrutaAdapter(items)
            recyclerView.layoutManager= LinearLayoutManager(context)//
            recyclerView.adapter=adapter
        }
        btnEliminar.setOnClickListener {
            var data = ""
            var mensaje = ""
            if (guardarEnMemoriaInterna(data)== true) {
                mensaje = "ELIMINADO"
                view.findViewById<RecyclerView>(R.id.reclyclerView).visibility= INVISIBLE
            } else {
                mensaje = "ERROR AL ELIMINAR"
            }

            getActivity()?.let { it1 -> AlertDialog.Builder(it1).setMessage(mensaje).setPositiveButton("ok"){d,i->d.dismiss()}
                .show()
            }
        }

        return view
    }


    private fun abrirDesdeMemoriaInterna(): String {
        var data=""

        try {
            var flujoEntrada = BufferedReader(InputStreamReader(getActivity()?.openFileInput("archivo.txt")))
            try{
                data= flujoEntrada.readLine()}catch(io:NullPointerException){return ""}
            flujoEntrada.close()

        }catch(io: IOException){
            return ""
        }
        return data
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}