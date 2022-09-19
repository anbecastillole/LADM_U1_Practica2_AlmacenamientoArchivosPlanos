package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.slideshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.FrutaAdapter
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.Frutas
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.R
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.databinding.FragmentSlideshowBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    var items = mutableListOf(Frutas(R.drawable.fresas,"Fresas",1))
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
        val btn = view.findViewById<Button>(R.id.btnver)
        val texto = view.findViewById<TextView>(R.id.titulo1)
        //AQUI


        btn.setOnClickListener {


            //items = mutableListOf(Frutas(R.drawable.pepino,"pepino","20".toInt()))
         //   println("inicio "+items.toString()+items.size)
            //

            //

            //zana.setText("HOLA")
            var contenido = abrirDesdeMemoriaInterna()
            var mensaje = ""
            if (contenido.isEmpty()==true) {

                mensaje = "ERROR, NO SE PUDO LEER"
            } else {
                texto.setText(contenido)
                println(contenido)

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
                          items.add(Frutas(R.drawable.fresas, "Fresas", chunks[0][1].toInt())); //println("fruta" + item[0] + "cantidad" + item[1])
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

        return view
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