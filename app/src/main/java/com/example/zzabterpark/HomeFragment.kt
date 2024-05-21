import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.CardItem
import com.example.zzabterpark.R

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
            CardItem(R.drawable.sample_image1, "SUMMER VACANCE"),
            CardItem(R.drawable.sample_image2, "MUSIC RESTIVAL")
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
        // 여기서 프래그먼트 전환 또는 액티비티 전환 로직을 구현합니다.
        // 예: fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, TargetFragment())?.commit()
    }

}