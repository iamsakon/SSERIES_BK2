package com.sky.biz.sseries.ssd.services;
import com.sky.biz.sseries.ssd.dto.ProductDTO;
import com.sky.biz.sseries.ssd.entity.ProductEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IProductService extends ISSeriesServices {

	public ProductDTO saveNew(ProductDTO dto) throws Exception;
	public ProductDTO update(ProductDTO dto) throws Exception;
	public void delete(ProductDTO dto) throws Exception;
	public List<ProductDTO> loadActiveProduct();
	public static ProductDTO buildProductDTO(ProductEntity entity) {return null;}
	public static List<ProductDTO> buildProductDTO(List<ProductEntity> entities){return null;}
	public List<ProductEntity> buildProductEntity(List<ProductDTO> dtoList);
	public ProductEntity buildProductEntity(ProductDTO dto);
	}
