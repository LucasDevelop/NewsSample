package com.lucas.newssample.beans;

/**
 * 作者：lucas on 2016/7/4 17:32
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class Images {
        public String title;
        public String thumburl;
        public String sourceurl;
        public int height;
        public int width;
        public String url;

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("com.lucas.newssample.beans.Images{");
                sb.append("height='").append(height).append('\'');
                sb.append(", sourceurl='").append(sourceurl).append('\'');
                sb.append(", thumburl='").append(thumburl).append('\'');
                sb.append(", title='").append(title).append('\'');
                sb.append(", url='").append(url).append('\'');
                sb.append(", width='").append(width).append('\'');
                sb.append('}');
                return sb.toString();
        }
}
