<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<display:table name="contests" id="row" requestURI="${requestURI}" pagesize="5" class="displaytag">
	<jstl:if test="${requestURI=='contest/organiser/list.do'}">
		<security:authorize access="hasRole('ORGANISER')">
			<display:column title="actions">
				<a href="contest/organiser/edit.do?contestId=${row.id}"><spring:message code="contest.edit"/></a>
				<br/>
			<display:column title="submitted">
				<a href="essay/organiser/listAll.do?contestId=${row.id}"><spring:message code="contest.submitted"/></a>
				<br/>
			</display:column>
			
			</display:column>
		</security:authorize>
	</jstl:if>
	<security:authorize access="hasRole('AUTHOR')">
		<display:column title="actions">
			<a href="essay/author/create.do?contestId=${row.id}"><spring:message code="contest.createEssay"/></a>
			<br/>
			<a href="essay/author/listMyEssays.do?contestId=${row.id}"><spring:message code="contest.myEssays"/></a>
			<br/>
		</display:column>
	</security:authorize>
	
	<display:column title="published">
		<a href="essay/listPublished.do?contestId=${row.id}"><spring:message code="contest.published"/></a>
		<br/>
	</display:column>
	
	<spring:message code="name" var="name"></spring:message>
	<display:column property="name" title="${name}" sortable="false"></display:column>
	
	<spring:message code="description" var="description"></spring:message>
	<display:column property="description" title="${description}" sortable="false"></display:column>
	
	<spring:message code="holdingDate" var="holdingDate"></spring:message>
	<display:column property="holdingDate" title="${holdingDate}" sortable="false"></display:column>
		
	<spring:message code="deadline" var="deadline"></spring:message>
	<display:column property="deadline" title="${deadline}" sortable="false"></display:column>	
	
	<spring:message code="result" var="result"></spring:message>
	<display:column property="result" title="${result}" sortable="false"></display:column>
</display:table>

<security:authorize access="hasRole('ORGANISER')">
		<input type="button" name="create" value="<spring:message code="contest.create"/>" 
		onclick="javascript: window.location.replace('contest/organiser/create.do')"/>
		<br />
</security:authorize>	