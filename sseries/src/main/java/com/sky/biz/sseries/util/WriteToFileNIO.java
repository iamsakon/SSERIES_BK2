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
	private static final String TARGETOBJECT = "BusinessPartnerGroup";
	private static final String MODULEPATH = "bpn";
	
	private static final String CONTROLLERPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "controller\\Abstract" + TARGETOBJECT + "Controller.java" ;
	private static final String CONVERTERPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "converter\\" + TARGETOBJECT + "Converter.java" ;
	private static final String SERVICEPATH = PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "services" + "\\Abstract" + TARGETOBJECT + "Service.java" ;
	private static final String DTOPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "dto\\" +  TARGETOBJECT + "DTO.java" ;
	private static final String ENTITYPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "entity\\" +  TARGETOBJECT + "Entity.java" ;
	private static final String REPOSITORYPATH =  PROJECTFILEPATH + "\\" + MODULEPATH + "\\" + "repositories" +  TARGETOBJECT + "Repositories.java" ;
	private static final String SPECIFICATIONPATH = PROJECTFILEPATH + "\\" + MODULEPATH + "\\"  +"specification\\Abstract"+  TARGETOBJECT + "Repositories.java" ;
	
	
	//###############################
	private static final String WEBAPPPATH = "D:\\SKY-SOFT\\github-repository\\sseries\\sseries\\src\\main\\webapp\\app\\" + MODULEPATH;
	private static final String WEBTARGETOBJECT = "business-partner-group";
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

		String str1 = "";
		String str2 = "package com.sky.biz.sseries.bpn.specification;\n\nimport javax.persistence.criteria.CriteriaBuilder;\n\nimport java.util.Map;\n\nimport javax.persistence.criteria.*;\n\nimport org.springframework.data.jpa.domain.Specification;\nimport com.sky.biz.sseries.bpn.util.*;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.entity.*;\n\nimport java.util.*;\nimport com.sky.biz.sseries.util.SpecificationsUtil;\npublic class AbstractBusinessPartnerGroupSpecifications{\n\tpublic static Specification<BusinessPartnerGroupEntity> basicCriteria(Map<String,Object> criteriaMap){\n\t\treturn new Specification<BusinessPartnerGroupEntity>() {\n\t\t\tpublic Predicate toPredicate(Root<BusinessPartnerGroupEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){\n\t\t\t\tBusinessPartnerGroupDTO dto = null;\n\t\t\t\tif(criteriaMap != null)\n\t\t\t\t\tdto = (BusinessPartnerGroupDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);\n\t\t\t\tif(dto!=null){\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDefaultGroup())){\n\t\t\t\t\t\tp1 = cb.and(cb.equal(root.get(\"default_group\"),dto.getDefaultGroup()),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getName())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"name\"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDescription())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"description\"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t}\n\t\t\t\treturn p1;\n\t\t\t}\n\t\t};\n\t}\n}";		

		String absController = "/**\n *\n */\npackage com.sky.biz.sseries.bpn.framework.controller;\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.util.HashMap;\nimport java.util.Map;\nimport javax.annotation.PostConstruct;\nimport javax.faces.bean.ManagedProperty;\nimport javax.faces.event.ActionEvent;\nimport com.sky.biz.sseries.mbean.AbstractController;\nimport com.sky.biz.sseries.mbean.IBasicController;\nimport com.sky.biz.sseries.mbean.LazyDataModelUtil;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.services.impl.*;\n\nimport com.sky.biz.sseries.util.JsfUtil;\n\nimport com.sky.biz.sseries.util.SpecificationsUtil;\nimport org.primefaces.event.SelectEvent;\npublic class AbstractBusinessPartnerGroupController extends AbstractController implements IBasicController {\n\tprivate LazyDataModelUtil<BusinessPartnerGroupDTO> lazyData;\n\t@ManagedProperty(value=\"#{businessPartnerGroupServiceImpl}\")\n\tprivate BusinessPartnerGroupServiceImpl businessPartnerGroupServiceImpl;\n\tprivate BusinessPartnerGroupDTO selectedBusinessPartnerGroupDTO;\n\tprivate BusinessPartnerGroupDTO mainBusinessPartnerGroupDTO;\n\tprivate BusinessPartnerGroupDTO criteriaBusinessPartnerGroupDTO;\n\n\t@SuppressWarnings(\"unchecked\")\n\t@PostConstruct\n\tpublic void init() {\n\t\tthis.createView=\"app/bpn/business-partner-group-create\";\n\t\tthis.editView=\"app/bpn/business-partner-group-edit\";\n\t\tthis.listView=\"app/bpn/business-partner-group-list\";\n\t\tthis.readView=\"app/bpn/business-partner-group-view\";\n\t\tthis.selectedBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();\n\t\tthis.criteriaBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();\n\t\tthis.mainBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();\n\t\tlazyData = new LazyDataModelUtil<BusinessPartnerGroupDTO>(businessPartnerGroupServiceImpl);\n\t}\n\n\tpublic void editAction(ActionEvent actionEvent){\n\t\ttry{\n\t\t\tif(this.selectedBusinessPartnerGroupDTO == null || this.selectedBusinessPartnerGroupDTO.getId() == null){\n\t\t\t\tJsfUtil.addWarningMessage(\"Please select at least one item\");\n\t\t\t}else{\n\t\t\t\tthis.mainBusinessPartnerGroupDTO = this.selectedBusinessPartnerGroupDTO;\n\t\t\t\tthis.setCurrentSubView(this.editView);\n\t\t\t}\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void saveAction(ActionEvent actionEvent) {\n\t\ttry{\n\t\t\tbusinessPartnerGroupServiceImpl.save(this.mainBusinessPartnerGroupDTO);\n\t\t\tthis.selectedBusinessPartnerGroupDTO = this.mainBusinessPartnerGroupDTO;\n\t\t\tthis.mainBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();\n\t\t\tthis.setCurrentSubView(this.readView);\n\t\t\tJsfUtil.addSuccessMessage(\"businessPartnerGroup was created already!!\");\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void searchAction(ActionEvent actionEvent){\n\t\ttry{\n\t\t\tMap<String, Object> map = new HashMap<String, Object>();\n\t\t\tmap.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaBusinessPartnerGroupDTO);\n\t\t\tthis.lazyData.setCriteriaMap(map);\n\t\t}catch(Exception ex){\n\t\t\tJsfUtil.addErrorMessage(ex, \"SSeries Error Please Contact admin\");\n\t\t\tex.printStackTrace();\n\t\t}\n\t}\n\n\tpublic void resetAction(ActionEvent actionEvent){\n\t\tthis.criteriaBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();\n\t\tthis.lazyData.setCriteriaMap(null);\n\n\t}\n\n\tpublic void onRowSelect(SelectEvent event) {\n\t\tthis.selectedBusinessPartnerGroupDTO = (BusinessPartnerGroupDTO) event.getObject();\n\t}\n\n\tpublic BusinessPartnerGroupServiceImpl getBusinessPartnerGroupServiceImpl() {\n\t\t\treturn businessPartnerGroupServiceImpl;\n\t}\n\n\tpublic void setBusinessPartnerGroupServiceImpl(BusinessPartnerGroupServiceImpl businessPartnerGroupServiceImpl) {\n\n\t\tthis.businessPartnerGroupServiceImpl = businessPartnerGroupServiceImpl;\n\n\t}\n\n\tpublic LazyDataModelUtil<BusinessPartnerGroupDTO> getLazyData() {\n\n\t\treturn lazyData;\n\n\t}\n\n\tpublic void setLazyData(LazyDataModelUtil<BusinessPartnerGroupDTO> lazyData) {\n\n\t\tthis.lazyData = lazyData;\n\n\t}\n\n\tpublic BusinessPartnerGroupDTO getSelectedBusinessPartnerGroupDTO() {\n\n\t\treturn selectedBusinessPartnerGroupDTO;\n\n\t}\n\n\tpublic void setSelectedBusinessPartnerGroupDTO(BusinessPartnerGroupDTO selectedBusinessPartnerGroupDTO) {\n\n\t\tthis.selectedBusinessPartnerGroupDTO = selectedBusinessPartnerGroupDTO;\n\n\t}\n\n\tpublic BusinessPartnerGroupDTO getMainBusinessPartnerGroupDTO() {\n\n\t\treturn mainBusinessPartnerGroupDTO;\n\n\t}\n\n\tpublic void setMainBusinessPartnerGroupDTO(BusinessPartnerGroupDTO mainBusinessPartnerGroupDTO) {\n\n\t\tthis.mainBusinessPartnerGroupDTO = mainBusinessPartnerGroupDTO;\n\n\t}\n\n\tpublic BusinessPartnerGroupDTO getCriteriaBusinessPartnerGroupDTO() {\n\n\t\treturn criteriaBusinessPartnerGroupDTO;\n\n\t}\n\n\tpublic void setCriteriaBusinessPartnerGroupDTO(BusinessPartnerGroupDTO criteriaBusinessPartnerGroupDTO) {\n\n\t\tthis.criteriaBusinessPartnerGroupDTO = criteriaBusinessPartnerGroupDTO;\n\n\t}\n}";
		String converter = "package com.sky.biz.sseries.bpn.converter;\n\nimport javax.faces.application.FacesMessage;\nimport javax.faces.component.UIComponent;\nimport javax.faces.context.FacesContext;\nimport javax.faces.convert.Converter;\nimport javax.faces.convert.ConverterException;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Component;\nimport com.sky.biz.sseries.bpn.dto.BusinessPartnerGroupDTO;\nimport com.sky.biz.sseries.bpn.services.impl.BusinessPartnerGroupServiceImpl;\n@Component(\"businessPartnerGroupConverter\")\npublic class BusinessPartnerGroupConverter implements Converter {\n\t @Autowired\n\t private BusinessPartnerGroupServiceImpl businessPartnerGroupServiceImpl;\n\n\t@Override\n\tpublic Object getAsObject(FacesContext fc, UIComponent uic, String value) {\n\t\tif(value != null && value.trim().length() > 0) {\n\t\t\ttry {\n\t\t\t\treturn businessPartnerGroupServiceImpl.loadById(Long.parseLong(value));\n\t\t\t} catch(NumberFormatException e) {\n\t\t\t\tthrow new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, \"Conversion Error\", \"Not a valid Id for Converter.\"));\n\t\t\t}\n\t\t}\n\t\telse {return null;}\n\t}\n\n\t@Override\n\tpublic String getAsString(FacesContext fc, UIComponent uic, Object object ) {\n\t\tif(object != null && object.toString().trim().length() > 0) {\n\t\t\tString val = String.valueOf(((BusinessPartnerGroupDTO) object).getId());\n\t\t\treturn val;\n\t\t}\n\t\telse {return null;}\n\t}\n }";
		String service = "package com.sky.biz.sseries.bpn.services;\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.data.domain.Page;\nimport org.springframework.data.domain.Pageable;\nimport org.springframework.stereotype.Service;\nimport com.sky.biz.sseries.util.*;\nimport com.sky.biz.sseries.services.ISSeriesServices;\nimport com.sky.biz.sseries.bpn.util.*;\nimport com.sky.biz.sseries.bpn.repositories.*;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.entity.*;\nimport com.sky.biz.sseries.bpn.services.*;\n\nimport java.util.*;\npublic class AbstractBusinessPartnerGroupService extends BpnService implements ISSeriesServices{\n\n\t@Override\n\n\tpublic BusinessPartnerGroupDTO loadById(Long id){\n\t\treturn buildBusinessPartnerGroupDTO(businessPartnerGroupRepository.findOne(id));\n\n\t}\n\n\t@Override\n\n\tpublic PageDTOUtil<BusinessPartnerGroupDTO> loadData(int first, int pageSize, Map criteriaMap){\n\t\tList<BusinessPartnerGroupDTO> dtoList = new ArrayList<BusinessPartnerGroupDTO>();\n\t\tPageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);\n\t\tPage<BusinessPartnerGroupEntity> entityPage =  businessPartnerGroupRepository.findAll(BusinessPartnerGroupSpecification.basicCriteria(criteriaMap),pageRequest);\n\t\tdtoList =  AbstractBusinessPartnerGroupService.buildBusinessPartnerGroupDTO(entityPage.getContent());\n\t\tPageDTOUtil<BusinessPartnerGroupDTO> pageDTO = new PageDTOUtil<BusinessPartnerGroupDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);\n\t\treturn pageDTO;\n\t}\n\n\t@Override\n\n\t@SuppressWarnings(\"unchecked\")\n\n\tpublic PageDTOUtil<BusinessPartnerGroupDTO> loadData(int first, int pageSize){\n\n\t\treturn this.loadData(first,pageSize,null);\n\t}\n\n\tpublic void save(BusinessPartnerGroupDTO dto) throws Exception{\n\n\t\tBusinessPartnerGroupEntity entity = this.buildBusinessPartnerGroupEntity(dto);\n\n\t\tbusinessPartnerGroupRepository.save(entity);\n\n\t}\n\tpublic static BusinessPartnerGroupDTO buildBusinessPartnerGroupDTO(BusinessPartnerGroupEntity entity){\n\t\tif(entity == null)\n\t\t\treturn null;\n\t\tBusinessPartnerGroupDTO dto = null;\n\t\tdto = new BusinessPartnerGroupDTO();\n\t\tdto.setId(entity.getId());\n\t\tdto.setName(entity.getName());\n\t\tdto.setDescription(entity.getDescription());\n\t\tdto.setDefaultGroup(entity.getDefaultGroup());\n\t\tEntityDtoUtil.getAbstractDTO(entity,dto);\n\t\treturn dto;\n\n\t}\n\tpublic static List<BusinessPartnerGroupDTO> buildBusinessPartnerGroupDTO(List<BusinessPartnerGroupEntity> entities){\n\t\tList<BusinessPartnerGroupDTO> listReturn = new ArrayList<BusinessPartnerGroupDTO>();\n\t\tIterator<BusinessPartnerGroupEntity> iterator = entities.iterator();\n\t\twhile(iterator.hasNext()){\n\t\t\tlistReturn.add(buildBusinessPartnerGroupDTO((BusinessPartnerGroupEntity)iterator.next()));\n\t\t}\n\t\treturn listReturn;\n\t\t}\n\tpublic List<BusinessPartnerGroupEntity> buildBusinessPartnerGroupEntity(List<BusinessPartnerGroupDTO> dtoList){ \n\t\tList<BusinessPartnerGroupEntity> listReturn = new ArrayList<BusinessPartnerGroupEntity>();\n\t\tIterator<BusinessPartnerGroupDTO> iterator = dtoList.iterator();\n\t\twhile(iterator.hasNext()){\n\t\t\tlistReturn.add(buildBusinessPartnerGroupEntity((BusinessPartnerGroupDTO)iterator.next()));\n\t\t}\n\t\treturn listReturn;\n\t}\n\tpublic BusinessPartnerGroupEntity buildBusinessPartnerGroupEntity(BusinessPartnerGroupDTO dto) {\n\t\tBusinessPartnerGroupEntity entity = (BusinessPartnerGroupEntity)DtoEntityUtil.initEntity(new BusinessPartnerGroupEntity());\n\t\t\n\t\tentity.setName(dto.getName());\n\t\tentity.setDescription(dto.getDescription());\n\t\tentity.setDefaultGroup(dto.getDefaultGroup());\n\t\treturn entity;\n\t}\n}";
		String dto ="/**\n *\n */\npackage com.sky.biz.sseries.bpn.dto;\nimport java.util.Calendar;\n\nimport com.sky.biz.sseries.dto.AbstractDTO; \npublic class BusinessPartnerGroupDTO extends AbstractDTO {\n\tprivate Long id;\n\t\n\tpublic String name;\n\t\n\tpublic Boolean defaultGroup;\n\t\n\tpublic String description;\n\tpublic String getName() {\n\t\treturn this.name;\n\t}\n\tpublic void setName(String name) { \n\t\tthis.name = name;\n\t}\n\t\n\tpublic Boolean getDefaultGroup() {\n\t\treturn this.defaultGroup;\n\t}\n\tpublic void setDefaultGroup(Boolean defaultGroup) { \n\t\tthis.defaultGroup = defaultGroup;\n\t}\n\t\n\tpublic String getDescription() {\n\t\treturn this.description;\n\t}\n\tpublic void setDescription(String description) { \n\t\tthis.description = description;\n\t}\n}";
		String entity="/**\n *\n */\npackage com.sky.biz.sseries.bpn.entity;\n\nimport javax.persistence.Column;\nimport javax.persistence.JoinColumn;\nimport javax.persistence.ManyToOne;\nimport javax.persistence.Entity;\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.GenerationType;\nimport javax.persistence.Id;\nimport javax.persistence.Inheritance;\nimport javax.persistence.InheritanceType;\nimport javax.persistence.SequenceGenerator;\nimport javax.persistence.Table;\nimport java.util.Calendar;\nimport javax.persistence.Temporal;\nimport javax.persistence.TemporalType;\nimport com.sky.biz.sseries.entity.AbstractEntity; \n@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)\n@Table(name = \"bpn_business_partner_group\")\n@SequenceGenerator(name = \"seq_bpn_business_partner_group\", sequenceName = \"seq_bpn_business_partner_group\")\n@Entity\npublic class BusinessPartnerGroupEntity extends AbstractEntity {\n\t@Id \n\t@Column(name = \"id\") \n\t@GeneratedValue(strategy = GenerationType.SEQUENCE)\n\tprivate Long id;\n\t@Column(name = \"default_group\")\n\tprivate Boolean defaultGroup;\n\t@Column(name = \"description\")\n\tprivate String description;\n\t@Column(name = \"name\")\n\tprivate String name;\n\tpublic Long getId() {\n\t\treturn this.id;\n\t}\n\tpublic void setId(Long id) { \n\t\tthis.id = id;\n\t}\n\t\n\tpublic Boolean getDefaultGroup() {\n\t\treturn this.defaultGroup;\n\t}\n\tpublic void setDefaultGroup(Boolean defaultGroup) { \n\t\tthis.defaultGroup = defaultGroup;\n\t}\n\t\n\tpublic String getDescription() {\n\t\treturn this.description;\n\t}\n\tpublic void setDescription(String description) { \n\t\tthis.description = description;\n\t}\n\t\n\tpublic String getName() {\n\t\treturn this.name;\n\t}\n\tpublic void setName(String name) { \n\t\tthis.name = name;\n\t}\n}";
		String repository = "package com.sky.biz.sseries.bpn.repositories;\n\nimport org.springframework.data.domain.Page;\nimport org.springframework.data.domain.Pageable;\nimport org.springframework.data.jpa.repository.JpaSpecificationExecutor;\nimport org.springframework.data.repository.PagingAndSortingRepository;\nimport com.sky.biz.sseries.bpn.entity.BusinessPartnerGroupEntity;\n\npublic interface BusinessPartnerGroupRepository extends PagingAndSortingRepository<BusinessPartnerGroupEntity, Long>,JpaSpecificationExecutor<BusinessPartnerGroupEntity>{\n\n\tpublic Page<BusinessPartnerGroupEntity> findByCompCode(String compCode,Pageable pageRequest);\n}";
		String specification = "package com.sky.biz.sseries.bpn.specification;\n\nimport javax.persistence.criteria.CriteriaBuilder;\n\nimport java.util.Map;\n\nimport javax.persistence.criteria.*;\n\nimport org.springframework.data.jpa.domain.Specification;\nimport com.sky.biz.sseries.bpn.util.*;\nimport com.sky.biz.sseries.bpn.dto.*;\nimport com.sky.biz.sseries.bpn.entity.*;\n\nimport java.util.*;\nimport com.sky.biz.sseries.util.SpecificationsUtil;\npublic class AbstractBusinessPartnerGroupSpecifications{\n\tpublic static Specification<BusinessPartnerGroupEntity> basicCriteria(Map<String,Object> criteriaMap){\n\t\treturn new Specification<BusinessPartnerGroupEntity>() {\n\t\t\tpublic Predicate toPredicate(Root<BusinessPartnerGroupEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){\n\t\t\t\tBusinessPartnerGroupDTO dto = null;\n\t\t\t\tPredicate p1 = null;\n\t\t\t\tif(criteriaMap != null)\n\t\t\t\t\tdto = (BusinessPartnerGroupDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);\n\t\t\t\tif(dto!=null){\n\t\t\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getName())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"name\"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDescription())){\n\t\t\t\t\t\tp1 = cb.and(cb.like(root.get(\"description\"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);\n\t\t\t\t\t}\n\t\t\n\t\t\t\t\tif(SpecificationsUtil.isNotEmpty(dto.getDefaultGroup())){\n\t\t\t\t\t\tp1 = cb.and(cb.equal(root.get(\"default_group\"),dto.getDefaultGroup()),p1);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn p1;\n\t\t\t}\n\t\t};\n\t}\n}";
		
		String webCenter = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<h:form>\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\"/>\n\t\t<p:ribbon>\n\t\t\t<p:tab title=\" Business Partner Group\">\n\t\t\t<p:ribbonGroup label=\"New\">\n\t\t\t<p:commandButton value=\"New\" icon=\"ui-ribbonicon-new\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{businessPartnerGroupController.disabledNewEvent}\" actionListener=\"#{businessPartnerGroupController.newAction}\" />\n\t\t\t<p:commandButton value=\"Save\" icon=\"ui-ribbonicon-save\"  update=\":centerContentPanel\"  styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{businessPartnerGroupController.disabledSaveEvent}\" actionListener=\"#{businessPartnerGroupController.saveAction}\"/>\n\t\t\t</p:ribbonGroup>\n\t\t\t<p:ribbonGroup label = \"Find\">\n\t\t\t<p:commandButton value=\"Finding\" icon=\"ui-ribbonicon-find\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{businessPartnerGroupController.disabledFindEvent}\" actionListener=\"#{businessPartnerGroupController.findAction}\" />\n\t\t\t<p:commandButton value=\"Finding\" icon=\"ui-ribbonicon-find\" update=\":centerContentPanel\" styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{businessPartnerGroupController.disabledFindEvent}\" actionListener=\"#{businessPartnerGroupController.viewAction}\" />\n\t\t\t</p:ribbonGroup>\n\t\t\t<p:ribbonGroup label=\"Editing\">\n\t\t\t<p:commandButton value=\"Modify\" icon=\"ui-ribbonicon-save\"  update=\":centerContentPanel\"  styleClass=\"ui-ribbon-bigbutton\" disabled=\"#{businessPartnerGroupController.disabledEditEvent}\" actionListener=\"#{businessPartnerGroupController.editAction}\"/> \n\t\t\t</p:ribbonGroup>\n\t\t\t<p:ribbonGroup label=\"Export\">\n\t\t\t</p:ribbonGroup>\n\t\t\t</p:tab>\n\t\t\t</p:ribbon>\n\t\t\t</h:form>\n\t\t\t<br/>\n\t\t\t<ui:include src=\"/#{businessPartnerGroupController.currentSubView}.xhtml\" />\n</ui:composition>";
		String webList = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<h:form id=\"BusinessPartnerGroupCriteriaForm\">\n\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" /> \n\t\t<p:panel header=\" Business Partner Group\" toggleable=\"true\" closable=\"true\" toggleSpeed=\"500\" closeSpeed=\"500\" >\n\t\t\t<h:panelGrid columns=\"2\" columnClasses=\"label, value\">\n\t\n\t\t\t\t<p:outputLabel value=\"Name:\"/>\n\t\t\t\t<p:inputText value=\"#{businessPartnerGroupController.criteriaBusinessPartnerGroupDTO.name}\"/>\n\t\t\t\t<p:outputLabel value=\"Description:\"/>\n\t\t\t\t<p:inputText value=\"#{businessPartnerGroupController.criteriaBusinessPartnerGroupDTO.description}\"/>\n\t\t\t\t<p:outputLabel value=\"Default Group: \" />\n\t\t\t\t<p:selectOneRadio value=\"#{businessPartnerGroupController.criteriaBusinessPartnerGroupDTO.defaultGroup}\"> \n\t\t\t\t\t<f:selectItem itemLabel=\"ALL\" itemValue=\"\" /> \n\t\t\t\t\t<f:selectItem itemLabel=\"Yes\" itemValue=\"#{true}\" />\n\t\t\t\t\t<f:selectItem itemLabel=\"No\" itemValue=\"#{false}\" />  \n\t\t\t\t</p:selectOneRadio>\n\t\t\t</h:panelGrid>\n\t\t\t<div align=\"center\">\n\t\t\t\t<p:commandButton value=\"Search\" id=\"searchButton\" update=\":centerContentPanel\" actionListener=\"#{businessPartnerGroupController.searchAction}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-disk\" />\n\t\t\t\t<p:commandButton value=\"Reset\" id=\"resetButton\" update=\":centerContentPanel\" actionListener=\"#{businessPartnerGroupController.resetAction}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-disk\" />\n\t\t\t</div>\n\t\t</p:panel>\n\t</h:form>\n\t	<br/>\n\t<h:form id=\"BusinessPartnerGroupListForm\">\n\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" /> \n\t\t<p:dataTable var=\"businessPartnerGroup\" value=\"#{businessPartnerGroupController.lazyData}\" paginator=\"true\" rows=\"10\" paginatorTemplate=\"{CurrentPageReport} {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}\" rowsPerPageTemplate=\"5,10,15\" selectionMode=\"single\" selection=\"#{businessPartnerGroupController.selectedBusinessPartnerGroupDTO}\" id=\"BusinessPartnerGroupTable\" lazy=\"true\">\n\t\t\t<p:ajax event=\"rowSelect\" listener=\"#{businessPartnerGroupController.onRowSelect}\"/>\n\t\n\t\t\t<p:column headerText=\"Name\">\n\t\t\t\t<h:outputText value=\"#{businessPartnerGroup.name}\" />\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Description\">\n\t\t\t\t<h:outputText value=\"#{businessPartnerGroup.description}\" />\n\t\t\t</p:column>\n\t\t\t<p:column headerText=\"Default Group\">\n\t\t\t\t<p:selectBooleanCheckbox value=\"#{businessPartnerGroup.defaultGroup}\" />\n\t\t\t</p:column>\n\t\t\t<p:column style=\"width:32px;text-align: center\">\n\t\t\t\t<p:commandButton update=\":centerContentPanel\" actionListener=\"#{businessPartnerGroupController.viewAction}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-search\" title=\"View\">\n\t\t\t\t\t</p:commandButton>\n\t\t\t</p:column>\n\t\t</p:dataTable>\n\t</h:form>\n</ui:composition>";
		String webCreate = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<h:form id=\"BusinessPartnerGroupModifyForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Business Partner Group\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<h:panelGrid columns=\"2\" columnClasses=\"label, value\">\n\t\n\t\t\t\t<p:outputLabel value=\"Name:\"/>\n\t\t\t\t<p:inputText value=\"#{businessPartnerGroupController.mainBusinessPartnerGroupDTO.name}\"/>\n\t\t\t\t<p:outputLabel value=\"Description:\"/>\n\t\t\t\t<p:inputText value=\"#{businessPartnerGroupController.mainBusinessPartnerGroupDTO.description}\"/>\n\t\t\t\t<p:outputLabel value=\"Default Group: \" /><p:selectBooleanCheckbox value=\"#{businessPartnerGroupController.mainBusinessPartnerGroupDTO.defaultGroup}\" />\n\t\t\t\t<p:commandButton value=\"Save\" id=\"ajax\" update=\":centerContentPanel\" disabled=\"#{businessPartnerGroupController.disabledSaveEvent}\" actionListener=\"#{businessPartnerGroupController.saveAction}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-disk\"/>\n\t\t\t\t<p:commandButton value=\"Save-Continue\" id=\"ajax2\" update=\"growl\" disabled=\"#{businessPartnerGroupController.disabledSaveEvent}\" actionListener=\"#{businessPartnerGroupController.saveAction2}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-disk\"/>\n\t\t\t</h:panelGrid>\n\t\t</p:panel>\n\t</h:form>\n</ui:composition>";
		String webEdit = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<div class=\"ui-fluid\">\n\t<h:form id=\"BusinessPartnerGroupModifyForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Business Partner Group\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<p:panelGrid columns=\"3\" columnClasses=\"ui-grid-col-3,ui-grid-col-10\" layout=\"grid\" styleClass=\"ui-panelgrid-blank\">\n\t\n\t\t\t\t<p:outputLabel value=\"Name:\" for=\"name\"/>\n\t\t\t\t<p:inputText id=\"name\" value=\"#{businessPartnerGroupController.mainBusinessPartnerGroupDTO.name}\"/>\n\t\t\t\t<p:message for=\"name\" />\n\t\t\t\t<p:outputLabel value=\"Description:\" for=\"description\"/>\n\t\t\t\t<p:inputText id=\"description\" value=\"#{businessPartnerGroupController.mainBusinessPartnerGroupDTO.description}\"/>\n\t\t\t\t<p:message for=\"description\" />\n\t\t\t\t<p:outputLabel value=\"Default Group: \" for=\"defaultGroup\"/><p:selectBooleanCheckbox id=\"defaultGroup\" value=\"#{businessPartnerGroupController.mainBusinessPartnerGroupDTO.defaultGroup}\"/>\n\t\t\t\t<p:message for=\"defaultGroup\"/>\n\t\t\t\t<p:commandButton value=\"Save\" id=\"ajax\" update=\":centerContentPanel\" disabled=\"#{businessPartnerGroupController.disabledSaveEvent}\" actionListener=\"#{businessPartnerGroupController.updateAction}\" styleClass=\"ui-priority-primary\" icon=\"ui-icon-disk\"/>\n\t\t\t</p:panelGrid>\n\t\t</p:panel>\n\t</h:form>\n\t</div>\n</ui:composition>";
		String webView = "<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"\n xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n xmlns:h=\"http://java.sun.com/jsf/html\"\n xmlns:f=\"http://java.sun.com/jsf/core\"\n xmlns:p=\"http://primefaces.org/ui\">\n\t<h:form id=\"BusinessPartnerGroupViewForm\">\n\t\t<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" />\n\t\t<p:panel header=\" Business Partner Group\">\n\t\t\t<p:growl id=\"growl\" life=\"10000\" />\n\t\t\t<h:panelGrid columns=\"2\" columnClasses=\"label, value\">\n\t\n\t\t\t\t<p:outputLabel value=\"Name:\"/>\n\t\t\t\t<p:outputLabel value=\"#{businessPartnerGroupController.selectedBusinessPartnerGroupDTO.name}\"/>\n\t\t\t\t<p:outputLabel value=\"Description:\"/>\n\t\t\t\t<p:outputLabel value=\"#{businessPartnerGroupController.selectedBusinessPartnerGroupDTO.description}\"/>\n\t\t\t\t<p:outputLabel value=\"Default Group: \" />\n\t\t\t\t<p:selectBooleanCheckbox value=\"#{businessPartnerGroupController.mainBusinessPartnerGroupDTO.defaultGroup}\" />\n\t\t\t</h:panelGrid>\n\t\t</p:panel>\n\t</h:form>\n</ui:composition>";

//		bufferedWrite(absController,CONTROLLERPATH);
//		bufferedWrite(converter,CONVERTERPATH);
//		bufferedWrite(service,SERVICEPATH);
//		bufferedWrite(dto,DTOPATH);
//		bufferedWrite(entity,ENTITYPATH);
//		bufferedWrite(repository,REPOSITORYPATH);
//		bufferedWrite(specification,SPECIFICATIONPATH);
//		
//		bufferedWrite(webCenter,SCREENCENTERPATH);
//		bufferedWrite(webList,SCREENLISTPATH);
//		bufferedWrite(webCreate,SCREENCREATEPATH);
		bufferedWrite(webEdit,SCREENMODIFYPATH);
//		bufferedWrite(webView,SCREENVIEWPATH);
		

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
