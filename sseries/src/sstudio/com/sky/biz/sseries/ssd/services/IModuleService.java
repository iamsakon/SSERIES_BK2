package com.sky.biz.sseries.ssd.services;
import com.sky.biz.sseries.ssd.dto.ModuleDTO;
import com.sky.biz.sseries.ssd.entity.ModuleEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IModuleService extends ISSeriesServices {

	public ModuleDTO saveNew(ModuleDTO dto) throws Exception;
	public ModuleDTO update(ModuleDTO dto) throws Exception;
	public void delete(ModuleDTO dto) throws Exception;
	public List<ModuleDTO> loadActiveModule();
	public static ModuleDTO buildModuleDTO(ModuleEntity entity) {return null;}
	public static List<ModuleDTO> buildModuleDTO(List<ModuleEntity> entities){return null;}
	public List<ModuleEntity> buildModuleEntity(List<ModuleDTO> dtoList);
	public ModuleEntity buildModuleEntity(ModuleDTO dto);
	}
