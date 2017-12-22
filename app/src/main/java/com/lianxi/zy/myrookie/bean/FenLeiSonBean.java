package com.lianxi.zy.myrookie.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ${zy} on 2017/12/20.
 */

public class FenLeiSonBean {


    /**
     * copyright : 本API接口只允许菜鸟窝(https://www.cniao5.com)用户使用,其他机构或者个人使用均为侵权行为
     * totalCount : 17
     * currentPage : 1
     * totalPage : 0
     * pageSize : 10
     * orders : []
     * list : [{"id":136,"categoryId":2,"campaignId":4,"name":"丹杰仕     2015新款 男士西服套装 韩版修身西装 三件套 黑色单西 2XL","imgUrl":"http://m.360buyimg.com/n4/jfs/t1987/334/292655906/92721/7a00e06b/55feab75Nbb24fcf3.jpg!q70.jpg","price":258,"sale":5289},{"id":137,"categoryId":2,"campaignId":11,"name":"丹杰仕男装 西装新郎结婚礼服外套 韩版修身发型师英伦花刺绣西服三件套 单件西装 XL","imgUrl":"http://m.360buyimg.com/n4/jfs/t826/17/578550613/123531/4ffa1d6e/553867bcN1d1d0e8a.jpg!q70.jpg","price":268,"sale":7550},{"id":138,"categoryId":2,"campaignId":10,"name":"培罗蒙西服2015夏季商务休闲男 修身韩版二扣西服西装套装外套 ETZBH4502 4502黑色 165/84 A","imgUrl":"http://m.360buyimg.com/n4/jfs/t2044/179/368026217/724456/de3a9a5/56020133N646cb7bf.jpg!q70.jpg","price":439,"sale":1882},{"id":140,"categoryId":2,"campaignId":8,"name":"领般【商务绅士】男士西服套装商务休闲修身西装男款职业正装结婚礼服 黑竖纹 西服44+西裤28","imgUrl":"http://m.360buyimg.com/n4/jfs/t1789/182/1002200635/217318/6de09102/55ded1e1N4e7763b9.jpg!q70.jpg","price":388,"sale":8156},{"id":141,"categoryId":2,"campaignId":1,"name":"幸福时光 西服套装男士 韩版男免烫修身休闲西装男套装商务职业正装新郎结婚礼服工作装 藏青色 M","imgUrl":"http://m.360buyimg.com/n4/jfs/t2242/70/107608910/263732/5c0066ff/55efac88N8ea51acb.jpg!q70.jpg","price":387,"sale":500},{"id":142,"categoryId":2,"campaignId":13,"name":"【秋季新品】罗蒙西服套装男士修身西装新郎结婚礼服商务1S51120 89黑色 175/92A","imgUrl":"http://m.360buyimg.com/n4/jfs/t1291/107/1133853439/231353/4c32a349/55b7689eN4e0026af.jpg!q70.jpg","price":489,"sale":8032},{"id":143,"categoryId":2,"campaignId":17,"name":"Heilan Home/海澜之家2015秋季新品男装修身质感套装西服HTXAD3A060A 黑色(60) 175/92A","imgUrl":"http://m.360buyimg.com/n4/jfs/t1399/214/1145383443/468146/9bf32a81/55bd7d2eN89bb46ab.jpg!q70.jpg","price":680,"sale":8660},{"id":144,"categoryId":2,"campaignId":9,"name":"丹杰仕 2015新款韩版时尚韩版修身男士西装潮流西服套装 男 结婚西服套装男士婚礼礼服 X128黑色上衣 M","imgUrl":"http://m.360buyimg.com/n4/jfs/t1219/344/590964683/112463/562e7550/553386eaN6840fb71.jpg!q70.jpg","price":288,"sale":9202},{"id":146,"categoryId":2,"campaignId":1,"name":"丹杰仕男仕西服套装男2015新款结婚礼服正装英伦修身影楼西装婚庆三件套潮 黑色两件套 L","imgUrl":"http://m.360buyimg.com/n4/jfs/t1819/280/1813576110/71047/998409ff/5610e8c6N2e5a9555.jpg!q70.jpg","price":326,"sale":2542},{"id":147,"categoryId":2,"campaignId":8,"name":"Heilan Home/海澜之家2015年秋季新品绅士修身西服套装HTXAD3A009A 黑色(09) 175/92A","imgUrl":"http://m.360buyimg.com/n4/jfs/t1552/226/1321048840/479695/f3947afe/55c55b5bN83767f59.jpg!q70.jpg","price":800,"sale":2621}]
     */

    private String copyright;
    private int totalCount;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private List<?> orders;
    private List<ListBean> list;

    public static FenLeiSonBean objectFromData(String str) {

        return new Gson().fromJson(str, FenLeiSonBean.class);
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getOrders() {
        return orders;
    }

    public void setOrders(List<?> orders) {
        this.orders = orders;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 136
         * categoryId : 2
         * campaignId : 4
         * name : 丹杰仕     2015新款 男士西服套装 韩版修身西装 三件套 黑色单西 2XL
         * imgUrl : http://m.360buyimg.com/n4/jfs/t1987/334/292655906/92721/7a00e06b/55feab75Nbb24fcf3.jpg!q70.jpg
         * price : 258.0
         * sale : 5289
         */

        private int id;
        private int categoryId;
        private int campaignId;
        private String name;
        private String imgUrl;
        private double price;
        private int sale;

        public static ListBean objectFromData(String str) {

            return new Gson().fromJson(str, ListBean.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }
    }
}
