package com.sky.biz.sseries.ssd.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sky.biz.sseries.ssd.dto.ProductDTO;
import com.sky.biz.sseries.ssd.services.impl.ProductServiceImpl;
@Component("productConverter")
public class ProductConverter implements Converter {
	 @Autowired
	 private ProductServiceImpl productServiceImpl;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
			try {
				return productServiceImpl.loadById(Long.parseLong(value));
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Id for Converter."));
			}
		}
		else {return null;}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object ) {
		if(object != null && object.toString().trim().length() > 0) {
			String val = String.valueOf(((ProductDTO) object).getId());
			return val;
		}
		else {return null;}
	}
 }
