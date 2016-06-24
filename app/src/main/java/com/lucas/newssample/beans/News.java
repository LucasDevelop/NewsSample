package com.lucas.newssample.beans;

import java.util.List;

/**
 * 作者：lucas on 2016/6/24 17:55
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class News {

    /**
     * postid : PHOT22OAS000100A
     * hasCover : false
     * hasHead : 1
     * replyCount : 112421
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : 9IG74V5H00963VRO_BQBASDMObjjikeupdateDoc
     * title : 英国公投脱欧派胜出 卡梅伦宣布辞职
     * order : 1
     * priority : 254
     * lmodify : 2016-06-24 15:59:30
     * boardid : photoview_bbs
     * ads : [{"title":"江苏盐城遭遇龙卷风 幼儿园被刮塌","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/061e021315ff41adad85b828df50e8ae20160624101522.jpeg","subtitle":"","url":"00AP0001|2187594"},{"title":"英国脱欧 日元飙升至近两年高位","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/76cba023d513492ca43d84762a2cc22020160624135738.jpeg","subtitle":"","url":"00AO0001|2187609"},{"title":"英国决定脱欧 独立党领袖欢呼庆祝","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/9abd07bf4ed74d0baadd42747b26f6fe20160624133303.jpeg","subtitle":"","url":"00AO0001|2187607"},{"title":"英国脱欧公投计票 52%民众支持脱欧","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/3fe107cfe53a4d95bb170c095763fa5720160624104823.jpeg","subtitle":"","url":"00AO0001|2187569"},{"title":"航拍阜宁龙卷风受灾现场 一片狼藉","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/27d07542eb3947db88a4b561296c774420160624093316.jpeg","subtitle":"","url":"00AP0001|2187588"}]
     * photosetID : 00AO0001|2187612
     * template : normal1
     * votecount : 108282
     * skipID : 00AO0001|2187612
     * alias : Top News
     * skipType : photoset
     * cid : C1348646712614
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/ab9043dfb07248cf8473af349c538d3820160624155709.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/cebb7443dd494bb9a6349c25d3b174c020160624155711.jpeg"}]
     * source : 网易原创
     * ename : androidnews
     * imgsrc : http://cms-bucket.nosdn.127.net/d06985eedff848c5b4340f28e4743ca220160624155704.jpeg
     * tname : 头条
     * ptime : 2016-06-24 15:55:25
     */

    public List<T1348647909107Bean> T1348647909107;

    public static class T1348647909107Bean {
        public String postid;
        public boolean hasCover;
        public int hasHead;
        public int replyCount;
        public int hasImg;
        public String digest;
        public boolean hasIcon;
        public String docid;
        public String title;
        public int order;
        public int priority;
        public String lmodify;
        public String boardid;
        public String photosetID;
        public String template;
        public int votecount;
        public String skipID;
        public String alias;
        public String skipType;
        public String cid;
        public int hasAD;
        public String source;
        public String ename;
        public String imgsrc;
        public String tname;
        public String ptime;
        /**
         * title : 江苏盐城遭遇龙卷风 幼儿园被刮塌
         * tag : photoset
         * imgsrc : http://cms-bucket.nosdn.127.net/061e021315ff41adad85b828df50e8ae20160624101522.jpeg
         * subtitle :
         * url : 00AP0001|2187594
         */

        public List<AdsBean> ads;
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/ab9043dfb07248cf8473af349c538d3820160624155709.jpeg
         */

        public List<ImgextraBean> imgextra;

        public static class AdsBean {
            public String title;
            public String tag;
            public String imgsrc;
            public String subtitle;
            public String url;
        }

        public static class ImgextraBean {
            public String imgsrc;
        }
    }
}
