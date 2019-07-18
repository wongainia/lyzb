package com.szy.yishopcustomer.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zongren on 2016/3/23.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public enum EventWhat {
    EVENT_SHOP_CART_UPDATE,
    EVENT_ADD_ADDRESS,
    EVENT_AWAIT_SHIP_ORDER_LIST,
    EVENT_BIND_SUCCESS,
    EVENT_UPDATE_CART_NUMBER,
    EVENT_DELETE_ADDRESS,
    EVENT_FINISH_GUIDE,
    EVENT_HIDE_FILTER_VIEW,
    EVENT_LOGIN,
    EVENT_LOGIN_CANCEL,
    EVENT_LOGOUT,
    EVENT_OPEN_CART_TAB,
    EVENT_LOAD_FRAGMENT,
    EVENT_OPEN_CATEGORY_TAB,
    EVENT_OPEN_INDEX,
    EVENT_OPEN_INVENTORY_TAB,
    EVENT_OPEN_USER_TAB,
    EVENT_ORDER_LIST,
    EVENT_PAY_CANCEL,
    EVENT_PAY_FINISH,
    EVENT_PAY_WX_SUCCESS,
    EVENT_PAY_WX_FAILURE,
    EVENT_RECEIVER_MESSAGE,
    EVENT_REFRESH_INDEX,
    EVENT_REFRESH_WEB_TITLE, EVENT_CLOSE,
    EVENT_SHOW_FILTER_VIEW,
    EVENT_UNPAID_ORDER_LIST,
    EVENT_UPDATE_ADDRESS,
    EVENT_WEIXIN_LOGIN,
    EVENT_WEIXIN_SHARE,
    EVENT_CHECKOUT_SUCCEED,
    EVENT_COUNTDOWN_FINISH,
    EVENT_UPDATE_GOODS_NUMBER,
    EVENT_REFRESH_INVENTORY, EVENT_MONEY_CHANGE, ITEM_VIEW_TYPE,
    EVENT_REFRESH_BACK_DETAIL, EVENT_REFRESH_USER_INFO, EVENT_CHECKOUT_FINISH, EVENT_REFRESH_BIND_LIST,
    EVENT_REFRESH_NEARBY, EVENT_TIME_OUT, EVENT_OPEN_SHOP_STREET_TAB, EVENT_OPEN_DISTRIB_INCOME,
    EVENT_OPEN_DISTRIB_INCOME_ADD, EVENT_OPEN_DISTRIB_INCOME_RECORD, EVENT_OPEN_DISTRIB_INCOME_DETAILS,
    EVENT_OPEN_DISTRIB_ORDER, EVENT_OPEN_DISTRIB_TEAM, EVENT_OPEN_DISTRIB_HELP,
    EVENT_UPDATE_MESSAGE_VISIBILE, EVENT_SHOW_KEYWORDS, EVENT_REFRESH_ORDER_LIST, EVENT_REFRESH_GOODS,
    EVENT_SHOP_GOODS_LIST_REFRESH, EVENT_OPEN_DISTRIBUTOR_INDEX, EVENT_OPEN_DISTRIB_CATEGORY,
    EVENT_OPEN_DISTRIB_GOODS_LIST, EVENT_OPEN_DISTRIB_SET, EVENT_DISTRIB_MENU_CHANGE,
    EVENT_COMPLAINT_REFRESH,
    EVENT_UPDATE_GOODS_DESC,
    EVENT_WX_PAY_SUCCESS_LIFE,
    QR_CODE_URL,
    SAMECITY_HOME,
    SAMECITY_NEAR,
    SAMECITY_ORDER,
    SAMECITY_ADDRESS_INFO,
    HX_LISTINENER,
    HX_UNLISTINENER;


    private static Map<Integer, EventWhat> mMap = new HashMap<>();

    static {
        for (EventWhat eventWhat : values()) {
            mMap.put(eventWhat.ordinal(), eventWhat);
        }
    }

    public static EventWhat valueOf(int value) {
        return mMap.get(value);
    }

    public int getValue() {
        return this.ordinal();
    }

}