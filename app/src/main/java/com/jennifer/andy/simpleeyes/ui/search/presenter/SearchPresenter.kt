package com.jennifer.andy.simpleeyes.ui.search.presenter


import android.view.View
import com.jennifer.andy.simpleeyes.entity.AndyInfo
import com.jennifer.andy.simpleeyes.ui.base.presenter.LoadMorePresenter
import com.jennifer.andy.simpleeyes.ui.home.model.HomeModel
import com.jennifer.andy.simpleeyes.ui.search.view.SearchHotView
import com.uber.autodispose.autoDispose


/**
 * Author:  andy.xwt
 * Date:    2018/4/3 11:05
 * Description:
 */

class SearchPresenter : LoadMorePresenter<AndyInfo, HomeModel, SearchHotView>() {

    override var mBaseModel: HomeModel = HomeModel()

    /**
     * 获取热门搜索
     */
    fun searchHot() {
        mBaseModel.getHotWord().autoDispose(mScopeProvider).subscribe {
            mView?.getHotWordSuccess(it)
        }
    }

    /**
     * 根据关键字搜索
     */
    fun searchVideoByWord(word: String) {
        mView?.showLoading()
        mBaseModel.searchVideoByWord(word).autoDispose(mScopeProvider).subscribe({
            mView?.showContent()
            mView?.showSearchSuccess(word, it)
            mNextPageUrl = it.nextPageUrl
        }, {
            mView?.showNetError(View.OnClickListener { searchVideoByWord(word) })
        })
    }


}