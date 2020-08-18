package com.tiger.zwy.adapter

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tiger.zwy.R
import com.tiger.zwy.bean.CommentDetailBean
import com.tiger.zwy.bean.ReplyDetailBean
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*
import kotlin.collections.ArrayList

/**
 * Author: Moos
 * E-mail: moosphon@gmail.com
 * Date:  18/4/20.
 * Desc: 评论与回复列表的适配器
 */
class CommentExpandAdapter(private val context: Context, private val commentBeanList: MutableList<CommentDetailBean>) : BaseExpandableListAdapter() {
    private val replyBeanList: List<ReplyDetailBean>? = null
    private val pageIndex = 1
    override fun getGroupCount(): Int {
        return commentBeanList.size
    }

    override fun getChildrenCount(i: Int): Int {
        return if (commentBeanList[i].replyList == null) {
            0
        } else {
            if (commentBeanList[i].replyList!!.size > 0) commentBeanList[i].replyList!!.size else 0
        }
    }

    override fun getGroup(i: Int): Any {
        return commentBeanList[i]
    }

    override fun getChild(i: Int, i1: Int): Any {
        return commentBeanList[i].replyList!![i1]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return getCombinedChildId(groupPosition.toLong(), childPosition.toLong())
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    var isLike = false
    override fun getGroupView(groupPosition: Int, isExpand: Boolean, convertView: View, viewGroup: ViewGroup): View {
        var convertView = convertView
        val groupHolder: GroupHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item_layout, viewGroup, false)
            groupHolder = GroupHolder(convertView)
            convertView.tag = groupHolder
        } else {
            groupHolder = convertView.tag as GroupHolder
        }
//        Glide.with(context).load(R.drawable.user_other)
//                .diskCacheStrategy(DiskCacheStrategy.RESULT)
//                .error(R.mipmap.ic_launcher)
//                .centerCrop()
//                .into(groupHolder.logo)
        groupHolder.tv_name.text = commentBeanList[groupPosition].nickName
        groupHolder.tv_time.text = commentBeanList[groupPosition].createDate
        groupHolder.tv_content.text = commentBeanList[groupPosition].content
        groupHolder.iv_like.setOnClickListener {
            if (isLike) {
                isLike = false
                groupHolder.iv_like.setColorFilter(Color.parseColor("#aaaaaa"))
            } else {
                isLike = true
                groupHolder.iv_like.setColorFilter(Color.parseColor("#FF5C5C"))
            }
        }
        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, b: Boolean, convertView: View, viewGroup: ViewGroup): View {
        var convertView = convertView
        val childHolder: ChildHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout, viewGroup, false)
            childHolder = ChildHolder(convertView)
            convertView.tag = childHolder
        } else {
            childHolder = convertView.tag as ChildHolder
        }
        val replyUser = commentBeanList[groupPosition].replyList!![childPosition].nickName
        if (!TextUtils.isEmpty(replyUser)) {
            childHolder.tv_name.text = "$replyUser:"
        } else {
            childHolder.tv_name.text = "无名" + ":"
        }
        childHolder.tv_content.text = commentBeanList[groupPosition].replyList!![childPosition].content
        return convertView
    }

    override fun isChildSelectable(i: Int, i1: Int): Boolean {
        return true
    }

    private inner class GroupHolder(view: View) {
        val logo: CircleImageView
        val tv_name: TextView
        val tv_content: TextView
        val tv_time: TextView
        val iv_like: ImageView

        init {
            logo = view.findViewById<View>(R.id.comment_item_logo) as CircleImageView
            tv_content = view.findViewById<View>(R.id.comment_item_content) as TextView
            tv_name = view.findViewById<View>(R.id.comment_item_userName) as TextView
            tv_time = view.findViewById<View>(R.id.comment_item_time) as TextView
            iv_like = view.findViewById<View>(R.id.comment_item_like) as ImageView
        }
    }

    private inner class ChildHolder(view: View) {
        val tv_name: TextView
        val tv_content: TextView

        init {
            tv_name = view.findViewById<View>(R.id.reply_item_user) as TextView
            tv_content = view.findViewById<View>(R.id.reply_item_content) as TextView
        }
    }

    /**
     * by moos on 2018/04/20
     * func:评论成功后插入一条数据
     * @param commentDetailBean 新的评论数据
     */
    fun addTheCommentData(commentDetailBean: CommentDetailBean?) {
        if (commentDetailBean != null) {
            commentBeanList.add(commentDetailBean)
            notifyDataSetChanged()
        } else {
            throw IllegalArgumentException("评论数据为空!")
        }
    }

    /**
     * by moos on 2018/04/20
     * func:回复成功后插入一条数据
     * @param replyDetailBean 新的回复数据
     */
    fun addTheReplyData(replyDetailBean: ReplyDetailBean?, groupPosition: Int) {
        if (replyDetailBean != null) {
            Log.e(TAG, "addTheReplyData: >>>>该刷新回复列表了:$replyDetailBean")
            if (commentBeanList[groupPosition].replyList != null) {
                commentBeanList[groupPosition].replyList?.add(replyDetailBean)
            } else {
                val replyList= ArrayList<ReplyDetailBean>()
                replyList.add(replyDetailBean)
                commentBeanList[groupPosition].replyList = replyList
            }
            notifyDataSetChanged()
        } else {
            throw IllegalArgumentException("回复数据为空!")
        }
    }

    /**
     * by moos on 2018/04/20
     * func:添加和展示所有回复
     * @param replyBeanList 所有回复数据
     * @param groupPosition 当前的评论
     */
    private fun addReplyList(replyBeanList: ArrayList<ReplyDetailBean>, groupPosition: Int) {
        if (commentBeanList[groupPosition].replyList != null) {
            commentBeanList[groupPosition].replyList?.clear()
            commentBeanList[groupPosition].replyList?.addAll(replyBeanList)
        } else {
            commentBeanList[groupPosition].replyList = replyBeanList
        }
        notifyDataSetChanged()
    }

    companion object {
        private const val TAG = "CommentExpandAdapter"
    }

}