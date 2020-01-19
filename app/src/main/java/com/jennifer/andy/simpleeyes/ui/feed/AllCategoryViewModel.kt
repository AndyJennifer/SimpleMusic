package com.jennifer.andy.simpleeyes.ui.feed

import com.jennifer.andy.base.rx.RxThreadHelper
import com.jennifer.andy.base.viewmodel.AutoDisposeViewModel
import com.jennifer.andy.simpleeyes.base.model.handleInit
import com.jennifer.andy.simpleeyes.net.entity.AndyInfo
import com.jennifer.andy.simpleeyes.net.result.Result
import com.jennifer.andy.simpleeyes.ui.base.ViewState
import com.jennifer.andy.simpleeyes.ui.feed.usecase.FeedUseCase
import com.uber.autodispose.autoDispose
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject


/**
 * Author:  andy.xwt
 * Date:    2020-01-02 21:40
 * Description:
 */

class AllCategoryViewModel(private val feedUseCase: FeedUseCase) : AutoDisposeViewModel() {


    private val mViewStateSubject = BehaviorSubject.createDefault(ViewState.init<AndyInfo>())

    fun observeViewState(): Observable<ViewState<AndyInfo>> = mViewStateSubject.hide().distinctUntilChanged()

    fun loadAllCategoriesInfo() {
        feedUseCase.loadAllCategoriesInfo()
                .startWith(Result.idle())
                .compose(RxThreadHelper.switchFlowableThread())
                .autoDispose(this)
                .subscribe { handleInit(it, mViewStateSubject) }
    }

}