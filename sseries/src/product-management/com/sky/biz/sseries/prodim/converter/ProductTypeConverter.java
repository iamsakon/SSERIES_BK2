package com.sky.biz.sseries.prodim.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sky.biz.sseries.prodim.dto.ProductTypeDTO;
import com.sky.biz.sseries.prodim.services.impl.ProductTypeService;
@Component("productTypeConverter")
public class ProductTypeConverter implements Converter {

	@Autowired
	private ProductTypeService productTypeService;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
            	//ISSeriesServices service = (ISSeriesServices)fc.getExternalContext().getApplicationMap().get("productTypeService");
            	return productTypeService.loadById(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object ) {
		if(object != null && object.toString().trim().length() > 0) {
			String val = String.valueOf(((ProductTypeDTO) object).getId());
            return val;
        }
        else {
            return null;
        }
	}

}
