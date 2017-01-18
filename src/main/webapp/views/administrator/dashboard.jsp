<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- DASHBOARD LEVEL A -->
<fieldset>
	<legend align="left">
		<spring:message code="dashboard.fieldset1"></spring:message>
	</legend>
	<display:table name="contestDesc" id="row" requestURI="${requestURI}" pagesize="5" class="displaytag">
		<spring:message code="contest.name" var="name"/>
		<display:column property="name" title="${name}" sortable="false" />
		
		<spring:message code="contest.description" var="description"/>
		<display:column property="description" title="${description}" sortable="false" />
		
		<spring:message code="contest.holdingDate" var="holdingDate"/>
		<display:column property="holdingDate" title="${holdingDate}" sortable="false" />
		
		<spring:message code="contest.deadLine" var="deadline"/>
		<display:column property="deadline" title="${deadline}" sortable="false" />
		
		<spring:message code="contest.result" var="result"/>
		<display:column property="result" title="${result}" sortable="false" />
	</display:table>
</fieldset>

<fieldset>
	<legend align="left">
		<spring:message code="dashboard.fieldset2"></spring:message>
	</legend>
	<display:table name="authorsMoreEssSubmit" id="row" requestURI="${requestURI}" pagesize="5" class="displaytag">
		<spring:message code="author.name" var="name"/>
		<display:column property="name" title="${name}" sortable="false" />
		
		<spring:message code="author.surname" var="surname"/>
		<display:column property="surname" title="${surname}" sortable="false" />
		
		<spring:message code="author.emailAddress" var="emailAddress"/>
		<display:column property="emailAddress" title="${emailAddress}" sortable="false" />
		
		<spring:message code="author.contactPhone" var="contactPhone"/>
		<display:column property="contactPhone" title="${contactPhone}" sortable="false" />
		
		<spring:message code="author.url" var="url"/>
		<display:column property="url" title="${url}" sortable="false" />
		
		<spring:message code="author.birthDate" var="birthDate"/>
		<display:column property="birthDate" title="${birthDate}" sortable="false" />
		
		<spring:message code="author.nationality" var="nationality"/>
		<display:column property="nationality" title="${nationality}" sortable="false" />
	</display:table>
</fieldset>

<fieldset>
	<legend align="left">
		<spring:message code="dashboard.fieldset3"></spring:message>
	</legend>
	<display:table name="authorsMoreEssPublished" id="row" requestURI="${requestURI}" pagesize="5" class="displaytag">
		<spring:message code="author.name" var="name"/>
		<display:column property="name" title="${name}" sortable="false" />
		
		<spring:message code="author.surname" var="surname"/>
		<display:column property="surname" title="${surname}" sortable="false" />
		
		<spring:message code="author.emailAddress" var="emailAddress"/>
		<display:column property="emailAddress" title="${emailAddress}" sortable="false" />
		
		<spring:message code="author.contactPhone" var="contactPhone"/>
		<display:column property="contactPhone" title="${contactPhone}" sortable="false" />
		
		<spring:message code="author.url" var="url"/>
		<display:column property="url" title="${url}" sortable="false" />
		
		<spring:message code="author.birthDate" var="birthDate"/>
		<display:column property="birthDate" title="${birthDate}" sortable="false" />
		
		<spring:message code="author.nationality" var="nationality"/>
		<display:column property="nationality" title="${nationality}" sortable="false" />
	</display:table>
</fieldset>


<fieldset>
	<legend align="left">
		<spring:message code="dashboard.fieldset4"></spring:message>
	</legend>
	<display:table name="authorsLessEssPublished" id="row" requestURI="${requestURI}" pagesize="5" class="displaytag">
		<spring:message code="author.name" var="name"/>
		<display:column property="name" title="${name}" sortable="false" />
		
		<spring:message code="author.surname" var="surname"/>
		<display:column property="surname" title="${surname}" sortable="false" />
		
		<spring:message code="author.emailAddress" var="emailAddress"/>
		<display:column property="emailAddress" title="${emailAddress}" sortable="false" />
		
		<spring:message code="author.contactPhone" var="contactPhone"/>
		<display:column property="contactPhone" title="${contactPhone}" sortable="false" />
		
		<spring:message code="author.url" var="url"/>
		<display:column property="url" title="${url}" sortable="false" />
		
		<spring:message code="author.birthDate" var="birthDate"/>
		<display:column property="birthDate" title="${birthDate}" sortable="false" />
		
		<spring:message code="author.nationality" var="nationality"/>
		<display:column property="nationality" title="${nationality}" sortable="false" />
	</display:table>
</fieldset>

<fieldset>
	<legend align="left">
		<spring:message code="dashboard.fieldset5"></spring:message>
	</legend>
	<table class="displaytag">
		<thead>
		<tr>
			<th><spring:message code="author.name"/></th>
			<th><spring:message code="avgNumberEssaysSubmitted"></spring:message></th>
		</tr>
		</thead>
		
		<tbody>
		<jstl:forEach items="${avgNumberEssaysSubmitted}" var="avg">
			<tr>
				<jstl:forEach items="${avg}" var="aux">
					<td><jstl:out value="${aux}"/></td>
				</jstl:forEach>
			</tr>
		</jstl:forEach>
		</tbody>
	</table>
</fieldset>

<fieldset>
	<legend align="left">
		<spring:message code="dashboard.fieldset6"></spring:message>
	</legend>
	<table class="displaytag">
		<thead>
		<tr>
			<th><spring:message code="author.name"/></th>
			<th><spring:message code="avgContestOrganisedByOrganiser"></spring:message></th>
		</tr>
		</thead>
		
		<tbody>
		<jstl:forEach items="${avgContestOrganisedByOrganiser}" var="avg">
			<tr>
				<jstl:forEach items="${avg}" var="aux">
					<td><jstl:out value="${aux}"/></td>
				</jstl:forEach>
			</tr>
		</jstl:forEach>
		</tbody>
	</table>
</fieldset>

<fieldset>
	<legend align="left">
		<spring:message code="dashboard.fieldset7"></spring:message>
	</legend>
	<display:table name="contestsHeldLastMonth" id="row" requestURI="${requestURI}" pagesize="5" class="displaytag">
		<spring:message code="contest.name" var="name"/>
		<display:column property="name" title="${name}" sortable="false" />
		
		<spring:message code="contest.description" var="description"/>
		<display:column property="description" title="${description}" sortable="false" />
		
		<spring:message code="contest.holdingDate" var="holdingDate"/>
		<display:column property="holdingDate" title="${holdingDate}" sortable="false" />
		
		<spring:message code="contest.deadLine" var="deadline"/>
		<display:column property="deadline" title="${deadline}" sortable="false" />
		
		<spring:message code="contest.result" var="result"/>
		<display:column property="result" title="${result}" sortable="false" />
	</display:table>
</fieldset>