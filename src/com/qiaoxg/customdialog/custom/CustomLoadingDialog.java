package com.qiaoxg.customdialog.custom;

import com.qiaoxg.customdialog.R;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomLoadingDialog extends Dialog {

    private Context mContext;
    private static Dialog mDialog;
    private static TextView msgTextView;
    private boolean mIsCancelBack = true;//榛樿鐐瑰嚮鎵嬫満杩斿洖鎸夐挳娑堝け
    private boolean mIsCancelOutSide = false;//榛樿鐐瑰嚮dialog澶栭潰涓嶆秷澶�

    public CustomLoadingDialog(Context context) {
        super(context);
        this.mContext = context;
        mDialog = createDialog();
    }

    /**
     *鍒涘缓dialog
     * @return
     */
    public Dialog createDialog() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.dialog_loading, null);// 寰楀埌鍔犺浇view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_loading_view);// 鍔犺浇甯冨眬

        msgTextView = (TextView) v.findViewById(R.id.tipTextView);// 鎻愮ず鏂囧瓧View
        msgTextView.setText("");// 璁剧疆鍔犺浇淇℃伅

        mDialog = new Dialog(mContext, R.style.CustomLoadingDialogStyle);// 鍒涘缓鑷畾涔夋牱寮廳ialog
        mDialog.setCancelable(mIsCancelBack); // 鏄惁鍙互鎸夆�滆繑鍥為敭鈥濇秷澶�
        mDialog.setCanceledOnTouchOutside(mIsCancelOutSide); // 鐐瑰嚮鍔犺浇妗嗕互澶栫殑鍖哄煙
        mDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 璁剧疆甯冨眬
        /**
         *灏嗘樉绀篋ialog鐨勬柟娉曞皝瑁呭湪杩欓噷闈�
         */
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.PopWindowAnimStyle);

        return mDialog;
    }

    /**
     * 璁剧疆鎻愮ず淇℃伅
     *
     * @param msgStr
     */
    public static void setMessage(String msgStr) {
        if (mDialog != null && msgTextView != null) {
            msgTextView.setText(msgStr);
        }
    }

    /**
     * 璁剧疆鐐瑰嚮dialog澶栭潰鏄惁娑堝け
     *
     * @param isCancel
     */
    public static void setCancelOnClickOutSide(boolean isCancel) {
        if (mDialog != null) {
            mDialog.setCanceledOnTouchOutside(isCancel);
        }
    }

    /**
     * 璁剧疆鐐瑰嚮鎵嬫満鐨勮繑鍥炴寜閽槸鍚︽秷澶�
     *
     * @param isCancel
     */
    public static void setCancelableOnClickBackBtn(boolean isCancel) {
        if (mDialog != null) {
            mDialog.setCancelable(isCancel);
        }
    }

    /**
     * 鏄剧ずdialog
     */
    public static void showDialog() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    /**
     * 鍏抽棴dialog
     */
    public static void closeDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }
}