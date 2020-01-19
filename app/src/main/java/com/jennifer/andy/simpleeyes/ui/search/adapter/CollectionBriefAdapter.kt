package com.jennifer.andy.simpleeyes.ui.search.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.facebook.drawee.view.SimpleDraweeView
import com.jennifer.andy.base.utils.getElapseTimeForShow
import com.jennifer.andy.simpleeyes.R
import com.jennifer.andy.simpleeyes.net.entity.Content


/**
 * Author:  andy.xwt
 * Date:    2018/4/9 11:01
 * Description:
 */

class CollectionBriefAdapter(data: MutableList<Content>) : BaseQuickAdapter<Content, BaseViewHolder>(R.layout.item_collection_brief, data) {

    override fun convert(helper: BaseViewHolder, item: Content) {

        with(helper) {
            getView<SimpleDraweeView>(R.id.iv_image).setImageURI(item.data.cover.feed)
            setText(R.id.tv_title, item.data.title)
            val description = "#${item.data.category}   /   ${getElapseTimeForShow(item.data.duration)}"
            setText(R.id.tv_desc, description)
        }
    }
}