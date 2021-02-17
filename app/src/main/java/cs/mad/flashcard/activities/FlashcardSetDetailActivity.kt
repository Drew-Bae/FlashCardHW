package cs.mad.flashcard.activities

import android.content.Intent
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.RecyclerView
import cs.mad.flashcard.R
import cs.mad.flashcard.adapters.FlashcardAdapter
import cs.mad.flashcard.entities.Flashcard
import cs.mad.flashcard.entities.getHardcodedFlashcards
import kotlin.random.Random

class FlashcardSetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard_set_detail)

        findViewById<RecyclerView>(R.id.Flashcard_View).adapter=FlashcardAdapter(
                getHardcodedFlashcards(), this
        )
        findViewById<Button>(R.id.button1).setOnClickListener {
            startActivity(Intent(this, StudySetActivity::class.java))
        }
    }

    fun insertFlashcard(view: View) {
        val index = Random.nextInt(8)
        val newItem = Flashcard(
            question = "Term1",
            answer = "Def 1"
        )
    }

    fun deleteFlashcard(view: View) {

    }

    fun onItemClick(position: Int) {
        val intent = Intent(this, StudySetActivity::class.java)
        startActivity(intent)
    }
    }


