import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zzabterpark.R
import com.example.zzabterpark.RankingFragment

class CategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        // 각 버튼에 클릭 리스너를 설정하여 RankingFragment로 이동
        val btnRanking: Button = view.findViewById(R.id.ranking_btn)
        btnRanking.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, RankingFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}
