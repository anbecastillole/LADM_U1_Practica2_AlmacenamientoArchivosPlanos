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
import kotlinx.android.synthetic.main.fragment_slideshow.*
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
    var contador:Int = 0
    var entra = false

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
        val botonmostrar = view.findViewById<Button>(R.id.mostrar)
       // val botonleer = view.findViewById<Button>(R.id.btnleer)
        val fresa = view.findViewById<CheckBox>(R.id.fresach)
        val fresac =view.findViewById<EditText>(R.id.fresacant)

        val durazno=view.findViewById<CheckBox>(R.id.duraznoch)
        val duraznoc =view.findViewById<EditText>(R.id.duraznocant)

        val guayaba=view.findViewById<CheckBox>(R.id.guayabach)
        val guayabac =view.findViewById<EditText>(R.id.guayabacant)

        val mango=view.findViewById<CheckBox>(R.id.mangoch)
        val mangoc =view.findViewById<EditText>(R.id.mangocant)

        val melon=view.findViewById<CheckBox>(R.id.melonch)
        val melonc =view.findViewById<EditText>(R.id.meloncant)

        val naranja=view.findViewById<CheckBox>(R.id.naranjach)
        val naranjac =view.findViewById<EditText>(R.id.naranjacant)

        val pina=view.findViewById<CheckBox>(R.id.pinach)
        val pinac =view.findViewById<EditText>(R.id.pinacant)

        val platano=view.findViewById<CheckBox>(R.id.platanoch)
        val platanoc =view.findViewById<EditText>(R.id.platanocant)

        val sandia=view.findViewById<CheckBox>(R.id.sandiach)
        val sandiac =view.findViewById<EditText>(R.id.sandiacant)

        val uvas=view.findViewById<CheckBox>(R.id.uvasch)
        val uvasc =view.findViewById<EditText>(R.id.uvascant)

        val betabel=view.findViewById<CheckBox>(R.id.betabelch)
        val betabelc =view.findViewById<EditText>(R.id.betabelcant)

        val brocoli=view.findViewById<CheckBox>(R.id.brocolich)
        val brocolic =view.findViewById<EditText>(R.id.brocolicant)

        val cebolla=view.findViewById<CheckBox>(R.id.cebollach)
        val cebollac =view.findViewById<EditText>(R.id.cebollacant)

        val chayote=view.findViewById<CheckBox>(R.id.chayotech)
        val chayotec =view.findViewById<EditText>(R.id.chayotecant)

        val chile=view.findViewById<CheckBox>(R.id.chilech)
        val chilec =view.findViewById<EditText>(R.id.chilecant)

        val elote=view.findViewById<CheckBox>(R.id.elotech)
        val elotec =view.findViewById<EditText>(R.id.elotecant)

        val jitomate=view.findViewById<CheckBox>(R.id.jitomatech)
        val jitomatec =view.findViewById<EditText>(R.id.jitomatecant)

        val papa=view.findViewById<CheckBox>(R.id.papach)
        val papac =view.findViewById<EditText>(R.id.papacant)

        val pepino=view.findViewById<CheckBox>(R.id.pepinoch)
        val pepinoc =view.findViewById<EditText>(R.id.pepinocant)

        val zanahoria = view.findViewById<CheckBox>(R.id.zanahoriach)
        val zanac = view.findViewById<EditText>(R.id.zanahoriacant)

        val recyclerView = view.findViewById<RecyclerView>(R.id.reclyclerView)

        recyclerView.layoutManager= LinearLayoutManager(context)//
        //botonmostrar.visibility=(INVISIBLE)
        botonguardar.setOnClickListener {
         //   botonmostrar.visibility=(VISIBLE)
            fun  checar(campo: String): String {
                var valor = ""
                if(campo.equals("")){valor="1"}
                else{valor=campo}
                return valor
            }
            contador=0
            var s= ""
            if (fresa.isChecked()){ s+=("fresa:"+checar(fresac.text.toString())+":");contador++}
            if (durazno.isChecked()){ s+=("durazno:"+checar(duraznoc.text.toString())+":");contador++}
            if (guayaba.isChecked()){ s+=("guayaba:"+checar(guayabac.text.toString())+":");contador++}
            if (mango.isChecked()){ s+=("mango:"+checar(mangoc.text.toString())+":");contador++}
            if (melon.isChecked()){ s+=("melon:"+checar(melonc.text.toString())+":");contador++}
            if (naranja.isChecked()){ s+=("naranja:"+checar(naranjac.text.toString())+":");contador++}
            if (pina.isChecked()){ s+=("pina:"+checar(pinac.text.toString())+":");contador++}
            if (platano.isChecked()){ s+=("platano:"+checar(platanoc.text.toString())+":");contador++}
            if (sandia.isChecked()){ s+=("sandia:"+checar(sandiac.text.toString())+":");contador++}
            if (uvas.isChecked()){ s+=("uvas:"+checar(uvasc.text.toString())+":");contador++}
            if (betabel.isChecked()){ s+=("betabel:"+checar(betabelc.text.toString())+":");contador++}
            if (brocoli.isChecked()){ s+=("brocoli:"+checar(brocolic.text.toString())+":");contador++}
            if (cebolla.isChecked()){ s+=("cebolla:"+checar(cebollac.text.toString())+":");contador++}
            if (chayote.isChecked()){ s+=("chayote:"+checar(chayotec.text.toString())+":");contador++}
            if (chile.isChecked()){ s+=("chile:"+checar(chilec.text.toString())+":");contador++}
            if (elote.isChecked()){ s+=("elote:"+checar(elotec.text.toString())+":");contador++}
            if (jitomate.isChecked()){ s+=("jitomate:"+checar(jitomatec.text.toString())+":");contador++}
            if (papa.isChecked()){ s+=("papa:"+checar(papac.text.toString())+":");contador++}
            if (pepino.isChecked()){ s+=("pepino:"+checar(pepinoc.text.toString())+":");contador++}
            if (zanahoria.isChecked()){ s+=("zanahoria:"+checar(zanac.text.toString())+":");contador++}

            if (contador<=9) {
                getActivity()?.let { it1 ->
                    AlertDialog.Builder(it1).setTitle("Venta al mayoreo")
                        .setMessage("Debe elegir mas de 10 productos minimo")
                        .setPositiveButton("ok") { d, i -> d.cancel() }
                        .show()
                }

                return@setOnClickListener
            }
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
            entra = true

        }
        botonmostrar.setOnClickListener(){
            var contenido=""
            var mensaje=""
            contenido = abrirDesdeMemoriaInterna()
            if (contenido.equals("")) {
                mensaje ="ERROR, asegurate de tener guardados artículos en carrito antes de editar"

            } else {
                println(contenido)
            mensaje="¡Gracias por elegirnos! Este es tu carrito:"
            //SPLIT
            val words = contenido.split(':')
            val chunks = words.chunked(2) //junta de a 2 = [fruta, cantidad]
            for (item in chunks) {

                if (item[0]=="fresa"){
                    fresa.isChecked = true
                    fresac.setText(item[1].toString())
                }
                if (item[0]=="durazno"){
                    durazno.isChecked = true
                    duraznoc.setText(item[1].toString())
                }
                if (item[0]=="guayaba"){
                    guayaba.isChecked = true
                    guayabac.setText(item[1].toString())
                }
                if (item[0]=="mango"){
                    mango.isChecked = true
                    mangoc.setText(item[1].toString())
                }
                if (item[0]=="melon"){
                    melon.isChecked = true
                    melonc.setText(item[1].toString())
                }
                if (item[0]=="naranja"){
                    naranja.isChecked = true
                    naranjac.setText(item[1].toString())
                }
                if (item[0]=="pina"){
                    pina.isChecked = true
                    pinac.setText(item[1].toString())
                }
                if (item[0]=="platano"){
                    platano.isChecked = true
                    platanoc.setText(item[1].toString())
                }
                if (item[0]=="sandia"){
                    sandia.isChecked = true
                    sandiac.setText(item[1].toString())
                }
                if (item[0]=="uvas"){
                    uvas.isChecked = true
                    uvasc.setText(item[1].toString())
                }
                if (item[0]=="betabel"){
                    betabel.isChecked = true
                    betabelc.setText(item[1].toString())
                }
                if (item[0]=="cebolla"){
                    cebolla.isChecked = true
                    cebollac.setText(item[1].toString())
                }
                if (item[0]=="chayote"){
                    chayote.isChecked = true
                    chayotec.setText(item[1].toString())
                }
                if (item[0]=="chile"){
                    chile.isChecked = true
                    chilec.setText(item[1].toString())
                }
                if (item[0]=="elote"){
                    elote.isChecked = true
                    elotec.setText(item[1].toString())
                }
                if (item[0]=="jitomate"){
                    jitomate.isChecked = true
                    jitomatec.setText(item[1].toString())
                }
                if (item[0]=="papa"){
                    papa.isChecked = true
                    papac.setText(item[1].toString())
                }
                if (item[0]=="pepino"){
                    pepino.isChecked = true
                    pepinoc.setText(item[1].toString())
                }
                if (item[0]=="zanahoria"){
                    zanahoria.isChecked = true
                    zanac.setText(item[1].toString())
                }
                if (item[0]=="brocoli"){
                    brocoli.isChecked = true
                    brocolic.setText(item[1].toString())
                }
                if (item[0]==""){continue}

            }
        }
            getActivity()?.let { it1 -> AlertDialog.Builder(it1).setMessage(mensaje).setPositiveButton("ok"){ d, i->d.dismiss()}
                .show()
            }
        }
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
            try{
                data= flujoEntrada.readLine()}catch(io:NullPointerException){return ""}
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
