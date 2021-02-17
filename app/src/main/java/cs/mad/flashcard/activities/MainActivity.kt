package cs.mad.flashcard.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import cs.mad.flashcard.R
import cs.mad.flashcard.adapters.FlashcardSetAdapter
import cs.mad.flashcard.entities.getHardcodedFlashcardSets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.flashcardSet_View).adapter= FlashcardSetAdapter(
                getHardcodedFlashcardSets(), this)

        findViewById<RecyclerView>(R.id.flashcardSet_View).setOnClickListener {
            startActivity(Intent(this, FlashcardSetDetailActivity::class.java))
        }
    }

    fun onItemClick(position: Int) {
        val intent = Intent(this, FlashcardSetDetailActivity::class.java)
        startActivity(intent)
    }
}