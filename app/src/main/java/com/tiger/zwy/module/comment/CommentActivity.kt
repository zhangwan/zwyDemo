package com.tiger.zwy.module.comment

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ExpandableListView.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tiger.zwy.R
import com.tiger.zwy.adapter.CommentExpandAdapter
import com.tiger.zwy.bean.CommentDetailBean
import com.tiger.zwy.bean.ReplyDetailBean
import kotlinx.android.synthetic.main.activity_comment.*

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
class CommentActivity :AppCompatActivity(), View.OnClickListener{
    var dialog:BottomSheetDialog?=null
    var adapter: CommentExpandAdapter?=null
    var commentsList= arrayListOf<CommentDetailBean>()
    var testJson= "{\n" +
            "\t\"code\": 1000,\n" +
            "\t\"message\": \"查看评论成功\",\n" +
            "\t\"data\": {\n" +
            "\t\t\"total\": 3,\n" +
            "\t\t\"list\": [{\n" +
            "\t\t\t\t\"id\": 42,\n" +
            "\t\t\t\t\"nickName\": \"程序猿\",\n" +
            "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
            "\t\t\t\t\"content\": \"时间是一切财富中最宝贵的财富。\",\n" +
            "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
            "\t\t\t\t\"replyTotal\": 1,\n" +
            "\t\t\t\t\"createDate\": \"三分钟前\",\n" +
            "\t\t\t\t\"replyList\": [{\n" +
            "\t\t\t\t\t\"nickName\": \"沐風\",\n" +
            "\t\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
            "\t\t\t\t\t\"id\": 40,\n" +
            "\t\t\t\t\t\"commentId\": \"42\",\n" +
            "\t\t\t\t\t\"content\": \"时间总是在不经意中擦肩而过,不留一点痕迹.\",\n" +
            "\t\t\t\t\t\"status\": \"01\",\n" +
            "\t\t\t\t\t\"createDate\": \"一个小时前\"\n" +
            "\t\t\t\t}]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"id\": 41,\n" +
            "\t\t\t\t\"nickName\": \"设计狗\",\n" +
            "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
            "\t\t\t\t\"content\": \"这世界要是没有爱情，它在我们心中还会有什么意义！这就如一盏没有亮光的走马灯。\",\n" +
            "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
            "\t\t\t\t\"replyTotal\": 1,\n" +
            "\t\t\t\t\"createDate\": \"一天前\",\n" +
            "\t\t\t\t\"replyList\": [{\n" +
            "\t\t\t\t\t\"nickName\": \"沐風\",\n" +
            "\t\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
            "\t\t\t\t\t\"commentId\": \"41\",\n" +
            "\t\t\t\t\t\"content\": \"时间总是在不经意中擦肩而过,不留一点痕迹.\",\n" +
            "\t\t\t\t\t\"status\": \"01\",\n" +
            "\t\t\t\t\t\"createDate\": \"三小时前\"\n" +
            "\t\t\t\t}]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"id\": 40,\n" +
            "\t\t\t\t\"nickName\": \"产品喵\",\n" +
            "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
            "\t\t\t\t\"content\": \"笨蛋自以为聪明，聪明人才知道自己是笨蛋。\",\n" +
            "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
            "\t\t\t\t\"replyTotal\": 0,\n" +
            "\t\t\t\t\"createDate\": \"三天前\",\n" +
            "\t\t\t\t\"replyList\": []\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}\n" +
            "}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        initView()
        initListener()
    }
    fun initView(){

        val collapsingToolbar=collapsing_toolbar as CollapsingToolbarLayout
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar.title = "详情"
        initExpandableListView(commentsList)
    }
    fun initListener(){
        detail_page_do_comment.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.detail_page_do_comment->{
                showCommentDialog()
            }
        }
    }

    /**
     * 初始化评论和回复列表
     */
    private fun initExpandableListView(commentList: ArrayList<CommentDetailBean>) {
        detail_page_lv_comment.setGroupIndicator(null)
        //默认展开所有回复
        adapter = CommentExpandAdapter(this, commentList)
        detail_page_lv_comment.setAdapter(adapter)
        for (i in commentList.indices) {
            detail_page_lv_comment.expandGroup(i)
        }
        detail_page_lv_comment.setOnGroupClickListener(OnGroupClickListener { expandableListView, view, groupPosition, l ->
            val isExpanded = expandableListView.isGroupExpanded(groupPosition)
            Log.e("CommentActivity", "onGroupClick: 当前的评论id>>>" + commentList[groupPosition]?.id)
            //                if(isExpanded){
//                    expandableListView.collapseGroup(groupPosition);
//                }else {
//                    expandableListView.expandGroup(groupPosition, true);
//                }
            showReplyDialog(groupPosition)
            true
        })
        detail_page_lv_comment.setOnChildClickListener(OnChildClickListener { expandableListView, view, groupPosition, childPosition, l ->
            Toast.makeText(this, "点击了回复", Toast.LENGTH_SHORT).show()
            false
        })
        detail_page_lv_comment.setOnGroupExpandListener(OnGroupExpandListener {
            //toast("展开第"+groupPosition+"个分组");
        })
    }
    /**
     * 弹出评论框
     */
    private  fun showCommentDialog() {
        dialog = BottomSheetDialog(this)
        val commentView: View = LayoutInflater.from(this).inflate(R.layout.comment_dialog_layout, null)
        val commentText = commentView.findViewById<View>(R.id.dialog_comment_et) as EditText
        val bt_comment = commentView.findViewById<View>(R.id.dialog_comment_bt) as Button
        dialog?.setContentView(commentView)
        /**
         * 解决bsd显示不全的情况
         */
        val parent = commentView.parent as View
        val behavior = BottomSheetBehavior.from(parent)
        commentView.measure(0, 0)
        behavior.setPeekHeight(commentView.measuredHeight)
        bt_comment.setOnClickListener {
            val commentContent = commentText.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(commentContent)) { //commentOnWork(commentContent);
                dialog?.dismiss()
                val detailBean = CommentDetailBean("小明", commentContent, "刚刚")
                adapter?.addTheCommentData(detailBean)
                Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "评论内容不能为空", Toast.LENGTH_SHORT).show()
            }
        }
        commentText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!TextUtils.isEmpty(charSequence) && charSequence.length > 2) {
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"))
                } else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"))
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        dialog?.show()
    }

    /**
     * by moos on 2018/04/20
     * func:弹出回复框
     */
    private fun showReplyDialog(position: Int) {
        dialog = BottomSheetDialog(this)
        val commentView = LayoutInflater.from(this).inflate(R.layout.comment_dialog_layout, null)
        val commentText = commentView.findViewById<View>(R.id.dialog_comment_et) as EditText
        val bt_comment = commentView.findViewById<View>(R.id.dialog_comment_bt) as Button
        commentText.hint = "回复 " + commentsList.get(position).nickName.toString() + " 的评论:"
        dialog!!.setContentView(commentView)
        bt_comment.setOnClickListener {
            val replyContent = commentText.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(replyContent)) {
                dialog!!.dismiss()
                val detailBean = ReplyDetailBean("小红", replyContent)
                adapter!!.addTheReplyData(detailBean, position)
                detail_page_lv_comment.expandGroup(position)
                Toast.makeText(this, "回复成功", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "回复内容不能为空", Toast.LENGTH_SHORT).show()
            }
        }
        commentText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!TextUtils.isEmpty(charSequence) && charSequence.length > 2) {
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"))
                } else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"))
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        dialog!!.show()
    }


}