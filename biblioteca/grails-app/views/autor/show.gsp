
<%@ page import="biblioteca.Autor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'autor.label', default: 'Autor')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-autor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-autor" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list autor">
			
				<g:if test="${autorInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="autor.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${autorInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${autorInstance?.nacionalidad}">
				<li class="fieldcontain">
					<span id="nacionalidad-label" class="property-label"><g:message code="autor.nacionalidad.label" default="Nacionalidad" /></span>
					
						<span class="property-value" aria-labelledby="nacionalidad-label"><g:fieldValue bean="${autorInstance}" field="nacionalidad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${autorInstance?.libros}">
				<li class="fieldcontain">
					<span id="libros-label" class="property-label"><g:message code="autor.libros.label" default="Libros" /></span>
					
						<g:each in="${autorInstance.libros}" var="l">
						<span class="property-value" aria-labelledby="libros-label"><g:link controller="libro" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${autorInstance?.id}" />
					<g:link class="edit" action="edit" id="${autorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
