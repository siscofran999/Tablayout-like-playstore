package com.siscofran.tabchips

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.Dimension
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = MainPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(OneFragment(), "Fragment One")
        pagerAdapter.addFragment(SecondFragment(), "Fragment Second")
        pagerAdapter.addFragment(ThreeFragment(), "Fragment Three")

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        // request dari mas firdaus
        val tabs = tabLayout.getChildAt(0) as ViewGroup
        val tes = tabs.getChildAt(0)
        val layoutParams = tes.layoutParams as LinearLayout.LayoutParams
        layoutParams.marginStart = dpToPx(resources, resources.getDimension(R.dimen.dimen_30dp)).toInt()
        tes.layoutParams = layoutParams
        tabLayout.requestLayout()
        Log.i("TAG", "onCreate: ${tabs.childCount}")

        val tes2 = tabs.getChildAt(tabs.childCount -1)
        val layoutParams2 = tes2.layoutParams as LinearLayout.LayoutParams
        layoutParams2.marginEnd = dpToPx(resources, resources.getDimension(R.dimen.dimen_30dp)).toInt()
        tes2.layoutParams = layoutParams2
        tabLayout.requestLayout()

        for (i in 0 until tabs.childCount -1) {
            val tab = tabs.getChildAt(i)
            val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
            layoutParams.marginEnd = dpToPx(resources, 8f).toInt()
//            layoutParams.marginStart = dpToPx(resources, 8f).toInt()
            tab.layoutParams = layoutParams
            tabLayout.requestLayout()
        }
    }

    private fun dpToPx(r: Resources, dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, r.displayMetrics
        )
    }
}
