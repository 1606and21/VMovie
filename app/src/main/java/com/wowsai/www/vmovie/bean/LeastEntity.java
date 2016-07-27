package com.wowsai.www.vmovie.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class LeastEntity {

    /**
     * status : 0
     * msg : OK
     * data : [{"postid":"49652","title":"盖里奇新片《亚瑟王·圣剑传奇》首曝预告","pid":"1","app_fu_title":"",
     * "is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0",
     * "is_album":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-25/5795e231c77e4_cut.jpeg","rating":"7.9","duration":"163",
     * "publish_time":"1469426340","like_num":"38","share_num":"131","cates":[{"cateid":"43",
     * "catename":"预告"}],"request_url":"http://app.vmoiver.com/49652?qingapp=app_new"},
     * {"postid":"49612","title":"社交媒体情感危机短片《点赞》","pid":"1","app_fu_title":"","is_xpc":"0",
     * "is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","is_album":"0","tags":"",
     * "recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-22/5791cf95eb63a_cut.jpeg","rating":"7.8","duration":"294",
     * "publish_time":"1469405040","like_num":"95","share_num":"317","cates":[{"cateid":"17",
     * "catename":"剧情"}],"request_url":"http://app.vmoiver.com/49612?qingapp=app_new"},
     * {"postid":"49634","title":"机关重重的起床短片《早上好》","pid":"1","app_fu_title":"","is_xpc":"0",
     * "is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","is_album":"0","tags":"",
     * "recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-21/5790d11014d25_cut.jpeg","rating":"7.4","duration":"182",
     * "publish_time":"1469404980","like_num":"252","share_num":"534","cates":[{"cateid":"6",
     * "catename":"创意"}],"request_url":"http://app.vmoiver.com/49634?qingapp=app_new"},
     * {"postid":"49627","title":"棉布品牌欢乐歌舞广告《如何避免酷夏出汗》","pid":"1","app_fu_title":"","is_xpc":"0",
     * "is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","is_album":"0","tags":"",
     * "recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-21/579088a6dfa19_cut.jpeg","rating":"7.3","duration":"132",
     * "publish_time":"1469404920","like_num":"74","share_num":"101","cates":[{"cateid":"13",
     * "catename":"广告"}],"request_url":"http://app.vmoiver.com/49627?qingapp=app_new"},
     * {"postid":"49616","title":"九旬老人独自建教堂五十载《一个人一座\u201c城\u201d》","pid":"1","app_fu_title":"",
     * "is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0",
     * "is_album":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-22/5791ba14c90f3_cut.jpeg","rating":"7.6","duration":"142",
     * "publish_time":"1469404860","like_num":"136","share_num":"172","cates":[{"cateid":"24",
     * "catename":"纪录"}],"request_url":"http://app.vmoiver.com/49616?qingapp=app_new"},
     * {"postid":"49622","title":"唯美意大利风光摄影《托斯卡纳之夏》","pid":"1","app_fu_title":"","is_xpc":"0",
     * "is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","is_album":"0","tags":"",
     * "recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-22/5791b86c2c300_cut.jpeg","rating":"7.9","duration":"219",
     * "publish_time":"1469404800","like_num":"98","share_num":"107","cates":[{"cateid":"11",
     * "catename":"旅行"}],"request_url":"http://app.vmoiver.com/49622?qingapp=app_new"},
     * {"postid":"49650","title":"DC新作《神奇女侠》曝光首款预告片","pid":"1","app_fu_title":"","is_xpc":"0",
     * "is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","is_album":"0","tags":"",
     * "recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-24/5794655eb6d5d_cut.jpeg","rating":"7.6","duration":"171",
     * "publish_time":"1469345520","like_num":"210","share_num":"906","cates":[{"cateid":"43",
     * "catename":"预告"}],"request_url":"http://app.vmoiver.com/49650?qingapp=app_new"},
     * {"postid":"49631","title":"第87届奥斯卡提名短片《波加洛和格拉汉姆》","pid":"1","app_fu_title":"",
     * "is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0",
     * "is_album":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-21/5790926167da7_cut.jpeg","rating":"8.5","duration":"875",
     * "publish_time":"1469318640","like_num":"289","share_num":"442","cates":[{"cateid":"17",
     * "catename":"剧情"}],"request_url":"http://app.vmoiver.com/49631?qingapp=app_new"},
     * {"postid":"49645","title":"仿手绘风延时摄影《中国故事》","pid":"1","app_fu_title":"","is_xpc":"0",
     * "is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","is_album":"0","tags":"",
     * "recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-22/5791ebd7022bd_cut.jpeg","rating":"7.7","duration":"86",
     * "publish_time":"1469318580","like_num":"228","share_num":"471","cates":[{"cateid":"11",
     * "catename":"旅行"}],"request_url":"http://app.vmoiver.com/49645?qingapp=app_new"},
     * {"postid":"49618","title":"真·玩火！酷炫特技表演《火球》","pid":"1","app_fu_title":"","is_xpc":"0",
     * "is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","is_album":"0","tags":"",
     * "recent_hot":"0","discussion":"0","image":"http://cs.vmoiver
     * .com/Uploads/cover/2016-07-20/578f44b299400_cut.jpeg","rating":"7.8","duration":"134",
     * "publish_time":"1469318520","like_num":"153","share_num":"252","cates":[{"cateid":"10",
     * "catename":"运动"}],"request_url":"http://app.vmoiver.com/49618?qingapp=app_new"}]
     */

    private String status;
    private String msg;
    /**
     * postid : 49652
     * title : 盖里奇新片《亚瑟王·圣剑传奇》首曝预告
     * pid : 1
     * app_fu_title :
     * is_xpc : 0
     * is_promote : 0
     * is_xpc_zp : 0
     * is_xpc_cp : 0
     * is_xpc_fx : 0
     * is_album : 0
     * tags :
     * recent_hot : 0
     * discussion : 0
     * image : http://cs.vmoiver.com/Uploads/cover/2016-07-25/5795e231c77e4_cut.jpeg
     * rating : 7.9
     * duration : 163
     * publish_time : 1469426340
     * like_num : 38
     * share_num : 131
     * cates : [{"cateid":"43","catename":"预告"}]
     * request_url : http://app.vmoiver.com/49652?qingapp=app_new
     */

    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String postid;
        private String title;
        private String pid;
        private String app_fu_title;
        private String is_xpc;
        private String is_promote;
        private String is_xpc_zp;
        private String is_xpc_cp;
        private String is_xpc_fx;
        private String is_album;
        private String tags;
        private String recent_hot;
        private String discussion;
        private String image;
        private String rating;
        private String duration;
        private String publish_time;
        private String like_num;
        private String share_num;
        private String request_url;
        /**
         * cateid : 43
         * catename : 预告
         */

        private List<CatesBean> cates;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getApp_fu_title() {
            return app_fu_title;
        }

        public void setApp_fu_title(String app_fu_title) {
            this.app_fu_title = app_fu_title;
        }

        public String getIs_xpc() {
            return is_xpc;
        }

        public void setIs_xpc(String is_xpc) {
            this.is_xpc = is_xpc;
        }

        public String getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(String is_promote) {
            this.is_promote = is_promote;
        }

        public String getIs_xpc_zp() {
            return is_xpc_zp;
        }

        public void setIs_xpc_zp(String is_xpc_zp) {
            this.is_xpc_zp = is_xpc_zp;
        }

        public String getIs_xpc_cp() {
            return is_xpc_cp;
        }

        public void setIs_xpc_cp(String is_xpc_cp) {
            this.is_xpc_cp = is_xpc_cp;
        }

        public String getIs_xpc_fx() {
            return is_xpc_fx;
        }

        public void setIs_xpc_fx(String is_xpc_fx) {
            this.is_xpc_fx = is_xpc_fx;
        }

        public String getIs_album() {
            return is_album;
        }

        public void setIs_album(String is_album) {
            this.is_album = is_album;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getRecent_hot() {
            return recent_hot;
        }

        public void setRecent_hot(String recent_hot) {
            this.recent_hot = recent_hot;
        }

        public String getDiscussion() {
            return discussion;
        }

        public void setDiscussion(String discussion) {
            this.discussion = discussion;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getLike_num() {
            return like_num;
        }

        public void setLike_num(String like_num) {
            this.like_num = like_num;
        }

        public String getShare_num() {
            return share_num;
        }

        public void setShare_num(String share_num) {
            this.share_num = share_num;
        }

        public String getRequest_url() {
            return request_url;
        }

        public void setRequest_url(String request_url) {
            this.request_url = request_url;
        }

        public List<CatesBean> getCates() {
            return cates;
        }

        public void setCates(List<CatesBean> cates) {
            this.cates = cates;
        }

        public static class CatesBean {
            private String cateid;
            private String catename;

            public String getCateid() {
                return cateid;
            }

            public void setCateid(String cateid) {
                this.cateid = cateid;
            }

            public String getCatename() {
                return catename;
            }

            public void setCatename(String catename) {
                this.catename = catename;
            }
        }
    }
}
