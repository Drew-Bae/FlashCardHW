package cs.mad.flashcard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.mad.flashcard.R
import cs.mad.flashcard.activities.FlashcardSetDetailActivity
import cs.mad.flashcard.entities.Flashcard


class FlashcardAdapter (val dataSet: List<Flashcard>, val listener: FlashcardSetDetailActivity):
    RecyclerView.Adapter<FlashcardAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textView: TextView
        val textView1: TextView

        init {
            textView = view.findViewById(R.id.text_view_2)
            textView1 = view.findViewById(R.id.text_view_1)
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_flashcard, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView1.text = dataSet[position].question
        viewHolder.textView.text = dataSet[position].answer
    }

    override fun getItemCount()= dataSet.size
}
