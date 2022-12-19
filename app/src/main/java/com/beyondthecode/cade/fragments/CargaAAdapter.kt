package com.beyondthecode.cade.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyondthecode.cade.R
import com.beyondthecode.cade.api.modelos.HorarioDTOItem
import com.beyondthecode.cade.databinding.ItemNomateriaBinding

class CargaAAdapter(
    private var context: Context,
    var califaciones: List<HorarioDTOItem>?
) :
    RecyclerView.Adapter<CargaAAdapter.ViewHolder>() {
    var checkBoxStateArray = SparseBooleanArray()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_nomateria, parent, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.binding.textView.text = califaciones!![position].claveMateriaFk.id
        viewHolder.binding.textView2.text = califaciones!![position].claveMateriaFk.nombreMateria
        viewHolder.binding.textView3.text = califaciones!![position].idGrupoFk.numeroGrupo
        viewHolder.binding.checkAdd.setOnCheckedChangeListener { _, isChecked ->
            checkBoxStateArray.put(position, isChecked)
        }
        /*viewHolder.constraintLayout.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putString("id_producto", id[position])
            Navigation.findNavController(v)
                .navigate(R.id.navigation_productos_to_compra_productos, bundle)

        })*/
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return califaciones!!.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemNomateriaBinding.bind(view)
    }
}
