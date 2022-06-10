package com.example.cars.app.presentation.userPosts

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.domain.models.UserPostResponse
import com.example.cars.app.presentation.userPosts.recycler.UserPostsAdapter
import com.example.cars.app.presentation.userPosts.userPost.UserPostItemFragment
import com.example.cars.app.presentation.userPosts.userPost.UserPostItemSharedViewModel
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.mainActivityComponent
import com.example.cars.utils.ext.openFragment
import com.example.cars.utils.sharedPrefs.SharedPreferencesManager
import kotlinx.android.synthetic.main.fragment_user_posts.*
import javax.inject.Inject

class UserPostsFragment : Fragment(R.layout.fragment_user_posts) {

    companion object {
        const val TAG = "UserPostsFragment"
        fun newInstance() = UserPostsFragment()
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    @Inject
    lateinit var userPostItemSharedViewModel: UserPostItemSharedViewModel

    private val userPostsFragmentViewModel by viewModels<UserPostsFragmentViewModel> {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.recycler_user_posts)
    }

    private val adapter by lazy {
        UserPostsAdapter { userPostResponse ->
            openPost(userPostResponse)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().mainActivityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserPosts()
    }

    private fun openPost(userPostResponse: UserPostResponse) {
        userPostItemSharedViewModel.addPostOnInterface(userPostResponse)
        requireActivity().openFragment(
            UserPostItemFragment.newInstance(),
            UserPostItemFragment.TAG,
            R.id.container
        )
    }
    private fun initUserPosts() {
        userPostsFragmentViewModel.getUserPosts(sharedPreferences.getDocumentPath())
        recycler?.adapter = adapter
        userPostsFragmentViewModel.userPosts.observe(viewLifecycleOwner) { userPosts ->
            progressUserPosts.visibility = ProgressBar.INVISIBLE
            adapter.setItems(userPosts)
        }
    }
}