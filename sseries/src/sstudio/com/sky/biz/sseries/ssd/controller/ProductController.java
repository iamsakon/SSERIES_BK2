package com.sky.biz.sseries.ssd.controller;
import javax.faces.bean.*;

import com.sky.biz.sseries.mbean.IBasicController;
@ManagedBean(name = "productController")
@SessionScoped
public class ProductController extends AbstractProductController implements IBasicController {

}
