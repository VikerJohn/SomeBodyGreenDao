package com.zwei.somebodygreendao;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/6/15.
 */
public class MyEmojiconEditText extends EditText {
    private int mEmojiconSize;
    private int mEmojiconTextSize;
    private boolean mUseSystemDefault = false;

    public MyEmojiconEditText(Context context) {
        super(context);
        mEmojiconSize = (int) getTextSize();
        mEmojiconTextSize = (int) getTextSize();
    }

    public MyEmojiconEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyEmojiconEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, com.rockerhieu.emojicon.R.styleable.Emojicon);
        mEmojiconSize = (int) a.getDimension(com.rockerhieu.emojicon.R.styleable.Emojicon_emojiconSize, getTextSize());
        mUseSystemDefault = a.getBoolean(com.rockerhieu.emojicon.R.styleable.Emojicon_emojiconUseSystemDefault, false);
        a.recycle();
        mEmojiconTextSize = (int) getTextSize();
        setText(getText());
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        updateText();
    }

    /**
     * Set the size of emojicon in pixels.
     */
    public void setEmojiconSize(int pixels) {
        mEmojiconSize = pixels;

        updateText();
    }

    private void updateText() {
        EmojiconHandler.addEmojis(getContext(), getText(), mEmojiconSize, mEmojiconTextSize, mUseSystemDefault);
    }

    /**
     * Set whether to use system default emojicon
     */
    public void setUseSystemDefault(boolean useSystemDefault) {
        mUseSystemDefault = useSystemDefault;
    }
}
