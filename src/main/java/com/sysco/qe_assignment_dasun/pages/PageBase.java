package com.sysco.qe_assignment_dasun.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;

public class PageBase {
    protected static SyscoLabUI syscoLabUIOgm;

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }
}
