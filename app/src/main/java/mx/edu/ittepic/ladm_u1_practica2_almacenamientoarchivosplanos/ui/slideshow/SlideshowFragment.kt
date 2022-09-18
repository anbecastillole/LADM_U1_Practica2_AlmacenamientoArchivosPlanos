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
            var items: List<Frutas>
            items = mutableListOf(Frutas(R.drawable.pepino,"contenido","20".toInt()))
            println("inicio "+items.toString()+items.size)
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
                val chunks = words.chunked(2) //junta de a 2 = [fruta, csntidad]

                println(chunks)
                //POR HACER:
                //agregar un for que recorra el tamaño de chunks y lea si chunks[i][0].equals("fresa") u otra fruta
                //haga lo de la linea 75, que es agregar un item, pasarle el nombre, la cantidad chunks[i][1]
                // y la imagen que le corresponda
                println(chunks[0][1]) //cantidad


                if(contenido.equals("fresa:1:zanahoria:1:")){
                    println("chi");items = mutableListOf(Frutas(R.drawable.fresas,"Fresas","12".toInt()));

                    items.add(Frutas(R.drawable.fresas, "Prueba", 230))
                    items.add(Frutas(R.drawable.zanahoria, "otraprueba", 456))
                }

                mensaje = "SE  LEYÓ CORRECTAMENTE"
                println("hey "+items.toString()+items.size)
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