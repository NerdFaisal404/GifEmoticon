package com.hoanganhtuan95ptit.emoticon;

import com.hoanganhtuan95ptit.emoticon.utils.EmoticonProvider;

import java.util.HashMap;


class ExampleEmoticonProvider implements EmoticonProvider {

    private ExampleEmoticonProvider() {
    }

    private static ExampleEmoticonProvider exampleEmoticonProvider;

    static ExampleEmoticonProvider create() {
        if (exampleEmoticonProvider == null) {
            exampleEmoticonProvider = new ExampleEmoticonProvider();
        }
        return exampleEmoticonProvider;
    }

    @Override
    public boolean hasEmoticonIcon(String unicode) {
        return EmoticonList.EMOTICONS.containsKey(unicode);
    }

    @Override
    public HashMap<String, String> getEmoticons() {
        return EmoticonList.EMOTICONS;
    }

}
