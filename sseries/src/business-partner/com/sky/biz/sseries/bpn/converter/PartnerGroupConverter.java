package com.sky.biz.sseries.bpn.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sky.biz.sseries.bpn.dto.PartnerGroupDTO;
import com.sky.biz.sseries.bpn.services.impl.PartnerGroupServiceImpl;
@Component("partnerGroupConverter")
public class PartnerGroupConverter implements Converter {
	 @Autowired
	 private PartnerGroupServiceImpl partnerGroupServiceImpl;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
			try {
				return partnerGroupServiceImpl.loadById(Long.parseLong(value));
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Id for Converter."));
			}
		}
		else {return null;}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object ) {
		if(object != null && object.toString().trim().length() > 0) {
			String val = String.valueOf(((PartnerGroupDTO) object).getId());
			return val;
		}
		else {return null;}
	}
 }
