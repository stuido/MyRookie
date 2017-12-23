package com.lianxi.zy.myrookie.bean;

/**
 * Created by 杜梦豪 on 2017/12/23.
 */

public class EventCheck {
    public boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "EventCheck{" +
                "checked=" + checked +
                '}';
    }
}
