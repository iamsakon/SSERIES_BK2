package com.sky.biz.sseries.apm.services;
import com.sky.biz.sseries.apm.dto.MeterTypeDTO;
import com.sky.biz.sseries.apm.entity.MeterTypeEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IMeterTypeService extends ISSeriesServices {

	public MeterTypeDTO saveNew(MeterTypeDTO dto) throws Exception;
	public MeterTypeDTO update(MeterTypeDTO dto) throws Exception;
	public void delete(MeterTypeDTO dto) throws Exception;
	public List<MeterTypeDTO> loadActiveMeterType();
	public static MeterTypeDTO buildMeterTypeDTO(MeterTypeEntity entity) {return null;}
	public static List<MeterTypeDTO> buildMeterTypeDTO(List<MeterTypeEntity> entities){return null;}
	public List<MeterTypeEntity> buildMeterTypeEntity(List<MeterTypeDTO> dtoList);
	public MeterTypeEntity buildMeterTypeEntity(MeterTypeDTO dto);
	}
