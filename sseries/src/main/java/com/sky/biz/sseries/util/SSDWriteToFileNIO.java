package com.sky.biz.sseries.util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.sky.biz.sseries.ssd.controller.util.ControllerUtil;
import com.sky.biz.sseries.ssd.controller.util.ServiceImplUtil;
import com.sky.biz.sseries.ssd.controller.util.SpecificationUtil;

public class SSDWriteToFileNIO {
	
	private static final String MODULEPATH = "ssd";
	private static final String TARGETOBJECT = "Module";
	private static final String TARGETOBJECTINS = "module";
	private static final String WEBTARGETOBJECT = "module";
	
	
	private static final String JAVA_MODULE_NAME = "";
	
	private static final String PROJECTFILEPATH = "D:\\SKY-SOFT\\github-repository\\sseries\\sseries\\src\\sstudio\\com\\sky\\biz\\sseries";
	private static final String PACKAGE = "com.sky.biz.sseries." + MODULEPATH + "";
	
	
	
	private static final String CONTROLLERPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "controller\\Abstract" + TARGETOBJECT + "Controller.java" ;
	private static final String CONVERTERPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "converter\\" + TARGETOBJECT + "Converter.java" ;
	private static final String INTERFACESERVICEPATH = PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "services" + "\\I" + TARGETOBJECT + "Service.java" ;
	private static final String SERVICEPATH = PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "services" + "\\Abstract" + TARGETOBJECT + "Service.java" ;
	private static final String DTOPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "dto\\" +  TARGETOBJECT + "DTO.java" ;
	private static final String ENTITYPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "entity\\" +  TARGETOBJECT + "Entity.java" ;
	private static final String REPOSITORYPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "repositories" + "\\" +  TARGETOBJECT + "Repository.java" ;
	private static final String SPECIFICATIONPATH = PROJECTFILEPATH + "\\" + MODULEPATH + "\\"  +"specification\\Abstract"+  TARGETOBJECT + "Specification.java" ;
	
	private static final String CONTROLLERPATHEXTEND =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "controller\\" + TARGETOBJECT + "Controller.java" ;
	private static final String SERVICEPATHEXTEND = PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "services\\impl" + "\\" + TARGETOBJECT + "ServiceImpl.java" ;
	private static final String SPECIFICATIONPATHEXTEND = PROJECTFILEPATH + "\\" + MODULEPATH + "\\"  +"specification\\"+  TARGETOBJECT + "Specification.java" ;
	//###############################
	private static final String WEBAPPPATH = "D:\\SKY-SOFT\\github-repository\\sseries\\sseries\\src\\main\\webapp\\app\\" + MODULEPATH + "\\master-data";
	
	private static final String SCREENCENTERPATH = WEBAPPPATH + "\\" + WEBTARGETOBJECT + ".xhtml";
	private static final String SCREENLISTPATH = WEBAPPPATH + "\\" + WEBTARGETOBJECT + "-list.xhtml";
	private static final String SCREENCREATEPATH = WEBAPPPATH + "\\" + WEBTARGETOBJECT + "-create.xhtml";
	private static final String SCREENMODIFYPATH = WEBAPPPATH + "\\" + WEBTARGETOBJECT + "-edit.xhtml";
	private static final String SCREENVIEWPATH = WEBAPPPATH + "\\" + WEBTARGETOBJECT + "-view.xhtml";
		
	private static final String CONTROLLERFILEPATH = "D:\\SKY-SOFT\\github-repository\\sseries\\sseries\\src\\business-partner\\com\\sky\\biz\\sseries"
			+ "\\bpn\\specification" 
			+ "\\AbstractBusinessPartnerGroupSpecifications.java";
//	private static final String CONTROLLERFILEPATH = "D:\\SKY-SOFT\\github-repository\\sseries\\sseries\\src\\main\\webapp\\app\\bpn" 
//			+ "\\business-partner-group-list.xhtml";
	private static final String FILEPATH = "C:\\TestFiles\\UserAccountController.java";
	private static final String FILENAME = "ProductTypeConverter.java";

	public static void main(String[] args) throws IOException {

		//String str1 = "";
		//String str2 = "package com.sky.biz.sseries.bpn.specification;\n\nimport javax.persistence.criteria.CriteriaBuilder;\n\nimport java.util.Map;\n\nimport javax.persistence.criteria.*;\n\nimport org.springframework.data.jpa.domain.Specification;\nimport com.sky.biz.sseries.bpn.util.*;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.entity.*;\n\nimport java.util.*;\nimport com.sky.biz.sseries.util.SpecificationsUtil;\npublic class AbstractBusinessPartnerGroupSpecifications{\n\tpublic static Specification<BusinessPartnerGroupEntity> basicCriteria(Map<String,Object> criteriaMap){\n\t\treturn new Specification<BusinessPartnerGroupEntity>() {\n\t\t\tpublic Predicate toPredicate(Root<BusinessPartnerGroupEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){\n\t\t\t\tBusinessPartnerGroupDTO dto = null;\n\t\t\t\tif(criteriaMap != null)\n\t\t\t\t\tdto = (BusinessPartnerGroupDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);\n\t\t\t\tif(dto!=null){\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDefaultGroup())){\n\t\t\t\t\t\tp1 = cb.and(cb.equal(root.get(\"default_group\"),dto.getDefaultGroup()),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getName())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"name\"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDescription())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"description\"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t}\n\t\t\t\treturn p1;\n\t\t\t}\n\t\t};\n\t}\n}";		

		String absController = "/**\n *\n */\npackage com.sky.biz.sseries.ssd.controller;\nimport java.util.*;\nimport javax.annotation.PostConstruct;\nimport javax.faces.bean.ManagedProperty;\nimport javax.faces.event.ActionEvent;\nimport com.sky.biz.sseries.mbean.AbstractController;\nimport com.sky.biz.sseries.mbean.IBasicController;\nimport com.sky.biz.sseries.mbean.LazyDataModelUtil;\nimport com.sky.biz.sseries.ssd.dto.*;\nimport com.sky.biz.sseries.ssd.services.*;\n\nimport com.sky.biz.sseries.util.JsfUtil;\n\nimport com.sky.biz.sseries.util.SpecificationsUtil;\nimport org.primefaces.event.SelectEvent;\npublic class AbstractModuleController extends AbstractController implements IBasicController {\n\tprivate LazyDataModelUtil<ModuleDTO> lazyData;\n\t@ManagedProperty(value=\"#{moduleService}\")\n\tprivate IModuleService moduleService;\n\tprivate ModuleDTO selectedModuleDTO;\n\tprivate ModuleDTO mainModuleDTO;\n\tprivate ModuleDTO criteriaModuleDTO;\n\tprivate List<ProductDTO> productList;\n\t@ManagedProperty(value=\"#{productService}\")\n\tprivate IProductService productService;\n\n\t@SuppressWarnings(\"unchecked\")\n\t@PostConstruct\n\tpublic void init() {\n\t\tthis.createView=\"app/ssd/master-data/module-create\";\n\t\tthis.editView=\"app/ssd/master-data/module-edit\";\n\t\tthis.listView=\"app/ssd/master-data/module-list\";\n\t\tthis.readView=\"app/ssd/master-data/module-view\";\n\t\tthis.selectedModuleDTO = new ModuleDTO();\n\t\tthis.criteriaModuleDTO = new ModuleDTO();\n\t\tthis.mainModuleDTO = new ModuleDTO();\n\t\tthis.currentSubView = this.listView;\n\t\tlazyData = new LazyDataModelUtil<ModuleDTO>(moduleService);\n\t\tthis.productList = this.productService.loadActiveProduct();\n\t}\n\n\tpublic void editAction(ActionEvent actionEvent){\n\t\ttry{\n\t\t\tif(this.selectedModuleDTO == null || this.selectedModuleDTO.getId() == null){\n\t\t\t\tJsfUtil.addWarningMessage(\"Please select at least one item\");\n\t\t\t}else{\n\t\t\t\tthis.mainModuleDTO = this.selectedModuleDTO;\n\t\t\t\tthis.setCurrentSubView(this.editView);\n\t\t\t}\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void viewAction(ActionEvent actionEvent){\n\t\ttry{\n\t\t\tif(this.selectedModuleDTO == null || this.selectedModuleDTO.getId() == null){\n\t\t\t\tJsfUtil.addWarningMessage(\"Please select at least one item\");\n\t\t\t}else{\n\t\t\t\tthis.setCurrentSubView(this.readView);\n\t\t\t}\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void newAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tthis.mainModuleDTO = new ModuleDTO();\n\t\t\tthis.setCurrentSubView(this.createView);\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void saveAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tmoduleService.saveNew(this.mainModuleDTO);\n\t\t\tthis.selectedModuleDTO = this.mainModuleDTO;\n\t\t\tthis.mainModuleDTO = new ModuleDTO();\n\t\t\tthis.setCurrentSubView(this.readView);\n\t\t\tJsfUtil.addSuccessMessage(\" Module was created already!!\");\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void updateAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tmoduleService.update(this.mainModuleDTO);\n\t\t\tthis.selectedModuleDTO = this.mainModuleDTO;\n\t\t\tthis.mainModuleDTO = new ModuleDTO();\n\t\t\tthis.setCurrentSubView(this.readView);\n\t\t\tJsfUtil.addSuccessMessage(\" Module was updated already!!\");\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void deleteAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tmoduleService.delete(this.selectedModuleDTO);\n\t\t\tthis.selectedModuleDTO = this.mainModuleDTO;\n\t\t\tthis.mainModuleDTO = new ModuleDTO();\n\t\t\tthis.setCurrentSubView(this.listView);\n\t\t\tJsfUtil.addSuccessMessage(\" Module was deleted already!!\");\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void searchAction(ActionEvent actionEvent){\n\t\ttry{\n\t\t\tMap<String, Object> map = new HashMap<String, Object>();\n\t\t\tmap.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaModuleDTO);\n\t\t\tthis.lazyData.setCriteriaMap(map);\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void resetAction(ActionEvent actionEvent){\n\t\tthis.criteriaModuleDTO = new ModuleDTO();\n\t\tthis.lazyData.setCriteriaMap(null);\n\n\t}\n\n\tpublic void setDeleteAction(ModuleDTO module){\n\t\ttry{\n\t\t\tthis.selectedModuleDTO = module;\n\t\t\tif(this.selectedModuleDTO == null || this.selectedModuleDTO.getId() == null){\n\t\t\t\tJsfUtil.addWarningMessage(\"Please select at least one item\");\n\t\t\t}else{\n\t\t\t\tmoduleService.delete(this.selectedModuleDTO);\n\t\t\t\tthis.selectedModuleDTO = this.mainModuleDTO;\n\t\t\t\tthis.mainModuleDTO = new ModuleDTO();\n\t\t\t\tthis.setCurrentSubView(this.listView);\n\t\t\t\tJsfUtil.addSuccessMessage(\" Module was deleted already!!\");\n\t\t\t}\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\n\t}\n\n\tpublic void setViewAction(ModuleDTO module){\n\t\tthis.selectedModuleDTO = module;\n\t\tthis.setCurrentSubView(this.readView);\n\n\t}\n\n\tpublic void onRowSelect(SelectEvent event) {\n\t\tthis.selectedModuleDTO = (ModuleDTO) event.getObject();\n\t}\n\n\tpublic IModuleService getModuleService() {\n\t\t\treturn moduleService;\n\t}\n\n\tpublic void setModuleService(IModuleService moduleService) {\n\t\tthis.moduleService = moduleService;\n\n\t}\n\n\tpublic LazyDataModelUtil<ModuleDTO> getLazyData() {\n\t\treturn lazyData;\n\n\t}\n\n\tpublic void setLazyData(LazyDataModelUtil<ModuleDTO> lazyData) {\n\t\tthis.lazyData = lazyData;\n\n\t}\n\n\tpublic ModuleDTO getSelectedModuleDTO() {\n\t\treturn selectedModuleDTO;\n\n\t}\n\n\tpublic void setSelectedModuleDTO(ModuleDTO selectedModuleDTO) {\n\t\tthis.selectedModuleDTO = selectedModuleDTO;\n\n\t}\n\n\tpublic ModuleDTO getMainModuleDTO() {\n\t\treturn mainModuleDTO;\n\n\t}\n\n\tpublic void setMainModuleDTO(ModuleDTO mainModuleDTO) {\n\t\tthis.mainModuleDTO = mainModuleDTO;\n\n\t}\n\n\tpublic ModuleDTO getCriteriaModuleDTO() {\n\t\treturn criteriaModuleDTO;\n\n\t}\n\n\tpublic void setCriteriaModuleDTO(ModuleDTO criteriaModuleDTO) {\n\t\tthis.criteriaModuleDTO = criteriaModuleDTO;\n\n\t}\n\tpublic IProductService getProductService() {\n\t\treturn productService;\n\t}\n\tpublic void setProductService(IProductService productService) {\n\t\tthis.productService = productService;\n\t}\n\tpublic List<ProductDTO> getProductList(){\n\t\treturn this.productList;\n\t}\n\tpublic void setProductList(List<ProductDTO> productList) {\n\t\tthis.productList = productList;\n\t}\n}";
		String converter = "package com.sky.biz.sseries.ssd.converter;\n\nimport javax.faces.application.FacesMessage;\nimport javax.faces.component.UIComponent;\nimport javax.faces.context.FacesContext;\nimport javax.faces.convert.Converter;\nimport javax.faces.convert.ConverterException;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Component;\nimport com.sky.biz.sseries.ssd.dto.ModuleDTO;\nimport com.sky.biz.sseries.ssd.services.impl.ModuleServiceImpl;\n@Component(\"moduleConverter\")\npublic class ModuleConverter implements Converter {\n\t @Autowired\n\t private ModuleServiceImpl moduleServiceImpl;\n\n\t@Override\n\tpublic Object getAsObject(FacesContext fc, UIComponent uic, String value) {\n\t\tif(value != null && value.trim().length() > 0) {\n\t\t\ttry {\n\t\t\t\treturn moduleServiceImpl.loadById(Long.parseLong(value));\n\t\t\t} catch(NumberFormatException e) {\n\t\t\t\tthrow new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, \"Conversion Error\", \"Not a valid Id for Converter.\"));\n\t\t\t}\n\t\t}\n\t\telse {return null;}\n\t}\n\n\t@Override\n\tpublic String getAsString(FacesContext fc, UIComponent uic, Object object ) {\n\t\tif(object != null && object.toString().trim().length() > 0) {\n\t\t\tString val = String.valueOf(((ModuleDTO) object).getId());\n\t\t\treturn val;\n\t\t}\n\t\telse {return null;}\n\t}\n }";
		String dto = "/**\n *\n */\npackage com.sky.biz.sseries.ssd.dto;\nimport java.util.Calendar;\n\nimport com.sky.biz.sseries.dto.AbstractDTO; \n@SuppressWarnings(\"serial\")\npublic class ModuleDTO extends AbstractDTO {\n\n\t\n\tpublic String code;\n\t\n\tpublic String description;\n\t\n\tpublic Boolean isActive;\n\t\n\tpublic String name;\n\t\n\tpublic Double sortKey;\n\n\t\n\tpublic ProductDTO product;\n\n\tpublic String getCode() {\n\t\treturn this.code;\n\t}\n\tpublic void setCode(String code) { \n\t\tthis.code = code;\n\t}\n\t\n\tpublic String getDescription() {\n\t\treturn this.description;\n\t}\n\tpublic void setDescription(String description) { \n\t\tthis.description = description;\n\t}\n\t\n\tpublic Boolean getIsActive() {\n\t\treturn this.isActive;\n\t}\n\tpublic void setIsActive(Boolean isActive) { \n\t\tthis.isActive = isActive;\n\t}\n\t\n\tpublic String getName() {\n\t\treturn this.name;\n\t}\n\tpublic void setName(String name) { \n\t\tthis.name = name;\n\t}\n\t\n\tpublic Double getSortKey() {\n\t\treturn this.sortKey;\n\t}\n\tpublic void setSortKey(Double sortKey) { \n\t\tthis.sortKey = sortKey;\n\t}\n\n\tpublic ProductDTO getProduct() {\n\t\treturn this.product;\n\t}\n\tpublic void setProduct(ProductDTO product) { \n\t\tthis.product = product;\n\t}\n}";
		String entity = "/**\n *\n */\npackage com.sky.biz.sseries.ssd.entity;\n\nimport javax.persistence.Column;\nimport javax.persistence.JoinColumn;\nimport javax.persistence.ManyToOne;\nimport javax.persistence.Entity;\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.GenerationType;\nimport javax.persistence.Id;\nimport javax.persistence.Inheritance;\nimport javax.persistence.InheritanceType;\nimport javax.persistence.SequenceGenerator;\nimport javax.persistence.Table;\nimport java.util.Calendar;\nimport javax.persistence.Temporal;\nimport javax.persistence.TemporalType;\nimport com.sky.biz.sseries.entity.AbstractEntity; \n@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)\n@Table(name = \"ssd_module\")\n@SequenceGenerator(name = \"seq_ssd_module\", sequenceName = \"seq_ssd_module\")\n@Entity\npublic class ModuleEntity extends AbstractEntity {\n\t@Column(name = \"code\")\n\tprivate String code;\n\t@Column(name = \"description\")\n\tprivate String description;\n\t@Id \n\t@Column(name = \"id\") \n\t@GeneratedValue(strategy = GenerationType.SEQUENCE)\n\tprivate Long id;\n\t@Column(name = \"is_active\")\n\tprivate Boolean isActive;\n\t@Column(name = \"name\")\n\tprivate String name;\n\t@Column(name = \"sort_key\")\n\tprivate Double sortKey;\n\t@ManyToOne \n\t@JoinColumn(name=\"product_id\")\n\tprivate ProductEntity product;\n\tpublic String getCode() {\n\t\treturn this.code;\n\t}\n\tpublic void setCode(String code) { \n\t\tthis.code = code;\n\t}\n\t\n\tpublic String getDescription() {\n\t\treturn this.description;\n\t}\n\tpublic void setDescription(String description) { \n\t\tthis.description = description;\n\t}\n\t\n\tpublic Long getId() {\n\t\treturn this.id;\n\t}\n\tpublic void setId(Long id) { \n\t\tthis.id = id;\n\t}\n\t\n\tpublic Boolean getIsActive() {\n\t\treturn this.isActive;\n\t}\n\tpublic void setIsActive(Boolean isActive) { \n\t\tthis.isActive = isActive;\n\t}\n\t\n\tpublic String getName() {\n\t\treturn this.name;\n\t}\n\tpublic void setName(String name) { \n\t\tthis.name = name;\n\t}\n\t\n\tpublic Double getSortKey() {\n\t\treturn this.sortKey;\n\t}\n\tpublic void setSortKey(Double sortKey) { \n\t\tthis.sortKey = sortKey;\n\t}\n\tpublic ProductEntity getProduct() {\n\t\treturn this.product;\n\t}\n\tpublic void setProduct(ProductEntity product) { \n\t\tthis.product = product;\n\t}\n}";
		String repository = "package com.sky.biz.sseries.ssd.repositories;\n\nimport org.springframework.data.domain.Page;\nimport org.springframework.data.domain.Pageable;\nimport org.springframework.data.jpa.repository.JpaSpecificationExecutor;\nimport org.springframework.data.repository.PagingAndSortingRepository;\nimport com.sky.biz.sseries.ssd.entity.ModuleEntity;\nimport java.util.List;\n\npublic interface ModuleRepository extends PagingAndSortingRepository<ModuleEntity, Long>,JpaSpecificationExecutor<ModuleEntity>{\n\n\tpublic Page<ModuleEntity> findByCompCode(String compCode,Pageable pageRequest);\n\tpublic ModuleEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);\n\tpublic List<ModuleEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);\n}";
		String service = "package com.sky.biz.sseries.ssd.services;\nimport org.springframework.data.domain.Page;\nimport org.springframework.data.domain.Pageable;\nimport com.sky.biz.sseries.util.*;\nimport com.sky.biz.sseries.ssd.dto.*;\nimport com.sky.biz.sseries.ssd.entity.*;\nimport com.sky.biz.sseries.ssd.specification.*;\n\nimport java.util.*;\npublic class AbstractModuleService extends SsdService implements IModuleService{\n\n\t@Override\n\tpublic ModuleDTO loadById(Long id){\n\t\treturn buildModuleDTO(moduleRepository.findOne(id));\n\t}\n\t@Override\n\t@SuppressWarnings({\"rawtypes\", \"unchecked\"})\n\tpublic PageDTOUtil<ModuleDTO> loadData(int first, int pageSize, Map criteriaMap){\n\t\tList<ModuleDTO> dtoList = new ArrayList<ModuleDTO>();\n\t\tPageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);\n\t\tPage<ModuleEntity> entityPage =  moduleRepository.findAll(ModuleSpecification.basicCriteria(criteriaMap),pageRequest);\n\t\tdtoList =  AbstractModuleService.buildModuleDTO(entityPage.getContent());\n\t\tPageDTOUtil<ModuleDTO> pageDTO = new PageDTOUtil<ModuleDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);\n\t\treturn pageDTO;\n\t}\n\t@Override\n\tpublic PageDTOUtil<ModuleDTO> loadData(int first, int pageSize){\n\t\treturn this.loadData(first,pageSize,null);\n\t}\n\tpublic ModuleDTO saveNew(ModuleDTO dto) throws Exception{\n\t\tModuleEntity entity = this.buildModuleEntity(dto);\n\t\tentity.setCreatedBy(-9999L);\n\t\tentity.setCreatedDate(Calendar.getInstance());\n\t\tentity.setVersion(0);\n\t\tentity.setCompCode(\"FCNF\");\n\t\tentity =  moduleRepository.save(entity);\n\t\treturn buildModuleDTO(entity);\n\t}\n\tpublic ModuleDTO update(ModuleDTO dto) throws Exception{\n\t\tModuleEntity entity = this.buildModuleEntity(dto);\n\t\tentity.setId(dto.getId());\n\t\tentity.setUpdatedBy(-9999L);\n\t\tentity.setCompCode(\"FCNF\");\n\t\tentity.setUpdatedDate(Calendar.getInstance());\n\t\tentity =  moduleRepository.save(entity);\n\t\treturn buildModuleDTO(entity);\n\t}\n\tpublic void delete(ModuleDTO dto) throws Exception{\n\t\tModuleEntity entity = moduleRepository.findByCompCodeAndIdAndMarkDelete(\"FCNF\",dto.getId(),false);\n\t\tentity.setMarkDelete(true);\n\t\tmoduleRepository.save(entity);\n\t\tdto = buildModuleDTO(entity);\n\t}\n\tpublic List<ModuleDTO> loadActiveModule(){\n\t\tList <ModuleDTO>resultList = new ArrayList<ModuleDTO>();\n\t\tList<ModuleEntity> listEntity =  moduleRepository.findByCompCodeAndIsActiveAndMarkDelete(\"FCNF\",true,false);\n\t\tresultList = buildModuleDTO(listEntity);\n\t\treturn resultList;\n\t}\n\tpublic static ModuleDTO buildModuleDTO(ModuleEntity entity){\n\t\tif(entity == null)\n\t\t\treturn null;\n\t\tModuleDTO dto = null;\n\t\tdto = new ModuleDTO();\n\t\tdto.setCode(entity.getCode());\n\t\tdto.setDescription(entity.getDescription());\n\t\tdto.setId(entity.getId());\n\t\tdto.setIsActive(entity.getIsActive());\n\t\tdto.setName(entity.getName());\n\t\tdto.setSortKey(entity.getSortKey());\n\t\tdto.setProduct(AbstractProductService.buildProductDTO(entity.getProduct()));\n\t\tEntityDtoUtil.getAbstractDTO(entity,dto);\n\t\treturn dto;\n\t}\n\tpublic static List<ModuleDTO> buildModuleDTO(List<ModuleEntity> entities){\n\t\tList<ModuleDTO> listReturn = new ArrayList<ModuleDTO>();\n\t\tIterator<ModuleEntity> iterator = entities.iterator();\n\t\twhile(iterator.hasNext()){\n\t\t\tlistReturn.add(buildModuleDTO((ModuleEntity)iterator.next()));\n\t\t}\n\t\treturn listReturn;\n\t\t}\n\tpublic List<ModuleEntity> buildModuleEntity(List<ModuleDTO> dtoList){ \n\t\tList<ModuleEntity> listReturn = new ArrayList<ModuleEntity>();\n\t\tIterator<ModuleDTO> iterator = dtoList.iterator();\n\t\twhile(iterator.hasNext()){\n\t\t\tlistReturn.add(buildModuleEntity((ModuleDTO)iterator.next()));\n\t\t}\n\t\treturn listReturn;\n\t}\n\tpublic ModuleEntity buildModuleEntity(ModuleDTO dto) {\n\t\tModuleEntity entity = (ModuleEntity)DtoEntityUtil.initEntity(new ModuleEntity());\n\t\tentity.setCode(dto.getCode());\n\t\tentity.setDescription(dto.getDescription());\n\t\t\n\t\tentity.setIsActive(dto.getIsActive());\n\t\tentity.setName(dto.getName());\n\t\tentity.setSortKey(dto.getSortKey());\n\t\tif(dto.getProduct() != null && dto.getProduct().getId() !=null)\n\t\t entity.setProduct(productRepository.findOne(dto.getId()));\n\t\treturn entity;\n\t}\n}";
		String serviceInterface = "package com.sky.biz.sseries.ssd.services;\nimport com.sky.biz.sseries.ssd.dto.ModuleDTO;\nimport com.sky.biz.sseries.ssd.entity.ModuleEntity;\nimport com.sky.biz.sseries.services.ISSeriesServices;\n\nimport java.util.List;\n@SuppressWarnings(\"rawtypes\")\npublic interface IModuleService extends ISSeriesServices {\n\n\tpublic ModuleDTO saveNew(ModuleDTO dto) throws Exception;\n\tpublic ModuleDTO update(ModuleDTO dto) throws Exception;\n\tpublic void delete(ModuleDTO dto) throws Exception;\n\tpublic List<ModuleDTO> loadActiveModule();\n\tpublic static ModuleDTO buildModuleDTO(ModuleEntity entity) {return null;}\n\tpublic static List<ModuleDTO> buildModuleDTO(List<ModuleEntity> entities){return null;}\n\tpublic List<ModuleEntity> buildModuleEntity(List<ModuleDTO> dtoList);\n\tpublic ModuleEntity buildModuleEntity(ModuleDTO dto);\n\t}";
		String specification = "package com.sky.biz.sseries.ssd.specification;\n\nimport javax.persistence.criteria.CriteriaBuilder;\n\nimport java.util.Map;\n\nimport javax.persistence.criteria.*;\n\nimport org.springframework.data.jpa.domain.Specification;\nimport com.sky.biz.sseries.ssd.dto.*;\nimport com.sky.biz.sseries.ssd.entity.*;\nimport com.sky.biz.sseries.util.SpecificationsUtil;\npublic class AbstractModuleSpecification{\n\tpublic static Specification<ModuleEntity> basicCriteria(Map<String,Object> criteriaMap){\n\t\treturn new Specification<ModuleEntity>() {\n\t\t\tpublic Predicate toPredicate(Root<ModuleEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){\n\t\t\t\tModuleDTO dto = null;\n\t\t\t\tPredicate p1 = cb.equal(root.get(\"markDelete\"), false);\n\t\t\t\tif(criteriaMap != null)\n\t\t\t\t\tdto = (ModuleDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);\n\t\t\t\tif(dto!=null){\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getCode())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"code\"),SpecificationsUtil.getLikePattern(dto.getCode(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDescription())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"description\"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getIsActive())){\n\t\t\t\t\t\tp1 = cb.and(cb.equal(root.get(\"isActive\"),dto.getIsActive()),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getName())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"name\"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getSortKey())){\n\t\t\t\t\t\tp1 = cb.and(cb.equal(root.get(\"sortKey\"),dto.getSortKey()),p1);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn p1;\n\t\t\t}\n\t\t};\n\t}\n}";
		String webCenter = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<h:form>\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\"/>\n\t\t<p:ribbon>\n\t\t\t<p:tab title=\" Module\">\n\t\t\t\t<p:ribbonGroup label=\"New\">\n\t\t\t\t\t<p:commandButton value=\"New\" icon=\"ui-ribbonicon-new\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{moduleController.disabledNewEvent}\" actionListener=\"#{moduleController.newAction}\" />\n\t\t\t\t\t<p:commandButton value=\"Save\" icon=\"ui-ribbonicon-save\"  update=\":centerContentPanel\"  styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{moduleController.disabledSaveEvent}\" actionListener=\"#{moduleController.saveAction}\"/>\n\t\t\t\t</p:ribbonGroup>\n\t\t\t<p:ribbonGroup label = \"Find\">\n\t\t\t\t\t<p:commandButton value=\"Finding\" icon=\"ui-ribbonicon-find\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{moduleController.disabledFindEvent}\" actionListener=\"#{moduleController.findAction}\" />\n\t\t\t\t\t<p:commandButton value=\"View\" icon=\"ui-ribbonicon-find\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{moduleController.disabledFindEvent}\" actionListener=\"#{moduleController.viewAction}\" />\n\t\t\t\t</p:ribbonGroup>\n\t\t\t\t<p:ribbonGroup label=\"Editing\">\n\t\t\t\t\t<p:commandButton value=\"Modify\" icon=\"ui-ribbonicon-save\"  update=\":centerContentPanel\"  styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{moduleController.disabledEditEvent}\" actionListener=\"#{moduleController.editAction}\"/> \n\t\t\t\t</p:ribbonGroup>\n\t\t\t\t<p:ribbonGroup label=\"Export\">\n\t\t\t\t</p:ribbonGroup>\n\t\t\t</p:tab>\n\t\t\t</p:ribbon>\n\t\t\t</h:form>\n\t\t\t<br/>\n\t\t\t<ui:include src=\"/#{moduleController.currentSubView}.xhtml\" />\n</ui:composition>";
		String webCreate = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"ModuleModifyForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Module\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<p:panelGrid columns=\"3\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Code:\" for=\"code\"/>\n\t\t\t\t<p:inputText id=\"code\" value=\"#{moduleController.mainModuleDTO.code}\"/>\n\t\t\t\t<p:message for=\"code\" />\n\t\t\t\t<p:outputLabel value=\"Description:\" for=\"description\"/>\n\t\t\t\t<p:inputText id=\"description\" value=\"#{moduleController.mainModuleDTO.description}\"/>\n\t\t\t\t<p:message for=\"description\" />\n\t\t\t\t<p:outputLabel value=\"Is Active: \" for=\"isActive\"/>\n\t\t\t\t<p:selectBooleanCheckbox id=\"isActive\" value=\"#{moduleController.mainModuleDTO.isActive}\"/>\n\t\t\t\t<p:message for=\"isActive\"/>\n\t\t\t\t<p:outputLabel value=\"Name:\" for=\"name\"/>\n\t\t\t\t<p:inputText id=\"name\" value=\"#{moduleController.mainModuleDTO.name}\"/>\n\t\t\t\t<p:message for=\"name\" />\n\t\t\t\t<p:outputLabel value=\"Sort Key:\" for=\"sortKey\"/>\n\t\t\t\t<p:inputNumber id=\"sortKey\" value=\"#{moduleController.mainModuleDTO.sortKey}\"/> \n\t\t\t\t<p:message for=\"sortKey\"/>\n\t\t\t</p:panelGrid>\n\t\t\t<div align=\"center\">\n\t\t\t\t<p:commandButton value=\"Save\" id=\"ajax\" update=\":centerContentPanel\" disabled=\"#{moduleController.disabledSaveEvent}\" actionListener=\"#{moduleController.saveAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\"/>\n\t\t\t\t<p:commandButton value=\"Save-Continue\" id=\"ajax2\" update=\"growl\" disabled=\"#{moduleController.disabledSaveEvent}\" actionListener=\"#{moduleController.saveAction2}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\"/>\n\t\t\t</div>\n\t\t</p:panel>\n\t</h:form>\n\t</div>\n</ui:composition>";
		String webEdit = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"ModuleModifyForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Module\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<p:panelGrid columns=\"3\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Code:\" for=\"code\"/>\n\t\t\t\t<p:inputText id=\"code\" value=\"#{moduleController.mainModuleDTO.code}\"/>\n\t\t\t\t<p:message for=\"code\" />\n\t\t\t\t<p:outputLabel value=\"Description:\" for=\"description\"/>\n\t\t\t\t<p:inputText id=\"description\" value=\"#{moduleController.mainModuleDTO.description}\"/>\n\t\t\t\t<p:message for=\"description\" />\n\t\t\t\t<p:outputLabel value=\"Is Active: \" for=\"isActive\"/>\n\t\t\t\t<p:selectBooleanCheckbox id=\"isActive\" value=\"#{moduleController.mainModuleDTO.isActive}\"/>\n\t\t\t\t<p:message for=\"isActive\"/>\n\t\t\t\t<p:outputLabel value=\"Name:\" for=\"name\"/>\n\t\t\t\t<p:inputText id=\"name\" value=\"#{moduleController.mainModuleDTO.name}\"/>\n\t\t\t\t<p:message for=\"name\" />\n\t\t\t\t<p:outputLabel value=\"Sort Key:\" for=\"sortKey\"/>\n\t\t\t\t<p:inputNumber id=\"sortKey\" value=\"#{moduleController.mainModuleDTO.sortKey}\"/> \n\t\t\t\t<p:message for=\"sortKey\"/>\n\t\t\t</p:panelGrid>\n\t\t\t<div align=\"center\">\n\t\t\t\t<p:commandButton value=\"Update\" id=\"updateCommandButton\" update=\":centerContentPanel\" disabled=\"#{moduleController.disabledSaveEvent}\" actionListener=\"#{moduleController.updateAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\"/>\n\t\t\t</div>\n\t\t</p:panel>\n\t</h:form>\n\t</div>\n</ui:composition>";
		String webList = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"ModuleCriteriaForm\">\n\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" /> \n\t\t<p:panel header=\" Module\" toggleable=\"true\" toggleSpeed=\"500\" closeSpeed=\"500\" >\n\t\t\t<p:panelGrid columns=\"3\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Code:\" for=\"code\"/>\n\t\t\t\t<p:inputText id=\"code\" value=\"#{moduleController.criteriaModuleDTO.code}\"/>\n\t\t\t\t<p:message for=\"code\" />\n\t\t\t\t<p:outputLabel value=\"Description:\" for=\"description\"/>\n\t\t\t\t<p:inputText id=\"description\" value=\"#{moduleController.criteriaModuleDTO.description}\"/>\n\t\t\t\t<p:message for=\"description\" />\n\t\t\t\t<p:outputLabel value=\"Is Active: \" for=\"isActive\"/>\n\t\t\t\t<p:selectOneButton id=\"isActive\" value=\"#{moduleController.criteriaModuleDTO.isActive}\"> \n\t\t\t\t\t<f:selectItem itemLabel=\"ALL\" itemValue=\"#{null}\" /> \n\t\t\t\t\t<f:selectItem itemLabel=\"Yes\" itemValue=\"#{true}\" />\n\t\t\t\t\t<f:selectItem itemLabel=\"No\" itemValue=\"#{false}\" />  \n\t\t\t\t</p:selectOneButton>\n\t\t\t\t<p:message for=\"isActive\" />\n\t\t\t\t<p:outputLabel value=\"Name:\" for=\"name\"/>\n\t\t\t\t<p:inputText id=\"name\" value=\"#{moduleController.criteriaModuleDTO.name}\"/>\n\t\t\t\t<p:message for=\"name\" />\n\t\t\t\t<p:outputLabel value=\"Sort Key:\" for=\"sortKey\"/>\n\t\t\t\t<p:inputNumber id=\"sortKey\" value=\"#{moduleController.mainModuleDTO.sortKey}\"/>\n\t\t\t\t<p:message for=\"sortKey\" />\n\t\t\t</p:panelGrid>\n\t\t\t<div align=\"center\">\n\t\t\t\t<p:commandButton value=\"Search\" id=\"searchButton\" update=\":centerContentPanel\" actionListener=\"#{moduleController.searchAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\" />\n\t\t\t\t<p:commandButton value=\"Reset\" id=\"resetButton\" update=\":centerContentPanel\" actionListener=\"#{moduleController.resetAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\" />\n\t\t\t</div>\n\t\t</p:panel>\n\t</h:form>\n\t	<br/>\n\t<h:form id=\"ModuleListForm\">\n\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" /> \n\t\t<p:dataTable var=\"module\" value=\"#{moduleController.lazyData}\" \n\t\t\tpaginator=\"true\" rows=\"10\" paginatorTemplate=\"{CurrentPageReport} {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}\" \n\t\t\trowsPerPageTemplate=\"10,20,30\" selectionMode=\"single\" \n\t\t\tselection=\"#{moduleController.selectedModuleDTO}\"\n\t\t\tid=\"ModuleTable\" lazy=\"true\"\n\t\t\trowIndexVar=\"rowIndex\" widgetVar=\"dataTableWidget\">\n\t\t\t<p:ajax event=\"rowSelect\" listener=\"#{moduleController.onRowSelect}\"/>\n\t\t\t<p:column headerText=\"No\">\n\t\t\t\t#{(rowIndex + (moduleController.lazyData.pageSize ) * ( (dataTableWidget.paginator.page + 1) - 1)) + 1 }\n\t\t\t</p:column>\n\t\n\t\t\t<p:column headerText=\"Code\">\n\t\t\t\t<h:outputText value=\"#{module.code}\" />\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Description\">\n\t\t\t\t<h:outputText value=\"#{module.description}\" />\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Is Active\">\n\t\t\t\t<p:selectBooleanCheckbox value=\"#{module.isActive}\" disabled=\"true\"/>\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Name\">\n\t\t\t\t<h:outputText value=\"#{module.name}\" />\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Sort Key\">\n\t\t\t\t<h:outputText value=\"#{module.sortKey}\" />\n\t\t\t</p:column>\n\t\n\t\t\t<p:column headerText=\"product\">\n\t\t\t\t<h:outputText value=\"#{module.product.id}\" />\n\t\t\t</p:column>\n\t\t\t<p:column style=\"width:32px;text-align: center\" headerText=\"View\">\n\t\t\t\t<p:commandButton update=\":centerContentPanel\"\n\t\t\t\t\tstyleClass=\"ui-priority-primary\" icon=\"ui-icon-search\" title=\"View\">\n\t\t\t\t\t<f:setPropertyActionListener value=\"#{module}\" target=\"#{moduleController.viewAction}\" />\n\t\t\t\t</p:commandButton>\n\t\t\t</p:column>\n\t\t\t<p:column style=\"width:32px;text-align: center\" headerText=\"Delete\">\n\t\t\t\t<p:commandButton update=\":centerContentPanel\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-search\" title=\"Delete\">\n\t\t\t\t\t<p:confirm header=\"Confirmation\" message=\"Are you sure?\" icon=\"ui-icon-alert\" />\n\t\t\t\t\t<f:setPropertyActionListener value=\"#{module}\" target=\"#{moduleController.deleteAction}\" />\n\t\t\t\t</p:commandButton>\n\t\t\t</p:column>\n\t\t</p:dataTable>\n\t\t<p:confirmDialog global=\"true\" showEffect=\"fade\" hideEffect=\"fade\">\n\t\t\t<p:commandButton value=\"Yes\" type=\"button\" styleClass=\"ui-confirmdialog-yes\" icon=\"ui-icon-check\" />\n\t\t\t<p:commandButton value=\"No\" type=\"button\" styleClass=\"ui-confirmdialog-no\" icon=\"ui-icon-close\" />\n\t\t</p:confirmDialog>\n\t</h:form>\n\t</div>\n</ui:composition>";
		String webView = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"RoomStatusViewForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Room Status\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<p:panelGrid columns=\"2\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Code:\"/>\n\t\t\t\t<p:outputLabel value=\"#{roomStatusController.selectedRoomStatusDTO.code}\"/>\n\t\t\t\t<p:outputLabel value=\"Description:\"/>\n\t\t\t\t<p:outputLabel value=\"#{roomStatusController.selectedRoomStatusDTO.description}\"/>\n\t\t\t\t<p:outputLabel value=\"Is Active: \" />\n\t\t\t\t<p:selectBooleanCheckbox value=\"#{roomStatusController.selectedRoomStatusDTO.isActive}\" disabled=\"true\"/>\n\t\t\t\t<p:outputLabel value=\"Name:\"/>\n\t\t\t\t<p:outputLabel value=\"#{roomStatusController.selectedRoomStatusDTO.name}\"/>\n\t\t\t</p:panelGrid>\n\t\t</p:panel>\n\t</h:form>\n\t</div>\n</ui:composition>";
		
		bufferedWrite(absController,CONTROLLERPATH);
		bufferedWrite(converter,CONVERTERPATH);
		bufferedWrite(serviceInterface,INTERFACESERVICEPATH);
		bufferedWrite(service,SERVICEPATH);
		bufferedWrite(dto,DTOPATH);
		bufferedWrite(entity,ENTITYPATH);
		bufferedWrite(repository,REPOSITORYPATH);
		bufferedWrite(specification,SPECIFICATIONPATH);
		
		bufferedWrite(webCenter,SCREENCENTERPATH);
		bufferedWrite(webList,SCREENLISTPATH);
		bufferedWrite(webCreate,SCREENCREATEPATH);
		bufferedWrite(webEdit,SCREENMODIFYPATH);
		bufferedWrite(webView,SCREENVIEWPATH);
		
		bufferedWriteIfNotExists(SpecificationUtil.getTemplate(PACKAGE,TARGETOBJECT),SPECIFICATIONPATHEXTEND);
		bufferedWriteIfNotExists(ServiceImplUtil.getTemplate(PACKAGE,TARGETOBJECT,TARGETOBJECTINS),SERVICEPATHEXTEND);
		bufferedWriteIfNotExists(ControllerUtil.getTemplate(PACKAGE,TARGETOBJECT,TARGETOBJECTINS),CONTROLLERPATHEXTEND);
		
		
		//bufferedWrite(list, FILEPATH,FILENAME);
		//bufferedWrite(list, CONTROLLERFILEPATH,FILENAME);
	}

	/**
	 * Write a small string to a File - Use a FileWriter
	 */
	public static void simpleWrite(String content, String filePath) {
		Path fileP = Paths.get(filePath);
		try {
			if(!Files.exists(fileP.getFileName()))
				Files.createFile(fileP.getFileName());
			Files.write(fileP, content.getBytes("utf-8"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write a big list of Strings to a file - Use a BufferedWriter
	 */
	public static void bufferedWrite(List<String> content, String filePath,String fileName) {

		File file = new File(filePath);
		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
		
		Path fileP = Paths.get(filePath);
		Charset charset = Charset.forName("utf-8");
		
		try (BufferedWriter writer = Files.newBufferedWriter(fileP, charset)) {
			
			for (String line : content) {
				writer.write(line, 0, line.length());
				writer.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bufferedWrite(String content,String filePath){
		File file = new File(filePath);
		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
		
		Path fileP = Paths.get(filePath);
		Charset charset = Charset.forName("utf-8");
		
		try (BufferedWriter writer = Files.newBufferedWriter(fileP, charset)) {			
			writer.write(content,0,content.length());
			writer.newLine();			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void bufferedWriteIfNotExists(String content,String filePath){
		File file = new File(filePath);
		if(!file.exists()){
			file.getParentFile().mkdirs();
			Path fileP = Paths.get(filePath);
			Charset charset = Charset.forName("utf-8");
			
			try (BufferedWriter writer = Files.newBufferedWriter(fileP, charset)) {			
				writer.write(content,0,content.length());
				writer.newLine();			

			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Exists " + filePath);
		}
		
		
	}
	

	/**
	 * Write raw data to file - use OutputStream
	 */
	public static void writeWithOutputStream(String content, String filePath) {

		Path fileP = Paths.get(filePath);

		try (OutputStream outputStream = Files.newOutputStream(fileP)) {
			if(!Files.exists(fileP))
				Files.createFile(fileP);
			outputStream.write(content.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write raw data to file using BufferedOutputStream
	 */
	public static void writeWithBufferedOutputStream(List<String> content, String filePath) {

		Path fileP = Paths.get(filePath);

		try (BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(fileP))) {
			if(!Files.exists(fileP))
				Files.createFile(fileP);
			for (String line : content) {
				outputStream.write(line.getBytes());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write a string list to a File
	 */
	public static void simpleWriteListOfString(List<String> content, String filePath) {
		Path fileP = Paths.get(filePath);
		Charset charset = Charset.forName("utf-8");

		try {
			if(!Files.exists(fileP))
				Files.createFile(fileP);
			Files.write(fileP, content, charset);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
