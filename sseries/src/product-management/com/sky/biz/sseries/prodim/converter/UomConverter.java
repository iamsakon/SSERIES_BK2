package com.sky.biz.sseries.prodim.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import  com.sky.biz.sseries.prodim.dto.UomDTO;
import com.sky.biz.sseries.prodim.services.impl.UomService;
@Component("uomConverter")
public class UomConverter implements Converter {

	@Autowired
	private UomService uomService;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {            	
            	return uomService.loadById(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null && object.toString().trim().length() > 0) {
            return String.valueOf(((UomDTO) object).getId());
        }
        else {
            return null;
        }
	}

}
