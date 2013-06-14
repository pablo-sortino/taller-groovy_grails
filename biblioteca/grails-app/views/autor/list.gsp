
<%@ page import="biblioteca.Autor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'autor.label', default: 'Autor')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-autor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-autor" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'autor.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="nacionalidad" title="${message(code: 'autor.nacionalidad.label', default: 'Nacionalidad')}" />
					
						<g:sortableColumn property="cantLibros" title="Cantidad de libros" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${autorInstanceList}" status="i" var="autorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${autorInstance.id}">${fieldValue(bean: autorInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: autorInstance, field: "nacionalidad")}</td>
						
						<td>${autorInstance.libros.size()}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${autorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
