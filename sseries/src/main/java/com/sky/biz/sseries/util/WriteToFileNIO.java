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

public class WriteToFileNIO {
	
	
	private static final String PROJECTFILEPATH = "D:\\SKY-SOFT\\github-repository\\sseries\\sseries\\src\\business-partner\\com\\sky\\biz\\sseries";
	private static final String TARGETOBJECT = "CorporateType";
	private static final String WEBTARGETOBJECT = "corporate-type";
	private static final String MODULEPATH = "bpn";
	
	private static final String CONTROLLERPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "controller\\Abstract" + TARGETOBJECT + "Controller.java" ;
	private static final String CONVERTERPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "converter\\" + TARGETOBJECT + "Converter.java" ;
	private static final String SERVICEPATH = PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "services" + "\\Abstract" + TARGETOBJECT + "Service.java" ;
	private static final String DTOPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "dto\\" +  TARGETOBJECT + "DTO.java" ;
	private static final String ENTITYPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "entity\\" +  TARGETOBJECT + "Entity.java" ;
	private static final String REPOSITORYPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "repositories" + "\\" +  TARGETOBJECT + "Repository.java" ;
	private static final String SPECIFICATIONPATH = PROJECTFILEPATH + "\\" + MODULEPATH + "\\"  +"specification\\Abstract"+  TARGETOBJECT + "Specification.java" ;
	
	
	//###############################
	private static final String WEBAPPPATH = "D:\\SKY-SOFT\\github-repository\\sseries\\sseries\\src\\main\\webapp\\app\\" + MODULEPATH;
	
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

		String absController = "/**\n *\n */\npackage com.sky.biz.sseries.bpn.controller;\nimport java.util.HashMap;\nimport java.util.Map;\nimport javax.annotation.PostConstruct;\nimport javax.faces.bean.ManagedProperty;\nimport javax.faces.event.ActionEvent;\nimport com.sky.biz.sseries.mbean.AbstractController;\nimport com.sky.biz.sseries.mbean.IBasicController;\nimport com.sky.biz.sseries.mbean.LazyDataModelUtil;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.services.impl.*;\n\nimport com.sky.biz.sseries.util.JsfUtil;\n\nimport com.sky.biz.sseries.util.SpecificationsUtil;\nimport org.primefaces.event.SelectEvent;\npublic class AbstractCorporateTypeController extends AbstractController implements IBasicController {\n\tprivate LazyDataModelUtil<CorporateTypeDTO> lazyData;\n\t@ManagedProperty(value=\"#{corporateTypeServiceImpl}\")\n\tprivate CorporateTypeServiceImpl corporateTypeServiceImpl;\n\tprivate CorporateTypeDTO selectedCorporateTypeDTO;\n\tprivate CorporateTypeDTO mainCorporateTypeDTO;\n\tprivate CorporateTypeDTO criteriaCorporateTypeDTO;\n\n\t@SuppressWarnings(\"unchecked\")\n\t@PostConstruct\n\tpublic void init() {\n\t\tthis.createView=\"app/bpn/corporate-type-create\";\n\t\tthis.editView=\"app/bpn/corporate-type-edit\";\n\t\tthis.listView=\"app/bpn/corporate-type-list\";\n\t\tthis.readView=\"app/bpn/corporate-type-view\";\n\t\tthis.selectedCorporateTypeDTO = new CorporateTypeDTO();\n\t\tthis.criteriaCorporateTypeDTO = new CorporateTypeDTO();\n\t\tthis.mainCorporateTypeDTO = new CorporateTypeDTO();\n\t\tthis.currentSubView = this.listView;\n\t\tlazyData = new LazyDataModelUtil<CorporateTypeDTO>(corporateTypeServiceImpl);\n\t}\n\n\tpublic void editAction(ActionEvent actionEvent){\n\t\ttry{\n\t\t\tif(this.selectedCorporateTypeDTO == null || this.selectedCorporateTypeDTO.getId() == null){\n\t\t\t\tJsfUtil.addWarningMessage(\"Please select at least one item\");\n\t\t\t}else{\n\t\t\t\tthis.mainCorporateTypeDTO = this.selectedCorporateTypeDTO;\n\t\t\t\tthis.setCurrentSubView(this.editView);\n\t\t\t}\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void newAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tthis.mainCorporateTypeDTO = new CorporateTypeDTO();\n\t\t\tthis.setCurrentSubView(this.createView);\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void saveAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tcorporateTypeServiceImpl.saveNew(this.mainCorporateTypeDTO);\n\t\t\tthis.selectedCorporateTypeDTO = this.mainCorporateTypeDTO;\n\t\t\tthis.mainCorporateTypeDTO = new CorporateTypeDTO();\n\t\t\tthis.setCurrentSubView(this.readView);\n\t\t\tJsfUtil.addSuccessMessage(\" Corporate Type was created already!!\");\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void updateAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tcorporateTypeServiceImpl.update(this.mainCorporateTypeDTO);\n\t\t\tthis.selectedCorporateTypeDTO = this.mainCorporateTypeDTO;\n\t\t\tthis.mainCorporateTypeDTO = new CorporateTypeDTO();\n\t\t\tthis.setCurrentSubView(this.readView);\n\t\t\tJsfUtil.addSuccessMessage(\" Corporate Type was updated already!!\");\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void deleteAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tcorporateTypeServiceImpl.delete(this.selectedCorporateTypeDTO);\n\t\t\tthis.selectedCorporateTypeDTO = this.mainCorporateTypeDTO;\n\t\t\tthis.mainCorporateTypeDTO = new CorporateTypeDTO();\n\t\t\tthis.setCurrentSubView(this.listView);\n\t\t\tJsfUtil.addSuccessMessage(\" Corporate Type was deleted already!!\");\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void searchAction(ActionEvent actionEvent){\n\t\ttry{\n\t\t\tMap<String, Object> map = new HashMap<String, Object>();\n\t\t\tmap.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaCorporateTypeDTO);\n\t\t\tthis.lazyData.setCriteriaMap(map);\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void resetAction(ActionEvent actionEvent){\n\t\tthis.criteriaCorporateTypeDTO = new CorporateTypeDTO();\n\t\tthis.lazyData.setCriteriaMap(null);\n\n\t}\n\n\tpublic void onRowSelect(SelectEvent event) {\n\t\tthis.selectedCorporateTypeDTO = (CorporateTypeDTO) event.getObject();\n\t}\n\n\tpublic CorporateTypeServiceImpl getCorporateTypeServiceImpl() {\n\t\t\treturn corporateTypeServiceImpl;\n\t}\n\n\tpublic void setCorporateTypeServiceImpl(CorporateTypeServiceImpl corporateTypeServiceImpl) {\n\n\t\tthis.corporateTypeServiceImpl = corporateTypeServiceImpl;\n\n\t}\n\n\tpublic LazyDataModelUtil<CorporateTypeDTO> getLazyData() {\n\n\t\treturn lazyData;\n\n\t}\n\n\tpublic void setLazyData(LazyDataModelUtil<CorporateTypeDTO> lazyData) {\n\n\t\tthis.lazyData = lazyData;\n\n\t}\n\n\tpublic CorporateTypeDTO getSelectedCorporateTypeDTO() {\n\n\t\treturn selectedCorporateTypeDTO;\n\n\t}\n\n\tpublic void setSelectedCorporateTypeDTO(CorporateTypeDTO selectedCorporateTypeDTO) {\n\n\t\tthis.selectedCorporateTypeDTO = selectedCorporateTypeDTO;\n\n\t}\n\n\tpublic CorporateTypeDTO getMainCorporateTypeDTO() {\n\n\t\treturn mainCorporateTypeDTO;\n\n\t}\n\n\tpublic void setMainCorporateTypeDTO(CorporateTypeDTO mainCorporateTypeDTO) {\n\n\t\tthis.mainCorporateTypeDTO = mainCorporateTypeDTO;\n\n\t}\n\n\tpublic CorporateTypeDTO getCriteriaCorporateTypeDTO() {\n\n\t\treturn criteriaCorporateTypeDTO;\n\n\t}\n\n\tpublic void setCriteriaCorporateTypeDTO(CorporateTypeDTO criteriaCorporateTypeDTO) {\n\n\t\tthis.criteriaCorporateTypeDTO = criteriaCorporateTypeDTO;\n\n\t}\n}";
		String converter = "package com.sky.biz.sseries.bpn.converter;\n\nimport javax.faces.application.FacesMessage;\nimport javax.faces.component.UIComponent;\nimport javax.faces.context.FacesContext;\nimport javax.faces.convert.Converter;\nimport javax.faces.convert.ConverterException;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Component;\nimport com.sky.biz.sseries.bpn.dto.CorporateTypeDTO;\nimport com.sky.biz.sseries.bpn.services.impl.CorporateTypeServiceImpl;\n@Component(\"corporateTypeConverter\")\npublic class CorporateTypeConverter implements Converter {\n\t @Autowired\n\t private CorporateTypeServiceImpl corporateTypeServiceImpl;\n\n\t@Override\n\tpublic Object getAsObject(FacesContext fc, UIComponent uic, String value) {\n\t\tif(value != null && value.trim().length() > 0) {\n\t\t\ttry {\n\t\t\t\treturn corporateTypeServiceImpl.loadById(Long.parseLong(value));\n\t\t\t} catch(NumberFormatException e) {\n\t\t\t\tthrow new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, \"Conversion Error\", \"Not a valid Id for Converter.\"));\n\t\t\t}\n\t\t}\n\t\telse {return null;}\n\t}\n\n\t@Override\n\tpublic String getAsString(FacesContext fc, UIComponent uic, Object object ) {\n\t\tif(object != null && object.toString().trim().length() > 0) {\n\t\t\tString val = String.valueOf(((CorporateTypeDTO) object).getId());\n\t\t\treturn val;\n\t\t}\n\t\telse {return null;}\n\t}\n }";
		String dto = "/**\n *\n */\npackage com.sky.biz.sseries.bpn.dto;\nimport java.util.Calendar;\n\nimport com.sky.biz.sseries.dto.AbstractDTO; \n@SuppressWarnings(\"serial\")\npublic class CorporateTypeDTO extends AbstractDTO {\n\n\t\n\tpublic Boolean isActive;\n\t\n\tpublic String name;\n\t\n\tpublic String description;\n\n\n\tpublic Boolean getIsActive() {\n\t\treturn this.isActive;\n\t}\n\tpublic void setIsActive(Boolean isActive) { \n\t\tthis.isActive = isActive;\n\t}\n\t\n\tpublic String getName() {\n\t\treturn this.name;\n\t}\n\tpublic void setName(String name) { \n\t\tthis.name = name;\n\t}\n\t\n\tpublic String getDescription() {\n\t\treturn this.description;\n\t}\n\tpublic void setDescription(String description) { \n\t\tthis.description = description;\n\t}\n\n}";
		String entity = "/**\n *\n */\npackage com.sky.biz.sseries.bpn.entity;\n\nimport javax.persistence.Column;\nimport javax.persistence.JoinColumn;\nimport javax.persistence.ManyToOne;\nimport javax.persistence.Entity;\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.GenerationType;\nimport javax.persistence.Id;\nimport javax.persistence.Inheritance;\nimport javax.persistence.InheritanceType;\nimport javax.persistence.SequenceGenerator;\nimport javax.persistence.Table;\nimport java.util.Calendar;\nimport javax.persistence.Temporal;\nimport javax.persistence.TemporalType;\nimport com.sky.biz.sseries.entity.AbstractEntity; \n@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)\n@Table(name = \"bpn_corporate_type\")\n@SequenceGenerator(name = \"seq_bpn_corporate_type\", sequenceName = \"seq_bpn_corporate_type\")\n@Entity\npublic class CorporateTypeEntity extends AbstractEntity {\n\t@Column(name = \"is_active\")\n\tprivate Boolean isActive;\n\t@Column(name = \"name\")\n\tprivate String name;\n\t@Column(name = \"description\")\n\tprivate String description;\n\t@Id \n\t@Column(name = \"id\") \n\t@GeneratedValue(strategy = GenerationType.SEQUENCE)\n\tprivate Long id;\n\tpublic Boolean getIsActive() {\n\t\treturn this.isActive;\n\t}\n\tpublic void setIsActive(Boolean isActive) { \n\t\tthis.isActive = isActive;\n\t}\n\t\n\tpublic String getName() {\n\t\treturn this.name;\n\t}\n\tpublic void setName(String name) { \n\t\tthis.name = name;\n\t}\n\t\n\tpublic String getDescription() {\n\t\treturn this.description;\n\t}\n\tpublic void setDescription(String description) { \n\t\tthis.description = description;\n\t}\n\t\n\tpublic Long getId() {\n\t\treturn this.id;\n\t}\n\tpublic void setId(Long id) { \n\t\tthis.id = id;\n\t}\n}";
		String repository = "package com.sky.biz.sseries.bpn.repositories;\n\nimport org.springframework.data.domain.Page;\nimport org.springframework.data.domain.Pageable;\nimport org.springframework.data.jpa.repository.JpaSpecificationExecutor;\nimport org.springframework.data.repository.PagingAndSortingRepository;\nimport com.sky.biz.sseries.bpn.entity.CorporateTypeEntity;\n\npublic interface CorporateTypeRepository extends PagingAndSortingRepository<CorporateTypeEntity, Long>,JpaSpecificationExecutor<CorporateTypeEntity>{\n\n\tpublic Page<CorporateTypeEntity> findByCompCode(String compCode,Pageable pageRequest);\n\tpublic CorporateTypeEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);\n}";
		String service = "package com.sky.biz.sseries.bpn.services;\nimport org.springframework.data.domain.Page;\nimport org.springframework.data.domain.Pageable;\nimport com.sky.biz.sseries.services.ISSeriesServices;\nimport com.sky.biz.sseries.util.*;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.entity.*;\nimport com.sky.biz.sseries.bpn.specification.*;\n\nimport java.util.*;\npublic class AbstractCorporateTypeService extends BpnService implements ISSeriesServices{\n\n\t@Override\n\tpublic CorporateTypeDTO loadById(Long id){\n\t\treturn buildCorporateTypeDTO(corporateTypeRepository.findOne(id));\n\n\t}\n\n\t@Override\n\tpublic PageDTOUtil<CorporateTypeDTO> loadData(int first, int pageSize, Map criteriaMap){\n\t\tList<CorporateTypeDTO> dtoList = new ArrayList<CorporateTypeDTO>();\n\t\tPageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);\n\t\tPage<CorporateTypeEntity> entityPage =  corporateTypeRepository.findAll(CorporateTypeSpecification.basicCriteria(criteriaMap),pageRequest);\n\t\tdtoList =  AbstractCorporateTypeService.buildCorporateTypeDTO(entityPage.getContent());\n\t\tPageDTOUtil<CorporateTypeDTO> pageDTO = new PageDTOUtil<CorporateTypeDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);\n\t\treturn pageDTO;\n\t}\n\n\t@Override\n\n\t@SuppressWarnings(\"unchecked\")\n\tpublic PageDTOUtil<CorporateTypeDTO> loadData(int first, int pageSize){\n\n\t\treturn this.loadData(first,pageSize,null);\n\t}\n\n\tpublic CorporateTypeDTO saveNew(CorporateTypeDTO dto) throws Exception{\n\n\t\tCorporateTypeEntity entity = this.buildCorporateTypeEntity(dto);\n\n\t\tentity.setCreatedBy(-9999L);\n\n\t\tentity.setCreatedDate(Calendar.getInstance());\n\n\t\tentity.setActive(true);\n\n\t\tentity.setVersion(0);\n\n\t\tentity.setCompCode(\"FCNF\");\n\n\t\tentity =  corporateTypeRepository.save(entity);\n\n\t\treturn buildCorporateTypeDTO(entity);\n\n\t}\n\n\tpublic CorporateTypeDTO update(CorporateTypeDTO dto) throws Exception{\n\n\t\tCorporateTypeEntity entity = this.buildCorporateTypeEntity(dto);\n\n\t\tentity.setId(dto.getId());\n\n\t\tentity.setUpdatedBy(-9999L);\n\n\t\tentity.setUpdatedDate(Calendar.getInstance());\n\n\t\tentity =  corporateTypeRepository.save(entity);\n\n\t\treturn buildCorporateTypeDTO(entity);\n\n\t}\n\n\tpublic void delete(CorporateTypeDTO dto) throws Exception{\n\n\t\tCorporateTypeEntity entity = corporateTypeRepository.findByCompCodeAndIdAndMarkDelete(\"FCNF\",dto.getId(),false);\n\n\t\tentity.setMarkDelete(true);\n\n\t\tcorporateTypeRepository.save(entity);\n\n\t\tdto = buildCorporateTypeDTO(entity);\n\n\t}\n\tpublic static CorporateTypeDTO buildCorporateTypeDTO(CorporateTypeEntity entity){\n\t\tif(entity == null)\n\t\t\treturn null;\n\t\tCorporateTypeDTO dto = null;\n\t\tdto = new CorporateTypeDTO();\n\t\tdto.setIsActive(entity.getIsActive());\n\t\tdto.setName(entity.getName());\n\t\tdto.setDescription(entity.getDescription());\n\t\tdto.setId(entity.getId());\n\t\tEntityDtoUtil.getAbstractDTO(entity,dto);\n\t\treturn dto;\n\n\t}\n\tpublic static List<CorporateTypeDTO> buildCorporateTypeDTO(List<CorporateTypeEntity> entities){\n\t\tList<CorporateTypeDTO> listReturn = new ArrayList<CorporateTypeDTO>();\n\t\tIterator<CorporateTypeEntity> iterator = entities.iterator();\n\t\twhile(iterator.hasNext()){\n\t\t\tlistReturn.add(buildCorporateTypeDTO((CorporateTypeEntity)iterator.next()));\n\t\t}\n\t\treturn listReturn;\n\t\t}\n\tpublic List<CorporateTypeEntity> buildCorporateTypeEntity(List<CorporateTypeDTO> dtoList){ \n\t\tList<CorporateTypeEntity> listReturn = new ArrayList<CorporateTypeEntity>();\n\t\tIterator<CorporateTypeDTO> iterator = dtoList.iterator();\n\t\twhile(iterator.hasNext()){\n\t\t\tlistReturn.add(buildCorporateTypeEntity((CorporateTypeDTO)iterator.next()));\n\t\t}\n\t\treturn listReturn;\n\t}\n\tpublic CorporateTypeEntity buildCorporateTypeEntity(CorporateTypeDTO dto) {\n\t\tCorporateTypeEntity entity = (CorporateTypeEntity)DtoEntityUtil.initEntity(new CorporateTypeEntity());\n\t\tentity.setIsActive(dto.getIsActive());\n\t\tentity.setName(dto.getName());\n\t\tentity.setDescription(dto.getDescription());\n\t\t\n\t\treturn entity;\n\t}\n}";
		String specification = "package com.sky.biz.sseries.bpn.specification;\n\nimport javax.persistence.criteria.CriteriaBuilder;\n\nimport java.util.Map;\n\nimport javax.persistence.criteria.*;\n\nimport org.springframework.data.jpa.domain.Specification;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.entity.*;\n\nimport java.util.*;\nimport com.sky.biz.sseries.util.SpecificationsUtil;\npublic class AbstractCorporateTypeSpecification{\n\tpublic static Specification<CorporateTypeEntity> basicCriteria(Map<String,Object> criteriaMap){\n\t\treturn new Specification<CorporateTypeEntity>() {\n\t\t\tpublic Predicate toPredicate(Root<CorporateTypeEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){\n\t\t\t\tCorporateTypeDTO dto = null;\n\t\t\t\tPredicate p1 = cb.equal(root.get(\"markDelete\"), false);\n\t\t\t\tif(criteriaMap != null)\n\t\t\t\t\tdto = (CorporateTypeDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);\n\t\t\t\tif(dto!=null){\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getIsActive())){\n\t\t\t\t\t\tp1 = cb.and(cb.equal(root.get(\"IsActive\"),dto.getIsActive()),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getName())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"Name\"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDescription())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"Description\"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t}\n\t\t\t\treturn p1;\n\t\t\t}\n\t\t};\n\t}\n}";
		String webCenter = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<h:form>\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\"/>\n\t\t<p:ribbon>\n\t\t\t<p:tab title=\" Corporate Type\">\n\t\t\t\t<p:ribbonGroup label=\"New\">\n\t\t\t\t\t<p:commandButton value=\"New\" icon=\"ui-ribbonicon-new\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{corporateTypeController.disabledNewEvent}\" actionListener=\"#{corporateTypeController.newAction}\" />\n\t\t\t\t\t<p:commandButton value=\"Save\" icon=\"ui-ribbonicon-save\"  update=\":centerContentPanel\"  styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{corporateTypeController.disabledSaveEvent}\" actionListener=\"#{corporateTypeController.saveAction}\"/>\n\t\t\t\t</p:ribbonGroup>\n\t\t\t<p:ribbonGroup label = \"Find\">\n\t\t\t\t\t<p:commandButton value=\"Finding\" icon=\"ui-ribbonicon-find\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{corporateTypeController.disabledFindEvent}\" actionListener=\"#{corporateTypeController.findAction}\" />\n\t\t\t\t\t<p:commandButton value=\"View\" icon=\"ui-ribbonicon-find\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{corporateTypeController.disabledFindEvent}\" actionListener=\"#{corporateTypeController.viewAction}\" />\n\t\t\t\t</p:ribbonGroup>\n\t\t\t\t<p:ribbonGroup label=\"Editing\">\n\t\t\t\t\t<p:commandButton value=\"Modify\" icon=\"ui-ribbonicon-save\"  update=\":centerContentPanel\"  styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{corporateTypeController.disabledEditEvent}\" actionListener=\"#{corporateTypeController.editAction}\"/> \n\t\t\t\t</p:ribbonGroup>\n\t\t\t\t<p:ribbonGroup label=\"Export\">\n\t\t\t\t</p:ribbonGroup>\n\t\t\t</p:tab>\n\t\t\t</p:ribbon>\n\t\t\t</h:form>\n\t\t\t<br/>\n\t\t\t<ui:include src=\"/#{corporateTypeController.currentSubView}.xhtml\" />\n</ui:composition>";
		String webCreate = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"CorporateTypeModifyForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Corporate Type\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<p:panelGrid columns=\"3\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Is Active: \" for=\"isActive\"/><p:selectBooleanCheckbox id=\"isActive\" value=\"#{corporateTypeController.mainCorporateTypeDTO.isActive}\"/>\n\t\t\t\t<p:message for=\"isActive\"/>\n\t\t\t\t<p:outputLabel value=\"Name:\" for=\"name\"/>\n\t\t\t\t<p:inputText id=\"name\" value=\"#{corporateTypeController.mainCorporateTypeDTO.name}\"/>\n\t\t\t\t<p:message for=\"name\" />\n\t\t\t\t<p:outputLabel value=\"Description:\" for=\"description\"/>\n\t\t\t\t<p:inputText id=\"description\" value=\"#{corporateTypeController.mainCorporateTypeDTO.description}\"/>\n\t\t\t\t<p:message for=\"description\" />\n\t\t\t</p:panelGrid>\n\t\t\t<div align=\"center\">\n\t\t\t\t<p:commandButton value=\"Save\" id=\"ajax\" update=\":centerContentPanel\" disabled=\"#{corporateTypeController.disabledSaveEvent}\" actionListener=\"#{corporateTypeController.saveAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\"/>\n\t\t\t\t<p:commandButton value=\"Save-Continue\" id=\"ajax2\" update=\"growl\" disabled=\"#{corporateTypeController.disabledSaveEvent}\" actionListener=\"#{corporateTypeController.saveAction2}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\"/>\n\t\t\t</div>\n\t\t</p:panel>\n\t</h:form>\n\t</div>\n</ui:composition>";
		String webEdit = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"CorporateTypeModifyForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Corporate Type\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<p:panelGrid columns=\"3\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Is Active: \" for=\"isActive\"/><p:selectBooleanCheckbox id=\"isActive\" value=\"#{corporateTypeController.mainCorporateTypeDTO.isActive}\"/>\n\t\t\t\t<p:message for=\"isActive\"/>\n\t\t\t\t<p:outputLabel value=\"Name:\" for=\"name\"/>\n\t\t\t\t<p:inputText id=\"name\" value=\"#{corporateTypeController.mainCorporateTypeDTO.name}\"/>\n\t\t\t\t<p:message for=\"name\" />\n\t\t\t\t<p:outputLabel value=\"Description:\" for=\"description\"/>\n\t\t\t\t<p:inputText id=\"description\" value=\"#{corporateTypeController.mainCorporateTypeDTO.description}\"/>\n\t\t\t\t<p:message for=\"description\" />\n\t\t\t</p:panelGrid>\n\t\t\t<div align=\"center\">\n\t\t\t\t<p:commandButton value=\"Update\" id=\"updateCommandButton\" update=\":centerContentPanel\" disabled=\"#{corporateTypeController.disabledSaveEvent}\" actionListener=\"#{corporateTypeController.updateAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\"/>\n\t\t\t</div>\n\t\t</p:panel>\n\t</h:form>\n\t</div>\n</ui:composition>";
		String webList = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"CorporateTypeCriteriaForm\">\n\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" /> \n\t\t<p:panel header=\" Corporate Type\" toggleable=\"true\" toggleSpeed=\"500\" closeSpeed=\"500\" >\n\t\t\t<p:panelGrid columns=\"3\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Is Active: \" for=\"isActive\"/>\n\t\t\t\t<p:selectOneButton id=\"isActive\" value=\"#{corporateTypeController.criteriaCorporateTypeDTO.isActive}\"> \n\t\t\t\t\t<f:selectItem itemLabel=\"ALL\" itemValue=\"#{null}\" /> \n\t\t\t\t\t<f:selectItem itemLabel=\"Yes\" itemValue=\"#{true}\" />\n\t\t\t\t\t<f:selectItem itemLabel=\"No\" itemValue=\"#{false}\" />  \n\t\t\t\t</p:selectOneButton>\n\t\t\t\t<p:message for=\"isActive\" />\n\t\t\t\t<p:outputLabel value=\"Name:\" for=\"name\"/>\n\t\t\t\t<p:inputText id=\"name\" value=\"#{corporateTypeController.criteriaCorporateTypeDTO.name}\"/>\n\t\t\t\t<p:message for=\"name\" />\n\t\t\t\t<p:outputLabel value=\"Description:\" for=\"description\"/>\n\t\t\t\t<p:inputText id=\"description\" value=\"#{corporateTypeController.criteriaCorporateTypeDTO.description}\"/>\n\t\t\t\t<p:message for=\"description\" />\n\t\t\t</p:panelGrid>\n\t\t\t<div align=\"center\">\n\t\t\t\t<p:commandButton value=\"Search\" id=\"searchButton\" update=\":centerContentPanel\" actionListener=\"#{corporateTypeController.searchAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\" />\n\t\t\t\t<p:commandButton value=\"Reset\" id=\"resetButton\" update=\":centerContentPanel\" actionListener=\"#{corporateTypeController.resetAction}\" styleClass=\"ui-priority-primary\" style=\"width: 20%\" icon=\"ui-icon-disk\" />\n\t\t\t</div>\n\t\t</p:panel>\n\t</h:form>\n\t	<br/>\n\t<h:form id=\"CorporateTypeListForm\">\n\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" /> \n\t\t<p:dataTable var=\"corporateType\" value=\"#{corporateTypeController.lazyData}\" paginator=\"true\" rows=\"10\" paginatorTemplate=\"{CurrentPageReport} {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}\" rowsPerPageTemplate=\"5,10,15\" selectionMode=\"single\" selection=\"#{corporateTypeController.selectedCorporateTypeDTO}\" id=\"CorporateTypeTable\" lazy=\"true\">\n\t\t\t<p:ajax event=\"rowSelect\" listener=\"#{corporateTypeController.onRowSelect}\"/>\n\t\n\t\t\t<p:column headerText=\"Is Active\">\n\t\t\t\t<p:selectBooleanCheckbox value=\"#{corporateType.isActive}\" disabled=\"true\"/>\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Name\">\n\t\t\t\t<h:outputText value=\"#{corporateType.name}\" />\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Description\">\n\t\t\t\t<h:outputText value=\"#{corporateType.description}\" />\n\t\t\t</p:column>\n\t\t\t<p:column style=\"width:32px;text-align: center\" headerText=\"View\">\n\t\t\t\t<p:commandButton update=\":centerContentPanel\" actionListener=\"#{corporateTypeController.viewAction}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-search\" title=\"View\"/>\n\t\t\t</p:column>\n\t\t\t<p:column style=\"width:32px;text-align: center\" headerText=\"Delete\">\n\t\t\t\t<p:commandButton update=\":centerContentPanel\" actionListener=\"#{corporateTypeController.deleteAction}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-search\" title=\"Delete\">\n\t\t\t\t\t<p:confirm header=\"Confirmation\" message=\"Are you sure?\" icon=\"ui-icon-alert\" />\n\t\t\t\t</p:commandButton>\n\t\t\t</p:column>\n\t\t</p:dataTable>\n\t\t<p:confirmDialog global=\"true\" showEffect=\"fade\" hideEffect=\"fade\">\n\t\t\t<p:commandButton value=\"Yes\" type=\"button\" styleClass=\"ui-confirmdialog-yes\" icon=\"ui-icon-check\" />\n\t\t\t<p:commandButton value=\"No\" type=\"button\" styleClass=\"ui-confirmdialog-no\" icon=\"ui-icon-close\" />\n\t\t</p:confirmDialog>\n\t</h:form>\n\t</div>\n</ui:composition>";
		String webView = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"CorporateTypeViewForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Corporate Type\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<p:panelGrid columns=\"2\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Is Active: \" />\n\t\t\t\t<p:selectBooleanCheckbox value=\"#{corporateTypeController.selectedCorporateTypeDTO.isActive}\" disabled=\"true\"/>\n\t\t\t\t<p:outputLabel value=\"Name:\"/>\n\t\t\t\t<p:outputLabel value=\"#{corporateTypeController.selectedCorporateTypeDTO.name}\"/>\n\t\t\t\t<p:outputLabel value=\"Description:\"/>\n\t\t\t\t<p:outputLabel value=\"#{corporateTypeController.selectedCorporateTypeDTO.description}\"/>\n\t\t\t</p:panelGrid>\n\t\t</p:panel>\n\t</h:form>\n\t</div>\n</ui:composition>";
		
		bufferedWrite(absController,CONTROLLERPATH);
		bufferedWrite(converter,CONVERTERPATH);
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
//		

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
