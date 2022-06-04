package com.t4zb.gboytranslate.ui.fragment

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.t4zb.gboytranslate.R
import com.t4zb.gboytranslate.core.modellayer.rest.service.event.TextModel
import com.t4zb.gboytranslate.core.modellayer.rest.service.repo.TranslateRepository
import com.t4zb.gboytranslate.databinding.FragmentTranslateBinding
import com.t4zb.gboytranslate.ui.Contract.BaseContract
import com.t4zb.gboytranslate.utils.showLogDebug
import com.t4zb.gboytranslate.utils.showSnack


class TranslateFragment : BaseFragment(R.layout.fragment_translate), BaseContract.ViewMain {

    private lateinit var mBinding: FragmentTranslateBinding
    private lateinit var mContext: FragmentActivity
   // private lateinit var mSharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = FragmentTranslateBinding.bind(view)



        mBinding.translatebtn.setOnClickListener {

            var text = mBinding.translateEditText.text
            if (text.isNullOrEmpty()){
                showSnack(view,"çeviri cümlenizi yazınız")
            }else{
                var model = TextModel(text.toString())
                var dataRepo = activity?.let { it1 -> TranslateRepository(it1.application,model) }

                dataRepo?.let { it1 ->
                    showLogDebug(TAG, it1.resultData.toString())
                    it1.resultData.observe(viewLifecycleOwner,{data ->
                        mBinding.resultTextView.text = data.result
                    })

                }
            }

        }

    }

    companion object {
      const val TAG = "TRANSLATEFRAGMENT"
    }

    override fun setupViewModel() {

    }

    override fun initializeViews() {

    }
}