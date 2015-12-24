package ayaseruri.x.twittersearch.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import ayaseruri.x.twittersearch.R;

/**
 * Created by ayaseruri on 15/12/23.
 */
@EViewGroup(R.layout.search_condition_item)
public class SearchConditionItem extends RelativeLayout {

    @ViewById(R.id.search_condition_rb)
    RadioButton radioButton;
    @ViewById(R.id.search_condition_text)
    TextView textView;

    private String text = "";
    private boolean isCheck;
    private boolean clickable = true;
    private IOnSearchConditionItemClick mIOnItemClick;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    public SearchConditionItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SearchConditionItem);
        try{
            text = a.getString(R.styleable.SearchConditionItem_text);
            isCheck = a.getBoolean(R.styleable.SearchConditionItem_isCheck, false);
        }finally {
            a.recycle();
        }
    }

    @AfterViews
    void init(){
        this.setBackgroundResource(R.drawable.item_ripple);
        textView.setText(text);
        radioButton.setChecked(isCheck);
        radioButton.setEnabled(false);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButton.setChecked(true);
                if (null != mIOnItemClick) {
                    mIOnItemClick.onItemClick(SearchConditionItem.this);
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setClickable(boolean isClickable){
        this.clickable = isClickable;
        super.setClickable(clickable);
        String colorStr = "#616161";
        if(!isClickable){
            colorStr = "#BDBDBD";
        }
        textView.setTextColor(Color.parseColor(colorStr));
        setChecked(isCheck);
    }

    public boolean getIsClickable() {
        return clickable;
    }

    public void setItemClick(IOnSearchConditionItemClick itemClick){
        mIOnItemClick = itemClick;
    }

    public interface IOnSearchConditionItemClick{
        void onItemClick(SearchConditionItem searchConditionItem);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener l){
        mOnCheckedChangeListener = l;
        radioButton.setOnCheckedChangeListener(l);
    }

    public void setChecked(boolean check){
        radioButton.setOnCheckedChangeListener(null);
        radioButton.setChecked(check);
        if(null != mOnCheckedChangeListener){
            radioButton.setOnCheckedChangeListener(mOnCheckedChangeListener);
        }
    }
}
