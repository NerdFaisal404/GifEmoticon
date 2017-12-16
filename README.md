# GifEmoticon
emoticon gif like skype

# Demo

[<img src="/store/GIF.gif">](https://play.google.com/store/apps/details?id=com.hoanganhtuan01101995.sola_date)

# Project

Icon | Name | Link Google Play
------------ | ------------ | -------------
[<img src="/store/ic_launcher.png">](https://play.google.com/store/apps/details?id=com.hoanganhtuan01101995.sola_date) | [Sola - Stranger chat, Anonymous chat & Date](https://play.google.com/store/apps/details?id=com.hoanganhtuan01101995.sola_date) | [<img src="/store/Store.png">](https://play.google.com/store/apps/details?id=com.hoanganhtuan01101995.sola_date)


# Download

* Step 1. Add it in your root build.gradle at the end of repositories:
```java
    allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
    }
```
* Step 2. Add the dependency
```java
    dependencies {
	      compile 'com.github.hoanganhtuan95ptit:GifEmoticon:1.0'
    }
```

# Using

* xml

```java
     <com.hoanganhtuan95ptit.emoticon.EmoticonTextView
        android:id="@+id/tv_infor"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:emoticonSize="30sp" />
```

# How to customize the EmoticonTextView
* Customize EmoticonProvider
```java
      public interface EmoticonProvider {

          boolean hasEmoticonIcon(String unicode);

          HashMap<String, String> getEmoticons();

      }
```
* Example
```java
    public class GifEmoticonProvider implements EmoticonProvider {

        static final HashMap<String, String> EMOTICONS = new HashMap<>();

        static {
            EMOTICONS.put("(giggle)", "emojigifs/emoji_1.gif");
            EMOTICONS.put("(monkey)", "emojigifs/monkey.gif");
            EMOTICONS.put("(rock)", "emojigifs/emoji_3.gif");
            EMOTICONS.put(":)", "emojicons/emoji_1.png");
            ...
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

```
 * set EmoticonProvider
 ```java
        emoticonTextView.setEmoticonProvider(GifEmoticonProvider.create());
 ```

# Thank 

 Name | Library
------------ | -------------
waynejo | [android-ndk-gif](https://github.com/waynejo/android-ndk-gif) 

