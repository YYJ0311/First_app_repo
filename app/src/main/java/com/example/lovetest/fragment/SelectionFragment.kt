package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController
    lateinit var btnBack : ImageView
    lateinit var option_1 : TextView
    lateinit var option_2 : TextView
    lateinit var option_3 : TextView
    lateinit var option_4 : TextView

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
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnBack = view.findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)

        option_1 = view.findViewById(R.id.option_1)
        option_1.setOnClickListener(this)
        option_2 = view.findViewById(R.id.option_2)
        option_2.setOnClickListener(this)
        option_3 = view.findViewById(R.id.option_3)
        option_3.setOnClickListener(this)
        option_4 = view.findViewById(R.id.option_4)
        option_4.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){ // id를 불러오기 위해서 view는 null이 되면 안 됨. 따라서 ?를 붙여준다.
            // view가 null이 아니라면 id를 가져오고, null이라면 null을 반환함
            R.id.option_1 -> {navigateWithIndex(1)}
            R.id.option_2 -> {navigateWithIndex(2)}
            R.id.option_3 -> {navigateWithIndex(3)}
            R.id.option_4 -> {navigateWithIndex(4)}
            R.id.btn_back -> {
                navController.popBackStack()
            }
            /*
                fragment는 이동을 할 때 항상 Back stack에 쌓이게 됨
                fragment A->B->C 순서로 이동했다면 Back stack의 아래에서부터 차례대로 쌓이게 됨
                이 상태에서 뒤로가기를 누르면 가장 위에 있는 것부터 다시 불러와지는 것임
            */
        }
    }

    fun navigateWithIndex(index : Int){ // option 별로 이동되는 페이지를 정의하는 함수
        val bundle = bundleOf("index" to index) // 파라미터로 받은 index를 "index"라는 key 안에 넣을 것임. 뒤에 index는 value
        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }
}