package ayaseruri.x.twittersearch.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
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
    private boolean isCheck = false;
    private IOnSearchConditionItemClick mIOnItemClick;

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

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButton.setChecked(!radioButton.isChecked());
                if (null != mIOnItemClick) {
                    mIOnItemClick.onItemClick();
                }
            }
        });

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(null != mIOnItemClick){
                    mIOnItemClick.onItemClick();
                }
            }
        });
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setItemClick(IOnSearchConditionItemClick itemClick){
        mIOnItemClick = itemClick;
    }

    public interface IOnSearchConditionItemClick{
        void onItemClick();
    }
}
