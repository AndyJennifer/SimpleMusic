package com.jennifer.andy.simpleeyes.ui.feed.presenter

import android.view.View
import com.jennifer.andy.simpleeyes.ui.base.presenter.BasePresenter
import com.jennifer.andy.simpleeyes.ui.feed.model.FeedModel
import com.jennifer.andy.simpleeyes.ui.feed.view.CategoryTabView
import com.uber.autodispose.autoDispose


/**
 * Author:  andy.xwt
 * Date:    2018/8/6 10:48
 * Description:
 */

class CategoryTabPresenter : BasePresenter<CategoryTabView>() {

    private var mFeedModel: FeedModel = FeedModel()

    fun getTabInfo(id: String) {
        mFeedModel.getCategoryTabIno(id).autoDispose(mScopeProvider).subscribe({
            mView?.showContent()
            mView?.showLoadTabSuccess(it)
        }, {
            mView?.showNetError(View.OnClickListener { getTabInfo(id) })
        })
    }
}