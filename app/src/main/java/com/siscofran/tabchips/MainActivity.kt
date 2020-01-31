package com.siscofran.tabchips

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val tabs = tabLayout.getChildAt(0) as ViewGroup
        for (i in 0 until tabs.childCount - 1) {
            val tab = tabs.getChildAt(i)
            val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
            layoutParams.marginEnd = dpToPx(resources, 8f).toInt()
            layoutParams.marginStart = dpToPx(resources, 8f).toInt()
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
