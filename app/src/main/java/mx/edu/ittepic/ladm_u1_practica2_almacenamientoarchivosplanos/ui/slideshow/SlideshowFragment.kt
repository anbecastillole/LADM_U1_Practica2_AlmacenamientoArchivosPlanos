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
        val recyclerView = view.findViewById<RecyclerView>(R.id.reclyclerView)//
        val btnVer = view.findViewById<Button>(R.id.btnver)
        val btnEditar=view.findViewById<Button>(R.id.btnEditar)
        val btnEliminar=view.findViewById<Button>(R.id.btneliminar)
        //val texto = view.findViewById<TextView>(R.id.titulo1)
        //AQUI


//lo que hacemos es llevarlo a la pantalla de frutas y verduras para que elija de nuevo sus productos
        btnEditar.setOnClickListener {

            val fragmentManager = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)

            // reemplazamos este fragment con el otro

            transaction.replace(
                R.id.relativelayout,
                GalleryFragment()
            )

            // Commit la transaccion
            transaction.commit()

            //Ocultar botones y etiquetas
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
            //try{
            contenido = abrirDesdeMemoriaInterna()/*}catch(io: NullPointerException){
                mensaje = "ERROR, NO SE PUDO LEER"
            }*/
            print("contenido-"+contenido+"-")
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

                println(chunks)
                //POR HACER:
                //agregar un for que recorra el tamaño de chunks y lea si chunks[i][0].equals("fresa") u otra fruta
                //haga lo de la linea 75, que es agregar un item, pasarle el nombre, la cantidad chunks[i][1]
                // y la imagen que le corresponda
                println(chunks[0][1]) //cantidad

//                for(i in 0..chunks.size){
//                    if(chunks[i][0].equals("fresa")){
//                        items = mutableListOf(Frutas(R.drawable.fresas,"Fresas",chunks[i][1].toInt()));
//                     //   items.add(Frutas(R.drawable.fresas, "Fresas", chunks[0][1].toInt()))
//                    }
//                }

                for (item in chunks) {

                    if (item[0]=="fresa"){
                        //items = mutableListOf(Frutas(R.drawable.fresas,"Fresas",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.fresas, "Fresas", item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                       // (items as MutableList<Frutas>).removeFirst()
                    }
                    if (item[0]=="durazno"){
                       // items = mutableListOf(Frutas(R.drawable.durazno,"Duraznos",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.durazno,"Duraznos",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="guayaba"){
                      //  items = mutableListOf(Frutas(R.drawable.guayabas,"Guayabas",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.guayabas,"Guayabas",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="mango"){
                        //items = mutableListOf(Frutas(R.drawable.mango,"Mangos",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.mango,"Mangos",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="melon"){
                       // items = mutableListOf(Frutas(R.drawable.melon,"Melon",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.melon,"Melon",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="naranja"){
                       // items = mutableListOf(Frutas(R.drawable.naranja,"Naranjas",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.naranja,"Naranjas",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="pina"){
                      //  items = mutableListOf(Frutas(R.drawable.pina,"Piña",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.pina,"Piña",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="platano"){
                      //  items = mutableListOf(Frutas(R.drawable.platano,"Platanos",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.platano,"Platanos",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="sandia"){
                       // items = mutableListOf(Frutas(R.drawable.sandia,"Sandia",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.sandia,"Sandia",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="uvas"){
                       // items = mutableListOf(Frutas(R.drawable.uvas,"Uvas",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.uvas,"Uvas",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="betabel"){
                      //  items = mutableListOf(Frutas(R.drawable.betabel,"Betabel",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.betabel,"Betabel",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="cebolla"){
                      //  items = mutableListOf(Frutas(R.drawable.cebolla,"Cebolla",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.cebolla,"Cebolla",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="chayote"){
                       // items = mutableListOf(Frutas(R.drawable.chayote,"Chayote",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.chayote,"Chayote",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="chile"){
                      //  items = mutableListOf(Frutas(R.drawable.chileserrano,"Chile",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.chileserrano,"Chile",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="elote"){
                        //items = mutableListOf(Frutas(R.drawable.elote,"Elote",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.elote,"Elote",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="jitomate"){
                       // items = mutableListOf(Frutas(R.drawable.jitomate,"Jitomates",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.jitomate,"Jitomates",item[1].toInt())) ;//println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="papa"){
                       // items = mutableListOf(Frutas(R.drawable.papa,"Papas",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.papa,"Papas",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="pepino"){
                    //    items = mutableListOf(Frutas(R.drawable.pepino,"Pepino",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.pepino,"Pepino",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="zanahoria"){
                     //   items = mutableListOf(Frutas(R.drawable.zanahoria,"Zanahorias",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.zanahoria,"Zanahorias",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]=="brocoli"){
                     //   items = mutableListOf(Frutas(R.drawable.brocoli,"Brocoli",item[1].toInt()))
                        (items as MutableList<Frutas>).add(Frutas(R.drawable.brocoli,"Brocoli",item[1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
                    }
                    if (item[0]==""){continue}
                    //(items as MutableList<Frutas>).removeFirst()

                }


//                if(contenido.equals("fresa:1:zanahoria:1:")){
//                    println("chi");items = mutableListOf(Frutas(R.drawable.fresas,"Fresas","12".toInt()));
//
//                    items.add(Frutas(R.drawable.fresas, "Prueba", 230))
//                    items.add(Frutas(R.drawable.zanahoria, "otraprueba", 456))
//                }

//                mensaje = "SE  LEYÓ CORRECTAMENTE"
//                println("hey "+items.toString()+items.size)
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