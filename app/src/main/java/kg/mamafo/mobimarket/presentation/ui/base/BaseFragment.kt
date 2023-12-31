package kg.mamafo.mobimarket.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(private val viewBinding: (LayoutInflater, ViewGroup?, Boolean) -> VB) :
    Fragment() {

    private var _vb: VB? = null
    val vb get() = _vb!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _vb = viewBinding.invoke(inflater, container, false)

        setUpUI()
        setData()
        checkInternet()
        return vb.root
    }

    abstract fun setUpUI()
    protected open fun setData() {}
    protected open fun checkInternet() {}

    protected open fun navigateUp() {
        findNavController().navigateUp()
    }

    protected open fun navigate(resID: Int, bundle: Bundle? = null) {
        if (bundle == null)
            findNavController().navigate(resID)
        else
            findNavController().navigate(resID, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _vb = null
    }
}