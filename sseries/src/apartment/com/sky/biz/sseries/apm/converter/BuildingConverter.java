package com.sky.biz.sseries.apm.converter;

import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
//import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.convert.ConverterException;
import com.sky.biz.sseries.apm.dto.BuildingDTO;
import com.sky.biz.sseries.apm.services.IBuildingService;
@Component
public class BuildingConverter implements Converter {
	//@ManagedProperty(value="#{buildingService}")
	@Autowired
	private IBuildingService buildingService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
			try {
				Long x = Long.parseLong(value);
				return buildingService.loadById(x);
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Id for Converter."));
			}
		}
		else {return null;}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object ) {		
		if (object == null || "".equals(object.toString())) {
	        return ""; // Required by HTML spec.
	    }		
		if (!(object instanceof BuildingDTO)) {
	        throw new ConverterException("Value is not a valid instance of BuildingDTO.");
	    }		
		Long id = ((BuildingDTO) object).getId();		
		return (id != null) ? id.toString() : "";
		
//		if(object != null && object.toString().trim().length() > 0) {
//			String val = String.valueOf(((BuildingDTO) object).getId());
//			return val;
//		}
//		else {return null;}
	}

	public IBuildingService getBuildingService() {
		return buildingService;
	}

	public void setBuildingService(IBuildingService buildingService) {
		this.buildingService = buildingService;
	}
 }
