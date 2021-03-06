package com.szy.yishopcustomer.ResponseModel;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;
import java.util.Map;

/**
 * Created by Smart on 2017/7/3.
 */

public class DepositCardModel {

    /**
     * code : 0
     * data : {"model":{"id":null,"card_number":null,"pass_word":null,"type_id":null,"card_status":null,"user_id":null,"use_time":null,"add_time":null},"list":[{"amount":"10.00","start_time":"1497196800","end_time":"1497369600","type_name":"10元储值卡","id":"15","card_number":"82222814751","pass_word":"O1isvY","card_status":"1","user_id":"2","use_time":"1497239015","add_time":"1497238987","user_name":"liuxiaona"},{"amount":"10.00","start_time":"1497196800","end_time":"1497369600","type_name":"10元储值卡10元储值卡10元储储值卡10元储值卡10储值卡10元储值卡10元储值卡10元储值卡10元储值卡1储值卡储值","id":"21","card_number":"06062429724","pass_word":"FM6Zgt","card_status":"1","user_id":"2","use_time":"1497246418","add_time":"1497246404","user_name":"liuxiaona"},{"amount":"10.00","start_time":"1497888000","end_time":"1504281599","type_name":"测试10元","id":"55","card_number":"96163052681","pass_word":"zq18B2","card_status":"1","user_id":"2","use_time":"1497938376","add_time":"1497938065","user_name":"liuxiaona"},{"amount":"50.00","start_time":"1498406400","end_time":"1499097599","type_name":"50元储值卡","id":"60","card_number":"66308965928","pass_word":"1y7q8h","card_status":"1","user_id":"2","use_time":"1498469650","add_time":"1498469426","user_name":"liuxiaona"}],"page":{"page_key":"page","page_id":"pagination","default_page_size":15,"cur_page":1,"page_size":10,"page_size_list":[10,50,500,1000],"record_count":4,"page_count":1,"offset":0,"url":null,"sql":null},"nav_default":"recharge-card","context":{"current_time":1499064483,"user_info":{"user_id":2,"user_name":"liuxiaona","nickname":"哈哈","headimg":"/system/config/default_image/default_user_portrait_0.png","email":null,"email_validated":0,"mobile":"15133518792","mobile_validated":0,"is_seller":1,"shop_id":2,"last_time":1499064459,"last_ip":"100.97.126.2","last_region_code":null,"user_rank":{"rank_id":11,"rank_name":"铜牌会员","rank_img":"/backend/1/images/2017/04/12/14919738061835.jpg","min_points":2,"max_points":10,"type":0,"is_special":0}},"config":{"mall_logo":"/system/config/mall/mall_logo_0.png","site_name":"小京东+测试站","user_center_logo":"/system/config/mall/user_center_logo_0.png","mall_region_code":"13,03,02","mall_region_name":{"13":"河北省","13,03":"秦皇岛市","13,03,02":"海港区"},"mall_address":"秦皇半岛51号楼3层　","site_icp":"12222222222222222","site_copyright":"<script type=\"text/javascript\"><\/script>秦皇岛懒到家（www.qhd001.com）版权所有，并保留所有权利。","site_powered_by":"","mall_phone":"13333344125","mall_email":"zhaoyunlong@68ecshop.com","mall_wx_qrcode":"/system/config/mall/mall_wx_qrcode_0.jpg","mall_qq":"800007396","mall_wangwang":"","default_user_portrait":"/system/config/default_image/default_user_portrait_0.png","favicon":"http://68yun.oss-cn-beijing.aliyuncs.com/images/746/system/config/website/favicon_0.jpg","aliim_appkey":"23488235","aliim_secret_key":"b88d4dd831e463d7ec451d7c171a323e","aliim_main_customer":"xn8801160116","aliim_customer_logo":"/system/config/aliim/aliim_customer_logo_0.gif","aliim_welcome_words":"","aliim_uid":"d41d8cd98f00b204e9800998ecf8427e","aliim_pwd":"d41d8cd98f00b204e9800998ecf8427e"},"cart":{"goods_count":1}}}
     * message :
     * limit_urls : ["goods/publish/edit-goods-column","goods/publish/batch-edit-sku-by-sku-id","goods/publish/onsale","goods/publish/offsale","trade/order/edit","trade/order/assign","trade/delivery/quick-delivery","trade/delivery/send-logistics","finance/bill/shop-bill","shop-share","site/upload-video","enable-sousou"]
     */

    public int code;
    public DataBean data;
    public String message;
    public List<String> limit_urls;

    public static class DataBean {
        /**
         * model : {"id":null,"card_number":null,"pass_word":null,"type_id":null,"card_status":null,"user_id":null,"use_time":null,"add_time":null}
         * list : [{"amount":"10.00","start_time":"1497196800","end_time":"1497369600","type_name":"10元储值卡","id":"15","card_number":"82222814751","pass_word":"O1isvY","card_status":"1","user_id":"2","use_time":"1497239015","add_time":"1497238987","user_name":"liuxiaona"},{"amount":"10.00","start_time":"1497196800","end_time":"1497369600","type_name":"10元储值卡10元储值卡10元储储值卡10元储值卡10储值卡10元储值卡10元储值卡10元储值卡10元储值卡1储值卡储值","id":"21","card_number":"06062429724","pass_word":"FM6Zgt","card_status":"1","user_id":"2","use_time":"1497246418","add_time":"1497246404","user_name":"liuxiaona"},{"amount":"10.00","start_time":"1497888000","end_time":"1504281599","type_name":"测试10元","id":"55","card_number":"96163052681","pass_word":"zq18B2","card_status":"1","user_id":"2","use_time":"1497938376","add_time":"1497938065","user_name":"liuxiaona"},{"amount":"50.00","start_time":"1498406400","end_time":"1499097599","type_name":"50元储值卡","id":"60","card_number":"66308965928","pass_word":"1y7q8h","card_status":"1","user_id":"2","use_time":"1498469650","add_time":"1498469426","user_name":"liuxiaona"}]
         * page : {"page_key":"page","page_id":"pagination","default_page_size":15,"cur_page":1,"page_size":10,"page_size_list":[10,50,500,1000],"record_count":4,"page_count":1,"offset":0,"url":null,"sql":null}
         * nav_default : recharge-card
         * context : {"current_time":1499064483,"user_info":{"user_id":2,"user_name":"liuxiaona","nickname":"哈哈","headimg":"/system/config/default_image/default_user_portrait_0.png","email":null,"email_validated":0,"mobile":"15133518792","mobile_validated":0,"is_seller":1,"shop_id":2,"last_time":1499064459,"last_ip":"100.97.126.2","last_region_code":null,"user_rank":{"rank_id":11,"rank_name":"铜牌会员","rank_img":"/backend/1/images/2017/04/12/14919738061835.jpg","min_points":2,"max_points":10,"type":0,"is_special":0}},"config":{"mall_logo":"/system/config/mall/mall_logo_0.png","site_name":"小京东+测试站","user_center_logo":"/system/config/mall/user_center_logo_0.png","mall_region_code":"13,03,02","mall_region_name":{"13":"河北省","13,03":"秦皇岛市","13,03,02":"海港区"},"mall_address":"秦皇半岛51号楼3层　","site_icp":"12222222222222222","site_copyright":"<script type=\"text/javascript\"><\/script>秦皇岛懒到家（www.qhd001.com）版权所有，并保留所有权利。","site_powered_by":"","mall_phone":"13333344125","mall_email":"zhaoyunlong@68ecshop.com","mall_wx_qrcode":"/system/config/mall/mall_wx_qrcode_0.jpg","mall_qq":"800007396","mall_wangwang":"","default_user_portrait":"/system/config/default_image/default_user_portrait_0.png","favicon":"http://68yun.oss-cn-beijing.aliyuncs.com/images/746/system/config/website/favicon_0.jpg","aliim_appkey":"23488235","aliim_secret_key":"b88d4dd831e463d7ec451d7c171a323e","aliim_main_customer":"xn8801160116","aliim_customer_logo":"/system/config/aliim/aliim_customer_logo_0.gif","aliim_welcome_words":"","aliim_uid":"d41d8cd98f00b204e9800998ecf8427e","aliim_pwd":"d41d8cd98f00b204e9800998ecf8427e"},"cart":{"goods_count":1}}
         */

        public ModelBean model;
        public PageBean page;
        public String nav_default;
        public ContextBean context;
        public List<ListBean> list;

        public static class ModelBean {
            /**
             * id : null
             * card_number : null
             * pass_word : null
             * type_id : null
             * card_status : null
             * user_id : null
             * use_time : null
             * add_time : null
             */

            public String id;
            public String card_number;
            public String pass_word;
            public String type_id;
            public String card_status;
            public String user_id;
            public String use_time;
            public String add_time;
        }

        public static class PageBean {
            /**
             * page_key : page
             * page_id : pagination
             * default_page_size : 15
             * cur_page : 1
             * page_size : 10
             * page_size_list : [10,50,500,1000]
             * record_count : 4
             * page_count : 1
             * offset : 0
             * url : null
             * sql : null
             */

            public String page_key;
            public String page_id;
            public int default_page_size;
            public int cur_page;
            public int page_size;
            public int record_count;
            public int page_count;
            public int offset;
            public Object url;
            public Object sql;
            public List<Integer> page_size_list;
        }

        public static class ContextBean {
            /**
             * current_time : 1499064483
             * user_info : {"user_id":2,"user_name":"liuxiaona","nickname":"哈哈","headimg":"/system/config/default_image/default_user_portrait_0.png","email":null,"email_validated":0,"mobile":"15133518792","mobile_validated":0,"is_seller":1,"shop_id":2,"last_time":1499064459,"last_ip":"100.97.126.2","last_region_code":null,"user_rank":{"rank_id":11,"rank_name":"铜牌会员","rank_img":"/backend/1/images/2017/04/12/14919738061835.jpg","min_points":2,"max_points":10,"type":0,"is_special":0}}
             * config : {"mall_logo":"/system/config/mall/mall_logo_0.png","site_name":"小京东+测试站","user_center_logo":"/system/config/mall/user_center_logo_0.png","mall_region_code":"13,03,02","mall_region_name":{"13":"河北省","13,03":"秦皇岛市","13,03,02":"海港区"},"mall_address":"秦皇半岛51号楼3层　","site_icp":"12222222222222222","site_copyright":"<script type=\"text/javascript\"><\/script>秦皇岛懒到家（www.qhd001.com）版权所有，并保留所有权利。","site_powered_by":"","mall_phone":"13333344125","mall_email":"zhaoyunlong@68ecshop.com","mall_wx_qrcode":"/system/config/mall/mall_wx_qrcode_0.jpg","mall_qq":"800007396","mall_wangwang":"","default_user_portrait":"/system/config/default_image/default_user_portrait_0.png","favicon":"http://68yun.oss-cn-beijing.aliyuncs.com/images/746/system/config/website/favicon_0.jpg","aliim_appkey":"23488235","aliim_secret_key":"b88d4dd831e463d7ec451d7c171a323e","aliim_main_customer":"xn8801160116","aliim_customer_logo":"/system/config/aliim/aliim_customer_logo_0.gif","aliim_welcome_words":"","aliim_uid":"d41d8cd98f00b204e9800998ecf8427e","aliim_pwd":"d41d8cd98f00b204e9800998ecf8427e"}
             * cart : {"goods_count":1}
             */

            public int current_time;
            public UserInfoBean user_info;
            public ConfigBean config;
            public CartBean cart;

            public static class UserInfoBean {
                /**
                 * user_id : 2
                 * user_name : liuxiaona
                 * nickname : 哈哈
                 * headimg : /system/config/default_image/default_user_portrait_0.png
                 * email : null
                 * email_validated : 0
                 * mobile : 15133518792
                 * mobile_validated : 0
                 * is_seller : 1
                 * shop_id : 2
                 * last_time : 1499064459
                 * last_ip : 100.97.126.2
                 * last_region_code : null
                 * user_rank : {"rank_id":11,"rank_name":"铜牌会员","rank_img":"/backend/1/images/2017/04/12/14919738061835.jpg","min_points":2,"max_points":10,"type":0,"is_special":0}
                 */

                public int user_id;
                public String user_name;
                public String nickname;
                public String headimg;
                public Object email;
                public int email_validated;
                public String mobile;
                public int mobile_validated;
                public int is_seller;
                public int shop_id;
                public int last_time;
                public String last_ip;
                public Object last_region_code;
                public UserRankBean user_rank;

                public static class UserRankBean {
                    /**
                     * rank_id : 11
                     * rank_name : 铜牌会员
                     * rank_img : /backend/1/images/2017/04/12/14919738061835.jpg
                     * min_points : 2
                     * max_points : 10
                     * type : 0
                     * is_special : 0
                     */

                    public int rank_id;
                    public String rank_name;
                    public String rank_img;
                    public int min_points;
                    public int max_points;
                    public int type;
                    public int is_special;
                }
            }

            public static class ConfigBean {
                /**
                 * mall_logo : /system/config/mall/mall_logo_0.png
                 * site_name : 小京东+测试站
                 * user_center_logo : /system/config/mall/user_center_logo_0.png
                 * mall_region_code : 13,03,02
                 * mall_region_name : {"13":"河北省","13,03":"秦皇岛市","13,03,02":"海港区"}
                 * mall_address : 秦皇半岛51号楼3层　
                 * site_icp : 12222222222222222
                 * site_copyright : <script type="text/javascript"></script>秦皇岛懒到家（www.qhd001.com）版权所有，并保留所有权利。
                 * site_powered_by :
                 * mall_phone : 13333344125
                 * mall_email : zhaoyunlong@68ecshop.com
                 * mall_wx_qrcode : /system/config/mall/mall_wx_qrcode_0.jpg
                 * mall_qq : 800007396
                 * mall_wangwang :
                 * default_user_portrait : /system/config/default_image/default_user_portrait_0.png
                 * favicon : http://68yun.oss-cn-beijing.aliyuncs.com/images/746/system/config/website/favicon_0.jpg
                 * aliim_appkey : 23488235
                 * aliim_secret_key : b88d4dd831e463d7ec451d7c171a323e
                 * aliim_main_customer : xn8801160116
                 * aliim_customer_logo : /system/config/aliim/aliim_customer_logo_0.gif
                 * aliim_welcome_words :
                 * aliim_uid : d41d8cd98f00b204e9800998ecf8427e
                 * aliim_pwd : d41d8cd98f00b204e9800998ecf8427e
                 */

                public String mall_logo;
                public String site_name;
                public String user_center_logo;
                public String mall_region_code;
                public Map<String,String> mall_region_name;
                public String mall_address;
                public String site_icp;
                public String site_copyright;
                public String site_powered_by;
                public String mall_phone;
                public String mall_email;
                public String mall_wx_qrcode;
                public String mall_qq;
                public String mall_wangwang;
                public String default_user_portrait;
                public String favicon;
                public String aliim_appkey;
                public String aliim_secret_key;
                public String aliim_main_customer;
                public String aliim_customer_logo;
                public String aliim_welcome_words;
                public String aliim_uid;
                public String aliim_pwd;

            }

            public static class CartBean {
                /**
                 * goods_count : 1
                 */

                public int goods_count;
            }
        }

        public static class ListBean {
            /**
             * amount : 10.00
             * start_time : 1497196800
             * end_time : 1497369600
             * type_name : 10元储值卡
             * id : 15
             * card_number : 82222814751
             * pass_word : O1isvY
             * card_status : 1
             * user_id : 2
             * use_time : 1497239015
             * add_time : 1497238987
             * user_name : liuxiaona
             */

            public String card_id;
            public String surplus_amount;
            public String type_id;
            public String send_number;
            public String limit_bind;
            public Object bind_num;
            public String use_range;
            public String ext_info;
            public String desc;
            public String is_delete;
            public String is_enable;
            public String shop_id;
            public String shop_name;
            public String is_used;
            public String is_over;


            public String amount;
            public String start_time;
            public String end_time;
            public String type_name;
            public String id;
            public String card_number;
            public String pass_word;
            public String card_status;
            public String user_id;
            public String use_time;
            public String add_time;
            public String user_name;



        }
    }

}
