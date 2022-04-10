package com.example.cars.app.presentation.userPosts

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.presentation.userPosts.recycler.UserPostsAdapter
import com.example.cars.utils.ext.appComponent
import kotlinx.android.synthetic.main.fragment_user_posts.*

class UserPostsFragment : Fragment(R.layout.fragment_user_posts) {

    companion object {
        const val TAG = "UserPostsFragment"
        fun newInstance() = UserPostsFragment()
    }

    private val userPostsFragmentViewModel by viewModels<UserPostsFragmentViewModel> {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.recycler_user_posts)
    }

    private val adapter by lazy {
        UserPostsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserPosts()
    }

    private fun initUserPosts() {
        recycler?.adapter = adapter
        userPostsFragmentViewModel.userPosts.observe(viewLifecycleOwner) { userPosts ->
            progressUserPosts.visibility = ProgressBar.INVISIBLE
            adapter.setItems(userPosts)
        }
    }
}