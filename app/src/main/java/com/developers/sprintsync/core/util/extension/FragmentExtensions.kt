package com.developers.sprintsync.core.util.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.developers.sprintsync.R

fun Fragment.findTopNavController(): NavController {
    val topLevelHost =
        requireActivity().supportFragmentManager.findFragmentById(R.id.mainFragmentContainer) as NavHostFragment?
    return topLevelHost?.navController ?: findNavController()
}
