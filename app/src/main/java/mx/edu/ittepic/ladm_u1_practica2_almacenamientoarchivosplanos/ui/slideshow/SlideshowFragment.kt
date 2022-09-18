package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.slideshow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.CustomAdapter
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.R
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.databinding.FragmentSlideshowBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter


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
        val adapter = CustomAdapter()//

        recyclerView.layoutManager= LinearLayoutManager(context)//
        recyclerView.adapter=adapter//
        btn.setOnClickListener {
            //zana.setText("HOLA")
            var contenido = abrirDesdeMemoriaInterna()
            var mensaje = ""
            if (contenido.isEmpty()==true) {

                mensaje = "ERROR, NO SE PUDO LEER"
            } else {
                texto.setText(contenido)
                mensaje = "SE  LEYÓ CORRECTAMENTE"
            }

            getActivity()?.let { it1 -> AlertDialog.Builder(it1).setMessage(mensaje).setPositiveButton("ok"){ d, i->d.dismiss()}
                .show()
            }


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