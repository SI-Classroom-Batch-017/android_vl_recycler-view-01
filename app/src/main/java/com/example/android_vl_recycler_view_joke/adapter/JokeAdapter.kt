package com.example.android_vl_recycler_view_joke.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_vl_recycler_view_joke.data.model.Joke
import com.example.android_vl_recycler_view_joke.databinding.ListItemJokeBinding

class JokeAdapter(
    private val dataset: List<Joke>
): RecyclerView.Adapter<JokeAdapter.JokeItemViewHolder>() {

    inner class JokeItemViewHolder(val viewBinding: ListItemJokeBinding): RecyclerView.ViewHolder(viewBinding.root)

    /**
     * Wird aufgerufen, wenn der RecyclerView einen neuen [ViewHolder] des angegebenen Typs benötigt, um
     * ein Element darzustellen.
     *
     *
     * Dieser neue ViewHolder sollte mit einer neuen View konstruiert werden, die die Elemente
     * des angegebenen Typs darstellen kann. Du kannst entweder eine neue View manuell erstellen oder sie aus einer XML-Layoutdatei inflatieren.
     *
     *
     * Der neue ViewHolder wird verwendet, um Elemente des Adapters mit
     * [.onBindViewHolder] anzuzeigen. Da er wiederverwendet wird, um
     * verschiedene Elemente im Datensatz anzuzeigen, ist es eine gute Idee, Referenzen auf Unteransichten der View zu cachen, um unnötige [View.findViewById] Aufrufe zu vermeiden.
     *
     * @param parent Die ViewGroup, in die die neue View nach dem Binden an
     * eine Adapterposition eingefügt wird.
     * @param viewType Der View-Typ der neuen View.
     *
     * @return Ein neuer ViewHolder, der eine View des angegebenen Typs hält.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ListItemJokeBinding.inflate(inflater, parent, false)
        val viewHolder = JokeItemViewHolder(viewBinding)
        Log.i("RV_TAG", "onCreateViewHolder, viewHolder: ${viewHolder.hashCode()}")

        return viewHolder
    }

    /**
     * Gibt die Gesamtanzahl der Elemente im vom Adapter gehaltenen Datensatz zurück.
     *
     * @return Die Gesamtanzahl der Elemente in diesem Adapter.
     */
    override fun getItemCount(): Int {
        Log.w("RV_TAG", "getItemCount()")
        return dataset.size
    }

    /**
     * Wird vom RecyclerView aufgerufen, um die Daten an der angegebenen Position anzuzeigen. Diese Methode sollte
     * den Inhalt von [ViewHolder.itemView] aktualisieren, um das Element an der gegebenen
     * Position darzustellen.
     *
     *
     * Beachte, dass im Gegensatz zu [android.widget.ListView] RecyclerView diese Methode
     * nicht erneut aufruft, wenn sich die Position des Elements im Datensatz ändert, es sei denn, das Element selbst
     * ist ungültig oder die neue Position kann nicht bestimmt werden. Aus diesem Grund solltest du den position Parameter
     * nur verwenden, um das zugehörige Datenobjekt innerhalb dieser Methode zu ermitteln und keine Kopie davon behalten. Wenn du die Position eines Elements später benötigst
     * (z.B. in einem Click-Listener), verwende [ViewHolder.getAdapterPosition], das die aktualisierte Adapterposition enthält.
     *
     * Überschreibe [.onBindViewHolder], wenn der Adapter
     * eine effiziente partielle Bindung verarbeiten kann.
     *
     * @param holder Der ViewHolder, der aktualisiert werden sollte, um den Inhalt des
     * Elements an der gegebenen Position im Datensatz darzustellen.
     * @param position Die Position des Elements im Datensatz des Adapters.
     */
    override fun onBindViewHolder(holder: JokeItemViewHolder, position: Int) {
        Log.v("RV_TAG",
            "onBindViewHolder, position: $position, holder: ${holder.hashCode()}, holder.itemView.hashCode(): ${holder.itemView.hashCode()}")

        val item = dataset[position]
        holder.viewBinding.tvJoke.text = String.format("${item.joke}\n\nlist_item_joke an position: $position")
    }
}