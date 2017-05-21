package com.sky.biz.sseries.apm.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import com.sky.biz.sseries.apm.dto.MeterTypeDTO;
import com.sky.biz.sseries.apm.services.IMeterTypeService;
@FacesConverter("meterTypeConverter")
public class MeterTypeConverter implements Converter {
	 @Autowired
	 private IMeterTypeService meterTypeService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
			try {
				return meterTypeService.loadById(Long.parseLong(value));
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Id for Converter."));
			}
		}
		else {return null;}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object ) {
		if(object != null && object.toString().trim().length() > 0) {
			String val = String.valueOf(((MeterTypeDTO) object).getId());
			return val;
		}
		else {return null;}
	}
 }
