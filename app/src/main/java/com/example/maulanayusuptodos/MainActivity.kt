package com.example.maulanayusuptodos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.maulanayusuptodos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        val navController = navHostFragment.navController
        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back_custom)
        binding.toolbar.setNavigationIconTint(getColor(R.color.black))

        setupActionBarWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.todoListFragment -> {
                    // Di halaman utama, ga ada tombol back
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    supportActionBar?.title = "Maulana Yusup TodoApp"
                }
                else -> {
                    // Di halaman detail, munculkan tombol back custom
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    binding.toolbar.navigationIcon =
                        getDrawable(R.drawable.ic_arrow_back_custom)
                    binding.toolbar.navigationIcon?.setTint(getColor(R.color.black))
                    supportActionBar?.title = "Todo Detail"
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}