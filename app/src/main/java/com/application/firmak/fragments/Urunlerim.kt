package com.application.firmak

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.layout_child.view.*
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.urunlerim.*
import com.application.firmak.adapters.ProductRecyclerViewAdapter
import com.application.firmak.adapters.TeslimEdilecekProductRecyclerViewAdapter
import com.application.firmak.models.ProductItem


class Urunlerim: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: ProductRecyclerViewAdapter? = null

    private var teslimEdilecekproductArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var teslimEdilecekproductAdapter: TeslimEdilecekProductRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.urunlerim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initProductRecycleView()

        initExpandableLayouts()
    }

    private fun initExpandableLayouts() {
        teslimedilecekexp.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {
                view.imageView12.setImageResource(if (isExpanded) R.mipmap.ic_launcher else R.mipmap.ic_launcher)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                val item1 = ProductItem("Estone 300", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "1X129,00 TL", R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                val item2 = ProductItem("Rokon", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "1X65,00 TL", R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                teslimEdilecekproductArray.clear()
                teslimEdilecekproductArray.add(item1)
                teslimEdilecekproductArray.add(item2)

                view.teslimedilecek.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                teslimEdilecekproductAdapter = TeslimEdilecekProductRecyclerViewAdapter(teslimEdilecekproductArray, requireContext())
                val gridLayoutManager = GridLayoutManager(requireContext(), 1)
                view.teslimedilecek.layoutManager = gridLayoutManager
                view.teslimedilecek.adapter = teslimEdilecekproductAdapter
            }
        })

        val teslimatsection = Section<String, String>()
        val teslimatparent = ""
        val teslimatchild = ""

        teslimatsection.parent = teslimatparent
        teslimatsection.children.add(teslimatchild)
        teslimatsection.expanded = true
        teslimedilecekexp.addSection(teslimatsection)


    }

    private fun initProductRecycleView() {

        val item1 = ProductItem("V Yaka Uzun Elbise", "18YOX-POLASBISE", "1X129,00 TL", R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("V Yaka Gömlek", "18YOX-POLASBISE", "1X65,00 TL", R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)

        product!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = ProductRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        product!!.layoutManager = gridLayoutManager
        product!!.adapter = productAdapter

    }


}