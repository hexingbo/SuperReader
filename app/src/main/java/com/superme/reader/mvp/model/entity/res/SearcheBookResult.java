package com.superme.reader.mvp.model.entity.res;

import java.util.List;

/**
 * 追书搜索结果
 * Created by YandZD on 2017/8/11.
 */

public class SearcheBookResult {


    /**
     * code : 0
     * list : [{"author":"12小时睡眠","cover":"https://www.xsbiquge.com/cover/89/89056/89056s.jpg","introduce":"穷小子杨柏初吻被夺了，居然还是一条鲤鱼。神奇的事情发生了，种瓜种草种神药，养花养鱼养神犬。挣很多的钱，桃花也也朵朵开。杨柏要打下一片乐途，任何不服之人，统统打倒。农村包围城市，莫欺小神农，一个农民的强...","name":"超品小神农","num":" 第1172章 无法无量 ","tag":"都市言情","time":"2019-12-14","url":"https://www.xsbiquge.com/89_89056/"},{"cover":"https://www.x23qb.com/files/article/image/10/10089/10089s.jpg","introduce":"穷小子杨柏初吻被夺了，居然还是一条鲤鱼。神奇的事情发生了，种瓜种草种神药，养花养鱼养神犬。挣很多的钱，桃花也也朵朵开。杨柏要打下一片乐途，任何不服之人，统统打倒。农村包围城市，莫欺小神农，一个农民的强大传奇！","name":"超品小神农","num":"第1172章 无法无量","status":"连载中","tag":"玄幻奇幻","time":"2019-12-14 06:10","url":"qbxshttps://www.x23qb.com/book/10089/"},{"author":"12小时睡眠","cover":"https://www.x33xs.com/image/239/239672/239672s.jpg","introduce":"穷小子杨柏初吻被夺了，居然还是一条鲤鱼。神奇的事情发生了，种瓜种草种神药，养花养鱼养神犬。","name":"超品小神农","num":"第1172章 无法无量","tag":"都市小说","time":"2019-12-14","url":"/33xs/239/239672/"}]
     * message : 成功!
     */

    private int code;
    private String message;
    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * author : 12小时睡眠
         * cover : https://www.xsbiquge.com/cover/89/89056/89056s.jpg
         * introduce : 穷小子杨柏初吻被夺了，居然还是一条鲤鱼。神奇的事情发生了，种瓜种草种神药，养花养鱼养神犬。挣很多的钱，桃花也也朵朵开。杨柏要打下一片乐途，任何不服之人，统统打倒。农村包围城市，莫欺小神农，一个农民的强...
         * name : 超品小神农
         * num :  第1172章 无法无量
         * tag : 都市言情
         * time : 2019-12-14
         * url : https://www.xsbiquge.com/89_89056/
         * status : 连载中
         */

        private String author;
        private String cover;
        private String introduce;
        private String name;
        private String num;
        private String tag;
        private String time;
        private String url;
        private String status;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
