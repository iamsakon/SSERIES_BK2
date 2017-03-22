
/**
 *
 */
package com.sky.biz.sseries.usm.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sky.biz.sseries.mbean.IBasicController;

import com.sky.biz.sseries.usm.framework.controller.AbstractUserAccountController;

@ManagedBean(name = "userAccountController")
@SessionScoped
public class UserAccountController extends AbstractUserAccountController implements IBasicController {

}
