package cs.mad.flashcard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.mad.flashcard.R
import cs.mad.flashcard.activities.MainActivity
import cs.mad.flashcard.entities.FlashcardSet

class FlashcardSetAdapter(val dataSet: List<FlashcardSet>, val listener: MainActivity) :
    RecyclerView.Adapter<FlashcardSetAdapter.ViewHolder>() {
    // need to get and store a reference to the data set

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val textView: TextView

        init {
            textView = view.findViewById(R.id.textView2)
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
        // store view references as properties using findViewById on view
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        /*
            this is written for you but understand what is happening here
            the layout for an individual item is being inflated
            the inflated layout is passed to view holder for storage

            THE ITEM LAYOUT STILL NEEDS TO BE SETUP IN THE LAYOUT EDITOR
         */
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_flashcard_set, viewGroup, false))
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].title
        /*
            fill the contents of the view using references in view holder and current position in data set

            to launch FlashcardSetDetailActivity ->
            viewHolder.itemView.context.startActivity(Intent(viewHolder.itemView.context, FlashcardSetDetailActivity::class.java))
         */
    }

    override fun getItemCount()= dataSet.size
        // return the size of the data set

}
