package com.lianxi.zy.myrookie.bean;

import java.util.List;

/**
 * Created by 小傻瓜 on 2017/12/21.
 */

public class HotDoorBean {

    /**
     * copyright : 本API接口只允许菜鸟窝(https://www.cniao5.com)用户使用,其他机构或者个人使用均为侵权行为
     * totalCount : 23
     * currentPage : 1
     * totalPage : 0
     * pageSize : 10
     * orders : [{"orderType":"DESC","field":"id"}]
     * list : [{"id":177,"categoryId":1,"campaignId":17,"name":"爱慕新品金丝奇缘3/4薄模杯无托文胸AM17GP1 酒红色 B80","imgUrl":"http://m.360buyimg.com/n4/jfs/t1786/328/1204039392/295008/96a7278c/55e3e456N0ddbe7c5.jpg!q70.jpg","price":239,"sale":3973},{"id":169,"categoryId":1,"campaignId":10,"name":"幻薇聚拢文胸 无钢圈性感无痕舒适收副乳调整型胸罩一片式拉丝小胸女式内衣 迷人黑色 85/38C","imgUrl":"http://m.360buyimg.com/n4/jfs/t2245/94/128551027/64302/5d6b2e47/55efe952N2b07492e.jpg!q70.jpg","price":102,"sale":546},{"id":152,"categoryId":1,"campaignId":18,"name":"幸福时光 2015男士西服套装 西服 男西装套装 三件套西装外套休闲西装男 藏青色 L","imgUrl":"http://m.360buyimg.com/n4/jfs/t1408/218/876301182/146947/9d229bf8/55ae11faN6dbcd049.jpg!q70.jpg","price":388,"sale":4434},{"id":149,"categoryId":1,"campaignId":1,"name":"海澜之家男装 2015秋季热卖 男士商务西装修身西服套装男HTXAD1A051A 黑色(51) 175/92A","imgUrl":"http://m.360buyimg.com/n4/jfs/t562/95/1374419144/476595/9c523767/54d41fdfNdd8cac62.jpg!q70.jpg","price":680,"sale":9538},{"id":145,"categoryId":1,"campaignId":5,"name":"丹杰仕2015新款西服套装 男 小西装韩版修身新郎西服 宴会礼服 男商务休闲职业西装 XZ23咖色上衣 L","imgUrl":"http://m.360buyimg.com/n4/jfs/t1147/221/527465037/194737/cd51e056/552bc8ffN305a6037.jpg!q70.jpg","price":258,"sale":29},{"id":139,"categoryId":1,"campaignId":1,"name":"雅戈尔（YOUNGOR）2015秋季新款羊毛西服男商旅抗皱西装套装 TX28803 藏蓝色 175/96A","imgUrl":"http://m.360buyimg.com/n4/jfs/t634/77/449777070/143492/3fffbe4f/546ab0a1N9995f8c9.jpg!q70.jpg","price":1088,"sale":6760},{"id":112,"categoryId":1,"campaignId":1,"name":"【货到付款+送华为路由器】华为手环B2蓝牙耳机与智能手环运动手环支持安卓与苹果智能手表 黑色(运动版)送华为无线路由器","imgUrl":"http://m.360buyimg.com/n4/jfs/t994/138/1047376084/108265/1869453f/556e7626N45a3d4d8.jpg!q70.jpg","price":999,"sale":2828},{"id":110,"categoryId":1,"campaignId":7,"name":"新小米（MI）手环 智能健康睡眠运动手环手表男女腕带黑色计步器手环 (激光刻字)(不支持货到付款)选择货到付款将不发货","imgUrl":"http://m.360buyimg.com/n4/jfs/t793/200/1057010598/115140/562c0f5c/55716d4fNfadd1d1b.jpg!q70.jpg","price":77,"sale":8233},{"id":94,"categoryId":1,"campaignId":1,"name":"小米（MI）手环 智能防水运动手环  计步器 可监测健康睡眠 新黑色原封+原装橙色腕带","imgUrl":"http://m.360buyimg.com/n4/jfs/t1390/142/747439596/104209/729a49bf/55a8ae89N4b5676f4.jpg!q70.jpg","price":88.8,"sale":5307},{"id":86,"categoryId":1,"campaignId":3,"name":"一加手机2（A2001） 64GB 砂岩黑版 移动联通4G手机 双卡双待","imgUrl":"http://m.360buyimg.com/n4/jfs/t1762/270/63178273/111852/cf9f6325/55cc115eNbbf574aa.jpg!q70.jpg","price":2399,"sale":685}]
     */

    private String copyright;
    private int totalCount;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private List<OrdersBean> orders;
    private List<ListBean> list;

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

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class OrdersBean {
        /**
         * orderType : DESC
         * field : id
         */

        private String orderType;
        private String field;

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }
    }

    public static class ListBean {
        /**
         * id : 177
         * categoryId : 1
         * campaignId : 17
         * name : 爱慕新品金丝奇缘3/4薄模杯无托文胸AM17GP1 酒红色 B80
         * imgUrl : http://m.360buyimg.com/n4/jfs/t1786/328/1204039392/295008/96a7278c/55e3e456N0ddbe7c5.jpg!q70.jpg
         * price : 239.0
         * sale : 3973
         */

        private int id;
        private int categoryId;
        private int campaignId;
        private String name;
        private String imgUrl;
        private double price;
        private int sale;

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
