package com.hoanganhtuan95ptit.gifemoticon.utils;

import com.hoanganhtuan95ptit.emoticon.utils.EmoticonProvider;

import java.util.HashMap;

/**
 * Created by Hoang Anh Tuan on 12/15/2017.
 */

public class GifEmoticonProvider implements EmoticonProvider {

    static final HashMap<String, String> EMOTICONS = new HashMap<>();

    static {
        EMOTICONS.put("(giggle)", "emojigifs/emoji_1.gif");
        EMOTICONS.put("(monkey)", "emojigifs/monkey.gif");
        EMOTICONS.put("(rock)", "emojigifs/emoji_3.gif");
        EMOTICONS.put(":)", "emojicons/emoji_1.png");
        EMOTICONS.put("y:))", "emojicons/emoji_2.png");
        EMOTICONS.put("(:8", "emojicons/emoji_3.png");
        EMOTICONS.put(":'(", "emojicons/emoji_4.png");
        EMOTICONS.put(":D", "emojicons/emoji_5.png");
        EMOTICONS.put(">:|", "emojicons/emoji_6.png");
        EMOTICONS.put("|:|", "emojicons/emoji_7.png");
        EMOTICONS.put(":B", "emojicons/emoji_8.png");
        EMOTICONS.put("):.", "emojicons/emoji_9.png");
        EMOTICONS.put("b:|", "emojicons/emoji_10.png");
        EMOTICONS.put("**", "emojicons/emoji_11.png");
        EMOTICONS.put("**|", "emojicons/emoji_12.png");
        EMOTICONS.put("O:|", "emojicons/emoji_13.png");
        EMOTICONS.put("@@", "emojicons/emoji_14.png");
        EMOTICONS.put("8'", "emojicons/emoji_15.png");
        EMOTICONS.put(":-o", "emojicons/emoji_16.png");
        EMOTICONS.put("*:", "emojicons/emoji_17.png");
        EMOTICONS.put(">8p", "emojicons/emoji_18.png");
        EMOTICONS.put("cold", "emojicons/emoji_19.png");
        EMOTICONS.put("):(", "emojicons/emoji_20.png");
        EMOTICONS.put(",:|", "emojicons/emoji_21.png");
        EMOTICONS.put(">:(", "emojicons/emoji_22.png");
        EMOTICONS.put(":(=", "emojicons/emoji_23.png");
        EMOTICONS.put("|;(", "emojicons/emoji_24.png");
        EMOTICONS.put("B)", "emojicons/emoji_25.png");
        EMOTICONS.put(":8b", "emojicons/emoji_26.png");
        EMOTICONS.put(":=", "emojicons/emoji_27.png");
        EMOTICONS.put(";)", "emojicons/emoji_28.png");
        EMOTICONS.put("..:.", "emojicons/emoji_29.png");
        EMOTICONS.put(":P", "emojicons/emoji_30.png");
        EMOTICONS.put(">:;", "emojicons/emoji_31.png");
        EMOTICONS.put("|:;", "emojicons/emoji_32.png");
        EMOTICONS.put("|;)", "emojicons/emoji_33.png");
        EMOTICONS.put("b-", "emojicons/emoji_34.png");
        EMOTICONS.put(":-o", "emojicons/emoji_35.png");
        EMOTICONS.put(":'o", "emojicons/emoji_36.png");
        EMOTICONS.put("_:O", "emojicons/emoji_37.png");
        EMOTICONS.put("8d", "emojicons/emoji_38.png");
        EMOTICONS.put("6~", "emojicons/emoji_39.png");
        EMOTICONS.put("(yoyo)", "emojicons/emoji_40.png");
        EMOTICONS.put("<8o", "emojicons/emoji_41.png");
        EMOTICONS.put(";.)", "emojicons/emoji_42.png");
        EMOTICONS.put("':o", "emojicons/emoji_43.png");
        EMOTICONS.put("(spiderman)", "emojicons/emoji_45.png");
        EMOTICONS.put(":).", "emojicons/emoji_46.png");
        EMOTICONS.put(":((", "emojicons/emoji_47.png");
        EMOTICONS.put("=;-", "emojicons/emoji_48.png");
        EMOTICONS.put(":oo", "emojicons/emoji_49.png");
        EMOTICONS.put(":s2", "emojicons/emoji_50.png");
        EMOTICONS.put(");o", "emojicons/emoji_51.png");
        EMOTICONS.put(":=~", "emojicons/emoji_52.png");
        EMOTICONS.put("B-0", "emojicons/emoji_53.png");
        EMOTICONS.put(">:", "emojicons/emoji_54.png");
    }

    private static GifEmoticonProvider exampleEmoticonProvider;

    public static GifEmoticonProvider create() {
        if (exampleEmoticonProvider == null) {
            exampleEmoticonProvider = new GifEmoticonProvider();
        }
        return exampleEmoticonProvider;
    }

    GifEmoticonProvider() {
    }

    @Override
    public boolean hasEmoticonIcon(String unicode) {
        return EMOTICONS.containsKey(unicode);
    }

    @Override
    public HashMap<String, String> getEmoticons() {
        return EMOTICONS;
    }

}
