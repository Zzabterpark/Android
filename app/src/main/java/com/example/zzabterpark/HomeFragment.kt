import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.CardItem
import com.example.zzabterpark.ClassicActivity
import com.example.zzabterpark.ConcertActivity
import com.example.zzabterpark.MusicalActivity
import com.example.zzabterpark.R
import com.example.zzabterpark.SportsActivity
import com.example.zzabterpark.TheaterActivity

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var cardAdapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
            val lp = recyclerView.layoutParams
            lp.width = RecyclerView.LayoutParams.MATCH_PARENT
            recyclerView.layoutParams = lp
        }

        val cardItems = listOf(
            CardItem(R.drawable.card_image1),
            CardItem(R.drawable.card_image2),
            CardItem(R.drawable.card_image3),
            CardItem(R.drawable.card_image4),
            CardItem(R.drawable.card_image5)
        )

        cardAdapter = CardAdapter(cardItems)
        recyclerView.adapter = cardAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageView>(R.id.imageMusical).setOnClickListener {
            navigateToCategory("Musical")
        }
        view.findViewById<ImageView>(R.id.imageConcert).setOnClickListener {
            navigateToCategory("Concert")
        }
        view.findViewById<ImageView>(R.id.imageSports).setOnClickListener {
            navigateToCategory("Sports")
        }
        view.findViewById<ImageView>(R.id.imageClassic).setOnClickListener {
            navigateToCategory("Classic")
        }
        view.findViewById<ImageView>(R.id.imageTheater).setOnClickListener {
            navigateToCategory("Theater")
        }
    }

    private fun navigateToCategory(category: String) {
        when (category) {
            "Musical" -> startActivity(Intent(context, MusicalActivity::class.java))
            "Concert" -> startActivity(Intent(context, ConcertActivity::class.java))
            "Sports" -> startActivity(Intent(context, SportsActivity::class.java))
            "Classic" -> startActivity(Intent(context, ClassicActivity::class.java))
            "Theater" -> startActivity(Intent(context, TheaterActivity::class.java))
        }
    }
}