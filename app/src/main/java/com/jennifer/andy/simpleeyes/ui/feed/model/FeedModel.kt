package com.jennifer.andy.simpleeyes.ui.feed.model

import com.jennifer.andy.simpleeyes.entity.AndyInfo
import com.jennifer.andy.simpleeyes.entity.Category
import com.jennifer.andy.simpleeyes.entity.Tab
import com.jennifer.andy.simpleeyes.net.Api
import com.jennifer.andy.simpleeyes.rx.RxThreadHelper
import com.jennifer.andy.simpleeyes.rx.error.globalHandleError
import com.jennifer.andy.simpleeyes.ui.base.model.BaseModel
import io.reactivex.Observable


/**
 * Author:  andy.xwt
 * Date:    2017/9/22 13:52
 * Description:
 */

class FeedModel : BaseModel {

    /**
     * 获取发现tab栏
     */
    fun getDiscoveryTab(): Observable<Tab> =
            Api.getDefault()
                    .getDiscoveryTab()
                    .compose(globalHandleError())
                    .compose(RxThreadHelper.switchObservableThread())

    /**
     * 获取全部分类信息
     */
    fun loadAllCategoriesInfo(): Observable<AndyInfo> =
            Api.getDefault()
                    .getAllCategoriesInfo()
                    .compose(globalHandleError())
                    .compose(RxThreadHelper.switchObservableThread())

    /**
     * 获取排行榜tab栏
     */
    fun getRankListTab(): Observable<Tab> =
            Api.getDefault()
                    .getRankListTab()
                    .compose(globalHandleError())
                    .compose(RxThreadHelper.switchObservableThread())

    /**
     * 获取专题信息
     */
    fun getTopicInfo(): Observable<AndyInfo> =
            Api.getDefault()
                    .getTopicInfo()
                    .compose(globalHandleError())
                    .compose(RxThreadHelper.switchObservableThread())


    /**
     * 获取种类下tab信息
     */
    fun getCategoryTabIno(id: String): Observable<Category> =
            Api.getDefault()
                    .getCategoryTabInfo(id)
                    .compose(globalHandleError())
                    .compose(RxThreadHelper.switchObservableThread())
}