package com.example.lovetest.fragment

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var option = -1
    lateinit var navController: NavController
    lateinit var tv_main: TextView
    lateinit var tv_sub: TextView
    lateinit var homeBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        option = arguments?.getInt("index")?:-1 // arguments?.getInt("index")가 null이면 -1을 반환

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(option, view) // 결과를 세팅해주는 역할

        homeBtn = view.findViewById(R.id.homeBtn)
        homeBtn.setOnClickListener{
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }
    fun setResult(option : Int, view: View){
        when(option){
            1 -> {
                tv_main = view.findViewById(R.id.tv_main)
                tv_main.text = "You are a QUITTER!" // 텍스트를 불러오고 할당함. tv_main.setText("")와 같음.
                tv_sub = view.findViewById(R.id.tv_sub)
                tv_sub.text = "You can let the person easily."
            }
            2 -> {
                tv_main = view.findViewById(R.id.tv_main)
                tv_main.text = "You should focus on yourself"
                tv_sub = view.findViewById(R.id.tv_sub)
                tv_sub.text = "You become really clingy to your ex."
            }
            3 -> {
                tv_main = view.findViewById(R.id.tv_main)
                tv_main.text = "You should take it easy"
                tv_sub = view.findViewById(R.id.tv_sub)
                tv_sub.text = "You can do crazy things no matter what it takes."
            }
            4 -> {
                tv_main = view.findViewById(R.id.tv_main)
                tv_main.text = "You are pretty mature."
                tv_sub = view.findViewById(R.id.tv_sub)
                tv_sub.text = "You can easily accept the break-up."
            }
        }
    }
}