package com.hoanganhtuan95ptit.emoticon;

import java.util.HashMap;

/**
 * Created by Hoang Anh Tuan on 12/14/2017.
 */

class EmoticonList {
    static final HashMap<String, String> EMOTICONS = new HashMap<>();

    static {
        EMOTICONS.put("(giggle)", "emojigifs/emoji_1.gif");
        EMOTICONS.put("(monkey)", "emojigifs/emoji_2.gif");
        EMOTICONS.put("(rock)", "emojigifs/emoji_3.gif");
        EMOTICONS.put(":))", "emojicons/emoji_1.png");
        EMOTICONS.put(";)", "emojicons/emoji_28.png");
    }

}