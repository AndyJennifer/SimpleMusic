package com.jennifer.andy.simpleeyes.ui.common

import android.view.View
import com.jennifer.andy.simpleeyes.entity.AndyInfo
import com.jennifer.andy.simpleeyes.ui.base.presenter.LoadMorePresenter
import com.uber.autodispose.autoDispose


/**
 * Author:  andy.xwt
 * Date:    2019-08-26 19:51
 * Description:
 */

class CommonPresenter : LoadMorePresenter<AndyInfo, CommonModel, CommonView>() {


    override var mBaseModel = CommonModel()
    /**
     * 获取专题信息
     */
    fun loadDataInfoFromUrl(url: String?) {
        mBaseModel.getDataInfoFromUrl(url).autoDispose(mScopeProvider).subscribe({
            mView?.showLoadSuccess(it.itemList)
            mNextPageUrl = it.nextPageUrl
        }, {
            mView?.showNetError(View.OnClickListener { loadDataInfoFromUrl(url) })
        })
    }
}